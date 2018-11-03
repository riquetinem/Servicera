package br.com.servicera.views;

import java.sql.*;
import br.com.servicera.dao.ConnectionFactory;
import br.com.servicera.dao.UsuariosDao;
import br.com.servicera.model.Usuarios;
import br.com.servicera.util.Formatacao;

    /**
     * Classe publica que chama o metodo de Conexão
     * @author Servicera
     */
public class TelaUsuario extends javax.swing.JInternalFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    String id;
    
    /**
     * Chama dos pacotes util formatações para os JTextField's e Conexão com a DAO e faz pesquisa do Usuario
     * @author Servicera
     */
    
    public TelaUsuario() {
        initComponents();
        conexao = ConnectionFactory.getConnection();

        txtNome.requestFocus();
        
        Formatacao format = new Formatacao();

        jffTelefone.setFormatterFactory(format.fone());

        try {
            pesquisarUsuario();
        } catch (Exception e) {

        }

        UsuariosDao cmb = new UsuariosDao();
        cmb.populaComboBox(cmbPerfil);
    }
    /**
     * Metodo utilizado para limpar o botão da TelaUsuario
     * @author Servicera
     */

    private void limpar() {
        txtNome.setText("");
        jffTelefone.setText("");
        txtLogin.setText("");
        cmbPerfil.setSelectedIndex(0);
        txtSenha.setText("");
        txtConfirmSenha.setText("");
        btnCreate.setEnabled(true);
    }
    /**
     * Metodo averiguando se foi efetuada a inserção de dados no Banco de dados
     * @author Servicera
     * * @throws SQLException 
     */ 
     
    private void adicionar() throws SQLException {
        boolean cadastrou = false;

        UsuariosDao dao = new UsuariosDao();

        Usuarios usuario = new Usuarios(txtNome.getText(), jffTelefone.getText(), txtLogin.getText(), txtSenha.getText(), cmbPerfil.getSelectedItem().toString());

        try {
            cadastrou = dao.adicionarUsuario(usuario, txtConfirmSenha.getText());
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

        if (cadastrou) {
            limpar();
            pesquisarUsuario();
        }
    } 
    /**
     * Metodo que pesquisa dados no Banco de dados
     * @author Servicera
     * * @throws SQLException 
     */ 
    private void pesquisarUsuario() throws SQLException {
        UsuariosDao dao = new UsuariosDao();

        try {
            dao.pesquisarUsuario(txtPesquisar.getText(), tblUsuarios);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
    /**
     * Metodo para quando for selecionado com seu mouse alguma linha da Tabela que seja preenchida com os dados do BD
     * @author Servicera
     */
    public void setarCampos() {
        int setar = tblUsuarios.getSelectedRow();
        id = tblUsuarios.getModel().getValueAt(setar, 0).toString();
        txtNome.setText(tblUsuarios.getModel().getValueAt(setar, 1).toString());
        jffTelefone.setText(tblUsuarios.getModel().getValueAt(setar, 2).toString());
        txtLogin.setText(tblUsuarios.getModel().getValueAt(setar, 3).toString());
        cmbPerfil.setSelectedItem(tblUsuarios.getModel().getValueAt(setar, 4).toString());
        btnCreate.setEnabled(false);
    }
    /**
     * Metodo averiguando se foi efetuada a Atualização de dados no Banco de dados
     * @author Servicera
     * * @throws SQLException 
     */ 
    private void alterar() throws SQLException {
        boolean alterou;

        UsuariosDao dao = new UsuariosDao();

        Usuarios usuario = new Usuarios(id, txtNome.getText(), jffTelefone.getText(), txtLogin.getText(), txtSenha.getText(), cmbPerfil.getSelectedItem().toString());

        try {
            alterou = dao.alteraUsuario(usuario, txtConfirmSenha.getText());
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

        if (alterou) {
            limpar();
            pesquisarUsuario();
        }
    }
    /**
     * Metodo averiguando se foi efetuada a remoção de dados no Banco de dados
     * @author Servicera
     * * @throws SQLException 
     */ 
    private void remover() throws SQLException {
        boolean removeu;

        UsuariosDao dao = new UsuariosDao();

        try {
            removeu = dao.removeUsuario(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        if (removeu) {
            limpar();
            pesquisarUsuario();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        lblusunome = new javax.swing.JLabel();
        lbllogin = new javax.swing.JLabel();
        lblsenha = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblperfil = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        cmbPerfil = new javax.swing.JComboBox<>();
        lbltel = new javax.swing.JLabel();
        btnCreate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        tblUsu = new javax.swing.JScrollPane();
        tblUsuarios = new javax.swing.JTable();
        lblpesquisar = new javax.swing.JLabel();
        txtPesquisar = new javax.swing.JTextField();
        lblconfisenha = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        txtConfirmSenha = new javax.swing.JPasswordField();
        jffTelefone = new javax.swing.JFormattedTextField();

        jLabel9.setText("ID do Cliente: ");

        jTextField1.setEnabled(false);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Servicera - Usuários");
        setPreferredSize(new java.awt.Dimension(640, 480));

        lblusunome.setText("Nome* :");

        lbllogin.setText("Login*: ");

        lblsenha.setText("Senha*: ");

        lblperfil.setText("Perfil* :");

        lbltel.setText("Telefone* :");

        btnCreate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/servicera/icones/Create.png"))); // NOI18N
        btnCreate.setToolTipText("Adicionar");
        btnCreate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCreate.setPreferredSize(new java.awt.Dimension(120, 80));
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/servicera/icones/Delete.png"))); // NOI18N
        btnDelete.setToolTipText("Deletar");
        btnDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDelete.setPreferredSize(new java.awt.Dimension(120, 80));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/servicera/icones/Update.png"))); // NOI18N
        btnUpdate.setToolTipText("Atualizar");
        btnUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdate.setPreferredSize(new java.awt.Dimension(120, 80));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/servicera/icones/Limpar.png"))); // NOI18N
        btnLimpar.setToolTipText("Limpar Campos");
        btnLimpar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        tblUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "USUÁRIO", "FONE", "LOGIN", "PERFIL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUsuariosMouseClicked(evt);
            }
        });
        tblUsuarios.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblUsuariosKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tblUsuariosKeyTyped(evt);
            }
        });
        tblUsu.setViewportView(tblUsuarios);
        if (tblUsuarios.getColumnModel().getColumnCount() > 0) {
            tblUsuarios.getColumnModel().getColumn(0).setResizable(false);
            tblUsuarios.getColumnModel().getColumn(2).setResizable(false);
            tblUsuarios.getColumnModel().getColumn(3).setResizable(false);
            tblUsuarios.getColumnModel().getColumn(4).setResizable(false);
        }

        lblpesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/servicera/icones/lupa.png"))); // NOI18N

        txtPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisarKeyReleased(evt);
            }
        });

        lblconfisenha.setText("Conf. Senha*: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblpesquisar)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(tblUsu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1026, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbltel)
                                    .addComponent(lblusunome)
                                    .addComponent(lblperfil))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmbPerfil, 0, 206, Short.MAX_VALUE)
                                    .addComponent(txtNome, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                                    .addComponent(jffTelefone)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(btnCreate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(219, 219, 219)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbllogin)
                            .addComponent(lblsenha)
                            .addComponent(lblconfisenha))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtLogin)
                            .addComponent(txtSenha)
                            .addComponent(txtConfirmSenha)
                            .addComponent(btnLimpar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(179, 179, 179)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(lblpesquisar))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tblUsu, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblusunome)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbltel)
                            .addComponent(jffTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblperfil)
                            .addComponent(cmbPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbllogin)
                            .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblsenha)
                            .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblconfisenha)
                            .addComponent(txtConfirmSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                            .addComponent(btnCreate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(34, 34, 34))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnLimpar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        setBounds(0, 0, 1050, 600);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limpar();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        try {
            adicionar();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try {
            alterar();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
            remover();
        } catch (SQLException ex){
            throw new RuntimeException(ex);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tblUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUsuariosMouseClicked
        setarCampos();
    }//GEN-LAST:event_tblUsuariosMouseClicked

    private void tblUsuariosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblUsuariosKeyReleased

    }//GEN-LAST:event_tblUsuariosKeyReleased

    private void tblUsuariosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblUsuariosKeyTyped
    }//GEN-LAST:event_tblUsuariosKeyTyped

    private void txtPesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisarKeyReleased
        try {
            pesquisarUsuario();
        } catch (Exception e) {

        }
    }//GEN-LAST:event_txtPesquisarKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cmbPerfil;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JFormattedTextField jffTelefone;
    private javax.swing.JLabel lblconfisenha;
    private javax.swing.JLabel lbllogin;
    private javax.swing.JLabel lblperfil;
    private javax.swing.JLabel lblpesquisar;
    private javax.swing.JLabel lblsenha;
    private javax.swing.JLabel lbltel;
    private javax.swing.JLabel lblusunome;
    private javax.swing.JScrollPane tblUsu;
    private javax.swing.JTable tblUsuarios;
    private javax.swing.JPasswordField txtConfirmSenha;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPesquisar;
    private javax.swing.JPasswordField txtSenha;
    // End of variables declaration//GEN-END:variables
}
