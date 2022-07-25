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
import model.CompraMate;
import model.Conexion;
import model.OrdenTraba.TablaOT;

/**
 *
 * @author emily
 */
public class CompraMateDao {
private static final String SQL_SELECT_COMPRAMATE
            = "SELECT a.IdMateCompra, a.IdOt, a.IdMaterial,  a.CantCompra, b.NomMate FROM compramate a, materiales b WHERE a.IdOt = ? AND a.IdMaterial=b.IdMaterial";

private static final String SQL_SELECT_CANTINVEN
            = "SELECT CantiMate FROM materiales WHERE IdMaterial = ?";
    
    private static final String SQL_DELETE_COMPRAMATE
            = "DELETE FROM compramate WHERE IdMateCompra =?";
    
    private static final String SQL_SELECT_ENVIOCOMPRA
            = "SELECT a.IdSoliServ, a.IdOt, b.NombClient, b.PriApeClient, b.SegApeClient, b.Proyecto, a.EstadoOT, a.JustifiOt "
            + "FROM ordentraba a, soliservicio b where  a.IdSoliServ = b.IdSoliServ and a.EnvioOC = 1";
     
    
    private static int CantMatInven;
     /*ENVIO*/
    public static ArrayList<TablaOT> getEnvioCompra() {
        ArrayList<TablaOT> lista = new ArrayList<>();
        try {
            PreparedStatement consulta = Conexion.getConexion()
                    .prepareStatement(SQL_SELECT_ENVIOCOMPRA);
            ResultSet datos = consulta.executeQuery();
            while (datos != null && datos.next()) {
                lista.add(new TablaOT(
                       datos.getInt(1),
                        datos.getInt(2),
                        datos.getString(3),
                        datos.getString(4),
                        datos.getString(5),
                        datos.getString(6),
                        datos.getString(7),
                        datos.getString(8)
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CompraMateDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
     
    public static boolean enviadoCompra(CompraMate compraMate) {
        try {
            String consulta = "UPDATE ordentraba SET EnvioOC = ?  WHERE IdOt = ?;";
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(consulta);
            sentencia.setInt(1, 1);
            sentencia.setInt(2, compraMate.getIdOt());
            sentencia.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
    

    /*VISUALIZAR DATOS DE ID ESPECIFICO*/
   public static ArrayList<CompraMate> getCompraMate(int IdOt) {
        ArrayList<CompraMate> listaes = new ArrayList<>();
        try {
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(SQL_SELECT_COMPRAMATE);
            consulta.setInt(1, IdOt);
            ResultSet datos = consulta.executeQuery();
            while (datos != null && datos.next()) {
                listaes.add(new CompraMate(
                        datos.getInt(1),
                        datos.getInt(2),
                        datos.getInt(3),
                        datos.getInt(4),
                        datos.getString(5)
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CompraMateDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaes;
    }
   
 
    public boolean crearMates(CompraMate CompraMates) {
        try {
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(SQL_SELECT_CANTINVEN);
            consulta.setInt(1, CompraMates.getIdMaterial());
            ResultSet datos = consulta.executeQuery();
            if (datos != null && datos.next()) {
                CantMatInven = datos.getInt(1);
            }
            if(CantMatInven<CompraMates.getCantiCompra()){
            String consulta2 = "INSERT INTO compramate(IdOt, IdMaterial, CantCompra)"
                    + "VALUES(?, ?, ?)";
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(consulta2);
            sentencia.setInt(1, CompraMates.getIdOt());
            sentencia.setInt(2, CompraMates.getIdMaterial());
            sentencia.setInt(3, CompraMates.getCantiCompra()-CantMatInven);
            sentencia.executeUpdate();
            }else{
                return false;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
            
    public static boolean eliminar(int IdMateCompra) {
        try {
            PreparedStatement consulta3 = Conexion.getConexion().prepareStatement(SQL_DELETE_COMPRAMATE);
            consulta3.setInt(1, IdMateCompra);
            
            return consulta3.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(EspecificacionOTDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
}

