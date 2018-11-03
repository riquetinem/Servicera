package br.com.servicera.model;
    /**
    * Responsavel por guardar dados dos clientes
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
     * Sobrecarga de Construtores 
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
     * Retornando o valor Id do Cliente
     * @author Servicera
     * @return 
     */
    public String getId() {
        return id;
    }
    /**
     * Incrementando o valor para o ID
     * @author Servicera
     * @param id 
     */
    public void setId(String id) {
        this.id = id;
    }
    
    /**
     * Retorna o nome do Cliente
     * @author Servicera
     * @return 
     */
    public String getNome() {
        return nome;
    }
    /**
     * Incrementando o nome do Cliente
     * @author Servicera
     * @param nome 
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    /**
     * Retornando o Endereço do Cliente
     * @author Servicera
     * @return 
     */
    public String getEndereco() {
        return endereco;
    }
    /**
     * Incrementando o endereço do Cliente
     * @author Servicera
     * @param endereco 
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    /**
     * Retornando o Telefone do Cliente
     * @author Servicera
     * @return 
     */
    public String getTelefone() {
        return telefone;
    }
    /**
     * Incrementando o Telefone do Cliente
     * @author Servicera
     * @param telefone 
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    /**
     * Retornando o Email do Cliente
     * @author Servicera
     * @return 
     */
    public String getEmail() {
        return email;
    }
    /**
     * Incrementando o Email do Cliente
     * @author Servicera
     * @param email 
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
