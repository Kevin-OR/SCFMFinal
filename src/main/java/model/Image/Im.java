/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.Image;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;


/**
 *
 * @author KevinOcampo
 */
@Named(value = "Im")
@SessionScoped
public class Im implements Serializable{
    
    private int idIm;
    private int IdSoliServ;
    private int IdOt;
    private String url;

    public Im(int idIm) {
        this.idIm = idIm;
    }

    
    public Im() {
    }

    public Im(int idIm, String url) {
        this.idIm = idIm;
        this.url = url;
    }

    public int getIdIm() {
        return idIm;
    }

    public void setIdIm(int idIm) {
        this.idIm = idIm;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    


    
    

    
}
