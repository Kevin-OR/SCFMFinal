/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Conexion;
import model.espacio;

/**
 *
 * @author emily
 */
public class espacioDao {

    private static final String SQL_SELECT_ESPACIO
            = "SELECT * FROM espacio";

    public static ArrayList<espacio> getEspacios() {
        ArrayList<espacio> lista = new ArrayList<>();
        try {
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(SQL_SELECT_ESPACIO);
            ResultSet datos = consulta.executeQuery();
            while (datos != null && datos.next()) {
                lista.add(new espacio(
                        datos.getInt(1),
                        datos.getString(2)));
            }
        } catch (SQLException e) {
            Logger.getLogger(OrdenSerDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return lista;
    }
}
