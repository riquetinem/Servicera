package br.com.servicera.model;
    /**
     * Responsavel por guardar dados dos usuarios
     * @author Servicera
     */
public class Usuarios {

    private String id;
    private String nome;
    private String telefone;
    private String login;
    private String senha;
    private String perfil;
    /**
     * Construtores sendo chamados com parametros
     * @author Servicera
     * @param id
     * @param nome
     * @param telefone
     * @param login
     * @param senha
     * @param perfil 
     */
    public Usuarios(String id, String nome, String telefone, String login, String senha, String perfil) {
        setId(id);
        setNome(nome);
        setTelefone(telefone);
        setLogin(login);
        setSenha(senha);
        setPerfil(perfil);
    }
    /**
     * Sobrecarga de Construtores 
     * @author Servicera
     * @param nome
     * @param telefone
     * @param login
     * @param senha
     * @param perfil 
     */
    public Usuarios(String nome, String telefone, String login, String senha, String perfil) {
        setNome(nome);
        setTelefone(telefone);
        setLogin(login);
        setSenha(senha);
        setPerfil(perfil);
    }
    /**
     * Construtor criado com parametros de login e senha
     * @author Servicera
     * @param login
     * @param senha 
     */
    public Usuarios(String login, String senha){
        setLogin(login);
        setSenha(senha);
    }
    /**
     * Retornando o Id do Usuario
     * @author Servicera
     * @return 
     */
    public String getId() {
        return id;
    }
    /**
     * Incrementando o ID do Usuario
     * @author Servicera
     * @param id 
     */
    public void setId(String id) {
        this.id = id;
    }
    /**
     * Retornando o nome do usuario
     * @author Servicera
     * @return 
     */
    public String getNome() {
        return nome;
    }
    /**
     * Incrementando o nome do usuario
     * @author Servicera
     * @param nome 
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    /**
     * Retornando o Telefone do usuario
     * @author Servicera
     * @return 
     */
    public String getTelefone() {
        return telefone;
    }
    /**
     * Incrementando o Telefone do usuario
     * @author Servicera
     * @param telefone 
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    /**
     * Retornando o Login
     * @author Servicera
     * @return 
     */
    public String getLogin() {
        return login;
    }
    /**
     * Incrementando o Login
     * @author Servicera
     * @param login 
     */
    public void setLogin(String login) {
        this.login = login;
    }
    /**
     * Retornando a Senha
     * @author Servicera
     * @return 
     */
    public String getSenha() {
        return senha;
    }
    /**
     * Incrementando a senha
     * @author Servicera
     * @param senha 
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }
    /**
     * retornando o perfil do usuario admin/técnico
     * @author Servicera
     * @return 
     */
    public String getPerfil() {
        return perfil;
    }
    /**
     * Incrementando o perfil do usuario admin/técnico
     * @author Servicera
     * @param perfil 
     */
    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
    /**
     * Metodo criado para confirmar a senha dos usuarios
     * @author Servicera
     * @param confSenha
     * @return 
     */
    public boolean verificaSenha(String confSenha) {

        if (this.getSenha().equals(confSenha)) {

            return true;
        } else {

            return false;
        }
    }
}
