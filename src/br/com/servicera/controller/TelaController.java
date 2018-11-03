package br.com.servicera.controller;

import br.com.servicera.views.TelaLogin;

public class TelaController {
    
    /**
     * Mostra qual tela deverá ser a primeira a ser iniciada no programa
     * @author Servicera
     * @param args
     */
    
    public static void main(String[] args) {
        TelaLogin tela = new TelaLogin();
        tela.setVisible(true);
    }
}
