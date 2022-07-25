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
import model.DiseñoFinal;

/**
 *
 * @author Asus
 */
public class DiseñoFinalDao {

    private static final String SQL_SELECT_DISENOSFINALES
            = "SELECT IdDiseFinal, IdSoliServ, NombreArc FROM disefinal";

    private static final String SQL_SELECT_DISENOFI
            = "SELECT IdSoliServ, NombreArc FROM disefinal WHERE IdDiseFinal = ?";

    /*VISUALIZAR DATOS EN TABLA*/
    public static ArrayList<DiseñoFinal> getDisenosFin() {
        ArrayList<DiseñoFinal> lista = new ArrayList<>();
        try {
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(SQL_SELECT_DISENOSFINALES);
            ResultSet datos = consulta.executeQuery();
            while (datos != null && datos.next()) {
                lista.add(new DiseñoFinal(
                        datos.getInt(1),
                        datos.getInt(2),
                        datos.getString(3)));
            }
        } catch (SQLException e) {
            Logger.getLogger(DiseñoFinalDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return lista;
    }

    /*VISUALIZAR DATOS DE ID ESPECIFICO*/
    public static DiseñoFinal getDisenoFin(int IdDiseFinal) {
        DiseñoFinal diseñoFinal = null;
        try {
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(SQL_SELECT_DISENOFI);
            consulta.setInt(1, IdDiseFinal);
            ResultSet datos = consulta.executeQuery();
            if (datos != null && datos.next()) {
                diseñoFinal = new DiseñoFinal(
                        datos.getInt(1),
                        datos.getInt(2),
                        datos.getString(3)
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(DiseñoFinalDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return diseñoFinal;
    }

    public static boolean actualizarDiseF(DiseñoFinal diseñoFinal) {
        try {
            String consulta = "UPDATE disefinal SET IdOrdenSer = ?, NombreArc = ? WHERE  IdDiseFinal = ?";
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(consulta);
            sentencia.setInt(1, diseñoFinal.getIdOrdenSer());
            sentencia.setString(2, diseñoFinal.getNombreArc());
            sentencia.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

}
