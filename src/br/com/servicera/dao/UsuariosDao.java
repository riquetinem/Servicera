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

public class UsuariosDao {

    public boolean realizaLogin(String user, String senha) throws SQLException, Exception {
        String sql = "select * from usuarios where login = ? and senha = ?";
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
                TelaPrincipal.MenRel.setEnabled(true);
                TelaPrincipal.MenCadUsu.setEnabled(true);
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

    public void populaComboBox(JComboBox cmbPerfil) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;

        String sql = "select * from perfil";
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

    public boolean adicionarUsuario(Usuarios usuario, String confSenha) throws SQLException, Exception {
        boolean correto = usuario.verificaSenha(confSenha);
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;

        if (correto) {
            String sql = "insert into usuarios (nome, fone, login, senha, perfil) values (?, ?, ?, ?, ?)";
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

    public void pesquisarUsuario(String nome, JTable tblUsuarios) throws SQLException, Exception {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;

        String sql = "select id as ID,nome as NOME,fone as TELEFONE,login as LOGIN, perfil as PERFIL from usuarios where nome like ?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, nome + "%");
            rs = pst.executeQuery();

            tblUsuarios.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public boolean alteraUsuario(Usuarios usuario, String confSenha) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;

        int confirma = JOptionPane.showConfirmDialog(null, "Você tem certeza que deseja atualizar este usuário ?", "Atenção!", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            boolean correto;

            if (!usuario.getSenha().isEmpty()) {
                correto = true;
            } else {
                correto = usuario.verificaSenha(confSenha);
            }

            if (correto) {
                String sql = "update usuarios set nome = ?,fone = ?, login = ?, senha = ?, perfil = ? where id = ?";
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
