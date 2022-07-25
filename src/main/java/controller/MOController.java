/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import model.ManoObra.MO;
import model.ManoObra.MOGestion;
import model.ManoObra.MOMostraTa;

/**
 *
 * @author KevinOcampo
 */
@Named(value = "MOController")
@SessionScoped
public class MOController extends MO implements Serializable {

   
    public String ponerOT(int id) {

        this.setIdOt(id);
        this.setIdPersonal(0);
        this.setHorasNor(0);
        this.setHorasExtra(0);
        this.setHorasDobExtra(0);
        return "RegistroManObra.xhtml";
    }
    
    public String ponerOT2(int id) {

        this.setIdOt(id);
        this.setIdPersonal(0);
        this.setHorasNor(0);
        this.setHorasExtra(0);
        this.setHorasDobExtra(0);
        return "CalcularSalario.xhtml";
    }

    public String salir() {

        this.setIdOt(0);
        this.setIdPersonal(0);
        this.setHorasNor(0);
        this.setHorasExtra(0);
        this.setHorasDobExtra(0);
        return "ManodeObra.xhtml";
    }

    public List<MOMostraTa> getMOTa() {
        return MOGestion.getMOTa(this.getIdOt());
    }

    public String elimina(int id) throws IOException {
        if (MOGestion.eliminar(id)) {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/SCFM/faces/produccion/RegistroManObra.xhtml");
            return "RegistroManObra.xhtml";
        } else {
            FacesMessage mensaje = new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, "Error",
                    "Posiblemente el id no existe");
            FacesContext.getCurrentInstance().addMessage(
                    "editaCanchaForm:identificacion",
                    mensaje);
            return "RegistroManObra.xhtml";
        }
    }

    public String nuevoMO() throws IOException {

        MOGestion mogestion = new MOGestion();
        mogestion.inserMO(this);
        FacesContext.getCurrentInstance().getExternalContext().redirect("/SCFM/faces/produccion/RegistroManObra.xhtml");
        return "RegistroManObra.xhtml";

    }

    public String edita(int idM) {
        MO mo
                = MOGestion.getMO(idM);
        if (mo != null) {
            this.setIdMO(mo.getIdMO());
            this.setIdOt(mo.getIdOt());
            this.setIdPersonal(mo.getIdPersonal());
            this.setHorasNor(mo.getHorasNor());
            this.setHorasExtra(mo.getHorasExtra());
            this.setHorasDobExtra(mo.getHorasDobExtra());

            return "EditarMO.xhtml";
        } else {
            return "RegistroManObra.xhtml";
        }
    }
    
    
    public String calcular(int idM) throws IOException {
        MO mos
                = MOGestion.getMO(idM);
        if (mos != null) {
            this.setIdMO(mos.getIdMO());
            this.setIdOt(mos.getIdOt());
            this.setIdPersonal(mos.getIdPersonal());
            this.setHorasNor(mos.getHorasNor());
            this.setHorasExtra(mos.getHorasExtra());
            this.setHorasDobExtra(mos.getHorasDobExtra());

            
            FacesContext.getCurrentInstance().getExternalContext().redirect("/SCFM/faces/produccion/CALcuMO.xhtml");
            return "CALcuMO.xhtml";
        } else {
            return "RegistroManObra.xhtml";
        }
    }
    
    

    public String modifica() {
        MOGestion.modificar(this);
        this.setIdPersonal(0);
        this.setHorasNor(0);
        this.setHorasExtra(0);
        this.setHorasDobExtra(0);
        return "RegistroManObra.xhtml";
    }
    
    public String vacia(){
        this.setIdPersonal(0);
        this.setHorasNor(0);
        this.setHorasExtra(0);
        this.setHorasDobExtra(0);
        return "MOController";
    }
    
}
