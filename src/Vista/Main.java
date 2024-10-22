package Vista;

import Modelo.Paciente;
import Persistencia.Conexion;
import Persistencia.PacienteData;
import java.sql.Connection;


public class Main {

 
    public static void main(String[] args) {
           Conexion conexion = new Conexion();
        
       
        Connection con = conexion.getConexion();
        
        
            if (con != null) {
            System.out.println("¡Conexión exitosa a la base de datos!");

    }
    
            PacienteData pacienteData = new PacienteData();
            
            Paciente paciente = new Paciente("Compañero", 11, 180, 88, 80);
            
            pacienteData.agregarPaciente(paciente);
            
            pacienteData.buscarPaciente(5);
            
}
}
