/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CotizProvDao;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import model.CotizProv;

/**
 *
 * @author Asus
 */
@Named(value = "cotizProvController")
@SessionScoped
public class CotizProvController extends CotizProv implements Serializable {
    
    public List<CotizProv> getCotizacionesPro() {
        return CotizProvDao.getCotizacionesPro();
    }
    
    public String vaciarEspacios() throws IOException {
        this.setIdSoliServ(0);
        this.setPrecioTotal(0);
        FacesContext.getCurrentInstance().getExternalContext().redirect("/SCFM/faces/ventas/SubirCotiFinal.xhtml");
        return "SubirCotiFinal";
     }
    
    public String guardarInformacion() throws IOException {
        CotizProvDao cotizPDao = new CotizProvDao();
        cotizPDao.crearCotizP(this);
        FacesContext.getCurrentInstance().getExternalContext().redirect("/SCFM/faces/ventas/Cotiz_Proveed.xhtml");
        return "Cotiz_Proveed.xhtml";
    }
    
    public String edita(int IdSoliS) throws IOException {
        CotizProv cotizProv
                = CotizProvDao.getCotizP(IdSoliS);
        if (cotizProv != null) {
            this.setIdCotizProv(cotizProv.getIdCotizProv());
            this.setIdSoliServ(cotizProv.getIdSoliServ());
            this.setPrecioTotal(cotizProv.getPrecioTotal());
            this.setUrl(cotizProv.getUrl());
                FacesContext.getCurrentInstance().getExternalContext().redirect("/SCFM/faces/ventas/Editar_CotiProveed.xhtml");
                return "Editar_CotiProveed.xhtml";
            
        } else {
            return "Cotiz_Proveed.xhtml";
        }
    }
    
}
