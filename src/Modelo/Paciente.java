package Modelo;

import java.util.List;

public class Paciente {
    int nroPaciente;
    String nombre;
    int edad;
    float altura;
    float pesoActual;
    float pesoBuscado;
    boolean estado;
    Dieta dieta;

    public Paciente(int nroPaciente, String nombre, int edad, float altura, float pesoActual, float pesoBuscado, boolean estado, Dieta dieta) {
        this.nroPaciente = nroPaciente;
        this.nombre = nombre;
        this.edad = edad;
        this.altura = altura;
        this.pesoActual = pesoActual;
        this.pesoBuscado = pesoBuscado;
        this.estado = estado;
        this.dieta = dieta;
    }

    public Paciente(int nroPaciente, String nombre, int edad, float altura, float pesoActual, float pesoBuscado, boolean estado) {
        this.nroPaciente = nroPaciente;
        this.nombre = nombre;
        this.edad = edad;
        this.altura = altura;
        this.pesoActual = pesoActual;
        this.pesoBuscado = pesoBuscado;
        this.estado = estado;
    }

    public Paciente() {
    }

    // Getters y setters
    public int getNroPaciente() {
        return nroPaciente;
    }

    public void setNroPaciente(int nroPaciente) {
        this.nroPaciente = nroPaciente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getPesoActual() {
        return pesoActual;
    }

    public void setPesoActual(float pesoActual) {
        this.pesoActual = pesoActual;
    }

    public float getPesoBuscado() {
        return pesoBuscado;
    }

    public void setPesoBuscado(float pesoBuscado) {
        this.pesoBuscado = pesoBuscado;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Dieta getDieta() {
        return dieta;
    }

    public void setDieta(Dieta dieta) {
        this.dieta = dieta;
    }

    // Métodos adicionales
    public void cambiarPesoDeseado() {
        // Implementación
    }

    public void actualizarPesoAct() {
        // Implementación
    }

    public boolean seAcercaAlPeso(Dieta dieta) {
        return true;
    }

    public List<Paciente> listarLosQueLlegaron() {
        return null;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
