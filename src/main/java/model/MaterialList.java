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
@Named(value = "materialList")
@SessionScoped
public class MaterialList implements Serializable {

    private int IdMateList;
    private int IdMaterial;
    private int IdSoliServ;
    private int CantOcupar;
    private String Material;

    public MaterialList(int IdMateList, int IdMaterial, int IdSoliServ, int CantOcupar, String Material) {
        this.IdMateList = IdMateList;
        this.IdMaterial = IdMaterial;
        this.IdSoliServ = IdSoliServ;
        this.CantOcupar = CantOcupar;
        this.Material = Material;
    }

    public int getIdMateList() {
        return IdMateList;
    }

    public void setIdMateList(int IdMateList) {
        this.IdMateList = IdMateList;
    }

    public int getIdMaterial() {
        return IdMaterial;
    }

    public void setIdMaterial(int IdMaterial) {
        this.IdMaterial = IdMaterial;
    }

    public int getIdSoliServ() {
        return IdSoliServ;
    }

    public void setIdSoliServ(int IdSoliServ) {
        this.IdSoliServ = IdSoliServ;
    }

    public int getCantOcupar() {
        return CantOcupar;
    }

    public void setCantOcupar(int CantOcupar) {
        this.CantOcupar = CantOcupar;
    }

    public String getMaterial() {
        return Material;
    }

    public void setMaterial(String Material) {
        this.Material = Material;
    }

    public MaterialList() {

    }

}
