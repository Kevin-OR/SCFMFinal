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
import model.SoliServ;

/**
 *
 * @author Asus
 */
public class SoliServDao {

    private static final String SQL_SELECT_SOLIS
            = "SELECT * FROM soliservicio";

    private static final String SQL_SELECT_SOLIMages
            = "SELECT IdSoliServ,NombClient,PriApeClient,SegApeClient,Proyecto FROM soliservicio";
    private static final String SQL_SELECT_TaIma
            = "SELECT a.IdSoliServ, b.url, b.idIm FROM soliservicio a, imagen b WHERE a.IdSoliServ = b.IdSoliServ AND b.tipo=2 AND a.IdSoliServ=?";

    private static final String SQL_SELECT_SOLISER
            = "SELECT * FROM soliservicio WHERE IdSoliServ = ?";

    private static final String SQL_SELECT_ENVIOSS
            = "SELECT * FROM soliservicio WHERE EnvioSS = 1";
    
    private static final String SQL_INSERT_Ult = "SELECT MAX(IdSoliServ) FROM soliservicio";
    
    private static final String SQL_DELETE_SOLISER= "DELETE FROM soliservicio WHERE IdSoliServ=?";
    
    public static SoliServ getUl() {
        SoliServ SoliServ = null;
        try {
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(SQL_INSERT_Ult);
            ResultSet datos = consulta.executeQuery();
            if (datos != null && datos.next()) {
                SoliServ = new SoliServ(
                        datos.getInt(1)
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(SoliServDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return SoliServ;
    }

    public static ArrayList<SoliServ> getTaIma(int id) {
        ArrayList<SoliServ> lista = new ArrayList<>();
        try {
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(SQL_SELECT_TaIma);
            consulta.setInt(1, id);
            ResultSet datos = consulta.executeQuery();
            while (datos != null && datos.next()) {
                lista.add(new SoliServ(
                        datos.getInt(1),
                        datos.getString(2),     
                        datos.getInt(3)
                        ));
            }
        } catch (SQLException e) {
            Logger.getLogger(SoliServDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return lista;
    }
    
    
    public static ArrayList<SoliServ> getSOLIMages() {
        ArrayList<SoliServ> lista = new ArrayList<>();
        try {
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(SQL_SELECT_SOLIMages);
            ResultSet datos = consulta.executeQuery();
            while (datos != null && datos.next()) {
                lista.add(new SoliServ(
                        datos.getInt(1),
                        datos.getString(2),
                        datos.getString(3),
                        datos.getString(4),
                        datos.getString(5)
                ));
            }
        } catch (SQLException e) {
            Logger.getLogger(SoliServDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return lista;
    }

    /*VISUALIZAR DATOS EN TABLA*/
    public static ArrayList<SoliServ> getSolisS() {
        ArrayList<SoliServ> lista = new ArrayList<>();
        try {
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(SQL_SELECT_SOLIS);
            ResultSet datos = consulta.executeQuery();
            while (datos != null && datos.next()) {
                lista.add(new SoliServ(
                        datos.getInt(1),
                        datos.getString(2),
                        datos.getString(3),
                        datos.getString(4),
                        datos.getString(5),
                        datos.getInt(6),
                        datos.getInt(7),
                        datos.getInt(8),
                        datos.getString(9),
                        datos.getString(10),
                        datos.getString(11),
                        datos.getString(12),
                        datos.getString(13),
                        datos.getString(14),
                        datos.getString(15), 
                        datos.getString(16)));
            }
        } catch (SQLException e) {
            Logger.getLogger(SoliServDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return lista;
    }

    /*VISUALIZAR DATOS DE ID ESPECIFICO*/
    public static SoliServ getSoliServ(int IdSoliServ) {
        SoliServ soliServ = null;
        try {
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(SQL_SELECT_SOLISER);
            consulta.setInt(1, IdSoliServ);
            ResultSet datos = consulta.executeQuery();
            if (datos != null && datos.next()) {
                soliServ = new SoliServ(
                        datos.getInt(1),
                        datos.getString(2),
                        datos.getString(3),
                        datos.getString(4),
                        datos.getString(5),
                        datos.getInt(6),
                        datos.getInt(7),
                        datos.getInt(8),
                        datos.getString(9),
                        datos.getString(10),
                        datos.getString(11),
                        datos.getString(12),
                        datos.getString(13),
                        datos.getString(14),
                        datos.getString(15),
                        datos.getString(16)
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(SoliServDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return soliServ;
    }

    public static boolean actualizarSoli(SoliServ soliServ) {
        try {
            String consulta = "UPDATE soliservicio SET NombClient = ?, PriApeClient = ?, SegApeClient = ?, Proyecto = ?, IdTipoCedu = ?, Cedula = ?, Telefono = ?, "
                    + " Direccion = ?, NotasMue = ?, NotasDise = ?, DisenoCli = ?, NotasMedi = ?, NotasElem = ? WHERE IdSoliServ = ?";
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(consulta);
            sentencia.setString(1, soliServ.getNombClient());
            sentencia.setString(2, soliServ.getPriApeClient());
            sentencia.setString(3, soliServ.getSegApeClient());
            sentencia.setString(4, soliServ.getProyecto());
            sentencia.setInt(5, soliServ.getIdTipoCedu());
            sentencia.setInt(6, soliServ.getCedula());
            sentencia.setInt(7, soliServ.getTelefono());
            sentencia.setString(8, soliServ.getDireccion());
            sentencia.setString(9, soliServ.getNotasMue());
            sentencia.setString(10, soliServ.getNotasDise());
            sentencia.setString(11, soliServ.getDisenoCli());
            sentencia.setString(12, soliServ.getNotasMedi());
            sentencia.setString(13, soliServ.getNotasElem());
            sentencia.setInt(15, soliServ.getIdSoliServ());
            sentencia.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
    
    public static boolean clasifSS(SoliServ soliServ) {
        try {
            String consulta = "UPDATE soliservicio SET EstadoSS = ?, ClasifiSS = ? WHERE IdSoliServ = ?";
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(consulta);
            sentencia.setString(1, "Aceptada");
            sentencia.setString(2, soliServ.getClasifiSS());
            sentencia.setInt(3, soliServ.getIdSoliServ());
            sentencia.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public boolean crearSoliS(SoliServ soliS) {
        try {
            String consulta = "INSERT INTO soliservicio(NombClient, PriApeClient, SegApeClient, Proyecto, IdTipoCedu, Cedula, Telefono, Direccion, NotasMue, NotasDise, DisenoCli, NotasMedi, NotasElem)"
                    + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(consulta);
            sentencia.setString(1, soliS.getNombClient());
            sentencia.setString(2, soliS.getPriApeClient());
            sentencia.setString(3, soliS.getSegApeClient());
            sentencia.setString(4, soliS.getProyecto());
            sentencia.setInt(5, soliS.getIdTipoCedu());
            sentencia.setInt(6, soliS.getCedula());
            sentencia.setInt(7, soliS.getTelefono());
            sentencia.setString(8, soliS.getDireccion());
            sentencia.setString(9, soliS.getNotasMue());
            sentencia.setString(10, soliS.getNotasDise());
            sentencia.setString(11, soliS.getDisenoCli());
            sentencia.setString(12, soliS.getNotasMedi());
            sentencia.setString(13, soliS.getNotasElem());
            sentencia.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public static boolean modificarRecha(SoliServ soliServ) {
        try {
            String consulta = "UPDATE soliservi SET EstadoSS = ?, Justifiss = ? WHERE IdSoliServ = ?";
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(consulta);
            sentencia.setString(1, "Rechazada");
            sentencia.setString(2, soliServ.getJustifiss());
            sentencia.setInt(3, soliServ.getIdSoliServ());
            sentencia.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public static ArrayList<SoliServ> getEnvioSS() {
        ArrayList<SoliServ> lista = new ArrayList<>();
        try {
            PreparedStatement consulta = Conexion.getConexion()
                    .prepareStatement(SQL_SELECT_ENVIOSS);
            ResultSet datos = consulta.executeQuery();
            while (datos != null && datos.next()) {
                lista.add(new SoliServ(
                        datos.getInt(1),
                        datos.getString(2),
                        datos.getString(3),
                        datos.getString(4),
                        datos.getString(5),
                        datos.getInt(6),
                        datos.getInt(7),
                        datos.getInt(8),
                        datos.getString(9),
                        datos.getString(10),
                        datos.getString(11),
                        datos.getString(12),
                        datos.getString(13),
                        datos.getString(14),
                        datos.getString(15),
                        datos.getString(16)
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SoliServDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public static boolean enviado(SoliServ soliServ) {
        try {
            String consulta = "UPDATE soliservicio SET EnvioSS = ?  WHERE IdSoliServ = ?;";
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(consulta);
            sentencia.setInt(1, 1);
            sentencia.setInt(2, soliServ.getIdSoliServ());
            sentencia.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
    
    
}
