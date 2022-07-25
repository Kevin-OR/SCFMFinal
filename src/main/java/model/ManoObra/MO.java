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
@Named(value = "MO")
@SessionScoped
public class MO implements Serializable{
    private int IdMO;
    private int IdOt;
    private int IdPersonal;
    private int HorasNor;
    private int HorasExtra;
    private int HorasDobExtra;

    public MO() {
    }

    public MO(int IdMO, int IdOt, int IdPersonal, int HorasNor, int HorasExtra, int HorasDobExtra) {
        this.IdMO = IdMO;
        this.IdOt = IdOt;
        this.IdPersonal = IdPersonal;
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

    public int getIdOt() {
        return IdOt;
    }

    public void setIdOt(int IdOt) {
        this.IdOt = IdOt;
    }

    public int getIdPersonal() {
        return IdPersonal;
    }

    public void setIdPersonal(int IdPersonal) {
        this.IdPersonal = IdPersonal;
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
