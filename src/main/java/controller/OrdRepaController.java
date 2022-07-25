/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.OrdRepaDao;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import model.OrdRepa;

/**
 *
 * @author Asus
 */
@Named(value = "ORController")
@SessionScoped
public class OrdRepaController extends OrdRepa implements Serializable {

    public OrdRepaController() {
    }

    private int IdOR;

    /*INSERTAR DATOS NUEVOS*/
    public String guardarInformacion(int Modulo) throws IOException {
        try {
            OrdRepaDao ordRepaDao = new OrdRepaDao();
            ordRepaDao.crearOR(Modulo, this);
            this.setIdOrdRepa(0);
        
            switch (Modulo) {
                case 4:
                    FacesContext.getCurrentInstance().getExternalContext().redirect("/SCFM/faces/calidad/OrdenRepaCa.xhtml");
                    break;
                case 5:
                    FacesContext.getCurrentInstance().getExternalContext().redirect("/SCFM/faces/logistica/OrdenRepaLo.xhtml");
                    break;
                case 6:
                    FacesContext.getCurrentInstance().getExternalContext().redirect("/SCFM/faces/garantia/OrdenRepaGa.xhtml");
                    break;

            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "Se ha produccido un error."));
        }
        return "ORController";
    }

    /*VACIA LOS CAMPOS AL HACER UNO NUEVO*/
    public String vaciarEspacios() {
        this.setIdOrdRepa(0);
        this.setIdOt(0);
        this.setJustifOR("");
        this.setResponOR(0);
        return "NuevaRepaGa.xhtml";
    }
    /*VACIA LOS CAMPOS AL HACER UNO NUEVO*/
    public String vaciarEspacios2() {
        this.setIdOrdRepa(0);
        this.setIdOt(0);
        this.setJustifOR("");
        this.setResponOR(0);
        return "NuevaRepaLo.xhtml";
    }
    /*VACIA LOS CAMPOS AL HACER UNO NUEVO*/
    public String vaciarEspacios3() {
        this.setIdOrdRepa(0);
        this.setIdOt(0);
        this.setJustifOR("");
        this.setResponOR(0);
        return "NuevaRepaCa.xhtml";
    }

    /*VISUALIZAR LISTA*/
    public List<OrdRepa> getOrdenesRepaCali() {
        return OrdRepaDao.getOrdenesRepaCali();
    }

    public List<OrdRepa> getOrdenesRepaLogi() {
        return OrdRepaDao.getOrdenesRepaLogi();
    }

    public List<OrdRepa> getOrdenesRepaGaran() {
        return OrdRepaDao.getOrdenesRepaGaran();
    }

    /*CARGAR DATOS AL DAR EDITAR*/
    public String edita(int IdOrdRepa, int ed, int tipo) throws IOException {
        IdOR = IdOrdRepa;
        OrdRepa ordRepa
                = OrdRepaDao.getOrdenRepa(IdOR, tipo);
        if (ordRepa != null) {
            this.setIdOrdRepa(ordRepa.getIdOrdRepa());
            this.setIdOt(ordRepa.getIdOt());
            this.setJustifOR(ordRepa.getJustifOR());
            this.setResponOR(ordRepa.getResponOR());
            this.setUrl(ordRepa.getUrl());
            switch (ed) {
                case 1:
                    FacesContext.getCurrentInstance().getExternalContext().redirect("/SCFM/faces/calidad/VerRepaCa.xhtml");
                    break;
                case 2:
                    FacesContext.getCurrentInstance().getExternalContext().redirect("/SCFM/faces/calidad/EdiRepaCa.xhtml");
                    break;
                case 3:
                    FacesContext.getCurrentInstance().getExternalContext().redirect("/SCFM/faces/logistica/VerRepaLo.xhtml");
                    break;
                case 4:
                    FacesContext.getCurrentInstance().getExternalContext().redirect("/SCFM/faces/logistica/EdiRepaLo.xhtml");
                    break;
                case 5:
                    FacesContext.getCurrentInstance().getExternalContext().redirect("/SCFM/faces/garantia/VerRepaGa.xhtml");
                    break;
                case 6:
                    FacesContext.getCurrentInstance().getExternalContext().redirect("/SCFM/faces/garantia/EdiRepaGa.xhtml");
                    break;

            }
        
    }
        return "ORController";
    }

    /*MODIFICA LOS CAMBIOS*/
    public String modifica(int Modulo) throws IOException {
        OrdRepaDao.modificar(this);
        switch (Modulo) {
                case 4:
                    FacesContext.getCurrentInstance().getExternalContext().redirect("/SCFM/faces/calidad/VerRepaCa.xhtml");
                    break;
                case 5:
                    FacesContext.getCurrentInstance().getExternalContext().redirect("/SCFM/faces/logistica/VerRepaLo.xhtml");
                    break;
                case 6:
                    FacesContext.getCurrentInstance().getExternalContext().redirect("/SCFM/faces/garantia/VerRepaGa.xhtml");
                    break;

            }
        return "ORController";
    }
    
    public String enviarOR() throws IOException {
        OrdRepaDao.enviarOR(this);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se ha enviado la orden de reparación a producción"));
        return "ORController";
    }

}
