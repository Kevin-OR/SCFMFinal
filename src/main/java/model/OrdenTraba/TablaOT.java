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
@Named(value = "TablaOT")
@SessionScoped
public class TablaOT implements Serializable {
    private int IdSoliServ;
    private int IdOt;
    private String NombClient;
    private String PriApeClient;
    private String SegApeClient;
    private String Proyecto;
    private String EstadoOt;
    private String JustifiOt;
    private String FechaEntre;
    private String FechaFin;

    public TablaOT() {
    }

    public TablaOT(int IdSoliServ, int IdOt, String NombClient, String PriApeClient, String SegApeClient, String Proyecto, String EstadoOt, String JustifiOt) {
        this.IdSoliServ = IdSoliServ;
        this.IdOt = IdOt;
        this.NombClient = NombClient;
        this.PriApeClient = PriApeClient;
        this.SegApeClient = SegApeClient;
        this.Proyecto = Proyecto;
        this.EstadoOt = EstadoOt;
        this.JustifiOt = JustifiOt;
    }

    public TablaOT(int IdOt, String NombClient, String PriApeClient, String SegApeClient, String Proyecto, String FechaEntre, String FechaFin) {
        this.IdOt = IdOt;
        this.NombClient = NombClient;
        this.PriApeClient = PriApeClient;
        this.SegApeClient = SegApeClient;
        this.Proyecto = Proyecto;
        this.FechaEntre = FechaEntre;
        this.FechaFin = FechaFin;
    }

    public int getIdSoliServ() {
        return IdSoliServ;
    }

    public void setIdSoliServ(int IdSoliServ) {
        this.IdSoliServ = IdSoliServ;
    }

    public int getIdOt() {
        return IdOt;
    }

    public void setIdOt(int IdOt) {
        this.IdOt = IdOt;
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

    public String getSegApeClient() {
        return SegApeClient;
    }

    public void setSegApeClient(String SegApeClient) {
        this.SegApeClient = SegApeClient;
    }

    public String getProyecto() {
        return Proyecto;
    }

    public void setProyecto(String Proyecto) {
        this.Proyecto = Proyecto;
    }

    public String getEstadoOt() {
        return EstadoOt;
    }

    public void setEstadoOt(String EstadoOt) {
        this.EstadoOt = EstadoOt;
    }

    public String getJustifiOt() {
        return JustifiOt;
    }

    public void setJustifiOt(String JustifiOt) {
        this.JustifiOt = JustifiOt;
    }

    public String getFechaEntre() {
        return FechaEntre;
    }

    public void setFechaEntre(String FechaEntre) {
        this.FechaEntre = FechaEntre;
    }

    public String getFechaFin() {
        return FechaFin;
    }

    public void setFechaFin(String FechaFin) {
        this.FechaFin = FechaFin;
    }
    
    

      
}
