/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package br.com.fatec.controller;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Fernanda
 */
public class TelaAdmController implements Initializable {
    private String dadoPassado;
    
    @FXML
    private ImageView imgLogo;
    @FXML
    private Label lblFernanda;
    @FXML
    private Label lblFernando;
    @FXML
    private Label lblTitulo;
     @FXML
    private ListView<String> lvMenu;
     
    @FXML
    private Pane pnMenu;
    
    private final Map<String, String> viewMap = new HashMap<>();


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
        lvMenu.getItems().addAll("Inicio", "Gerenciar Filmes", "Gerenciar Sessões");

        // Associa os itens aos arquivos FXML
        viewMap.put("Gerenciar Filmes", "GerenciarFilme.fxml");
        viewMap.put("Gerenciar Sessões", "GerenciarSessoes.fxml");
        viewMap.put("Tela 3", "view3.fxml");

        // Define o comportamento ao clicar nos itens
        lvMenu.setOnMouseClicked(this::handleSelection);
    }

   

    private void loadView(String fxmlFile) {
        try {
            Node view = FXMLLoader.load(getClass().getResource(fxmlFile));
            pnMenu.getChildren().setAll(view);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
    
 
}
