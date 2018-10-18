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

}
