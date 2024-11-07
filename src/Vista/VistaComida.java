package Vista;

import Modelo.Comida;
import Persistencia.ComidaData;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyVetoException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

public class VistaComida extends javax.swing.JInternalFrame {
    
    private ComidaData cd = new ComidaData();
    private Comida comidaActual = null;
    
    DefaultTableModel tabla = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int f, int c) {
            return false;
        }
    };

    public VistaComida() {
        initComponents();
        
        this.setResizable(false);
        this.setMaximizable(false);
        
        //internalFrame siempre maximizado
        try {
            this.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(VistaComida.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setFrameIcon(new ImageIcon());
        
        spinnerConfig();
        crearCabecera();
        verTodo_radio.setSelected(true);
        llenarTabla(cd.listarComidas());
        
        filtroCalorias_textField.setEnabled(false);
        filtroIngredientes_textField.setEnabled(false);
        
    }
    
    private void crearCabecera() {
        tabla.addColumn("Código");
        tabla.addColumn("Nombre");
        tabla.addColumn("Detalle");
        tabla.addColumn("Tipo de comida");
        tabla.addColumn("Calorias");
        tablaComidas.setModel(tabla);
    }

    private void llenarCombo(JComboBox combo){
    
    }
    
    private void llenarTabla(List<Comida> comidas){
        tabla.setRowCount(0);
        for (Comida c : comidas){
            tabla.addRow(new Object[]{c.getCodComida(),c.getNombre(), c.getDetalle(), c.getTipoComida(), c.getCaloriasPor100g()});
        }

    }
    
    private void spinnerConfig(){
        int min = 0;
        int paso = 1;
        int valorInicial = 0; 

        SpinnerNumberModel model = new SpinnerNumberModel(valorInicial, min, Integer.MAX_VALUE, paso);
        calorias_spinner.setModel(model);
        
        // Para permitir solo dígitos y teclas de control
        JFormattedTextField spinnerTextField = ((JSpinner.DefaultEditor) calorias_spinner.getEditor()).getTextField();
        spinnerTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_DELETE) {
                    e.consume(); 
                    return;
                }
                
                // Para sobreescribir el valor inicial
                if (spinnerTextField.getText().equals("0") && Character.isDigit(c)) {
                    spinnerTextField.setText(""); 
                }
            }
        });

    }
    
    private void resetCampos(){
        nombre_textField.setText("");
        tipoComida_textField.setText("");
        detalle_textArea.setText("");
        calorias_spinner.setValue(0);
        baja_radio.setSelected(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaComidas = new javax.swing.JTable();
        borrar_btn = new javax.swing.JButton();
        guardar_btn = new javax.swing.JButton();
        nuevo_btn = new javax.swing.JButton();
        verTodo_radio = new javax.swing.JRadioButton();
        filtrarIngredientes_radio = new javax.swing.JRadioButton();
        filtrarCalorias_radio = new javax.swing.JRadioButton();
        nombre_textField = new javax.swing.JTextField();
        baja_radio = new javax.swing.JRadioButton();
        ingresarComidas_text = new javax.swing.JLabel();
        nombre_text = new javax.swing.JLabel();
        tipoComida_text = new javax.swing.JLabel();
        detalle_text = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        detalle_textArea = new javax.swing.JTextArea();
        calorias_text = new javax.swing.JLabel();
        tipoComida_textField = new javax.swing.JTextField();
        calorias_spinner = new javax.swing.JSpinner();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        gestionComidas_text = new javax.swing.JLabel();
        filtroCalorias_textField = new javax.swing.JTextField();
        filtroIngredientes_textField = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(null);

        bg.setBackground(new java.awt.Color(255, 255, 255));

        tablaComidas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaComidas);

        borrar_btn.setText("Borrar");
        borrar_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrar_btnActionPerformed(evt);
            }
        });

        guardar_btn.setText("Guardar");
        guardar_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardar_btnActionPerformed(evt);
            }
        });

        nuevo_btn.setText("Nuevo");
        nuevo_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevo_btnActionPerformed(evt);
            }
        });

        verTodo_radio.setText("Ver todo");
        verTodo_radio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verTodo_radioActionPerformed(evt);
            }
        });

        filtrarIngredientes_radio.setText("Filtrar por ingredientes");
        filtrarIngredientes_radio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtrarIngredientes_radioActionPerformed(evt);
            }
        });

        filtrarCalorias_radio.setText("Filtrar por calorías");
        filtrarCalorias_radio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtrarCalorias_radioActionPerformed(evt);
            }
        });

        baja_radio.setText("Baja");
        baja_radio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                baja_radioActionPerformed(evt);
            }
        });

        ingresarComidas_text.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        ingresarComidas_text.setText("Ingresar Comidas");

        nombre_text.setText("Nombre");

        tipoComida_text.setText("Tipo de comida");

        detalle_text.setText("Detalle");

        detalle_textArea.setColumns(20);
        detalle_textArea.setRows(5);
        jScrollPane2.setViewportView(detalle_textArea);

        calorias_text.setText("Calorias (100gr)");

        jPanel1.setBackground(new java.awt.Color(250, 250, 250));
        jPanel1.setForeground(new java.awt.Color(204, 204, 204));

        jLabel6.setForeground(new java.awt.Color(153, 153, 153));
        jLabel6.setText("USUARIO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(33, 33, 33))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel6)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        gestionComidas_text.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        gestionComidas_text.setText("Gestion de Comidas");

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(gestionComidas_text)
                    .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(bgLayout.createSequentialGroup()
                            .addComponent(nuevo_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(guardar_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(borrar_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(bgLayout.createSequentialGroup()
                            .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 687, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, bgLayout.createSequentialGroup()
                                    .addComponent(verTodo_radio)
                                    .addGap(43, 43, 43)
                                    .addComponent(filtrarCalorias_radio)
                                    .addGap(18, 18, 18)
                                    .addComponent(filtroCalorias_textField, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(40, 40, 40)
                                    .addComponent(filtrarIngredientes_radio)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(filtroIngredientes_textField)))
                            .addGap(46, 46, 46)
                            .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jScrollPane2)
                                    .addComponent(tipoComida_textField)
                                    .addComponent(nombre_textField, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(calorias_spinner, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(baja_radio)
                                .addComponent(ingresarComidas_text)
                                .addComponent(nombre_text)
                                .addComponent(tipoComida_text)
                                .addComponent(detalle_text)
                                .addComponent(calorias_text)))))
                .addContainerGap(183, Short.MAX_VALUE))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
                .addComponent(gestionComidas_text)
                .addGap(32, 32, 32)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addComponent(ingresarComidas_text)
                        .addGap(18, 18, 18)
                        .addComponent(nombre_text)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nombre_textField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tipoComida_text)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tipoComida_textField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(detalle_text)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(calorias_text)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(calorias_spinner, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(baja_radio))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(filtrarIngredientes_radio)
                            .addComponent(filtrarCalorias_radio)
                            .addComponent(verTodo_radio)
                            .addComponent(filtroCalorias_textField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(filtroIngredientes_textField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(borrar_btn)
                    .addComponent(guardar_btn)
                    .addComponent(nuevo_btn))
                .addGap(67, 67, 67))
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

    private void verTodo_radioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verTodo_radioActionPerformed
        llenarTabla(cd.listarComidas());
        filtrarCalorias_radio.setSelected(false);
        filtrarIngredientes_radio.setSelected(false);
        filtroCalorias_textField.setEnabled(false);
        filtroIngredientes_textField.setEnabled(false);
    }//GEN-LAST:event_verTodo_radioActionPerformed

    private void filtrarCalorias_radioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filtrarCalorias_radioActionPerformed
        tabla.setRowCount(0);
        verTodo_radio.setSelected(false);
        filtrarIngredientes_radio.setSelected(false);
        filtroCalorias_textField.setEnabled(true);
        filtroIngredientes_textField.setEnabled(false);
        
        filtroCalorias_textField.addActionListener(e -> {
            try {
                int calorias = Integer.parseInt(filtroCalorias_textField.getText()); 
                List<Comida> comidas = cd.filtrarPorCalorias(calorias); 
                llenarTabla(comidas); 
            } catch (NumberFormatException ex) {
                System.out.println("Por favor, ingrese un número válido.");
            }
        });
    }//GEN-LAST:event_filtrarCalorias_radioActionPerformed

    private void filtrarIngredientes_radioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filtrarIngredientes_radioActionPerformed
        tabla.setRowCount(0);
        verTodo_radio.setSelected(false);
        filtrarCalorias_radio.setSelected(false);
        filtroCalorias_textField.setEnabled(false);
        filtroIngredientes_textField.setEnabled(true);
        
        filtroIngredientes_textField.addActionListener(e -> {
            try {
                String ingrediente = filtroIngredientes_textField.getText();
                List<Comida> comidas = cd.filtrarPorIngrediente(ingrediente);
                llenarTabla(comidas);
            } catch (NumberFormatException ex) {
                System.out.println("Por favor, ingrese un ingrediente válido.");
            }
        });
        
    }//GEN-LAST:event_filtrarIngredientes_radioActionPerformed

    private void nuevo_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevo_btnActionPerformed
        resetCampos();
        comidaActual = null;
    }//GEN-LAST:event_nuevo_btnActionPerformed

    private void guardar_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardar_btnActionPerformed
        try{
            String nombre = nombre_textField.getText();
            String tipoComida = tipoComida_textField.getText();
            String detalle = detalle_textArea.getText();
        
            if (nombre.isEmpty() || tipoComida.isEmpty() || detalle.isEmpty()){
                JOptionPane.showMessageDialog(null, "Asegúrese de completar todos los campos");
                return;
            }
                
            int calorias = (int)calorias_spinner.getValue();
            boolean baja = baja_radio.isSelected();
            

            if ( comidaActual == null){
                comidaActual =  new Comida(nombre, tipoComida, detalle, calorias, baja);
                cd.guardarComida(comidaActual);
                JOptionPane.showMessageDialog(null, "Comida guardada");
                resetCampos();
                
            } else {
                comidaActual.setNombre(nombre);
                comidaActual.setTipoComida(tipoComida);
                comidaActual.setDetalle(detalle);
                comidaActual.setCaloriasPor100g(calorias);
                comidaActual.setBaja(baja);

                cd.actualizarComida(comidaActual);
                resetCampos();
                
            }
        
        }catch (Exception e){
            JOptionPane.showMessageDialog(this, "Verifique los datos ingresados.");
        }    

    }//GEN-LAST:event_guardar_btnActionPerformed

    private void borrar_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrar_btnActionPerformed
        // agregar confirmacion   
        int filaSeleccionada = tablaComidas.getSelectedRow();
        if(filaSeleccionada!=-1){
            int codigo = (Integer)tablaComidas.getValueAt(filaSeleccionada, 0);
            cd.borrarComida(codigo);
            }
    }//GEN-LAST:event_borrar_btnActionPerformed

    private void baja_radioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_baja_radioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_baja_radioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton baja_radio;
    private javax.swing.JPanel bg;
    private javax.swing.JButton borrar_btn;
    private javax.swing.JSpinner calorias_spinner;
    private javax.swing.JLabel calorias_text;
    private javax.swing.JLabel detalle_text;
    private javax.swing.JTextArea detalle_textArea;
    private javax.swing.JRadioButton filtrarCalorias_radio;
    private javax.swing.JRadioButton filtrarIngredientes_radio;
    private javax.swing.JTextField filtroCalorias_textField;
    private javax.swing.JTextField filtroIngredientes_textField;
    private javax.swing.JLabel gestionComidas_text;
    private javax.swing.JButton guardar_btn;
    private javax.swing.JLabel ingresarComidas_text;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel nombre_text;
    private javax.swing.JTextField nombre_textField;
    private javax.swing.JButton nuevo_btn;
    private javax.swing.JTable tablaComidas;
    private javax.swing.JLabel tipoComida_text;
    private javax.swing.JTextField tipoComida_textField;
    private javax.swing.JRadioButton verTodo_radio;
    // End of variables declaration//GEN-END:variables
}
