package br.com.servicera.model;

import br.com.servicera.util.Criptografia;
import br.com.servicera.views.TelaPrincipal;
import java.awt.Color;
import java.sql.*;
import javax.swing.JOptionPane;

public class Usuarios {

    private int id;
    private String user;
    private String senha;
    private int pessoa_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getPessoa_id() {
        return pessoa_id;
    }

    public void setPessoa_id(int pessoa_id) {
        this.pessoa_id = pessoa_id;
    }

    public boolean realizaLogin(String user, String senha, PreparedStatement pst, ResultSet rs, Connection conexao) throws Exception {
        String sql = "select * from tbusuarios where login = ? and senha = ?";

        pst = conexao.prepareStatement(sql);
        pst.setString(1, user);

        Criptografia c = new Criptografia();
        senha = c.criptografaSenha(senha);

        pst.setString(2, senha);

        rs = pst.executeQuery();
        if (rs.next()) {
            String perfil = rs.getString(6);

            if (perfil.equals("admin")) {
                TelaPrincipal principal = new TelaPrincipal(); 
                principal.setVisible(true); 
                TelaPrincipal.MenRel.setEnabled(true); 
                TelaPrincipal.MenCadUsu.setEnabled(true); 
                TelaPrincipal.lblUsuario.setText(rs.getString(2)); 
                TelaPrincipal.lblUsuario.setForeground(Color.blue); 
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
}
