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
import model.EspecificacionOT;
import model.OrdenTraba.TablaOT;

/**
 *
 * @author emily
 */
public class EspecificacionOTDao {

   private static final String SQL_SELECT_ESPE
            = "SELECT * FROM especifiot WHERE IdOt = ?";
    
    private static final String SQL_DELETE_ESPE 
            = "DELETE FROM especifiot WHERE IdEspe =?";
    
    private static final String SQL_SELECT_ENVIOES
            = "SELECT a.IdSoliServ, a.IdOt, b.NombClient, b.PriApeClient, b.SegApeClient, b.Proyecto, a.EstadoOT, a.JustifiOt "
            + "FROM ordentraba a, soliservicio b where  a.IdSoliServ = b.IdSoliServ and a.EnvioEs = 1";
     
     /*ENVIO*/
    public static ArrayList<TablaOT> getEnvioEs() {
        ArrayList<TablaOT> lista = new ArrayList<>();
        try {
            PreparedStatement consulta = Conexion.getConexion()
                    .prepareStatement(SQL_SELECT_ENVIOES);
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
            Logger.getLogger(EspecificacionOTDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
     
    public static boolean enviadoEs(EspecificacionOT especificacionOT) {
        try {
            String consulta = "UPDATE ordentraba SET EnvioEs = ?  WHERE IdOt = ?;";
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(consulta);
            sentencia.setInt(1, 1);
            sentencia.setInt(2, especificacionOT.getIdOt());
            sentencia.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
    

    /*VISUALIZAR DATOS DE ID ESPECIFICO*/
   public static ArrayList<EspecificacionOT> getEspecificacionOT(int IdOt) {
        ArrayList<EspecificacionOT> listaes = new ArrayList<>();
        try {
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(SQL_SELECT_ESPE);
            consulta.setInt(1, IdOt);
            ResultSet datos = consulta.executeQuery();
            while (datos != null && datos.next()) {
                listaes.add(new EspecificacionOT(
                        datos.getInt(1),
                        datos.getInt(2),
                        datos.getString(3),
                        datos.getString(4),
                        datos.getString(5),
                        datos.getString(6),
                        datos.getString(7)
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EspecificacionOTDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaes;
    }
   
 
    public boolean crearEspeciS(EspecificacionOT EspeciS) {
        try {
            String consulta = "INSERT INTO especifiot(IdOt, NomEspe, TipoEspe, DescrEspe, NotasEspe)"
                    + "VALUES(?, ?, ?, ?, ?)";
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(consulta);
            sentencia.setInt(1, EspeciS.getIdOt());
            sentencia.setString(2, EspeciS.getNomEspe());
            sentencia.setString(3, EspeciS.getTipoEspe());
            sentencia.setString(4, EspeciS.getDescrEspe());
            sentencia.setString(5, EspeciS.getNotasEspe());
            sentencia.executeUpdate();
            

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
            
    public static boolean eliminar(int IdEspe) {
        try {
            PreparedStatement sentencia = Conexion.getConexion()
                    .prepareStatement(SQL_DELETE_ESPE);
            sentencia.setInt(1, IdEspe);
            
            return sentencia.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(EspecificacionOTDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    /*METODO VERIFICAR*/
    public static boolean modificarAceptarES(EspecificacionOT especificacionOT) {
        try {
            String consulta = "UPDATE especifiot SET EstadoES = ?  WHERE IdOt = ?";
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(consulta);
            sentencia.setString(1, "Verificada");
            sentencia.setInt(2, especificacionOT.getIdOt());
            sentencia.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}
