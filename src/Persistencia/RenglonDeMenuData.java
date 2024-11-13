

package Persistencia;

import Modelo.RenglonDeMenu;
import Modelo.Comida;
import Persistencia.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RenglonDeMenuData {
    private final Connection connection;

    public RenglonDeMenuData() {
        this.connection = Conexion.getConexion();
    }

public void guardarRenglonDeMenu(RenglonDeMenu renglon) {
    String sql = "INSERT INTO renglonDeMenu (codComida, cantidadGrs, subtotalCalorias, codMenu) VALUES (?, ?, ?, ?)";
    try (PreparedStatement ps = connection.prepareStatement(sql)) {
        
        ps.setInt(1, renglon.getComida().getCodComida());  
        ps.setDouble(2, renglon.getCantidadGrms()); 
        ps.setInt(3, renglon.getSubTotalCalorias());
        ps.setInt(4, renglon.getCodMenu());  
        ps.executeUpdate();
    } catch (SQLException e) {
        System.out.println("Error al guardar renglón de menú: " + e.getMessage());
    }

}


public void actualizarRenglonDeMenu(RenglonDeMenu renglon) {
    String sql = "UPDATE renglonDeMenu SET codComida = ?, cantidadGrs = ?, subtotalCalorias = ?, codMenu = ? WHERE nroRenglon = ?";
    try (PreparedStatement ps = connection.prepareStatement(sql)) {
        ps.setInt(1, renglon.getComida().getCodComida());
        ps.setDouble(2, renglon.getCantidadGrms());  
        ps.setInt(3, renglon.getSubTotalCalorias());
        ps.setInt(4, renglon.getCodMenu());  
        ps.setInt(5, renglon.getNroRenglon());
        ps.executeUpdate();
    } catch (SQLException e) {
        System.out.println("Error al actualizar renglón de menú: " + e.getMessage());
    }
}


  public RenglonDeMenu buscarRenglonDeMenu(int nroRenglon) {
    RenglonDeMenu renglon = null;
    String sql = "SELECT * FROM renglonDeMenu WHERE nroRenglon = ?";
    try (PreparedStatement ps = connection.prepareStatement(sql)) {
        ps.setInt(1, nroRenglon);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            
            int nroRenglonDb = rs.getInt("nroRenglon");
            int codMenuDb = rs.getInt("codMenu");  
            Comida comida = buscarComida(rs.getInt("codComida"));  
            double cantidadGrmsDb = rs.getDouble("cantidadGrms");

            
            renglon = new RenglonDeMenu(nroRenglonDb, codMenuDb, comida, cantidadGrmsDb);
            renglon.setSubTotalCalorias(rs.getInt("subTotalCalorias"));  
        }
    } catch (SQLException e) {
        System.out.println("Error al buscar renglón de menú: " + e.getMessage());
    }
    return renglon;
}



 public void borrarRenglonDeMenu(int nroRenglon) {
    String sql = "DELETE FROM renglonDeMenu WHERE nroRenglon = ?";
    try (PreparedStatement ps = connection.prepareStatement(sql)) {
        ps.setInt(1, nroRenglon);
        ps.executeUpdate();
    } catch (SQLException e) {
        System.out.println("Error al borrar renglón de menú: " + e.getMessage());
    }
}

 
 
 public Comida buscarComida(int codComida) {
    Comida comida = null;
    String sql = "SELECT * FROM comida WHERE codComida = ?";
    try (PreparedStatement ps = connection.prepareStatement(sql)) {
        ps.setInt(1, codComida);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            
            comida = new Comida();
            comida.setCodComida(rs.getInt("codComida"));
            comida.setNombre(rs.getString("nombre"));
            comida.setCaloriasPor100g(rs.getInt("caloriasPor100grms"));
            
        }
        rs.close();
    } catch (SQLException e) {
        System.out.println("Error al buscar comida: " + e.getMessage());
    }
    return comida;
}
 
 
 

public List<RenglonDeMenu> listarRenglonesDeMenu() {
    List<RenglonDeMenu> renglones = new ArrayList<>();
    String sql = "SELECT * FROM renglonDeMenu";
    try (PreparedStatement ps = connection.prepareStatement(sql)) {
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int nroRenglonDb = rs.getInt("nroRenglon");
            int codMenuDb = rs.getInt("codMenu");  // Recuperamos el código del menú
            Comida comida = buscarComida(rs.getInt("codComida"));  // Recuperamos la comida
            double cantidadGrmsDb = rs.getDouble("cantidadGrms");

            // Usamos el constructor con los parámetros correctos
            RenglonDeMenu renglon = new RenglonDeMenu(nroRenglonDb, codMenuDb, comida, cantidadGrmsDb);
            renglon.setSubTotalCalorias(rs.getInt("subTotalCalorias"));  // Establecemos el subtotal de calorías

            // Agregar el renglón a la lista
            renglones.add(renglon);
        }
    } catch (SQLException e) {
        System.out.println("Error al listar renglones de menú: " + e.getMessage());
    }
    return renglones;
}

    public List<RenglonDeMenu> obtenerRenglonesDeMenu(int codMenu) {
        List<RenglonDeMenu> renglones = new ArrayList<>();
        
        String sql = "SELECT * FROM renglondemenu WHERE codMenu = ? LIMIT 5";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
             
            stmt.setInt(1, codMenu);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                RenglonDeMenu renglon = new RenglonDeMenu();
                renglon.setNroRenglon(rs.getInt("nroRenglon"));
                renglon.setCantidadGrms(rs.getDouble("cantidadGrms"));
                renglon.setSubTotalCalorias(rs.getInt("subTotalCalorias"));
                
                ComidaData cd = new ComidaData();
                Comida comida = cd.buscarComida(rs.getInt("codComida"));
                renglon.setComida(comida);
                
                renglones.add(renglon);
            }
        }catch (SQLException e) {
            System.out.println("Error al listar renglones de menu: " + e.getMessage());
        }
        return renglones;
    }


}
