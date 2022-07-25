/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.OGarantia;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author KevinOcampo
 */
@Named(value = "TablaOG")
@SessionScoped
public class TablaOG implements Serializable {
    private int IdOG;
    private String nomCliente;
    private String priCliente;
    private String segCliente;
    private String proyec;
    private String EstaGO;

    public TablaOG() {
    }

    public TablaOG(int IdOG, String nomCliente, String priCliente, String segCliente, String proyec, String EstaGO) {
        this.IdOG = IdOG;
        this.nomCliente = nomCliente;
        this.priCliente = priCliente;
        this.segCliente = segCliente;
        this.proyec = proyec;
        this.EstaGO = EstaGO;
    }

    public int getIdOG() {
        return IdOG;
    }

    public void setIdOG(int IdOG) {
        this.IdOG = IdOG;
    }

    public String getNomCliente() {
        return nomCliente;
    }

    public void setNomCliente(String nomCliente) {
        this.nomCliente = nomCliente;
    }

    public String getPriCliente() {
        return priCliente;
    }

    public void setPriCliente(String priCliente) {
        this.priCliente = priCliente;
    }

    public String getSegCliente() {
        return segCliente;
    }

    public void setSegCliente(String segCliente) {
        this.segCliente = segCliente;
    }

    public String getProyec() {
        return proyec;
    }

    public void setProyec(String proyec) {
        this.proyec = proyec;
    }

    public String getEstaGO() {
        return EstaGO;
    }

    public void setEstaGO(String EstaGO) {
        this.EstaGO = EstaGO;
    }

}
