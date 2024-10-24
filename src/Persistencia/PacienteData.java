package Persistencia;
import Modelo.Dieta;
import Modelo.Paciente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class PacienteData {

    private Connection con = null;

    public PacienteData() {
        con = Conexion.getConexion();

    }

    public void agregarPaciente(Paciente paciente) {

        String sql = "INSERT INTO paciente (Nombre, Edad, Altura, pesoActual, pesoBuscado) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, paciente.getNombre());
            ps.setInt(2, paciente.getEdad());
            ps.setFloat(3, paciente.getAltura());
            ps.setFloat(4, paciente.getPesoActual());
            ps.setFloat(5, paciente.getPesoBuscado());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                paciente.setNroPaciente(rs.getInt(1));
            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al guardar el paciente: " + ex.getMessage());
        }
    }

    public List<Paciente> obtenerPacientes() {
        List<Paciente> listaPaciente = new ArrayList();
        try {
            String sql = "SELEC * FROM paciente";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Paciente paciente = new Paciente();
                paciente.setNroPaciente(rs.getInt("NroPaciente"));
                paciente.setNombre(rs.getString("Nombre"));
                paciente.setEdad(rs.getInt("Edad"));
                paciente.setPesoActual(rs.getFloat("PesoActual"));
                paciente.setPesoBuscado(rs.getFloat("PesoBuscado"));
                listaPaciente.add(paciente);
            }
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener paciente: " + e.getMessage());
        }
        return listaPaciente;
    }

    public Paciente buscarPaciente(int nroPaciente) {
        Paciente p = null;
        String sql = "SELECT Nombre,Edad,Altura,pesoActual,pesoBuscado FROM paciente WHERE nroPaciente = ?";
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, nroPaciente);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                p = new Paciente();
                p.setNroPaciente(nroPaciente);
                p.setNombre(rs.getString("Nombre"));
                p.setEdad(rs.getInt("Edad"));
                p.setPesoActual(rs.getFloat("pesoActual"));
                p.setPesoBuscado(rs.getFloat("pesoBuscado"));
                System.out.println(p);

            } else {
                System.out.println("El paciente buscado no existe");
                ps.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrió un problema al intentar acceder a la tabla paciente " + ex.getMessage());

        }
        return p;
    }

    public void modificarPaciente(Paciente paciente) {
        String sql = "UPDATE paciente SET Nombre=?, Edad=?,Altura=?,pesoActual=?,pesoBuscado=? WHERE nroPaciente=?";
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, paciente.getNombre());
            ps.setInt(2, paciente.getEdad());
            ps.setFloat(3, paciente.getAltura());
            ps.setFloat(4, paciente.getPesoActual());
            ps.setFloat(5, paciente.getPesoBuscado());

            int result = ps.executeUpdate();

            if (result == 1) {
                JOptionPane.showMessageDialog(null, "Se ha modificado el paciente");
            } else {
                JOptionPane.showMessageDialog(null, "El paciente no existe");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al intentar acceder a la tabla paciente " + ex.getMessage());

        }
    }

    public void cambiarPesoDeseado(float nuevoPeso, Paciente paciente) {
        String sql = "UPDATE paciente SET pesoBuscado=? WHERE nroPaciente=?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);

            ps.setFloat(1, nuevoPeso);
            ps.setInt(2, paciente.getNroPaciente());

            int result = ps.executeUpdate();

            if (result == 1) {
                JOptionPane.showMessageDialog(null, "Se ha actualizado el peso deseado.");
                paciente.setPesoBuscado(nuevoPeso);
            } else {
                JOptionPane.showMessageDialog(null, "El paciente no existe.");
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al intentar acceder a la tabla paciente " + ex.getMessage());

        }
    }

    public void actualizarPesoAct(float nuevoPesoActual, Paciente paciente) {
                String sql = "UPDATE paciente SET pesoActual=? WHERE nroPaciente=?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);

            ps.setFloat(1, nuevoPesoActual);
            ps.setInt(2, paciente.getNroPaciente());

            int result = ps.executeUpdate();

            if (result == 1) {
                JOptionPane.showMessageDialog(null, "Se ha actualizado el peso actual.");
                paciente.setPesoActual(nuevoPesoActual);
            } else {
                JOptionPane.showMessageDialog(null, "El paciente no existe.");
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al intentar acceder a la tabla paciente " + ex.getMessage());

        }

    }

 
    public List<Paciente> listarLosQueLlegaron(Dieta dieta) {
        List<Paciente> pacientePeso = new ArrayList();
        List<Paciente> listaPaciente = obtenerPacientes();
        
        for (Paciente paci : listaPaciente) {
            if (paci.seAcercaAlPeso(dieta)) {
                pacientePeso.add(paci);
            }
        }
        return pacientePeso;
    }
}
