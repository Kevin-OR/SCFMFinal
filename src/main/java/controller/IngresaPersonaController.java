/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import model.personal.TablaPersonal;
import model.personal.personal;
import model.personal.personalGestion;

/**
 *
 * @author KevinOcampo
 */
@Named(value = "IngresaPersonaController")
@RequestScoped
public class IngresaPersonaController extends personal implements Serializable {

    public String edita(int idM) {
        personal personal
                = personalGestion.getPersona(idM);
        if (personal != null) {
            this.setIdPersona(personal.getIdPersona());
            this.setNombrePerso(personal.getNombrePerso());
            this.setPriApellidoPerso(personal.getPriApellidoPerso());
            this.setSegApellidoPerso(personal.getSegApellidoPerso());
            this.setTelefono(personal.getTelefono());
            this.setCorreoPerso(personal.getCorreoPerso());
            this.setSalario(personal.getSalario());
            this.setIdTipocedula(personal.getIdTipocedula());
            this.setNomUsuario(personal.getNomUsuario());
            this.setClave(personal.getClave());
            this.setIdRol(personal.getIdRol());

            return "EditarPerso.xhtml";
        } else {
            return "InvenPersonal.xhtml";
        }
    }

    public String modifica() {
        personalGestion.modificar(this);
        return "InvenPersonal.xhtml";
    }

    public String per(int id) {
        personalGestion.per(id);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Se cambio el acceso correctamente"));
        return "IngresaPersonaController";
    }

    public String de(int id) {
        personalGestion.de(id);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Se cambio el acceso correctamente"));
        return "IngresaPersonaController";
    }

    public String elimina(int id) {
        if (personalGestion.eliminar(id)) {
            return "InvenPersonal.xhtml";
        } else {

            return "InvenPersonal.xhtml";
        }
    }

//    public String guardarInformacion() {
//        personalGestion per = new personalGestion();
//        per.insertarPEr(this);
//        return "IngresaPersonaController";
//    }
    public String guardarInformacion(String co, String cla) {
        personalGestion per = new personalGestion();

        final String username = "prueba2.ultima@gmail.com";
        final String password = "4321prue02";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.socketFactory.port", "465");
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        String[] symbols = {"0", "1", "-", "*", "%", "$", "a", "b", "c"};
        int length = 8;
        Random random;

        try {

            random = SecureRandom.getInstanceStrong();
            StringBuilder sb = new StringBuilder(length);
            for (int i = 0; i < length; i++) {
                int indexRandom = random.nextInt(symbols.length);
                sb.append(symbols[indexRandom]);
            }
            String clas = sb.toString();
            
            
            
            if(per.insertarPEr(this, clas)){
            
            
            
            
            
            Message message = new MimeMessage(session);

            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(co)
            );
            message.setSubject("Contraseña Actual");
            message.setText("Puede cambiar su contraseña en el apartado de Cambiar contraseña: "
                    + clas);

            Transport.send(message);

            this.setIdPersona(0);
            this.setNombrePerso("");
            this.setPriApellidoPerso("");
            this.setSegApellidoPerso("");
            this.setTelefono(0);
            this.setCorreoPerso("");
            this.setSalario(0);
            this.setIdTipocedula(0);
            this.setNomUsuario("");
            this.setClave("");
            this.setIdRol(0);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "El Empleado se guardo correctamente"));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Su Nueva contraseña la puede ver en su correo"));
            
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "La Cédula ya fue ingresada anteriormente"));
            }
            
        } catch (MessagingException e) {
            e.printStackTrace();
            
        } catch (NoSuchAlgorithmException ex) {
            System.out.println(ex.toString());
        }

        return "IngresaPersonaController";
    }

    public List<TablaPersonal> getTablaPersona() {
        return personalGestion.getTablaPersona();
    }

    public List<personal> getEncargadoCa() {
        return personalGestion.getEncargados();
    }

    public List<personal> getACCPersona() {
        return personalGestion.getACCPersona();
    }
}
