/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.material;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author KevinOcampo
 */
@Named(value = "materiales")
@SessionScoped
public class materiales implements Serializable {

    private int idMaterial;
    private String nomMaterial;
    private int precioMaterial;
    private int cantMaterial;

    public materiales(int idMaterial, String nomMaterial, int precioMaterial, int cantMaterial) {
        this.idMaterial = idMaterial;
        this.nomMaterial = nomMaterial;
        this.precioMaterial = precioMaterial;
        this.cantMaterial = cantMaterial;
    }

    public int getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(int idMaterial) {
        this.idMaterial = idMaterial;
    }

    public String getNomMaterial() {
        return nomMaterial;
    }

    public void setNomMaterial(String nomMaterial) {
        this.nomMaterial = nomMaterial;
    }

    public int getPrecioMaterial() {
        return precioMaterial;
    }

    public void setPrecioMaterial(int precioMaterial) {
        this.precioMaterial = precioMaterial;
    }

    

    public int getCantMaterial() {
        return cantMaterial;
    }

    public void setCantMaterial(int cantMaterial) {
        this.cantMaterial = cantMaterial;
    }

    public materiales() {
    }

}
