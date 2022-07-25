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
@Named(value = "precioVen")
@SessionScoped
public class PrecioVenta implements Serializable {

    private int IdPreVenta;
    private int IdSoliServ;
    private int TotalMate;
    private int ManoObra;
    private String PlazoEntre;
    private int Descuento;
    private int Agregados;
    private int TotalCal;
    private String EstadoPV;
    private String JustifiPV;

    public PrecioVenta() {
    }

    public PrecioVenta(int IdPreVenta, int IdSoliServ, int TotalMate, int ManoObra, String PlazoEntre, int Descuento, int Agregados, int TotalCal, String EstadoPV, String JustifiPV) {
        this.IdPreVenta = IdPreVenta;
        this.IdSoliServ = IdSoliServ;
        this.TotalMate = TotalMate;
        this.ManoObra = ManoObra;
        this.PlazoEntre = PlazoEntre;
        this.Descuento = Descuento;
        this.Agregados = Agregados;
        this.TotalCal = TotalCal;
        this.EstadoPV = EstadoPV;
        this.JustifiPV = JustifiPV;
    }

    public int getIdPreVenta() {
        return IdPreVenta;
    }

    public void setIdPreVenta(int IdPreVenta) {
        this.IdPreVenta = IdPreVenta;
    }

    public int getIdSoliServ() {
        return IdSoliServ;
    }

    public void setIdSoliServ(int IdSoliServ) {
        this.IdSoliServ = IdSoliServ;
    }

    public int getTotalMate() {
        return TotalMate;
    }

    public void setTotalMate(int TotalMate) {
        this.TotalMate = TotalMate;
    }

    public int getManoObra() {
        return ManoObra;
    }

    public void setManoObra(int ManoObra) {
        this.ManoObra = ManoObra;
    }

    public String getPlazoEntre() {
        return PlazoEntre;
    }

    public void setPlazoEntre(String PlazoEntre) {
        this.PlazoEntre = PlazoEntre;
    }

    public int getDescuento() {
        return Descuento;
    }

    public void setDescuento(int Descuento) {
        this.Descuento = Descuento;
    }

    public int getAgregados() {
        return Agregados;
    }

    public void setAgregados(int Agregados) {
        this.Agregados = Agregados;
    }

    public int getTotalCal() {
        return TotalCal;
    }

    public void setTotalCal(int TotalCal) {
        this.TotalCal = TotalCal;
    }

    public String getEstadoPV() {
        return EstadoPV;
    }

    public void setEstadoPV(String EstadoPV) {
        this.EstadoPV = EstadoPV;
    }

    public String getJustifiPV() {
        return JustifiPV;
    }

    public void setJustifiPV(String JustifiPV) {
        this.JustifiPV = JustifiPV;
    }

    

   
}