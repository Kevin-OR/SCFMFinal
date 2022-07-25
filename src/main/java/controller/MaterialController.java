/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import model.material.MaterialGestion;
import model.material.materiales;

/**
 *
 * @author KevinOcampo
 */
@Named(value = "MaterialController")
@SessionScoped
public class MaterialController extends materiales implements Serializable {

    public MaterialController() {

    }

    public List<materiales> getMateriales() {
        return MaterialGestion.getMateriales();
    }

    public String edita(int idM) {
        materiales materiales
                = MaterialGestion.getMaterial(idM);
        if (materiales != null) {
            this.setIdMaterial(materiales.getIdMaterial());
            this.setNomMaterial(materiales.getNomMaterial());
            this.setPrecioMaterial(materiales.getPrecioMaterial());
            this.setCantMaterial(materiales.getCantMaterial());

            return "EditarInvenMate.xhtml";
        } else {
            return "InvenMaterial.xhtml";
        }
    }

    public String modifica() {
        MaterialGestion.modificar(this);
        return "InvenMaterial.xhtml";
    }

    public String elimina(int id) {
        if (MaterialGestion.eliminar(id)) {
            return "InvenMaterial.xhtml";
        } else {
            FacesMessage mensaje = new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, "Error",
                    "Posiblemente el id no existe");
            FacesContext.getCurrentInstance().addMessage(
                    "editaCanchaForm:identificacion",
                    mensaje);
            return "InvenMaterial.xhtml";
        }
    }

    public String vaciarEspacios() {
        this.setNomMaterial("");
        this.setPrecioMaterial(0);
        this.setCantMaterial(0);

        return "MaterialController";
    }

    /*INSERTAR*/
    public String guardarInformacion() {

        MaterialGestion materialGestion = new MaterialGestion();
        materialGestion.inserMateri(this);
        
        
        return "InvenMaterial.xhtml";

    }

    public String nuevoMater() {
        
        MaterialGestion materialGestion = new MaterialGestion();
        materialGestion.crearMaterCoti(this);
        this.setNomMaterial("");
        this.setPrecioMaterial(0);
        return "RealizarCotizacion.xhtml";

    }

}
