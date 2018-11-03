package br.com.servicera.dao;

import br.com.servicera.model.Usuarios;
import br.com.servicera.util.Criptografia;
import br.com.servicera.views.TelaPrincipal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

    /**
     * Classe publica que faz a conexão com Usuarios com Banco de Dados
     * @author Servicera
     */
public class UsuariosDao {
    
    /**
     * Metodo que realiza o Login testando Usuario e senha
     * @author Sericera
     * @param user
     * @param senha
     * @return
     * @throws SQLException
     * @throws Exception 
     */

    public boolean realizaLogin(String user, String senha) throws SQLException, Exception {
        String sql = "SELECT * FROM usuarios WHERE login = ? AND senha = ?";
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;

        pst = conexao.prepareStatement(sql);
        pst.setString(1, user);

        Criptografia c = new Criptografia();
        try {
            senha = c.criptografaSenha(senha);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

        pst.setString(2, senha);

        rs = pst.executeQuery();

        if (rs.next()) {
            String perfil = rs.getString(6);
            if (perfil.equals("admin")) {
                TelaPrincipal principal = new TelaPrincipal();
                principal.setVisible(true);
                TelaPrincipal.menuUsuarios.setEnabled(true);
            } else {
                TelaPrincipal principal = new TelaPrincipal();
                principal.setVisible(true);
            }

            conexao.close();
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Usuario e/ou senha inválido(s)");
            conexao.close();
            return false;
        }

    }
    
    /**
     * Metodo que seleciona os perfis dos usuarios
     * @author Servicera
     * @param cmbPerfil 
     */

    public void populaComboBox(JComboBox cmbPerfil) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM perfil";
        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                cmbPerfil.addItem(rs.getString(2));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    /**
     * Metodo que adiciona o usuario no banco de dados, conferindo para ver se as senhas inseridas batem 
     * @author Servicera
     * @param usuario
     * @param confSenha
     * @return
     * @throws SQLException
     * @throws Exception 
     */

    public boolean adicionarUsuario(Usuarios usuario, String confSenha) throws SQLException, Exception {
        boolean correto = usuario.verificaSenha(confSenha);

        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;

        if (correto) {
            String sql = "INSERT INTO usuarios (nome, fone, login, senha, perfil) values (?, ?, ?, ?, ?)";
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, usuario.getNome());
                pst.setString(2, usuario.getTelefone());
                pst.setString(3, usuario.getLogin());

                Criptografia c = new Criptografia();
                usuario.setSenha(c.criptografaSenha(usuario.getSenha()));

                pst.setString(4, usuario.getSenha());
                pst.setString(5, usuario.getPerfil());
                if ((((usuario.getNome().isEmpty())) || (usuario.getLogin().isEmpty())) || (usuario.getSenha().isEmpty())) {
                    JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");
                    return false;
                } else {
                    int adicionado = pst.executeUpdate();

                    if (adicionado > 0) {
                        JOptionPane.showMessageDialog(null, "Usuário adicionado com sucesso.");

                        return true;
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuário não foi adicionado.");

                        return false;
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Senhas diferentes!");
            return false;
        }

    }

    /**
     * Metodo que permite pesquisar na TelaUsuarios com parametro do nome do usuario
     * @author Servicera
     * @param nome
     * @param tblUsuarios
     * @throws SQLException
     * @throws Exception 
     */
    public void pesquisarUsuario(String nome, JTable tblUsuarios) throws SQLException, Exception {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;

        String sql = "SELECT id AS ID,nome AS NOME,fone AS TELEFONE,login AS LOGIN, perfil as PERFIL FROM usuarios WHERE nome like ?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, nome + "%");
            rs = pst.executeQuery();

            tblUsuarios.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    /**
     * Metodo que permite alterar o Usuario com parametro de Confirmação de senha
     * @author Servicera
     * @param usuario
     * @param confSenha
     * @return 
     */
    public boolean alteraUsuario(Usuarios usuario, String confSenha) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;

        int confirma = JOptionPane.showConfirmDialog(null, "Você tem certeza que deseja atualizar este usuário ?", "Atenção!", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            boolean correto;

            if (usuario.getSenha().isEmpty() && confSenha.equals("")) {
                correto = true;
            } else {
                correto = usuario.verificaSenha(confSenha);
            }

            if (correto) {
                String sql = "UPDATE usuarios SET nome = ?,fone = ?, login = ?, senha = ?, perfil = ? WHERE id = ?";
                try {
                    pst = conexao.prepareStatement(sql);
                    pst.setString(1, usuario.getNome());
                    pst.setString(2, usuario.getTelefone());
                    pst.setString(3, usuario.getLogin());

                    Criptografia c = new Criptografia();
                    usuario.setSenha(c.criptografaSenha(usuario.getSenha()));

                    pst.setString(4, usuario.getSenha());
                    pst.setString(5, usuario.getPerfil());
                    pst.setString(6, usuario.getId());

                    if ((((usuario.getNome().isEmpty())) || (usuario.getLogin().isEmpty())) || (usuario.getSenha().isEmpty())) {
                        JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");

                        return false;
                    } else {
                        int adicionado = pst.executeUpdate();

                        if (adicionado > 0) {
                            JOptionPane.showMessageDialog(null, "Usuário atualizado com sucesso.");

                            return true;
                        } else {
                            JOptionPane.showMessageDialog(null, "Usuário não foi alterado.");

                            return false;
                        }
                    }

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);

                    return false;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Senhas diferentes!");

                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * Metodo que remove o usuario do banco de dados, com parametro de ID para a remoção
     * @author Servicera
     * @param id
     * @return
     * @throws SQLException
     * @throws Exception 
     */
    public boolean removeUsuario(String id) throws SQLException, Exception {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;

        int confirma = JOptionPane.showConfirmDialog(null, "Você tem certeza que deseja remover esse usuario?", "Atenção!!", JOptionPane.YES_NO_OPTION);

        if (confirma == JOptionPane.YES_OPTION) {
            String sql = "DELETE FROM usuarios WHERE id = ?";
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, id);
                int apagou = pst.executeUpdate();
                if (apagou > 0) {
                    JOptionPane.showMessageDialog(null, "Usuário removido com sucesso!");
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "Ocorreu um erro ao remover o usuário!");

                    return false;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
                return false;
            }
        } else {
            return false;
        }
    }
}
