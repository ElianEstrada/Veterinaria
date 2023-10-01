package controlador;

import datos.CitaBD;
import java.util.ArrayList;
import model.Cita;

public class ObtenerCita {
    
    public ArrayList<Cita> obtenerCita(int idCliente) {
        
        ArrayList<Cita> citas = new ArrayList<>();
        
        try {
            
            CitaBD citaBD = new CitaBD();
            citas = citaBD.obtenerCitas(idCliente);
            
            if (citas == null ) {
                System.out.println("Error al obtener citas");
            }
            
            return citas;
            
        } catch (Exception e ) {
            System.out.println("Error al obtener citas: " + e.getMessage());
        }
        
        return citas;
    }
    
}
