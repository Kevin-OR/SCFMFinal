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
@Named(value = "TablaMList")
@SessionScoped
public class TablaMList implements Serializable{
    private String NomMater;
    private int CantMa;

    public TablaMList() {
    }

    public TablaMList(String NomMater, int CantMa) {
        this.NomMater = NomMater;
        this.CantMa = CantMa;
    }
    
    public String getNomMater() {
        return NomMater;
    }

    public void setNomMater(String NomMater) {
        this.NomMater = NomMater;
    }

    public int getCantMa() {
        return CantMa;
    }

    public void setCantMa(int CantMa) {
        this.CantMa = CantMa;
    }
    
    
}
