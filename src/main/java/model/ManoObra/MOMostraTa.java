/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.ManoObra;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author KevinOcampo
 */
@Named(value = "MOMostraTa")
@SessionScoped
public class MOMostraTa implements Serializable{
    private int IdMO;
    private int IdPersonal;
    private String nombrePerso;
    private String priApellidoPerso;
    private String segApellidoPerso;
    private int HorasNor;
    private int HorasExtra;
    private int HorasDobExtra;

    public MOMostraTa() {
    }

    public MOMostraTa(int IdMO, int IdPersonal, String nombrePerso, String priApellidoPerso, String segApellidoPerso, int HorasNor, int HorasExtra, int HorasDobExtra) {
        this.IdMO = IdMO;
        this.IdPersonal = IdPersonal;
        this.nombrePerso = nombrePerso;
        this.priApellidoPerso = priApellidoPerso;
        this.segApellidoPerso = segApellidoPerso;
        this.HorasNor = HorasNor;
        this.HorasExtra = HorasExtra;
        this.HorasDobExtra = HorasDobExtra;
    }

    
    public int getIdMO() {
        return IdMO;
    }

    public void setIdMO(int IdMO) {
        this.IdMO = IdMO;
    }

    public int getIdPersonal() {
        return IdPersonal;
    }

    public void setIdPersonal(int IdPersonal) {
        this.IdPersonal = IdPersonal;
    }

    public String getNombrePerso() {
        return nombrePerso;
    }

    public void setNombrePerso(String nombrePerso) {
        this.nombrePerso = nombrePerso;
    }

    public String getPriApellidoPerso() {
        return priApellidoPerso;
    }

    public void setPriApellidoPerso(String priApellidoPerso) {
        this.priApellidoPerso = priApellidoPerso;
    }

    public String getSegApellidoPerso() {
        return segApellidoPerso;
    }

    public void setSegApellidoPerso(String segApellidoPerso) {
        this.segApellidoPerso = segApellidoPerso;
    }

    public int getHorasNor() {
        return HorasNor;
    }

    public void setHorasNor(int HorasNor) {
        this.HorasNor = HorasNor;
    }

    public int getHorasExtra() {
        return HorasExtra;
    }

    public void setHorasExtra(int HorasExtra) {
        this.HorasExtra = HorasExtra;
    }

    public int getHorasDobExtra() {
        return HorasDobExtra;
    }

    public void setHorasDobExtra(int HorasDobExtra) {
        this.HorasDobExtra = HorasDobExtra;
    }

    
    
}
