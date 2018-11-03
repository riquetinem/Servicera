package br.com.servicera.model;
    /**
    * Responsavel por guardar dados da Ordem de Serviço
    * @author Servicera
    */
public class OrdemServico {

    private String id;
    private String data;
    private String situacao;
    private String equipamento;
    private String defeito;
    private String servico;
    private String tecnico;
    private String valor;
    private String cliente;
    /**
     * Construtores sendo chamados com parametros
    * @param id
    * @param situacao
    * @param equipamento
    * @param defeito
    * @param servico
    * @param tecnico
    * @param valor
    * @param cliente 
    */
    public OrdemServico(String id, String situacao, String equipamento, String defeito, String servico, String tecnico, String valor, String cliente) {
        this.id = id;
        this.data = data;
        this.situacao = situacao;
        this.equipamento = equipamento;
        this.defeito = defeito;
        this.servico = servico;
        this.tecnico = tecnico;
        this.valor = valor;
        this.cliente = cliente;
    }
    /**
    * Sobrecarga de Construtores
    * @author Servicera
    * @param situacao
    * @param equipamento
    * @param defeito
    * @param servico
    * @param tecnico
     * @param valor
    * @param cliente 
    */
    public OrdemServico(String situacao, String equipamento, String defeito, String servico, String tecnico, String valor, String cliente) {
        this.situacao = situacao;
        this.equipamento = equipamento;
        this.defeito = defeito;
        this.servico = servico;
        this.tecnico = tecnico;
        this.valor = valor;
        this.cliente = cliente;
    }
    /**
     * Retornando o valor Id da Ordem de Serviço
     * @author Servicera
     * @return 
     */
    public String getId() {
        return id;
    }
    /**
     * Incrementando o valor do ID
     * @author Servicera
     * @param id 
     */
    public void setId(String id) {
        this.id = id;
    }
    /**
     * Retornando a Data
     * @author Servicera
     * @return 
     */
    public String getData() {
        return data;
    }
    /**
     *Incrementando a Data
     * @author Servicera
     * @param data 
     */
    public void setData(String data) {
        this.data = data;
    }
    /**
     * Retornando a Situação
     * @author Servicera
     * @return 
     */
    public String getSituacao() {
        return situacao;
    }
    /**
     * Incrementando a Situação
     * @author Servicera
     * @param situacao 
     */
    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
    /**
     * Retornando o Equipamento
     * @author Servicera
     * @return 
     */
    public String getEquipamento() {
        return equipamento;
    }
    /**
     * Incrementando o Equipamento
     * @author Servicera
     * @param equipamento 
     */
    public void setEquipamento(String equipamento) {
        this.equipamento = equipamento;
    }
    /**
     * Retornando o Defeito do Equipamento
     * @author Servicera
     * @return 
     */
    public String getDefeito() {
        return defeito;
    }
    /**
     * Incrementando o Defeito do Equipamento
     * @author Servicera
     * @param defeito 
     */
    public void setDefeito(String defeito) {
        this.defeito = defeito;
    }
    /**
     * Retornando o Serviço
     * @author Servicera
     * @return 
     */
    public String getServico() {
        return servico;
    }
    /**
     * Incrementando o Serviço
     * @author Servicera
     * @param servico 
     */
    public void setServico(String servico) {
        this.servico = servico;
    }
    /**
     * Retornando o Técnico
     * @author Servicera
     * @return 
     */
    public String getTecnico() {
        return tecnico;
    }
    /**
     * Incrementando o Técnico
     * @author Servicera
     * @param tecnico 
     */
    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }
    /**
     * Retornando o Valor do Equipamento
     * @author Servicera
     * @return 
     */
    public String getValor() {
        return valor;
    }
    /**
     * Incrementando o Valor do Equipamento
     * @author Servicera
     * @param valor 
     */
    public void setValor(String valor) {
        this.valor = valor;
    }
    /**
     * Retornando o Cliente
     * @author Servicera
     * @return 
     */
    public String getCliente() {
        return cliente;
    }
    /**
     * Incrementando o Cliente
     * @author Servicera
     * @param cliente 
     */
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

}
