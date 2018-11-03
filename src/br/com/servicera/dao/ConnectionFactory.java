package br.com.servicera.dao;

import java.sql.*;

/**
 * Classe publica que contem a String de conexão com o Banco de Dados Mysql
 * @author Servicera
 */

public class ConnectionFactory {
    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/servicera?useTimezone=true&serverTimezone=UTC"; 
    private static final String USER = "root"; 
    private static final String PASSWORD = ""; 
    public static Connection getConnection() {
        java.sql.Connection conexao = null;
        
        try { 
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, USER, PASSWORD);
            return conexao;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao conectar com o banco de dados!");
        }
        
    }
}
