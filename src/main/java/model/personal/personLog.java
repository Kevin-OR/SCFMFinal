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
@Named(value = "personLog")
@SessionScoped
public class personLog implements Serializable {

    private String NomUsuario;
    private String Clave;
    private String nombrePerso;
    private String priApellido;
    private String segApellido;
    private int idRol;

    public personLog(String NomUsuario, String Clave, String nombrePerso, String priApellido, String segApellido, int idRol) {
        this.NomUsuario = NomUsuario;
        this.Clave = Clave;
        this.nombrePerso = nombrePerso;
        this.priApellido = priApellido;
        this.segApellido = segApellido;
        this.idRol = idRol;
    }

    
    public String getNomUsuario() {
        return NomUsuario;
    }

    public void setNomUsuario(String NomUsuario) {
        this.NomUsuario = NomUsuario;
    }

    public String getClave() {
        return Clave;
    }

    public void setClave(String Clave) {
        this.Clave = Clave;
    }

    public String getNombrePerso() {
        return nombrePerso;
    }

    public void setNombrePerso(String nombrePerso) {
        this.nombrePerso = nombrePerso;
    }

    public String getPriApellido() {
        return priApellido;
    }

    public void setPriApellido(String priApellido) {
        this.priApellido = priApellido;
    }

    public String getSegApellido() {
        return segApellido;
    }

    public void setSegApellido(String segApellido) {
        this.segApellido = segApellido;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

   

    public personLog() {
    }

}
