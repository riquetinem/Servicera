package br.com.servicera.controller;

import br.com.servicera.views.TelaLogin;

    /**
     * Mostra qual tela deverá ser a primeira a ser iniciada no programa
     * @author Servicera
     */
    
public class TelaController {
    public static void main(String[] args) {
        TelaLogin tela = new TelaLogin();
        tela.setVisible(true);
    }
}
