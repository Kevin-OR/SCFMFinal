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
import model.PrecioVenta;

/**
 *
 * @author emily
 */
public class PrecioVentaDao {
    int cal;

    private static final String SQL_SELECT_PRECIOVEN
            = "SELECT * FROM precioventa WHERE IdSoliServ = ?";

     private static final String SQL_DELETE_PRECIOVEN
            = "DELETE FROM precioventa WHERE IdSoliServ =?";
     
     private static final String SQL_SELECT_ENVIOPV 
             = "SELECT * FROM precioventa WHERE EnvioPV = 1";
     
     /*ENVIO*/
    public static ArrayList<PrecioVenta> getEnvioPV() {
        ArrayList<PrecioVenta> listaE = new ArrayList<>();
        try {
            PreparedStatement consulta = Conexion.getConexion()
                    .prepareStatement(SQL_SELECT_ENVIOPV);
            ResultSet datos = consulta.executeQuery();
            while (datos != null && datos.next()) {
                listaE.add(new PrecioVenta(
                        datos.getInt(1),
                        datos.getInt(2),
                        datos.getInt(3),
                        datos.getInt(4),
                        datos.getString(5),
                        datos.getInt(6),
                        datos.getInt(7),
                        datos.getInt(8),
                        datos.getString(9),
                        datos.getString(10)
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PrecioVentaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaE;
    }
     
    public static boolean enviadoPV(PrecioVenta precioVenta) {
        try {
            String consulta = "UPDATE precioventa SET envioPV = ?  WHERE IdSoliServ = ?;";
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(consulta);
            sentencia.setInt(1, 1);
            sentencia.setInt(2, precioVenta.getIdSoliServ());
            sentencia.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
    
    /*METODO RECHAZAR*/
    public static boolean modificarRechaPV(PrecioVenta precioVenta) {
        try {
            String consulta = "UPDATE precioventa SET EstadoPV = ?, JustifiPV = ?  WHERE IdPreVenta = ?";
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(consulta);
            sentencia.setString(1, "Rechazada");
            sentencia.setString(2, precioVenta.getJustifiPV());
            sentencia.setInt(3, precioVenta.getIdPreVenta());
            sentencia.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
    
    /*METODO ACEPTAR*/
    public static boolean modificarAceptarPV(PrecioVenta precioVenta) {
        try {
            String consulta = "UPDATE precioventa SET EstadoPV = ?, JustifiPV = ?  WHERE IdPreVenta = ?";
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(consulta);
            sentencia.setString(1, "Aceptada");
            sentencia.setString(2, "");
            sentencia.setInt(3, precioVenta.getIdPreVenta());
            sentencia.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
    
    
    /*METODO CREAR NUEVO*/
    public boolean crearOrdenPreVen(PrecioVenta precioV) {
        try {
            String consulta = "INSERT INTO precioventa(IdSoliServ, TotalMate, ManoObra, PlazoEntre, Descuento, Agregados, TotalCal)"
                    + "VALUES(?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(consulta);
            sentencia.setInt(1, precioV.getIdSoliServ());
            sentencia.setInt(2, precioV.getTotalMate());
            sentencia.setInt(3, precioV.getManoObra());
            sentencia.setString(4, precioV.getPlazoEntre());
            sentencia.setInt(5, precioV.getDescuento());
            sentencia.setInt(6, precioV.getAgregados());
            sentencia.setInt(7, cal);
            sentencia.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
    
    public int calculo(int TotalMate, int ManoObra,  int Agregados, int Descuento){
        cal = (TotalMate + ManoObra + Agregados) - Descuento;
        return cal;
    }

    /*METODO VISUALIZAR DATOS DE ID ESPECIFICO*/
    public static PrecioVenta getPrecioVenta(int IdSoliServ) {
        PrecioVenta precioVenta = null;
        try {
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(SQL_SELECT_PRECIOVEN);
            consulta.setInt(1, IdSoliServ);
            ResultSet datos = consulta.executeQuery();
            if (datos != null && datos.next()) {
                precioVenta = new PrecioVenta(
                        datos.getInt(1),
                        datos.getInt(2),
                        datos.getInt(3),
                        datos.getInt(4),
                        datos.getString(5),
                        datos.getInt(6),
                        datos.getInt(7),
                        datos.getInt(8),
                        datos.getString(9),
                        datos.getString(10)
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(PrecioVentaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return precioVenta;
    }
    
    public static boolean eliminar(int IdSoliServ) {
        try {
            PreparedStatement sentencia = Conexion.getConexion()
                    .prepareStatement(SQL_DELETE_PRECIOVEN);
            sentencia.setInt(1, IdSoliServ);
            
            return sentencia.executeUpdate() > 0;
            
        } catch (SQLException ex) {
            Logger.getLogger(PrecioVentaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
