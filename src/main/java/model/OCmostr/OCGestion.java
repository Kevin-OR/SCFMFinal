/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.OCmostr;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Conexion;
import model.ManoObra.MOGestion;
import model.OrdenTraba.OrdenTrabaGestion;


/**
 *
 * @author KevinOcampo
 */
public class OCGestion {
    
    private static final String SQL_SELECT_ordentrabajos
            = "SELECT a.IdOt, b.NombClient, b.PriApeClient, b.SegApeClient, "
            + "b.Proyecto, a.EstadoCM FROM ordentraba a, soliservicio b WHERE  "
            + "a.IdSoliServ = b.IdSoliServ AND a.EnvioOC=1;";
    
    private static final String SQL_SELECT_ListaMAte="SELECT b.NomMate, "
            + "a.CantCompra FROM compramate a, materiales b WHERE "
            + "a.IdMaterial=b.IdMaterial and IdOt= ?";
    
    private static final String SQL_UPDATE_MO="UPDATE ordentraba SET "
            + "EstadoCM='Aceptada' WHERE IdOt= ?;";
    
    
    public static ArrayList<TablaMList> getMOTa(int id) {
        ArrayList<TablaMList> lista = new ArrayList<>();
        try {
            PreparedStatement consulta = Conexion.getConexion()
                    .prepareStatement(SQL_SELECT_ListaMAte);
            consulta.setInt(1, id);
            ResultSet datos = consulta.executeQuery();
            while (datos != null && datos.next()) {
                lista.add(new TablaMList(
                        datos.getString(1),
                        datos.getInt(2)
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(OCGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    public static ArrayList<TablaOC> getTablaOC() {
        ArrayList<TablaOC> lista = new ArrayList<>();
        try {
            PreparedStatement consulta = Conexion.getConexion()
                    .prepareStatement(SQL_SELECT_ordentrabajos);
            ResultSet datos = consulta.executeQuery();
            while (datos != null && datos.next()) {
                lista.add(new TablaOC(
                        datos.getInt(1),
                        datos.getString(2),
                        datos.getString(3),
                        datos.getString(4),
                        datos.getString(5),
                        datos.getString(6)
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(OCGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
     public static boolean modificar(int id) {
        try {
            
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(SQL_UPDATE_MO);
            sentencia.setInt(1, id);

            return sentencia.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(OCGestion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }
    
        
    
}

