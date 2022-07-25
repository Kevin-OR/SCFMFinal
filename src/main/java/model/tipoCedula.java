/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author KevinOcampo
 */
@Named(value = "tipoCedula")
@SessionScoped
public class tipoCedula implements Serializable {

    private int idTipoCedula;
    private String tipoCedula;

    public tipoCedula(int idTipoCedula, String tipoCedula) {
        this.idTipoCedula = idTipoCedula;
        this.tipoCedula = tipoCedula;
    }

    public int getIdTipoCedula() {
        return idTipoCedula;
    }

    public void setIdTipoCedula(int idTipoCedula) {
        this.idTipoCedula = idTipoCedula;
    }

    public String getTipoCedula() {
        return tipoCedula;
    }

    public void setTipoCedula(String tipoCedula) {
        this.tipoCedula = tipoCedula;
    }

    public tipoCedula() {
    }

}
