package Persistencia;

import Modelo.Comida;
import Modelo.MenuDiario;
import Modelo.RenglonDeMenu;
import Modelo.Dieta;
import Modelo.TipoComida;
import Persistencia.Conexion;
import Persistencia.RenglonDeMenuData;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.mariadb.jdbc.Statement;

public class MenuDiarioData {
    private final Connection connection;

    public MenuDiarioData() {
        this.connection = Conexion.getConexion();
    }

 
  
  
  
private void guardarRenglonDeMenu(RenglonDeMenu renglon, int codMenu) {
    
    String sqlRenglon = "INSERT INTO renglondemenu (codMenu, cantidadGrms, subTotalCalorias, codComida) VALUES (?, ?, ?, ?)";

    try (PreparedStatement psRenglon = connection.prepareStatement(sqlRenglon)) {
        // Setear los parámetros para la sentencia SQL
        psRenglon.setInt(1, codMenu); 
        psRenglon.setDouble(2, renglon.getCantidadGrms()); 
        psRenglon.setInt(3, renglon.getSubTotalCalorias());  
        psRenglon.setInt(4, renglon.getComida().getCodComida());  

        
        psRenglon.executeUpdate();
        
    } catch (SQLException e) {
        System.out.println("Error al guardar renglón de menú: " + e.getMessage());
    }
}






public MenuDiario buscarMenuDiario(int codMenu) {
    MenuDiario menu = null;
    String sqlMenu = "SELECT * FROM menudiario WHERE codMenu = ?";
    try {
        PreparedStatement psMenu = connection.prepareStatement(sqlMenu);
        psMenu.setInt(1, codMenu);
        ResultSet rsMenu = psMenu.executeQuery();
        if (rsMenu.next()) {
            menu = new MenuDiario(codMenu, new ArrayList<>());
            
            
            List<RenglonDeMenu> renglones = buscarRenglonesDeMenu(codMenu);
            menu.setRenglones(renglones);
        }
        rsMenu.close();
        psMenu.close();
    } catch (SQLException e) {
        System.out.println("Error al buscar menú diario: " + e.getMessage());
    }
    return menu;
}





    // Buscar los renglones de menú asociados a un menú
   private List<RenglonDeMenu> buscarRenglonesDeMenu(int codMenu) {
    List<RenglonDeMenu> renglones = new ArrayList<>();
    String sqlRenglon = "SELECT * FROM renglondemenu WHERE codMenu = ?";
    try (PreparedStatement psRenglon = connection.prepareStatement(sqlRenglon)) {
        psRenglon.setInt(1, codMenu);
        ResultSet rsRenglon = psRenglon.executeQuery();
        while (rsRenglon.next()) {
            Comida comida = buscarComida(rsRenglon.getInt("codComida"));
            RenglonDeMenu renglon = new RenglonDeMenu(
                rsRenglon.getInt("nroRenglon"),  
                codMenu,  
                comida, 
                rsRenglon.getDouble("cantidadGrms")
            );
            renglon.setSubTotalCalorias(rsRenglon.getInt("subTotalCalorias"));
            renglones.add(renglon);
        }
        rsRenglon.close();
    } catch (SQLException e) {
        System.out.println("Error al buscar renglones de menú: " + e.getMessage());
    }
    return renglones;
}




