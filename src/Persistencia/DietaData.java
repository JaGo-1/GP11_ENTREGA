
package Persistencia;

import Modelo.Dieta;
import Modelo.Paciente;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

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
    
     /*
     * Este metodo recibe por parametro un dato entero llamado id, la cual se
     * encarga de buscar la dieta y retornarlo.
     */
    public Dieta buscarDietaPorId(int id) {
        Dieta dieta = null;
        String sql = "SELECT * FROM dieta WHERE idDieta = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                dieta = construirDieta(rs);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al buscar la dieta en la base de datos: " + e.getMessage());
        }
        return dieta;
    } 
    
/*
     * Los proximos dos metodos se encargan de listar todos los pacientes cuya dieta
     * esté terminada o vigente, y cuando es la fecha de culminación.
     */
    public List<Dieta> pacientesDietaVigente(LocalDate fecha) {
        List<Dieta> listaDieta = new ArrayList<>();
        String sql = "SELECT * FROM dieta WHERE fechaFinal > ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setDate(1, Date.valueOf(fecha));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listaDieta.add(construirDieta(rs));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al buscar dietas vigentes en la base de datos: " + e.getMessage());
        }
        return listaDieta;
    }
    
//Para dietas terminadas
    public List<Dieta> pacientesDietaTerminada(LocalDate fecha) {
        List<Dieta> listaDieta = new ArrayList<>();
        String sql = "SELECT * FROM dieta WHERE fechaFinal <= ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setDate(1, Date.valueOf(fecha));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listaDieta.add(construirDieta(rs));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al buscar dietas terminadas en la base de datos: " + e.getMessage());
        }
        return listaDieta;
    }

    //SQL POR DEFINIR
    public List<Dieta> listaPacientePesoNoLlegado() {
        List<Dieta> listaDieta = new ArrayList<>();
        String sql = "POR DEFINIR";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listaDieta.add(construirDieta(rs));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al listar pacientes que no alcanzaron su peso objetivo: " + e.getMessage());
        }
        return listaDieta;
    }

    public void eliminarDieta(int id) {
        String sql = "DELETE FROM dieta WHERE idDieta = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar la dieta: " + e.getMessage());
        }
    }

    public Dieta dietaPorPaciente(int idPaciente) {
        Dieta dieta = null;
        String sql = "SELECT * FROM dieta WHERE idPaciente = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, idPaciente);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                dieta = construirDieta(rs);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al buscar la dieta por paciente: " + e.getMessage());
        }
        return dieta;
    }
    
    private Dieta construirDieta(ResultSet rs) throws SQLException {
        int idDieta = rs.getInt("idDieta");
        String nombre = rs.getString("nombre");
        int idPaciente = rs.getInt("idPaciente");
        LocalDate fechaInicial = rs.getDate("fechaInicial").toLocalDate();
        double pesoInicial = rs.getDouble("pesoInicial");
        float pesoFinal = rs.getFloat("pesoFinal");
        LocalDate fechaFinal = rs.getDate("fechaFinal").toLocalDate();
        int altura = rs.getInt("altura");

        PacienteData pacienteData = new PacienteData();
        Paciente paciente = pacienteData.buscarPaciente(idPaciente);

        return new Dieta(idDieta, nombre, paciente, fechaInicial, pesoInicial, pesoFinal, fechaFinal, altura);
    }

}