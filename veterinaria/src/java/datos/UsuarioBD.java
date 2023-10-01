/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import connection.ConectarBD;
import model.Usuario;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.text.MessageFormat;
import javax.swing.JOptionPane;
import model.TipoUsuario;

/**
 *
 * @author elian_estrada
 */
public class UsuarioBD {

    Connection conexion;
    Statement stm;
    ResultSet result;

    public boolean insertarUsuario(Usuario usuario) {

        int filasAfectadas = 0;

        try {

            conexion = ConectarBD.abrir();
            stm = conexion.createStatement();

            filasAfectadas = stm.executeUpdate(MessageFormat.format(
                    "INSERT INTO Usuario (nombre, correo, contrasenia, idTipoUsuario)"
                            + "values (''{0}'', ''{1}'', ''{2}'', {3});",
                    usuario.getNombre(),
                    usuario.getCorreo(),
                    usuario.getContrasenia(),
                    usuario.getTipo().getValor())
            );

            if (filasAfectadas != 0) {
                ConectarBD.cerrar();
                return true;
            }

        } catch (Exception e) {
            System.out.println("Error en la base de datos");
            e.printStackTrace();
        }

        ConectarBD.cerrar();
        return false;
    }

    public Usuario buscarUsuario(String correo, String contrasenia) {

        try {
            conexion = ConectarBD.abrir();
            stm = conexion.createStatement();

            String query = MessageFormat.format(
                    "SELECT * FROM Usuario WHERE correo = ''{0}'' AND contrasenia = ''{1}'';",
                    correo, contrasenia
            );

            System.out.println(query);
            
            result = stm.executeQuery(query);

            if (result.next()) {
                System.out.println("Usuario encontrado");

                int tipo = result.getInt(5);

                TipoUsuario tipoUsuario = (tipo == 1)
                        ? TipoUsuario.ADMINISTRADOR
                        : TipoUsuario.CLIENTE;

                Usuario usuario = new Usuario(
                        result.getString(2),
                        result.getString(3),
                        result.getString(4),
                        tipoUsuario
                );

                usuario.setId(result.getInt(1));

                ConectarBD.cerrar();
                return usuario;
            }

            System.out.println("No se encontro el usuario");

        } catch (Exception e) {
            System.out.println("Error al obtener el usuario: " + e.getMessage());
        }

        ConectarBD.cerrar();
        return null;
    }

}
