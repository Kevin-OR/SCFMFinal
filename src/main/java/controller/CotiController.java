/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package controller;

import dao.CotizacionDao;
import dao.MaterialListDao;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import model.Cotizacion;
import model.MaterialList;

/**
 *
 * @author emily
 */
@Named(value = "cotiController")
@SessionScoped
public class CotiController extends Cotizacion implements Serializable {

    public CotiController() {
    }

    private int IdSoli;

    public String guardarInformacion() throws IOException {
        CotizacionDao cotizacionDao = new CotizacionDao();
        cotizacionDao.crearCotiz(this);
        this.setTotal(CotizacionDao.getTotal());
        FacesContext.getCurrentInstance().getExternalContext().redirect("/SCFM/faces/ventas/RealizarCotizacion.xhtml");
        return "RealizarCotizacion.xhtml";
    }

    public String guardarInformacion2() throws IOException {
        CotizacionDao cotizacionDao = new CotizacionDao();
        cotizacionDao.crearCotiz(this);
        this.setTotal(CotizacionDao.getTotal());
        FacesContext.getCurrentInstance().getExternalContext().redirect("/SCFM/faces/ventas/Editar_Cotizacion.xhtml");
        return "Editar_Cotizacion.xhtml";
    }

    public List<MaterialList> getMaterList() {
        return CotizacionDao.getMateList(IdSoli);
    }

    public String edita(int IdSoliS, int ed) throws IOException {
        IdSoli = IdSoliS;
        Cotizacion cotizacion
                = CotizacionDao.getCotizacion(IdSoli);
        if (cotizacion != null) {
            this.setIdCotizacion(cotizacion.getIdCotizacion());
            this.setIdSoliServ(cotizacion.getIdSoliServ());
            this.setPreTrans(cotizacion.getPreTrans());
            this.setPreInsta(cotizacion.getPreInsta());
            this.setTotal(cotizacion.getTotal());
            if (ed == 1) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("/SCFM/faces/ventas/VerCotizacion.xhtml");
                return "VerCotizacion.xhtml";
            } else if (ed == 2) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("/SCFM/faces/ventas/Editar_Cotizacion.xhtml");
                return "Editar_Cotizacion.xhtml";
            }
        } else {
            return "Cotizacion.xhtml";
        }
        return "cotiController";
    }

    public String obtenerId(int IdSoliS) throws IOException {
        IdSoli = IdSoliS;
        this.setIdSoliServ(IdSoli);
        this.setPreInsta(0);
        this.setPreTrans(0);
        this.setTotal(0);
        CotizacionDao cotizacionDao = new CotizacionDao();
        if (cotizacionDao.crearCoti(IdSoli) == true) {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/SCFM/faces/ventas/RealizarCotizacion.xhtml");
            return "RealizarCotizacion.xhtml";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Esta Solicitud ya tiene un cotización"));
            return "Cotizacion.xhtml";
        }
    }

}
