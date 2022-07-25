/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.espacioDao;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import model.espacio;

/**
 *
 * @author emily
 */
@Named(value = "espacioController")
@SessionScoped
public class espacioController extends espacio implements Serializable {

    public espacioController() {
    }

    public List<espacio> getEspacios() {
        return espacioDao.getEspacios();
    }
}
