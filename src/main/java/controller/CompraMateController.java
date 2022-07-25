/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CompraMateDao;
import dao.EspecificacionOTDao;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import model.CompraMate;
import model.OrdenTraba.TablaOT;

/**
 *
 * @author emily
 */
@Named(value = "compraMateController")
@SessionScoped
public class CompraMateController extends CompraMate implements Serializable {
    
    public CompraMateController() {

    }
    
    private int id;

    public String obtenerId(int IdO) throws IOException {
        id = IdO;
        this.setIdOt(id);
        this.setIdMateCompra(0);
        this.setIdMaterial(0);
        this.setCantiCompra(0);
        FacesContext.getCurrentInstance().getExternalContext().redirect("/SCFM/faces/produccion/Materiales.xhtml");
        return "Materiales.xhtml";
    }

   

    /*ENVIO LISTA*/
    public List<TablaOT> getEnvioCompra() {
        return CompraMateDao.getEnvioCompra();
    }

    /*ENVIO*/
    public String enviadoCompra() {
        CompraMateDao.enviadoCompra(this);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se ha enviado el listado de materiales a comprar"));
        return "Materiales.xhtml";
    }


    public List<CompraMate> getMates() {
        return CompraMateDao.getCompraMate(id);
    }
   
    public String guardarInformacion() throws IOException {
        CompraMateDao compraMateDao = new CompraMateDao();
        if(compraMateDao.crearMates(this)==false){
        
        this.setIdOt(id);
        this.setIdMateCompra(0);
        this.setIdMaterial(0);
        this.setCantiCompra(0);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Suficientes materiales en el inventario"));
        FacesContext.getCurrentInstance().getExternalContext().redirect("/SCFM/faces/produccion/Materiales.xhtml");
        }else{
        this.setIdOt(id);
        this.setIdMateCompra(0);
        this.setIdMaterial(0);
        this.setCantiCompra(0);
        FacesContext.getCurrentInstance().getExternalContext().redirect("/SCFM/faces/produccion/Materiales.xhtml");
        }
        return "Materiales.xhtml";
    
    }

    public String vaciarEspacios(int IdOt) {
        this.setIdOt(IdOt);
        this.setIdMateCompra(0);
        this.setIdMaterial(0);
        this.setCantiCompra(0);
        return "Materiales.xhtml";
    }

    public String elimina(int IdMaterial) throws IOException {
        CompraMateDao.eliminar(IdMaterial);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Se ha eliminado material del listado."));
        FacesContext.getCurrentInstance().getExternalContext().redirect("/SCFM/faces/produccion/Materiales.xhtml");
        return "Materiales.xhtml";
    }
}