 public Comida buscarComida(int codComida) {
    Comida comida = null;
    String sqlComida = "SELECT * FROM comida WHERE codComida = ?";
    try {
        PreparedStatement psComida = connection.prepareStatement(sqlComida);
        psComida.setInt(1, codComida);
        ResultSet rsComida = psComida.executeQuery();
        
        if (rsComida.next()) {
            comida = new Comida();
            comida.setCodComida(codComida);
            comida.setNombre(rsComida.getString("nombre"));

            
            String tipoComidaStr = rsComida.getString("tipoDeComida");
            
            if (tipoComidaStr != null) {
                try {
                    comida.setTipoComida(TipoComida.valueOf(tipoComidaStr.toUpperCase()));
                } catch (IllegalArgumentException e) {
                    comida.setTipoComida(TipoComida.SNACK); 
                }
            } else {
                comida.setTipoComida(TipoComida.SNACK); 
            }

            comida.setCaloriasPor100g(rsComida.getInt("caloriaspor100grms"));
            comida.setDetalle(rsComida.getString("detalle"));
            comida.setBaja(rsComida.getBoolean("baja"));
        }
        
        rsComida.close();
        psComida.close();
    } catch (SQLException e) {
        System.out.println("Error al buscar comida: " + e.getMessage());
    }
    return comida;
}


public List<MenuDiario> listarMenusDiarios() {
    List<MenuDiario> menus = new ArrayList<>();
    String sql = "SELECT * FROM menudiario";
    try {
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            MenuDiario menu = new MenuDiario(rs.getInt("codMenu"), new ArrayList<>()); 
            
            List<RenglonDeMenu> renglones = buscarRenglonesDeMenu(menu.getCodMenu());
            menu.setRenglones(renglones);

            menus.add(menu);
        }
        rs.close();
        ps.close();
    } catch (SQLException e) {
        System.out.println("Error al listar menús diarios: " + e.getMessage());
    }
    return menus;
}


    
  
  
    
    


    public List<MenuDiario> filtrarMenusPorIngrediente(String ingrediente) {
    List<MenuDiario> menus = new ArrayList<>();
    String sql = "SELECT * FROM menudiario WHERE detalles LIKE ?";
    try {
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, "%" + ingrediente + "%");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            MenuDiario menu = new MenuDiario(rs.getInt("codMenu"), new ArrayList<>());
            
            List<RenglonDeMenu> renglones = buscarRenglonesDeMenu(menu.getCodMenu());
            menu.setRenglones(renglones);

            menus.add(menu);
        }
        rs.close();
        ps.close();
    } catch (SQLException e) {
        System.out.println("Error al filtrar menús por ingrediente: " + e.getMessage());
    }
    return menus;
}
    
    
        
    
    
    
    
    
// Guardar un nuevo MenuDiario
 public void guardar(MenuDiario menu) {
    
    String sql = "INSERT INTO menudiario (diaNro, caloriasDelMenu, estado, CodDieta) VALUES (?, ?, ?, ?)";

    try (PreparedStatement pst = connection.prepareStatement(sql)) {
        
        
        if (menu.getDieta() == null) {
            throw new Exception("La dieta no está seleccionada.");
        }

        
        pst.setInt(1, menu.getDiaNro());  
        pst.setInt(2, calcularCaloriasDelMenu(menu));  
        pst.setBoolean(3, menu.getEstado());  
        pst.setInt(4, menu.getDieta().getCodDieta());  

        // Ejecutamos la consulta
        pst.executeUpdate();
        System.out.println("Menú guardado exitosamente.");

    } catch (SQLException ex) {
        ex.printStackTrace();  
    } catch (Exception e) {
        e.printStackTrace();  
    }
}


    
    
    
    // Método para calcular las calorías totales de un menú
    private int calcularCaloriasDelMenu(MenuDiario menu) {
        int totalCalorias = 0;
        for (RenglonDeMenu renglon : menu.getRenglones()) {
            totalCalorias += renglon.getSubTotalCalorias(); // Asumiendo que el subtotal de calorías ya está calculado
        }
        return totalCalorias;
    }

  
    
    
  
    
    
    
    // Generar un menú diario
    public MenuDiario generarMenuDiario(List<Comida> ingredientesSeleccionados, int diaNro) {
    List<RenglonDeMenu> renglones = new ArrayList<>();

    
    int codMenu = 0;  

    for (int i = 0; i < 5; i++) {
        Comida comida = ingredientesSeleccionados.get(i % ingredientesSeleccionados.size());
        double cantidadGrms = 100 + (i * 50);

        RenglonDeMenu renglon = new RenglonDeMenu(i + 1, codMenu, comida, cantidadGrms);
        renglon.setSubTotalCalorias(calcularCalorias(renglon));
        renglones.add(renglon);
    }

   
    return new MenuDiario(diaNro, renglones);
}


    
    
    
    
    // Calcular las calorías de un renglón de menú
    private int calcularCalorias(RenglonDeMenu renglon) {
        return (int) (renglon.getCantidadGrms() * renglon.getComida().getCaloriasPor100g() / 100);
    }
    
        
    
    
    
    
    
      //VISTA VER MENUS DIARIOS
    
     /* public List<MenuDiario> obtenerMenuDiariosPorDieta( int n , int codDieta) {
        List<MenuDiario> menuDiarios = new ArrayList<>();
        
        String sql = "SELECT * FROM menudiario WHERE  diaNro = ?  AND CodDieta = ? ";
    
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            
          ps.setInt(2, n); 
          ps.setInt(1, codDieta);
        
            ResultSet rs = ps.executeQuery();
        
            while (rs.next()) {
                MenuDiario menuDiario = new MenuDiario();
                menuDiario.setCodMenu(rs.getInt("codMenu"));
                menuDiario.setDiaNro(rs.getInt("diaNro"));
                menuDiario.getDieta(rs.getInt("codDieta"));
            
                RenglonDeMenuData rd = new RenglonDeMenuData();
                List<RenglonDeMenu> renglones = rd.obtenerRenglonesDeMenu(menuDiario.getCodMenu());
                menuDiario.setRenglones(renglones);
            
                menuDiarios.add(menuDiario);
            }
        } catch (SQLException e) {
        System.out.println("Error al listar menús diarios: " + e.getMessage());
        }
        
        System.out.println("Cantidad de menús recuperados: " + menuDiarios.size());
        return menuDiarios;
    }
}
*/
  public List<MenuDiario> obtenerMenuDiariosPorDieta(int codDieta, int diaNro) {
    List<MenuDiario> menuDiarios = new ArrayList<>();
    System.out.println("Conectado a la base de datos, ejecutando consulta...");

    String sql = "SELECT * FROM menudiario WHERE diaNro = ? AND CodDieta = ?";
    System.out.println("Ejecutando SQL: " + sql);
    System.out.println("Parametros: diaNro=" + diaNro + ", CodDieta=" + codDieta);

    try (PreparedStatement ps = connection.prepareStatement(sql)) {
        // Cambiar el orden de los parámetros
        ps.setInt(1, diaNro);  // El primer parámetro corresponde a diaNro
        ps.setInt(2, codDieta); // El segundo parámetro corresponde a CodDieta

        ResultSet rs = ps.executeQuery();
        
        // Si no se encuentran resultados, imprímelo para depuración
        if (!rs.isBeforeFirst()) {
            System.out.println("No se encontraron menús para los parámetros dados.");
        }

        while (rs.next()) {
            MenuDiario menuDiario = new MenuDiario();
            menuDiario.setCodMenu(rs.getInt("codMenu"));
            menuDiario.setDiaNro(rs.getInt("diaNro"));

            // Recuperar el objeto Dieta asociado (asegúrate que 'setDieta' esté disponible en MenuDiario)
            Dieta dieta = new Dieta();
            dieta.setCodDieta(rs.getInt("codDieta"));
            menuDiario.setDieta(dieta); // Si tienes un setter para dieta en MenuDiario

            // Recuperar los renglones del menú utilizando el código del menú
            RenglonDeMenuData rd = new RenglonDeMenuData();
            List<RenglonDeMenu> renglones = rd.obtenerRenglonesDeMenu(menuDiario.getCodMenu());
            menuDiario.setRenglones(renglones);

            menuDiarios.add(menuDiario);
        }
    } catch (SQLException e) {
        System.out.println("Error al listar menús diarios: " + e.getMessage());
    }

    System.out.println("Cantidad de menús recuperados: " + menuDiarios.size());
    return menuDiarios;
}

}
    
    


    
    
    
    
    
   