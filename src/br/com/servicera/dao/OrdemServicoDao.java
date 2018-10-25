package br.com.servicera.dao;

import br.com.servicera.model.OrdemServico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class OrdemServicoDao {

    public static void populaComboBoxTecnicos(JComboBox cmbTecnico) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;

        String sql = "select * from usuarios WHERE perfil = 'técnico'";
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

    public static void populaComboBoxSituacao(JComboBox cmbSituacao) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;

        String sql = "select * from situacao";
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

    public static void populaComboBoxCliente(JComboBox cmbCliente) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;

        String sql = "select * from clientes";
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

    public boolean adicionarOrdemServico(OrdemServico ordemServico) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;

        String sql = "insert into ordem_servicos(situacao,equipamento,defeito,servico,tecnico,valor,idcli) values (?,?,?,?,?,?,?)";
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

    public boolean alteraOrdemServico(OrdemServico ordemServico) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;

        String sql = "update ordem_servicos set situacao = ?, equipamento = ?, defeito = ?, servico = ?,tecnico = ?,valor = ? where id = ?";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, ordemServico.getSituacao());
            pst.setString(2, ordemServico.getEquipamento());
            pst.setString(3, ordemServico.getDefeito());
            pst.setString(4, ordemServico.getServico());
            pst.setString(5, ordemServico.getTecnico());
            pst.setString(6, ordemServico.getValor().replace(",", "."));
            pst.setString(7, ordemServico.getId());

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

    public boolean excluirOrdemServico(String id) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;

        int Confirma_os = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir essa Ordem de serviço?", "ATENÇÃO!!!", JOptionPane.YES_NO_OPTION);
        if (Confirma_os == JOptionPane.YES_OPTION) {
            String sql = "delete from ordem_servicos where id = ?";
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

    public void pesquisarOrdemServico(String equipamento, JTable tblOrdemServico) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;

        String sql = "Select id as ID,dataos as Emissão, situacao as Situação,equipamento as Equipamento,defeito as Defeitos,servico as Serviço,tecnico as Técnico,valor as Valor from ordem_servicos where equipamento like ?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, equipamento + "%");
            rs = pst.executeQuery();
            tblOrdemServico.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void imprimirOrdemServico(String id) {
        Connection conexao = ConnectionFactory.getConnection();
        
        int confirma = JOptionPane.showConfirmDialog(null, "Confirma a impressão desta Ordem de serviço ?", "ATENÇÃO!!", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            try {
                HashMap filtro = new HashMap();
                filtro.put("os", id);
                JasperPrint print = JasperFillManager.fillReport("C:\\Users\\gabri\\Desktop\\Servicera\\Prjinfox\\reports\\os.jasper", filtro, conexao); //podemos criar varios parametros e varios reports de vários tipos delcarando a variavel no lugar do null.
                JasperViewer.viewReport(print, false);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }
}
