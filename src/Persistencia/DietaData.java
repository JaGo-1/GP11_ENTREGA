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

//    public void guardarDieta(Dieta dieta) {
//        String sql = "INSERT INTO dieta (nombreD, fechaIni, fechafin, pesoInicial, pesoFinal, estado, totalCalorias, nroPaciente) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
//        try (PreparedStatement ps = connection.prepareStatement(sql)) {
//            ps.setString(1, dieta.getNombreD());
//            ps.setDate(2, Date.valueOf(dieta.getFechaIni()));
//            ps.setDate(3, Date.valueOf(dieta.getFechaFin()));
//            ps.setFloat(4, dieta.getPaciente().getPesoActual());
//            ps.setFloat(5, dieta.getPesoFinal());
//            ps.setBoolean(6, dieta.isEstado());
//            ps.setInt(7, dieta.getTotalCalorias());
//            ps.setInt(8, dieta.getPaciente().getNroPaciente());
//            ps.executeUpdate();
//
//            ResultSet rs = ps.getGeneratedKeys();
//            if (rs.next()) {
//                dieta.setCodDieta(rs.getInt(1));
//            }
//            ps.close();
//
//        } catch (SQLException e) {
//            System.out.println("Error al guardar la dieta: " + e.getMessage());
//        }
//        System.out.println("Dieta guardada");
//    }
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

//    public void actualizarDieta(Dieta dieta) {
//        String sql = "UPDATE dieta SET nombreD = ?, fechaIni = ?, fechaFin = ?, pesoFinal = ?, estado = ?, TotalCalorias = ?, paciente_id = ? WHERE codDieta = ?";
//        try (PreparedStatement ps = connection.prepareStatement(sql)) {
//            ps.setString(1, dieta.getNombreD());
//            ps.setDate(2, Date.valueOf(dieta.getFechaIni()));
//            ps.setDate(3, Date.valueOf(dieta.getFechaFin()));
//            ps.setFloat(4, dieta.getPesoFinal());
//            ps.setBoolean(5, dieta.isEstado());
//            ps.setInt(6, dieta.getTotalCalorias());
//            ps.setInt(7, dieta.getPaciente().getNroPaciente());
//            ps.setInt(8, dieta.getCodDieta());
//            ps.executeUpdate();
//        } catch (SQLException e) {
//            System.out.println("Error al actualizar dieta: " + e.getMessage());
//        }
//    }
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

    /*
     * Este metodo recibe por parametro un dato entero llamado id, la cual se
     * encarga de buscar la dieta y retornarlo.
     */
//    public Dieta buscarDietaPorId(int id) {
//        Dieta dieta = null;
//        String sql = "SELECT * FROM dieta WHERE idDieta = ?";
//        try (PreparedStatement ps = connection.prepareStatement(sql)) {
//            ps.setInt(1, id);
//            ResultSet rs = ps.executeQuery();
//            if (rs.next()) {
//                dieta = construirDieta(rs);
//            }
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, "Error al buscar la dieta en la base de datos: " + e.getMessage());
//        }
//        return dieta;
//    } 
    /*
     * Los proximos dos metodos se encargan de listar todos los pacientes cuya dieta
     * esté terminada o vigente, y cuando es la fecha de culminación.
     */
//    public List<Dieta> pacientesDietaVigente(LocalDate fecha) {
//        List<Dieta> listaDieta = new ArrayList<>();
//        String sql = "SELECT * FROM dieta WHERE fechaFinal > ?";
//        try (PreparedStatement ps = connection.prepareStatement(sql)) {
//            ps.setDate(1, Date.valueOf(fecha));
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                listaDieta.add(construirDieta(rs));
//            }
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, "Error al buscar dietas vigentes en la base de datos: " + e.getMessage());
//        }
//        return listaDieta;
//    }
//    
//Para dietas terminadas
//    public List<Dieta> pacientesDietaTerminada(LocalDate fecha) {
//        List<Dieta> listaDieta = new ArrayList<>();
//        String sql = "SELECT * FROM dieta WHERE fechaFinal <= ?";
//        try (PreparedStatement ps = connection.prepareStatement(sql)) {
//            ps.setDate(1, Date.valueOf(fecha));
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                listaDieta.add(construirDieta(rs));
//            }
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, "Error al buscar dietas terminadas en la base de datos: " + e.getMessage());
//        }
//        return listaDieta;
//    }
//    //SQL POR DEFINIR
//    public List<Dieta> listaPacientePesoNoLlegado() {
//        List<Dieta> listaDieta = new ArrayList<>();
//        String sql = "POR DEFINIR";
//
//        try (PreparedStatement ps = connection.prepareStatement(sql)) {
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                listaDieta.add(construirDieta(rs));
//            }
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, "Error al listar pacientes que no alcanzaron su peso objetivo: " + e.getMessage());
//        }
//        return listaDieta;
//    }
    public void eliminarDieta(int id) {
        String sql = "DELETE FROM dieta WHERE idDieta = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar la dieta: " + e.getMessage());
        }
    }

//    public Dieta dietaPorPaciente(int idPaciente) {
//        Dieta dieta = null;
//        String sql = "SELECT * FROM dieta WHERE idPaciente = ?";
//        try (PreparedStatement ps = connection.prepareStatement(sql)) {
//            ps.setInt(1, idPaciente);
//            ResultSet rs = ps.executeQuery();
//            if (rs.next()) {
//                dieta = construirDieta(rs);
//            }
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, "Error al buscar la dieta por paciente: " + e.getMessage());
//        }
//        return dieta;
//    }
//    private Dieta construirDieta(ResultSet rs) throws SQLException {
//        int idDieta = rs.getInt("idDieta");
//        String nombre = rs.getString("nombre");
//        int idPaciente = rs.getInt("idPaciente");
//        LocalDate fechaInicial = rs.getDate("fechaInicial").toLocalDate();
//        double pesoInicial = rs.getDouble("pesoInicial");
//        float pesoFinal = rs.getFloat("pesoFinal");
//        LocalDate fechaFinal = rs.getDate("fechaFinal").toLocalDate();
//        int altura = rs.getInt("altura");
//
//        PacienteData pacienteData = new PacienteData();
//        Paciente paciente = pacienteData.buscarPaciente(idPaciente);
//
//        return new Dieta(idDieta, nombre, paciente, fechaInicial, pesoInicial, pesoFinal, fechaFinal, altura);
//    }
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

}
