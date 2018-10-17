/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.servicera.util;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 *
 * @author henri
 */
public class Criptografia {

    public Criptografia() {

    }

    public Criptografia(String senha) throws Exception {
        criptografaSenha(senha);
    }

    public String criptografaSenha(String senha) throws Exception {
        MessageDigest m = MessageDigest.getInstance("MD5");

        m.update(senha.getBytes(), 0, senha.length());

        String senhaCriptografada = new BigInteger(1, m.digest()).toString(16);

        return senhaCriptografada;
    }
}
