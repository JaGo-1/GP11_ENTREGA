
package Vista;

import Modelo.Comida;
import Modelo.Dieta;
import Modelo.MenuDiario;
import Modelo.RenglonDeMenu;
import Persistencia.DietaData;
import Persistencia.MenuDiarioData;
import java.beans.PropertyVetoException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.SpinnerNumberModel;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;


public class VistaVerMenusDiarios extends javax.swing.JInternalFrame {
    
    private List<MenuDiario> menuDiarios;
    private MenuDiarioData md = new MenuDiarioData();
    private DietaData dd = new DietaData();
    
    private DefaultTableModel tableModel;
    
    
    public VistaVerMenusDiarios() {
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
                new String[] { "Renglón", "Comida", "Calorías", "Detalle"}
        );
    
        jTablelistarMenusDiarios.setModel(tableModel);
        cargarDatosEnComboBoxes();
        spinnerConfig();
    
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        title_label = new javax.swing.JLabel();
        panel1 = new Vista.componentes.Panel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablelistarMenusDiarios = new javax.swing.JTable();
        panel2 = new Vista.componentes.Panel();
        jLabel1 = new javax.swing.JLabel();
        dieta_comboBox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        dias_jSpinner = new javax.swing.JSpinner();
        buscar_btn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        total_calorias = new javax.swing.JLabel();

        setBorder(null);

        title_label.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        title_label.setText("Ver Menús Diarios");

        panel1.setBackground(new java.awt.Color(255, 255, 255));

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

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 730, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        panel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(51, 51, 51));
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Seleccionar dieta");

        jLabel2.setText("Día");

        buscar_btn.setText("Buscar");
        buscar_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscar_btnActionPerformed(evt);
            }
        });

        jLabel3.setText("Total calorias:");

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(dieta_comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(dias_jSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(buscar_btn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(total_calorias)
                .addGap(31, 31, 31))
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(dieta_comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(dias_jSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscar_btn)
                    .addComponent(jLabel3)
                    .addComponent(total_calorias))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(title_label))
                    .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(panel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title_label)
                .addGap(18, 18, 18)
                .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscar_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscar_btnActionPerformed
         try {
            
            Dieta dieta = (Dieta)dieta_comboBox.getSelectedItem();
            int dias = (int)dias_jSpinner.getValue();
            menuDiarios = md.obtenerMenuDiariosPorDieta(dieta.getCodDieta(), dias);
            llenarTablaConMenus(menuDiarios);
            
            
            total_calorias.setText(sumarCalorias(menuDiarios)+"");
            
      
        } catch (Exception e) {
            System.out.println("Error al generar los menús: " + e.getMessage());
        }
    }//GEN-LAST:event_buscar_btnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JButton buscar_btn;
    private javax.swing.JSpinner dias_jSpinner;
    private javax.swing.JComboBox<Dieta> dieta_comboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablelistarMenusDiarios;
    private Vista.componentes.Panel panel1;
    private Vista.componentes.Panel panel2;
    private javax.swing.JLabel title_label;
    private javax.swing.JLabel total_calorias;
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

   
    private void llenarTablaConMenus(List<MenuDiario> menusGenerados) {
        tableModel.setRowCount(0);
        for (MenuDiario menuDiario : menuDiarios) {
            int contador = 1;
             
            for (RenglonDeMenu renglon : menuDiario.getRenglones()) {
                String comida = renglon.getComida().getNombre();
                String detalle = renglon.getComida().getDetalle();
                int calorias = renglon.getSubTotalCalorias();

                Object[] fila = {contador, comida, calorias, detalle};
                tableModel.addRow(fila);
                contador++;
            }
        }
    
    }
    
    
    private void cargarDatosEnComboBoxes() {

        dieta_comboBox.removeAllItems();
        List<Dieta> dietas = dd.listarDietas();
        for (Dieta dieta : dietas) {
            dieta_comboBox.addItem(dieta);
        }
    }
    
    private void spinnerConfig(){
        int min = 1;
        int max = 7;
        int initialValue = 1;
        int stepSize = 1;

        SpinnerNumberModel modelo = new SpinnerNumberModel(initialValue, min, max, stepSize);
        dias_jSpinner.setModel(modelo);
    }

    
    public int sumarCalorias(MenuDiario menu) {
        int contador = 0;
        for (RenglonDeMenu renglon : menu.getRenglones()) {
            contador += renglon.getSubTotalCalorias();
        }
        return contador;
    }
    
}

