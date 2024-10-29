package Persistencia;

import Modelo.Comida;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ComidaData {
    private final Connection connection;

    public ComidaData() {
        this.connection = Conexion.getConexion();
    }

    public void guardarComida(Comida comida) {
        String sql = "INSERT INTO comida (nombre, tipoComida, caloriasPor100g, detalle, baja) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, comida.getNombre());
            ps.setString(2, comida.getTipoComida());
            ps.setInt(3, comida.getCaloriasPor100g());
            ps.setString(4, comida.getDetalle());
            ps.setBoolean(5, comida.isBaja());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al guardar comida: " + e.getMessage());
        }
    }

    public void actualizarComida(Comida comida) {
        String sql = "UPDATE comida SET nombre = ?, tipoComida = ?, caloriasPor100g = ?, detalle = ?, baja = ? WHERE conComida = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, comida.getNombre());
            ps.setString(2, comida.getTipoComida());
            ps.setInt(3, comida.getCaloriasPor100g());
            ps.setString(4, comida.getDetalle());
            ps.setBoolean(5, comida.isBaja());
            ps.setInt(6, comida.getConComida());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al actualizar comida: " + e.getMessage());
        }
    }

    public Comida buscarComida(int conComida) {
        Comida comida = null;
        String sql = "SELECT * FROM comida WHERE conComida = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, conComida);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                comida = new Comida();
                comida.setConComida(rs.getInt("conComida"));
                comida.setNombre(rs.getString("nombre"));
                comida.setTipoComida(rs.getString("tipoComida"));
                comida.setCaloriasPor100g(rs.getInt("caloriasPor100g"));
                comida.setDetalle(rs.getString("detalle"));
                comida.setBaja(rs.getBoolean("baja"));
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar comida: " + e.getMessage());
        }
        return comida;
    }

    public void borrarComida(int conComida) {
        String sql = "DELETE FROM comida WHERE conComida = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, conComida);
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
                comida.setConComida(rs.getInt("conComida"));
                comida.setNombre(rs.getString("nombre"));
                comida.setTipoComida(rs.getString("tipoComida"));
                comida.setCaloriasPor100g(rs.getInt("caloriasPor100g"));
                comida.setDetalle(rs.getString("detalle"));
                comida.setBaja(rs.getBoolean("baja"));
                comidas.add(comida);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar comidas: " + e.getMessage());
        }
        return comidas;
    }
}
