/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Calidad;
import model.Conexion;

/**
 *
 * @author emily
 */
public class CalidadDao {
    
    private static final String SQL_SELECT_CALIDAD
            = "SELECT a.IdCalidadCli, b.IdCalidadEm, b.IdOt, c.IdSoliServ, a.EncarCli, b.EncarEm, "
            + "a.EstadoCli, b.EstadoEm, a.JustifiCli, b.JustifiEm, d.url, e.url FROM  calidadcli a, calidadem b, ordentraba c, imagen d, imagen e WHERE a.IdOt=? AND "
            + "b.IdOt = a.IdOt AND a.IdOt = c.IdOt AND d.tipo=5 AND e.tipo=6;";
    
    private static final String SQL_SELECT_DATOS_SOLI
            = "SELECT IdSoliServ, Proyecto, NotasMue, NotasDise, DisenoCli, NotasMedi, NotasElem  FROM  soliservicio WHERE IdSoliServ = ?";
    
    
    /*METODO CREAR NUEVO*/
    
     public static boolean CrearCali(int CaliEnvi, Calidad calidad) {
        try {
            String consulta = "INSERT INTO calidadcli(IdOt, EncarCli, EstadoCli, JustifiCli)"
                    + "VALUES(?, ?, ?, ?)";
            String consulta2 = "INSERT INTO calidadem(IdOt, EncarEm, EstadoEm, JustifiEm)"
                    + "VALUES(?, ?, ?, ?)";
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(consulta);
            PreparedStatement sentencia2 = Conexion.getConexion().prepareStatement(consulta2);
            switch (CaliEnvi){
                case 1:
                    sentencia.setInt(1, calidad.getIdOt());
                    sentencia.setInt(2, calidad.getEncarCli());
                    sentencia.setString(3, "Aceptada");
                    sentencia.setString(4, "");
                    sentencia.executeUpdate();
                    break;
                case 2:
                    sentencia.setInt(1, calidad.getIdOt());
                    sentencia.setInt(2, calidad.getEncarCli());
                    sentencia.setString(3, "Rechazada");
                    sentencia.setString(4, calidad.getJustifiCli());
                    sentencia.executeUpdate();
                    break;
                case 3:
                    sentencia2.setInt(1, calidad.getIdOt());
                    sentencia2.setInt(2, calidad.getEncarEm());
                    sentencia2.setString(3, "Aceptada");
                    sentencia2.setString(4, "");
                    sentencia2.executeUpdate();
                    break;
                case 4:
                    sentencia2.setInt(1, calidad.getIdOt());
                    sentencia2.setInt(2, calidad.getEncarEm());
                    sentencia2.setString(3, "Rechazada");
                    sentencia2.setString(4, calidad.getJustifiEm());
                    sentencia2.executeUpdate();
                    break;
            }                    
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
     
     public static Calidad getCalidad(int idM) {
        Calidad calidad = null;
        try {
            
            
            PreparedStatement consulta = Conexion.getConexion()
                    .prepareStatement(SQL_SELECT_CALIDAD);
            consulta.setInt(1, idM);
            ResultSet datos = consulta.executeQuery();
            if (datos != null && datos.next()) {
                calidad = new Calidad(
                        datos.getInt(1),
                        datos.getInt(2),
                        datos.getInt(3),
                        datos.getInt(4),
                        datos.getInt(5),
                        datos.getInt(6),
                        datos.getString(7),
                        datos.getString(8),
                        datos.getString(9),
                        datos.getString(10),
                        datos.getString(11),
                        datos.getString(12));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CalidadDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return calidad;
    }
     
     public static Calidad getDatosSoli(int IdSoliServ) {
        Calidad calidad = null;
        try {
            PreparedStatement consulta = Conexion.getConexion()
                    .prepareStatement(SQL_SELECT_DATOS_SOLI);
            consulta.setInt(1, IdSoliServ);
            ResultSet datos = consulta.executeQuery();
            if (datos != null && datos.next()) {
                calidad = new Calidad(
                        datos.getInt(1),
                        datos.getString(2),
                        datos.getString(3),
                        datos.getString(4),
                        datos.getString(5),
                        datos.getString(6),
                        datos.getString(7)
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(CalidadDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return calidad;
    }
     
     public boolean envioCa(Calidad calidad) {
        try {
            String consulta2 = "UPDATE ordentraba SET EnvioOT = ?, EstadoOT = ? WHERE IdOt = ?";
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(consulta2);
                    sentencia.setInt(1, 6);
                    sentencia.setString(2, "Sin Revisar");
                    sentencia.setInt(3, calidad.getIdOt());
                    sentencia.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}
