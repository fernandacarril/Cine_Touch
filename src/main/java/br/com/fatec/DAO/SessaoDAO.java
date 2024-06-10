/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.fatec.DAO;

import br.com.fatec.model.Filme;
import br.com.fatec.model.Sala;
import br.com.fatec.model.Sessoes;
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
public class SessaoDAO implements DAO<Sessoes> {

    private Sessoes sessoes;
    //para conter os comandos DML
    private PreparedStatement pst; //pacote java.sql
    //para conter os dados vindos do BD
    private ResultSet rs; //pacote java.sql 

    @Override
    public boolean insere(Sessoes model) throws SQLException {
        String sql = "INSERT INTO sessao (idSessao, dataInicio, dataFim, horario, numeroSala, idFilme ) "
                + "VALUES (?, ?, ?, ?, ?, ?);";
        //Abre a conexao
        Banco.conectar();
        //cria o comando preparado
        pst = Banco.obterConexao().prepareStatement(sql);
        //coloca os valores dentro do comando
        //substitui as '?' por dados
        pst.setInt(1, model.getIdSessao());
        pst.setString(2, model.getDataI());
        pst.setString(3, model.getDataF());
        pst.setString(4, model.getHorario());
        pst.setInt(5, model.getSala().getNumeroSala());
        pst.setInt(6, model.getFilme().getIdFilme());

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
    public boolean remove(Sessoes model) throws SQLException {
        String sql = "DELETE FROM sessao WHERE idSessao = ?;";

        //Abre a conexao
        Banco.conectar();

        //cria o comando preparado
        pst = Banco.obterConexao().prepareStatement(sql);

        //coloca os valores dentro do comando
        //substitui as '?' por dados
        pst.setInt(1, model.getIdSessao());

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
    public boolean altera(Sessoes model) throws SQLException {
        String sql = "UPDATE sessao SET idFilme = ?, dataInicio = ?, dataFim = ?, horario = ?, "
                + "numeroSala = ? WHERE idSessao = ?";

        //Abre a conexao
        Banco.conectar();

        //cria o comando preparado
        pst = Banco.obterConexao().prepareStatement(sql);

        //coloca os valores dentro do comando
        //substitui as '?' por dados
        pst = Banco.obterConexao().prepareStatement(sql);
        pst.setInt(1, model.getFilme().getIdFilme());
        pst.setString(2, model.getDataI());
        pst.setString(3, model.getDataF());// Convertendo LocalDate para String
        pst.setString(4, model.getHorario());
        pst.setInt(5, model.getSala().getNumeroSala());
        pst.setInt(6, model.getIdSessao());

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
    public Sessoes buscaID(Sessoes model) throws SQLException {
        sessoes = null;
        //Comando SELECT
        String sql = "SELECT * FROM sessao WHERE idSessao = ?;";

        //conecta ao banco
        Banco.conectar();

        //cria o comando preparado
        pst = Banco.obterConexao().prepareStatement(sql);

        //troca a ?
        pst.setInt(1, model.getIdSessao());

        //Executa o comando SELECT
        rs = pst.executeQuery();

        //le o próximo regitro
        if (rs.next()) { // Achou 1 registro
            // Cria o objeto Sessoes e configura o idSessao
            sessoes = new Sessoes();
            sessoes.setIdSessao(rs.getInt("idSessao"));

            // Configura o filme (supondo que você tenha um objeto Filme)
            Filme filme = new Filme();
            filme.setIdFilme(rs.getInt("idFilme"));
            // Aqui você configura outras propriedades do objeto Filme se necessário
            sessoes.setFilme(filme);
            

            // Configura as outras propriedades de sessoes
            sessoes.setDataI(rs.getString("dataInicio"));
            sessoes.setDataF(rs.getString("dataFim"));
            sessoes.setHorario(rs.getString("horario"));

            // Configura a sala (supondo que você tenha um objeto Sala)
            Sala sala = new Sala();
            sala.setNumeroSala(rs.getInt("numeroSala"));
            // Aqui você configura outras propriedades do objeto Sala se necessário
            sessoes.setSala(sala);
        }
        Banco.desconectar();

        return sessoes;

    }

    @Override
    public Collection<Sessoes> lista(String criterio) throws SQLException {

        //criar uma coleção
        Collection<Sessoes> listagem = new ArrayList<>();

        sessoes = null;
        //Comando SELECT
        String sql = "SELECT * FROM sessao ";
        //colocar filtro ou nao
        if (criterio.length() != 0) {
            sql += "WHERE " + criterio;
        }

        //conecta ao banco
        Banco.conectar();

        pst = Banco.obterConexao().prepareStatement(sql);

        //Executa o comando SELECT
        rs = pst.executeQuery();

        //le o próximo regitro
        while (rs.next()) { //achou 1 registro
            sessoes = new Sessoes();
            sessoes.setIdSessao(rs.getInt("idSessao"));

            // Configura o filme (supondo que você tenha um objeto Filme)
            Filme filme = new Filme();
            filme.setIdFilme(rs.getInt("idFilme"));
            // Aqui você configura outras propriedades do objeto Filme se necessário
            sessoes.setFilme(filme);

            // Configura as outras propriedades de sessoes
            sessoes.setDataI(rs.getString("dataInicio"));
            sessoes.setDataF(rs.getString("dataFim"));
            sessoes.setHorario(rs.getString("horario"));

            // Configura a sala (supondo que você tenha um objeto Sala)
            Sala sala = new Sala();
            sala.setNumeroSala(rs.getInt("numeroSala"));
            // Aqui você configura outras propriedades do objeto Sala se necessário
            sessoes.setSala(sala);
        }

        Banco.desconectar();

        return listagem;
    }
    
}
