package br.com.servicera.model;

public class Usuarios {

    private String id;
    private String nome;
    private String telefone;
    private String login;
    private String senha;
    private String perfil;

    public Usuarios(String id, String nome, String telefone, String login, String senha, String perfil) {
        setId(id);
        setNome(nome);
        setTelefone(telefone);
        setLogin(login);
        setSenha(senha);
        setPerfil(perfil);
    }

    public Usuarios(String nome, String telefone, String login, String senha, String perfil) {
        setNome(nome);
        setTelefone(telefone);
        setLogin(login);
        setSenha(senha);
        setPerfil(perfil);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public boolean verificaSenha(String senhaConfirm) {
        if (this.senha.equals(senhaConfirm)) {
            return true;
        } else {
            return false;
        }
    }

}
