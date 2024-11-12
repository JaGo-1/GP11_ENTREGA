package Persistencia;

import Modelo.Comida;
import Modelo.MenuDiario;
import Modelo.RenglonDeMenu;
import Modelo.Dieta;
import Modelo.TipoComida;
import Persistencia.Conexion;
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

    
    
    
    
    
    
  public void guardarMenuDiario(MenuDiario menu) {
    String sqlMenu = "INSERT INTO menu_diario (codMenu) VALUES (?)";
    try {
        
        PreparedStatement psMenu = connection.prepareStatement(sqlMenu, Statement.RETURN_GENERATED_KEYS);
        psMenu.setInt(1, menu.getCodMenu());  

        psMenu.executeUpdate();

        
        ResultSet rsMenu = psMenu.getGeneratedKeys();
        if (rsMenu.next()) {
            int codMenu = rsMenu.getInt(1);
            menu.setCodMenu(codMenu);  

            
            for (RenglonDeMenu renglon : menu.getRenglones()) {
                guardarRenglonDeMenu(renglon, codMenu);  
            }
        }
        psMenu.close();

    } catch (SQLException e) {
        System.out.println("Error al guardar menú diario: " + e.getMessage());
    }
}
  
  
  
  
  
  
  
private void guardarRenglonDeMenu(RenglonDeMenu renglon, int codMenu) {
    
    String sqlRenglon = "INSERT INTO renglon_menu (codMenu, cantidadGrms, subTotalCalorias, codComida) VALUES (?, ?, ?, ?)";

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
    String sqlMenu = "SELECT * FROM menu_diario WHERE codMenu = ?";
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
    String sqlRenglon = "SELECT * FROM renglon_menu WHERE codMenu = ?";
    try (PreparedStatement psRenglon = connection.prepareStatement(sqlRenglon)) {
        psRenglon.setInt(1, codMenu);
        ResultSet rsRenglon = psRenglon.executeQuery();
        while (rsRenglon.next()) {
            // Buscar la comida asociada al renglón
            Comida comida = buscarComida(rsRenglon.getInt("codComida"));

            // Crear un nuevo RenglonDeMenu con los datos obtenidos de la base de datos
            RenglonDeMenu renglon = new RenglonDeMenu(
                rsRenglon.getInt("nroRenglon"),  // Número de renglón
                codMenu,  // Pasar el codMenu aquí
                comida, 
                rsRenglon.getDouble("cantidadGrms")  // Cantidad en gramos
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
            comida.setDetalle(rsComida.getString("detalles"));
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
    String sql = "SELECT * FROM menu_diario";
    try {
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            MenuDiario menu = new MenuDiario(rs.getInt("codMenu"), new ArrayList<>());  // Instanciamos con codMenu
            
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
    String sql = "SELECT * FROM menu_diario WHERE detalles LIKE ?";
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
    
    
    
  public MenuDiario generarMenuDiario(List<Comida> ingredientesSeleccionados) {
    List<RenglonDeMenu> renglones = new ArrayList<>();
    int diaNro = 1;  
    int codMenu = diaNro;

    for (int i = 0; i < 5; i++) {
        Comida comida = ingredientesSeleccionados.get(i % ingredientesSeleccionados.size());
        double cantidadGrms = 100 + (i * 50);
        
        RenglonDeMenu renglon = new RenglonDeMenu(i + 1, codMenu, comida, cantidadGrms);
        renglon.setSubTotalCalorias(calcularCalorias(renglon));  
        renglones.add(renglon);
    }

    return new MenuDiario(diaNro, renglones);
}

private int calcularCalorias(RenglonDeMenu renglon) {
    return (int) (renglon.getCantidadGrms() * renglon.getComida().getCaloriasPor100g() / 100);
}
}