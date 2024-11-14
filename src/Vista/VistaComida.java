package Vista;

import Modelo.Comida;
import Modelo.TipoComida;
import Persistencia.ComidaData;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyVetoException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.plaf.basic.BasicInternalFrameUI;
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

        SpinnerNumberModel model = new SpinnerNumberModel(valorInicial, min, 1000, paso);
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
                
                if (spinnerTextField.getText().length() >= 4 && Character.isDigit(c)) {
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
        ingresarComidas_text = new javax.swing.JLabel();
        gestionComidas_text = new javax.swing.JLabel();
        panel1 = new Vista.componentes.Panel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaComidas = new javax.swing.JTable();
        borrar_btn = new javax.swing.JButton();
        verTodo_radio = new javax.swing.JRadioButton();
        panel2 = new Vista.componentes.Panel();
        filtrarCalorias_radio = new javax.swing.JRadioButton();
        filtroCalorias_textField = new javax.swing.JTextField();
        filtrarIngredientes_radio = new javax.swing.JRadioButton();
        filtroIngredientes_textField = new javax.swing.JTextField();
        panel3 = new Vista.componentes.Panel();
        nombre_text = new javax.swing.JLabel();
        nombre_textField = new javax.swing.JTextField();
        tipoComida_text = new javax.swing.JLabel();
        tipoComida_textField = new javax.swing.JTextField();
        detalle_text = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        detalle_textArea = new javax.swing.JTextArea();
        calorias_text = new javax.swing.JLabel();
        calorias_spinner = new javax.swing.JSpinner();
        baja_radio = new javax.swing.JRadioButton();
        guardar_btn = new javax.swing.JButton();
        nuevo_btn = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(null);

        ingresarComidas_text.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        ingresarComidas_text.setText("Ingresar Comidas");

        gestionComidas_text.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        gestionComidas_text.setText("Gestión de Comidas");

        panel1.setBackground(new java.awt.Color(255, 255, 255));

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

        verTodo_radio.setText("Ver todo");
        verTodo_radio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verTodo_radioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(verTodo_radio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(borrar_btn))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(borrar_btn)
                    .addComponent(verTodo_radio))
                .addGap(33, 33, 33))
        );

        panel2.setBackground(new java.awt.Color(255, 255, 255));

        filtrarCalorias_radio.setText("Filtrar por calorías");
        filtrarCalorias_radio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtrarCalorias_radioActionPerformed(evt);
            }
        });

        filtrarIngredientes_radio.setText("Filtrar por ingredientes");
        filtrarIngredientes_radio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtrarIngredientes_radioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(filtrarCalorias_radio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(filtroCalorias_textField, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(filtrarIngredientes_radio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(filtroIngredientes_textField, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(filtroCalorias_textField)
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(filtrarCalorias_radio)
                            .addComponent(filtrarIngredientes_radio)
                            .addComponent(filtroIngredientes_textField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        panel3.setBackground(new java.awt.Color(255, 255, 255));

        nombre_text.setText("Nombre");

        tipoComida_text.setText("Tipo de comida");

        detalle_text.setText("Detalle");

        detalle_textArea.setColumns(20);
        detalle_textArea.setRows(5);
        jScrollPane2.setViewportView(detalle_textArea);

        calorias_text.setText("Calorias (100gr)");

        baja_radio.setText("Baja");

        guardar_btn.setText("Guardar");
        guardar_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardar_btnActionPerformed(evt);
            }
        });

        nuevo_btn.setText("Limpiar");
        nuevo_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevo_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel3Layout = new javax.swing.GroupLayout(panel3);
        panel3.setLayout(panel3Layout);
        panel3Layout.setHorizontalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(baja_radio)
                    .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(panel3Layout.createSequentialGroup()
                            .addGap(21, 21, 21)
                            .addComponent(nuevo_btn)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(guardar_btn))
                        .addComponent(calorias_text, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(detalle_text, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(tipoComida_textField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                        .addComponent(tipoComida_text, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(nombre_textField, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(nombre_text, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(calorias_spinner, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        panel3Layout.setVerticalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(nombre_text)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nombre_textField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tipoComida_text)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tipoComida_textField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(detalle_text)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(calorias_text)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(calorias_spinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(baja_radio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(guardar_btn)
                    .addComponent(nuevo_btn))
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(panel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(gestionComidas_text))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ingresarComidas_text)
                    .addComponent(panel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ingresarComidas_text)
                    .addComponent(gestionComidas_text))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(panel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
                JOptionPane.showMessageDialog(null, "Ingrese un número válido.");
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
        
            String ingredientesText = filtroIngredientes_textField.getText();
        
       
            if (ingredientesText.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese al menos un ingrediente.");
                return; 
            }

       
            List<String> ingredientes = Arrays.stream(ingredientesText.split(","))
                                           .map(String::trim)  
                                           .collect(Collectors.toList());

            List<Comida> comidas = cd.filtrarPorIngredientes(ingredientes);

       
            llenarTabla(comidas);

    } catch (Exception ex) {
        System.out.println("Error al filtrar ingredientes: " + ex.getMessage());
        JOptionPane.showMessageDialog(null, "Error al filtrar ingredientes");
    }
});
          
        
    }//GEN-LAST:event_filtrarIngredientes_radioActionPerformed

    private void nuevo_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevo_btnActionPerformed
        resetCampos();
        comidaActual = null;
    }//GEN-LAST:event_nuevo_btnActionPerformed

    private void guardar_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardar_btnActionPerformed
                                                  
    try {
        String nombre = nombre_textField.getText();
        String tipoComidaStr = tipoComida_textField.getText();  
        String detalle = detalle_textArea.getText();

        if (!nombre.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")) {
            JOptionPane.showMessageDialog(null, "El nombre solo puede contener letras.");
            return;
        }
        
        if (!detalle.matches("^[a-zA-Z0-9áéíóúÁÉÍÓÚñÑ\\s]+$")) {
            JOptionPane.showMessageDialog(null, "El detalle solo puede contener letras y números.");
            return;
        }
        
        if (nombre.isEmpty() || tipoComidaStr.isEmpty() || detalle.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Asegúrese de completar todos los campos");
            return;
        }

       
        TipoComida tipoComida = null;
        try {
            tipoComida = TipoComida.valueOf(tipoComidaStr.toUpperCase());
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Tipo de comida no válido. Por favor, ingrese un valor correcto.");
            return;
        }

        int calorias = (int)calorias_spinner.getValue();
        boolean baja = baja_radio.isSelected();

        if (comidaActual == null) {
            comidaActual = new Comida(nombre, tipoComida, detalle, calorias, baja);
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

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al guardar la comida: " + e.getMessage());
    }


    }//GEN-LAST:event_guardar_btnActionPerformed

    private void borrar_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrar_btnActionPerformed
       
        int respuesta = JOptionPane.showConfirmDialog(null, "Usted está a punto de borrar una comida ¿Deseas continuar?", "Confirmación", JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION) {
            int filaSeleccionada = tablaComidas.getSelectedRow();
            if(filaSeleccionada!=-1){
                int codigo = (Integer)tablaComidas.getValueAt(filaSeleccionada, 0);
                cd.borrarComida(codigo);
                JOptionPane.showMessageDialog(null, "Comida borrada con éxito.");
            }
        } 
        
       
    }//GEN-LAST:event_borrar_btnActionPerformed

    private void verTodo_radioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verTodo_radioActionPerformed
        llenarTabla(cd.listarComidas());
        filtrarCalorias_radio.setSelected(false);
        filtrarIngredientes_radio.setSelected(false);
        filtroCalorias_textField.setEnabled(false);
        filtroIngredientes_textField.setEnabled(false);
    }//GEN-LAST:event_verTodo_radioActionPerformed


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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel nombre_text;
    private javax.swing.JTextField nombre_textField;
    private javax.swing.JButton nuevo_btn;
    private Vista.componentes.Panel panel1;
    private Vista.componentes.Panel panel2;
    private Vista.componentes.Panel panel3;
    private javax.swing.JTable tablaComidas;
    private javax.swing.JLabel tipoComida_text;
    private javax.swing.JTextField tipoComida_textField;
    private javax.swing.JRadioButton verTodo_radio;
    // End of variables declaration//GEN-END:variables
}
