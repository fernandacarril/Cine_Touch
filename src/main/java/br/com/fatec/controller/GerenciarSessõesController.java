/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package br.com.fatec.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Fernanda
 */
public class GerenciarSessõesController implements Initializable {

    @FXML
    private Label lblTitulo;
    @FXML
    private Label lblSessao;
    @FXML
    private TextField txtId;
    @FXML
    private Label lblFilme;
    @FXML
    private TextField txtIdFilme;
    @FXML
    private ComboBox<?> cbFilme;
    @FXML
    private Label lblSala;
    @FXML
    private TextField txtSala;
    @FXML
    private Label lblDataI;
    @FXML
    private DatePicker dtDataI;
    @FXML
    private Label lblHorario;
    @FXML
    private Label lblDataF;
    @FXML
    private DatePicker dtDataF;
    @FXML
    private ComboBox<?> cbHorario;
    @FXML
    private Button btnGravar;
    @FXML
    private Button btnExcluir;
    @FXML
    private Button btnVoltar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
