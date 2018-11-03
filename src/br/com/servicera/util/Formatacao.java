package br.com.servicera.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

public class Formatacao {
    public Formatacao(){
        
    }
    /**
     * Metodo que utiliza uma mascara de formatação padrão para celulares de Usuario, Clientes e afins
     * @author Servicera
     * @return 
     */
    public static DefaultFormatterFactory fone() {
        MaskFormatter mask = null;
        try {
            mask = new MaskFormatter("(##) 9####-####");
            mask.setPlaceholderCharacter('_');
        } catch (ParseException ex) {
        }
        return (new DefaultFormatterFactory(mask, mask));

    }

}
