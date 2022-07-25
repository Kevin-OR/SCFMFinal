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
@Named(value = "especiOT")
@SessionScoped
public class EspecificacionOT implements Serializable{
    private int IdEspe;
    private int IdOt;
    private String NomEspe;
    private String TipoEspe;
    private String DescrEspe;
    private String NotasEspe;
    private String EstadoES;

    public EspecificacionOT() {
    }

    public EspecificacionOT(int IdEspe, int IdOt, String NomEspe, String TipoEspe, String DescrEspe, String NotasEspe, String EstadoES) {
        this.IdEspe = IdEspe;
        this.IdOt = IdOt;
        this.NomEspe = NomEspe;
        this.TipoEspe = TipoEspe;
        this.DescrEspe = DescrEspe;
        this.NotasEspe = NotasEspe;
        this.EstadoES = EstadoES;
    }

    public int getIdEspe() {
        return IdEspe;
    }

    public void setIdEspe(int IdEspe) {
        this.IdEspe = IdEspe;
    }

    public int getIdOt() {
        return IdOt;
    }

    public void setIdOt(int IdOt) {
        this.IdOt = IdOt;
    }

    public String getNomEspe() {
        return NomEspe;
    }

    public void setNomEspe(String NomEspe) {
        this.NomEspe = NomEspe;
    }

    public String getTipoEspe() {
        return TipoEspe;
    }

    public void setTipoEspe(String TipoEspe) {
        this.TipoEspe = TipoEspe;
    }

    public String getDescrEspe() {
        return DescrEspe;
    }

    public void setDescrEspe(String DescrEspe) {
        this.DescrEspe = DescrEspe;
    }

    public String getNotasEspe() {
        return NotasEspe;
    }

    public void setNotasEspe(String NotasEspe) {
        this.NotasEspe = NotasEspe;
    }

    public String getEstadoES() {
        return EstadoES;
    }

    public void setEstadoES(String EstadoES) {
        this.EstadoES = EstadoES;
    }

    
    
}