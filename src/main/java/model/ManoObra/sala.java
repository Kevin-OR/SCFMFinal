/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.ManoObra;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author KevinOcampo
 */
@Named(value = "sala")
@SessionScoped
public class sala implements Serializable{
    private int norm;
    private int extra;
    private int dobExtr;
    private double sala;
    private double total;

    public sala() {
    }

    public sala(int norm, int extra, int dobExtr, double sala, double total) {
        this.norm = norm;
        this.extra = extra;
        this.dobExtr = dobExtr;
        this.sala = sala;
        this.total = total;
    }

    public int getNorm() {
        return norm;
    }

    public void setNorm(int norm) {
        this.norm = norm;
    }

    public int getExtra() {
        return extra;
    }

    public void setExtra(int extra) {
        this.extra = extra;
    }

    public int getDobExtr() {
        return dobExtr;
    }

    public void setDobExtr(int dobExtr) {
        this.dobExtr = dobExtr;
    }

    public double getSala() {
        return sala;
    }

    public void setSala(double sala) {
        this.sala = sala;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    
    
}
