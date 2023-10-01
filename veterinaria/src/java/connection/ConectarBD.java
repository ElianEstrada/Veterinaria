/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connection;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author elian_estrada
 */
public class ConectarBD {

    public static Connection con;
    private static String bd = "veterinaria";
    private static String usuario = "root";
    private static String contra = "1234";
    private static String url = "jdbc:mysql://localhost/" + bd;
    
    public static Connection abrir() {
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, usuario, contra);
            
        } catch (Exception e) {
            System.out.println("Error en la conexion...");
            e.printStackTrace();
        }
        
        return con;
    }
    
    public static void cerrar() {
        try {
            if (con != null) {
                con.close();
            } 
        } catch (Exception e) {
            System.out.println("Error: No se logro cerra la conexión: \n" + e);
        }
    }
}
