package Vista;
import java.sql.Connection;
import javax.swing.*;
import Persistencia.Conexion;
import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;



public class Main {

    public static void main(String[] args) {
        Connection con = Conexion.getConexion();
        
        
            if (con != null) {
            System.out.println("¡Conexión exitosa a la base de datos!");

            }
            
//            ComidaData cd = new ComidaData();
//            Comida comida = new Comida("Yogur con frutos secos", "Desayuno","Yogur Griego, Almendras, Nueces, Avellanas, Pistachos", 150,  true );
//            Comida comida2 = new Comida("Yogur con frutos secos 22222", "Desayuno 2222","Yogur Griego asdasdasd, Almendras, Nueces, Avellanas, Pistachos", 150,  true );
//            
//            cd.guardarComida(comida);
//            cd.guardarComida(comida2);
         //   List<Comida> comidas = cd.listarComidas();
            
         //   System.out.println(comidas);
            
            FlatLightLaf.setup(); //LIBRERIA PARA LA GUI
            Principal frame = new Principal();
            frame.setVisible(true);
       
            
}
}