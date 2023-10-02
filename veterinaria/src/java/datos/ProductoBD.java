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
import model.Producto;
import model.TipoProducto;

/**
 *
 * @author elian_estrada
 */
public class ProductoBD {
    
    Connection conexion;
    Statement stm;
    ResultSet result;
    
    public ArrayList<Producto> obtenerProductos() {
        ArrayList<Producto> productos = new ArrayList<>();
        
        try {
            
            conexion = ConectarBD.abrir();
            stm = conexion.createStatement();
            
            String query = "SELECT * FROM Producto;";
            
            result = stm.executeQuery(query);
            
            while (result.next()) {
                
                TipoProducto tipoProducto = TipoProducto.COMIDA;
                
                switch(result.getInt(6)){
                    case 1:
                        tipoProducto = TipoProducto.COMIDA;
                        break;
                    case 2:
                        tipoProducto = TipoProducto.JUGUETES;
                        break;
                    case 3:
                        tipoProducto = TipoProducto.MEDICINA;
                        break;
                }
                
                Producto producto = new Producto(
                        result.getString(2),
                        result.getFloat(3),
                        result.getInt(4),
                        result.getString(5),
                        tipoProducto
                );
                producto.setId(result.getInt(1));
                productos.add(producto);
                
            }
            
        } catch(Exception e) {
            System.out.println("Error al obtener productos: " + e.getMessage());
        }
        
        ConectarBD.cerrar();
        return productos;
    }
    
}
