package com.bytecode.ejemplopostgresclout.controlador;

import com.bytecode.ejemplopostgresclout.conexion.Conexion;
import com.bytecode.ejemplopostgresclout.modelo.Usuario;
import sun.util.logging.PlatformLogger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioServicio {
    private static final UsuarioServicio INSTACIA = new UsuarioServicio();
    private static UsuarioServicio INSTANCIA_UNICA = null;

    public UsuarioServicio(){

    }

    public static UsuarioServicio getInstacia(){
        return INSTACIA;
    }

    public static UsuarioServicio getInstaciaServicio(){
        if(INSTANCIA_UNICA == null){
            INSTANCIA_UNICA = new UsuarioServicio();
        }
        return INSTANCIA_UNICA;
    }

    public boolean Salvar(Usuario usuario)throws SQLException{

        String sqlListener = "INSERT INTO usuario(nombre, apellido, " +
                "responsable, sexoid_sexo, estado, fecha) " +
                "VALUES ( ?, ?, ?, ?, true, current_timestamp)";
        boolean datoSalvado = true;
        try (Connection con = Conexion.getInstancia().getConexion()){
            try (PreparedStatement pst = con.prepareStatement(sqlListener)){
                pst.setString(1, usuario.getNombre());
                pst.setString(2,usuario.getApellido());
                pst.setString(3,usuario.getResponsable());
                pst.setInt(4, usuario.getSexo());

                pst.executeUpdate();
                con.close();
            }

        } catch (SQLException e) {
            Logger.getLogger(UsuarioServicio.class.getName()).log(Level.SEVERE, e.getMessage());
        }
        return datoSalvado;


    }

}
