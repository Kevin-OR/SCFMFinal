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
@Named(value = "personal")
@SessionScoped
public class personal implements Serializable {

    private int idPersona;
    private String nombrePerso;
    private String priApellidoPerso;
    private String segApellidoPerso;
    private int Telefono;
    private String CorreoPerso;
    private double salario;
    private int idTipocedula;
    private String NomUsuario;
    private String Clave;
    private int idRol;
    private String estado;

    public personal(int idPersona, String nombrePerso, String priApellidoPerso, String segApellidoPerso, String estado) {
        this.idPersona = idPersona;
        this.nombrePerso = nombrePerso;
        this.priApellidoPerso = priApellidoPerso;
        this.segApellidoPerso = segApellidoPerso;
        this.estado = estado;
    }
    
    

    public personal(int idPersona, String nombrePerso, String priApellidoPerso, String segApellidoPerso, int Telefono, String CorreoPerso, double salario, int idTipocedula, String NomUsuario, String Clave, int idRol) {
        this.idPersona = idPersona;
        this.nombrePerso = nombrePerso;
        this.priApellidoPerso = priApellidoPerso;
        this.segApellidoPerso = segApellidoPerso;
        this.Telefono = Telefono;
        this.CorreoPerso = CorreoPerso;
        this.salario = salario;
        this.idTipocedula = idTipocedula;
        this.NomUsuario = NomUsuario;
        this.Clave = Clave;
        this.idRol = idRol;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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

    public String getSegApellidoPerso() {
        return segApellidoPerso;
    }

    public void setSegApellidoPerso(String segApellidoPerso) {
        this.segApellidoPerso = segApellidoPerso;
    }

    public int getTelefono() {
        return Telefono;
    }

    public void setTelefono(int Telefono) {
        this.Telefono = Telefono;
    }

    public String getCorreoPerso() {
        return CorreoPerso;
    }

    public void setCorreoPerso(String CorreoPerso) {
        this.CorreoPerso = CorreoPerso;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getIdTipocedula() {
        return idTipocedula;
    }

    public void setIdTipocedula(int idTipocedula) {
        this.idTipocedula = idTipocedula;
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

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public personal() {

    }

}
