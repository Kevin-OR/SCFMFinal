/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.personal;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import model.personal.personal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Conexion;

/**
 *
 * @author KevinOcampo
 */
public class personalGestion {

    private static final String SQL_INSERT_PERSONA = "insert into personal values (?,?,?,?,?,?,?,?,?,?,?)";
    private static final String SQL_SELECT_PERSONA = "select * from personal where IdPersonal=?";
    private static final String SQL_UPDATE_PERSONA = "update personal set Nombre=?, PriApellido=?, SegApellido=?, Telefono=?, Correo=?, Salario=?, IdTipoCedu=?, IdRol=? where IdPersonal=?";
    private static final String SQL_DELETE_PERSONA = "delete from personal where IdPersonal=?";
    private static final String SQL_SELECT_PERSONAS = "SELECT a.IdPersonal,a.Nombre,a.PriApellido,a.Salario, b.Rol FROM personal a INNER JOIN rol b ON a.IdRol = b.IdRol";
    private static final String SQL_SELECT_ENCARCALI = "select * from personal where IdRol = 1";
    private static final String SQL_SELECT_PERSONAA = "SELECT IdPersonal,Nombre,PriApellido,SegApellido, Estado FROM personal";
    private static final String SQL_UPDATE_PER="UPDATE personal SET Estado='Permitido' WHERE IdPersonal=?;";
    private static final String SQL_UPDATE_DE="UPDATE personal SET Estado='Denegado' WHERE IdPersonal=?;";
    
    public static boolean per(int id) {
        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(SQL_UPDATE_PER);

            sentencia.setInt(1, id);
            
            sentencia.executeUpdate();

            return sentencia.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(personalGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    
    }
    
        public static boolean de(int id) {
        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(SQL_UPDATE_DE);

            sentencia.setInt(1, id);
            
            sentencia.executeUpdate();

            return sentencia.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(personalGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    
    }

    public static ArrayList<personal> getACCPersona() {
        ArrayList<personal> lista = new ArrayList<>();
        try {
            PreparedStatement consulta = Conexion.getConexion()
                    .prepareStatement(SQL_SELECT_PERSONAA);
            ResultSet datos = consulta.executeQuery();
            while (datos != null && datos.next()) {
                lista.add(new personal(
                        datos.getInt(1),
                        datos.getString(2),
                        datos.getString(3),
                        datos.getString(4),
                        datos.getString(5)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(personalGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public static ArrayList<personal> getEncargados() {
        ArrayList<personal> lista = new ArrayList<>();
        try {
            PreparedStatement consulta = Conexion.getConexion()
                    .prepareStatement(SQL_SELECT_ENCARCALI);
            ResultSet datos = consulta.executeQuery();
            while (datos != null && datos.next()) {
                lista.add(new personal(
                        datos.getInt(1),
                        datos.getString(2),
                        datos.getString(3),
                        datos.getString(4),
                        datos.getInt(5),
                        datos.getString(6),
                        datos.getDouble(7),
                        datos.getInt(8),
                        datos.getString(9),
                        datos.getString(10),
                        datos.getInt(11))
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(personalGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public boolean insertarPEr(personal personal, String password) {
        
       
        try {

            String consulta = "insert into personal (IdPersonal,Nombre,PriApellido, SegApellido, Telefono, Correo, Salario,IdTipoCedu, NomUsuario, Clave, IdRol)"
                    + "values (?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(consulta);
            sentencia.setInt(1, personal.getIdPersona());
            sentencia.setString(2, personal.getNombrePerso());
            sentencia.setString(3, personal.getPriApellidoPerso());
            sentencia.setString(4, personal.getSegApellidoPerso());
            sentencia.setInt(5, personal.getTelefono());
            sentencia.setString(6, personal.getCorreoPerso());
            sentencia.setDouble(7, personal.getSalario());
            sentencia.setInt(8, personal.getIdTipocedula());
            sentencia.setString(9, personal.getNomUsuario());
            sentencia.setString(10, password);
            sentencia.setInt(11, personal.getIdRol());
            sentencia.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public static boolean modificar(personal personal) {
        try {

            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(SQL_UPDATE_PERSONA);

            sentencia.setString(1, personal.getNombrePerso());
            sentencia.setString(2, personal.getPriApellidoPerso());
            sentencia.setString(3, personal.getSegApellidoPerso());
            sentencia.setInt(4, personal.getTelefono());
            sentencia.setString(5, personal.getCorreoPerso());
            sentencia.setDouble(6, personal.getSalario());
            sentencia.setInt(7, personal.getIdTipocedula());
            sentencia.setInt(8, personal.getIdRol());
            sentencia.setInt(9, personal.getIdPersona());
            sentencia.executeUpdate();

            return sentencia.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(personalGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    public static boolean eliminar(int id) {
        try {
            PreparedStatement sentencia = Conexion.getConexion()
                    .prepareStatement(SQL_DELETE_PERSONA);
            sentencia.setInt(1, id);
            return sentencia.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(personalGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static ArrayList<TablaPersonal> getTablaPersona() {
        ArrayList<TablaPersonal> lista = new ArrayList<>();
        try {
            PreparedStatement consulta = Conexion.getConexion()
                    .prepareStatement(SQL_SELECT_PERSONAS);
            ResultSet datos = consulta.executeQuery();
            while (datos != null && datos.next()) {
                lista.add(new TablaPersonal(
                        datos.getInt(1),
                        datos.getString(2),
                        datos.getString(3),
                        datos.getDouble(4),
                        datos.getString(5)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(personalGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public static personal getPersona(int idM) {
        personal personal = null;
        try {
            PreparedStatement consulta = Conexion.getConexion()
                    .prepareStatement(SQL_SELECT_PERSONA);
            consulta.setInt(1, idM);
            ResultSet datos = consulta.executeQuery();
            if (datos != null && datos.next()) {
                personal = new personal(
                        datos.getInt(1),
                        datos.getString(2),
                        datos.getString(3),
                        datos.getString(4),
                        datos.getInt(5),
                        datos.getString(6),
                        datos.getDouble(7),
                        datos.getInt(8),
                        datos.getString(9),
                        datos.getString(10),
                        datos.getInt(11)
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(personalGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return personal;
    }
}
