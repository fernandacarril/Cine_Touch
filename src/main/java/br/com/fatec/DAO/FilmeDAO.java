/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.fatec.DAO;

import br.com.fatec.model.Filme;
import br.com.fatec.persistencia.Banco;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Fernanda
 */
public class FilmeDAO implements DAO<Filme> {

    //variaveis auxiliares
    private Filme filme;
    //auxiliares para acesso aos dados

    //para conter os comandos DML
    private PreparedStatement pst; //pacote java.sql
    //para conter os dados vindos do BD
    private ResultSet rs; //pacote java.sql

    @Override
    public boolean insere(Filme model) throws SQLException {
        String sql = "INSERT INTO filme (nomeFilme, duracao, classificacao, sinopse, genero) "
                + "VALUES (?, ?, ?, ?, ?);";

        //Abre a conexao
        Banco.conectar();

        //cria o comando preparado
        pst = Banco.obterConexao().prepareStatement(sql);

        //coloca os valores dentro do comando
        //substitui as '?' por dados
        pst.setString(1, model.getNomeFilme().toUpperCase());
        pst.setString(2, model.getDuracao());
        pst.setString(3, model.getClassificacao());
        pst.setString(4, model.getSinopse());
        pst.setString(5, model.getGenero());

        //executa o comando
        if (pst.executeUpdate() >= 1) { //tudo certo
            Banco.desconectar();
            return true;
        } else {
            Banco.desconectar();
            return false;
        }
    }

    @Override
    public boolean remove(Filme model) throws SQLException {
        String sql = "DELETE FROM filme WHERE idFilme = ?;";

        //Abre a conexao
        Banco.conectar();

        //cria o comando preparado
        pst = Banco.obterConexao().prepareStatement(sql);

        //coloca os valores dentro do comando
        //substitui as '?' por dados
        pst.setInt(1, model.getIdFilme());

        //executa o comando
        if (pst.executeUpdate() >= 1) { //tudo certo
            Banco.desconectar();
            return true;
        } else {
            Banco.desconectar();
            return false;
        }
    }

    @Override
    public boolean altera(Filme model) throws SQLException {
        String sql = "UPDATE filme SET nomeFilme = ?,  duracao= ?, "
                + "classificacao = ?, sinopse = ?, genero = ? WHERE idFilme =? ;";

        //Abre a conexao
        Banco.conectar();

        //cria o comando preparado
        pst = Banco.obterConexao().prepareStatement(sql);

        //coloca os valores dentro do comando
        //substitui as '?' por dados
        pst.setString(1, model.getNomeFilme().toUpperCase());
        pst.setString(2, model.getDuracao());
        pst.setString(3, model.getClassificacao());
        pst.setString(4, model.getSinopse());
        pst.setString(5, model.getGenero());
        pst.setInt(6, model.getIdFilme());
        //executa o comando
        if (pst.executeUpdate() >= 1) { //tudo certo
            Banco.desconectar();
            return true;
        } else {
            Banco.desconectar();
            return false;
        }
    }

    @Override
    public Filme buscaID(Filme model) throws SQLException {
        filme = null;
        //Comando SELECT
        String sql = "SELECT * FROM filme WHERE nomeFilme = ?;";

        //conecta ao banco
        Banco.conectar();

        //cria o comando preparado
        pst = Banco.obterConexao().prepareStatement(sql);

        //troca a ?
        pst.setString(1, model.getNomeFilme());

        //Executa o comando SELECT
        rs = pst.executeQuery();

        //le o próximo regitro
        if (rs.next()) { //achou 1 registro

            //cria o objeto filme
            filme = new Filme();
            filme.setIdFilme(rs.getInt("idFilme"));
            filme.setNomeFilme(rs.getString("nomeFilme"));
            filme.setDuracao(rs.getString("duracao"));
            filme.setClassificacao(rs.getString("classificacao"));
            filme.setSinopse(rs.getString("sinopse"));
            filme.setGenero(rs.getString("genero"));
        }

        Banco.desconectar();

        return filme;
    }

    @Override
    public Collection<Filme> lista(String criterio) throws SQLException {
        //cria uma lista para armazenar os dados vindos do banco
        ArrayList<Filme> lista = new ArrayList<>();
        
        String sql = "SELECT * FROM filme ";

        //precisa fazer filtro para listagem
        if(criterio != null && criterio.length() > 0) {
            sql += " WHERE " + criterio;
        }
        
        //abre a conexao com o banco
        Banco.conectar();
        
        //preparar o comando PST
        pst = Banco.obterConexao().prepareStatement(sql);
        
        //executar o comando
        rs = pst.executeQuery(); //esse método serve para SELECT
        
        //Varre todo o resultado da consulta e coloca cada registro dentro
        //de um objeto e coloca o objeto dentro da coleção
        while(rs.next()) {
            //criar o objeto
            filme = new Filme();
            
            //mover os dados do resultSet para o objeto proprietário
            filme.setIdFilme(rs.getInt("idFilme"));
            filme.setNomeFilme(rs.getString("nomeFilme"));
            filme.setDuracao(rs.getString("duracao"));
            filme.setSinopse(rs.getString("sinopse"));
            filme.setGenero(rs.getString("genero"));
            filme.setClassificacao(rs.getString("classificacao"));
            
            //move o objeto para a coleção
            lista.add(filme);
        }
                
        //fecha a conexao
        Banco.desconectar();
        
        //devolve o objeto proprietario
        return lista;
        
    }
}
