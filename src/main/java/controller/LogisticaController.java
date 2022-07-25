/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.LogisticaDao;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import model.Logistica;

/**
 *
 * @author Asus
 */
@Named(value = "logiController")
@SessionScoped
public class LogisticaController extends Logistica implements Serializable{
    
    public String modifica(int IdOt) throws IOException {
        LogisticaDao.modificar(IdOt);
                    FacesContext.getCurrentInstance().getExternalContext().redirect("/SCFM/faces/inicio.xhtml");
        return "logiController";
    }
    
    public String edita(int IdOt) throws IOException {
        Logistica logistica
                = LogisticaDao.getLogist(IdOt);
        if (logistica != null) {
            this.setIdOt(logistica.getIdOt());
            this.setDireccion(logistica.getDireccion());
            this.setEvidenciaInsta(logistica.getEvidenciaInsta());
            this.setIdSoliServ(logistica.getIdSoliServ());
        FacesContext.getCurrentInstance().getExternalContext().redirect("/SCFM/faces/logistica/EditarDirecc.xhtml");
    }
        return "logiController";
    }
    
    public String edita2(int IdOt) throws IOException {
        Logistica logistica
                = LogisticaDao.getLogist(IdOt);
        if (logistica != null) {
            this.setIdOt(logistica.getIdOt());
            this.setDireccion(logistica.getDireccion());
            this.setEvidenciaInsta(logistica.getEvidenciaInsta());
            this.setIdSoliServ(logistica.getIdSoliServ());
        FacesContext.getCurrentInstance().getExternalContext().redirect("/SCFM/faces/logistica/JustiRechaMueble.xhtml");
    }
        return "logiController";
    }
    
    public String actualizarDirecc() throws IOException {
        LogisticaDao.actualizarDirecc(this);
                    FacesContext.getCurrentInstance().getExternalContext().redirect("/SCFM/faces/logistica/Direccion.xhtml");
        return "logiController";
    }
    
    public String aceptarDirecc() throws IOException {
        LogisticaDao.aceptarDirecc(this);
                    FacesContext.getCurrentInstance().getExternalContext().redirect("/SCFM/faces/logistica/Direccion.xhtml");
        return "logiController";
    }
    
    public String enviado(){
        try {
            LogisticaDao.enviado(this);
            FacesContext.getCurrentInstance().getExternalContext().redirect("/SCFM/faces/logistica/InstaMueble.xhtml");
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se ha trasladado la orden de trabajo al área de garantía"));
                                   
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "Se ha produccido un error."));
        }
        return "logiController";
    }
    
}
