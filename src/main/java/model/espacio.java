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
@Named(value = "espacio")
@SessionScoped
public class espacio implements Serializable {

    private int IdEspacio;
    private String Espacio;

    public espacio(int IdEspacio, String Espacio) {
        this.IdEspacio = IdEspacio;
        this.Espacio = Espacio;
    }

    public int getIdEspacio() {
        return IdEspacio;
    }

    public void setIdEspacio(int IdEspacio) {
        this.IdEspacio = IdEspacio;
    }

    public String getEspacio() {
        return Espacio;
    }

    public void setEspacio(String Espacio) {
        this.Espacio = Espacio;
    }

    public espacio() {

    }
}
