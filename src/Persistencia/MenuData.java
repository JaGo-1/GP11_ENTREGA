package Persistencia;

import Modelo.MenuDiario;
import Modelo.RenglonDeMenu;
import Modelo.Dieta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MenuData {
    private final Connection connection;

    public MenuData() {
        this.connection = Conexion.getConexion();
    }

    public void guardarMenuDiario(MenuDiario menu) {
        String sql = "INSERT INTO menuDiario (diaNro, estado, dieta_id) VALUES (?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, menu.getDiaNro());
            ps.setBoolean(2, menu.isEstado());
            ps.setInt(3, menu.getDieta().getCodDieta());
            ps.executeUpdate();

            if (menu.getComidas() != null) {
                for (RenglonDeMenu renglon : menu.getComidas()) {
                    RenglonData renglonData = new RenglonData();
                    renglonData.guardarRenglonDeMenu(renglon);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al guardar menu diario: " + e.getMessage());
        }
    }

    public void actualizarMenuDiario(MenuDiario menu) {
        String sql = "UPDATE menuDiario SET diaNro = ?, estado = ?, dieta_id = ? WHERE codMenu = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, menu.getDiaNro());
            ps.setBoolean(2, menu.isEstado());
            ps.setInt(3, menu.getDieta().getCodDieta());
            ps.setInt(4, menu.getCodMenu());
            ps.executeUpdate();
            
            if (menu.getComidas() != null) {
                RenglonData renglonData = new RenglonData();
                for (RenglonDeMenu renglon : menu.getComidas()) {
                    renglonData.actualizarRenglonDeMenu(renglon);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar menu diario: " + e.getMessage());
        }
    }

    public MenuDiario buscarMenuDiario(int codMenu) {
        MenuDiario menu = null;
        String sql = "SELECT * FROM menuDiario WHERE codMenu = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, codMenu);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                menu = new MenuDiario();
                menu.setCodMenu(rs.getInt("codMenu"));
                menu.setDiaNro(rs.getInt("diaNro"));
                menu.setEstado(rs.getBoolean("estado"));

                Dieta dieta = new Dieta();  
                dieta.setCodDieta(rs.getInt("dieta_id"));
                menu.setDieta(dieta);

                RenglonData renglonData = new RenglonData();
                List<RenglonDeMenu> comidas = renglonData.listarRenglonesDeMenu(); 
                menu.setComidas(comidas);
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar menu diario: " + e.getMessage());
        }
        return menu;
    }

    public void borrarMenuDiario(int codMenu) {
        String sql = "DELETE FROM menuDiario WHERE codMenu = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, codMenu);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al borrar menu diario: " + e.getMessage());
        }
    }

    public List<MenuDiario> listarMenusDiarios() {
        List<MenuDiario> menus = new ArrayList<>();
        String sql = "SELECT * FROM menuDiario";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                MenuDiario menu = new MenuDiario();
                menu.setCodMenu(rs.getInt("codMenu"));
                menu.setDiaNro(rs.getInt("diaNro"));
                menu.setEstado(rs.getBoolean("estado"));

                Dieta dieta = new Dieta();  
                dieta.setCodDieta(rs.getInt("dieta_id"));
                menu.setDieta(dieta);

                RenglonData renglonData = new RenglonData();
                List<RenglonDeMenu> comidas = renglonData.listarRenglonesDeMenu(); 
                menu.setComidas(comidas);

                menus.add(menu);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar menus diarios: " + e.getMessage());
        }
        return menus;
    }
}
