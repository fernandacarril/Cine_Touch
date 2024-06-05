/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package br.com.fatec.controller;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;


/**
 * FXML Controller class
 *
 * @author Fernanda
 */
public class TelaInicialController implements Initializable {

    @FXML
    private Button btnIniciar;
    @FXML
    private Label lblFernanda;
    @FXML
    private ImageView imgLogo;
    @FXML
    private Label lblFernando;
    @FXML
    private Button btnAdmin;



    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnAdmin_Click(ActionEvent event) {
        
    }

    @FXML
    private void btnIniciar_Click(ActionEvent event) {
    }
}
