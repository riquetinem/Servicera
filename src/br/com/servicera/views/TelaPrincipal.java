package br.com.servicera.views;

import br.com.servicera.dao.ConnectionFactory;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.sql.*;

public class TelaPrincipal extends javax.swing.JFrame {
    
    Connection conexao = null;

    public TelaPrincipal() {  
        initComponents();   
        Icone();
        conexao = ConnectionFactory.getConnection();
    }
    /**
     * Metodo para inserção de um Icone na tela principal do projeto
     * @author Servicera
     */
    private void Icone(){
        URL caminhoicone = getClass().getResource("/br/com/servicera/icones/S.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(caminhoicone);
        this.setIconImage(iconeTitulo);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Desktop = new javax.swing.JDesktopPane();
        Menu = new javax.swing.JMenuBar();
        menuPessoas = new javax.swing.JMenu();
        menuClientes = new javax.swing.JMenuItem();
        menuUsuarios = new javax.swing.JMenuItem();
        menuOrdemServicos = new javax.swing.JMenu();
        menSair = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Servicera - Controle de Ordem de Serviço");
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        Desktop.setBackground(new java.awt.Color(69, 69, 69));
        Desktop.setBorder(new javax.swing.border.MatteBorder(null));
        Desktop.setForeground(new java.awt.Color(255, 255, 153));
        Desktop.setPreferredSize(new java.awt.Dimension(1050, 600));

        javax.swing.GroupLayout DesktopLayout = new javax.swing.GroupLayout(Desktop);
        Desktop.setLayout(DesktopLayout);
        DesktopLayout.setHorizontalGroup(
            DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1048, Short.MAX_VALUE)
        );
        DesktopLayout.setVerticalGroup(
            DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 598, Short.MAX_VALUE)
        );

        menuPessoas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/servicera/icones/pessoas.png"))); // NOI18N
        menuPessoas.setText("Pessoas");

        menuClientes.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        menuClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/servicera/icones/Cliente.png"))); // NOI18N
        menuClientes.setText("Clientes");
        menuClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuClientesActionPerformed(evt);
            }
        });
        menuPessoas.add(menuClientes);

        menuUsuarios.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        menuUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/servicera/icones/usuarios.png"))); // NOI18N
        menuUsuarios.setText("Usuarios");
        menuUsuarios.setEnabled(false);
        menuUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuUsuariosActionPerformed(evt);
            }
        });
        menuPessoas.add(menuUsuarios);

        Menu.add(menuPessoas);

        menuOrdemServicos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/servicera/icones/os.png"))); // NOI18N
        menuOrdemServicos.setText("Ordem de Serviço");
        menuOrdemServicos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuOrdemServicosMouseClicked(evt);
            }
        });
        Menu.add(menuOrdemServicos);

        menSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/servicera/icones/Sair.png"))); // NOI18N
        menSair.setText("Sair");
        menSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menSairMouseClicked(evt);
            }
        });
        Menu.add(menSair);

        setJMenuBar(Menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Desktop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Desktop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(1062, 651));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated

    }//GEN-LAST:event_formWindowActivated

    private void menSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menSairMouseClicked
        System.exit(0);
    }//GEN-LAST:event_menSairMouseClicked

    private void menuOrdemServicosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuOrdemServicosMouseClicked
        TelaOrdemServico os=new TelaOrdemServico();
        os.setVisible(true);
        Desktop.add(os);
    }//GEN-LAST:event_menuOrdemServicosMouseClicked

    private void menuUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuUsuariosActionPerformed
        TelaUsuario usuario = new TelaUsuario(); 
        usuario.setVisible(true); 
        Desktop.add(usuario); 
    }//GEN-LAST:event_menuUsuariosActionPerformed

    private void menuClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuClientesActionPerformed
        TelaCliente Cliente = new TelaCliente();
        Cliente.setVisible(true);
        Desktop.add(Cliente);
    }//GEN-LAST:event_menuClientesActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane Desktop;
    private javax.swing.JMenuBar Menu;
    private javax.swing.JMenu menSair;
    private javax.swing.JMenuItem menuClientes;
    public static javax.swing.JMenu menuOrdemServicos;
    private javax.swing.JMenu menuPessoas;
    public static javax.swing.JMenuItem menuUsuarios;
    // End of variables declaration//GEN-END:variables
}
