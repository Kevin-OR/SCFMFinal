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
import model.Cronograma;
import model.TareasCrono;



/**
 *
 * @author emily
 */
public class CronogramaDao{
    private static final String SQL_SELECT_CRONOIND
            = "SELECT * FROM cronograma WHERE IdOt = ?";
    private static final String SQL_SELECT_CRONOCREAR
            = "SELECT IdCrono FROM cronograma WHERE IdOt = ? AND CronoGuardado IS NOT NULL";
    private static final String SQL_SELECT_TAREASC
            = "SELECT a.IdTareaC, a.IdOt, a.NomTarea, a.FechaFin, a.IdPersonal, b.Nombre FROM tareascrono a, personal b WHERE a.IdOt = ? AND a.IdPersonal=b.IdPersonal";

    /*METODO CREAR NUEVO*/
    

    public boolean crearCronos(Cronograma crono) {
        try {
            String consulta2 = "UPDATE cronograma SET CronoGuardado = ? WHERE IdOt = ?;";
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(consulta2);
            sentencia.setInt(1, 1);
            sentencia.setInt(2, crono.getIdOt());
            sentencia.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public boolean crearCrono(int IdOt) {
        try {
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(SQL_SELECT_CRONOIND);
            consulta.setInt(1, IdOt);
            ResultSet datos = consulta.executeQuery();
            PreparedStatement consulta2 = Conexion.getConexion().prepareStatement(SQL_SELECT_CRONOCREAR);
            consulta2.setInt(1, IdOt);
            ResultSet datos2 = consulta2.executeQuery();
            if (!datos.next()) {
                String consulta3 = "INSERT INTO cronograma (IdOt) VALUES(?)";
                PreparedStatement sentencia = Conexion.getConexion().prepareStatement(consulta3);
                sentencia.setInt(1, IdOt);
                sentencia.executeUpdate();

            } else if (!datos2.next()) {
                String consulta3 = "UPDATE cronograma SET CronoFinal = ? WHERE IdOt = ?";
                PreparedStatement sentencia2 = Conexion.getConexion().prepareStatement(consulta3);
                sentencia2.setInt(1, 0);
                sentencia2.setInt(2, IdOt);
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

    public static ArrayList<TareasCrono> getTareas(int IdOt) {
        ArrayList<TareasCrono> lista = new ArrayList<>();
        try {
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(SQL_SELECT_TAREASC);
            consulta.setInt(1, IdOt);
            ResultSet datos = consulta.executeQuery();
            while (datos != null && datos.next()) {
                lista.add(new TareasCrono(
                        datos.getInt(1),
                        datos.getInt(2),
                        datos.getString(3),
                        datos.getString(4),
                        datos.getInt(5),
                        datos.getString(6)
                ));
            }
        } catch (SQLException e) {
            Logger.getLogger(CronogramaDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return lista;
    }

    /*METODO VISUALIZAR DATOS DE ID ESPECIFICO*/
    public static Cronograma getCrono(int IdOt) {
        Cronograma cronograma = null;
        try {
            PreparedStatement consulta = Conexion.getConexion().prepareStatement(SQL_SELECT_CRONOIND);
            consulta.setInt(1, IdOt);
            ResultSet datos = consulta.executeQuery();
            if (datos != null && datos.next()) {
                cronograma = new Cronograma(
                        datos.getInt(1),
                        datos.getInt(2),
                        datos.getInt(3),
                        datos.getInt(4)
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(CronogramaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cronograma;
    }
}
