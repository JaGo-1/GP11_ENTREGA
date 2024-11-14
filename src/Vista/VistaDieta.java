/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vista;

import Modelo.Dieta;
import Modelo.Paciente;
import Persistencia.*;
import java.beans.PropertyVetoException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

public class VistaDieta extends javax.swing.JInternalFrame {

    private Paciente paciente = null;
    private PacienteData dp = new PacienteData();
    private DietaData dd = new DietaData();
    private Dieta dietaActual = null;

    DefaultTableModel tablaDieta = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int f, int c) {
            return false;
        }
    };
    DefaultTableModel tablaPaciente = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int f, int c) {
            return false;
        }
    };

    public VistaDieta() {
        initComponents();

        this.setResizable(false);
        this.setMaximizable(false);
        cargarDatosEnComboBoxes();
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
    }

//    private void crearCabecera() {
//        tabla.addColumn("Código");
//        tabla.addColumn("Nombre");
//        tabla.addColumn("Calorias");
//        dieta_jTable1.setModel(tablaDieta);
//    }
    private void llenarTablaDietas(List<Dieta> dietas) {
        tablaDieta.setRowCount(0);
        for (Dieta d : dietas) {
            tablaDieta.addRow(new Object[]{d.getCodDieta(), d.getNombreD(), d.getTotalCalorias()});
        }
    }

    private void llenarTablaPacientes(List<Paciente> pacientes) {
        tablaPaciente.setRowCount(0);
        for (Paciente p : pacientes) {
            tablaPaciente.addRow(new Object[]{p.getNroPaciente(), p.getNombre(), p.getPesoActual(), p.getPesoBuscado()});
        }
    }

    private void cargarDatosEnComboBoxes() {
        // Cargar dietas

        dietas_jComboBox.removeAllItems();
        pacientes_jComboBox.removeAllItems();
        List<Dieta> dietas = dd.listarDietas();
        for (Dieta dieta : dietas) {
            dietas_jComboBox.addItem(dieta);
        }

        // Cargar pacientes
        List<Paciente> pacientes = dp.listarPacientesAltas();
        for (Paciente paciente : pacientes) {
            pacientes_jComboBox.addItem(paciente);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        panel1 = new Vista.componentes.Panel();
        CodigoDieta_Label = new javax.swing.JLabel();
        codigo_Text = new javax.swing.JTextField();
        buscar_jButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        nombre_Text = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        estado_jRadioButton = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        calorias_Text = new javax.swing.JTextField();
        nuevo_jButton = new javax.swing.JButton();
        guardar_jButton = new javax.swing.JButton();
        borrar_jButton = new javax.swing.JButton();
        panel2 = new Vista.componentes.Panel();
        jScrollPane1 = new javax.swing.JScrollPane();
        dieta_jTable1 = new javax.swing.JTable();
        dietasTotales_jRadioButton = new javax.swing.JRadioButton();
        panel3 = new Vista.componentes.Panel();
        jScrollPane3 = new javax.swing.JScrollPane();
        paciente_jTable1 = new javax.swing.JTable();
        dietasPaciente_jRadioButton = new javax.swing.JRadioButton();
        mostrarPacientesPorFecha_jRadioButton = new javax.swing.JRadioButton();
        panel4 = new Vista.componentes.Panel();
        jLabel6 = new javax.swing.JLabel();
        pesoFinal_Text = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        fechaInicio_jDateChooser = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        fechaFin_jDateChooser = new com.toedter.calendar.JDateChooser();
        asignarDieta_jButton = new javax.swing.JButton();
        dietas_jComboBox = new javax.swing.JComboBox<>();
        pacientes_jComboBox = new javax.swing.JComboBox<>();
        actualizar_jButton = new javax.swing.JButton();

        setBorder(null);

        jPanel1.setBackground(new java.awt.Color(242, 242, 242));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel3.setText("Crear Dieta");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel5.setText("Asignar Dieta");

        panel1.setBackground(new java.awt.Color(255, 255, 255));

        CodigoDieta_Label.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        CodigoDieta_Label.setText("Codigo:");

        codigo_Text.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        codigo_Text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codigo_TextActionPerformed(evt);
            }
        });

        buscar_jButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/img/buscar.png"))); // NOI18N
        buscar_jButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscar_jButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel1.setText("Nombre:");

        nombre_Text.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel7.setText("Estado:");

        estado_jRadioButton.setText("Activo");

        jLabel8.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel8.setText("Calorias:");

        calorias_Text.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        calorias_Text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calorias_TextActionPerformed(evt);
            }
        });

        nuevo_jButton.setText("Nuevo");
        nuevo_jButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevo_jButtonActionPerformed(evt);
            }
        });

        guardar_jButton.setText("Guardar");
        guardar_jButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardar_jButtonActionPerformed(evt);
            }
        });

        borrar_jButton.setText("Borrar");
        borrar_jButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrar_jButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(nuevo_jButton, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(guardar_jButton)
                        .addGap(18, 18, 18)
                        .addComponent(borrar_jButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(CodigoDieta_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(codigo_Text)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buscar_jButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nombre_Text)
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(estado_jRadioButton)
                                            .addComponent(calorias_Text, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE)))))))
                .addGap(45, 45, 45))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CodigoDieta_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codigo_Text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscar_jButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombre_Text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(estado_jRadioButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(calorias_Text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nuevo_jButton)
                    .addComponent(guardar_jButton)
                    .addComponent(borrar_jButton))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        panel2.setBackground(new java.awt.Color(255, 255, 255));

        dieta_jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        dieta_jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dieta_jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(dieta_jTable1);

        dietasTotales_jRadioButton.setText("Mostrar Dietas");
        dietasTotales_jRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dietasTotales_jRadioButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dietasTotales_jRadioButton)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(dietasTotales_jRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        panel3.setBackground(new java.awt.Color(255, 255, 255));

        paciente_jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        paciente_jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                paciente_jTable1MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(paciente_jTable1);

        dietasPaciente_jRadioButton.setText("Mostrar Pacientes");
        dietasPaciente_jRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dietasPaciente_jRadioButtonActionPerformed(evt);
            }
        });

        mostrarPacientesPorFecha_jRadioButton.setText("Mostrar Fechas");
        mostrarPacientesPorFecha_jRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarPacientesPorFecha_jRadioButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel3Layout = new javax.swing.GroupLayout(panel3);
        panel3.setLayout(panel3Layout);
        panel3Layout.setHorizontalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel3Layout.createSequentialGroup()
                        .addComponent(dietasPaciente_jRadioButton)
                        .addGap(117, 117, 117)
                        .addComponent(mostrarPacientesPorFecha_jRadioButton)
                        .addGap(23, 23, 23))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        panel3Layout.setVerticalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel3Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dietasPaciente_jRadioButton)
                    .addComponent(mostrarPacientesPorFecha_jRadioButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        panel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel6.setText("Actualizar Peso:");

        pesoFinal_Text.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        pesoFinal_Text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesoFinal_TextActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel2.setText("Fecha Inicio:");

        jLabel4.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel4.setText("Fecha Fin:");

        asignarDieta_jButton.setText("Asignar");
        asignarDieta_jButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asignarDieta_jButtonActionPerformed(evt);
            }
        });

        dietas_jComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dietas_jComboBoxActionPerformed(evt);
            }
        });

        pacientes_jComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pacientes_jComboBoxActionPerformed(evt);
            }
        });

        actualizar_jButton.setText("Actualizar");
        actualizar_jButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizar_jButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel4Layout = new javax.swing.GroupLayout(panel4);
        panel4.setLayout(panel4Layout);
        panel4Layout.setHorizontalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel4Layout.createSequentialGroup()
                .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel4Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panel4Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                                .addComponent(pesoFinal_Text, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel4Layout.createSequentialGroup()
                                .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)
                                    .addComponent(dietas_jComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(fechaInicio_jDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                                    .addComponent(fechaFin_jDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(pacientes_jComboBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(panel4Layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(asignarDieta_jButton))
                    .addGroup(panel4Layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(actualizar_jButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel4Layout.setVerticalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel4Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pacientes_jComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dietas_jComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fechaInicio_jDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fechaFin_jDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(asignarDieta_jButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pesoFinal_Text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(actualizar_jButton)
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3))
                    .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(panel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel5)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(panel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void paciente_jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paciente_jTable1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_paciente_jTable1MouseClicked

    private void asignarDieta_jButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asignarDieta_jButtonActionPerformed
        // TODO add your handling code here:    // Obtener la fila seleccionada en la tabla de dietas
        Dieta dietaSeleccionada = (Dieta) dietas_jComboBox.getSelectedItem();
        Paciente pacienteSeleccionado = (Paciente) pacientes_jComboBox.getSelectedItem();

        if (dietaSeleccionada == null || pacienteSeleccionado == null) {
            JOptionPane.showMessageDialog(this, "Seleccione una dieta y un paciente.");
            return;
        }

        int codigoDieta = dietaSeleccionada.getCodDieta();
        String nombreDieta = dietaSeleccionada.getNombreD();
        int codigoPaciente = pacienteSeleccionado.getNroPaciente();
        float pesoInicial = pacienteSeleccionado.getPesoActual();

        try {

            if (dd.pacienteTieneDieta(codigoPaciente)) {
                int respuesta = JOptionPane.showConfirmDialog(
                        this,
                        "Este paciente ya tiene una dieta asignada. ¿Desea cambiarla?",
                        "Confirmación de cambio de dieta",
                        JOptionPane.YES_NO_OPTION
                );

                if (respuesta == JOptionPane.YES_OPTION) {
                    dd.eliminarDietaAnterior(codigoPaciente);

                    java.util.Date dateInicial = fechaInicio_jDateChooser.getDate();
                    java.util.Date dateFinal = fechaFin_jDateChooser.getDate();

                    if (dateInicial == null || dateFinal == null) {
                        JOptionPane.showMessageDialog(this, "Seleccione ambas fechas (inicial y final) para continuar.");
                        return;
                    }

                    LocalDate fechaInicial = dateInicial.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                    LocalDate fechaFinal = dateFinal.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

                    dd.asignarDietaAPaciente(codigoDieta, nombreDieta, fechaInicial, fechaFinal, codigoPaciente, pesoInicial);
                } else {
                    JOptionPane.showMessageDialog(this, "La dieta del paciente no ha sido modificada.");
                }
            } else {
                java.util.Date dateInicial = fechaInicio_jDateChooser.getDate();
                java.util.Date dateFinal = fechaFin_jDateChooser.getDate();

                if (dateInicial == null || dateFinal == null) {
                    JOptionPane.showMessageDialog(this, "Seleccione ambas fechas (inicial y final) para continuar.");
                    return;
                }

                LocalDate fechaInicial = dateInicial.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                LocalDate fechaFinal = dateFinal.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

                dd.asignarDietaAPaciente(codigoDieta, nombreDieta, fechaInicial, fechaFinal, codigoPaciente, pesoInicial);
                JOptionPane.showMessageDialog(this, "Dieta asignada correctamente.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El peso final debe ser un número válido.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Se produjo un error: " + e.getMessage());
        }
    }//GEN-LAST:event_asignarDieta_jButtonActionPerformed


    private void dietasPaciente_jRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dietasPaciente_jRadioButtonActionPerformed
        // TODO add your handling code here:
        List<Object[]> listaPacientesYDietas = dp.obtenerPacientesYDietas();

        tablaPaciente.setRowCount(0);
        tablaPaciente.setColumnCount(0);

        tablaPaciente.addColumn("Nombre Paciente");
        tablaPaciente.addColumn("Peso Actual");
        tablaPaciente.addColumn("Peso Buscado");
        tablaPaciente.addColumn("Estado Paciente");
        tablaPaciente.addColumn("Dieta");
        tablaPaciente.addColumn("Peso Final");

        for (Object[] registro : listaPacientesYDietas) {
            String nombrePaciente = (String) registro[0];
            float pesoActual = (float) registro[1];
            float pesoBuscado = (float) registro[2];
            String estadoPaciente = (String) registro[3];
            String nombreDieta = (String) registro[4];
            float pesoFinal = (float) registro[5];

            tablaPaciente.addRow(new Object[]{
                nombrePaciente,
                pesoActual,
                pesoBuscado,
                estadoPaciente,
                nombreDieta,
                pesoFinal
            });
        }

        paciente_jTable1.setModel(tablaPaciente);

        mostrarPacientesPorFecha_jRadioButton.setSelected(false);
    }//GEN-LAST:event_dietasPaciente_jRadioButtonActionPerformed

    private void dietasTotales_jRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dietasTotales_jRadioButtonActionPerformed
        // TODO add your handling code here:
        tablaDieta.setRowCount(0);

        tablaDieta.setColumnCount(0);
        tablaDieta.addColumn("Código Dieta");
        tablaDieta.addColumn("Nombre");
        tablaDieta.addColumn("Total Calorías");

        llenarTablaDietas(dd.listarDietas());
        dieta_jTable1.setModel(tablaDieta);
    }//GEN-LAST:event_dietasTotales_jRadioButtonActionPerformed

    private void dieta_jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dieta_jTable1MouseClicked
        // TODO add your handling code here:
        //        int fila = dieta_jTable1.getSelectedRow();
        //        if (fila != -1) {
        //            int codigo = (Integer) dieta_jTable1.getValueAt(fila, 0);
        //            String nombre = (String) dieta_jTable1.getValueAt(fila, 1);
        //            int calorias = (Integer) dieta_jTable1.getValueAt(fila, 2);
        //
        //            codigo_Text.setText(codigo + "");
        //            nombre_Text.setText(nombre);
        //            calorias_Text.setText(calorias + "");
        //             }
    }//GEN-LAST:event_dieta_jTable1MouseClicked

    private void buscar_jButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscar_jButtonActionPerformed
        // TODO add your handling code here:
        try {
            int codigo = Integer.parseInt(codigo_Text.getText());
            dietaActual = dd.buscarDieta(codigo);
            if (dietaActual != null) {
                nombre_Text.setText(dietaActual.getNombreD());
                // LocalDate lc = dietaActual.getFechaIni();
                // java.util.Date date = java.util.Date.from(lc.atStartOfDay(ZoneId.systemDefault()).toInstant());
                // fechaInicio_jDateChooser.setDate(date);
                // LocalDate lc2 = dietaActual.getFechaFin();
                // java.util.Date date2 = java.util.Date.from(lc2.atStartOfDay(ZoneId.systemDefault()).toInstant());
                // fechaFin_jDateChooser.setDate(date2);
                calorias_Text.setText(String.valueOf(dietaActual.getTotalCalorias()));
            } else {
                JOptionPane.showMessageDialog(this, "El codigo de dieta ingresado no se encuentra.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese un codigo válido (numero entero).", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_buscar_jButtonActionPerformed

    private void borrar_jButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrar_jButtonActionPerformed
        // TODO add your handling code here:
        if (dietaActual != null) {
            dd.borrarDieta(dietaActual.getCodDieta());
            JOptionPane.showMessageDialog(this, "Dieta eliminada con exito.");
            dietaActual = null;
        } else {
            JOptionPane.showMessageDialog(this, "No hay seleccionada ninguna dieta.");
        }
    }//GEN-LAST:event_borrar_jButtonActionPerformed

    private void guardar_jButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardar_jButtonActionPerformed
        // TODO add your handling code here:

        //        try {
        //            int codigo = Integer.parseInt(codigo_Text.getText());
        //            String nombre = nombre_Text.getText();
        //            float pesoFinal = Float.parseFloat(pesoFinal_Text.getText());
        //            java.util.Date dateInicial = fechaInicio_jDateChooser.getDate();
        //            LocalDate fechaInicial = dateInicial.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        //            java.util.Date dateFinal = fechaFin_jDateChooser.getDate();
        //            LocalDate fechaFinal = dateFinal.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        //            int calorias = Integer.parseInt(calorias_Text.getText());
        //            Boolean estado = estado_jRadioButton.isSelected();
        //
        //            if (dietaActual == null) {
        //                dietaActual = new Dieta(codigo, nombre, fechaInicial, fechaFinal, pesoFinal, estado, calorias);
        //
        //                dd.guardarDieta(dietaActual);
        //
        //                JOptionPane.showMessageDialog(null, "Dieta guardada exitosamente.");
        //            } else {
        //                JOptionPane.showMessageDialog(null, "Ya existe una dieta actual. Por favor, elimínala o modifícala.");
        //            }
        //
        //        } catch (Exception e) {
        //        }
        try {
            String nombre = nombre_Text.getText();
            String caloriasText = calorias_Text.getText();

            if (nombre.isEmpty() || caloriasText.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.");
                return;
            }

            int calorias = Integer.parseInt(caloriasText);
            boolean estado = estado_jRadioButton.isSelected();

            if (dietaActual == null) {
                dietaActual = new Dieta(nombre, estado, calorias);
                dd.guardarDieta(dietaActual);
                JOptionPane.showMessageDialog(null, "Dieta guardada exitosamente.");
                resetCampos();
            } else {
                dietaActual.setNombreD(nombre);
                dietaActual.setTotalCalorias(calorias);
                dd.actualizarDieta(dietaActual);
                resetCampos();
                JOptionPane.showMessageDialog(null, "La dieta fue actualizada.");
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El campo de calorías debe ser un número válido.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se produjo un error: " + e.getMessage());
        }

    }//GEN-LAST:event_guardar_jButtonActionPerformed

    private void nuevo_jButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevo_jButtonActionPerformed
        // TODO add your handling code here:
        dietaActual = null;
        resetCampos();
    }//GEN-LAST:event_nuevo_jButtonActionPerformed

    private void calorias_TextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calorias_TextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_calorias_TextActionPerformed

    private void pesoFinal_TextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesoFinal_TextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pesoFinal_TextActionPerformed

    private void codigo_TextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codigo_TextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codigo_TextActionPerformed

    private void dietas_jComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dietas_jComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dietas_jComboBoxActionPerformed

    private void actualizar_jButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizar_jButtonActionPerformed
        // TODO add your handling code here:
        Paciente pacienteSeleccionado = (Paciente) pacientes_jComboBox.getSelectedItem();

        if (pacienteSeleccionado != null) {
            int codigoPaciente = pacienteSeleccionado.getNroPaciente();

            Float pesoActualIniciado = pacienteSeleccionado.getPesoActual();
            Float pesoBuscado = pacienteSeleccionado.getPesoBuscado();

            // Calculo para obtener la diferencia del peso inicial.
            Float diferenciaPesoInicial = Math.abs(pesoActualIniciado - pesoBuscado);

            // Obtener el nuevo peso ingresado por el usuario
            String pesoFinalActual = pesoFinal_Text.getText();

            if (pesoFinalActual.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, ingrese un peso actual.");
                return;
            }

            try {
                float nuevoPesoActual = Float.parseFloat(pesoFinalActual);

                if (nuevoPesoActual <= 0) {
                    JOptionPane.showMessageDialog(this, "El peso debe ser un valor positivo.");
                    return;
                }

                // Actualizar el peso actual del paciente en la base de datos
                dp.actualizarPesoActual(codigoPaciente, nuevoPesoActual);

                // Calculo para obtener la diferencia del peso final.
                float diferenciaPesoFinal = Math.abs(pesoBuscado - nuevoPesoActual);

                // Calculo para obtener el cambio en el peso
                float cambioDePeso = pesoActualIniciado - nuevoPesoActual;

                String cambioPeso;
                if (cambioDePeso > 0) {
                    cambioPeso = "El paciente ha bajado de peso en un total de " + cambioDePeso + " kg.\n";
                } else if (cambioDePeso < 0) {
                    cambioPeso = "El paciente ha subido de peso en un total de " + Math.abs(cambioDePeso) + " kg.\n";
                } else {
                    cambioPeso = "El peso del paciente se ha mantenido estable.\n";
                }

                // If para saber si cumple con el peso
                if (nuevoPesoActual <= pesoBuscado) {
                    // Mensaje si el paciente cumple el objetivo.
                    dp.actualizarEstadoPaciente(codigoPaciente, 0); // Cambiar el estado del paciente a Alta

                    JOptionPane.showMessageDialog(this,
                            "El paciente ha llegado a su peso objetivo de " + pesoBuscado + " kg.\n"
                            + "Peso inicial: " + pesoActualIniciado + " kg\n"
                            + "Diferencia de peso al inicio de la dieta: " + diferenciaPesoInicial + " kg\n"
                            + "Peso actual: " + nuevoPesoActual + " kg\n"
                            + cambioPeso
                            + "El paciente ha sido dado de alta."
                    );

                } else {
                    // String para mandar un mensaje diferente dependiendo del peso del paciente.
                    String subeBajaPeso;
                    if (diferenciaPesoFinal < diferenciaPesoInicial) {
                        subeBajaPeso = "El paciente se esta acercando a su peso objetivo.\n";
                    } else {
                        subeBajaPeso = "El paciente se ha alejado de su peso objetivo.\n";
                    }

                    dp.actualizarEstadoPaciente(codigoPaciente, 1); // Cambiar el estado del paciente a Activo

                    JOptionPane.showMessageDialog(this,
                            subeBajaPeso
                            + "Peso inicial: " + pesoActualIniciado + " kg\n"
                            + "Diferencia de peso al inicio de la dieta: " + diferenciaPesoInicial + " kg\n"
                            + "Peso actual: " + nuevoPesoActual + " kg\n"
                            + cambioPeso
                            + "El paciente continuará con la dieta."
                    );
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "El peso ingresado no es válido. Por favor ingrese un número.");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Se produjo un error: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un paciente.");
        }

        cargarDatosEnComboBoxes();
    }//GEN-LAST:event_actualizar_jButtonActionPerformed

    private void pacientes_jComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pacientes_jComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pacientes_jComboBoxActionPerformed

    private void mostrarPacientesPorFecha_jRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarPacientesPorFecha_jRadioButtonActionPerformed
        // TODO add your handling code here:
        List<Object[]> pacientes = dp.listarPacientesNoAlcanzaronPeso();

        tablaPaciente.setRowCount(0);
        tablaPaciente.setColumnCount(0);

        tablaPaciente.addColumn("Nombre");
        tablaPaciente.addColumn("Edad");
        tablaPaciente.addColumn("Altura");
        tablaPaciente.addColumn("Peso Actual");
        tablaPaciente.addColumn("Peso Buscado");
        tablaPaciente.addColumn("Fecha Fin");

        for (Object[] registro : pacientes) {
            String nombre = (String) registro[0];
            int edad = (int) registro[1];
            float altura = (float) registro[2];
            float pesoActual = (float) registro[3];
            float pesoBuscado = (float) registro[4];
            Date fechaFin = (Date) registro[5];

            tablaPaciente.addRow(new Object[]{
                nombre,
                edad,
                altura,
                pesoActual,
                pesoBuscado,
                fechaFin
            });
        }

        paciente_jTable1.setModel(tablaPaciente);
        
        dietasPaciente_jRadioButton.setSelected(false);
    }//GEN-LAST:event_mostrarPacientesPorFecha_jRadioButtonActionPerformed

    private void resetCampos() {
        nombre_Text.setText("");
        calorias_Text.setText("");
        pesoFinal_Text.setText("");
//        fechaInicio_jDateChooser.setDate(new Date());
//        fechaFin_jDateChooser.setDate(new Date());
        calorias_Text.setText("");
        estado_jRadioButton.setSelected(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CodigoDieta_Label;
    private javax.swing.JButton actualizar_jButton;
    private javax.swing.JButton asignarDieta_jButton;
    private javax.swing.JButton borrar_jButton;
    private javax.swing.JButton buscar_jButton;
    private javax.swing.JTextField calorias_Text;
    private javax.swing.JTextField codigo_Text;
    private javax.swing.JTable dieta_jTable1;
    private javax.swing.JRadioButton dietasPaciente_jRadioButton;
    private javax.swing.JRadioButton dietasTotales_jRadioButton;
    private javax.swing.JComboBox<Dieta> dietas_jComboBox;
    private javax.swing.JRadioButton estado_jRadioButton;
    private com.toedter.calendar.JDateChooser fechaFin_jDateChooser;
    private com.toedter.calendar.JDateChooser fechaInicio_jDateChooser;
    private javax.swing.JButton guardar_jButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JRadioButton mostrarPacientesPorFecha_jRadioButton;
    private javax.swing.JTextField nombre_Text;
    private javax.swing.JButton nuevo_jButton;
    private javax.swing.JTable paciente_jTable1;
    private javax.swing.JComboBox<Paciente> pacientes_jComboBox;
    private Vista.componentes.Panel panel1;
    private Vista.componentes.Panel panel2;
    private Vista.componentes.Panel panel3;
    private Vista.componentes.Panel panel4;
    private javax.swing.JTextField pesoFinal_Text;
    // End of variables declaration//GEN-END:variables
}
