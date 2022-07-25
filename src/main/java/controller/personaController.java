/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import model.Conexion;
import model.personal.personLog;
import model.personal.personal;

/**
 *
 * @author KevinOcampo
 */
@Named(value = "personaController")
@SessionScoped
public class personaController extends personal implements Serializable {

    @Inject
    private personLog personLog;

    public personaController() {
    }

    public String valida() {
        try {
            String con = "SELECT NomUsuario, clave, Nombre, PriApellido, SegApellido, IdRol FROM personal WHERE NomUsuario=?";
            
            
            PreparedStatement sentencias = Conexion.getConexion().prepareStatement(con);
            sentencias.setString(1, personLog.getNomUsuario());
            ResultSet rs = sentencias.executeQuery();
            if (rs != null && rs.next() && rs.getString(2).equals(personLog.getClave())) {
                
                
                try {

                    String consulta =  "SELECT Nombre FROM personal WHERE NomUsuario=? AND Estado='Permitido'";
                    
                    
                    PreparedStatement sentencia = Conexion.getConexion().prepareStatement(consulta);
                    sentencia.setString(1, personLog.getNomUsuario());
                    ResultSet r = sentencia.executeQuery();
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("USU", rs);
                    if (r != null && r.next()) {
                        personLog.setNomUsuario(rs.getString(1));
                        personLog.setNombrePerso(rs.getString(3));
                        personLog.setPriApellido(rs.getString(4));
                        personLog.setSegApellido(rs.getString(5));
                        personLog.setIdRol(rs.getInt(6));
                        return "inicio.xhtml";
                    } else {
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Alerta", "Acceso Denegado"));
                        personLog.setNomUsuario("");
                        personLog.setClave("");
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(personaController.class.getName()).log(Level.SEVERE, null, ex);

                }
                return "index.xhtml";
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Alerta", "Nombre de usuario o contraseña invalidos."));
                personLog.setNomUsuario("");
                personLog.setClave("");
                return "index.xhtml";
            }
        } catch (SQLException ex) {
            Logger.getLogger(personaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "index.xhtml";
    }

    public void cerrar() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Alerta", "Su sesión se cerró correctamente"));
    }
}
