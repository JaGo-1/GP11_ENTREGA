package Persistencia;

import Modelo.RenglonDeMenu;
import Modelo.Comida;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RenglonData {
    private final Connection connection;

    public RenglonData() {
        this.connection = Conexion.getConexion();
    }

    public void guardarRenglonDeMenu(RenglonDeMenu renglon) {
        String sql = "INSERT INTO renglonDeMenu (alimento_id, cantidadGrs, subtotalCalorias) VALUES (?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, renglon.getAlimento().getConComida());  
            ps.setDouble(2, renglon.getCantidadGrs());
            ps.setInt(3, renglon.getSubtotalCalorias());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al guardar renglon de menu: " + e.getMessage());
        }
    }

    public void actualizarRenglonDeMenu(RenglonDeMenu renglon) {
        String sql = "UPDATE renglonDeMenu SET alimento_id = ?, cantidadGrs = ?, subtotalCalorias = ? WHERE nroRenglon = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, renglon.getAlimento().getConComida());
            ps.setDouble(2, renglon.getCantidadGrs());
            ps.setInt(3, renglon.getSubtotalCalorias());
            ps.setInt(4, renglon.getNroRenglon());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al actualizar renglon de menu: " + e.getMessage());
        }
    }

    public RenglonDeMenu buscarRenglonDeMenu(int nroRenglon) {
        RenglonDeMenu renglon = null;
        String sql = "SELECT * FROM renglonDeMenu WHERE nroRenglon = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, nroRenglon);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                renglon = new RenglonDeMenu();
                renglon.setNroRenglon(rs.getInt("nroRenglon"));
                Comida comida = new Comida();  
                comida.setConComida(rs.getInt("alimento_id"));
                renglon.setAlimento(comida);
                renglon.setCantidadGrs(rs.getDouble("cantidadGrs"));
                renglon.setSubtotalCalorias(rs.getInt("subtotalCalorias"));
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar renglon de menu: " + e.getMessage());
        }
        return renglon;
    }

    public void borrarRenglonDeMenu(int nroRenglon) {
        String sql = "DELETE FROM renglonDeMenu WHERE nroRenglon = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, nroRenglon);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al borrar renglon de menu: " + e.getMessage());
        }
    }

    public List<RenglonDeMenu> listarRenglonesDeMenu() {
        List<RenglonDeMenu> renglones = new ArrayList<>();
        String sql = "SELECT * FROM renglonDeMenu";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                RenglonDeMenu renglon = new RenglonDeMenu();
                renglon.setNroRenglon(rs.getInt("nroRenglon"));
                Comida comida = new Comida();  
                comida.setConComida(rs.getInt("alimento_id"));
                renglon.setAlimento(comida);
                renglon.setCantidadGrs(rs.getDouble("cantidadGrs"));
                renglon.setSubtotalCalorias(rs.getInt("subtotalCalorias"));
                renglones.add(renglon);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar renglones de menu: " + e.getMessage());
        }
        return renglones;
    }
}