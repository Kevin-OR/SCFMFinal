/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.material;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Conexion;

/**
 *
 * @author KevinOcampo
 */
public class MaterialGestion {

    private static final String SQL_SELECT_materiales = "SELECT * FROM materiales";
    private static final String SQL_SELECT_material = "select * from materiales where IdMaterial=?";
    private static final String SQL_UPDATE_material = "update materiales set NomMate=?, PrecioMate=?, CantiMate=? where IdMaterial=?";
    private static final String SQL_DELETE_material = "delete from materiales where IdMaterial=?";
    private static final String SQL_INSERT_material = "INSERT INTO materiales VALUES(NULL,\"lobo\",6000,)";

    public boolean inserMateri(materiales materiales) {
        try {
            String consulta = "INSERT INTO materiales (NomMate, PrecioMate, CantiMate) VALUES(?,?,?)";
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(consulta);
            sentencia.setString(1, materiales.getNomMaterial());
            sentencia.setInt(2, materiales.getPrecioMaterial());
            sentencia.setInt(3, materiales.getCantMaterial());
            sentencia.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
    
    public boolean crearMaterCoti(materiales matecoti) {
        try {
            String consulta = "INSERT INTO materiales (NomMate, PrecioMate) VALUES(?,?)";
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(consulta);
            sentencia.setString(1, matecoti.getNomMaterial());
            sentencia.setInt(2, matecoti.getPrecioMaterial());
            sentencia.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public static boolean insertar(materiales materiales) {
        try {
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(SQL_INSERT_material);
            consulta.setString(1, materiales.getNomMaterial());
            consulta.setInt(2, materiales.getPrecioMaterial());
            consulta.setInt(3, materiales.getCantMaterial());

            return (consulta.executeUpdate() == 1);
        } catch (SQLException ex) {
        }
        return false;
    }

    public static boolean modificar(materiales material) {
        try {
            String consulta = "update materiales set NomMate=?, PrecioMate=?, CantiMate=? where IdMaterial=?";
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(consulta);
            sentencia.setString(1, material.getNomMaterial());
            sentencia.setInt(2, material.getPrecioMaterial());
            sentencia.setInt(3, material.getCantMaterial());
            sentencia.setInt(4, material.getIdMaterial());

            return sentencia.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(MaterialGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    public static boolean eliminar(int id) {
        try {
            PreparedStatement sentencia = Conexion.getConexion()
                    .prepareStatement(SQL_DELETE_material);
            sentencia.setInt(1, id);
            return sentencia.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(MaterialGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static ArrayList<materiales> getMateriales() {
        ArrayList<materiales> lista = new ArrayList<>();
        try {
            PreparedStatement consulta = Conexion.getConexion()
                    .prepareStatement(SQL_SELECT_materiales);
            ResultSet datos = consulta.executeQuery();
            while (datos != null && datos.next()) {
                lista.add(new materiales(
                        datos.getInt(1),
                        datos.getString(2),
                        datos.getInt(3),
                        datos.getInt(4)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MaterialGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public static materiales getMaterial(int idM) {
        materiales materiales = null;
        try {
            PreparedStatement consulta = Conexion.getConexion()
                    .prepareStatement(SQL_SELECT_material);
            consulta.setInt(1, idM);
            ResultSet datos = consulta.executeQuery();
            if (datos != null && datos.next()) {
                materiales = new materiales(
                        datos.getInt(1),
                        datos.getString(2),
                        datos.getInt(3),
                        datos.getInt(4)
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(MaterialGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return materiales;
    }

}
