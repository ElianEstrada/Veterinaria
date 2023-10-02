/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import connection.ConectarBD;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.ArrayList;
import model.Cita;

/**
 *
 * @author elian_estrada
 */
public class CitaBD {
    
    Connection conexion;
    Statement stm;
    ResultSet result;
    
    public boolean crearCita(Cita cita) {
        
        int filasAfecatadas = 0;
        
        try {
            
            conexion = ConectarBD.abrir();
            stm = conexion.createStatement();
            
            filasAfecatadas = stm.executeUpdate(MessageFormat.format(
                    "INSERT INTO Cita (nombreMascota, especie, fecha, horaInicio, horaFin, idCliente, idAdmin)"
                            + "VALUES(''{0}'', ''{1}'', ''{2}'', ''{3}'', ''{4}'', {5}, {6});", 
                    cita.getNombreMascota(),
                    cita.getEspecie(),
                    cita.getFecha(),
                    cita.getHoraInicio(),
                    cita.getHoraFin(),
                    cita.getIdCliente(),
                    1
            ));
            
            if (filasAfecatadas != 0) {
                ConectarBD.cerrar();
                return true;
            }
            
        } catch (Exception e) {
            System.out.println("Error al crear la cita: " + e.getMessage());
        }
        
        ConectarBD.cerrar();
        return false;
    }
    
    public boolean validarHorario(Cita cita) {
        try {
            
            conexion = ConectarBD.abrir();
            stm = conexion.createStatement();
            
            String query = MessageFormat.format(
                    "SELECT * FROM Cita WHERE fecha = ''{0}'' "
                            + "AND (''{1}'' BETWEEN horaInicio AND horaFin "
                            + "OR ''{2}'' BETWEEN horaInicio and horaFin);", 
                    cita.getFecha(),
                    cita.getHoraInicio(),
                    cita.getHoraFin()
            );
            
            System.out.println(query);
            
            result = stm.executeQuery(query);
            
            if (result.next()) {
                System.out.println("Ya existe una cita en este horario");
            } else {
                return true;
            }
            
        } catch (Exception e) {
            System.out.println("Error al buscar cita: " + e.getMessage());
        }
        
        ConectarBD.cerrar();
        return false;
    }
    
    public ArrayList<Cita> obtenerCitas(int idUsuario) {
        ArrayList<Cita> citas = new ArrayList<Cita>();
        
        try {
            
            conexion = ConectarBD.abrir();
            stm = conexion.createStatement();
            
            String query = MessageFormat.format(
                    "SELECT * FROM Cita WHERE idCliente = {0}", 
                    idUsuario
            );
            
            System.out.println(query);
            
            result = stm.executeQuery(query);
            
            while (result.next()) {
                Cita cita = new Cita(
                        result.getString(2), 
                        result.getString(3), 
                        result.getString(4), 
                        result.getString(5), 
                        result.getString(6), 
                        result.getInt(7)
                );
                cita.setId(result.getInt(1));
                citas.add(cita);
            } 
            
            System.out.println(citas);
            
            return citas;
            
        } catch (Exception e) {
            System.out.println("Error al obtener las citas: " + e.getMessage());
        }
        
        return null;
    }
    
    public ArrayList<Cita> obtenerCitasAdmin() {
        ArrayList<Cita> citas = new ArrayList<Cita>();
        
        try {
            
            conexion = ConectarBD.abrir();
            stm = conexion.createStatement();
            
            String query = "SELECT * FROM Cita;";
            
            System.out.println(query);
            
            result = stm.executeQuery(query);
            
            while (result.next()) {
                Cita cita = new Cita(
                        result.getString(2), 
                        result.getString(3), 
                        result.getString(4), 
                        result.getString(5), 
                        result.getString(6), 
                        result.getInt(7)
                );
                cita.setId(result.getInt(1));
                citas.add(cita);
            } 
            
            System.out.println(citas);
            
            return citas;
            
        } catch (Exception e) {
            System.out.println("Error al obtener las citas: " + e.getMessage());
        }
        
        return citas;
    }
    
}
