/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KevinOcampo
 */
public class rolGestion {

    private static final String SQL_SELECT_Rol = "SELECT * FROM rol";

    public static ArrayList<rol> getRoles() {
        ArrayList<rol> lista = new ArrayList<>();
        try {
            PreparedStatement consulta = Conexion.getConexion()
                    .prepareStatement(SQL_SELECT_Rol);
            ResultSet datos = consulta.executeQuery();
            while (datos != null && datos.next()) {
                lista.add(new rol(
                        datos.getInt(1),
                        datos.getString(2)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(rolGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

}
