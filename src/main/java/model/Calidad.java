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
 * @author emily
 */
@Named(value = "calidad")
@SessionScoped
public class Calidad implements Serializable {
    private int IdCalidadCli;
    private int IdCalidadEm;
    private int IdOt;
    private int IdSoliServ;
    private int EncarCli;
    private int EncarEm;
    private String EstadoCli;
    private String EstadoEm;
    private String JustifiCli;
    private String JustifiEm;
    private String Proyecto;
    private String NotasMue;
    private String NotasDise;
    private String DisenoCli;
    private String NotasMedi;
    private String NotasElem;
    private String UrlCC;
    private String UrlCE;
    


    public Calidad() {
    }

    public Calidad(int IdCalidadCli, int IdCalidadEm, int IdOt, int IdSoliServ, int EncarCli, int EncarEm, String EstadoCli, String EstadoEm, String JustifiCli, String JustifiEm) {
        this.IdCalidadCli = IdCalidadCli;
        this.IdCalidadEm = IdCalidadEm;
        this.IdOt = IdOt;
        this.IdSoliServ = IdSoliServ;
        this.EncarCli = EncarCli;
        this.EncarEm = EncarEm;
        this.EstadoCli = EstadoCli;
        this.EstadoEm = EstadoEm;
        this.JustifiCli = JustifiCli;
        this.JustifiEm = JustifiEm;
    }

    public Calidad(int IdSoliServ, String Proyecto, String NotasMue, String NotasDise, String DisenoCli, String NotasMedi, String NotasElem) {
        this.IdSoliServ = IdSoliServ;
        this.Proyecto = Proyecto;
        this.NotasMue = NotasMue;
        this.NotasDise = NotasDise;
        this.DisenoCli = DisenoCli;
        this.NotasMedi = NotasMedi;
        this.NotasElem = NotasElem;
    }

    public Calidad(int IdCalidadCli, int IdCalidadEm, int IdOt, int IdSoliServ, int EncarCli, int EncarEm, String EstadoCli, String EstadoEm, String JustifiCli, String JustifiEm, String UrlCC, String UrlCE) {
        this.IdCalidadCli = IdCalidadCli;
        this.IdCalidadEm = IdCalidadEm;
        this.IdOt = IdOt;
        this.IdSoliServ = IdSoliServ;
        this.EncarCli = EncarCli;
        this.EncarEm = EncarEm;
        this.EstadoCli = EstadoCli;
        this.EstadoEm = EstadoEm;
        this.JustifiCli = JustifiCli;
        this.JustifiEm = JustifiEm;
        this.UrlCC = UrlCC;
        this.UrlCE = UrlCE;
    }


    public int getIdCalidadCli() {
        return IdCalidadCli;
    }

    public void setIdCalidadCli(int IdCalidadCli) {
        this.IdCalidadCli = IdCalidadCli;
    }

    public int getIdCalidadEm() {
        return IdCalidadEm;
    }

    public void setIdCalidadEm(int IdCalidadEm) {
        this.IdCalidadEm = IdCalidadEm;
    }

    public int getIdOt() {
        return IdOt;
    }

    public void setIdOt(int IdOt) {
        this.IdOt = IdOt;
    }

    public int getIdSoliServ() {
        return IdSoliServ;
    }

    public void setIdSoliServ(int IdSoliServ) {
        this.IdSoliServ = IdSoliServ;
    }

    public int getEncarCli() {
        return EncarCli;
    }

    public void setEncarCli(int EncarCli) {
        this.EncarCli = EncarCli;
    }

    public int getEncarEm() {
        return EncarEm;
    }

    public void setEncarEm(int EncarEm) {
        this.EncarEm = EncarEm;
    }


    public String getEstadoCli() {
        return EstadoCli;
    }

    public void setEstadoCli(String EstadoCli) {
        this.EstadoCli = EstadoCli;
    }

    public String getEstadoEm() {
        return EstadoEm;
    }

    public void setEstadoEm(String EstadoEm) {
        this.EstadoEm = EstadoEm;
    }

    public String getJustifiCli() {
        return JustifiCli;
    }

    public void setJustifiCli(String JustifiCli) {
        this.JustifiCli = JustifiCli;
    }

    public String getJustifiEm() {
        return JustifiEm;
    }

    public void setJustifiEm(String JustifiEm) {
        this.JustifiEm = JustifiEm;
    }

    public String getProyecto() {
        return Proyecto;
    }

    public void setProyecto(String Proyecto) {
        this.Proyecto = Proyecto;
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

    public String getUrlCC() {
        return UrlCC;
    }

    public void setUrlCC(String UrlCC) {
        this.UrlCC = UrlCC;
    }

    public String getUrlCE() {
        return UrlCE;
    }

    public void setUrlCE(String UrlCE) {
        this.UrlCE = UrlCE;
    }

    
    
}
