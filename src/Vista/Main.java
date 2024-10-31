package Vista;
import java.sql.Connection;
import javax.swing.*;
import Persistencia.Conexion;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;



public class Main {

 
    public static void main(String[] args) {
     Connection con= (Connection) Conexion.getConexion();
     if(con!=null){
     
         System.out.println("Conexion exitosa a la base de datos");
     }
   
       /*SwingUtilities.invokeLater(() -> {
           
            JFrame frame = new JFrame("Gestión de Pacientes");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);

            
            JDesktopPane desktopPane = new JDesktopPane();
            frame.add(desktopPane);

            // Crear y añadir el JInternalFrame
            GenerarPaciente generarPaciente = new GenerarPaciente();
            desktopPane.add(generarPaciente);
            generarPaciente.setVisible(true); // Hacer visible el JInternalFrame

            // Mostrar la ventana principal
            frame.setVisible(true);
        });
    }
}*/
    }}