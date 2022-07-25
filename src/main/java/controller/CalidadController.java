/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CalidadDao;
import java.io.IOException;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import model.Calidad;

/**
 *
 * @author emily
 */
@Named(value = "calidadController")
@SessionScoped
public class CalidadController extends Calidad implements Serializable {
    
    public String vaciarEspacios(int IdSoliServ, int IdOt) throws IOException {
        Calidad calidad
                = CalidadDao.getDatosSoli(IdSoliServ);
        if (calidad != null) {
        this.setIdSoliServ(IdSoliServ);
        this.setProyecto(calidad.getProyecto());
        this.setNotasMue(calidad.getNotasMue());
        this.setNotasDise(calidad.getNotasDise());
        this.setDisenoCli(calidad.getDisenoCli());
        this.setNotasMedi(calidad.getNotasMedi());
        this.setNotasElem(calidad.getNotasElem());
        this.setIdOt(IdOt);
        this.setEncarCli(0);
        this.setEncarEm(0);
        this.setJustifiCli("");
        this.setJustifiEm("");
        FacesContext.getCurrentInstance().getExternalContext().redirect("/SCFM/faces/calidad/ConfirCalidClien.xhtml");
        
    }
        return "ConfirCalidClien.xhtml";
    }
    
    public String vaciarEspacios2(int IdSoliServ, int IdOt) throws IOException {
        this.setIdSoliServ(IdSoliServ);
        this.setIdOt(IdOt);
        this.setEncarCli(0);
        this.setEncarEm(0);
        this.setJustifiCli("");
        this.setJustifiEm("");
        FacesContext.getCurrentInstance().getExternalContext().redirect("/SCFM/faces/calidad/ConfirCalidEmpre.xhtml");
        return "ConfirCalidEmpre.xhtml";
    }
    
    public String CrearCali(int CaliEnvi){
        try {
            CalidadDao.CrearCali(CaliEnvi, this);
            switch (CaliEnvi){
                case 1:
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se ha aceptado la calidad del cliente"));
                    break;
                case 2:
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Se ha rechazado la calidad del cliente"));
                    break;
                case 3:
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se ha aceptado la calidad de la empresa"));
                    break;
                case 4:
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Se ha rechazado la calidad de la empresa"));
                    break;
            }                    
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "Se ha produccido un error."));
        }
        return "RevisarCalidad.xhtml";
    }
    
    public String editaCali(int idM) throws IOException {
        Calidad calidad
                = CalidadDao.getCalidad(idM);
        if (calidad != null) {
            this.setIdCalidadCli(calidad.getIdCalidadCli());
            this.setIdCalidadEm(calidad.getIdCalidadEm());
            this.setIdOt(calidad.getIdOt());
            this.setIdSoliServ(calidad.getIdSoliServ());
            this.setEncarCli(calidad.getEncarCli());
            this.setEncarEm(calidad.getEncarEm());
            this.setEstadoCli(calidad.getEstadoCli());
            this.setEstadoEm(calidad.getEstadoEm());
            this.setJustifiCli(calidad.getJustifiCli());
            this.setJustifiEm(calidad.getJustifiEm());
            this.setUrlCC(calidad.getUrlCC());
            this.setUrlCE(calidad.getUrlCE());
            
            FacesContext.getCurrentInstance().getExternalContext().redirect("/SCFM/faces/calidad/VisualizarCalidad.xhtml");
            return "VisualizarCalidad.xhtml";
        } else {
            return "RevisarCalidad.xhtml";
        }
    }
    
    public String envio() throws IOException {
        CalidadDao calidadDao = new CalidadDao();
        calidadDao.envioCa(this);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se ha aceptado la orden de trabajo para logística."));
        return "VisualizarCalidad.xhtml";
    }
      
}
