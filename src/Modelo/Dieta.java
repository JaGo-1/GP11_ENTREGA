package Modelo;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class Dieta {
    int codDieta;
    String nombreD;
    List<MenuDiario> Menus;
    LocalDate fechaIni;
    LocalDate fechaFin;
    float pesoFinal;
    boolean estado;
    int totalCalorias;
    List<Paciente> pacientes;

    public Dieta(int codDieta, String nombreD, LocalDate fechaIni, double pesoInicial, float pesoFinal, LocalDate fechaFin, int totalCalorias, List<Paciente> pacientes) {
        this.codDieta = codDieta;
        this.nombreD = nombreD;
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
        this.pesoFinal = pesoFinal;
        this.estado = estado;
        this.totalCalorias = totalCalorias;
        this.pacientes = pacientes;
    }

    public Dieta(int codDieta, String nombreD, LocalDate fechaIni, LocalDate fechaFin, float pesoFinal, boolean estado, int totalCalorias) {
        this.codDieta = codDieta;
        this.nombreD = nombreD;
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
        this.pesoFinal = pesoFinal;
        this.estado = estado;
        this.totalCalorias = totalCalorias;
    }

    public Dieta(String nombreD, boolean estado, int totalCalorias) {
        this.nombreD = nombreD;
        this.estado = estado;
        this.totalCalorias = totalCalorias;
    }

    public Dieta(String nombreD, LocalDate fechaIni, LocalDate fechaFin, boolean estado, int totalCalorias) {
        this.nombreD = nombreD;
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
        this.estado = estado;
        this.totalCalorias = totalCalorias;
    }

    public Dieta() {
    }

    // Getters y setters
    public int getCodDieta() {
        return codDieta;
    }

    public void setCodDieta(int codDieta) {
        this.codDieta = codDieta;
    }

    public String getNombreD() {
        return nombreD;
    }

    public void setNombreD(String nombreD) {
        this.nombreD = nombreD;
    }

    public List<MenuDiario> getMenus() {
        return Menus;
    }

    public void setMenus(List<MenuDiario> Menus) {
        this.Menus = Menus;
    }

    public LocalDate getFechaIni() {
        return fechaIni;
    }

    public void setFechaIni(LocalDate fechaIni) {
        this.fechaIni = fechaIni;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public float getPesoFinal() {
        return pesoFinal;
    }

    public void setPesoFinal(float pesoFinal) {
        this.pesoFinal = pesoFinal;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getTotalCalorias() {
        return totalCalorias;
    }

    public void setTotalCalorias(int totalCalorias) {
        this.totalCalorias = totalCalorias;
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    // Métodos adicionales
    public void cargarPesoyFinalizar(float pesoFinal) {
        // Implementación
    }

    public void imprimirDietacompleta() {
        // Implementación
    }

    public int calcularDiferDePeso() {
        return 1;
    }

       public long getTotalDias() {
        // Calcula los días totales entre fechaIni y fechaFin
        if (fechaIni != null && fechaFin != null) {
            return ChronoUnit.DAYS.between(fechaIni, fechaFin);
        }
        return 0;  // Devuelve 0 si alguna de las fechas es null
    }

    public long getDiasTranscurridos() {
        // Calcula los días transcurridos desde fechaIni hasta hoy
        if (fechaIni != null) {
            return ChronoUnit.DAYS.between(fechaIni, LocalDate.now());
        }
        return 0;  // Devuelve 0 si fechaIni es null
    }

    public double getPorcentajeProgreso() {
        // Calcula el porcentaje de progreso basado en los días transcurridos
        long totalDias = getTotalDias();
        long diasTranscurridos = getDiasTranscurridos();
        if (totalDias > 0) {
            return ((double) diasTranscurridos / totalDias) * 100;
        }
        return 0;  // Devuelve 0 si totalDias es 0 (sin progreso)
    }
    
    
    @Override
    public String toString() {
        return nombreD;
    }
}
