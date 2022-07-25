/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author emily
 */
public class Cronograma {
    private int IdCrono;
    private int IdOt;
    private int CronoGuardado;
    private int CronoFinal;

    public Cronograma(int IdCrono, int IdOt, int CronoGuardado, int CronoFinal) {
        this.IdCrono = IdCrono;
        this.IdOt = IdOt;
        this.CronoGuardado = CronoGuardado;
        this.CronoFinal = CronoFinal;
    }

    public int getIdCrono() {
        return IdCrono;
    }

    public void setIdCrono(int IdCrono) {
        this.IdCrono = IdCrono;
    }

    public int getIdOt() {
        return IdOt;
    }

    public void setIdOt(int IdOt) {
        this.IdOt = IdOt;
    }

    public int getCronoGuardado() {
        return CronoGuardado;
    }

    public void setCronoGuardado(int CronoGuardado) {
        this.CronoGuardado = CronoGuardado;
    }

    public int getCronoFinal() {
        return CronoFinal;
    }

    public void setCronoFinal(int CronoFinal) {
        this.CronoFinal = CronoFinal;
    }

    public Cronograma() {
    }
    
    
}
