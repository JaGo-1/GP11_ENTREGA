package Vista;


import Modelo.Comida;
import Modelo.MenuDiario;
import Modelo.RenglonDeMenu;
import Modelo.TipoComida;
import Persistencia.ComidaData;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.swing.table.DefaultTableModel;


public class VistaMenu extends javax.swing.JInternalFrame {

   
   private DefaultTableModel tableModel;
public VistaMenu() {
        initComponents();
        
       tableModel = new DefaultTableModel(new Object[][] {},
        new String[] {
            "Día", "Calorías Totales", "Desayuno", "Almuerzo", "Snack", "Merienda", "Cena"
        });
    
    jTablelistarMenusDiarios.setModel(tableModel);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButtonBuscaringredientes = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablelistarMenusDiarios = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();

        jButtonBuscaringredientes.setText("Buscar");
        jButtonBuscaringredientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscaringredientesActionPerformed(evt);
            }
        });

        jTablelistarMenusDiarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTablelistarMenusDiarios);

        jLabel1.setText("Generar Menus");

        jLabel2.setText("seleccionar ingredientes");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonBuscaringredientes)
                        .addGap(56, 56, 56))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 695, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(256, 256, 256)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonBuscaringredientes)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(89, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBuscaringredientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscaringredientesActionPerformed
try {
        
        String ingredientesTexto = jTextField1.getText();
        List<String> ingredientes = Arrays.asList(ingredientesTexto.split(","));

        
        ComidaData comidaData = new ComidaData();  
        List<Comida> comidasFiltradas = comidaData.filtrarPorIngredientes(ingredientes);

        
        List<MenuDiario> menusGenerados = generarMenus(comidasFiltradas);

        
        llenarTablaConMenus(menusGenerados);
    } catch (Exception e) {
        System.out.println("Error al generar los menús: " + e.getMessage());
    }

        
        
        
        
    }//GEN-LAST:event_jButtonBuscaringredientesActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBuscaringredientes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablelistarMenusDiarios;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

  
    
 
    
private List<Comida> filtrarComidasPorIngredientes(String ingredientesTexto) {
    List<Comida> comidasFiltradas = new ArrayList<>();
    
    
    ComidaData comidaData = new ComidaData();
    
    
    List<Comida> todasLasComidas = comidaData.obtenerTodasLasComidas();  
    
    
    String[] ingredientes = ingredientesTexto.split(",");  
    
    
    List<String> ingredientesList = Arrays.stream(ingredientes)
            .map(String::trim)
            .filter(ingrediente -> !ingrediente.isEmpty())
            .collect(Collectors.toList());

    
    for (Comida comida : todasLasComidas) {
        for (String ingrediente : ingredientesList) {
            if (comida.getDetalle().toLowerCase().contains(ingrediente.toLowerCase())) {
                comidasFiltradas.add(comida);
                break;  
            }
        }
    }

    return comidasFiltradas;
}



private List<MenuDiario> generarMenus(List<Comida> comidasFiltradas) {
    List<MenuDiario> menus = new ArrayList<>();
    
    
    Map<TipoComida, List<Comida>> comidasPorTipo = new HashMap<>();
    
    
    for (Comida comida : comidasFiltradas) {
        TipoComida tipo = comida.getTipoComida();
        comidasPorTipo.putIfAbsent(tipo, new ArrayList<>());
        comidasPorTipo.get(tipo).add(comida);
    }

    
    for (int i = 0; i < 4; i++) {
        MenuDiario menu = new MenuDiario();
        menu.setCodMenu(i + 1);  
        
        
        List<RenglonDeMenu> renglones = new ArrayList<>();
        int caloriasMenu = 0;  
        
        
        TipoComida[] tiposComida = {TipoComida.DESAYUNO, TipoComida.ALMUERZO, TipoComida.SNACK, TipoComida.MERIENDA, TipoComida.CENA};

        
        for (int j = 0; j < tiposComida.length; j++) {
            TipoComida tipo = tiposComida[j];
            List<Comida> comidasDelTipo = comidasPorTipo.get(tipo);
            
            
            if (comidasDelTipo != null && !comidasDelTipo.isEmpty()) {
                Comida comida = comidasDelTipo.get((int) (Math.random() * comidasDelTipo.size()));

                
                RenglonDeMenu renglon = new RenglonDeMenu(
                    j + 1, 
                    menu.getCodMenu(), 
                    comida, 
                    100 
                );
                
                
                renglones.add(renglon);
                caloriasMenu += renglon.getSubTotalCalorias();  
            }
        }
        
        menu.setRenglones(renglones);  
        menu.setCaloriasDelMenu(caloriasMenu);  
        
        menus.add(menu);  
    }
    
    return menus;
}



private void llenarTablaConMenus(List<MenuDiario> menusGenerados) {
    DefaultTableModel model = (DefaultTableModel) jTablelistarMenusDiarios.getModel();
    model.setRowCount(0);  

    for (MenuDiario menu : menusGenerados) {
        Object[] row = new Object[7];  
        
        
        row[0] = "Día " + menu.getCodMenu();  
        row[1] = menu.getCaloriasDelMenu() + " kcal";  

        
        String[] renglones = new String[5];

        
        for (RenglonDeMenu renglon : menu.getRenglones()) {
           
            renglones[renglon.getNroRenglon() - 1] = renglon.getComida().getNombre() + " (" + renglon.getCantidadGrms() + "g)";
        }

        
        for (int i = 0; i < 5; i++) {
            row[i + 2] = renglones[i];  
        }

        
        model.addRow(row);
    }
}
}