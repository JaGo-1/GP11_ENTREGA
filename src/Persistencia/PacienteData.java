package Persistencia;

import Modelo.Paciente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PacienteData {
    private final Connection connection;

    public PacienteData() {
        this.connection = Conexion.getConexion();
    }

    public void guardarPaciente(Paciente paciente) {
        String sql = "INSERT INTO paciente (nombre, edad, altura, pesoActual, pesoBuscado) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, paciente.getNombre());
            ps.setInt(2, paciente.getEdad());
            ps.setFloat(3, paciente.getAltura());
            ps.setFloat(4, paciente.getPesoActual());
            ps.setFloat(5, paciente.getPesoBuscado());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al guardar paciente: " + e.getMessage());
        }
    }

    public void actualizarPaciente(Paciente paciente) {
        String sql = "UPDATE paciente SET nombre = ?, edad = ?, altura = ?, pesoActual = ?, pesoBuscado = ? WHERE nroPaciente = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, paciente.getNombre());
            ps.setInt(2, paciente.getEdad());
            ps.setFloat(3, paciente.getAltura());
            ps.setFloat(4, paciente.getPesoActual());
            ps.setFloat(5, paciente.getPesoBuscado());
            ps.setInt(6, paciente.getNroPaciente());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al actualizar paciente: " + e.getMessage());
        }
    }

    public Paciente buscarPaciente(int nroPaciente) {
        Paciente paciente = null;
        String sql = "SELECT * FROM paciente WHERE nroPaciente = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, nroPaciente);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                paciente = new Paciente();
                paciente.setNroPaciente(rs.getInt("nroPaciente"));
                paciente.setNombre(rs.getString("nombre"));
                paciente.setEdad(rs.getInt("edad"));
                paciente.setAltura(rs.getFloat("altura"));
                paciente.setPesoActual(rs.getFloat("pesoActual"));
                paciente.setPesoBuscado(rs.getFloat("pesoBuscado"));
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar paciente: " + e.getMessage());
        }
        return paciente;
    }

    public void borrarPaciente(int nroPaciente) {
        String sql = "DELETE FROM paciente WHERE nroPaciente = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, nroPaciente);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al borrar paciente: " + e.getMessage());
        }
    }

    public List<Paciente> listarPacientes() {
        List<Paciente> pacientes = new ArrayList<>();
        String sql = "SELECT * FROM paciente";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Paciente paciente = new Paciente();
                paciente.setNroPaciente(rs.getInt("nroPaciente"));
                paciente.setNombre(rs.getString("nombre"));
                paciente.setEdad(rs.getInt("edad"));
                paciente.setAltura(rs.getFloat("altura"));
                paciente.setPesoActual(rs.getFloat("pesoActual"));
                paciente.setPesoBuscado(rs.getFloat("pesoBuscado"));
                pacientes.add(paciente);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar pacientes: " + e.getMessage());
        }
        return pacientes;
    }
}
