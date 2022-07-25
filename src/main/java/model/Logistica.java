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
@Named(value = "logistica")
@SessionScoped
public class Logistica implements Serializable{
    
    private int IdOt;
    private String Direccion;
    private String EvidenciaInsta;
    private int IdSoliServ;

    public Logistica(int IdOt, String Direccion, String EvidenciaInsta, int IdSoliServ) {
        this.IdOt = IdOt;
        this.Direccion = Direccion;
        this.EvidenciaInsta = EvidenciaInsta;
        this.IdSoliServ = IdSoliServ;
    }

    public int getIdOt() {
        return IdOt;
    }

    public void setIdOt(int IdOt) {
        this.IdOt = IdOt;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getEvidenciaInsta() {
        return EvidenciaInsta;
    }

    public void setEvidenciaInsta(String EvidenciaInsta) {
        this.EvidenciaInsta = EvidenciaInsta;
    }

    public int getIdSoliServ() {
        return IdSoliServ;
    }

    public void setIdSoliServ(int IdSoliServ) {
        this.IdSoliServ = IdSoliServ;
    }

    

    public Logistica() {
    }
   
    
    
}
