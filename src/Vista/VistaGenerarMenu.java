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
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;


public class VistaGenerarMenu extends javax.swing.JInternalFrame {

   private DietaData dd = new DietaData();
   private MenuDiarioData menuDiarioData = new MenuDiarioData();
   private DefaultTableModel tableModel;
   private List<MenuDiario>menusGenerados;
    
   
   public VistaGenerarMenu() {
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
        new String[] {
            "Día", "Calorías Totales", "Desayuno", "Almuerzo", "Snack", "Merienda", "Cena"
        });
    
    jTablelistarMenusDiarios.setModel(tableModel);
     cargarDatosEnComboBoxes();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panel1 = new Vista.componentes.Panel();
        jButtonBuscaringredientes = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        dieta_comboBox = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        title_label = new javax.swing.JLabel();
        panel2 = new Vista.componentes.Panel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablelistarMenusDiarios = new javax.swing.JTable();
        borrar_btn = new javax.swing.JButton();
        modificar_btn = new javax.swing.JButton();
        nuevo_btn = new javax.swing.JButton();

        setBorder(null);

        panel1.setBackground(new java.awt.Color(255, 255, 255));

        jButtonBuscaringredientes.setText("Buscar");
        jButtonBuscaringredientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscaringredientesActionPerformed(evt);
            }
        });

        jLabel2.setText("Seleccionar ingredientes");

        jLabel1.setText("Asignar menu a una Dieta");

        jButton1.setText("Asignar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dieta_comboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE))
                .addGap(37, 37, 37)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jButtonBuscaringredientes))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonBuscaringredientes)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(dieta_comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        title_label.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        title_label.setText("Generar Menú");

        panel2.setBackground(new java.awt.Color(255, 255, 255));

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

        borrar_btn.setText("Borrar");

        modificar_btn.setText("Modificar");

        nuevo_btn.setText("Nuevo");

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGap(632, 632, 632)
                        .addComponent(nuevo_btn)
                        .addGap(18, 18, 18)
                        .addComponent(modificar_btn)
                        .addGap(18, 18, 18)
                        .addComponent(borrar_btn))
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 840, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(borrar_btn)
                    .addComponent(modificar_btn)
                    .addComponent(nuevo_btn))
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(panel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(title_label)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(title_label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        String ingredientesTexto = jTextField1.getText().trim();
        
        if (ingredientesTexto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese algunos ingredientes.");
            return;
        }

        List<String> ingredientes = Arrays.asList(ingredientesTexto.split(","));
        
        if (ingredientes.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe haber al menos un ingrediente.");
            return;
        }

        // Filtrar comidas por ingredientes
        ComidaData comidaData = new ComidaData();
        List<Comida> comidasFiltradas = comidaData.filtrarPorIngredientes(ingredientes);

        if (comidasFiltradas.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No se encontraron comidas con esos ingredientes.");
            return;
        }

        // Generar menús con las comidas filtradas
        menusGenerados = generarMenus(comidasFiltradas);
        
        // Depuración: Verificar cuántos menús fueron generados
        System.out.println("Cantidad de menús generados: " + menusGenerados.size());

        // Llenar la tabla con los menús generados
        llenarTablaConMenus(menusGenerados);

        JOptionPane.showMessageDialog(this, "Menús generados exitosamente.");
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al generar los menús: " + e.getMessage());
    }
        
    }//GEN-LAST:event_jButtonBuscaringredientesActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
                                         
    if (menusGenerados == null || menusGenerados.isEmpty()) {
        JOptionPane.showMessageDialog(this, "No se han generado menús. Primero busque ingredientes.");
        return;
    }

    // Obtener la dieta seleccionada
    Dieta dietaSeleccionada = (Dieta) dieta_comboBox.getSelectedItem();

    if (dietaSeleccionada == null) {
        JOptionPane.showMessageDialog(this, "Por favor, seleccione una dieta.");
        return;
    }

    // Depuración: Verificar que la dieta seleccionada no sea null
    System.out.println("Dieta seleccionada: " + dietaSeleccionada.getNombreD());

    try {
        // Asignar los menús generados a la dieta seleccionada
        asignarMenusADieta(dietaSeleccionada, menusGenerados);
        JOptionPane.showMessageDialog(this, "Menús asignados a la dieta correctamente.");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al asignar los menús: " + e.getMessage());
    }









        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton borrar_btn;
    private javax.swing.JComboBox<Dieta> dieta_comboBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonBuscaringredientes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablelistarMenusDiarios;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton modificar_btn;
    private javax.swing.JButton nuevo_btn;
    private Vista.componentes.Panel panel1;
    private Vista.componentes.Panel panel2;
    private javax.swing.JLabel title_label;
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
        
        // Recorrer los renglones del menú
        for (RenglonDeMenu renglon : menu.getRenglones()) {
            int nroRenglon = renglon.getNroRenglon() - 1;  
            
            
            if (renglon.getComida() != null) {
                
                renglones[nroRenglon] = renglon.getComida().getNombre() + " (" + renglon.getCantidadGrms() + "g)";
            } else {
                
                renglones[nroRenglon] = "Comida no asignada";
            }
        }

        
        for (int i = 0; i < 5; i++) {
            row[i + 2] = renglones[i] != null ? renglones[i] : "No disponible";  // Llenar la tabla con los renglones, o "No disponible" si el renglón está vacío
        }

        // Agregar la fila a la tabla
        model.addRow(row);  
    }
}


 private void cargarDatosEnComboBoxes() {
    dieta_comboBox.removeAllItems();
    List<Dieta> dietas = dd.listarDietas();
    
    if (dietas.isEmpty()) {
        JOptionPane.showMessageDialog(this, "No se encontraron dietas disponibles.");
        return;
    }

    for (Dieta dieta : dietas) {
        dieta_comboBox.addItem(dieta);
    }
}

    
 
 private void asignarMenusADieta(Dieta dieta, List<MenuDiario> menus) throws Exception {
    if (menus == null || menus.isEmpty()) {
        throw new Exception("No hay menús para asignar.");
    }
    
    for (MenuDiario menu : menus) {
        menu.setDieta(dieta);  // Asignar la dieta a cada menú
        menuDiarioData.guardar(menu);  // Guardar el menú asignado a la dieta
        
        
    }
 }
}
