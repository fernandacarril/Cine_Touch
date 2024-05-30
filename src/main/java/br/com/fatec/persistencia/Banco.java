/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.persistencia;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Aluno
 */
public class Banco {
    //criar atributos
    public static String bancoDados, usuario, senha, servidor;
    public static int porta;

    //variavel de conexao
    public static java.sql.Connection conexao = null;
    
    //define valores padrão
    static {
        bancoDados = "Cinema";
        usuario = "root";
        senha = "";
        servidor = "localhost";
        porta = 3306; 
    }
    
    //métodos
    public static void conectar() throws SQLException {
        //MariaDB xampp
        String url = "jdbc:mariadb://" + servidor +
                     ":" + porta + "/" + bancoDados;

        conexao = DriverManager.getConnection(url, usuario, senha);
    }
    
    public static void desconectar() throws SQLException {
        conexao.close();
    }

    public static java.sql.Connection obterConexao() 
                throws SQLException {
        if (conexao == null) {
            throw new SQLException("Conexão está fechada..");
        } else {
            return conexao;
        }
    }
}
