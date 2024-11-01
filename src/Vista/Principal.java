package Vista;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JInternalFrame;

public class Principal extends javax.swing.JFrame {

    public Principal() {
        initComponents();
        
        //Calcula el tamaño de la pantalla para que el frame ocupe siempre el 75% 
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) (screenSize.width * 0.75);
        int height = (int) (screenSize.height * 0.75);

        setSize(width, height);
        setResizable(false);

        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        sideBar_bg = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        pacientes_btn = new javax.swing.JButton();
        inicio_btn = new javax.swing.JButton();
        comidas_btn = new javax.swing.JButton();
        dietas_btn = new javax.swing.JButton();
        menus_btn = new javax.swing.JButton();
        reportes_btn = new javax.swing.JButton();
        escritorio = new javax.swing.JDesktopPane();
        jdesktopPane_bg = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        sideBar_bg.setBackground(new java.awt.Color(255, 255, 255));

        logo.setForeground(new java.awt.Color(204, 204, 204));
        logo.setText("LOGO");

        pacientes_btn.setText("PACIENTES");
        pacientes_btn.setBorder(null);
        pacientes_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pacientes_btnActionPerformed(evt);
            }
        });

        inicio_btn.setText("INICIO");
        inicio_btn.setBorder(null);
        inicio_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicio_btnActionPerformed(evt);
            }
        });

        comidas_btn.setText("COMIDAS");
        comidas_btn.setBorder(null);
        comidas_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comidas_btnActionPerformed(evt);
            }
        });

        dietas_btn.setText("DIETAS");
        dietas_btn.setBorder(null);
        dietas_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dietas_btnActionPerformed(evt);
            }
        });

        menus_btn.setText("MENUS");
        menus_btn.setBorder(null);
        menus_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menus_btnActionPerformed(evt);
            }
        });

        reportes_btn.setText("REPORTES");
        reportes_btn.setBorder(null);
        reportes_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportes_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sideBar_bgLayout = new javax.swing.GroupLayout(sideBar_bg);
        sideBar_bg.setLayout(sideBar_bgLayout);
        sideBar_bgLayout.setHorizontalGroup(
            sideBar_bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sideBar_bgLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(sideBar_bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inicio_btn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pacientes_btn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dietas_btn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)))
            .addGroup(sideBar_bgLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(menus_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sideBar_bgLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(reportes_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(sideBar_bgLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comidas_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sideBar_bgLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logo)
                .addGap(97, 97, 97))
        );
        sideBar_bgLayout.setVerticalGroup(
            sideBar_bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sideBar_bgLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(logo)
                .addGap(129, 129, 129)
                .addComponent(inicio_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pacientes_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dietas_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menus_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comidas_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(reportes_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        escritorio.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jdesktopPane_bgLayout = new javax.swing.GroupLayout(jdesktopPane_bg);
        jdesktopPane_bg.setLayout(jdesktopPane_bgLayout);
        jdesktopPane_bgLayout.setHorizontalGroup(
            jdesktopPane_bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 871, Short.MAX_VALUE)
        );
        jdesktopPane_bgLayout.setVerticalGroup(
            jdesktopPane_bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 690, Short.MAX_VALUE)
        );

        escritorio.setLayer(jdesktopPane_bg, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jdesktopPane_bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jdesktopPane_bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addComponent(sideBar_bg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(escritorio))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sideBar_bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(escritorio)
        );

        getContentPane().add(bg, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inicio_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicio_btnActionPerformed

    }//GEN-LAST:event_inicio_btnActionPerformed

    private void dietas_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dietas_btnActionPerformed
    
    }//GEN-LAST:event_dietas_btnActionPerformed

    private void menus_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menus_btnActionPerformed
      
    }//GEN-LAST:event_menus_btnActionPerformed

    private void pacientes_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pacientes_btnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pacientes_btnActionPerformed

    private void reportes_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportes_btnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_reportes_btnActionPerformed

    private void comidas_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comidas_btnActionPerformed
        abrirInternalFrame(new VistaComida());
    }//GEN-LAST:event_comidas_btnActionPerformed

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
    private javax.swing.JButton dietas_btn;
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JButton inicio_btn;
    private javax.swing.JPanel jdesktopPane_bg;
    private javax.swing.JLabel logo;
    private javax.swing.JButton menus_btn;
    private javax.swing.JButton pacientes_btn;
    private javax.swing.JButton reportes_btn;
    private javax.swing.JPanel sideBar_bg;
    // End of variables declaration//GEN-END:variables
}
