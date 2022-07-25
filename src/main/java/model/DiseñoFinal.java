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
@Named(value = "diseñoFinal")
@SessionScoped
public class DiseñoFinal implements Serializable {

    private int IdDiseFinal;
    private int IdOrdenSer;
    private String NombreArc;

    public DiseñoFinal(int IdDiseFinal, int IdOrdenSer, String NombreArc) {
        this.IdDiseFinal = IdDiseFinal;
        this.IdOrdenSer = IdOrdenSer;
        this.NombreArc = NombreArc;
    }

    public int getIdDiseFinal() {
        return IdDiseFinal;
    }

    public void setIdDiseFinal(int IdDiseFinal) {
        this.IdDiseFinal = IdDiseFinal;
    }

    public int getIdOrdenSer() {
        return IdOrdenSer;
    }

    public void setIdOrdenSer(int IdOrdenSer) {
        this.IdOrdenSer = IdOrdenSer;
    }

    public String getNombreArc() {
        return NombreArc;
    }

    public void setNombreArc(String NombreArc) {
        this.NombreArc = NombreArc;
    }

    public DiseñoFinal() {

    }
}
