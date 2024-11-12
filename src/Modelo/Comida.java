
package Modelo;

import java.util.List;


public class Comida {
      private int codComida;
    private String nombre;
    private TipoComida tipoComida;  
    private int caloriasPor100g;
    private String detalle;
    private boolean baja;

    // Constructor sin parámetros (por si necesito crear un objeto vacío)
    public Comida() {}
    
    public Comida(String nombre, TipoComida tipoComida, String detalle, int caloriasPor100g, boolean baja) {
        this.nombre = nombre;
        this.tipoComida = tipoComida;
        this.caloriasPor100g = caloriasPor100g;
        this.detalle = detalle;
        this.baja = baja;
    }

    // Getters y Setters
    public int getCodComida() {
        return codComida;
    }

    public void setCodComida(int codComida) {
        this.codComida = codComida;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoComida getTipoComida() {
        return tipoComida;
    }

    public void setTipoComida(TipoComida tipoComida) {
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


    @Override
    public String toString() {
        return "Comida{" + "codComida=" + codComida + ", nombre=" + nombre + ", tipoComida=" + tipoComida + ", caloriasPor100g=" + caloriasPor100g + ", detalle=" + detalle + ", baja=" + baja + '}';
    }
}

