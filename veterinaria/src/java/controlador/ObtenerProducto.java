package controlador;

import datos.ProductoBD;
import java.util.ArrayList;
import model.Producto;


public class ObtenerProducto {

    public ArrayList<Producto> obtenerProductos() {
        ArrayList<Producto> productos = new ArrayList<>();
        
        try {
            
            ProductoBD productoBD = new ProductoBD();
            productos = productoBD.obtenerProductos();
            
            if (productos == null) {
                System.out.println("Error al obtener productos");
            }
            
        } catch(Exception e) {
            System.out.println("Error al obtener productos: " + e.getMessage());
        }
        
        return productos;
    }
}
