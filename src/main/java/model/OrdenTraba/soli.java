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

@Named(value = "soli")
@SessionScoped


public class soli implements Serializable{
    private int IdSoli;

    public soli() {
    }

    public soli(int IdSoli) {
        this.IdSoli = IdSoli;
    }
    
    

    public int getIdSoli() {
        return IdSoli;
    }

    public void setIdSoli(int IdSoli) {
        this.IdSoli = IdSoli;
    }

    
    
    
    
    
}
