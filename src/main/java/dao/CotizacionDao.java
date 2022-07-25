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
import model.Cotizacion;
import model.MaterialList;

/**
 *
 * @author emily
 */
public class CotizacionDao {

    private static final String SQL_SELECT_COTIZIND
            = "SELECT * FROM cotizacion WHERE IdSoliServ = ?";
    private static final String SQL_SELECT_COTIZCREAR
            = "SELECT IdCotizacion FROM cotizacion WHERE IdSoliServ = ? AND Total IS NOT NULL";
    private static final String SQL_SELECT_PRETOTAL
            = "SELECT SUM(a.PrecioMate*b.CantOcupar) FROM materiales a, materialeslist b WHERE b.IdSoliServ=? AND a.IdMaterial=b.IdMaterial";
    private static final String SQL_SELECT_MATELIST
            = "SELECT a.IdMateList, a.IdMaterial, a.IdSoliServ, a.CantOcupar, b.NomMate FROM materialeslist a, materiales b WHERE a.IdSoliServ = ? AND a.IdMaterial=b.IdMaterial";

    /*METODO CREAR NUEVO*/
    private static int Total;

    public static int getTotal() {
        return Total;
    }

    public static void setTotal(int Total) {
        CotizacionDao.Total = Total;
    }

    public boolean crearCotiz(Cotizacion cotiz) {
        try {
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(SQL_SELECT_PRETOTAL);
            consulta.setInt(1, cotiz.getIdSoliServ());
            ResultSet datos = consulta.executeQuery();
            if (datos != null && datos.next()) {
                Total = datos.getInt(1) + cotiz.getPreTrans() + cotiz.getPreInsta();
            }
            String consulta2 = "UPDATE cotizacion SET PreTrans = ?, PreInsta = ?, Total = ? WHERE IdSoliServ = ?;";
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(consulta2);
            sentencia.setInt(1, cotiz.getPreTrans());
            sentencia.setInt(2, cotiz.getPreInsta());
            sentencia.setInt(3, Total);
            sentencia.setInt(4, cotiz.getIdSoliServ());
            sentencia.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public boolean crearCoti(int IdSoliS) {
        try {
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(SQL_SELECT_COTIZIND);
            consulta.setInt(1, IdSoliS);
            ResultSet datos = consulta.executeQuery();
            PreparedStatement consulta2 = Conexion.getConexion().prepareStatement(SQL_SELECT_COTIZCREAR);
            consulta2.setInt(1, IdSoliS);
            ResultSet datos2 = consulta2.executeQuery();
            if (!datos.next()) {
                String consulta3 = "INSERT INTO cotizacion (IdSoliServ) VALUES(?)";
                PreparedStatement sentencia = Conexion.getConexion().prepareStatement(consulta3);
                sentencia.setInt(1, IdSoliS);
                sentencia.executeUpdate();

            } else if (!datos2.next()) {
                String consulta3 = "UPDATE cotizacion SET PreTrans = ?, PreInsta = ? WHERE IdSoliServ = ?;";
                PreparedStatement sentencia2 = Conexion.getConexion().prepareStatement(consulta3);
                sentencia2.setInt(1, 0);
                sentencia2.setInt(2, 0);
                sentencia2.setInt(3, IdSoliS);
                sentencia2.executeUpdate();
            } else {
                return false;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }

    public static ArrayList<MaterialList> getMateList(int IdSoli) {
        ArrayList<MaterialList> lista = new ArrayList<>();
        try {
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(SQL_SELECT_MATELIST);
            consulta.setInt(1, IdSoli);
            ResultSet datos = consulta.executeQuery();
            while (datos != null && datos.next()) {
                lista.add(new MaterialList(
                        datos.getInt(1),
                        datos.getInt(2),
                        datos.getInt(3),
                        datos.getInt(4),
                        datos.getString(5)));
            }
        } catch (SQLException e) {
            Logger.getLogger(MaterialListDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return lista;
    }

    /*METODO VISUALIZAR DATOS DE ID ESPECIFICO*/
    public static Cotizacion getCotizacion(int IdOrdenSer) {
        Cotizacion cotizacion = null;
        try {
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(SQL_SELECT_COTIZIND);
            consulta.setInt(1, IdOrdenSer);
            ResultSet datos = consulta.executeQuery();
            if (datos != null && datos.next()) {
                cotizacion = new Cotizacion(
                        datos.getInt(1),
                        datos.getInt(2),
                        datos.getInt(3),
                        datos.getInt(4),
                        datos.getInt(5)
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrdenSerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cotizacion;
    }
}
