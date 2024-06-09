/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package br.com.fatec.controller;

import br.com.fatec.DAO.FilmeDAO;
import br.com.fatec.model.Filme;
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
public class VisualizarFilmesController implements Initializable {

    @FXML
    private Label lblTitulo;
    @FXML
    private TableView<Filme> tbFilmes;
    @FXML
    private TableColumn<Filme, Boolean> colSelecionado;
    @FXML
    private TableColumn<Filme, Integer> colId;
    @FXML
    private TableColumn<Filme, String> colNome;
    @FXML
    private TableColumn<Filme, String> colDuracao;
    @FXML
    private TableColumn<Filme, String> colClass;
    @FXML
    private TableColumn<Filme, String> colSinopse;
    @FXML
    private TableColumn<Filme, String> colGenero;
    @FXML
    private Button btnExcluir;
    @FXML
    private Button btnVoltar;
    
    private String dadoPassado;

    public String getDadoPassado() {
        return dadoPassado;
    }

    public void setDadoPassado(String dadoPassado) {
        this.dadoPassado = dadoPassado;
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colSelecionado.setCellValueFactory(
            cellData -> cellData.getValue().selecionadoProperty().asObject());
        colId.setCellValueFactory(
                new PropertyValueFactory<>("idFilme"));
        colNome.setCellValueFactory(
                new PropertyValueFactory<>("nomeFilme"));
        colDuracao.setCellValueFactory(
                new PropertyValueFactory<>("duracao"));
        colClass.setCellValueFactory(
                new PropertyValueFactory<>("classificacao"));
        colSinopse.setCellValueFactory(
                new PropertyValueFactory<>("sinopse"));
        colGenero.setCellValueFactory(
                new PropertyValueFactory<>("genero"));
        
        
        //coloca o checkbox na coluna
        colSelecionado.setCellFactory(
                CheckBoxTableCell.forTableColumn(colSelecionado));

        //preenche a tabela
        tbFilmes.setItems(preencheTabela());
    }
    private ObservableList<Filme> preencheTabela() {
        FilmeDAO dao = new FilmeDAO();
        ObservableList<Filme> filmes
            = FXCollections.observableArrayList();
        
        try {
            //busca somente que termina com 'a'
            //proprietarios.addAll(dao.lista("nome like '%a'"));
            //busca todo mundo
            filmes.addAll(dao.lista(""));
        } catch (SQLException ex) {
            Alert alerta = new Alert(Alert.AlertType.ERROR,
                    "Erro Preenche Tabela: " + ex.getMessage(),
                    ButtonType.OK);
            alerta.showAndWait();
        }
        
        return filmes;
    }    
    
}
