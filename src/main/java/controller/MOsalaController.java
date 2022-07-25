/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import model.ManoObra.sala;
import model.ManoObra.salaGestion;

/**
 *
 * @author KevinOcampo
 */
@Named(value = "MOsalaController")
@SessionScoped
public class MOsalaController extends sala implements Serializable {

    public String operacion(int idM) throws IOException {
        sala sala
                = salaGestion.getMOTa(idM);
        int honor = sala.getNorm();
        int hoextra = sala.getExtra();
        int hordobextr = sala.getDobExtr();
        double presala = sala.getSala();

        double multiExtra = 1.5;
        double multidoblExtra = 2;
        double total;
        total = (presala * (honor + (hoextra * multiExtra) + (hordobextr * multidoblExtra)));
        this.setTotal(total);
        this.setSala(presala);
        FacesContext.getCurrentInstance().getExternalContext().redirect("/SCFM/faces/produccion/CALcuMO.xhtml");

        return "CALcuMO.xhtml";
    }
     public String vacisala() {
         this.setTotal(0);
         this.setSala(0);
         return "MOsalaController";
     }
}
