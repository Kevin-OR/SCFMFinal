/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.EspecificacionOTDao;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import model.EspecificacionOT;
import model.OrdenTraba.TablaOT;


/**
 *
 * @author emily
 */
@Named(value = "especificacionOTController")
@SessionScoped
public class EspecificacionOTController extends EspecificacionOT implements Serializable {

    private int id;

    public String obtenerId(int IdO) {
        id = IdO;
        this.setIdOt(id);
        this.setNomEspe("");
        this.setTipoEspe("");
        this.setDescrEspe("");
        this.setNotasEspe("");
        return "Especif_OT.xhtml";
    }

    public EspecificacionOTController() {

    }

    /*ENVIO LISTA*/
    public List<TablaOT> getEnvioES() {
        return EspecificacionOTDao.getEnvioEs();
    }

    /*ENVIO*/
    public String enviadoES() {
        EspecificacionOTDao.enviadoEs(this);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se han enviado las especificaciones"));
        return "Especif_OT.xhtml";
    }

    public String modificarAceptarES() {
        EspecificacionOTDao.modificarAceptarES(this);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se ha verificado las especificaciones de la orden de trabajo."));
        return "Especif_OT.xhtml";
    }

    public List<EspecificacionOT> getEspecis() {
        return EspecificacionOTDao.getEspecificacionOT(id);
    }
   
    public String guardarInformacion() throws IOException {
        EspecificacionOTDao especificacionOTDao = new EspecificacionOTDao();
        especificacionOTDao.crearEspeciS(this);
        this.setNomEspe("");
        this.setTipoEspe("");
        this.setDescrEspe("");
        this.setNotasEspe("");
        FacesContext.getCurrentInstance().getExternalContext().redirect("/SCFM/faces/ventas/Especif_OT.xhtml");
        
        return "Especif_OT.xhtml";
    }

    public String vaciarEspacios(int IdOt) {
        this.setIdOt(IdOt);
        this.setNomEspe("");
        this.setTipoEspe("");
        this.setDescrEspe("");
        this.setNotasEspe("");
        return "Especif_OT.xhtml";
    }

    public String elimina(int IdEspe) throws IOException {
        EspecificacionOTDao.eliminar(IdEspe);
        FacesContext.getCurrentInstance().getExternalContext().redirect("/SCFM/faces/ventas/Especif_OT.xhtml");
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Se ha eliminado especificación de la orden de trabajo."));
        return "Especif_OT.xhtml";
    }
}
