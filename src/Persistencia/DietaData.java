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
import org.mariadb.jdbc.Statement;

public class DietaData {

    private final Connection connection;

    public DietaData() {
        this.connection = Conexion.getConexion();
    }

    public void guardarDieta(Dieta dieta) {
        String sql = "INSERT INTO dieta (nombreD, estado, totalCalorias) VALUES (?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, dieta.getNombreD());
            ps.setBoolean(2, dieta.isEstado());
            ps.setInt(3, dieta.getTotalCalorias());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                dieta.setCodDieta(rs.getInt(1));
            }
            ps.close();

        } catch (SQLException e) {
            System.out.println("Error al guardar la dieta: " + e.getMessage());
        }
        System.out.println("Dieta guardada");
    }

    public void actualizarDieta(Dieta dieta) {
        String sql = "UPDATE dieta SET nombreD = ?,estado = ?, TotalCalorias = ? WHERE codDieta = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, dieta.getNombreD());
            ps.setBoolean(2, dieta.isEstado());
            ps.setInt(3, dieta.getTotalCalorias());
            ps.setInt(4, dieta.getCodDieta());
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
                dieta.setTotalCalorias(rs.getInt("TotalCalorias"));
                dietas.add(dieta);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar dietas: " + e.getMessage());
        }
        return dietas;
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

    public void asignarDietaAPaciente(int codigoDieta, String nombreDieta, LocalDate fechaInicio, LocalDate fechaFin, int codigoPaciente, float pesoInicial, float pesoFinal) {
        String sql = "UPDATE Dieta SET fechaInicial = ?, fechaFin = ?, nroPaciente = ?, pesoInicial = ?, pesoFinal = ? WHERE codDieta = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setDate(1, java.sql.Date.valueOf(fechaInicio)); 
            ps.setDate(2, java.sql.Date.valueOf(fechaFin));
            ps.setInt(3, codigoPaciente);
            ps.setFloat(4, pesoInicial);
            ps.setFloat(5, pesoFinal); 
            ps.setInt(6, codigoDieta); 

            int filasActualizadas = ps.executeUpdate();
            if (filasActualizadas > 0) {
                JOptionPane.showMessageDialog(null, "Dieta asignada con éxito al paciente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró la dieta con el código especificado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al asignar dieta: " + e.getMessage());
        }
    }

    public boolean pacienteTieneDieta(int codigoPaciente) {
 
        String sql = "SELECT COUNT(*) FROM Dieta WHERE nroPaciente = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, codigoPaciente);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0; 
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    
    public void eliminarDietaAnterior(int codigoPaciente) {
    String sql = "UPDATE Dieta SET nroPaciente = NULL WHERE nroPaciente = ?";

    try (PreparedStatement ps = connection.prepareStatement(sql)) {
        ps.setInt(1, codigoPaciente);

        int filasActualizadas = ps.executeUpdate();
        if (filasActualizadas > 0) {
            JOptionPane.showMessageDialog(null, "La dieta anterior ha sido eliminada.");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró una dieta asignada para este paciente.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error al eliminar la dieta anterior: " + e.getMessage());
    }
}
public float obtenerPesoInicialDePaciente(int codigoPaciente) {
    float pesoInicial = 0.0f;
    String sql = "SELECT pesoActual FROM Paciente WHERE nroPaciente = ?";

    try (PreparedStatement ps = connection.prepareStatement(sql)) {
        
        ps.setInt(1, codigoPaciente);

        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                pesoInicial = rs.getFloat("pesoActual");
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error al obtener el peso inicial: " + e.getMessage());
    }

    return pesoInicial;
}

    public List<Dieta> obtenerDietasPorPaciente(int nroPaciente) {
        List<Dieta> dietas = new ArrayList<>();
        String sql = "SELECT * FROM dieta WHERE nroPaciente = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, nroPaciente);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Dieta dieta = new Dieta();
                dieta.setCodDieta(rs.getInt("codDieta"));
                dieta.setNombreD(rs.getString("nombreD"));
                dieta.setTotalCalorias(rs.getInt("TotalCalorias"));
                dietas.add(dieta);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener dietas por paciente: " + e.getMessage());
        }
        return dietas;
    }
    public void actualizarPesoYEstadoEnBaseDeDatos(Paciente paciente, Dieta dieta) {
    String sqlActualizarPeso = "UPDATE paciente SET pesoActual = ? WHERE nroPaciente = ?";
    String sqlActualizarEstadoDieta = "UPDATE dieta SET estado = ? WHERE codDieta = ?";

    try (PreparedStatement psPeso = connection.prepareStatement(sqlActualizarPeso);
         PreparedStatement psEstadoDieta = connection.prepareStatement(sqlActualizarEstadoDieta)) {

        // Actualizar el peso actual del paciente
        psPeso.setFloat(1, paciente.getPesoActual());
        psPeso.setInt(2, paciente.getNroPaciente());
        psPeso.executeUpdate();

        // Actualizar el estado de la dieta en función del nuevo peso
        psEstadoDieta.setBoolean(1, dieta.isEstado());
        psEstadoDieta.setInt(2, dieta.getCodDieta());
        psEstadoDieta.executeUpdate();

        System.out.println("Peso y estado de la dieta actualizados en la base de datos.");
    } catch (SQLException e) {
        System.out.println("Error al actualizar el peso o el estado de la dieta en la base de datos: " + e.getMessage());
    }
}
    public Float obtenerPesoFinalDeDietaPorPaciente(int nroPaciente) {
    String sql = "SELECT pesoFinal FROM dieta WHERE nroPaciente = ?";
    try (PreparedStatement ps = connection.prepareStatement(sql)) {
        ps.setInt(1, nroPaciente);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getFloat("pesoFinal");  // Retorna el peso final de la dieta
        }
    } catch (SQLException e) {
        System.out.println("Error al obtener el peso final de la dieta: " + e.getMessage());
    }
    return null;  // En caso de que no se encuentre una dieta para ese paciente
}

    
    public List<Dieta> obtenerDietasConPacientes() {
    List<Dieta> dietas = new ArrayList<>();

    String sql = "SELECT d.*, p.nroPaciente, p.nombre, p.edad, p.altura, p.pesoActual, p.pesoBuscado, p.estado AS estadoPaciente "
               + "FROM dieta d "
               + "LEFT JOIN paciente p ON d.codDieta = p.nroPaciente";

    try (PreparedStatement ps = connection.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        Dieta dietaActual = null;

        while (rs.next()) {
            int codDieta = rs.getInt("codDieta");

            // Si cambiamos de dieta, añadimos la dieta anterior a la lista
            if (dietaActual == null || dietaActual.getCodDieta() != codDieta) {
                dietaActual = new Dieta();
                dietaActual.setCodDieta(codDieta);
                dietaActual.setNombreD(rs.getString("nombreD"));
                dietaActual.setFechaIni(rs.getDate("fechainicial") != null ? rs.getDate("fechainicial").toLocalDate() : null);
                dietaActual.setFechaFin(rs.getDate("fechafin") != null ? rs.getDate("fechafin").toLocalDate() : null);
                dietaActual.setPesoFinal(rs.getFloat("pesoFinal"));
                dietaActual.setEstado(rs.getBoolean("estado"));
                dietaActual.setTotalCalorias(rs.getInt("totalCalorias"));
                dietaActual.setPacientes(new ArrayList<>()); 
                dietas.add(dietaActual);
            }

            // Crear el paciente y agregarlo a la dieta actual si existe
            if (rs.getInt("nroPaciente") != 0) { 
                Paciente paciente = new Paciente();
                paciente.setNroPaciente(rs.getInt("nroPaciente"));
                paciente.setNombre(rs.getString("nombre"));
                paciente.setEdad(rs.getInt("edad"));
                paciente.setAltura(rs.getFloat("altura"));
                paciente.setPesoActual(rs.getFloat("pesoActual"));
                paciente.setPesoBuscado(rs.getFloat("pesoBuscado"));
                paciente.setEstado(rs.getBoolean("estadoPaciente"));
                dietaActual.getPacientes().add(paciente);  // Añadir el paciente a la dieta actual
            }
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return dietas;
}

}
