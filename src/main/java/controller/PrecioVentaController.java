/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.PrecioVentaDao;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import model.PrecioVenta;

/**
 *
 * @author emily
 */
@Named(value = "precioVentaController")
@SessionScoped
public class PrecioVentaController extends PrecioVenta implements Serializable {

    private String resultado;

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
    
    public PrecioVentaController() {
    }
    
    /*ENVIO LISTA*/
    public List<PrecioVenta> getEnvioPV() {
        return PrecioVentaDao.getEnvioPV();
    }
    
    /*ENVIO*/
    public String enviadoPV() {
        PrecioVentaDao.enviadoPV(this);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se ha enviado el precio de venta."));
        return "DefinirCostos.xhtml";
    }
    
    public String modificarRechaPV() {
        PrecioVentaDao.modificarRechaPV(this);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Se ha rechazado el precio de venta."));
        return "RecibirPrecioVenta.xhtml";
    }
    
    public String modificarAceptarPV() {
        PrecioVentaDao.modificarAceptarPV(this);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se ha aceptado el precio de venta."));
        return "RecibirPrecioVenta.xhtml";
    }
    
 /*INSERTAR DATOS NUEVOS*/
    public String guardarInformacion() {
        PrecioVentaDao precioVentaDao = new PrecioVentaDao();
        resultado = precioVentaDao.calculo(getTotalMate(), getManoObra(), getAgregados(), getDescuento())+"";
        precioVentaDao.crearOrdenPreVen(this);
        return "DefinirCostos.xhtml";
    }

    /*VACIA LOS CAMPOS AL HACER UNO NUEVO*/
    public String vaciarEspacios(int IdSoliServ) {
        this.setIdSoliServ(IdSoliServ);
        this.setTotalMate(0);
        this.setManoObra(0);
        this.setPlazoEntre("");
        this.setAgregados(0);
        this.setDescuento(0);
        this.setResultado("");
        return "DefinirCostos.xhtml";
    }
   
    /*CARGAR DATOS AL DAR EDITAR*/
    public String edita(int IdSoliServ) throws IOException {
        PrecioVenta precioVenta
                = PrecioVentaDao.getPrecioVenta(IdSoliServ);
        if (precioVenta != null) {
            this.setIdPreVenta(precioVenta.getIdPreVenta());
            this.setIdSoliServ(precioVenta.getIdSoliServ());
            this.setTotalMate(precioVenta.getTotalMate());
            this.setManoObra(precioVenta.getManoObra());
            this.setPlazoEntre(precioVenta.getPlazoEntre());
            this.setDescuento(precioVenta.getDescuento());
            this.setAgregados(precioVenta.getAgregados());
            this.setTotalCal(precioVenta.getTotalCal());
            FacesContext.getCurrentInstance().getExternalContext().redirect("/SCFM/faces/ventas/RecibirPrecioVenta.xhtml");
            return "RecibirPrecioVenta.xhtml";
        } else {
            return "PrecioVenta.xhtml";
        }
    }
    
    public String elimina(int IdSoliServ) {
        if (PrecioVentaDao.eliminar(IdSoliServ)) {
            return "PrecioVenta.xhtml";
        } else {
            return "DefinirCostos.xhtml";
        }
    }
}
