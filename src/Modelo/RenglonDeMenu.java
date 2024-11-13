
package Modelo;


public class RenglonDeMenu {
  

    private int nroRenglon;  
    private int codMenu;     
    private double cantidadGrms;  
    private int subTotalCalorias;  
    private Comida comida;  

    public RenglonDeMenu() {
    }
    
    public RenglonDeMenu(int nroRenglon, int codMenu, Comida comida, double cantidadGrms) {
        this.nroRenglon = nroRenglon;
        this.codMenu = codMenu;
        this.cantidadGrms = cantidadGrms;
        this.comida = comida;
        
        this.subTotalCalorias = (int) (comida.getCaloriasPor100g() * cantidadGrms / 100);  // Calorías por 100 gramos
    }

    
    public int getNroRenglon() {
        return nroRenglon;
    }

    public void setNroRenglon(int nroRenglon) {
        this.nroRenglon = nroRenglon;
    }

    public int getCodMenu() {
        return codMenu;
    }

    public void setCodMenu(int codMenu) {
        this.codMenu = codMenu;
    }

    public double getCantidadGrms() {
        return cantidadGrms;
    }

    public void setCantidadGrms(double cantidadGrms) {
        this.cantidadGrms = cantidadGrms;
    }

    public int getSubTotalCalorias() {
        return subTotalCalorias;
    }

    public void setSubTotalCalorias(int subTotalCalorias) {
        this.subTotalCalorias = subTotalCalorias;
    }

    public Comida getComida() {
        return comida;
    }

    public void setComida(Comida comida) {
        this.comida = comida;
    }
}
