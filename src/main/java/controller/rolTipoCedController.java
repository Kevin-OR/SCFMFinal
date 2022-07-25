package controller;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import model.rol;
import model.rolGestion;
import model.tipoCeduGestion;
import model.tipoCedula;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author KevinOcampo
 */
@Named(value = "rolTipoCedController")
@SessionScoped
public class rolTipoCedController extends rol implements Serializable {

    public rolTipoCedController() {
    }

    public List<rol> getRoles() {
        return rolGestion.getRoles();
    }

    public List<tipoCedula> getTipoCedu() {
        return tipoCeduGestion.getTipoCedu();
    }

}
