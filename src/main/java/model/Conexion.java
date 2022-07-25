/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KevinOcampo
 */
public class Conexion {
    // Declaramos la conexion a mysql

    private static Conexion laConexion;
    private static final String DBURL = "jdbc:mysql://localhost:3306/scfm;user=root;password=root";
    private static Connection conn = null;
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String user = "root";
    private static final String pass = "root";
    private static final String url = "jdbc:mysql://localhost:3306/scfm";

    public Conexion() {
        try {
            Class.forName(driver).getDeclaredConstructor().newInstance();
            conn = DriverManager.getConnection(url+"?autoReconnect=true&useUnicode=yes", user, pass);
        } catch (ClassNotFoundException | SQLException | InstantiationException
                | IllegalAccessException | NoSuchMethodException
                | InvocationTargetException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static synchronized Connection getConexion() {
        if (laConexion == null) {
            laConexion = new Conexion();
        }
        return conn;
    }
}
