/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import model.OrdenTraba.OrdenTrabaGestion;
import model.OrdenTraba.OrdenTrabajo;
import model.OrdenTraba.TablaOT;
import model.OrdenTraba.soli;

/**
 *
 * @author KevinOcampo
 */
@Named(value = "OTController")
@SessionScoped
public class OTController extends OrdenTrabajo implements Serializable {

    public OTController() {

    }

    public List<soli> getSol() {
        return OrdenTrabaGestion.getSoli();
    }
    
    public List<TablaOT> getEnvio() {
        return OrdenTrabaGestion.getEnvio();
    }
    
    /*PRODUCCIÓN*/
    public List<TablaOT> getEnvioAR() {
        return OrdenTrabaGestion.getEnvioAR();
    }
    
    /*PRODUCCIÓN/FINAL*/
    public List<TablaOT> getEnvioFi() {
        return OrdenTrabaGestion.getEnvioFi();
    }
    
    /*PRODUCCIÓN/FINAL/ACEP*/
    public List<TablaOT> getEnvioFiAc() {
        return OrdenTrabaGestion.getEnvioFiAc();
    }
    
    /*CALIDAD*/
    public List<TablaOT> getEnvioCa() {
        return OrdenTrabaGestion.getEnvioCa();
    }
    
    /*LOGISTICA PARA ACEPTAR*/
    public List<TablaOT> getEnvioLo() {
        return OrdenTrabaGestion.getEnvioLo();
    }
    
    /*LOGISTICA ACEPTADA*/
    public List<TablaOT> getEnvioLoAc() {
        return OrdenTrabaGestion.getEnvioLoAc();
    }
    
    public List<TablaOT> getEnvioLoInsta() {
        return OrdenTrabaGestion.getEnvioLoInsta();
    }
    
    public List<TablaOT> getEnvioGaran() {
        return OrdenTrabaGestion.getEnvioGaran();
    }

    public List<TablaOT> getTabOT() {
        return OrdenTrabaGestion.getTablaOT();
    }

    public String edita(int idM) throws IOException {
        OrdenTrabajo OrdenTrabajo
                = OrdenTrabaGestion.getOT(idM);
        if (OrdenTrabajo != null) {
            this.setIdOt(OrdenTrabajo.getIdOt());
            this.setIdOtordenservicio(OrdenTrabajo.getIdOtordenservicio());
            this.setFechaIni(OrdenTrabajo.getFechaIni());
            this.setFechaEntre(OrdenTrabajo.getFechaEntre());
            this.setProyect(OrdenTrabajo.getProyect());
            this.setNomClien(OrdenTrabajo.getNomClien());
            this.setPriApell(OrdenTrabajo.getPriApell());
            this.setSegApell(OrdenTrabajo.getSegApell());
            this.setEstadoOT(OrdenTrabajo.getEstadoOT());
            FacesContext.getCurrentInstance().getExternalContext().redirect("/SCFM/faces/ventas/Visualizar_OTVenta.xhtml");
            return "Visualizar_OTVenta.xhtml";
        } else {
            return "OrdenTrabajo.xhtml";
        }
    }
    
    
    public String editaPro(int idM) throws IOException {
        OrdenTrabajo OrdenTrabajo
                = OrdenTrabaGestion.getOT(idM);
        if (OrdenTrabajo != null) {
            this.setIdOt(OrdenTrabajo.getIdOt());
            this.setIdOtordenservicio(OrdenTrabajo.getIdOtordenservicio());
            this.setFechaIni(OrdenTrabajo.getFechaIni());
            this.setFechaEntre(OrdenTrabajo.getFechaEntre());
            this.setProyect(OrdenTrabajo.getProyect());
            this.setNomClien(OrdenTrabajo.getNomClien());
            this.setPriApell(OrdenTrabajo.getPriApell());
            this.setSegApell(OrdenTrabajo.getSegApell());
            this.setEstadoOT(OrdenTrabajo.getEstadoOT());
            FacesContext.getCurrentInstance().getExternalContext().redirect("/SCFM/faces/produccion/Ver_OT.xhtml");
            return "Ver_OT.xhtml";
        } else {
            return "OrdenTrabajoPro.xhtml";
        }
    }
    
    public String enviado(int Envi){
        try {
            OrdenTrabaGestion.enviado(Envi, this);
            switch (Envi){
                case 1:
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se ha enviado la orden de trabajo."));
                    break;
                case 2:
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se ha aceptado la orden de trabajo."));
                    break;
                case 3:
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Se ha rechazado la orden de trabajo."));
                    break;
                case 4:
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se ha finalizado la producción de la orden de trabajo."));
                    break;
                case 5:
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se ha aceptado la orden de trabajo en calidad."));
                    break;
            }                    
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "Se ha produccido un error."));
        }
        return "Visualizar_OTVenta.xhtml";
    }
    
    
    public String vaciarEspacios() {
        this.setIdOt(0);
        this.setIdOtordenservicio(0);
        this.setFechaIni("");
        this.setFechaEntre("");
        this.setProyect("");
        this.setNomClien("");
        this.setPriApell("");
        this.setSegApell("");
        this.setEstadoOT("");
        return "OTController";
    }

    public String guardarInformacion() {
        OrdenTrabaGestion ordenTrabaGestion = new OrdenTrabaGestion();
        ordenTrabaGestion.insertarOT(this);
        return "OrdenTrabajo.xhtml";

    }
}
