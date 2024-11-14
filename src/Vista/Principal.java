package Vista;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JInternalFrame;
import javax.swing.border.EmptyBorder;

public class Principal extends javax.swing.JFrame {

    public Principal() {
        initComponents();
        
        setLocationRelativeTo(null);
        setResizable(false);
        
        //estilos de los botones
        inicio_btn.setBorder(new EmptyBorder(20, 20, 20, 20)); 
        pacientes_btn.setBorder(new EmptyBorder(20, 20, 20, 20)); 
        dietas_btn.setBorder(new EmptyBorder(20, 20, 20, 20)); 
        menus_btn.setBorder(new EmptyBorder(20, 20, 20, 20)); 
        comidas_btn.setBorder(new EmptyBorder(20, 20, 20, 20)); 
        consultarMenus_btn.setBorder(new EmptyBorder(20, 20, 20, 20));
        
        cargarReportes();
        
        //Calcula el tamaño de la pantalla para que el frame ocupe siempre el 75% 
//        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//        int width = (int) (screenSize.width * 0.75);
//        int height = (int) (screenSize.height * 0.75);

     //   setSize(width, height);
//        setResizable(false);
//
//        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        escritorio = new javax.swing.JDesktopPane();
        panel1 = new Vista.componentes.Panel();
        inicio_btn = new javax.swing.JButton();
        pacientes_btn = new javax.swing.JButton();
        dietas_btn = new javax.swing.JButton();
        comidas_btn = new javax.swing.JButton();
        menus_btn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        consultarMenus_btn = new javax.swing.JButton();
        gradiente2 = new Vista.componentes.gradiente();
        user = new javax.swing.JLabel();
        user_picture = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        escritorio.setBackground(new java.awt.Color(242, 242, 242));
        escritorio.setForeground(new java.awt.Color(232, 232, 232));

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 519, Short.MAX_VALUE)
        );

        panel1.setBackground(new java.awt.Color(252, 252, 252));

        inicio_btn.setBackground(new java.awt.Color(252, 252, 252));
        inicio_btn.setForeground(new java.awt.Color(141, 141, 141));
        inicio_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/img/home-2.png"))); // NOI18N
        inicio_btn.setText("     Inicio");
        inicio_btn.setBorder(null);
        inicio_btn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        inicio_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicio_btnActionPerformed(evt);
            }
        });

        pacientes_btn.setBackground(new java.awt.Color(252, 252, 252));
        pacientes_btn.setForeground(new java.awt.Color(141, 141, 141));
        pacientes_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/img/pacientes (1).png"))); // NOI18N
        pacientes_btn.setText("     Pacientes");
        pacientes_btn.setBorder(null);
        pacientes_btn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        pacientes_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pacientes_btnActionPerformed(evt);
            }
        });

        dietas_btn.setBackground(new java.awt.Color(252, 252, 252));
        dietas_btn.setForeground(new java.awt.Color(141, 141, 141));
        dietas_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/img/dietas (1).png"))); // NOI18N
        dietas_btn.setText("     Dietas");
        dietas_btn.setBorder(null);
        dietas_btn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        dietas_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dietas_btnActionPerformed(evt);
            }
        });

        comidas_btn.setBackground(new java.awt.Color(252, 252, 252));
        comidas_btn.setForeground(new java.awt.Color(141, 141, 141));
        comidas_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/img/comidas-3.png"))); // NOI18N
        comidas_btn.setText("     Comidas");
        comidas_btn.setBorder(null);
        comidas_btn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        comidas_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comidas_btnActionPerformed(evt);
            }
        });

        menus_btn.setBackground(new java.awt.Color(252, 252, 252));
        menus_btn.setForeground(new java.awt.Color(141, 141, 141));
        menus_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/img/menu-2 (1).png"))); // NOI18N
        menus_btn.setText("     Menus");
        menus_btn.setBorder(null);
        menus_btn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        menus_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menus_btnActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/img/logo.png"))); // NOI18N

        consultarMenus_btn.setBackground(new java.awt.Color(252, 252, 252));
        consultarMenus_btn.setForeground(new java.awt.Color(141, 141, 141));
        consultarMenus_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/img/verMenus.png"))); // NOI18N
        consultarMenus_btn.setText("     Consultar Menus");
        consultarMenus_btn.setBorder(null);
        consultarMenus_btn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        consultarMenus_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarMenus_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(inicio_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pacientes_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(dietas_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(comidas_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(menus_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addContainerGap(36, Short.MAX_VALUE))
            .addComponent(consultarMenus_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                .addComponent(inicio_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pacientes_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dietas_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(comidas_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(menus_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(consultarMenus_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(104, 104, 104))
        );

        user.setForeground(new java.awt.Color(255, 255, 255));
        user.setText("USUARIO");

        user_picture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/img/Avatar.png"))); // NOI18N
        user_picture.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout gradiente2Layout = new javax.swing.GroupLayout(gradiente2);
        gradiente2.setLayout(gradiente2Layout);
        gradiente2Layout.setHorizontalGroup(
            gradiente2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gradiente2Layout.createSequentialGroup()
                .addContainerGap(674, Short.MAX_VALUE)
                .addComponent(user)
                .addGap(18, 18, 18)
                .addComponent(user_picture)
                .addGap(24, 24, 24))
        );
        gradiente2Layout.setVerticalGroup(
            gradiente2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradiente2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(user)
                .addContainerGap(15, Short.MAX_VALUE))
            .addComponent(user_picture, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addComponent(gradiente2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 16, Short.MAX_VALUE))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addComponent(escritorio)
                        .addContainerGap())))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                        .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(bgLayout.createSequentialGroup()
                        .addComponent(gradiente2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(escritorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 6, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inicio_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicio_btnActionPerformed
        abrirInternalFrame(new Reportes());
    }//GEN-LAST:event_inicio_btnActionPerformed

    private void pacientes_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pacientes_btnActionPerformed
       abrirInternalFrame(new GenerarPaciente());
    }//GEN-LAST:event_pacientes_btnActionPerformed

    private void dietas_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dietas_btnActionPerformed
        abrirInternalFrame(new VistaDieta());
    }//GEN-LAST:event_dietas_btnActionPerformed

    private void comidas_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comidas_btnActionPerformed
        abrirInternalFrame(new VistaComida());
    }//GEN-LAST:event_comidas_btnActionPerformed

    private void menus_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menus_btnActionPerformed
        abrirInternalFrame(new VistaGenerarMenu());
    }//GEN-LAST:event_menus_btnActionPerformed

    private void consultarMenus_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarMenus_btnActionPerformed
        abrirInternalFrame(new VistaVerMenusDiarios());
    }//GEN-LAST:event_consultarMenus_btnActionPerformed

    
     private void cargarReportes() {
        Reportes reporteFrame = new Reportes();

        reporteFrame.setSize(escritorio.getWidth(), escritorio.getHeight());
        reporteFrame.setLocation(0, 0);

        reporteFrame.setBorder(null);
        reporteFrame.setClosable(false);
        reporteFrame.setMaximizable(false);
        reporteFrame.setIconifiable(false);
        reporteFrame.setResizable(false);

        escritorio.add(reporteFrame);

        reporteFrame.setVisible(true);

        // Maximiza el JInternalFrame para que ocupe el tamaño completo del JDesktopPane
        try {
            reporteFrame.setMaximum(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     
    private void abrirInternalFrame(JInternalFrame iframe){
        for (javax.swing.JInternalFrame frame : escritorio.getAllFrames()) {
            frame.dispose();
        }
    
        escritorio.add(iframe);
        iframe.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JButton comidas_btn;
    private javax.swing.JButton consultarMenus_btn;
    private javax.swing.JButton dietas_btn;
    private javax.swing.JDesktopPane escritorio;
    private Vista.componentes.gradiente gradiente2;
    private javax.swing.JButton inicio_btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton menus_btn;
    private javax.swing.JButton pacientes_btn;
    private Vista.componentes.Panel panel1;
    private javax.swing.JLabel user;
    private javax.swing.JLabel user_picture;
    // End of variables declaration//GEN-END:variables
}
