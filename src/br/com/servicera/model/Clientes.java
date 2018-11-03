package br.com.servicera.model;
    /**
    * Construtores sendo criados
    * @author Servicera
    */
public class Clientes {
    private String id;
    private String nome;
    private String endereco;
    private String telefone;
    private String email;
    
    /**
     * Construtores sendo chamados com parametros
     * @author Servicera
     * @param id
     * @param nome
     * @param endereco
     * @param telefone
     * @param email 
     */
    public Clientes(String id, String nome, String endereco, String telefone, String email) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
    }

    /**
     * Construtores duplicados
     * @author Servicera
     * @param nome
     * @param endereco
     * @param telefone
     * @param email 
     */
    public Clientes(String nome, String endereco, String telefone, String email) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
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
     * Recebendo o Construtor Endereço
     * @author Servicera
     * @return 
     */
    public String getEndereco() {
        return endereco;
    }
    /**
     * Configurando a recepção do Endereço
     * @author Servicera
     * @param endereco 
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
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
     * Recebendo o Construtor Email
     * @author Servicera
     * @return 
     */
    public String getEmail() {
        return email;
    }
    /**
     * Configurando a recepção do Email
     * @author Servicera
     * @param email 
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
