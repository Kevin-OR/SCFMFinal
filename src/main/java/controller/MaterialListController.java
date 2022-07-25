/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package controller;

import dao.MaterialListDao;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import model.MaterialList;
import model.material.MaterialGestion;
import model.material.materiales;
import org.primefaces.PrimeFaces;

/**
 *
 * @author Asus
 */
@Named(value = "mateListController")
@SessionScoped
public class MaterialListController extends MaterialList implements Serializable {

    public MaterialListController() {

    }

    public String listarMate(int IdSoli) throws IOException {
        MaterialListDao materialListDao = new MaterialListDao();
        materialListDao.crearMateList(IdSoli, this);
        this.setIdMaterial(0);
        this.setCantOcupar(0);
        FacesContext.getCurrentInstance().getExternalContext().redirect("/SCFM/faces/ventas/RealizarCotizacion.xhtml");
        return "RealizarCotizacion.xhtml";
    }

    public String listarMate2(int IdSoli) throws IOException {
        MaterialListDao materialListDao = new MaterialListDao();
        materialListDao.crearMateList(IdSoli, this);
        this.setIdMaterial(0);
        this.setCantOcupar(0);
        FacesContext.getCurrentInstance().getExternalContext().redirect("/SCFM/faces/ventas/Editar_Cotizacion.xhtml");
        return "Editar_Cotizacion.xhtml";
    }

    public String elimina(int id) throws IOException {
        if (MaterialListDao.eliminar(id)) {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/SCFM/faces/ventas/RealizarCotizacion.xhtml");
            return "RealizarCotizacion.xhtml";
        } else {
            return "RealizarCotizacion.xhtml";
        }
    }

    public String elimina2(int id) throws IOException {
        if (MaterialListDao.eliminar(id)) {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/SCFM/faces/ventas/Editar_Cotizacion.xhtml");
            return "Editar_Cotizacion.xhtml";
        } else {
            return "Editar_Cotizacion.xhtml";
        }
    }
}
