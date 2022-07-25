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
@Named(value = "ordRepa")
@SessionScoped
public class OrdRepa implements Serializable{
    
    private int IdOrdRepa;
    private int IdOt;
    private String JustifOR;
    private int ResponOR;
    private int ModuloOR;
    private String NombClient;
    private String PriApeClient;
    private String Proyecto;
    private String Url;
    

    public OrdRepa(int IdOrdRepa, int IdOt, String JustifOR, int ResponOR, int ModuloOR, String NombClient, String PriApeClient, String Proyecto) {
        this.IdOrdRepa = IdOrdRepa;
        this.IdOt = IdOt;
        this.JustifOR = JustifOR;
        this.ResponOR = ResponOR;
        this.ModuloOR = ModuloOR;
        this.NombClient = NombClient;
        this.PriApeClient = PriApeClient;
        this.Proyecto = Proyecto;
    }

    public OrdRepa(int IdOrdRepa, int IdOt, String JustifOR, int ResponOR, int ModuloOR, String NombClient, String PriApeClient, String Proyecto, String Url) {
        this.IdOrdRepa = IdOrdRepa;
        this.IdOt = IdOt;
        this.JustifOR = JustifOR;
        this.ResponOR = ResponOR;
        this.ModuloOR = ModuloOR;
        this.NombClient = NombClient;
        this.PriApeClient = PriApeClient;
        this.Proyecto = Proyecto;
        this.Url = Url;
    }
    
    

    public int getIdOrdRepa() {
        return IdOrdRepa;
    }

    public void setIdOrdRepa(int IdOrdRepa) {
        this.IdOrdRepa = IdOrdRepa;
    }

    public int getIdOt() {
        return IdOt;
    }

    public void setIdOt(int IdOt) {
        this.IdOt = IdOt;
    }

    public String getJustifOR() {
        return JustifOR;
    }

    public void setJustifOR(String JustifOR) {
        this.JustifOR = JustifOR;
    }

    public int getResponOR() {
        return ResponOR;
    }

    public void setResponOR(int ResponOR) {
        this.ResponOR = ResponOR;
    }

    public int getModuloOR() {
        return ModuloOR;
    }

    public void setModuloOR(int ModuloOR) {
        this.ModuloOR = ModuloOR;
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

    public String getUrl() {
        return Url;
    }

    public void setUrl(String Url) {
        this.Url = Url;
    }

    
    
    public OrdRepa() {
    }
    
    
    
}
