

package Persistencia;

import Modelo.Comida;
import Modelo.TipoComida;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;

public class ComidaData {
    private final Connection connection;

    public ComidaData() {
        this.connection = Conexion.getConexion();
    }

    
    
    public void guardarComida(Comida comida) {
        String sql = "INSERT INTO comida (nombre, tipoDeComida, detalle, caloriasPor100grms, baja) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, comida.getNombre());
           
            ps.setString(2, comida.getTipoComida().name());  
            ps.setString(3, comida.getDetalle());
            ps.setInt(4, comida.getCaloriasPor100g());
            ps.setBoolean(5, comida.isBaja());
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                comida.setCodComida(rs.getInt(1));
            }
            ps.close();
            
        } catch (SQLException e) {
            System.out.println("Error al guardar comida: " + e.getMessage());
        }
        System.out.println("Comida guardada");
    }

    
    
    
    public void actualizarComida(Comida comida) {
        String sql = "UPDATE comida SET nombre = ?, tipoDeComida = ?, caloriasPor100grms = ?, detalle = ?, baja = ? WHERE codComida = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, comida.getNombre());
            
            ps.setString(2, comida.getTipoComida().name()); 
            ps.setInt(3, comida.getCaloriasPor100g());
            ps.setString(4, comida.getDetalle());
            ps.setBoolean(5, comida.isBaja());
            ps.setInt(6, comida.getCodComida());
            int result = ps.executeUpdate();
            
            if (result == 1) {
                JOptionPane.showMessageDialog(null, "Se ha modificado la comida");
            } else {
                System.out.println("Ocurrió un error modificando la comida");
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar comida: " + e.getMessage());
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
                
                comida.setTipoComida(TipoComida.valueOf(rs.getString("tipoDeComida").toUpperCase()));  // Asegúrate de que el nombre en la base de datos esté en mayúsculas
                comida.setCaloriasPor100g(rs.getInt("caloriasPor100grms"));
                comida.setDetalle(rs.getString("detalle"));
                comida.setBaja(rs.getBoolean("baja"));
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar comida: " + e.getMessage());
        }
        return comida;
    }

    
    
    
    
    public void borrarComida(int codComida) {
        String sql = "DELETE FROM comida WHERE codComida = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, codComida);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al borrar comida: " + e.getMessage());
        }
    }

    
    
    
    public List<Comida> listarComidas() {
        List<Comida> comidas = new ArrayList<>();
        String sql = "SELECT * FROM comida";  
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Comida comida = new Comida();
                comida.setCodComida(rs.getInt("codComida"));
                comida.setNombre(rs.getString("nombre"));
                
                comida.setTipoComida(TipoComida.valueOf(rs.getString("tipoDeComida").toUpperCase()));  // Convertir el String a Enum
                comida.setDetalle(rs.getString("detalle"));
                comida.setCaloriasPor100g(rs.getInt("caloriasPor100grms"));
                comida.setBaja(rs.getBoolean("baja"));
                comidas.add(comida);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar comidas: " + e.getMessage());
        }
        
        return comidas;
    }

   public List<Comida> filtrarPorIngredientes(List<String> ingredientes) {
    List<Comida> comidas = new ArrayList<>();

   
    if (ingredientes == null || ingredientes.isEmpty()) {
        return comidas;  
    }

    
    StringBuilder sql = new StringBuilder("SELECT * FROM comida WHERE ");

    
    List<String> ingredientesFiltrados = ingredientes.stream()
            .filter(ingrediente -> ingrediente != null && !ingrediente.trim().isEmpty())
            .collect(Collectors.toList());

    
    String whereClause = ingredientesFiltrados.stream()
            .map(ingrediente -> "detalle LIKE ?")
            .collect(Collectors.joining(" OR "));
    
    sql.append(whereClause);

    try (PreparedStatement ps = connection.prepareStatement(sql.toString())) {
        
        for (int i = 0; i < ingredientesFiltrados.size(); i++) {
            ps.setString(i + 1, "%" + ingredientesFiltrados.get(i) + "%");  
        }

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Comida comida = new Comida();  

            
            comida.setCodComida(rs.getInt("codComida"));
            comida.setNombre(rs.getString("nombre"));
            comida.setTipoComida(TipoComida.valueOf(rs.getString("tipoDeComida").toUpperCase()));  
            comida.setDetalle(rs.getString("detalle"));
            comida.setCaloriasPor100g(rs.getInt("caloriaspor100grms"));
            comida.setBaja(rs.getBoolean("baja"));

            comidas.add(comida);
        }
    } catch (SQLException e) {
        System.out.println("Error al filtrar por ingredientes: " + e.getMessage());
    }

    return comidas;
}
 
    
 
 
    public List<Comida> filtrarPorCalorias(int maxCalorias) {
        List<Comida> comidas = new ArrayList<>();
        String sql = "SELECT * FROM comida WHERE caloriaspor100grms <= ?";  

    try (PreparedStatement ps = connection.prepareStatement(sql)) {
        ps.setInt(1, maxCalorias);  

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            
            Comida comida = new Comida();

            
            comida.setCodComida(rs.getInt("codComida"));
            comida.setNombre(rs.getString("nombre"));
            comida.setTipoComida(TipoComida.valueOf(rs.getString("tipoDeComida").toUpperCase()));  
            comida.setDetalle(rs.getString("detalle"));
            comida.setCaloriasPor100g(rs.getInt("caloriaspor100grms"));  
            comida.setBaja(rs.getBoolean("baja"));

            
            comidas.add(comida);
        }
    } catch (SQLException e) {
        System.out.println("Error al filtrar por calorías: " + e.getMessage());
    }

    return comidas;
    }


    
    public List<Comida> obtenerTodasLasComidas() {
        List<Comida> comidas = new ArrayList<>();
        
        
        comidas.add(new Comida("Arroz con pollo", TipoComida.ALMUERZO, "Arroz, Pollo, Aceite", 250, true));
        comidas.add(new Comida("Ensalada de tomate", TipoComida.ALMUERZO, "Tomate, Aceite, Sal", 50, true));
        
        
        return comidas;
    }
}


























    /*
    public List<Comida> filtrarPorIngrediente(String ingrediente) {
    List<Comida> comidas = new ArrayList<>();
    String sql = "SELECT * FROM comida WHERE detalle LIKE ?";
    
    try (PreparedStatement ps = connection.prepareStatement(sql)) {
        ps.setString(1, "%" + ingrediente + "%"); 
        
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            Comida comida = new Comida();
//            rs.getInt("codComida"), // Ajusta los nombres y tipos según tu tabla
//                rs.getString("nombre"),
//                rs.getString("tipoDeComida"),
//                rs.getString("detalle"),
//                rs.getInt("caloriaspor100grms"),
//                rs.getBoolean("baja")
                comida.setCodComida(rs.getInt("codComida"));
                comida.setNombre(rs.getString("nombre"));
                comida.setTipoComida(rs.getString("tipoDeComida"));
                comida.setDetalle(rs.getString("detalle"));
                comida.setCaloriasPor100g(rs.getInt("caloriaspor100grms"));
                comida.setBaja(rs.getBoolean("baja"));
                comidas.add(comida);
//            comidas.add(comida); // Agrega el objeto a la lista
        }
    } catch (SQLException e) {
           System.out.println("Error al listar comidas: " + e.getMessage());
    }
    
    return comidas; // Devuelve la lista de comidas filtrada
}
    
    //    public boolean existeComida(String nombre, String tipoDeComida, String detalle, int calorias, boolean baja) {
//        String sql = "SELECT * FROM comida WHERE nombre = ? AND tipoDeComida = ? AND detalle = ? AND caloriaspor100grms = ? AND baja = ?";
//        try (PreparedStatement ps = connection.prepareStatement(sql)) {
//            ps.setString(1, nombre);
//            ps.setString(2, tipoDeComida);
//            ps.setString(3, detalle);
//            ps.setInt(4, calorias);
//            ps.setBoolean(5, baja);
//            ResultSet rs = ps.executeQuery();
//            
//            return rs.next();
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//        return false;
//    }
}
*/