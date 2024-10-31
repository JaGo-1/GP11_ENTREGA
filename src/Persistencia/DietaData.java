
package Persistencia;

import Modelo.Dieta;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DietaData {
    private final Connection connection;

    public DietaData() {
        this.connection = Conexion.getConexion();
    }

    public void guardarDieta(Dieta dieta) {
        String sql = "INSERT INTO dieta (nombreD, fechaIni, fechaFin, pesoFinal, estado, TotalCalorias, paciente_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, dieta.getNombreD());
            ps.setDate(2, Date.valueOf(dieta.getFechaIni()));
            ps.setDate(3, Date.valueOf(dieta.getFechaFin()));
            ps.setFloat(4, dieta.getPesoFinal());
            ps.setBoolean(5, dieta.isEstado());
            ps.setInt(6, dieta.getTotalCalorias());
            ps.setInt(7, dieta.getPaciente().getNroPaciente());  
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al guardar dieta: " + e.getMessage());
        }
    }

    public void actualizarDieta(Dieta dieta) {
        String sql = "UPDATE dieta SET nombreD = ?, fechaIni = ?, fechaFin = ?, pesoFinal = ?, estado = ?, TotalCalorias = ?, paciente_id = ? WHERE codDieta = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, dieta.getNombreD());
            ps.setDate(2, Date.valueOf(dieta.getFechaIni()));
            ps.setDate(3, Date.valueOf(dieta.getFechaFin()));
            ps.setFloat(4, dieta.getPesoFinal());
            ps.setBoolean(5, dieta.isEstado());
            ps.setInt(6, dieta.getTotalCalorias());
            ps.setInt(7, dieta.getPaciente().getNroPaciente());
            ps.setInt(8, dieta.getCodDieta());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al actualizar dieta: " + e.getMessage());
        }
    }

    public Dieta buscarDieta(int codDieta) {
        Dieta dieta = null;
        String sql = "SELECT * FROM dieta WHERE codDieta = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, codDieta);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                dieta = new Dieta();
                dieta.setCodDieta(rs.getInt("codDieta"));
                dieta.setNombreD(rs.getString("nombreD"));
                dieta.setFechaIni(rs.getDate("fechaIni").toLocalDate());
                dieta.setFechaFin(rs.getDate("fechaFin").toLocalDate());
                dieta.setPesoFinal(rs.getFloat("pesoFinal"));
                dieta.setEstado(rs.getBoolean("estado"));
                dieta.setTotalCalorias(rs.getInt("TotalCalorias"));
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar dieta: " + e.getMessage());
        }
        return dieta;
    }

    public void borrarDieta(int codDieta) {
        String sql = "DELETE FROM dieta WHERE codDieta = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, codDieta);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al borrar dieta: " + e.getMessage());
        }
    }

    public List<Dieta> listarDietas() {
        List<Dieta> dietas = new ArrayList<>();
        String sql = "SELECT * FROM dieta";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Dieta dieta = new Dieta();
                dieta.setCodDieta(rs.getInt("codDieta"));
                dieta.setNombreD(rs.getString("nombreD"));
                dieta.setFechaIni(rs.getDate("fechaIni").toLocalDate());
                dieta.setFechaFin(rs.getDate("fechaFin").toLocalDate());
                dieta.setPesoFinal(rs.getFloat("pesoFinal"));
                dieta.setEstado(rs.getBoolean("estado"));
                dieta.setTotalCalorias(rs.getInt("TotalCalorias"));
                dietas.add(dieta);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar dietas: " + e.getMessage());
        }
        return dietas;
    }
}