/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;


import java.io.Serializable;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import model.personal.personal;

/**
 *
 * @author KevinOcampo
 */
@Named
@ViewScoped
public class PlantillaController implements Serializable{
    public void verifiSesion(){
    try{
        personal us=(personal) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("USU");
        if(us ==null){
             FacesContext.getCurrentInstance().getExternalContext().redirect("/SCFM/faces/index.xhtml");
        }
    }catch(Exception e){
        
    }
    
    }
    
}
