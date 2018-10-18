package br.com.servicera.model;

import java.sql.*;

public class ModuloConexao {
// metodo responsavel por estabelecer a conexão com BD
//toda variavel que não é citada como "void", é obrigatório ter um retorno.
    public static Connection conector() {
        java.sql.Connection conexao = null; // estou atribuindo uma variavel de conexão com o retorno nulo
        //conexao = nulo, por enquanto não está sendo atribuida nenhum banco a ele.        
        // a linha abaixo "chama" o driver que se encontra em "import java.sql.*;"
        // está sendo atribuida a variavel driver o caminho "com.mysql.cj.jdbc.Driver"
        String driver = "com.mysql.cj.jdbc.Driver";
        // Armazenando inforamções referente ao Banco
        String url = "jdbc:mysql://localhost:3306/servicera?useTimezone=true&serverTimezone=UTC"; 
        // localhost é para um banco de dados local, 3306 é a porta do banco de dados local, dbinfox é o nome do banco que iremos utilizar;
        String user = "root"; // usuario do banco
        String password = ""; // senha do banco
        
        // Estabelecendo a conexão com BD
        try { // na tentativa de conexão de estabelecer uma conexão caso dê certo \/
            Class.forName(driver);// esta linha executa o arquivo do driver
            conexao = DriverManager.getConnection(url, user, password); //variavel criada acima para obter a conexão com "url,user,password"
            return conexao; //deve ser utilizado por conta que é um metodo estático e ele necessita do retorno.
        } catch (Exception e) { // caso não de certo ele irá retornar nulo
            // a linha abaixo serve de apoio para saber o erro.
            //System.out.println(e);    
            return null;
        }
        

    }
    
}
