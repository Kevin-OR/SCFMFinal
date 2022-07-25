/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Asus
 */
@Named(value = "cotizProv")
@SessionScoped
public class CotizProv implements Serializable {

    private int IdCotizProv;
    private int IdSoliServ;
    private int PrecioTotal;
    private String Url;
    private String NombClient;
    private String PriApeClient;
    private String Proyecto;
    
    

    public CotizProv(int IdCotizProv, int IdSoliServ, int PrecioTotal, String Url) {
        this.IdCotizProv = IdCotizProv;
        this.IdSoliServ = IdSoliServ;
        this.PrecioTotal = PrecioTotal;
        this.Url = Url;
    }

    public CotizProv(int IdCotizProv, int IdSoliServ, int PrecioTotal, String NombClient, String PriApeClient, String Proyecto) {
        this.IdCotizProv = IdCotizProv;
        this.IdSoliServ = IdSoliServ;
        this.PrecioTotal = PrecioTotal;
        this.NombClient = NombClient;
        this.PriApeClient = PriApeClient;
        this.Proyecto = Proyecto;
    }

    
    
    
    public int getIdCotizProv() {
        return IdCotizProv;
    }

    public void setIdCotizProv(int IdCotizProv) {
        this.IdCotizProv = IdCotizProv;
    }

    public int getIdSoliServ() {
        return IdSoliServ;
    }

    public void setIdSoliServ(int IdSoliServ) {
        this.IdSoliServ = IdSoliServ;
    }

    public int getPrecioTotal() {
        return PrecioTotal;
    }

    public void setPrecioTotal(int PrecioTotal) {
        this.PrecioTotal = PrecioTotal;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String Url) {
        this.Url = Url;
    }

    public String getNombClient() {
        return NombClient;
    }

    public void setNombClient(String NombClient) {
        this.NombClient = NombClient;
    }

    public String getPriApeClient() {
        return PriApeClient;
    }

    public void setPriApeClient(String PriApeClient) {
        this.PriApeClient = PriApeClient;
    }

    public String getProyecto() {
        return Proyecto;
    }

    public void setProyecto(String Proyecto) {
        this.Proyecto = Proyecto;
    }

    

    public CotizProv() {
    }
    
    

}
