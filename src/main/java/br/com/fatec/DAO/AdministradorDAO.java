/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.fatec.DAO;

import br.com.fatec.model.Administrador;
import br.com.fatec.persistencia.Banco;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author AMD
 */
public class AdministradorDAO 
    implements DAO<Administrador>

    {
        // variáveis auxiliares
    private Administrador administrador;
    //Auxiliares para acesso aos dadaos 

    //para conter os comandos DML
    private PreparedStatement pst; //pacote java.sql
    //para conter os dados vindos do BD
    private ResultSet rs; //pacote java.sql 

    //INSERE
    @Override
    public boolean insere(Administrador model) throws SQLException {
        String sql = "INSERT INTO administrador (idAdmin, login, senha) "
                + "VALUES (?, ?, ?);";

        //Abre a conexao
        Banco.conectar();

        //cria o comando preparado
        pst = Banco.obterConexao().prepareStatement(sql);

        //coloca os valores dentro do comando
        //substitui as '?' por dados
        pst.setInt(1, model.getIdUsuario());
        pst.setString(2, model.getLogin());
        pst.setString(3, model.getSenha());

        //executa o comando
        if (pst.executeUpdate() >= 1) { //tudo certo
            Banco.desconectar();
            return true;
        } else {
            Banco.desconectar();
            return false;
        }
    }

    //REMOVE
    @Override
    public boolean remove(Administrador model) throws SQLException {
        String sql = "DELETE FROM administrador WHERE idAdmin = ?;";
        Banco.conectar();

        //cria o comando preparado
        pst = Banco.obterConexao().prepareStatement(sql);

        //coloca os valores dentro do comando
        //substitui as '?' por dados
        pst.setInt(1, model.getIdUsuario());

        //executa o comando
        if (pst.executeUpdate() >= 1) { //tudo certo
            Banco.desconectar();
            return true;
        } else {
            Banco.desconectar();
            return false;
        }
    }

    //altera 
    @Override
    public boolean altera(Administrador model) throws SQLException {
        String sql = "UPDATE administrador SET login = ? "
                + "WHERE idAdmin = ?;";

        //Abre a conexao
        Banco.conectar();

        //cria o comando preparado
        pst = Banco.obterConexao().prepareStatement(sql);

        //coloca os valores dentro do comando
        //substitui as '?' por dados
        pst.setString(1, model.getLogin());
        pst.setInt(2, model.getIdUsuario());

        //executa o comando
        if (pst.executeUpdate() >= 1) { //tudo certo
            Banco.desconectar();
            return true;
        } else {
            Banco.desconectar();
            return false;
        }
    }

    
    
    
    
    
    public Administrador buscaPorLoginSenha(String login, String senha) throws SQLException {
        administrador = null;
        // Comando SELECT
        String sql = "SELECT * FROM administrador WHERE login = ? AND senha = ?;";

        // Conecta ao banco
        Banco.conectar();

        // Cria o comando preparado
        pst = Banco.obterConexao().prepareStatement(sql);

        // Define os parâmetros da consulta
        pst.setString(1, login);
        pst.setString(2, senha);

        // Executa o comando SELECT
        rs = pst.executeQuery();

        // Lê o próximo registro
        if (rs.next()) { // Achou 1 registro
            // Cria o objeto administrador
            administrador = new Administrador(0,"","");
            // Preenche os dados do administrador com os valores do banco de dados
            administrador.setIdUsuario(rs.getInt("idAdmin"));
            administrador.setLogin(rs.getString("login"));
            administrador.setSenha(rs.getString("senha"));
         
        }

        Banco.desconectar();

        return administrador;
    }

    
    //BUSCA ID
    @Override
    public Administrador buscaID(Administrador model) throws SQLException {
        administrador = null;
        //Comando SELECT
        String sql = "SELECT * FROM administrador WHERE idAdmin= ?;";

        //conecta ao banco
        Banco.conectar();

        //cria o comando preparado
        pst = Banco.obterConexao().prepareStatement(sql);

        //troca a ?
        pst.setInt(1, model.getIdUsuario());

        //Executa o comando SELECT
        rs = pst.executeQuery();

        //le o próximo regitro
        if (rs.next()) { //achou 1 registro
            //cria o objeto proprietario
            administrador = new Administrador(1,"login","senha");
            //move os dados do resultSet para o objeto proprietario
            administrador.setIdUsuario(rs.getInt("idAdmin"));
            administrador.setLogin(rs.getString("login"));
        }
        
        Banco.desconectar();

        return administrador;
    }

    
    @Override
     public Collection<Administrador> lista(String criterio) 
                throws SQLException {
        //criar uma coleção
        Collection<Administrador> listagem = new ArrayList<>();
        
        administrador = null;
        //Comando SELECT
        String sql = "SELECT * FROM administrador ";
        //colocar filtro ou nao
        if(criterio.length() != 0) {
            sql += "WHERE " + criterio;
        }
        
        //conecta ao banco
        Banco.conectar();
        
        pst = Banco.obterConexao().prepareStatement(sql);
        
        //Executa o comando SELECT
        rs = pst.executeQuery();
        
        //le o próximo regitro
        while(rs.next()) { //achou 1 registro
            //cria o objeto veiculo
            administrador = new Administrador(1,"login","senha");
            //move os dados do resultSet para o objeto proprietario
            administrador.setIdUsuario(rs.getInt("idAdmin"));
            administrador.setLogin(rs.getString("login"));
            
            //adicionar na coleção
            listagem.add(administrador);
        }
        
        Banco.desconectar();
        
        return listagem;
    }
    
    
}


