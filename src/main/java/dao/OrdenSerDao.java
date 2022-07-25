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
import model.OrdenServicioBD;

/**
 *
 * @author emily
 */
public class OrdenSerDao {

    private static final String SQL_SELECT_ORDENESSER
            = "SELECT * FROM ordenservicio ORDER BY IdOrdenSer DESC";

    private static final String SQL_SELECT_ORDENSER
            = "SELECT * FROM ordenservicio WHERE IdOrdenSer = ?";

    /*METODO CREAR NUEVO*/
    public boolean crearOrdenS(OrdenServicioBD ordenS) {
        try {
            String consulta = "INSERT INTO ordenservicio(Cliente, VisitaUno, VisitaDos, Direccion, FechaVisi, HoraVisi, IdEspacio, Muestra, Estado)"
                    + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(consulta);
            sentencia.setString(1, ordenS.getCliente());
            sentencia.setInt(2, ordenS.getVisitaUno());
            sentencia.setInt(3, ordenS.getVisitaDos());
            sentencia.setString(4, ordenS.getDireccion());
            sentencia.setString(5, ordenS.getFechaVisi());
            sentencia.setString(6, ordenS.getHoraVisi());
            sentencia.setInt(7, ordenS.getIdEspacio());
            sentencia.setString(8, ordenS.getMuestra());
            sentencia.setString(9, ordenS.getEstado());
            sentencia.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    /*METODO VISUALIZAR DATOS EN TABLA*/
    public static ArrayList<OrdenServicioBD> getOrdenesSer() {
        ArrayList<OrdenServicioBD> lista = new ArrayList<>();
        try {
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(SQL_SELECT_ORDENESSER);
            ResultSet datos = consulta.executeQuery();
            while (datos != null && datos.next()) {
                lista.add(new OrdenServicioBD(
                        datos.getInt(1),
                        datos.getString(2),
                        datos.getInt(3),
                        datos.getInt(4),
                        datos.getString(5),
                        datos.getString(6),
                        datos.getString(7),
                        datos.getInt(8),
                        datos.getString(9),
                        datos.getString(10)));
            }
        } catch (SQLException e) {
            Logger.getLogger(OrdenSerDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return lista;
    }

    /*METODO VISUALIZAR DATOS DE ID ESPECIFICO*/
    public static OrdenServicioBD getOrdenServicioBD(int IdOrdenSer) {
        OrdenServicioBD ordenServicioBD = null;
        try {
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(SQL_SELECT_ORDENSER);
            consulta.setInt(1, IdOrdenSer);
            ResultSet datos = consulta.executeQuery();
            if (datos != null && datos.next()) {
                ordenServicioBD = new OrdenServicioBD(
                        datos.getInt(1),
                        datos.getString(2),
                        datos.getInt(3),
                        datos.getInt(4),
                        datos.getString(5),
                        datos.getString(6),
                        datos.getString(7),
                        datos.getInt(8),
                        datos.getString(9),
                        datos.getString(10)
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrdenSerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ordenServicioBD;
    }

    /*METODO MODIFICAR DATOS*/
    public static boolean modificar(OrdenServicioBD ordenServicioBD) {
        try {
            String consulta = "UPDATE ordenservicio SET Cliente = ?, VisitaUno = ?, VisitaDos = ?, Direccion = ?, FechaVisi = ?, HoraVisi = ?, "
                    + " IdEspacio = ?, Muestra = ?, Estado = ? WHERE IdOrdenSer = ?";
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(consulta);
            sentencia.setString(1, ordenServicioBD.getCliente());
            sentencia.setInt(2, ordenServicioBD.getVisitaUno());
            sentencia.setInt(3, ordenServicioBD.getVisitaDos());
            sentencia.setString(4, ordenServicioBD.getDireccion());
            sentencia.setString(5, ordenServicioBD.getFechaVisi());
            sentencia.setString(6, ordenServicioBD.getHoraVisi());
            sentencia.setInt(7, ordenServicioBD.getIdEspacio());
            sentencia.setString(8, ordenServicioBD.getMuestra());
            sentencia.setString(9, ordenServicioBD.getEstado());
            sentencia.setInt(10, ordenServicioBD.getIdOrdenSer());
            sentencia.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

}
