/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.OCmostr;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author KevinOcampo
 */
@Named(value = "TablaOC")
@SessionScoped
public class TablaOC implements Serializable{

    private int IdOt;
    private String NombClient;
    private String PriApeClient;
    private String SegApeClient;
    private String Proyecto;
    private String EstadoOt;

    public TablaOC() {
    }

    public TablaOC(int IdOt, String NombClient, String PriApeClient, String SegApeClient, String Proyecto, String EstadoOt) {
        this.IdOt = IdOt;
        this.NombClient = NombClient;
        this.PriApeClient = PriApeClient;
        this.SegApeClient = SegApeClient;
        this.Proyecto = Proyecto;
        this.EstadoOt = EstadoOt;
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
    
    
}
