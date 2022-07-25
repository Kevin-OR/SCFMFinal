/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.ManoObra;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Conexion;

/**
 *
 * @author KevinOcampo
 */

public class salaGestion {
    
    private static final String SQL_SELECT_MOUN ="SELECT  a.HorasNor, a.HorasExtra, "
            + "a.HorasDobExtra, b.Salario, b.Salario "
            + "FROM manoobra a, "
            + "personal b WHERE a.IdPersonal= b.IdPersonal AND a.IdPersonal=?";
    
    public static sala getMOTa(int id) {
        sala sala =null;
        try {
            PreparedStatement consulta = Conexion.getConexion()
                    .prepareStatement(SQL_SELECT_MOUN);
            consulta.setInt(1, id);
            ResultSet datos = consulta.executeQuery();
            if (datos != null && datos.next()) {
                sala = new sala(
                        datos.getInt(1),
                        datos.getInt(2),
                        datos.getInt(3),
                        datos.getInt(4),
                        datos.getInt(5)
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(MOGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sala;
    }
    
}
