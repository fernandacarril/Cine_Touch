/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package br.com.fatec.controller;

import br.com.fatec.DAO.FilmeDAO;
import br.com.fatec.DAO.SessaoDAO;
import br.com.fatec.model.Filme;
import br.com.fatec.model.Sala;
import br.com.fatec.model.Sessoes;
import java.net.URL;
import java.sql.SQLException;
import java.util.Collection;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author AMD
 */
public class GerenciarSessaoController implements Initializable {

    @FXML
    private TextField txt_SessaoId;
    @FXML
    private TextField txt_DataInicio;
    @FXML
    private TextField txt_FilmeId;
    @FXML
    private TextField txt_DataFim;
    @FXML
    private TextField txt_Horas;
    @FXML
    private TextField txt_Sala;
    @FXML
    private ComboBox<Filme> cb_Filme;
    @FXML
    private Button btn_gravar;
    @FXML
    private Button btn_excluir;
    @FXML
    private Button btn_visualizarSessoes;
    @FXML
    private Button btn_voltar;
    @FXML
    private Button btn_Pesquisa;

    private String dadoPassado;

    public String getDadoPassado() {
        return dadoPassado;
    }

    public void setDadoPassado(String dadoPassado) {
        this.dadoPassado = dadoPassado;
    }

    private SessaoDAO sessaoDAO = new SessaoDAO();
    private Filme filme;
    private Sessoes sessao;
    private ObservableList<Filme> listaFilme
            = FXCollections.observableArrayList();
    private boolean incluindo = true;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        carregar_Combo();
    }

    private Sessoes carregar_Model() {
        // Cria uma nova instância de Sessoes
        Sessoes model = new Sessoes();

        // Define o idSessao
        model.setIdSessao(Integer.parseInt(txt_SessaoId.getText()));

        // Cria uma instância de Sala e configura os valores
        Sala sala = new Sala();
        sala.setNumeroSala(Integer.parseInt(txt_Sala.getText())); // Presumo que txt_Sala contenha o número da sala

        // Cria uma instância de Filme e configura os valores
        Filme filmes = new Filme();
        filmes.setIdFilme(Integer.parseInt(txt_FilmeId.getText())); // Presumo que txt_FilmeId contenha o id do filme

        // Define sala e filme no modelo
        model.setSala(sala);
        model.setFilme(filmes);

        // Define as outras propriedades
        model.setDataI(txt_DataInicio.getText());
        model.setDataF(txt_DataFim.getText());
        model.setHorario(txt_Horas.getText());

        return model;
    }

    private Sessoes carregar_Model_insere() {
         // Cria uma nova instância de Sessoes
        Sessoes model = new Sessoes();

        // Define o idSessao
        model.setIdSessao(Integer.parseInt(txt_SessaoId.getText()));

        // Cria uma instância de Sala e configura os valores
        Sala sala = new Sala();
        sala.setNumeroSala(Integer.parseInt(txt_Sala.getText())); // Presumo que txt_Sala contenha o número da sala

        // Cria uma instância de Filme e configura os valores
        Filme filmes = new Filme();
        filmes.setIdFilme(Integer.parseInt(txt_FilmeId.getText())); // Presumo que txt_FilmeId contenha o id do filme

        // Define sala e filme no modelo
        model.setSala(sala);
        model.setFilme(filmes);

        // Define as outras propriedades
        model.setDataI(txt_DataInicio.getText());
        model.setDataF(txt_DataFim.getText());
        model.setHorario(txt_Horas.getText());

    }
    
    private void carregar_View(Sessoes model){
        int idSessaoSelecionada = model.getIdSessao();
        
        
    }
    @FXML
    private void cb_Filme_Change(ActionEvent event) {
        if (cb_Filme.getValue() != null) {
            txt_FilmeId.setText(String.valueOf(cb_Filme.getValue().getIdFilme()));

        } else {
            txt_FilmeId.setText("");
        }

    }

    @FXML
    private void btn_gravar_Click(ActionEvent event) {

        if (!validarDados()) {
            mensagem("Por favor preencha todos os campos");
            return; //sai fora do método
        }
        sessao = carregar_model();
    }

    @FXML
    private void btn_excluir_Click(ActionEvent event) {
    }

    @FXML
    private void btn_visualizarSessoes_Click(ActionEvent event) {
    }

    @FXML
    private void btn_voltar_Click(ActionEvent event) {
    }

    @FXML
    private void btn_Pesquisa_Click(ActionEvent event) {
    }

    private void carregar_Combo() {
        FilmeDAO filmeDao = new FilmeDAO();
        try {
            //busca todos os registros no banco para uma Coleção
            Collection<Filme> listFilm = filmeDao.lista("");
            //colocar a lista gerada pela DAO dentro da COMBO
            listaFilme.addAll(listFilm);
            //informa que a combo possui uma lista
            cb_Filme.setItems(listaFilme);
        } catch (SQLException ex) {
            mensagem(ex.getMessage());
        }
    }

    @FXML
    private void mensagem(String msg) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Mensagem");
        alerta.setHeaderText(msg);
        alerta.setContentText("");

        alerta.showAndWait(); //exibe a mensage
    }

    private boolean validarDados() {

    }

}
