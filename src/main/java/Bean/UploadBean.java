/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import java.sql.PreparedStatement;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.Conexion;
import org.primefaces.model.file.UploadedFile;

/**
 *
 * @author Asus
 */
@ManagedBean
@SessionScoped
public class UploadBean {

    private UploadedFile file;
    private int IdOrdenServ;

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public int getIdOrdenServ() {
        return IdOrdenServ;
    }

    public void setIdOrdenServ(int IdOrdenServ) {
        this.IdOrdenServ = IdOrdenServ;
    }

    public void upload() {
        try {
            if (file != null) {
                PreparedStatement st = Conexion.getConexion().prepareStatement("INSERT INTO disefinal (IdOrdenSer, NombreArc, Archivo) VALUES (?,?,?)");
                st.setInt(1, IdOrdenServ);
                st.setString(2, file.getFileName());
                st.setBinaryStream(3, file.getInputStream());
                st.executeUpdate();

                FacesMessage mensaje = new FacesMessage("Exito", file.getFileName() + "fue subido");
                FacesContext.getCurrentInstance().addMessage(null, mensaje);
            }
        } catch (Exception e) {
            FacesMessage mensaje = new FacesMessage("Error");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);

        }
    }

}
