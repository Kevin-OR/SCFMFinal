/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Conexion;
import model.TareasCrono;

/**
 *
 * @author Asus
 */
public class TareasCronoDao {
    private static final String SQL_DELETE_TAREASCRO= "DELETE FROM tareascrono WHERE IdTareaC=?";

    public boolean crearTareaC(int IdOt, TareasCrono tareasCrono) {
        try {
            String consulta = "INSERT INTO tareascrono(IdOt, NomTarea, FechaFin, IdPersonal)"
                    + "VALUES(?, ?, ?, ?)";
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(consulta);
            sentencia.setInt(1, IdOt);
            sentencia.setString(2, tareasCrono.getNomTarea());
            sentencia.setString(3, tareasCrono.getFechaFin());
            sentencia.setInt(4, tareasCrono.getIdPersonal());
            sentencia.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public static boolean eliminar(int id) {
        try {
            PreparedStatement sentencia = Conexion.getConexion()
                    .prepareStatement(SQL_DELETE_TAREASCRO);
            sentencia.setInt(1, id);
            return sentencia.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(MaterialListDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
