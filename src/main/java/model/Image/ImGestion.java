/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.Image;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Conexion;

/**
 *
 * @author KevinOcampo
 */
public class ImGestion {

    private static final String SQL_SELECT_Im = "select * from materiales where IdMaterial=?";
    private static final String SQL_INSERT_Im1 = "INSERT INTO imagen(IdSoliServ,IdOt,url,tipo) VALUES(?,?,?,?)";
    private static final String SQL_INSERT_Ult = "SELECT MAX(IdIm) FROM imagen";

    public static boolean insertar(int idser, int idOt, String url, int tipo) {
        try {

            PreparedStatement consulta = Conexion.getConexion().prepareStatement(SQL_INSERT_Im1);
            consulta.setInt(1, idser);
            consulta.setInt(2, idOt);
            consulta.setString(3, url);
            consulta.setInt(4, tipo);
            return (consulta.executeUpdate() == 1);
        } catch (SQLException ex) {
            
        }
        return false;
    }

    public static Im getUl() {
        Im Im = null;
        try {
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(SQL_INSERT_Ult);
            ResultSet datos = consulta.executeQuery();
            if (datos != null && datos.next()) {
                Im = new Im(
                        datos.getInt(1)
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(ImGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Im;
    }

    public static Im getMaterial(int idM) {
        Im Im = null;
        try {
            PreparedStatement consulta = Conexion.getConexion()
                    .prepareStatement(SQL_SELECT_Im);
            consulta.setInt(1, idM);
            ResultSet datos = consulta.executeQuery();
            if (datos != null && datos.next()) {
                Im = new Im(
                        datos.getInt(1),
                        datos.getString(2)
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(ImGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Im;
    }

}
