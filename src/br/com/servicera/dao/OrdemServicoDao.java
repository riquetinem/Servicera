package br.com.servicera.dao;

import br.com.servicera.model.OrdemServico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

    /**
     * Classe que conecta a Ordem de Serviço com o Banco de Dados
     * @author Servicera
     */
public class OrdemServicoDao {
    
    /**
     * Metodo que seleciona quem está cadastrado como Técnico no Banco de Dados
     * @author Servicera
     * @param cmbTecnico 
     */

    public static void populaComboBoxTecnicos(JComboBox cmbTecnico) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM usuarios WHERE perfil = 'técnico'";
        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                cmbTecnico.addItem(rs.getString(2));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    /**
     * Metodo que seleciona qual Situação está cadastrada no Banco de Dados
     * @author Servicera
     * @param cmbSituacao 
     */
    public static void populaComboBoxSituacao(JComboBox cmbSituacao) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM situacao";
        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                cmbSituacao.addItem(rs.getString(2));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    /**
     * Metodo que seleciona qual cliente está cadastrado no Banco de Dados
     * @author Servicera
     * @param cmbCliente 
     */
    public static void populaComboBoxCliente(JComboBox cmbCliente) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM clientes";
        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                cmbCliente.addItem(rs.getString(2));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    /**
     * Metodo que adiciona a Ordem de serviço no Banco de dados assim que é efetuado o Insert.
     * @author Servicera
     * @param ordemServico
     * @return 
     */

    public boolean adicionarOrdemServico(OrdemServico ordemServico) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;

        String sql = "INSERT INTO ordem_servicos(situacao, equipamento, defeito, servico, tecnico, valor, cliente) values (?, ?, ?, ?, ?, ?, ?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, ordemServico.getSituacao());
            pst.setString(2, ordemServico.getEquipamento());
            pst.setString(3, ordemServico.getDefeito());
            pst.setString(4, ordemServico.getServico());
            pst.setString(5, ordemServico.getTecnico());
            pst.setString(6, ordemServico.getValor().replace(",", "."));
            pst.setString(7, ordemServico.getCliente());

            if (((ordemServico.getEquipamento().isEmpty())) || ((ordemServico.getDefeito().isEmpty()))) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos");

                return false;
            } else {
                int adicionado = pst.executeUpdate();
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Ordem de Serviço adicionada com sucesso");
                    return true;
                } else {
                    return false;
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

            return false;
        }
    }
    
    /**
     * Metodo que atualiza a Ordem de serviço no Banco de dados assim que é efetuado o Delete.
     * @author Servicera
     * @param ordemServico
     * @return 
     */
    public boolean alteraOrdemServico(OrdemServico ordemServico) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;

        String sql = "UPDATE ordem_servicos SET situacao = ?, "
                + "equipamento = ?, defeito = ?, servico = ?, "
                + "tecnico = ?,valor = ?, cliente = ? WHERE id = ?";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, ordemServico.getSituacao());
            pst.setString(2, ordemServico.getEquipamento());
            pst.setString(3, ordemServico.getDefeito());
            pst.setString(4, ordemServico.getServico());
            pst.setString(5, ordemServico.getTecnico());
            pst.setString(6, ordemServico.getValor().replace(",", "."));
            pst.setString(7, ordemServico.getCliente());
            pst.setString(8, ordemServico.getId());

            if (((ordemServico.getEquipamento().isEmpty())) || ((ordemServico.getDefeito().isEmpty()))) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos");

                return false;
            } else {
                int adicionado = pst.executeUpdate();
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Ordem de Serviço atualizada com sucesso");

                    return true;
                } else {
                    return false;
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

            return false;
        }

    }
    
    /**
     * Metodo que exclui a Ordem de serviço no Banco de dados assim que é efetuado o Delete.
     * @author Servicera
     * @param id
     * @return 
     */

    public boolean excluirOrdemServico(String id) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;

        int Confirma_os = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir essa Ordem de serviço?", "ATENÇÃO!!!", JOptionPane.YES_NO_OPTION);
        if (Confirma_os == JOptionPane.YES_OPTION) {
            String sql = "DELETE FROM ordem_servicos WHERE id = ?";
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, id);
                int apagado = pst.executeUpdate();
                if (apagado > 0) {
                    JOptionPane.showMessageDialog(null, "Ordem de Serviço excluida com sucesso!");

                    return true;

                } else {

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
    
    /**
     * Metodo que pesquisa a Ordem de Serviço com parametro do Equipamento
     * @author Servicera
     * @param equipamento
     * @param tblOrdemServico 
     */

    public void pesquisarOrdemServico(String equipamento, JTable tblOrdemServico) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;

        String sql = "SELECT id AS ID, cliente AS Cliente, data AS Emissão, situacao AS Situação,equipamento AS Equipamento, "
                + "defeito AS Defeitos, servico AS Serviço, tecnico AS Técnico, "
                + "valor AS Valor FROM ordem_servicos WHERE equipamento LIKE ?";
        
        
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, equipamento + "%");
            rs = pst.executeQuery();
            tblOrdemServico.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

}
