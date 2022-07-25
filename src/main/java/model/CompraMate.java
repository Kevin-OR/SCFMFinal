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
 * @author emily
 */
@Named(value = "compraMate")
@SessionScoped
public class CompraMate implements Serializable {
    private int IdMateCompra;
    private int IdOt;
    private int IdMaterial;
    private int CantiCompra;
    private String Material;

    public CompraMate() {
    }

    public CompraMate(int IdMateCompra, int IdOt, int IdMaterial, int CantiCompra, String Material) {
        this.IdMateCompra = IdMateCompra;
        this.IdOt = IdOt;
        this.IdMaterial = IdMaterial;
        this.CantiCompra = CantiCompra;
        this.Material = Material;
    }

    public int getIdMateCompra() {
        return IdMateCompra;
    }

    public void setIdMateCompra(int IdMateCompra) {
        this.IdMateCompra = IdMateCompra;
    }

    public int getIdOt() {
        return IdOt;
    }

    public void setIdOt(int IdOt) {
        this.IdOt = IdOt;
    }

    public int getIdMaterial() {
        return IdMaterial;
    }

    public void setIdMaterial(int IdMaterial) {
        this.IdMaterial = IdMaterial;
    }

    public int getCantiCompra() {
        return CantiCompra;
    }

    public void setCantiCompra(int CantiCompra) {
        this.CantiCompra = CantiCompra;
    }

    public String getMaterial() {
        return Material;
    }

    public void setMaterial(String Material) {
        this.Material = Material;
    }

    
    
    
    
    
    
    
}
