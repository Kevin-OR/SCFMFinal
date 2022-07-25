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
import model.OrdRepa;

/**
 *
 * @author Asus
 */
public class OrdRepaDao {

    private static final String SQL_SELECT_ORDENESREPA_CALI
            = "SELECT a.IdOrdRepa, a.IdOt, a.JustifOR, a.ResponOR, a.ModuloOR, b.NombClient, b.PriApeClient, b.Proyecto FROM ordenrepa a, soliservicio b, ordentraba c WHERE a.IdOt = c.IdOT AND c.IdSoliServ = b.IdSoliServ AND a.ModuloOR = 4 ORDER BY a.IdOrdRepa DESC";

    private static final String SQL_SELECT_ORDENESREPA_LOGI
            = "SELECT a.IdOrdRepa, a.IdOt, a.JustifOR, a.ResponOR, a.ModuloOR, b.NombClient, b.PriApeClient, b.Proyecto FROM ordenrepa a, soliservicio b, ordentraba c WHERE a.IdOt = c.IdOT AND c.IdSoliServ = b.IdSoliServ AND a.ModuloOR = 5 ORDER BY a.IdOrdRepa DESC";

    private static final String SQL_SELECT_ORDENESREPA_GARAN
            = "SELECT a.IdOrdRepa, a.IdOt, a.JustifOR, a.ResponOR, a.ModuloOR, b.NombClient, b.PriApeClient, b.Proyecto FROM ordenrepa a, soliservicio b, ordentraba c WHERE a.IdOt = c.IdOT AND c.IdSoliServ = b.IdSoliServ AND a.ModuloOR = 6 ORDER BY a.IdOrdRepa DESC";

    private static final String SQL_SELECT_ORDENREPA
            = "SELECT a.IdOrdRepa, a.IdOt, a.JustifOR, a.ResponOR, a.ModuloOR, b.NombClient, b.PriApeClient, b.Proyecto, d.url FROM ordenrepa a, soliservicio b, ordentraba c, imagen d WHERE a.IdOrdRepa = ? AND d.tipo = ? AND a.IdOt = c.IdOT AND c.IdSoliServ = b.IdSoliServ AND a.IdOt = d.IdOt";

    public boolean crearOR(int Modulo, OrdRepa ordRepa) {
        try {
            String consulta = "INSERT INTO ordenrepa(IdOt, JustifOR, ResponOR, ModuloOR)"
                    + "VALUES(?, ?, ?, ?)";
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(consulta);
            sentencia.setInt(1, ordRepa.getIdOt());
            sentencia.setString(2, ordRepa.getJustifOR());
            sentencia.setInt(3, ordRepa.getResponOR());
            sentencia.setInt(4, Modulo);
            sentencia.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public static ArrayList<OrdRepa> getOrdenesRepaCali() {
        ArrayList<OrdRepa> lista = new ArrayList<>();
        try {
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(SQL_SELECT_ORDENESREPA_CALI);
            ResultSet datos = consulta.executeQuery();
            while (datos != null && datos.next()) {
                lista.add(new OrdRepa(
                        datos.getInt(1),
                        datos.getInt(2),
                        datos.getString(3),
                        datos.getInt(4),
                        datos.getInt(5),
                        datos.getString(6),
                        datos.getString(7),
                        datos.getString(8)));
            }
        } catch (SQLException e) {
            Logger.getLogger(OrdRepaDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return lista;
    }

    public static ArrayList<OrdRepa> getOrdenesRepaLogi() {
        ArrayList<OrdRepa> lista = new ArrayList<>();
        try {
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(SQL_SELECT_ORDENESREPA_LOGI);
            ResultSet datos = consulta.executeQuery();
            while (datos != null && datos.next()) {
                lista.add(new OrdRepa(
                        datos.getInt(1),
                        datos.getInt(2),
                        datos.getString(3),
                        datos.getInt(4),
                        datos.getInt(5),
                        datos.getString(6),
                        datos.getString(7),
                        datos.getString(8)));
            }
        } catch (SQLException e) {
            Logger.getLogger(OrdRepaDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return lista;
    }

    public static ArrayList<OrdRepa> getOrdenesRepaGaran() {
        ArrayList<OrdRepa> lista = new ArrayList<>();
        try {
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(SQL_SELECT_ORDENESREPA_GARAN);
            ResultSet datos = consulta.executeQuery();
            while (datos != null && datos.next()) {
                lista.add(new OrdRepa(
                        datos.getInt(1),
                        datos.getInt(2),
                        datos.getString(3),
                        datos.getInt(4),
                        datos.getInt(5),
                        datos.getString(6),
                        datos.getString(7),
                        datos.getString(8)));
            }
        } catch (SQLException e) {
            Logger.getLogger(OrdRepaDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return lista;
    }

    /*METODO VISUALIZAR DATOS DE ID ESPECIFICO*/
    public static OrdRepa getOrdenRepa(int IdOrdRepa, int tipo) {
        OrdRepa OrdRepa = null;
        try {

            PreparedStatement consulta = Conexion.getConexion().prepareStatement(SQL_SELECT_ORDENREPA);
            switch (tipo) {
                case 7:
                    consulta.setInt(1, IdOrdRepa);
                    consulta.setInt(2, tipo);
                    break;
                case 8:
                    consulta.setInt(1, IdOrdRepa);
                    consulta.setInt(2, tipo);

                    break;
                case 9:
                    consulta.setInt(1, IdOrdRepa);
                    consulta.setInt(2, tipo);

                    break;
            }
            ResultSet datos = consulta.executeQuery();
            if (datos != null && datos.next()) {
                OrdRepa = new OrdRepa(
                        datos.getInt(1),
                        datos.getInt(2),
                        datos.getString(3),
                        datos.getInt(4),
                        datos.getInt(5),
                        datos.getString(6),
                        datos.getString(7),
                        datos.getString(8),
                        datos.getString(9)
                );
            }
        } catch (SQLException e) {
            Logger.getLogger(OrdRepaDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return OrdRepa;
    }

    public static boolean modificar(OrdRepa ordRepa) {
        try {
            String consulta = "UPDATE ordenrepa SET JustifOR = ?, ResponOR = ? WHERE IdOrdRepa = ?";
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(consulta);
            sentencia.setString(1, ordRepa.getJustifOR());
            sentencia.setInt(2, ordRepa.getResponOR());
            sentencia.setInt(3, ordRepa.getIdOrdRepa());
            sentencia.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public static boolean enviarOR(OrdRepa ordRepa) {
        try {
            String consulta = "UPDATE ordentraba SET EnvioOT = ?, EstadoOT = ? WHERE IdOt = ?";
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(consulta);
            sentencia.setInt(1, 2);
            sentencia.setString(2, "En Reparación");
            sentencia.setInt(3, ordRepa.getIdOt());
            sentencia.executeUpdate();
            String consulta2 = "DELETE FROM ordenrepa WHERE IdOrdRepa=?";
            PreparedStatement sentencia2 = Conexion.getConexion().prepareStatement(consulta2);
            sentencia2.setInt(1, ordRepa.getIdOrdRepa());
            sentencia2.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

}
