package br.com.servicera.dao;

import br.com.servicera.model.Clientes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

public class ClientesDao {

    public boolean adicionarCliente(Clientes cliente) throws SQLException {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;

        String sql = "insert into clientes (nome, endereco, fone, email) values (?,?,?,?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, cliente.getNome());
            pst.setString(2, cliente.getEndereco());
            pst.setString(3, cliente.getTelefone());
            pst.setString(4, cliente.getEmail());

            if ((((cliente.getNome().isEmpty()) || (cliente.getEndereco().isEmpty())) || (cliente.getTelefone().isEmpty())) || (cliente.getEmail().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");

                return false;
            } else {
                int adicionado = pst.executeUpdate();

                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Cliente adicionado com sucesso.");

                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "Cliente não foi adicionado.");

                    return false;
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

            return false;
        }

    }

    public boolean alterarCliente(Clientes cliente) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;

        int confirma = JOptionPane.showConfirmDialog(null, "Você tem certeza que deseja atualizar este cliente ?", "Atenção!!", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            String sql = "update clientes set nome = ?,endereco = ?, fone = ?,email = ? where id = ?";
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, cliente.getNome());
                pst.setString(2, cliente.getEndereco());
                pst.setString(3, cliente.getTelefone());
                pst.setString(4, cliente.getEmail());

                pst.setString(5, cliente.getId());

                if ((((cliente.getNome().isEmpty()) || (cliente.getEndereco().isEmpty())) || (cliente.getTelefone().isEmpty())) || (cliente.getEmail().isEmpty())) {
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
            return false;
        }
    }

    public boolean removeClientes(String id) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;

        int confirma = JOptionPane.showConfirmDialog(null, "Você tem certeza que deseja remover esse cliente ?", "Atenção!!", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            String sql = "delete from clientes where id =?";
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, id);
                int apagado = pst.executeUpdate();
                if (apagado > 0) {
                    JOptionPane.showMessageDialog(null, "Cliente removido com sucesso");

                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "Ocorreu um erro ao excluir o cliente!");

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

    public void pesquisarClientes(String nome, JTable tblClientes) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;

        String sql = "Select id as ID,nome as Nome,fone as Telefone,email as Email from clientes where nome like?";

        try {
            pst = conexao.prepareStatement(sql);

            pst.setString(1, nome + "%");
            rs = pst.executeQuery();

            tblClientes.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
