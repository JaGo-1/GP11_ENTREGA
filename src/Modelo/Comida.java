
package Modelo;

import java.util.List;


public class Comida {
    int codComida;
    String nombre;
    String tipoComida;
    int caloriasPor100g;
    String detalle;
    boolean baja;
    
    
    public Comida( String nombre, String tipoComida,  String detalle, int caloriasPor100g, boolean baja) {
        this.nombre = nombre;
        this.tipoComida = tipoComida;
        this.caloriasPor100g = caloriasPor100g;
        this.detalle = detalle;
        this.baja = baja;
    }

    public Comida() {
    }

    public int getCodComida() {
        return codComida;
    }

    public void setCodComida(int conComida) {
        this.codComida = conComida;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoComida() {
        return tipoComida;
    }

    public void setTipoComida(String tipoComida) {
        this.tipoComida = tipoComida;
    }

    public int getCaloriasPor100g() {
        return caloriasPor100g;
    }

    public void setCaloriasPor100g(int caloriasPor100g) {
        this.caloriasPor100g = caloriasPor100g;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public boolean isBaja() {
        return baja;
    }

    public void setBaja(boolean baja) {
        this.baja = baja;
    }
    
    //metodos (Añadí una clase Alimento para que coincida con el ejercicio, este es de tipo ENUM)
    
    public List<Alimento> filtrarxIngred(int conComida){
        
        return null;
    }
    
    public List<Alimento> filtrarxNombre(String nombre){
        
        return null;
    }
    
    public List<Alimento> filtrarxCalorias(int caloriasPor100gr){
        
        return null;
    }
    
    public void modificarAlimento(Comida comida){
        
    }

    @Override
    public String toString() {
        return  "codComida =" + codComida + ", nombre = " + nombre + ", tipoComida = " + tipoComida + ", caloriasPor100g = " + caloriasPor100g + ", detalle = " + detalle + ", baja = " + baja + ".\n";
    }
    
    
}
