/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.MaterialListDao;
import dao.TareasCronoDao;
import java.io.IOException;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import model.TareasCrono;
/**
 *
 * @author Asus
 */
@Named(value = "tareasCController")
@SessionScoped
public class TareasCronoController extends TareasCrono implements Serializable{
    
    public TareasCronoController() {

    }

    public String listarTarea(int IdOt) throws IOException {
        TareasCronoDao tareasCronoDao = new TareasCronoDao();
        tareasCronoDao.crearTareaC(IdOt, this);
        this.setNomTarea("");
        this.setFechaFin("");
        this.setIdPersonal(0);
        FacesContext.getCurrentInstance().getExternalContext().redirect("/SCFM/faces/produccion/Cronograma.xhtml");
        return "Cronograma.xhtml";
    }

    public String listarMate2(int IdOt) throws IOException {
        TareasCronoDao tareasCronoDao = new TareasCronoDao();
        tareasCronoDao.crearTareaC(IdOt, this);
        this.setNomTarea("");
        this.setFechaFin("");
        this.setIdPersonal(0);
        FacesContext.getCurrentInstance().getExternalContext().redirect("/SCFM/faces/produccion/EditarCronograma.xhtml");
        return "EditarCronograma.xhtml";
    }

    public String elimina(int id) throws IOException {
        if (TareasCronoDao.eliminar(id)) {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/SCFM/faces/produccion/Cronograma.xhtml");
            return "Cronograma.xhtml";
        } else {
            return "Cronograma.xhtml";
        }
    }

    public String elimina2(int id) throws IOException {
        if (TareasCronoDao.eliminar(id)) {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/SCFM/faces/produccion/EditarCronograma.xhtml");
            return "EditarCronograma.xhtml";
        } else {
            return "EditarCronograma.xhtml";
        }
    }
    
}
