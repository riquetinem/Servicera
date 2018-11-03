package br.com.servicera.util;

import java.math.BigInteger;
import java.security.MessageDigest;

public class Criptografia {

    public Criptografia() {

    }
    /**
     * Metodo que efetua a Criptografia MD5 na senha de Login
     * @author Servicera
     * @param senha
     * @throws Exception 
     */
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
