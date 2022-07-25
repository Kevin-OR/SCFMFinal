/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CronogramaDao;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import model.Cronograma;
import model.TareasCrono;

/**
 *
 * @author emily
 */
@Named(value = "cronoController")
@SessionScoped
public class CronogramaController extends Cronograma implements Serializable{
    
    public CronogramaController() {
    }

    private int IdOt;

    public String guardarInformacion() throws IOException {
        CronogramaDao cronogramaDao = new CronogramaDao();
        cronogramaDao.crearCronos(this);
        FacesContext.getCurrentInstance().getExternalContext().redirect("/SCFM/faces/produccion/MenuCronograma.xhtml");
        return "MenuCronograma.xhtml";
    }

    public String guardarInformacion2() throws IOException {
        CronogramaDao cronogramaDao = new CronogramaDao();
        cronogramaDao.crearCronos(this);
        FacesContext.getCurrentInstance().getExternalContext().redirect("/SCFM/faces/produccion/VerCrono.xhtml");
        return "VerCrono.xhtml";
    }

    public List<TareasCrono> getTareasC() {
        return CronogramaDao.getTareas(IdOt);
    }

    public String edita(int IdOtC, int ed) throws IOException {
        IdOt = IdOtC;
        Cronograma cronograma
                = CronogramaDao.getCrono(IdOt);
        if (cronograma != null) {
            this.setIdCrono(cronograma.getIdCrono());
            this.setIdOt(cronograma.getIdOt());
            this.setCronoGuardado(cronograma.getCronoGuardado());
            this.setCronoFinal(cronograma.getCronoFinal());
            if (ed == 1) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("/SCFM/faces/produccion/VerCrono.xhtml");
                return "VerCrono.xhtml";
            } else if (ed == 2) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("/SCFM/faces/produccion/EditarCronograma.xhtml");
                return "EditarCronograma.xhtml";
            }
        } else {
            return "MenuCronograma.xhtml";
        }
        return "cronoController";
    }

    public String obtenerId(int IdOtC) throws IOException {
        IdOt = IdOtC;
            this.setIdCrono(0);
            this.setIdOt(IdOt);
            this.setCronoGuardado(0);
            this.setCronoFinal(0);
        CronogramaDao cronogramaDao = new CronogramaDao();
        if (cronogramaDao.crearCrono(IdOt) == true) {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/SCFM/faces/produccion/Cronograma.xhtml");
            return "Cronograma.xhtml";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Ya existe un cronograma"));
            return "MenuCronograma.xhtml";
        }
    }
}
