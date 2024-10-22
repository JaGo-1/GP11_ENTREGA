package Modelo;

public enum Alimento {
  MILANESA("Milanesa"),
    PAPA("Papa"),
    BROCOLI("Brocoli"),
    ACEITUNA("Aceituna");

    private final String estado;

    private Alimento(String estado) {
        this.estado = estado;
    }


    // Método para obtener el valor String
    public String getEstado() {
        return estado;
    }
}  

