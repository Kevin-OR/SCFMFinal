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
public class MOGestion {
    
    private static final String SQL_SELECT_MO
            = "SELECT a.IdMO,a.IdPersonal, b.Nombre, b.PriApellido, b.SegApellido, a.HorasNor, a.HorasExtra, "
            + "a.HorasDobExtra from manoobra a, personal b, ordentraba c WHERE a.IdPersonal=b.IdPersonal "
            + "AND a.IdOt=c.IdOt AND c.IdOt=?";
    
    private static final String SQL_SELECT_MOUN ="SELECT * from manoobra a where IdMO=?";
    
    private static final String SQL_UPDATE_MO = "UPDATE manoobra SET HorasNor=?, HorasExtra=?, HorasDobExtra=? WHERE IdMO=?";
    private static final String SQL_INSERT_MO = "INSERT INTO manoobra (IdOt,IdPersonal,HorasNor,HorasExtra,HorasDobExtra) VALUES (?,?,?,?,?)";
    
    private static final String SQL_DELETE_MO = "delete from manoobra where IdMO=?";
    
    public boolean inserMO(MO MO) {
        try {
            
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(SQL_INSERT_MO);
            sentencia.setInt(1, MO.getIdOt());
            sentencia.setInt(2, MO.getIdPersonal());
            sentencia.setInt(3, MO.getHorasNor());
            sentencia.setInt(4, MO.getHorasExtra());
            sentencia.setInt(5, MO.getHorasDobExtra());
            sentencia.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
    
    public static MO getMO(int idM) {
        MO MO = null;
        try {
            PreparedStatement consulta = Conexion.getConexion()
                    .prepareStatement(SQL_SELECT_MOUN);
            consulta.setInt(1, idM);
            ResultSet datos = consulta.executeQuery();
            if (datos != null && datos.next()) {
                MO = new MO(
                        datos.getInt(1),
                        datos.getInt(2),
                        datos.getInt(3),
                        datos.getInt(4),
                        datos.getInt(5),
                        datos.getInt(6)
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(MOGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return MO;
    }
    
    public static boolean modificar(MO MO) {
        try {
            
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(SQL_UPDATE_MO);
            sentencia.setInt(1, MO.getHorasNor());
            sentencia.setInt(2, MO.getHorasExtra());
            sentencia.setInt(3, MO.getHorasDobExtra());
            sentencia.setInt(4, MO.getIdMO());

            return sentencia.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(MOGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }
    
    
    public static ArrayList<MOMostraTa> getMOTa(int id) {
        ArrayList<MOMostraTa> lista = new ArrayList<>();
        try {
            PreparedStatement consulta = Conexion.getConexion()
                    .prepareStatement(SQL_SELECT_MO);
            consulta.setInt(1, id);
            ResultSet datos = consulta.executeQuery();
            while (datos != null && datos.next()) {
                lista.add(new MOMostraTa(
                        datos.getInt(1),
                        datos.getInt(2),
                        datos.getString(3),
                        datos.getString(4),
                        datos.getString(5),
                        datos.getInt(6),
                        datos.getInt(7),
                        datos.getInt(8)
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MOGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    public static boolean eliminar(int id) {
        try {
            PreparedStatement sentencia = Conexion.getConexion()
                    .prepareStatement(SQL_DELETE_MO);
            sentencia.setInt(1, id);
            return sentencia.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(MOGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
}
