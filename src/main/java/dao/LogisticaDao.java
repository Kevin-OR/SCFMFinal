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
import model.Logistica;

/**
 *
 * @author Asus
 */
public class LogisticaDao {
    
    private static final String SQL_SELECT_LOGI
            = "SELECT a.IdOt, b.Direccion, a.EvidenInsta, a.IdSoliServ FROM  ordentraba a, soliservicio b WHERE a.IdOt=? AND "
            + "a.IdSoliServ = b.IdSoliServ";
    
    public static boolean modificar(int IdOt) {
        try {
            String consulta = "UPDATE ordentraba SET EnvioOT = ? WHERE IdOt = ?";
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(consulta);
            sentencia.setInt(1, 7);
            sentencia.setInt(2, IdOt);
            sentencia.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
    
    public static Logistica getLogist(int IdOt) {
        Logistica logistica = null;
        try {
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(SQL_SELECT_LOGI);
            consulta.setInt(1, IdOt);
            ResultSet datos = consulta.executeQuery();
            if (datos != null && datos.next()) {
                logistica = new Logistica(
                        datos.getInt(1),
                        datos.getString(2),
                        datos.getString(3),
                        datos.getInt(4)
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrdRepaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return logistica;
    }
    
    public static boolean actualizarDirecc(Logistica logistica) {
        try {
            String consulta = "UPDATE soliservicio SET Direccion = ?, EstadoDirec = ? WHERE IdSoliServ = ?";
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(consulta);
            sentencia.setString(1, logistica.getDireccion());
            sentencia.setString(2, "Aceptada");
            sentencia.setInt(3, logistica.getIdSoliServ());
            sentencia.executeUpdate();
            String consulta2 = "UPDATE ordentraba SET EnvioOT = ? WHERE IdOt = ?";
            PreparedStatement sentencia2 = Conexion.getConexion().prepareStatement(consulta2);
            sentencia2.setInt(1, 8);
            sentencia2.setInt(2, logistica.getIdOt());
            sentencia2.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
    
    public static boolean aceptarDirecc(Logistica logistica) {
        try {
            String consulta2 = "UPDATE ordentraba SET EnvioOT = ? WHERE IdOt = ?";
            PreparedStatement sentencia2 = Conexion.getConexion().prepareStatement(consulta2);
            sentencia2.setInt(1, 8);
            sentencia2.setInt(2, logistica.getIdOt());
            sentencia2.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
    
    public static boolean enviado(Logistica logistica) throws SQLException {
        try{
            String consulta = "UPDATE ordentraba SET EnvioOT = ?, EstadoOT = ?, JustifiOt = ? WHERE IdOt = ?";
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(consulta);
            sentencia.setInt(1, 9);
                    sentencia.setString(2, "En Garantía");
                    sentencia.setString(3, "");
                    sentencia.setInt(4, logistica.getIdOt());
                    sentencia.executeUpdate();
        }catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    
}
}
