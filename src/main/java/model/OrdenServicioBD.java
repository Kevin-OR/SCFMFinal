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
@Named(value = "ordenesSer")
@SessionScoped
public class OrdenServicioBD implements Serializable {

    private int IdOrdenSer;
    private String Cliente;
    private int VisitaUno;
    private int VisitaDos;
    private String Direccion;
    private String FechaVisi;
    private String HoraVisi;
    private int IdEspacio;
    private String Muestra;
    private String Estado;

    public OrdenServicioBD() {

    }

    public OrdenServicioBD(int IdOrdenSer, String Cliente, int VisitaUno, int VisitaDos, String Direccion, String FechaVisi, String HoraVisi, int IdEspacio, String Muestra, String Estado) {
        this.IdOrdenSer = IdOrdenSer;
        this.Cliente = Cliente;
        this.VisitaUno = VisitaUno;
        this.VisitaDos = VisitaDos;
        this.Direccion = Direccion;
        this.FechaVisi = FechaVisi;
        this.HoraVisi = HoraVisi;
        this.IdEspacio = IdEspacio;
        this.Muestra = Muestra;
        this.Estado = Estado;
    }

    public int getIdOrdenSer() {
        return IdOrdenSer;
    }

    public void setIdOrdenSer(int IdOrdenSer) {
        this.IdOrdenSer = IdOrdenSer;
    }

    public String getCliente() {
        return Cliente;
    }

    public void setCliente(String Cliente) {
        this.Cliente = Cliente;
    }

    public int getVisitaUno() {
        return VisitaUno;
    }

    public void setVisitaUno(int VisitaUno) {
        this.VisitaUno = VisitaUno;
    }

    public int getVisitaDos() {
        return VisitaDos;
    }

    public void setVisitaDos(int VisitaDos) {
        this.VisitaDos = VisitaDos;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getFechaVisi() {
        return FechaVisi;
    }

    public void setFechaVisi(String FechaVisi) {
        this.FechaVisi = FechaVisi;
    }

    public String getHoraVisi() {
        return HoraVisi;
    }

    public void setHoraVisi(String HoraVisi) {
        this.HoraVisi = HoraVisi;
    }

    public int getIdEspacio() {
        return IdEspacio;
    }

    public void setIdEspacio(int IdEspacio) {
        this.IdEspacio = IdEspacio;
    }

    public String getMuestra() {
        return Muestra;
    }

    public void setMuestra(String Muestra) {
        this.Muestra = Muestra;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

}
