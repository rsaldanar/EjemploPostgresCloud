package com.bytecode.ejemplopostgresclout.conexion;

import javax.swing.*;
import java.sql.Connection;

public class PruebaConexion {


    public static void main(String[]args){
        Conexion con = new Conexion();

        Connection connection = con.getConexion();

        if(connection == null){
            con.getConexion();
            System.out.println("Error al Conectar");
        }else {
            System.out.println("SI ME CONECTE");
        }
    }
}
