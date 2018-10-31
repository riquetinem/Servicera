package br.com.servicera.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

public class Formatacao {
    public Formatacao(){
        
    }
    
    public static DefaultFormatterFactory fone() {
        MaskFormatter mask = null;
        try {
            mask = new MaskFormatter("(##) 9####-####");
            mask.setPlaceholderCharacter('_');
        } catch (ParseException ex) {
        }
        return (new DefaultFormatterFactory(mask, mask));

    }
    
    public String valData(String data){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        try {
            sdf.setLenient(false);
            return sdf.format(sdf.format(sdf.parse(data)));
        } catch (Exception e) {
            return "Erro na data!";            
        }
    }
}
