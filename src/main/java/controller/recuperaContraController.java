/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.Serializable;
import java.util.Objects;
import java.util.Properties;
import javax.enterprise.context.SessionScoped;
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
import model.personal.ContraDatos;
import model.personal.RecuperaContraGesti;

/**
 *
 * @author KevinOcampo
 */
@Named(value = "recuperaContraController")
@SessionScoped
public class recuperaContraController extends ContraDatos implements Serializable {

    public String recupeCLave(String idM) {
        ContraDatos ContraDatos
                = RecuperaContraGesti.getContraDatos(idM);
        if (ContraDatos != null) {
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

            try {

                Message message = new MimeMessage(session);

                message.setRecipients(
                        Message.RecipientType.TO,
                        InternetAddress.parse(ContraDatos.getCorreo())
                );
                message.setSubject("Recuperacion de Contraseña");
                message.setText("Su Contraseña de recuperacion es: "
                        + ContraDatos.getClave());

                Transport.send(message);

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se envió un correo con su contraseña"));

            } catch (MessagingException e) {
                e.printStackTrace();
            }

            return "Contraseña.xhtml";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "El correo no es valido"));

            return "Contraseña.xhtml";
        }
    }

    public String vaciarEspacios() {
        this.setCorreo("");
        return "recuperaContraController";
    }

    public String modificaContra(String usu, String clave, String NueClave, String CoNueclave) {
        
        ContraDatos ContraDatos
                = RecuperaContraGesti.getContra(usu);

        
        String Contra=ContraDatos.getClave();

        
        if (ContraDatos != null) {

            if (clave.equals(Contra) ) {

                if (NueClave.equals(CoNueclave)) {
                    RecuperaContraGesti.modificarContra(usu, NueClave);
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "La contraseña se actualizó correctamente"));
                    return "inicio.xhtml";
                } else {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "La contraseñas nuevas no son iguales"));

                    return "CambioContra.xhtml";
                }

            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "La contraseña Actual no es valida"));

                return "CambioContra.xhtml";
            }

        } else {
            return "CambioContra.xhtml";
        }

    }

}
