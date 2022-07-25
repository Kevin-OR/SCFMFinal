/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.OGarantia;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author KevinOcampo
 */
@Named(value = "OG")
@SessionScoped
public class OG implements Serializable{
    
    private int IdOG;
    private int IdOt;
    private String nomCliente;
    private String segCliente;
    private String priCliente;
    private String proyec;
    private int VisitaUno;
    private int VisitaDos;
    private String Direccion;
    private String FechaVisi;
    private String HoraVisi;
    private String EstaGO;
    private String JustifiOG;

    public OG() {
    }

    public OG(int IdOG, String nomCliente, String segCliente, String priCliente, String proyec, String EstaGO) {
        this.IdOG = IdOG;
        this.nomCliente = nomCliente;
        this.segCliente = segCliente;
        this.priCliente = priCliente;
        this.proyec = proyec;
        this.EstaGO = EstaGO;
    }

    public OG(int IdOG, int IdOt, int VisitaUno, int VisitaDos, String Direccion, String FechaVisi, String HoraVisi, String EstaGO) {
        this.IdOG = IdOG;
        this.IdOt = IdOt;
        this.VisitaUno = VisitaUno;
        this.VisitaDos = VisitaDos;
        this.Direccion = Direccion;
        this.FechaVisi = FechaVisi;
        this.HoraVisi = HoraVisi;
        this.EstaGO = EstaGO;
    }
    
    

    public OG(int IdOG, int IdOt, int VisitaUno, int VisitaDos, String Direccion, String FechaVisi, String HoraVisi, String EstaGO, String JustifiOG) {
        this.IdOG = IdOG;
        this.IdOt = IdOt;
        this.VisitaUno = VisitaUno;
        this.VisitaDos = VisitaDos;
        this.Direccion = Direccion;
        this.FechaVisi = FechaVisi;
        this.HoraVisi = HoraVisi;
        this.EstaGO = EstaGO;
        this.JustifiOG = JustifiOG;
    }
    
    

    public int getIdOG() {
        return IdOG;
    }

    public void setIdOG(int IdOG) {
        this.IdOG = IdOG;
    }

    public int getIdOt() {
        return IdOt;
    }

    public void setIdOt(int IdOt) {
        this.IdOt = IdOt;
    }

    public String getNomCliente() {
        return nomCliente;
    }

    public void setNomCliente(String nomCliente) {
        this.nomCliente = nomCliente;
    }

    public String getSegCliente() {
        return segCliente;
    }

    public void setSegCliente(String segCliente) {
        this.segCliente = segCliente;
    }

    public String getPriCliente() {
        return priCliente;
    }

    public void setPriCliente(String priCliente) {
        this.priCliente = priCliente;
    }

    public String getProyec() {
        return proyec;
    }

    public void setProyec(String proyec) {
        this.proyec = proyec;
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

    public String getEstaGO() {
        return EstaGO;
    }

    public void setEstaGO(String EstaGO) {
        this.EstaGO = EstaGO;
    }

    public String getJustifiOG() {
        return JustifiOG;
    }

    public void setJustifiOG(String JustifiOG) {
        this.JustifiOG = JustifiOG;
    }

    
   
}
