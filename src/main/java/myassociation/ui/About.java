/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myassociation.ui;

import java.awt.Point;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import myassociation.controller.AssociationController;

/**
 *
 * @author FELGUEIRAS
 */
public class About extends javax.swing.JFrame {

    private static final long serialVersionUID = 1287134631239651914L;
    
    private AssociationController assocController = new AssociationController();
    private Point initialClick;
    /**
     * Creates new form About
     */
    public About() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setIconImage(assocController.applicationIcon());
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jplAbout = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        lblMyAssociation = new javax.swing.JLabel();
        lblMinimize = new javax.swing.JLabel();
        lblClose = new javax.swing.JLabel();
        txtAbout = new javax.swing.JTextArea();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 98, 206));
        setName("frmAbout"); // NOI18N
        setUndecorated(true);
        setResizable(false);

        jplAbout.setBackground(new java.awt.Color(0, 98, 206));
        jplAbout.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jplAboutMouseDragged(evt);
            }
        });
        jplAbout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jplAboutMousePressed(evt);
            }
        });

        lblLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/app_images/White_MyAssociationLogo_100px.png"))); // NOI18N

        lblMyAssociation.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblMyAssociation.setForeground(new java.awt.Color(255, 255, 255));
        lblMyAssociation.setText("MyAssociation");

        lblMinimize.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblMinimize.setForeground(new java.awt.Color(255, 255, 255));
        lblMinimize.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMinimize.setText("-");
        lblMinimize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblMinimizeMousePressed(evt);
            }
        });

        lblClose.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblClose.setForeground(new java.awt.Color(255, 255, 255));
        lblClose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblClose.setText("X");
        lblClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblCloseMousePressed(evt);
            }
        });

        txtAbout.setEditable(false);
        txtAbout.setBackground(new java.awt.Color(0, 98, 206));
        txtAbout.setColumns(20);
        txtAbout.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtAbout.setForeground(new java.awt.Color(255, 255, 255));
        txtAbout.setRows(5);
        txtAbout.setText(" MyAssociation v1.0\n\n Desenvolvido por:\n  - Cláudio Felgueiras\n  - Francisco Pereira\n  - Francisco Martins\n\n 2018");
        txtAbout.setBorder(null);
        txtAbout.setRequestFocusEnabled(false);

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jplAboutLayout = new javax.swing.GroupLayout(jplAbout);
        jplAbout.setLayout(jplAboutLayout);
        jplAboutLayout.setHorizontalGroup(
            jplAboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtAbout)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jplAboutLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblLogo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMyAssociation, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(117, 117, 117)
                .addComponent(lblMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblClose, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jSeparator1)
        );
        jplAboutLayout.setVerticalGroup(
            jplAboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jplAboutLayout.createSequentialGroup()
                .addGroup(jplAboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLogo)
                    .addGroup(jplAboutLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(lblMyAssociation, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jplAboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblClose, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtAbout, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jplAbout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jplAbout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblMinimizeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinimizeMousePressed
        setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_lblMinimizeMousePressed

    private void lblCloseMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMousePressed
        this.dispose();
    }//GEN-LAST:event_lblCloseMousePressed

    private void jplAboutMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jplAboutMouseDragged
        int thisX = this.getLocation().x;
        int thisY = this.getLocation().y;

        // Determine how much the mouse moved since the initial click
        int xMoved = (thisX + evt.getX()) - (thisX + initialClick.x);
        int yMoved = (thisY + evt.getY()) - (thisY + initialClick.y);

        // Move window to this position
        int X = thisX + xMoved;
        int Y = thisY + yMoved;
        this.setLocation(X, Y);
    }//GEN-LAST:event_jplAboutMouseDragged

    private void jplAboutMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jplAboutMousePressed
        initialClick = evt.getPoint();
    }//GEN-LAST:event_jplAboutMousePressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel jplAbout;
    private javax.swing.JLabel lblClose;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblMinimize;
    private javax.swing.JLabel lblMyAssociation;
    private javax.swing.JTextArea txtAbout;
    // End of variables declaration//GEN-END:variables
}
