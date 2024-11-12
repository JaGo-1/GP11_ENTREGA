package Modelo;

import java.util.ArrayList;
import java.util.List;

public class MenuDiario {
//    private int codMenu;  
//    private List<RenglonDeMenu> renglones;  
//    private int caloriasDelMenu;  
    int codMenu;
    int diaNro;
    List <RenglonDeMenu> renglones;
    boolean estado;
    Dieta dieta;


    
//    public MenuDiario(int codMenu, List<RenglonDeMenu> renglones) {
//        this.codMenu = codMenu;
//        this.renglones = renglones;
//    }

            public MenuDiario(int diaNro, List<RenglonDeMenu> comidas, boolean estado, Dieta dieta) {
        this.diaNro = diaNro;
        this.renglones = comidas;
        this.estado = estado;
        this.dieta = dieta;
    }

    
    public MenuDiario() {}

   
    public int getCodMenu() {
        return codMenu;
    }

    public void setCodMenu(int codMenu) {
        this.codMenu = codMenu;
    }

    
    public List<RenglonDeMenu> getRenglones() {
        return renglones;
    }

    public void setRenglones(List<RenglonDeMenu> renglones) {
        this.renglones = renglones;
    }

    
    
//    public int getCaloriasDelMenu() {
//        return caloriasDelMenu;
//    }
//
//    public void setCaloriasDelMenu(int caloriasDelMenu) {
//        this.caloriasDelMenu = caloriasDelMenu;
//    }

    public int getDiaNro() {
        return diaNro;
    }

    public void setDiaNro(int diaNro) {
        this.diaNro = diaNro;
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
}