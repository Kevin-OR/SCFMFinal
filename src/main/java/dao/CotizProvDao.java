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
import model.CotizProv;

/**
 *
 * @author Asus
 */
public class CotizProvDao {

    private static final String SQL_SELECT_COTIZACIONESPRO
            = "SELECT a.IdCotizProv, a.IdSoliServ, a.PrecioTotal, b.NombClient, b.PriApeClient, b.Proyecto FROM cotizprov a, soliservicio b WHERE a.IdSoliServ = b.IdSoliServ ORDER BY IdCotizProv DESC";

    private static final String SQL_SELECT_COTIZPRO
            = "SELECT a.IdCotizProv, a.IdSoliServ, a.PrecioTotal, b.url FROM cotizprov a, imagen b WHERE a.IdSoliServ = b.IdSoliServ AND b.tipo = 3 AND a.IdSoliServ = ?";

    public static ArrayList<CotizProv> getCotizacionesPro() {
        ArrayList<CotizProv> lista = new ArrayList<>();
        try {
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(SQL_SELECT_COTIZACIONESPRO);
            ResultSet datos = consulta.executeQuery();
            while (datos != null && datos.next()) {
                lista.add(new CotizProv(
                        datos.getInt(1),
                        datos.getInt(2),
                        datos.getInt(3),
                        datos.getString(4),
                        datos.getString(5),
                        datos.getString(6)
            
         ));
            }
        } catch (SQLException e) {
            Logger.getLogger(CotizProvDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return lista;
    }

    public boolean crearCotizP(CotizProv cotizProv) {
        try {
            String consulta = "INSERT INTO cotizprov(IdSoliServ, PrecioTotal)"
                    + "VALUES(?, ?)";
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(consulta);
            sentencia.setInt(1, cotizProv.getIdSoliServ());
            sentencia.setInt(2, cotizProv.getPrecioTotal());
            sentencia.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public static CotizProv getCotizP(int IdSoliServ) {
        CotizProv cotizProv = null;
        try {
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(SQL_SELECT_COTIZPRO);
            consulta.setInt(1, IdSoliServ);
            ResultSet datos = consulta.executeQuery();
            if (datos != null && datos.next()) {
                cotizProv = new CotizProv(
                        datos.getInt(1),
                        datos.getInt(2),
                        datos.getInt(3),
                        datos.getString(4)
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(CotizProvDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cotizProv;
    }

}
