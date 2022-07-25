/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.OrdenTraba;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author KevinOcampo
 */
@Named(value = "OrdenTrabajo")
@SessionScoped
public class OrdenTrabajo implements Serializable{
    private int IdOt;
    private int IdOtordenservicio;
    private String FechaIni;
    private String FechaEntre;
    private String proyect;
    private String nomClien;
    private String priApell;
    private String segApell;
    private String JustifiOt;
    private String EstadoOT;

    public OrdenTrabajo() {
    }
    
    public OrdenTrabajo(int IdOt, int IdOtordenservicio, String FechaIni, String FechaEntre, String proyect, String nomClien, String priApell, String segApell, String JustifiOt, String EstadoOT) {
        this.IdOt = IdOt;
        this.IdOtordenservicio = IdOtordenservicio;
        this.FechaIni = FechaIni;
        this.FechaEntre = FechaEntre;
        this.proyect = proyect;
        this.nomClien = nomClien;
        this.priApell = priApell;
        this.segApell = segApell;
        this.JustifiOt = JustifiOt;
        this.EstadoOT = EstadoOT;
    }

    public int getIdOt() {
        return IdOt;
    }

    public void setIdOt(int IdOt) {
        this.IdOt = IdOt;
    }

    public int getIdOtordenservicio() {
        return IdOtordenservicio;
    }

    public void setIdOtordenservicio(int IdOtordenservicio) {
        this.IdOtordenservicio = IdOtordenservicio;
    }

    public String getFechaIni() {
        return FechaIni;
    }

    public void setFechaIni(String FechaIni) {
        this.FechaIni = FechaIni;
    }

    public String getFechaEntre() {
        return FechaEntre;
    }

    public void setFechaEntre(String FechaEntre) {
        this.FechaEntre = FechaEntre;
    }

    public String getProyect() {
        return proyect;
    }

    public void setProyect(String proyect) {
        this.proyect = proyect;
    }

    public String getNomClien() {
        return nomClien;
    }

    public void setNomClien(String nomClien) {
        this.nomClien = nomClien;
    }

    public String getPriApell() {
        return priApell;
    }

    public void setPriApell(String priApell) {
        this.priApell = priApell;
    }

    public String getSegApell() {
        return segApell;
    }

    public void setSegApell(String segApell) {
        this.segApell = segApell;
    }

    public String getJustifiOt() {
        return JustifiOt;
    }

    public void setJustifiOt(String JustifiOt) {
        this.JustifiOt = JustifiOt;
    }

    public String getEstadoOT() {
        return EstadoOT;
    }

    public void setEstadoOT(String EstadoOT) {
        this.EstadoOT = EstadoOT;
    }

   
    
}
