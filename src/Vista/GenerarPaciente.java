package Vista;

import Modelo.Paciente;
import Persistencia.PacienteData;
import java.beans.PropertyVetoException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;


public class GenerarPaciente extends javax.swing.JInternalFrame {

    private PacienteData pacienteData;
    private DefaultTableModel tableModel;
    
    public GenerarPaciente() {
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
        
        pacienteData = new PacienteData();
        tableModel = new DefaultTableModel(new String[]{"Nro", "Nombre", "Edad", "Altura", "Peso Actual", "Peso Buscado"}, 0);
        jTpaciente.setModel(tableModel);
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        panel1 = new Vista.componentes.Panel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTpaciente = new javax.swing.JTable();
        jBactualizar = new javax.swing.JButton();
        jBborrar = new javax.swing.JButton();
        jBGuardar = new javax.swing.JButton();
        panel2 = new Vista.componentes.Panel();
        jRtodopacientes = new javax.swing.JRadioButton();
        jRpacientealta = new javax.swing.JRadioButton();
        jRpacientebaja = new javax.swing.JRadioButton();

        setBackground(new java.awt.Color(242, 242, 242));
        setBorder(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Generar paciente ");

        panel1.setBackground(new java.awt.Color(255, 255, 255));

        jTpaciente.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTpaciente);

        jBactualizar.setText("Actualizar");
        jBactualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBactualizarActionPerformed(evt);
            }
        });

        jBborrar.setText("Borrar");
        jBborrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBborrarActionPerformed(evt);
            }
        });

        jBGuardar.setText("Guardar");
        jBGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(jBGuardar)
                        .addGap(18, 18, 18)
                        .addComponent(jBactualizar)
                        .addGap(18, 18, 18)
                        .addComponent(jBborrar, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 727, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBborrar)
                    .addComponent(jBactualizar)
                    .addComponent(jBGuardar))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        panel2.setBackground(new java.awt.Color(255, 255, 255));

        jRtodopacientes.setText("Ver todos los pacientes");
        jRtodopacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRtodopacientesActionPerformed(evt);
            }
        });

        jRpacientealta.setText("Paciente de alta");
        jRpacientealta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRpacientealtaActionPerformed(evt);
            }
        });

        jRpacientebaja.setText("Paciente de baja");
        jRpacientebaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRpacientebajaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jRtodopacientes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jRpacientealta)
                .addGap(88, 88, 88)
                .addComponent(jRpacientebaja)
                .addGap(39, 39, 39))
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRpacientealta, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(jRpacientebaja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRtodopacientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRtodopacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRtodopacientesActionPerformed
        cargarPacientes("todos");
    }//GEN-LAST:event_jRtodopacientesActionPerformed

    private void jRpacientealtaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRpacientealtaActionPerformed
        cargarPacientes("altas");
    }//GEN-LAST:event_jRpacientealtaActionPerformed

    private void jRpacientebajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRpacientebajaActionPerformed
        cargarPacientes("bajas");
    }//GEN-LAST:event_jRpacientebajaActionPerformed

    private void jBborrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBborrarActionPerformed
        int filaSeleccionada = jTpaciente.getSelectedRow();
        if (filaSeleccionada != -1) {
            int nroPaciente = (Integer) tableModel.getValueAt(filaSeleccionada, 0);
            pacienteData.borrarPaciente(nroPaciente);
            JOptionPane.showMessageDialog(this, "Paciente eliminado.");
            cargarPacientes("todos"); 
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un paciente a eliminar.");
        }
    }//GEN-LAST:event_jBborrarActionPerformed

    private void jBactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBactualizarActionPerformed
int filaSeleccionada = jTpaciente.getSelectedRow();
        if (filaSeleccionada != -1) {
            int nroPaciente = (Integer) tableModel.getValueAt(filaSeleccionada, 0);
            Paciente paciente = pacienteData.buscarPaciente(nroPaciente);

            // Mostrar formulario de actualización
            paciente.setNombre(JOptionPane.showInputDialog("Ingrese el nombre:", paciente.getNombre()));
            paciente.setEdad(Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad:", paciente.getEdad())));
            paciente.setAltura(Float.parseFloat(JOptionPane.showInputDialog("Ingrese la altura:", paciente.getAltura())));
            paciente.setPesoActual(Float.parseFloat(JOptionPane.showInputDialog("Ingrese el peso actual:", paciente.getPesoActual())));
            paciente.setPesoBuscado(Float.parseFloat(JOptionPane.showInputDialog("Ingrese el peso buscado:", paciente.getPesoBuscado())));
            
            pacienteData.actualizarPaciente(paciente);
            JOptionPane.showMessageDialog(this, "Paciente actualizado.");
            cargarPacientes("todos"); 
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un paciente a actualizar.");
        }

    }//GEN-LAST:event_jBactualizarActionPerformed

    private void jBGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGuardarActionPerformed
     Paciente paciente = new Paciente();
        paciente.setNombre(JOptionPane.showInputDialog("Ingrese el nombre:"));
        paciente.setEdad(Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad:")));
        paciente.setAltura(Float.parseFloat(JOptionPane.showInputDialog("Ingrese la altura:")));
        paciente.setPesoActual(Float.parseFloat(JOptionPane.showInputDialog("Ingrese el peso actual:")));
        paciente.setPesoBuscado(Float.parseFloat(JOptionPane.showInputDialog("Ingrese el peso buscado:")));
        
        pacienteData.guardarPaciente(paciente);
        JOptionPane.showMessageDialog(this, "Paciente guardado.");
        cargarPacientes("todos"); 
    }//GEN-LAST:event_jBGuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBGuardar;
    private javax.swing.JButton jBactualizar;
    private javax.swing.JButton jBborrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton jRpacientealta;
    private javax.swing.JRadioButton jRpacientebaja;
    private javax.swing.JRadioButton jRtodopacientes;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTpaciente;
    private Vista.componentes.Panel panel1;
    private Vista.componentes.Panel panel2;
    // End of variables declaration//GEN-END:variables

    private void cargarPacientes(String estado) {
        tableModel.setRowCount(0); 
        List<Paciente> pacientes;

        switch (estado) {
            case "altas":
                pacientes = pacienteData.listarPacientesAltas();
                break;
            case "bajas":
                pacientes = pacienteData.listarPacientesBajas();
                break;
            case "todos":
            default:
                pacientes = pacienteData.listarPacientes();
                break;
        }

        for (Paciente p : pacientes) {
            tableModel.addRow(new Object[]{p.getNroPaciente(), p.getNombre(), p.getEdad(), p.getAltura(), p.getPesoActual(), p.getPesoBuscado()});
        }
}
}
    

