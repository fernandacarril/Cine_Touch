/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package br.com.fatec.controller;

import br.com.fatec.DAO.SessaoDAO;
import br.com.fatec.model.Sessoes;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Fernanda
 */
public class VisualizarSessoesController implements Initializable {
    private String dadoPassado;
    @FXML
    private TableView<Sessoes> tbSessoes;
    @FXML
    private TableColumn<Sessoes, Integer> colID;
    @FXML
    private TableColumn<Sessoes, Integer> colFilme;
    @FXML
    private TableColumn<Sessoes, Integer> colSala;
    @FXML
    private TableColumn<Sessoes, String> colInicial;
    @FXML
    private TableColumn<Sessoes, String> colFinal;
    @FXML
    private TableColumn<Sessoes, String> colHora;
    @FXML
    private Button btnExcluir;
    @FXML
    private TableColumn<Sessoes, Boolean> colSelecionado;

    public String getDadoPassado() {
        return dadoPassado;
    }

    public void setDadoPassado(String dadoPassado) {
        this.dadoPassado = dadoPassado;
    }


    @FXML
    private Label lblTitulo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        /*
        private TableColumn<Sessoes, Integer> colID;
    @FXML
    private TableColumn<Sessoes, Integer> colFilme;
    @FXML
    private TableColumn<Sessoes, Integer> colSala;
    @FXML
    private TableColumn<Sessoes, String> colInicial;
    @FXML
    private TableColumn<Sessoes, String> colFinal;
    @FXML
    private TableColumn<Sessoes, String> colHora;
    @FXML
    private Button btnExcluir;
    @FXML
    private TableColumn<Sessoes, Boolean> colSelecionado;
        */
        colSelecionado.setCellValueFactory(
                new PropertyValueFactory<>("selecionado"));
        colID.setCellValueFactory(
                new PropertyValueFactory<>("idSessao"));
        colSala.setCellValueFactory(
                new PropertyValueFactory<>("numeroSala"));
        colInicial.setCellValueFactory(
                new PropertyValueFactory<>("dataInicio"));
        colFinal.setCellValueFactory(
                new PropertyValueFactory<>("dataFim"));
        colHora.setCellValueFactory(
                new PropertyValueFactory<>("horario"));
        
        //coloca o checkbox na coluna
        colSelecionado.setCellFactory(
                CheckBoxTableCell.forTableColumn(colSelecionado));

        //preenche a tabela
        tbSessoes.setItems(preencheTabela());
    }    

    private ObservableList<Sessoes> preencheTabela() {
        SessaoDAO dao = new SessaoDAO();
        ObservableList<Sessoes> sessoes
            = FXCollections.observableArrayList();
        
        try {
            //busca somente que termina com 'a'
            //proprietarios.addAll(dao.lista("nome like '%a'"));
            //busca todo mundo
            sessoes.addAll(dao.lista(""));
        } catch (SQLException ex) {
            Alert alerta = new Alert(Alert.AlertType.ERROR,
                    "Erro Preenche Tabela: " + ex.getMessage(),
                    ButtonType.OK);
            alerta.showAndWait();
        }
        
        return sessoes;
    }
    
}
