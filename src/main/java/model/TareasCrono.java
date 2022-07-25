/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Asus
 */
public class TareasCrono {
    private int IdTareaC;
    private int IdOt;
    private String NomTarea;
    private String FechaFin;
    private int IdPersonal;
    private String NombreP;

    public TareasCrono(int IdTareaC, int IdOt, String NomTarea, String FechaFin, int IdPersonal, String NombreP) {
        this.IdTareaC = IdTareaC;
        this.IdOt = IdOt;
        this.NomTarea = NomTarea;
        this.FechaFin = FechaFin;
        this.IdPersonal = IdPersonal;
        this.NombreP = NombreP;
    }

    public int getIdTareaC() {
        return IdTareaC;
    }

    public void setIdTareaC(int IdTareaC) {
        this.IdTareaC = IdTareaC;
    }

    public int getIdOt() {
        return IdOt;
    }

    public void setIdOt(int IdOt) {
        this.IdOt = IdOt;
    }

    public String getNomTarea() {
        return NomTarea;
    }

    public void setNomTarea(String NomTarea) {
        this.NomTarea = NomTarea;
    }

    public String getFechaFin() {
        return FechaFin;
    }

    public void setFechaFin(String FechaFin) {
        this.FechaFin = FechaFin;
    }

    public int getIdPersonal() {
        return IdPersonal;
    }

    public void setIdPersonal(int IdPersonal) {
        this.IdPersonal = IdPersonal;
    }

    public String getNombreP() {
        return NombreP;
    }

    public void setNombreP(String NombreP) {
        this.NombreP = NombreP;
    }

    public TareasCrono(){
        
    }
}
