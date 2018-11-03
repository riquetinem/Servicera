package br.com.servicera.model;
    /**
     * Construtores sendo criados
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
     * Construtores duplicados
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
     * Recebendo o Construtor ID
     * @author Servicera
     * @return 
     */
    public String getId() {
        return id;
    }
    /**
     * Configurando a recepção do ID
     * @author Servicera
     * @param id 
     */
    public void setId(String id) {
        this.id = id;
    }
    /**
     * Recebendo o Construtor Nome
     * @author Servicera
     * @return 
     */
    public String getNome() {
        return nome;
    }
    /**
     * Configurando a recepção do Nome
     * @author Servicera
     * @param nome 
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    /**
     * Recebendo o Construtor Telefone
     * @author Servicera
     * @return 
     */
    public String getTelefone() {
        return telefone;
    }
    /**
     * Configurando a recepção do Telefone
     * @author Servicera
     * @param telefone 
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    /**
     * Recebendo o Construtor Login
     * @author Servicera
     * @return 
     */
    public String getLogin() {
        return login;
    }
    /**
     * Configurando a recepção do Login
     * @author Servicera
     * @param login 
     */
    public void setLogin(String login) {
        this.login = login;
    }
    /**
     * Recebendo o Construtor Senha
     * @author Servicera
     * @return 
     */
    public String getSenha() {
        return senha;
    }
    /**
     * Configurando a recepção da Senha
     * @author Servicera
     * @param senha 
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }
    /**
     * Recebendo o Construtor perfil adm/técnico
     * @author Servicera
     * @return 
     */
    public String getPerfil() {
        return perfil;
    }
    /**
     * Construtor criado para configurar a utilização do perfil admin/técnico
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
