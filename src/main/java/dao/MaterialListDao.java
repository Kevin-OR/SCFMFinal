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
import model.MaterialList;

/**
 *
 * @author Asus
 */
public class MaterialListDao {

    private static final String SQL_DELETE_MATERIALLIST = "DELETE FROM materialeslist WHERE IdMateList=?";

    public boolean crearMateList(int IdSoli, MaterialList materialList) {
        try {
            String consulta = "INSERT INTO materialeslist(IdMaterial, IdSoliServ, CantOcupar)"
                    + "VALUES(?, ?, ?)";
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(consulta);
            sentencia.setInt(1, materialList.getIdMaterial());
            sentencia.setInt(2, IdSoli);
            sentencia.setInt(3, materialList.getCantOcupar());
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
                    .prepareStatement(SQL_DELETE_MATERIALLIST);
            sentencia.setInt(1, id);
            return sentencia.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(MaterialListDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
