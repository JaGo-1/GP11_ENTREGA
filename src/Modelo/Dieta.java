
package Modelo;

import java.time.LocalDate;
import java.util.List;


public class Dieta {
 int codDieta;
 String nombreD;
 List <MenuDiario> Menus;
 LocalDate fechaIni;
 LocalDate fechaFin;
 float pesoFinal;
 boolean estado;
 int TotalCalorias;
 Paciente paciente; 

    public Dieta(int codDieta, String nombreD, List<MenuDiario> Menus, LocalDate fechaIni, LocalDate fechaFin, float pesoFinal, boolean estado, int TotalCalorias, Paciente paciente) {
        this.codDieta = codDieta;
        this.nombreD = nombreD;
        this.Menus = Menus;
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
        this.pesoFinal = pesoFinal;
        this.estado = estado;
        this.TotalCalorias = TotalCalorias;
        this.paciente = paciente;
    }

    public Dieta() {
    }

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
        return TotalCalorias;
    }

    public void setTotalCalorias(int TotalCalorias) {
        this.TotalCalorias = TotalCalorias;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
 
 //Aquí empiezan los métodos del ejercicio
    
    public void cargarPesoyFinalizar(float pesoFinal){
        
    }
    
    public void imprimirDietacompleta(){
        
    }
    
    public int calcularDiferDePeso(){
        
        return 1;
    }
 
}
