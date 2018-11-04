package br.com.servicera.views;

import java.sql.*;
import br.com.servicera.dao.ConnectionFactory;
import br.com.servicera.dao.OrdemServicoDao;
import br.com.servicera.model.OrdemServico;

    /**
     * Classe respondavel para criação de Conexões e Resultados 
     * @author Servicera
     */
public class TelaOrdemServico extends javax.swing.JInternalFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    String id;

    private String tipo;
    
     /**
     * Chama dos pacotes de Conexão com a DAO e faz a pesquisa da Ordem de Serviço
     * @author Servicera
     */
    public TelaOrdemServico() {
        initComponents();
        conexao = ConnectionFactory.getConnection();

        try {
            pesquisarOrdemServico();
        } catch (Exception e) {

        }

        OrdemServicoDao ordemServico = new OrdemServicoDao();
        ordemServico.populaComboBoxTecnicos(cmbTecnico);
        ordemServico.populaComboBoxSituacao(cmbSituacao);
        ordemServico.populaComboBoxCliente(cmbCliente);

        pesquisarOrdemServico();
    }

    /**
     * Metodo utilizado para limpar o botão da TelaOrdemServico
     * @author Servicera
     */
    private void limpar() {
        txtDefeito.setText("");
        txtEquipamento.setText("");
        txtValor.setText("");
        cmbTecnico.setSelectedIndex(0);
        cmbCliente.setSelectedIndex(0);
        cmbSituacao.setSelectedIndex(0);
        txtServico.setText("");
        txtPesquisar.setEnabled(true);
        btnCreate.setEnabled(true);
        tblOrdemServico.setVisible(true);
    }
    
    /**
     * Metodo para pesquisar a Ordem de Serviço no Banco de dados
     * @author Servicera
     */

    private void pesquisarOrdemServico() {
        OrdemServicoDao dao = new OrdemServicoDao();

        dao.pesquisarOrdemServico(txtPesquisar.getText(), tblOrdemServico);
    }
    
     /**
     * Metodo para quando for selecionado com seu mouse alguma linha da Tabela que seja preenchida com os dados do BD
     * @author Servicera
     */

    private void setarCampos() {
        int setar = tblOrdemServico.getSelectedRow();
        id = tblOrdemServico.getModel().getValueAt(setar, 0).toString();
        cmbCliente.setSelectedItem(tblOrdemServico.getModel().getValueAt(setar, 1).toString());
        cmbSituacao.setSelectedItem(tblOrdemServico.getModel().getValueAt(setar, 3).toString());
        txtEquipamento.setText(tblOrdemServico.getModel().getValueAt(setar, 4).toString());
        txtDefeito.setText(tblOrdemServico.getModel().getValueAt(setar, 5).toString());
        txtServico.setText(tblOrdemServico.getModel().getValueAt(setar, 6).toString());
        cmbTecnico.setSelectedItem(tblOrdemServico.getModel().getValueAt(setar, 7).toString());
        txtValor.setText(tblOrdemServico.getModel().getValueAt(setar, 8).toString());
         btnCreate.setEnabled(false);
    }
    
    /**
     * Metodo averiguando se foi efetuada a inserção de dados no Banco de dados
     * @author Servicera
     */
    private void adiciona() {
        boolean adicionou = false;

        OrdemServicoDao dao = new OrdemServicoDao();
        OrdemServico ordemServico = new OrdemServico(cmbSituacao.getSelectedItem().toString(),
                txtEquipamento.getText(), txtDefeito.getText(), 
                txtServico.getText(), cmbTecnico.getSelectedItem().toString(), 
                txtValor.getText(), cmbCliente.getSelectedItem().toString());

        try {
            adicionou = dao.adicionarOrdemServico(ordemServico);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        if (adicionou) {
            limpar();
            pesquisarOrdemServico();
        }
    }
    /**
     * Metodo averiguando se foi efetuada a Atualização de dados no Banco de dados
     * @author Servicera
     */
    private void alterar() {
        boolean alterou = false;

        OrdemServicoDao dao = new OrdemServicoDao();
        OrdemServico ordemServico = new OrdemServico(id, cmbSituacao.getSelectedItem().toString(),
                txtEquipamento.getText(), txtDefeito.getText(),
                txtServico.getText(), cmbTecnico.getSelectedItem().toString(), 
                txtValor.getText(), cmbCliente.getSelectedItem().toString());

        try {
            alterou = dao.alteraOrdemServico(ordemServico);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        if (alterou) {
            limpar();
            pesquisarOrdemServico();
        }
    }
    
    /**
     * Metodo averiguando se foi efetuada a remoção de dados no Banco de dados
     * @author Servicera
     */
    private void excluir() {
        boolean excluiu = false;

        OrdemServicoDao dao = new OrdemServicoDao();

        try {
            excluiu = dao.excluirOrdemServico(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        if (excluiu) {
            limpar();
            pesquisarOrdemServico();
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        lblsit = new javax.swing.JLabel();
        cmbSituacao = new javax.swing.JComboBox<>();
        JpOS = new javax.swing.JPanel();
        lblpesquisa = new javax.swing.JLabel();
        txtPesquisar = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblOrdemServico = new javax.swing.JTable();
        lblequip = new javax.swing.JLabel();
        lbldef = new javax.swing.JLabel();
        lblserv = new javax.swing.JLabel();
        lbltec = new javax.swing.JLabel();
        lblvt = new javax.swing.JLabel();
        txtEquipamento = new javax.swing.JTextField();
        txtServico = new javax.swing.JTextField();
        txtValor = new javax.swing.JTextField();
        txtDefeito = new javax.swing.JTextField();
        btnCreate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        cmbTecnico = new javax.swing.JComboBox<>();
        lblCliente = new javax.swing.JLabel();
        cmbCliente = new javax.swing.JComboBox<>();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Servicera - Ordem de Serviço");
        setPreferredSize(new java.awt.Dimension(700, 500));
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        lblsit.setText("Situação:");

        JpOS.setBorder(javax.swing.BorderFactory.createTitledBorder("Ordem de Serviço"));

        lblpesquisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/servicera/icones/lupa.png"))); // NOI18N

        txtPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisarKeyReleased(evt);
            }
        });

        tblOrdemServico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Cliente", "Emissão", "Tipo", "Situação", "Equipamentos", "Defeitos", "Serviço", "Valor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblOrdemServico.setColumnSelectionAllowed(true);
        tblOrdemServico.getTableHeader().setReorderingAllowed(false);
        tblOrdemServico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblOrdemServicoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblOrdemServico);
        tblOrdemServico.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (tblOrdemServico.getColumnModel().getColumnCount() > 0) {
            tblOrdemServico.getColumnModel().getColumn(0).setMinWidth(15);
            tblOrdemServico.getColumnModel().getColumn(0).setPreferredWidth(30);
            tblOrdemServico.getColumnModel().getColumn(0).setMaxWidth(25);
            tblOrdemServico.getColumnModel().getColumn(1).setResizable(false);
            tblOrdemServico.getColumnModel().getColumn(1).setPreferredWidth(30);
            tblOrdemServico.getColumnModel().getColumn(2).setPreferredWidth(30);
            tblOrdemServico.getColumnModel().getColumn(3).setResizable(false);
            tblOrdemServico.getColumnModel().getColumn(3).setPreferredWidth(30);
            tblOrdemServico.getColumnModel().getColumn(4).setPreferredWidth(30);
            tblOrdemServico.getColumnModel().getColumn(5).setResizable(false);
            tblOrdemServico.getColumnModel().getColumn(5).setPreferredWidth(30);
            tblOrdemServico.getColumnModel().getColumn(6).setResizable(false);
            tblOrdemServico.getColumnModel().getColumn(6).setPreferredWidth(30);
            tblOrdemServico.getColumnModel().getColumn(7).setPreferredWidth(30);
            tblOrdemServico.getColumnModel().getColumn(8).setResizable(false);
            tblOrdemServico.getColumnModel().getColumn(8).setPreferredWidth(30);
        }

        javax.swing.GroupLayout JpOSLayout = new javax.swing.GroupLayout(JpOS);
        JpOS.setLayout(JpOSLayout);
        JpOSLayout.setHorizontalGroup(
            JpOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpOSLayout.createSequentialGroup()
                .addComponent(txtPesquisar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblpesquisa)
                .addGap(73, 73, 73))
            .addGroup(JpOSLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1006, Short.MAX_VALUE))
        );
        JpOSLayout.setVerticalGroup(
            JpOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpOSLayout.createSequentialGroup()
                .addGroup(JpOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JpOSLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JpOSLayout.createSequentialGroup()
                        .addComponent(lblpesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                        .addGap(4, 4, 4)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                .addContainerGap())
        );

        lblequip.setText(" Equipamento*:");

        lbldef.setText(" Defeito*:");

        lblserv.setText("Serviço*:");

        lbltec.setText("Técnico*:");

        lblvt.setText("Valor Total*:");

        btnCreate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/servicera/icones/Create.png"))); // NOI18N
        btnCreate.setToolTipText("Adicionar");
        btnCreate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCreate.setPreferredSize(new java.awt.Dimension(140, 80));
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/servicera/icones/Delete.png"))); // NOI18N
        btnDelete.setToolTipText("Deletar");
        btnDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDelete.setPreferredSize(new java.awt.Dimension(140, 80));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/servicera/icones/Update.png"))); // NOI18N
        btnUpdate.setToolTipText("Atualizar");
        btnUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdate.setPreferredSize(new java.awt.Dimension(140, 80));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/servicera/icones/Limpar.png"))); // NOI18N
        btnLimpar.setToolTipText("Limpar Campos");
        btnLimpar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimpar.setPreferredSize(new java.awt.Dimension(100, 100));
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        cmbTecnico.setToolTipText("");

        lblCliente.setText("Cliente*: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblequip)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEquipamento))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbldef)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDefeito)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblserv)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtServico, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbltec)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbTecnico, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(217, 217, 217)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(lblCliente)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmbCliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblsit)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmbSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(201, 201, 201)
                                .addComponent(lblvt)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JpOS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(JpOS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblserv)
                    .addComponent(txtServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblequip)
                    .addComponent(txtEquipamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbltec)
                    .addComponent(cmbTecnico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbldef)
                    .addComponent(txtDefeito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnCreate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLimpar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblvt)
                            .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCliente)
                            .addComponent(cmbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblsit)
                            .addComponent(cmbSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        setBounds(0, 0, 1050, 600);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        adiciona();
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        excluir();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        alterar();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limpar();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void txtPesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisarKeyReleased
        pesquisarOrdemServico();
    }//GEN-LAST:event_txtPesquisarKeyReleased

    private void tblOrdemServicoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblOrdemServicoMouseClicked
        setarCampos();
    }//GEN-LAST:event_tblOrdemServicoMouseClicked

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened

    }//GEN-LAST:event_formInternalFrameOpened


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JpOS;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cmbCliente;
    private javax.swing.JComboBox<String> cmbSituacao;
    private javax.swing.JComboBox<String> cmbTecnico;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lbldef;
    private javax.swing.JLabel lblequip;
    private javax.swing.JLabel lblpesquisa;
    private javax.swing.JLabel lblserv;
    private javax.swing.JLabel lblsit;
    private javax.swing.JLabel lbltec;
    private javax.swing.JLabel lblvt;
    private javax.swing.JTable tblOrdemServico;
    private javax.swing.JTextField txtDefeito;
    private javax.swing.JTextField txtEquipamento;
    private javax.swing.JTextField txtPesquisar;
    private javax.swing.JTextField txtServico;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
