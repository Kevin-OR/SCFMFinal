/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.OGarantia;

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
public class OGGestion {
    
    private static final String SQL_INSERT_OG="INSERT INTO ordengara "
            + "(IdOt,VisitaUno,VisitaDos,Direccion,FechaIni,HoraVisi) VALUES (?,?,?,?,?,?)";
    
    private static final String SQL_SELECT_OG="SELECT a.IdOrdenGar,  "
            + "c.NombClient, c.PriApeClient, c.SegApeClient, c.Proyecto, "
            + "a.Estado FROM ordengara a, ordentraba b, soliservicio c WHERE "
            + "a.IdOt=b.IdOt AND b.IdSoliServ=c.IdSoliServ";
    
    private static final String SQL_SELECT_OGUna="SELECT * FROM ordengara WHERE IdOrdenGar=?;";
    
    
    private static final String SQL_DELETE_OG="DELETE from ordengara WHERE IdOrdenGar=?;";
    
    private static final String SQL_UPDATE_OG="UPDATE ordengara SET IdOt=?, "
            + "VisitaUno=?, VisitaDos=?, Direccion=? ,FechaIni=? , HoraVisi=? , "
            + "Estado=? WHERE IdOrdenGar=?;";
    
    public static boolean modificar(OG OG) {
        try {

            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(SQL_UPDATE_OG);

            
            sentencia.setInt(1, OG.getIdOt());
            sentencia.setInt(2, OG.getVisitaUno());
            sentencia.setInt(3, OG.getVisitaDos());
            sentencia.setString(4, OG.getDireccion());
            sentencia.setString(5, OG.getFechaVisi());
            sentencia.setString(6, OG.getHoraVisi());
            sentencia.setString(7, OG.getEstaGO());
            sentencia.setInt(8, OG.getIdOG());
            sentencia.executeUpdate();

            return sentencia.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(OGGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    public static boolean eliminar(int id) {
        try {
            PreparedStatement sentencia = Conexion.getConexion()
                    .prepareStatement(SQL_DELETE_OG);
            sentencia.setInt(1, id);
            return sentencia.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(OGGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public static OG getOGUna(int idM) {
        OG OG = null;
        try {
            PreparedStatement consulta = Conexion.getConexion()
                    .prepareStatement(SQL_SELECT_OGUna);
            consulta.setInt(1, idM);
            ResultSet datos = consulta.executeQuery();
            if (datos != null && datos.next()) {
                OG = new OG(
                        datos.getInt(1),
                        datos.getInt(2),
                        datos.getInt(3),
                        datos.getInt(4),
                        datos.getString(5),
                        datos.getString(6),
                        datos.getString(7),
                        datos.getString(8)

                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(OGGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return OG;
    }
    
    
    public static ArrayList<OG> getOGt() {
        ArrayList<OG> lista = new ArrayList<>();
        try {
            PreparedStatement consulta = Conexion.getConexion()
                    .prepareStatement(SQL_SELECT_OG);
            ResultSet datos = consulta.executeQuery();
            while (datos != null && datos.next()) {
                lista.add(new OG(
                        datos.getInt(1),
                        datos.getString(2),
                        datos.getString(3),
                        datos.getString(4),
                        datos.getString(5),
                        datos.getString(6)
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(OGGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    } 
    
    public boolean insertarOG(OG OG) {
        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(SQL_INSERT_OG);
            sentencia.setInt(1, OG.getIdOt());
            sentencia.setInt(2, OG.getVisitaUno());
            sentencia.setInt(3, OG.getVisitaDos());
            sentencia.setString(4, OG.getDireccion());
            sentencia.setString(5, OG.getFechaVisi());
            sentencia.setString(6, OG.getHoraVisi());
            
            sentencia.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
    
    public static boolean modificarRechaOG(OG OG) {
        try {
            String consulta = "UPDATE ordengara SET Estado = ?, JustifiOG = ?  WHERE IdOrdenGar = ?";
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(consulta);
            sentencia.setString(1, "Rechazada");
            sentencia.setString(2, OG.getJustifiOG());
            sentencia.setInt(3, OG.getIdOG());
            sentencia.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
    
    public static boolean modificarAcepOG(OG OG) {
        try {
            String consulta = "UPDATE ordengara SET Estado = ?, JustifiOG = ?  WHERE IdOrdenGar = ?";
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(consulta);
            sentencia.setString(1, "Aceptada");
            sentencia.setString(2, "");
            sentencia.setInt(3, OG.getIdOG());
            sentencia.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
    
}
