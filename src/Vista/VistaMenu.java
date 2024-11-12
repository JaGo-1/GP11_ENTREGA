package Vista;


import Modelo.Comida;
import Modelo.Dieta;
import Modelo.MenuDiario;
import Modelo.RenglonDeMenu;
import Modelo.TipoComida;
import Persistencia.ComidaData;
import Persistencia.DietaData;
import Persistencia.MenuDiarioData;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.ImageIcon;
import javax.swing.SpinnerNumberModel;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;


public class VistaMenu extends javax.swing.JInternalFrame {
    private List<MenuDiario> menuDiarios;
    private MenuDiarioData md = new MenuDiarioData();
    private DietaData dd = new DietaData();
   
    private DefaultTableModel tableModel;
    
    public VistaMenu() {
        initComponents();
        this.setResizable(false);
        this.setMaximizable(false);
               setSize(763, 501);

        // Ocultar la barra de título
        BasicInternalFrameUI ui = (BasicInternalFrameUI) getUI();
        ui.setNorthPane(null);

        //internalFrame siempre maximizado
        try {
            this.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setFrameIcon(new ImageIcon());
        
        tableModel = new DefaultTableModel(new Object[][] {},
//        new String[] {
//            "Día", "Calorías Totales", "Desayuno", "Almuerzo", "Snack", "Merienda", "Cena"
//        }
                new String[] { "Día", "Comida", "Calorías", "Detalle"}
        );
    
        jTablelistarMenusDiarios.setModel(tableModel);
        cargarDatosEnComboBoxes();
        spinnerConfig();
    
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
        dieta_comboBox = new javax.swing.JComboBox<>();
        dias_jSpinner = new javax.swing.JSpinner();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        totalCalorias_label = new javax.swing.JLabel();

        setBorder(null);

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

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Generar Menus");

        jLabel2.setText("Seleccionar dieta");

        dieta_comboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dieta_comboBoxActionPerformed(evt);
            }
        });

        jButton1.setText("Nuevo");

        jButton2.setText("Borrar");

        jButton3.setText("Editar");

        jLabel3.setText("Total calorias: ");

        totalCalorias_label.setText("{}");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(17, 17, 17))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(dieta_comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(dias_jSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jButtonBuscaringredientes)
                .addGap(131, 131, 131)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(totalCalorias_label)
                .addContainerGap(100, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(dieta_comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dias_jSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonBuscaringredientes)
                    .addComponent(jLabel3)
                    .addComponent(totalCalorias_label))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3)
                    .addComponent(jButton2))
                .addContainerGap(102, Short.MAX_VALUE))
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
            
            Dieta dieta = (Dieta)dieta_comboBox.getSelectedItem();
            int dias = (int)dias_jSpinner.getValue();
            menuDiarios = md.obtenerMenuDiariosPorDieta(dieta.getCodDieta(), dias);
            llenarTablaConMenus(menuDiarios);
            
            
            totalCalorias_label.setText(sumarCalorias(menuDiarios)+"");
            
      
        } catch (Exception e) {
            System.out.println("Error al generar los menús: " + e.getMessage());
    }
        
    }//GEN-LAST:event_jButtonBuscaringredientesActionPerformed

    private void dieta_comboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dieta_comboBoxActionPerformed
//         Dieta dieta = (Dieta)dieta_comboBox.getSelectedItem();
//         menuDiarios = md.obtenerMenuDiariosPorDieta(dieta.getCodDieta(), 3);
//         llenarTablaConMenus(menuDiarios);
    }//GEN-LAST:event_dieta_comboBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner dias_jSpinner;
    private javax.swing.JComboBox<Dieta> dieta_comboBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtonBuscaringredientes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablelistarMenusDiarios;
    private javax.swing.JLabel totalCalorias_label;
    // End of variables declaration//GEN-END:variables

  
    
   private int sumarCalorias (List<MenuDiario> m){
        int contador = 0;
        for (MenuDiario menu : m){
            for (RenglonDeMenu renglon : menu.getRenglones()){
                contador = contador + renglon.getSubTotalCalorias();
            }
        }
        return contador;
    }
    
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
    //    menu.setCaloriasDelMenu(caloriasMenu);  
        
        menus.add(menu);  
    }
    
    return menus;
}



private void llenarTablaConMenus(List<MenuDiario> menusGenerados) {


    tableModel.setRowCount(0);

for (MenuDiario menuDiario : menuDiarios) {
            int codMenu = menuDiario.getCodMenu();
            int diaNro = menuDiario.getDiaNro();
            
            
            for (RenglonDeMenu renglon : menuDiario.getRenglones()) {
                String comida = renglon.getComida().getNombre();
                String detalle = renglon.getComida().getDetalle();
                int calorias = renglon.getSubTotalCalorias();

                Object[] fila = {diaNro, comida, calorias, detalle};
                tableModel.addRow(fila);
            }
        }
    
}


public int sumarCalorias(MenuDiario menu) {
    int contador = 0;
    for (RenglonDeMenu renglon : menu.getRenglones()) {
        contador += renglon.getSubTotalCalorias();
    }
    return contador;
}

private void cargarDatosEnComboBoxes() {

        dieta_comboBox.removeAllItems();
        List<Dieta> dietas = dd.listarDietas();
        for (Dieta dieta : dietas) {
            dieta_comboBox.addItem(dieta);
        }
        }

private void spinnerConfig(){
    int min = 3;
        int max = 7;
        int initialValue = 5;
        int stepSize = 1;

        SpinnerNumberModel modelo = new SpinnerNumberModel(initialValue, min, max, stepSize);
        dias_jSpinner.setModel(modelo);
}
}