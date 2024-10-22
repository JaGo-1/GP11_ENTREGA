package Modelo;

import java.util.List;


public class MenuDiario {
int codMenu;
int diaNro;
List <RenglonDeMenu> comidas;
boolean estado;
Dieta dieta;

    public MenuDiario(int codMenu, int diaNro, List<RenglonDeMenu> comidas, boolean estado, Dieta dieta) {
        this.codMenu = codMenu;
        this.diaNro = diaNro;
        this.comidas = comidas;
        this.estado = estado;
        this.dieta = dieta;
    }

    public MenuDiario() {
    }

    public int getCodMenu() {
        return codMenu;
    }

    public void setCodMenu(int codMenu) {
        this.codMenu = codMenu;
    }

    public int getDiaNro() {
        return diaNro;
    }

    public void setDiaNro(int diaNro) {
        this.diaNro = diaNro;
    }

    public List<RenglonDeMenu> getComidas() {
        return comidas;
    }

    public void setComidas(List<RenglonDeMenu> comidas) {
        this.comidas = comidas;
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

// métodos
    
    public void alterarDietadiaria(){
        
    }
    
    public MenuDiario generarDietaDiaria(){
        
        return null;
    }
    
    public MenuDiario armarDietaDiaria(){
        
        return null;
    }
    
    public void addRenglon (RenglonDeMenu renglon){
        
    }
    
    public int calcularCaloriasDelDia(){
        
        return 1;
    }
    
    public void imprimirMenuDiario(){
        
    }
}
