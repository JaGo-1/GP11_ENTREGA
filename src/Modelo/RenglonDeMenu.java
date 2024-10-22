
package Modelo;


public class RenglonDeMenu {
    
    int nroRenglon;
    Comida alimento;
    double cantidadGrs;
    int subtotalCalorias;

    public RenglonDeMenu(int nroRenglon, Comida alimento, double cantidadGrs, int subtotalCalorias) {
        this.nroRenglon = nroRenglon;
        this.alimento = alimento;
        this.cantidadGrs = cantidadGrs;
        this.subtotalCalorias = subtotalCalorias;
    }

    public RenglonDeMenu() {
    }

    public int getNroRenglon() {
        return nroRenglon;
    }

    public void setNroRenglon(int nroRenglon) {
        this.nroRenglon = nroRenglon;
    }

    public Comida getAlimento() {
        return alimento;
    }

    public void setAlimento(Comida alimento) {
        this.alimento = alimento;
    }

    public double getCantidadGrs() {
        return cantidadGrs;
    }

    public void setCantidadGrs(double cantidadGrs) {
        this.cantidadGrs = cantidadGrs;
    }

    public int getSubtotalCalorias() {
        return subtotalCalorias;
    }

    public void setSubtotalCalorias(int subtotalCalorias) {
        this.subtotalCalorias = subtotalCalorias;
    }
    
    //métodos 
    
    public void modificarRenglon(){
        
    }
    
    public void imprimirRenglon(){
        
    }
    
    public void addAlimento(Comida comida){
        
    }
    
    public int subtotalCalorias(){
        
        return 1;
    }
}
