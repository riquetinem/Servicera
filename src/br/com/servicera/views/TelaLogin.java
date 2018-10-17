package br.com.servicera.views;

import java.sql.*;
import br.com.servicera.model.ModuloConexao;
import br.com.servicera.util.Criptografia;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class TelaLogin extends javax.swing.JFrame {

    Connection conexao = null; // cria uma framework de conexão com o banco de dados, que se encontra dentro da "java.sql.*"
    PreparedStatement pst = null; //mais um conjunto de bliblioteca para manipular as instruções SQL, para poder utilizar códigos SQL dentro do JAVA 
    ResultSet rs = null; //Exibir o resultado das instruções sql utlizadas no Java
    //os 3 frameworks acima estão todos dentro da "import java.sql.*;"

    public void logar() {
        String sql = "select * from tbusuarios where login = ? and senha = ?";
        try {
            // as linhas abaixo preparam a consulta para o banco em função do
            // que foi digitado nas caixas de texto 
            // o "?" é substituido pelo conteudo das variaveis
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtusuario.getText());

            // criptografa senha para md5 e compara com o banco, que já esta em md5
            Criptografia c = new Criptografia();
            txtsenha.setText(c.criptografaSenha(txtsenha.getText()));
            pst.setString(2, txtsenha.getText());

            System.out.println(txtsenha.getText());

            // a linha abaixo executa a query
            rs = pst.executeQuery();
            if (rs.next()) {
                // a linha abaixo obtem o conteúdo do campo perfil da tbusuarios
                //criamos abaixo uma variavel do tipo String e iremos atribuir o conteudo do campo da tbusuarios
                String perfil = rs.getString(6);
                //mostra abaixo a variavel se está executando tudo corretamente. (Utilizada para apoio)
                //System.out.println(perfil); 
                // a estrututa abaixo faz o tratamento do perfil do usuario (admin ou user)
                if (perfil.equals("admin")) {
                    // ele irá abrir a tela principal conforme existir usuario e senha correspondentes
                    TelaPrincipal principal = new TelaPrincipal(); //criada uma variavel para puxar a tela principal
                    principal.setVisible(true); //tornando-a visivel para o usuario
                    TelaPrincipal.MenRel.setEnabled(true); //MenRel foi trocado para publico para poder ser utilizado, pois quando são criados eles vem preSetados como Private.
                    TelaPrincipal.MenCadUsu.setEnabled(true); //MenCadUsu foi trocado para publico para poder ser utilizado, pois quando são criados eles vem preSetados como Private.
                    TelaPrincipal.lblUsuario.setText(rs.getString(2)); //LblUsuario foi trocado para publico e ser utilizado, pois quando são criados eles vem preSetados como Private
                    TelaPrincipal.lblUsuario.setForeground(Color.red); //Caso for administrador ele será presetado como vermelho a letra do Usuario.
                    this.dispose(); //com este comando você fecha a tela que estava aberta anteriormente 
                    conexao.close(); // aqui fechamos a conexão com o banco de dados, por motivos de segurança.
                } else {
                    TelaPrincipal principal = new TelaPrincipal(); //criada uma variavel para puxar a tela principal
                    principal.setVisible(true); //tornando-a visivel para o usuario
                    this.dispose(); //com este comando você fecha a tela que estava aberta anteriormente
                    TelaPrincipal.lblUsuario.setText(rs.getString(2));
                    conexao.close(); // aqui fechamos a conexão com o banco de dados, por motivos de segurança.
                }
            } else { //caso não existir usuario ou senha dentro do banco de dados
                JOptionPane.showMessageDialog(null, "Usuario e/ou senha inválido(s)"); //ele me retorna esta mensagem para o usuario
            }
        } catch (Exception e) { //caso o banco de dados não estiver aberto, ou algum erro dentro do BD ele me mostra o erro
            JOptionPane.showMessageDialog(null, "Banco de dados não conectado, verifique sua internet ou seu localhost.", "ATENÇÃO!!!!!", JOptionPane.CLOSED_OPTION);
        }

    }

    public TelaLogin() {
        initComponents();
        conexao = ModuloConexao.conector();
        // a linha abaixo serve de apoio para saber o status da conexão.
        //System.out.println(conexao); (Utilizada para apoio para saber se a conexão com o banco está fechada ou aberta.
        if (conexao != null) {
            lblstatus.setText("Conectado");
        } else {
            lblstatus.setText("Desconectado");
        }
        
        getRootPane().setDefaultButton(btnLogin);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label1 = new java.awt.Label();
        label2 = new java.awt.Label();
        txtusuario = new javax.swing.JTextField();
        txtsenha = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        lblstatus = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Servicera - Login");
        setResizable(false);

        label1.setText("Login");

        label2.setText("Senha");

        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        lblstatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br.com.infox.icones/db.png"))); // NOI18N
        lblstatus.setText("Status");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblstatus))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLogin)
                            .addComponent(txtsenha, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtusuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtsenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLogin)
                    .addComponent(lblstatus))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        label1.getAccessibleContext().setAccessibleName("lbllogin");
        label2.getAccessibleContext().setAccessibleName("lblsenha");

        setSize(new java.awt.Dimension(372, 215));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // chamando o metodo logar       
        logar();
    }//GEN-LAST:event_btnLoginActionPerformed

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
            java.util.logging.Logger.getLogger(TelaLogin.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private javax.swing.JLabel lblstatus;
    private javax.swing.JPasswordField txtsenha;
    private javax.swing.JTextField txtusuario;
    // End of variables declaration//GEN-END:variables
}
