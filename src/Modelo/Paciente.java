
package Modelo;

import java.util.List;

public class Paciente {
  
    int nroPaciente;
    String nombre;
    int edad;
    float altura;
    float pesoActual;
    float pesoBuscado;

    public Paciente(int nroPaciente, String nombre, int edad, float altura, float pesoActual, float pesoBuscado) {
        this.nroPaciente = nroPaciente;
        this.nombre = nombre;
        this.edad = edad;
        this.altura = altura;
        this.pesoActual = pesoActual;
        this.pesoBuscado = pesoBuscado;
    }

    public Paciente() {
    }

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
    
    //Aquí empiezan los métodos del ejercicio
    
    public void cambiarPesoDeseado(){
        
    }
    
    public void actualizarPesoAct(){
        
    }
    
    public boolean seAcercaAlPeso(Dieta dieta){
      
        return true;
    }
    
    public List <Paciente> listarLosQueLlegaron(){
       
        return null;
    }
}
