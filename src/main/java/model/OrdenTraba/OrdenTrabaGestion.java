/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.OrdenTraba;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Calidad;
import model.Conexion;

/**
 *
 * @author KevinOcampo
 */
public class OrdenTrabaGestion {

    private static final String SQL_INSERT_ordentraba
            = "INSERT INTO ordentraba(IdSoliServ,FechaIni,FechaEntre,FechaFin) values (?,?,?,(CURDATE() + INTERVAL 7 MONTH))";

    private static final String SQL_SELECT_ordentrabajos
            = "SELECT a.IdSoliServ, a.IdOt, b.NombClient, b.PriApeClient, b.SegApeClient, b.Proyecto, a.EstadoOT, a.JustifiOt "
            + "FROM ordentraba a, soliservicio b where  a.IdSoliServ = b.IdSoliServ";

    private static final String SQL_SELECT_ordentraba
            = "SELECT  a.IdOt, b.IdSoliServ, a.FechaIni, a.FechaEntre, b.Proyecto, "
            + "b.NombClient, b.PriApeClient, b.SegApeClient, a.JustifiOt, a.EstadoOT  FROM  ordentraba a, soliservicio b WHERE a.IdOt=? AND "
            + "a.IdSoliServ = b.IdSoliServ;";

    private static final String SQL_DELETE_ordentraba
            = "delete from ordentraba where IdPersonal=?";

    private static final String SQL_SELECT_soli
            = "SELECT IdSoliServ FROM soliservicio;";

    private static final String SQL_SELECT_ENVIO
            = "SELECT a.IdSoliServ, a.IdOt, b.NombClient, b.PriApeClient, b.SegApeClient, b.Proyecto, a.EstadoOT, a.JustifiOt "
            + "FROM ordentraba a, soliservicio b where  a.IdSoliServ = b.IdSoliServ AND a.EnvioOT = 1 OR a.IdSoliServ = b.IdSoliServ AND a.EnvioOT = 3";

     private static final String SQL_SELECT_ENVIOPRO
            = "SELECT a.IdSoliServ, a.IdOt, b.NombClient, b.PriApeClient, b.SegApeClient, b.Proyecto, a.EstadoOT, a.JustifiOt "
            + "FROM ordentraba a, soliservicio b where a.IdSoliServ = b.IdSoliServ AND a.EnvioOT = 2";
    
    private static final String SQL_SELECT_ENVIOPROAC
            = "SELECT a.IdSoliServ, a.IdOt, b.NombClient, b.PriApeClient, b.SegApeClient, b.Proyecto, a.EstadoOT, a.JustifiOt "
            + "FROM ordentraba a, soliservicio b where  a.IdSoliServ = b.IdSoliServ AND a.EnvioOT = 2 OR a.IdSoliServ = b.IdSoliServ AND a.EnvioOT = 4";
    
    private static final String SQL_SELECT_ENVIOFI
            = "SELECT a.IdSoliServ, a.IdOt, b.NombClient, b.PriApeClient, b.SegApeClient, b.Proyecto, a.EstadoOT, a.JustifiOt "
            + "FROM ordentraba a, soliservicio b where  a.IdSoliServ = b.IdSoliServ AND a.EnvioOT = 4";
    
    private static final String SQL_SELECT_ENVIOCA
            = "SELECT a.IdSoliServ, a.IdOt, b.NombClient, b.PriApeClient, b.SegApeClient, b.Proyecto, a.EstadoOT, a.JustifiOt "
            + "FROM ordentraba a, soliservicio b where  a.IdSoliServ = b.IdSoliServ AND a.EnvioOT = 5";
    
    private static final String SQL_SELECT_ENVIOLO
            = "SELECT a.IdSoliServ, a.IdOt, b.NombClient, b.PriApeClient, b.SegApeClient, b.Proyecto, a.EstadoOT, a.JustifiOt "
            + "FROM ordentraba a, soliservicio b where  a.IdSoliServ = b.IdSoliServ AND a.EnvioOT = 6";
    
