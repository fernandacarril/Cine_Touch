/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package br.com.fatec.controller;

import br.com.fatec.model.Filme;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Fernanda
 */
public class GerenciarFilmeController implements Initializable {

    @FXML
    private Button btnGravar;
    @FXML
    private Button btnExcluir;
    @FXML
    private Button btnVoltar;
    @FXML
    private Label lblTitulo;
    @FXML
    private Label lblFilme;
    @FXML
    private Label lblClassificacao;
    @FXML
    private TextField txtId;
    @FXML
    private Label lblTempo;
    @FXML
    private Label lblAtor;
    @FXML
    private TextField txtTempo;
    @FXML
    private ComboBox<?> cbClass;
    @FXML
    private ComboBox<Filme> cbFilme;
    @FXML
    private TextField txtAtores;
    @FXML
    private Label lblSinopse;
    @FXML
    private TextField txtSinopse;

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
        // TODO

    }    
    
}
