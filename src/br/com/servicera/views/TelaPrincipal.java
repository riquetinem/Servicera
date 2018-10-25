package br.com.servicera.views;

import br.com.servicera.dao.ConnectionFactory;
import java.text.DateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import java.sql.*;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;


public class TelaPrincipal extends javax.swing.JFrame {
    
    Connection conexao = null;

    public TelaPrincipal() {
        initComponents();
        conexao = ConnectionFactory.getConnection();
    }

    private void rel_cli(){
        int confirma = JOptionPane.showConfirmDialog(null,"Confirma a emissão deste relatório?","ATENÇÃO!!",JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION){
            //imprimindo relatório com framework JasperReports
            try {
                //Usando a classe JasperPrint, para preparar a impressão de um relatório;
                JasperPrint print = JasperFillManager.fillReport("C:\\Users\\gabri\\Desktop\\Servicera\\Prjinfox\\reports\\Clientes.jasper",null,conexao);
                // a linha abaixo exibe o relatorio atraves da classe Jasper Viewer
                JasperViewer.viewReport(print,false);
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,e);
            }
        }
    } // metodo relatorio de clientes
    
    private void rel_OS(){
         int confirma = JOptionPane.showConfirmDialog(null,"Confirma a emissão deste relatório?","ATENÇÃO!!",JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION){
            //imprimindo relatório com framework JasperReports
            try {
                //Usando a classe JasperPrint, para preparar a impressão de um relatório;
                JasperPrint print = JasperFillManager.fillReport("C:\\Users\\gabri\\Desktop\\Servicera\\Prjinfox\\reports\\servicos.jasper",null,conexao);
                // a linha abaixo exibe o relatorio atraves da classe Jasper Viewer
                JasperViewer.viewReport(print,false);
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,e);
            }
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Desktop = new javax.swing.JDesktopPane();
        Menu = new javax.swing.JMenuBar();
        menCad = new javax.swing.JMenu();
        MenCadCli = new javax.swing.JMenuItem();
        MenCadUsu = new javax.swing.JMenuItem();
        menOS = new javax.swing.JMenu();
        MenRel = new javax.swing.JMenu();
        MenRelSer = new javax.swing.JMenuItem();
        menRelCli = new javax.swing.JMenuItem();
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

        menCad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/servicera/icones/pessoas.png"))); // NOI18N
        menCad.setText("Pessoas");

        MenCadCli.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        MenCadCli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/servicera/icones/Cliente.png"))); // NOI18N
        MenCadCli.setText("Clientes");
        MenCadCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenCadCliActionPerformed(evt);
            }
        });
        menCad.add(MenCadCli);

        MenCadUsu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        MenCadUsu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/servicera/icones/usuarios.png"))); // NOI18N
        MenCadUsu.setText("Usuarios");
        MenCadUsu.setEnabled(false);
        MenCadUsu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenCadUsuActionPerformed(evt);
            }
        });
        menCad.add(MenCadUsu);

        Menu.add(menCad);

        menOS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/servicera/icones/os.png"))); // NOI18N
        menOS.setText("Ordem de Serviço");
        menOS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menOSMouseClicked(evt);
            }
        });
        Menu.add(menOS);

        MenRel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/servicera/icones/relatório.png"))); // NOI18N
        MenRel.setText("Relatorio");
        MenRel.setEnabled(false);

        MenRelSer.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK));
        MenRelSer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/servicera/icones/Relatório OS.png"))); // NOI18N
        MenRelSer.setText("Relatorio de Serviços");
        MenRelSer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenRelSerActionPerformed(evt);
            }
        });
        MenRel.add(MenRelSer);

        menRelCli.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
        menRelCli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/servicera/icones/Relatório Cli.png"))); // NOI18N
        menRelCli.setText("Relatório de Clientes");
        menRelCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menRelCliActionPerformed(evt);
            }
        });
        MenRel.add(menRelCli);

        Menu.add(MenRel);

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
        // As linhas abaixo substituem a label data lbldata pela data atual do sistema ao inicializar o form
        //Date data = new Date();
        //DateFormat formatador = DateFormat.getDateInstance(DateFormat.MEDIUM);
        //lbldata.setText(formatador.format(data));

    }//GEN-LAST:event_formWindowActivated

    private void menRelCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menRelCliActionPerformed
        // gerando um relatorio de clientes
        rel_cli();    
        
    }//GEN-LAST:event_menRelCliActionPerformed

    private void MenRelSerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenRelSerActionPerformed
        // gerando um relatorio de Ordem de Serviço
        rel_OS();
    }//GEN-LAST:event_MenRelSerActionPerformed

    private void menSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menSairMouseClicked
        System.exit(0);
    }//GEN-LAST:event_menSairMouseClicked

    private void menOSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menOSMouseClicked
        TelaOrdemServico os=new TelaOrdemServico();
        os.setVisible(true);
        Desktop.add(os);
    }//GEN-LAST:event_menOSMouseClicked

    private void MenCadUsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenCadUsuActionPerformed
        // As linhas abaixo elas irão abrir o form TelaUsuario, dentro do Desktop Panel
        TelaUsuario usuario = new TelaUsuario(); //Criando uma instancia dessa classe para ser aberta
        usuario.setVisible(true); //Utilizando a instancia para tornar visivel.
        Desktop.add(usuario); //estamos adicionando a instancia para ser aberto em Desktop panel
    }//GEN-LAST:event_MenCadUsuActionPerformed

    private void MenCadCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenCadCliActionPerformed
        // chamando a tela cliente
        TelaCliente Cliente = new TelaCliente();
        Cliente.setVisible(true);
        Desktop.add(Cliente);
    }//GEN-LAST:event_MenCadCliActionPerformed

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
    private javax.swing.JMenuItem MenCadCli;
    public static javax.swing.JMenuItem MenCadUsu;
    public static javax.swing.JMenu MenRel;
    private javax.swing.JMenuItem MenRelSer;
    private javax.swing.JMenuBar Menu;
    private javax.swing.JMenu menCad;
    public static javax.swing.JMenu menOS;
    private javax.swing.JMenuItem menRelCli;
    private javax.swing.JMenu menSair;
    // End of variables declaration//GEN-END:variables
}
