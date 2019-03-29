/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myassociation.ui;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import myassociation.controller.AssociationController;
import myassociation.controller.UserController;

/**
 *
 * @author Cláudio Felgueiras
 */
public class CreateUser extends javax.swing.JFrame {

    private static final long serialVersionUID = 7969534140008029512L;

    private AssociationController associacaoController;
    private UserController utilizadorController;
    private ImageIcon icon;
    private final Object[] joptionpaneoptions = {"Sim", "Não"};

    /**
     * Creates new form CriarUtilizador
     */
    public CreateUser() {
        initComponents();
        associacaoController = new AssociationController();
        utilizadorController = new UserController();
        this.setLocationRelativeTo(null);
        this.setIconImage(associacaoController.applicationIcon());
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

        jplUtilCriar = new javax.swing.JPanel();
        lblUtilNome = new javax.swing.JLabel();
        lblUtilSenha = new javax.swing.JLabel();
        txtUtilNome = new javax.swing.JTextField();
        pwdUtilSenha = new javax.swing.JPasswordField();
        btnUtilCriar = new javax.swing.JButton();
        lblClose = new javax.swing.JLabel();
        lblMinimize = new javax.swing.JLabel();
        jcbUtilGrupo = new javax.swing.JComboBox<>();
        lblUtilGrupo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("frmCreateUser"); // NOI18N
        setUndecorated(true);

        jplUtilCriar.setBackground(new java.awt.Color(246, 246, 246));
        jplUtilCriar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 98, 206), 2));
        jplUtilCriar.setFocusable(false);
        jplUtilCriar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblUtilNome.setBackground(new java.awt.Color(204, 204, 204));
        lblUtilNome.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblUtilNome.setForeground(new java.awt.Color(0, 98, 206));
        lblUtilNome.setText("Nome:");
        jplUtilCriar.add(lblUtilNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 40, 54, 24));

        lblUtilSenha.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblUtilSenha.setForeground(new java.awt.Color(0, 98, 206));
        lblUtilSenha.setText("Senha:");
        jplUtilCriar.add(lblUtilSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 54, 24));
        jplUtilCriar.add(txtUtilNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 290, 24));
        jplUtilCriar.add(pwdUtilSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 290, 24));

        btnUtilCriar.setBackground(new java.awt.Color(255, 255, 255));
        btnUtilCriar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnUtilCriar.setForeground(new java.awt.Color(0, 98, 206));
        btnUtilCriar.setText("Criar");
        btnUtilCriar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUtilCriarActionPerformed(evt);
            }
        });
        jplUtilCriar.add(btnUtilCriar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 93, 40));

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
        jplUtilCriar.add(lblClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, 32, 32));

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
        jplUtilCriar.add(lblMinimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 0, 32, 32));

        jcbUtilGrupo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Standard", "Administrador", "Basico" }));
        jplUtilCriar.add(jcbUtilGrupo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, 290, 24));

        lblUtilGrupo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblUtilGrupo.setForeground(new java.awt.Color(0, 98, 206));
        lblUtilGrupo.setText("Grupo:");
        jplUtilCriar.add(lblUtilGrupo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 54, 24));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 98, 206));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CRIAR UTILIZADOR");
        jplUtilCriar.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 0, 290, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jplUtilCriar, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jplUtilCriar, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUtilCriarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUtilCriarActionPerformed
        if (txtUtilNome.getText().isEmpty() || pwdUtilSenha.getPassword().equals("")) {
            JOptionPane.showMessageDialog(null, "Os dados do utilizador não podem ser vazios. \nInsira um utilizador e uma senha.", "Criar Utilizador", JOptionPane.ERROR_MESSAGE);
        } else {
            boolean utilcriado = utilizadorController.criarUtilizador(txtUtilNome.getText(), String.valueOf(pwdUtilSenha.getPassword()), (String) jcbUtilGrupo.getSelectedItem());
            if (utilcriado) {
                JOptionPane.showMessageDialog(null, "Utilizador criado com sucesso.", "Utilizador", JOptionPane.INFORMATION_MESSAGE);
                txtUtilNome.setText("");
                pwdUtilSenha.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "Utilizador já existe.\n Insira outros dados.", "Utilizador", JOptionPane.ERROR_MESSAGE);
                txtUtilNome.setText("");
                pwdUtilSenha.setText("");
            }
        }
    }//GEN-LAST:event_btnUtilCriarActionPerformed

    private void lblMinimizeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinimizeMousePressed
        setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_lblMinimizeMousePressed

    private void lblCloseMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMousePressed
        int selectedOption = JOptionPane.showOptionDialog(this,
                "Deseja mesmo sair?",
                "Criar sócio",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                joptionpaneoptions,
                joptionpaneoptions[1]);
        if (selectedOption == JOptionPane.YES_OPTION) {
            this.dispose();
        } else {
            setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        }
    }//GEN-LAST:event_lblCloseMousePressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUtilCriar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JComboBox<String> jcbUtilGrupo;
    private javax.swing.JPanel jplUtilCriar;
    private javax.swing.JLabel lblClose;
    private javax.swing.JLabel lblMinimize;
    private javax.swing.JLabel lblUtilGrupo;
    private javax.swing.JLabel lblUtilNome;
    private javax.swing.JLabel lblUtilSenha;
    private javax.swing.JPasswordField pwdUtilSenha;
    private javax.swing.JTextField txtUtilNome;
    // End of variables declaration//GEN-END:variables
}
