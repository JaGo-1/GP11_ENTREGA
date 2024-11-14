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
import javax.swing.JOptionPane;

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
       // String sql = "DELETE FROM paciente WHERE nroPaciente = ?";
       boolean estado = false;
       String sql = "UPDATE paciente SET estado = ? WHERE nroPaciente = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(2, nroPaciente);
            ps.setBoolean(1, estado);
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
            ps.setInt(1, estado);
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
                Object[] pacienteYDieta = new Object[6];

                pacienteYDieta[0] = rs.getString("nombre");
                pacienteYDieta[1] = rs.getFloat("pesoActual"); 
                pacienteYDieta[2] = rs.getFloat("pesoBuscado"); 
                pacienteYDieta[3] = rs.getBoolean("estadoPaciente") ? "Activo" : "Alta";

                pacienteYDieta[4] = rs.getString("nombreDieta");
                pacienteYDieta[5] = rs.getFloat("pesoFinal");

                pacientesYDietas.add(pacienteYDieta);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener pacientes y dietas: " + e.getMessage());
        }

        return pacientesYDietas;
    }

    public float obtenerPesoBuscadoDePaciente(int codigoPaciente) {
        float pesoBuscado = 0.0f;
        String sql = "SELECT pesoBuscado FROM Paciente WHERE nroPaciente = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, codigoPaciente);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    pesoBuscado = rs.getFloat("pesoBuscado");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al obtener el peso buscado: " + e.getMessage());
        }

        return pesoBuscado;
    }

    public List<Object[]> listarPacientesNoAlcanzaronPeso() {
        List<Object[]> pacientes = new ArrayList<>();
        String sql = "SELECT p.nroPaciente, p.nombre, p.edad, p.altura, p.pesoActual, p.pesoBuscado, d.fechaFin "
                + "FROM paciente p "
                + "JOIN dieta d ON p.nroPaciente = d.nroPaciente "
                + "WHERE p.pesoActual > p.pesoBuscado AND d.fechaFin <= CURRENT_DATE AND d.estado = true";

        try (PreparedStatement ps = connection.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Object[] paciente = new Object[6];
                paciente[0] = rs.getString("nombre");
                paciente[1] = rs.getInt("edad");
                paciente[2] = rs.getFloat("altura");
                paciente[3] = rs.getFloat("pesoActual");
                paciente[4] = rs.getFloat("pesoBuscado");
                paciente[5] = rs.getDate("fechaFin");
                pacientes.add(paciente);
            }

        } catch (SQLException e) {
            System.out.println("Error al listar pacientes que no alcanzaron su peso objetivo: " + e.getMessage());
        }
        return pacientes;
    }
}
