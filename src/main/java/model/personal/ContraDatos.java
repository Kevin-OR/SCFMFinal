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
@Named(value = "ContraDatos")
@SessionScoped
public class ContraDatos implements Serializable{
    private String Correo;
    private String Clave;
    

    public ContraDatos(String Correo, String Clave) {
        this.Correo = Correo;
        this.Clave = Clave;
    }

    public ContraDatos(String Clave) {
        this.Clave = Clave;
    }
    
   

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getClave() {
        return Clave;
    }

    public void setClave(String Clave) {
        this.Clave = Clave;
    }

    public ContraDatos() {
    }
    
    
    
    
}
