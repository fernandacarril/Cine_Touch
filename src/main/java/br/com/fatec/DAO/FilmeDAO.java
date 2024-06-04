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
public class FilmeDAO implements DAO <Filme> {
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
        pst.setString(1, model.getNomeFilme());
        pst.setString(2, model.getDuracao());
        pst.setInt(3, model.getClassificacao());
        pst.setString(4, model.getSinopse());
        pst.setString(5, model.getGenero());
                
        //executa o comando
        if(pst.executeUpdate() >= 1) { //tudo certo
            Banco.desconectar();
            return true;
        }
        else {
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
        if(pst.executeUpdate() >= 1) { //tudo certo
            Banco.desconectar();
            return true;
        }
        else {
            Banco.desconectar();
            return false;
        }
    }

    @Override
    public boolean altera(Filme model) throws SQLException {
        String sql = "UPDATE veiculo SET nomeFilme = ?,  duracao= ?, "
                + "classificacao = ? WHERE genero = ?;";
        
        //Abre a conexao
        Banco.conectar();
        
        //cria o comando preparado
        pst = Banco.obterConexao().prepareStatement(sql);
        
        //coloca os valores dentro do comando
        //substitui as '?' por dados
        pst.setString(1, model.getNomeFilme());
        pst.setString(2, model.getDuracao());
        pst.setInt(3, model.getClassificacao());
        pst.setString(4, model.getSinopse());
        pst.setString(5, model.getGenero());
        //executa o comando
        if(pst.executeUpdate() >= 1) { //tudo certo
            Banco.desconectar();
            return true;
        }
        else {
            Banco.desconectar();
            return false;
        }
    }

    @Override
    public Filme buscaID(Filme model) throws SQLException {
        filme = null;
        //Comando SELECT
        String sql = "SELECT * FROM filme WHERE idFilme = ?;";
        
        //conecta ao banco
        Banco.conectar();
        
        //cria o comando preparado
        pst = Banco.obterConexao().prepareStatement(sql);
        
        //troca a ?
        pst.setInt(1, model.getIdFilme());
        
        //Executa o comando SELECT
        rs = pst.executeQuery();
        
        //le o próximo regitro
        if(rs.next()) { //achou 1 registro
            
            
            //cria o objeto veiculo
            filme = new Filme(f);
            //move os dados do resultSet para o objeto veiculo
            filme.setNomeFilme(rs.getString("nomeFilme"));
            filme.setDuracao(rs.getString("duracao"));
            filme.setClassificacao(rs.getInt("classificacao"));
            filme.setSinopse(rs.getString("sinopse"));
            filme.setClassificacao(rs.getString("genero"));
        }
        
        Banco.desconectar();
        
        return filme;        
    }

    @Override
    public Collection<Filme> lista(String criterio) 
                throws SQLException {
        //criar uma coleção
        Collection<Filme> listagem = new ArrayList<>();
        
        filme = null;
        //Comando SELECT
        String sql = "SELECT * FROM Filme ";
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
            filme = new Filme(f);
            //move os dados do resultSet para o objeto veiculo
            filme.setNomeFilme(rs.getString("nomeFilme"));
            filme.setDuracao(rs.getString("duracao"));
            filme.setClassificacao(rs.getInt("classificacao"));
            filme.setSinopse(rs.getString("sinopse"));
            filme.setClassificacao(rs.getString("genero"));
            
            //adicionar na coleção
            listagem.add(filme);
        }
        
        Banco.desconectar();
        
        return listagem;
    }
}