    private static final String SQL_SELECT_ENVIOLOAC
            = "SELECT a.IdSoliServ, a.IdOt, b.NombClient, b.PriApeClient, b.SegApeClient, b.Proyecto, b.EstadoDirec, a.JustifiOt "
            + "FROM ordentraba a, soliservicio b where  a.IdSoliServ = b.IdSoliServ AND a.EnvioOT = 7";
    
    private static final String SQL_SELECT_ENVIOLOINSTA
            = "SELECT a.IdSoliServ, a.IdOt, b.NombClient, b.PriApeClient, b.SegApeClient, b.Proyecto, a.EstadoOT, a.JustifiOt "
            + "FROM ordentraba a, soliservicio b where  a.IdSoliServ = b.IdSoliServ AND a.EnvioOT = 8";
    
    private static final String SQL_SELECT_ENVIOGARAN
            = "SELECT a.IdOt, b.NombClient, b.PriApeClient, b.SegApeClient, b.Proyecto, a.FechaEntre, a.FechaFin "
            + "FROM ordentraba a, soliservicio b where  a.IdSoliServ = b.IdSoliServ AND a.EnvioOT = 9";

    public static ArrayList<soli> getSoli() {
        ArrayList<soli> lista = new ArrayList<>();
        try {
            PreparedStatement consulta = Conexion.getConexion()
                    .prepareStatement(SQL_SELECT_soli);
            ResultSet datos = consulta.executeQuery();
            while (datos != null && datos.next()) {
                lista.add(new soli(
                        datos.getInt(1)
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrdenTrabaGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    /*ENVIO*/
    public static ArrayList<TablaOT> getEnvio() {
        ArrayList<TablaOT> lista = new ArrayList<>();
        try {
            PreparedStatement consulta = Conexion.getConexion()
                    .prepareStatement(SQL_SELECT_ENVIO);
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
            Logger.getLogger(OrdenTrabaGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    /*ENVIO ACEP/Recha*/
    public static ArrayList<TablaOT> getEnvioAR() {
        ArrayList<TablaOT> lista = new ArrayList<>();
        try {
            PreparedStatement consulta = Conexion.getConexion()
                    .prepareStatement(SQL_SELECT_ENVIOPRO);
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
            Logger.getLogger(OrdenTrabaGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    /*ENVIO FINAL*/
    public static ArrayList<TablaOT> getEnvioFi() {
        ArrayList<TablaOT> lista = new ArrayList<>();
        try {
            PreparedStatement consulta = Conexion.getConexion()
                    .prepareStatement(SQL_SELECT_ENVIOFI);
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
            Logger.getLogger(OrdenTrabaGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    /*ENVIO FINAL/ACEPT*/
    public static ArrayList<TablaOT> getEnvioFiAc() {
        ArrayList<TablaOT> lista = new ArrayList<>();
        try {
            PreparedStatement consulta = Conexion.getConexion()
                    .prepareStatement(SQL_SELECT_ENVIOPROAC);
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
            Logger.getLogger(OrdenTrabaGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    /*ENVIO CALIDAD*/
    public static ArrayList<TablaOT> getEnvioCa() {
        ArrayList<TablaOT> lista = new ArrayList<>();
        try {
            PreparedStatement consulta = Conexion.getConexion()
                    .prepareStatement(SQL_SELECT_ENVIOCA);
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
            Logger.getLogger(OrdenTrabaGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
     /*ENVIO LOGISTICA*/
    public static ArrayList<TablaOT> getEnvioLo() {
        ArrayList<TablaOT> lista = new ArrayList<>();
        try {
            PreparedStatement consulta = Conexion.getConexion()
                    .prepareStatement(SQL_SELECT_ENVIOLO);
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
            Logger.getLogger(OrdenTrabaGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    public static ArrayList<TablaOT> getEnvioLoAc() {
        ArrayList<TablaOT> lista = new ArrayList<>();
        try {
            PreparedStatement consulta = Conexion.getConexion()
                    .prepareStatement(SQL_SELECT_ENVIOLOAC);
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
            Logger.getLogger(OrdenTrabaGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    public static ArrayList<TablaOT> getEnvioLoInsta() {
        ArrayList<TablaOT> lista = new ArrayList<>();
        try {
            PreparedStatement consulta = Conexion.getConexion()
                    .prepareStatement(SQL_SELECT_ENVIOLOINSTA);
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
            Logger.getLogger(OrdenTrabaGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    public static ArrayList<TablaOT> getEnvioGaran() {
        ArrayList<TablaOT> lista = new ArrayList<>();
        try {
            PreparedStatement consulta = Conexion.getConexion()
                    .prepareStatement(SQL_SELECT_ENVIOGARAN);
            ResultSet datos = consulta.executeQuery();
            while (datos != null && datos.next()) {
                lista.add(new TablaOT(
                        datos.getInt(1),
                        datos.getString(2),
                        datos.getString(3),
                        datos.getString(4),
                        datos.getString(5),
                        datos.getString(6),
                        datos.getString(7)
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrdenTrabaGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    public boolean insertarOT(OrdenTrabajo OrdenTrabajo) {
        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(SQL_INSERT_ordentraba);
            sentencia.setInt(1, OrdenTrabajo.getIdOtordenservicio());
            sentencia.setString(2, OrdenTrabajo.getFechaIni());
            sentencia.setString(3, OrdenTrabajo.getFechaEntre());
            sentencia.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public static ArrayList<TablaOT> getTablaOT() {
        ArrayList<TablaOT> lista = new ArrayList<>();
        try {
            PreparedStatement consulta = Conexion.getConexion()
                    .prepareStatement(SQL_SELECT_ordentrabajos);
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
            Logger.getLogger(OrdenTrabaGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public static OrdenTrabajo getOT(int idM) {
        OrdenTrabajo OrdenTrabajo = null;
        try {
            PreparedStatement consulta = Conexion.getConexion()
                    .prepareStatement(SQL_SELECT_ordentraba);
            consulta.setInt(1, idM);
            ResultSet datos = consulta.executeQuery();
            if (datos != null && datos.next()) {
                OrdenTrabajo = new OrdenTrabajo(
                        datos.getInt(1),
                        datos.getInt(2),
                        datos.getString(3),
                        datos.getString(4),
                        datos.getString(5),
                        datos.getString(6),
                        datos.getString(7),
                        datos.getString(8),
                        datos.getString(9),
                        datos.getString(10)
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrdenTrabaGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return OrdenTrabajo;
    }

    
    public static boolean enviado(int Envi, OrdenTrabajo ordenTrabajo) {
        try {
            String consulta = "UPDATE ordentraba SET EnvioOT = ?, EstadoOT = ?, JustifiOt = ? WHERE IdOt = ?";
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(consulta);
            switch (Envi){
                case 1:
                    sentencia.setInt(1, Envi);
                    sentencia.setString(2, "Sin Revisar");
                    sentencia.setString(3, "");
                    sentencia.setInt(4, ordenTrabajo.getIdOt());
                    sentencia.executeUpdate();
                    break;
                case 2:
                    sentencia.setInt(1, Envi);
                    sentencia.setString(2, "Aceptada");
                    sentencia.setString(3, "");
                    sentencia.setInt(4, ordenTrabajo.getIdOt());
                    sentencia.executeUpdate();
                    break;
                case 3:
                    sentencia.setInt(1, Envi);
                    sentencia.setString(2, "Rechazada");
                    sentencia.setString(3, ordenTrabajo.getJustifiOt());
                    sentencia.setInt(4, ordenTrabajo.getIdOt());
                    sentencia.executeUpdate();
                    break;
                case 4:
                    sentencia.setInt(1, Envi);
                    sentencia.setString(2, "Finalizada");
                    sentencia.setString(3, ordenTrabajo.getJustifiOt());
                    sentencia.setInt(4, ordenTrabajo.getIdOt());
                    sentencia.executeUpdate();
                    break;
                case 5:
                    sentencia.setInt(1, Envi);
                    sentencia.setString(2, "Revisión Calidad");
                    sentencia.setString(3, ordenTrabajo.getJustifiOt());
                    sentencia.setInt(4, ordenTrabajo.getIdOt());
                    sentencia.executeUpdate();
                    break;
            }                    
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

  
}
