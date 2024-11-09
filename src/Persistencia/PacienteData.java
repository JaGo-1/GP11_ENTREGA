package Persistencia;

import Modelo.Dieta;
import Modelo.Paciente;
import Persistencia.Conexion;
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

    public List<Paciente> listarPacientesAltas() {
        List<Paciente> pacientes = new ArrayList<>();
        String sql = "SELECT * FROM paciente WHERE estado = '1'";
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
            System.out.println("Error al listar pacientes dados de alta: " + e.getMessage());
        }
        return pacientes;
    }

    public List<Paciente> listarPacientesBajas() {
        List<Paciente> pacientes = new ArrayList<>();
        String sql = "SELECT * FROM paciente WHERE estado = '0'";
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
            System.out.println("Error al listar pacientes dados de baja: " + e.getMessage());
        }
        return pacientes;
    }

    public void actualizarPesoActual(int codigoPaciente, float nuevoPesoActual) {
        String sql = "UPDATE paciente SET pesoActual = ? WHERE nroPaciente = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setFloat(1, nuevoPesoActual);  // Establecemos el nuevo peso
            ps.setInt(2, codigoPaciente);  // Establecemos el código del paciente
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al actualizar el peso actual del paciente: " + e.getMessage());
        }
    }

    public void actualizarEstadoPaciente(int codigoPaciente, int estado) {
        String sql = "UPDATE paciente SET estado = ? WHERE nroPaciente = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, estado);  // Establecemos el nuevo estado (true = Alta, false = Activo)
            ps.setInt(2, codigoPaciente); 
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al actualizar el estado del paciente: " + e.getMessage());
        }
    }

public List<Object[]> obtenerPacientesYDietas() {
    List<Object[]> pacientesYDietas = new ArrayList<>();
    
    String sql = "SELECT p.nombre, p.pesoActual, p.pesoBuscado, p.estado AS estadoPaciente, "
            + "d.nombreD AS nombreDieta, d.pesoFinal "
            + "FROM paciente p "
            + "JOIN dieta d ON p.nroPaciente = d.nroPaciente";

    try (PreparedStatement ps = connection.prepareStatement(sql)) {
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            // Crear un arreglo para cada paciente y dieta con los campos seleccionados
            Object[] pacienteYDieta = new Object[6];  // 6 columnas

            // Añadimos los datos del paciente
            pacienteYDieta[0] = rs.getString("nombre");  // Nombre del paciente
            pacienteYDieta[1] = rs.getFloat("pesoActual");  // Peso actual del paciente
            pacienteYDieta[2] = rs.getFloat("pesoBuscado");  // Peso buscado del paciente
            pacienteYDieta[3] = rs.getBoolean("estadoPaciente") ? "Activo" : "Alta";  // Estado del paciente

            // Añadimos los datos de la dieta
            pacienteYDieta[4] = rs.getString("nombreDieta");  // Nombre de la dieta
            pacienteYDieta[5] = rs.getFloat("pesoFinal");  // Peso final alcanzado en la dieta

            pacientesYDietas.add(pacienteYDieta);
        }
    } catch (SQLException e) {
        System.out.println("Error al obtener pacientes y dietas: " + e.getMessage());
    }

    return pacientesYDietas;
}


}
