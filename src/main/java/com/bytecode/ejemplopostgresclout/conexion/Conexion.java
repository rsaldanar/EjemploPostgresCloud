package com.bytecode.ejemplopostgresclout.conexion;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    public static Conexion conexion = new Conexion();

    static String db = "nombreDeLaBaseDatos";
    static String usuario = "postgres";
    static String pass = "claveAqui";
    static String host = "direccionIP:puertoAqui/";
    static String url = "jdbc:postgresql://"+ host + db;

    private static Conexion instancia = null;

    public static Conexion getInstancia(){
        if(instancia == null){
            instancia = new Conexion();
        }
        return instancia;
    }

    public Conexion(){

    }
    public static Connection getConexion(){
        try {
            Connection cn = DriverManager.getConnection(url, usuario, pass);
            return cn;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar" + e.getMessage());
        }return null;
    }
}
