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
@Named(value = "soliServicio")
@SessionScoped
public class SoliServ implements Serializable {

    private int IdSoliServ;
    private String NombClient;
    private String PriApeClient;
    private String SegApeClient;
    private String Proyecto;
    private int IdTipoCedu;
    private int Cedula;
    private int Telefono;
    private String Direccion;
    private String NotasMue;
    private String NotasDise;
    private String DisenoCli;
    private String NotasMedi;
    private String NotasElem;
    private String Justifiss;
    private String Url;
    private int IdM;
    private String ClasifiSS;

    public SoliServ() {
    }
    
    public SoliServ(int IdSoliServ) {
        this.IdSoliServ = IdSoliServ;
    }

    public SoliServ(int IdSoliServ, String NombClient, String PriApeClient, String SegApeClient, String Proyecto) {
        this.IdSoliServ = IdSoliServ;
        this.NombClient = NombClient;
        this.PriApeClient = PriApeClient;
        this.SegApeClient = SegApeClient;
        this.Proyecto = Proyecto;
    }
    
    

    public SoliServ(int IdSoliServ, String NombClient, String PriApeClient, String SegApeClient, String Proyecto, int IdTipoCedu, int Cedula, int Telefono, String Direccion, String NotasMue, String NotasDise, String DisenoCli, String NotasMedi, String NotasElem, String Justifiss, String ClasifiSS ) {
        this.IdSoliServ = IdSoliServ;
        this.NombClient = NombClient;
        this.PriApeClient = PriApeClient;
        this.SegApeClient = SegApeClient;
        this.Proyecto = Proyecto;
        this.IdTipoCedu = IdTipoCedu;
        this.Cedula = Cedula;
        this.Telefono = Telefono;
        this.Direccion = Direccion;
        this.NotasMue = NotasMue;
        this.NotasDise = NotasDise;
        this.DisenoCli = DisenoCli;
        this.NotasMedi = NotasMedi;
        this.NotasElem = NotasElem;
        this.Justifiss = Justifiss;
        this.ClasifiSS = ClasifiSS;
    }

    public SoliServ(int IdSoliServ, String Url, int IdM) {
        this.IdSoliServ = IdSoliServ;
        this.Url = Url;
        this.IdM = IdM;
    }
    
    

    public String getUrl() {
        return Url;
    }

    public void setUrl(String Url) {
        this.Url = Url;
    }
    

    public int getIdSoliServ() {
        return IdSoliServ;
    }

    public void setIdSoliServ(int IdSoliServ) {
        this.IdSoliServ = IdSoliServ;
    }

    public String getNombClient() {
        return NombClient;
    }

    public void setNombClient(String NombClient) {
        this.NombClient = NombClient;
    }

    public String getPriApeClient() {
        return PriApeClient;
    }

    public void setPriApeClient(String PriApeClient) {
        this.PriApeClient = PriApeClient;
    }

    public String getSegApeClient() {
        return SegApeClient;
    }

    public void setSegApeClient(String SegApeClient) {
        this.SegApeClient = SegApeClient;
    }

    public String getProyecto() {
        return Proyecto;
    }

    public void setProyecto(String Proyecto) {
        this.Proyecto = Proyecto;
    }

    public int getIdTipoCedu() {
        return IdTipoCedu;
    }

    public void setIdTipoCedu(int IdTipoCedu) {
        this.IdTipoCedu = IdTipoCedu;
    }

    public int getCedula() {
        return Cedula;
    }

    public void setCedula(int Cedula) {
        this.Cedula = Cedula;
    }

    public int getTelefono() {
        return Telefono;
    }

    public void setTelefono(int Telefono) {
        this.Telefono = Telefono;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getNotasMue() {
        return NotasMue;
    }

    public void setNotasMue(String NotasMue) {
        this.NotasMue = NotasMue;
    }

    public String getNotasDise() {
        return NotasDise;
    }

    public void setNotasDise(String NotasDise) {
        this.NotasDise = NotasDise;
    }

    public String getDisenoCli() {
        return DisenoCli;
    }

    public void setDisenoCli(String DisenoCli) {
        this.DisenoCli = DisenoCli;
    }

    public String getNotasMedi() {
        return NotasMedi;
    }

    public void setNotasMedi(String NotasMedi) {
        this.NotasMedi = NotasMedi;
    }

    public String getNotasElem() {
        return NotasElem;
    }

    public void setNotasElem(String NotasElem) {
        this.NotasElem = NotasElem;
    }

    public String getJustifiss() {
        return Justifiss;
    }

    public void setJustifiss(String Justifiss) {
        this.Justifiss = Justifiss;
    }

    public int getIdM() {
        return IdM;
    }

    public void setIdM(int IdM) {
        this.IdM = IdM;
    }

    public String getClasifiSS() {
        return ClasifiSS;
    }

    public void setClasifiSS(String ClasifiSS) {
        this.ClasifiSS = ClasifiSS;
    }

    
}