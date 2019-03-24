/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myassociation.ui;

import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import myassociation.controller.AssociationController;
import myassociation.model.Association;

/**
 *
 * @author Cláudio Felgueiras
 */
public class AssociationSettings extends javax.swing.JFrame {

    private static final long serialVersionUID = -7529338988103187213L;

    private AssociationController associationController;
    private File ficheiro;
    private BufferedImage logo;
    private Association associacao;
    private Point initialClick;
    private final Object[] joptionpaneoptions = {"Sim", "Não"};

    /**
     * Creates new form Association
     */
    public AssociationSettings() {
        initComponents();
        associationController = new AssociationController();
        associacao = associationController.obterAssociacao();
        setDados();
        logo = createImageFromBytes(associacao.getLogotipo());
        this.setIconImage(associationController.applicationIcon());
        this.setLocationRelativeTo(null);
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

        jplMainSettings = new javax.swing.JPanel();
        lblMinimize = new javax.swing.JLabel();
        lblClose = new javax.swing.JLabel();
        jtabbedAssocSettings = new javax.swing.JTabbedPane();
        jplGeneralSettings = new javax.swing.JPanel();
        btnGeneralSave = new javax.swing.JButton();
        jplSettingsLogo = new javax.swing.JPanel();
        lblApplicationLogo = new javax.swing.JLabel();
        btnApplicationLogo = new javax.swing.JButton();
        lblAssocName2 = new javax.swing.JLabel();
        jplSettingsColor = new javax.swing.JPanel();
        jccGeneral = new javax.swing.JColorChooser();
        lblGeneralColor = new javax.swing.JLabel();
        jplAssociationSettings = new javax.swing.JPanel();
        txtAssocEmail = new javax.swing.JTextField();
        lblAssocName = new javax.swing.JLabel();
        lblAssocLogo = new javax.swing.JLabel();
        btnAssocLogo = new javax.swing.JButton();
        btnAssocSave = new javax.swing.JButton();
        lblAssocEmail = new javax.swing.JLabel();
        lblAssocNIF = new javax.swing.JLabel();
        lblAssocPresidente = new javax.swing.JLabel();
        lblAssocSecretario = new javax.swing.JLabel();
        lblAssocTesoureiro = new javax.swing.JLabel();
        lblAssocVogal1 = new javax.swing.JLabel();
        lblAssocVogal2 = new javax.swing.JLabel();
        lblAssocVogal3 = new javax.swing.JLabel();
        lblAssocVogal5 = new javax.swing.JLabel();
        lblAssocVogal4 = new javax.swing.JLabel();
        txtAssocName = new javax.swing.JTextField();
        txtAssocNIF = new javax.swing.JTextField();
        txtAssocPresidente = new javax.swing.JTextField();
        txtAssocSecretario = new javax.swing.JTextField();
        txtAssocName5 = new javax.swing.JTextField();
        txtAssocTesoureiro = new javax.swing.JTextField();
        txtAssocVogal1 = new javax.swing.JTextField();
        txtAssocVogal2 = new javax.swing.JTextField();
        txtAssocVogal3 = new javax.swing.JTextField();
        txtAssocVogal4 = new javax.swing.JTextField();
        txtAssocVogal5 = new javax.swing.JTextField();
        lblAssocMorada = new javax.swing.JLabel();
        lblAssocTelefone = new javax.swing.JLabel();
        lblAssocTelemovel = new javax.swing.JLabel();
        txtAssocMorada = new javax.swing.JTextField();
        txtAssocTelefone = new javax.swing.JTextField();
        txtAssocTelemovel = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 98, 206));
        setName("frmAssociationSettings"); // NOI18N
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jplMainSettings.setBackground(new java.awt.Color(246, 246, 246));
        jplMainSettings.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255), 2));
        jplMainSettings.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jplMainSettingsMouseDragged(evt);
            }
        });
        jplMainSettings.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblMinimize.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblMinimize.setForeground(new java.awt.Color(0, 98, 206));
        lblMinimize.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMinimize.setText("-");
        lblMinimize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblMinimizeMousePressed(evt);
            }
        });
        jplMainSettings.add(lblMinimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 0, 30, 32));

        lblClose.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblClose.setForeground(new java.awt.Color(0, 98, 206));
        lblClose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblClose.setText("X");
        lblClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblCloseMousePressed(evt);
            }
        });
        jplMainSettings.add(lblClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 0, 32, 32));

        jtabbedAssocSettings.setBackground(new java.awt.Color(255, 255, 255));
        jtabbedAssocSettings.setForeground(new java.awt.Color(0, 98, 206));
        jtabbedAssocSettings.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jtabbedAssocSettings.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jtabbedAssocSettings.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jplGeneralSettings.setBackground(new java.awt.Color(246, 246, 246));
        jplGeneralSettings.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jplGeneralSettings.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnGeneralSave.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnGeneralSave.setForeground(new java.awt.Color(0, 98, 206));
        btnGeneralSave.setText("Guardar");
        btnGeneralSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGeneralSaveActionPerformed(evt);
            }
        });
        jplGeneralSettings.add(btnGeneralSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 420, 93, 40));

        jplSettingsLogo.setBackground(new java.awt.Color(246, 246, 246));
        jplSettingsLogo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblApplicationLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblApplicationLogo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jplSettingsLogo.add(lblApplicationLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 5, 130, 110));

        btnApplicationLogo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnApplicationLogo.setForeground(new java.awt.Color(0, 98, 206));
        btnApplicationLogo.setLabel("Logótipo");
        btnApplicationLogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApplicationLogoActionPerformed(evt);
            }
        });
        jplSettingsLogo.add(btnApplicationLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 120, 130, 30));

        lblAssocName2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblAssocName2.setForeground(new java.awt.Color(0, 98, 206));
        lblAssocName2.setText("Logótipo da aplicação:");
        jplSettingsLogo.add(lblAssocName2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 140, 26));

        jplGeneralSettings.add(jplSettingsLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 700, 160));

        jplSettingsColor.setBackground(new java.awt.Color(246, 246, 246));
        jplSettingsColor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jccGeneral.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jplSettingsColor.add(jccGeneral, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 5, 450, 240));

        lblGeneralColor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblGeneralColor.setForeground(new java.awt.Color(0, 98, 206));
        lblGeneralColor.setText("Côr dos menus:");
        jplSettingsColor.add(lblGeneralColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        jplGeneralSettings.add(jplSettingsColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 700, 250));

        jtabbedAssocSettings.addTab("Geral", jplGeneralSettings);

        jplAssociationSettings.setBackground(new java.awt.Color(246, 246, 246));
        jplAssociationSettings.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jplAssociationSettings.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jplAssociationSettings.add(txtAssocEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 400, 420, 26));

        lblAssocName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblAssocName.setForeground(new java.awt.Color(0, 98, 206));
        lblAssocName.setText("Nome da Associação:");
        jplAssociationSettings.add(lblAssocName, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 140, 26));

        lblAssocLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAssocLogo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jplAssociationSettings.add(lblAssocLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, 130, 110));

        btnAssocLogo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAssocLogo.setForeground(new java.awt.Color(0, 98, 206));
        btnAssocLogo.setLabel("Logótipo");
        btnAssocLogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssocLogoActionPerformed(evt);
            }
        });
        jplAssociationSettings.add(btnAssocLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 130, 130, 30));
        btnAssocLogo.getAccessibleContext().setAccessibleName("");

        btnAssocSave.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAssocSave.setForeground(new java.awt.Color(0, 98, 206));
        btnAssocSave.setText("Guardar");
        btnAssocSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssocSaveActionPerformed(evt);
            }
        });
        jplAssociationSettings.add(btnAssocSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 433, 93, 40));

        lblAssocEmail.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblAssocEmail.setForeground(new java.awt.Color(0, 98, 206));
        lblAssocEmail.setText("Email:");
        jplAssociationSettings.add(lblAssocEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 140, 26));

        lblAssocNIF.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblAssocNIF.setForeground(new java.awt.Color(0, 98, 206));
        lblAssocNIF.setText("NIF:");
        jplAssociationSettings.add(lblAssocNIF, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 140, 26));

        lblAssocPresidente.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblAssocPresidente.setForeground(new java.awt.Color(0, 98, 206));
        lblAssocPresidente.setText("Presidente:");
        jplAssociationSettings.add(lblAssocPresidente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 140, 26));

        lblAssocSecretario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblAssocSecretario.setForeground(new java.awt.Color(0, 98, 206));
        lblAssocSecretario.setText("Secretário:");
        jplAssociationSettings.add(lblAssocSecretario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 140, 26));

        lblAssocTesoureiro.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblAssocTesoureiro.setForeground(new java.awt.Color(0, 98, 206));
        lblAssocTesoureiro.setText("Tesoureiro:");
        jplAssociationSettings.add(lblAssocTesoureiro, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 140, 26));

        lblAssocVogal1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblAssocVogal1.setForeground(new java.awt.Color(0, 98, 206));
        lblAssocVogal1.setText("Vogal 1:");
        jplAssociationSettings.add(lblAssocVogal1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 140, 26));

        lblAssocVogal2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblAssocVogal2.setForeground(new java.awt.Color(0, 98, 206));
        lblAssocVogal2.setText("Vogal 2:");
        jplAssociationSettings.add(lblAssocVogal2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 140, 26));

        lblAssocVogal3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblAssocVogal3.setForeground(new java.awt.Color(0, 98, 206));
        lblAssocVogal3.setText("Vogal 3:");
        jplAssociationSettings.add(lblAssocVogal3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 140, 26));

        lblAssocVogal5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblAssocVogal5.setForeground(new java.awt.Color(0, 98, 206));
        lblAssocVogal5.setText("Vogal 5:");
        jplAssociationSettings.add(lblAssocVogal5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 140, 26));

        lblAssocVogal4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblAssocVogal4.setForeground(new java.awt.Color(0, 98, 206));
        lblAssocVogal4.setText("Vogal 4:");
        jplAssociationSettings.add(lblAssocVogal4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 140, 26));
        jplAssociationSettings.add(txtAssocName, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 420, 26));
        jplAssociationSettings.add(txtAssocNIF, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 420, 26));
        jplAssociationSettings.add(txtAssocPresidente, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 420, 26));
        jplAssociationSettings.add(txtAssocSecretario, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 420, 26));
        jplAssociationSettings.add(txtAssocName5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 420, 26));
        jplAssociationSettings.add(txtAssocTesoureiro, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 420, 26));
        jplAssociationSettings.add(txtAssocVogal1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 420, 26));
        jplAssociationSettings.add(txtAssocVogal2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 420, 26));
        jplAssociationSettings.add(txtAssocVogal3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 420, 26));
        jplAssociationSettings.add(txtAssocVogal4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, 420, 26));
        jplAssociationSettings.add(txtAssocVogal5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, 420, 26));

        lblAssocMorada.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblAssocMorada.setForeground(new java.awt.Color(0, 98, 206));
        lblAssocMorada.setText("Morada:");
        jplAssociationSettings.add(lblAssocMorada, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 140, 26));

        lblAssocTelefone.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblAssocTelefone.setForeground(new java.awt.Color(0, 98, 206));
        lblAssocTelefone.setText("Telefone:");
        jplAssociationSettings.add(lblAssocTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 140, 26));

        lblAssocTelemovel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblAssocTelemovel.setForeground(new java.awt.Color(0, 98, 206));
        lblAssocTelemovel.setText("Telemóvel:");
        jplAssociationSettings.add(lblAssocTelemovel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 140, 26));
        jplAssociationSettings.add(txtAssocMorada, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 310, 420, 26));
        jplAssociationSettings.add(txtAssocTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 340, 420, 26));
        jplAssociationSettings.add(txtAssocTelemovel, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 370, 420, 26));

        jtabbedAssocSettings.addTab("Associação", jplAssociationSettings);

        jplMainSettings.add(jtabbedAssocSettings, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 740, 500));

        getContentPane().add(jplMainSettings, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblCloseMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMousePressed
        int selectedOption = JOptionPane.showOptionDialog(this,
                "Deseja mesmo sair?",
                "Definições da Associação",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                joptionpaneoptions,
                joptionpaneoptions[1]);
        if (selectedOption == JOptionPane.YES_OPTION) {
            this.dispose();
        } else {
            setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);
        }
    }//GEN-LAST:event_lblCloseMousePressed

    private void lblMinimizeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinimizeMousePressed
        setState(AssociationSettings.ICONIFIED);
    }//GEN-LAST:event_lblMinimizeMousePressed

    private void btnAssocLogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssocLogoActionPerformed
        try {
            JFileChooser filechooser = new JFileChooser();
            filechooser.setDialogTitle("Escolha a imagem");
            FileFilter filter = new FileNameExtensionFilter("Image Files", "jpg", "jpeg", "bmp", "png", "tif");
            filechooser.setFileFilter(filter);
            filechooser.setAcceptAllFileFilterUsed(false);
            filechooser.showOpenDialog(this);
            ficheiro = filechooser.getSelectedFile();
            logo = ImageIO.read(ficheiro);
            Image fotodim = logo.getScaledInstance(lblAssocLogo.getWidth(), lblAssocLogo.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon icone = new ImageIcon(fotodim);
            lblAssocLogo.setIcon(icone);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_btnAssocLogoActionPerformed

    private void btnAssocSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssocSaveActionPerformed

        try {
            byte[] logotipo = convertImagetoByte(logo);
            int selectedOption = JOptionPane.showOptionDialog(this,
                    "Deseja mesmo guardar as definições atuais?",
                    "Guardar definições",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    joptionpaneoptions,
                    joptionpaneoptions[1]);
            if (selectedOption == JOptionPane.YES_OPTION) {
                boolean associacaoeditada = associationController.editarAssociacao(txtAssocName.getText(), txtAssocNIF.getText(),
                        txtAssocPresidente.getText(), txtAssocSecretario.getText(), txtAssocTesoureiro.getText(),
                        txtAssocVogal1.getText(), txtAssocVogal2.getText(), txtAssocVogal3.getText(), txtAssocVogal4.getText(),
                        txtAssocVogal5.getText(), txtAssocMorada.getText(), txtAssocTelefone.getText(), txtAssocTelemovel.getText(),
                        txtAssocEmail.getText(), logotipo);
                if (associacaoeditada) {
                    JOptionPane.showMessageDialog(null, "Dados da associação alterados com sucesso", "Associação", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao realizar alteração.", "Associação", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (IOException ex) {
            System.out.println(ex);
            Logger.getLogger(AssociationSettings.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnAssocSaveActionPerformed

    private void jplMainSettingsMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jplMainSettingsMouseDragged
        int thisX = this.getLocation().x;
        int thisY = this.getLocation().y;

        // Determine how much the mouse moved since the initial click
        int xMoved = (thisX + evt.getX()) - (thisX + initialClick.x);
        int yMoved = (thisY + evt.getY()) - (thisY + initialClick.y);

        // Move window to this position
        int X = thisX + xMoved;
        int Y = thisY + yMoved;
        this.setLocation(X, Y);
    }//GEN-LAST:event_jplMainSettingsMouseDragged

    private void btnGeneralSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGeneralSaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGeneralSaveActionPerformed

    private void btnApplicationLogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApplicationLogoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnApplicationLogoActionPerformed
    private void setDados() {
        try {
            txtAssocName.setText(associacao.getNome());
            txtAssocNIF.setText(associacao.getNif());
            txtAssocPresidente.setText(associacao.getPresidente());
            txtAssocSecretario.setText(associacao.getSecretario());
            txtAssocTesoureiro.setText(associacao.getTesoureiro());
            txtAssocVogal1.setText(associacao.getVogal1());
            txtAssocVogal2.setText(associacao.getVogal2());
            txtAssocVogal3.setText(associacao.getVogal3());
            txtAssocVogal4.setText(associacao.getVogal4());
            txtAssocVogal5.setText(associacao.getVogal5());
            txtAssocMorada.setText(associacao.getMorada());
            txtAssocTelefone.setText(associacao.getTelefone());
            txtAssocTelemovel.setText(associacao.getTelemovel());
            txtAssocEmail.setText(associacao.getEmail());
            lblAssocLogo.setIcon(convertBytetoIcon(associacao.getLogotipo()));
        } catch (NullPointerException ex) {
            System.out.println(ex);
        }
    }

    private byte[] convertImagetoByte(BufferedImage foto) throws IOException {
        byte[] fotoinbytes;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        if (foto == null) {
            fotoinbytes = new byte[0];
        } else if (ficheiro == null) {
            fotoinbytes = associacao.getLogotipo();
        } else {
            try {
                foto = ImageIO.read(ficheiro);

                ImageIO.write(foto, "jpg", baos);
                baos.flush();
                baos.toByteArray();
            } catch (IOException ex) {
                Logger.getLogger(EditMember.class.getName()).log(Level.SEVERE, null, ex);
            }
            fotoinbytes = baos.toByteArray();;
        }
        return fotoinbytes;
    }

    private Icon convertBytetoIcon(byte[] fotografia) {
        ImageIcon icone = null;
        try {
            byte[] byteArray = fotografia;
            BufferedImage theImage = ImageIO.read(new ByteArrayInputStream(byteArray));
            Image fotodim = theImage.getScaledInstance(lblAssocLogo.getWidth(), lblAssocLogo.getHeight(), Image.SCALE_SMOOTH);
            icone = new ImageIcon(fotodim);

        } catch (IOException ex) {
            System.out.println(ex);
        } catch (NullPointerException exep) {
            System.out.println(exep);
        }
        return icone;
    }

    private BufferedImage createImageFromBytes(byte[] fotografia) {
        ByteArrayInputStream bais = new ByteArrayInputStream(fotografia);
        try {
            return ImageIO.read(bais);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApplicationLogo;
    private javax.swing.JButton btnAssocLogo;
    private javax.swing.JButton btnAssocSave;
    private javax.swing.JButton btnGeneralSave;
    private javax.swing.JColorChooser jccGeneral;
    private javax.swing.JPanel jplAssociationSettings;
    private javax.swing.JPanel jplGeneralSettings;
    private javax.swing.JPanel jplMainSettings;
    private javax.swing.JPanel jplSettingsColor;
    private javax.swing.JPanel jplSettingsLogo;
    private javax.swing.JTabbedPane jtabbedAssocSettings;
    private javax.swing.JLabel lblApplicationLogo;
    private javax.swing.JLabel lblAssocEmail;
    private javax.swing.JLabel lblAssocLogo;
    private javax.swing.JLabel lblAssocMorada;
    private javax.swing.JLabel lblAssocNIF;
    private javax.swing.JLabel lblAssocName;
    private javax.swing.JLabel lblAssocName2;
    private javax.swing.JLabel lblAssocPresidente;
    private javax.swing.JLabel lblAssocSecretario;
    private javax.swing.JLabel lblAssocTelefone;
    private javax.swing.JLabel lblAssocTelemovel;
    private javax.swing.JLabel lblAssocTesoureiro;
    private javax.swing.JLabel lblAssocVogal1;
    private javax.swing.JLabel lblAssocVogal2;
    private javax.swing.JLabel lblAssocVogal3;
    private javax.swing.JLabel lblAssocVogal4;
    private javax.swing.JLabel lblAssocVogal5;
    private javax.swing.JLabel lblClose;
    private javax.swing.JLabel lblGeneralColor;
    private javax.swing.JLabel lblMinimize;
    private javax.swing.JTextField txtAssocEmail;
    private javax.swing.JTextField txtAssocMorada;
    private javax.swing.JTextField txtAssocNIF;
    private javax.swing.JTextField txtAssocName;
    private javax.swing.JTextField txtAssocName5;
    private javax.swing.JTextField txtAssocPresidente;
    private javax.swing.JTextField txtAssocSecretario;
    private javax.swing.JTextField txtAssocTelefone;
    private javax.swing.JTextField txtAssocTelemovel;
    private javax.swing.JTextField txtAssocTesoureiro;
    private javax.swing.JTextField txtAssocVogal1;
    private javax.swing.JTextField txtAssocVogal2;
    private javax.swing.JTextField txtAssocVogal3;
    private javax.swing.JTextField txtAssocVogal4;
    private javax.swing.JTextField txtAssocVogal5;
    // End of variables declaration//GEN-END:variables
}
