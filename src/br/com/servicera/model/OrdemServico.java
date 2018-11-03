package br.com.servicera.model;
    /**
    * Construtores sendo criados
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
    * Construtores duplicados
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
     * Recebendo o Construtor Data
     * @author Servicera
     * @return 
     */
    public String getData() {
        return data;
    }
    /**
     * Configurando a recepção do Data
     * @author Servicera
     * @param data 
     */
    public void setData(String data) {
        this.data = data;
    }
    /**
     * Recebendo o Construtor Situação
     * @author Servicera
     * @return 
     */
    public String getSituacao() {
        return situacao;
    }
    /**
     * Configurando a recepção do Situação
     * @author Servicera
     * @param situacao 
     */
    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
    /**
     * Recebendo o Construtor Equipamento
     * @author Servicera
     * @return 
     */
    public String getEquipamento() {
        return equipamento;
    }
    /**
     * Configurando a recepção do Equipamento
     * @author Servicera
     * @param equipamento 
     */
    public void setEquipamento(String equipamento) {
        this.equipamento = equipamento;
    }
    /**
     * Recebendo o Construtor Defeito
     * @author Servicera
     * @return 
     */
    public String getDefeito() {
        return defeito;
    }
    /**
     * Configurando a recepção do Defeito
     * @author Servicera
     * @param defeito 
     */
    public void setDefeito(String defeito) {
        this.defeito = defeito;
    }
    /**
     * Recebendo o Construtor Serviço
     * @author Servicera
     * @return 
     */
    public String getServico() {
        return servico;
    }
    /**
     * Configurando a recepção do Serviço
     * @author Servicera
     * @param servico 
     */
    public void setServico(String servico) {
        this.servico = servico;
    }
    /**
     * Recebendo o Construtor Técnico
     * @author Servicera
     * @return 
     */
    public String getTecnico() {
        return tecnico;
    }
    /**
     * Configurando a recepção do Técnico
     * @author Servicera
     * @param tecnico 
     */
    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }
    /**
     * Recebendo o Construtor Valor
     * @author Servicera
     * @return 
     */
    public String getValor() {
        return valor;
    }
    /**
     * Configurando a recepção do valor
     * @author Servicera
     * @param valor 
     */
    public void setValor(String valor) {
        this.valor = valor;
    }
    /**
     * Recebendo o Construtor Cliente
     * @author Servicera
     * @return 
     */
    public String getCliente() {
        return cliente;
    }
    /**
     * Configurando a recepção do Cliente
     * @author Servicera
     * @param cliente 
     */
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

}
