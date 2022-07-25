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
 * @author emily
 */
@Named(value="cotizacion")
@SessionScoped
public class Cotizacion implements Serializable {

    private int IdCotizacion;
    private int IdSoliServ;
    private int PreTrans;
    private int PreInsta;
    private int Total;

    public Cotizacion(int IdCotizacion, int IdSoliServ, int PreTrans, int PreInsta, int Total) {
        this.IdCotizacion = IdCotizacion;
        this.IdSoliServ = IdSoliServ;
        this.PreTrans = PreTrans;
        this.PreInsta = PreInsta;
        this.Total = Total;
    }

    public int getIdCotizacion() {
        return IdCotizacion;
    }

    public void setIdCotizacion(int IdCotizacion) {
        this.IdCotizacion = IdCotizacion;
    }

    public int getIdSoliServ() {
        return IdSoliServ;
    }

    public void setIdSoliServ(int IdSoliServ) {
        this.IdSoliServ = IdSoliServ;
    }

    public int getPreTrans() {
        return PreTrans;
    }

    public void setPreTrans(int PreTrans) {
        this.PreTrans = PreTrans;
    }

    public int getPreInsta() {
        return PreInsta;
    }

    public void setPreInsta(int PreInsta) {
        this.PreInsta = PreInsta;
    }

    public int getTotal() {
        return Total;
    }

    public void setTotal(int Total) {
        this.Total = Total;
    }

    

    public Cotizacion() {
 
    }

}