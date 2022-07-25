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
import model.OGarantia.OG;
import model.OGarantia.OGGestion;

/**
 *
 * @author KevinOcampo
 */
@Named(value = "OGController")
@SessionScoped
public class OGController extends OG implements Serializable {

    public List<OG> getSol() {
        return OGGestion.getOGt();
    }

    public String guardarInformacion() {
        OGGestion OGGestion = new OGGestion();
        OGGestion.insertarOG(this);
        return "OrdenGarantia.xhtml";

    }

    public String edita(int idM) throws IOException {
        OG OG
                = OGGestion.getOGUna(idM);
        if (OG != null) {
            this.setIdOG(OG.getIdOG());
            this.setIdOt(OG.getIdOt());
            this.setVisitaUno(OG.getVisitaUno());
            this.setVisitaDos(OG.getVisitaDos());
            this.setDireccion(OG.getDireccion());
            this.setFechaVisi(OG.getFechaVisi());
            this.setHoraVisi(OG.getHoraVisi());
            this.setEstaGO(OG.getEstaGO());
            FacesContext.getCurrentInstance().getExternalContext().redirect("/SCFM/faces/garantia/VisuaOrdenGaran.xhtml");
            return "VisuaOrdenGaran.xhtml";
        } else {
            return "OrdenGarantia.xhtml";
        }
    }
    
    public String edita2(int idM) throws IOException {
        OG OG
                = OGGestion.getOGUna(idM);
        if (OG != null) {
            this.setIdOG(OG.getIdOG());
            this.setIdOt(OG.getIdOt());
            this.setVisitaUno(OG.getVisitaUno());
            this.setVisitaDos(OG.getVisitaDos());
            this.setDireccion(OG.getDireccion());
            this.setFechaVisi(OG.getFechaVisi());
            this.setHoraVisi(OG.getHoraVisi());
            this.setEstaGO(OG.getEstaGO());
            FacesContext.getCurrentInstance().getExternalContext().redirect("/SCFM/faces/garantia/EditarOrdenGaran.xhtml");
            return "EditarOrdenGaran.xhtml";
        } else {
            return "VisuaOrdenGaran.xhtml";
        }
    }


    public String modifica() {
        OGGestion.modificar(this);
        return "OrdenGarantia.xhtml";
    }

    public String elimina(int id) {
        if (OGGestion.eliminar(id)) {
            return "OrdenGarantia.xhtml";
        } else {

            return "VisuaOrdenGaran.xhtml";
        }
    }

    public String vaciarEspacios() {
        this.setIdOG(0);
        this.setIdOt(0);
        this.setVisitaUno(0);
        this.setVisitaDos(0);
        this.setDireccion("");
        this.setFechaVisi("");
        this.setHoraVisi("");
        this.setEstaGO("");
        this.setJustifiOG("");

        return "NueOrdenGaran.xhtml";
    }

    public String modificarRechaOG() {
        OGGestion.modificarRechaOG(this);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Se ha rechazado la orden de garantía."));
        return "VisuaOrdenGaran.xhtml";
    }
    
    public String modificarAceptarOG() throws IOException {
        OGGestion.modificarAcepOG(this);
        FacesContext.getCurrentInstance().getExternalContext().redirect("/SCFM/faces/garantia/OrdenGarantia.xhtml");
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se ha aceptado la orden de garantía."));
        return "NuevaRepaGa.xhtml";
    }
}
