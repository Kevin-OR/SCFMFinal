/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.personal;

import java.util.logging.Logger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import model.Conexion;

/**
 *
 * @author KevinOcampo
 */
public class RecuperaContraGesti {
    private static final String SQL_INSERT_Clave = "SELECT Correo, Clave FROM personal WHERE Correo=?";
    
    public static ContraDatos getContraDatos(String idM) {
        ContraDatos ContraDatos = null;
        try {
            PreparedStatement consulta = Conexion.getConexion()
                    .prepareStatement(SQL_INSERT_Clave);
            consulta.setString(1, idM);
            ResultSet datos = consulta.executeQuery();
            if (datos != null && datos.next()) {
                ContraDatos = new ContraDatos(
                        datos.getString(1),
                        datos.getString(2)
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(personalGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ContraDatos;
    }
    private static final String SQL_Nueva_contra = "SELECT Clave FROM personal WHERE NomUsuario=?";
    
    public static ContraDatos getContra(String idM) {
        ContraDatos ContraDatos = null;
        try {
            PreparedStatement consulta = Conexion.getConexion()
                    .prepareStatement(SQL_Nueva_contra);
            consulta.setString(1, idM);
            ResultSet datos = consulta.executeQuery();
            if (datos != null && datos.next()) {
                ContraDatos = new ContraDatos(
                        datos.getString(1)
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(personalGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ContraDatos;
    }
    private static final String SQL_UPDATE_Contra= "update personal set Clave=? where NomUsuario=?";

    public static boolean modificarContra(String Usu, String Clave) {
        try {

            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(SQL_UPDATE_Contra);
            sentencia.setString(1, Clave);
            sentencia.setString(2, Usu);       
            sentencia.executeUpdate();

            return sentencia.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(personalGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }
    
}
