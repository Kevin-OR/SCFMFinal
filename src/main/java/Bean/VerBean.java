/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import dao.DiseñoFinalDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import model.Conexion;
import model.DiseñoFinal;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author Asus
 */
@ManagedBean
@SessionScoped
public class VerBean extends DiseñoFinal {

    private StreamedContent file;
    private int codigo;

    public StreamedContent getFile() {
        return file;
    }

    public void setFile(StreamedContent file) {
        this.file = file;
    }

    public void ver() {
        ResultSet rs;
        DiseñoFinal diseñoFinal = new DiseñoFinal();

        try {
            byte[] bytes = null;

            PreparedStatement st = Conexion.getConexion().prepareStatement("SELECT Archivo FROM disefinal WHERE IdDiseFinal = (?)");
            st.setInt(1, diseñoFinal.getIdOrdenSer());

            rs = st.executeQuery();
            while (rs.next()) {
                bytes = rs.getBytes("Archivo");
            }
            FacesMessage mensaje = new FacesMessage("Exito");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);

            HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
            response.getOutputStream().write(bytes);
            response.getOutputStream().close();

            FacesContext.getCurrentInstance().responseComplete();
        } catch (Exception e) {
            FacesMessage mensaje = new FacesMessage("Error");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }
    }

    public String edita(int IdDiseFinal) {
        DiseñoFinal diseñoFinal
                = DiseñoFinalDao.getDisenoFin(IdDiseFinal);
        if (diseñoFinal != null) {
            this.setIdOrdenSer(diseñoFinal.getIdOrdenSer());
            this.setNombreArc(diseñoFinal.getNombreArc());
            return "EditarDiseñoFinal.xhtml";
        } else {
            return "DiseñosFinales.xhtml";
        }
    }

    public String actualizarDiseF() {
        DiseñoFinalDao.actualizarDiseF(this);
        return "VerBean";
    }

    public List<DiseñoFinal> getDisenosFin() {
        return DiseñoFinalDao.getDisenosFin();
    }

}
