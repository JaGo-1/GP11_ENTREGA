package Vista;
import Modelo.MenuDiario;
import Modelo.RenglonDeMenu;
import java.sql.Connection;
import javax.swing.*;
import Persistencia.Conexion;
import Persistencia.MenuDiarioData;
import com.formdev.flatlaf.FlatLightLaf;
import java.util.List;
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
            
                  MenuDiarioData md = new MenuDiarioData();
           MenuDiario menu_diario = new MenuDiario();
            
           // md.guardarMenuDiario(menu_diario);
     List<MenuDiario> menuDiarios = md.obtenerMenuDiariosPorDieta(18, 1);  // Dieta con codDieta = 1
      List<MenuDiario> menuDiarios1 = md.listarMenusDiarios();
            
                System.out.println ("todo mal hacen" );
              System.out.println (menuDiarios.size() );
             
           for (MenuDiario menuDiario : menuDiarios) {
               
                System.out.println ("entra" );
               
               
               System.out.println("Menú Diario (CodMenu: " + menuDiario.getCodMenu() + ", Día: " + menuDiario.getDiaNro() + ")");
               
               for (RenglonDeMenu renglon : menuDiario.getRenglones()) {
                  System.out.println("\tComida: " + renglon.getComida().getNombre() + ", Calorías: " + renglon.getSubTotalCalorias());
                }
               
           }
         
         
            FlatLightLaf.setup(); //LIBRERIA PARA LA GUI
            Principal frame = new Principal();
            frame.setVisible(true);
       
            
}
}