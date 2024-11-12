package Modelo;

import java.util.ArrayList;
import java.util.List;

public class MenuDiario {
private int codMenu;  
    private List<RenglonDeMenu> renglones;  
    private int caloriasDelMenu;  

    
    public MenuDiario(int codMenu, List<RenglonDeMenu> renglones) {
        this.codMenu = codMenu;
        this.renglones = renglones;
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

    
    public int getCaloriasDelMenu() {
        return caloriasDelMenu;
    }

    public void setCaloriasDelMenu(int caloriasDelMenu) {
        this.caloriasDelMenu = caloriasDelMenu;
    }
}