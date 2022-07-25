/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.personal;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author KevinOcampo
 */
@Named(value = "TablaPersonal")
@SessionScoped
public class TablaPersonal implements Serializable {

    private int idPersona;
    private String nombrePerso;
    private String priApellidoPerso;
    private double salario;
    private String Rol;

    public TablaPersonal(int idPersona, String nombrePerso, String priApellidoPerso, double salario, String Rol) {
        this.idPersona = idPersona;
        this.nombrePerso = nombrePerso;
        this.priApellidoPerso = priApellidoPerso;
        this.salario = salario;
        this.Rol = Rol;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombrePerso() {
        return nombrePerso;
    }

    public void setNombrePerso(String nombrePerso) {
        this.nombrePerso = nombrePerso;
    }

    public String getPriApellidoPerso() {
        return priApellidoPerso;
    }

    public void setPriApellidoPerso(String priApellidoPerso) {
        this.priApellidoPerso = priApellidoPerso;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getRol() {
        return Rol;
    }

    public void setRol(String Rol) {
        this.Rol = Rol;
    }

    public TablaPersonal() {
    }

}
