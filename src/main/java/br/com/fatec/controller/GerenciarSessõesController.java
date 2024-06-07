/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package br.com.fatec.controller;

import br.com.fatec.DAO.FilmeDAO;
import br.com.fatec.DAO.GerenciarSesõesDAO;
import br.com.fatec.model.Filme;
import br.com.fatec.model.Sessoes;
import java.net.URL;
import java.sql.SQLException;
import java.util.Collection;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
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
    private ComboBox<Filme> cbFilme;
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

    private String dadoPassado;
    @FXML
    private Button btnExcluir1;

    public String getDadoPassado() {
        return dadoPassado;
    }

    public void setDadoPassado(String dadoPassado) {
        this.dadoPassado = dadoPassado;
    }
    
    //variaveis auxiliares 
    private GerenciarSesõesDAO GerenciarSessõesDAO = new GerenciarSesõesDAO();
    private Sessoes sessoes; 
    private ObservableList<Filme> listafilme =  
            FXCollections.observableArrayList();  
    //para saber se a operação é de inclusão ou não
    private boolean incluindo = true;
   
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        carregar_Combo();
    }    
    
    
    private void carregar_Combo() {
        FilmeDAO filmeDao = new FilmeDAO();
        try {
            //busca todos os registros no banco para uma Coleção
            Collection<Filme> listFilm = filmeDao.lista("");
            //colocar a lista gerada pela DAO dentro da COMBO
            listafilme.addAll(listFilm);
            //informa que a combo possui uma lista
            cbFilme.setItems(listafilme);
            
        } catch (SQLException ex) {
            mensagem(ex.getMessage());
        }
    }
    
     private void mensagem(String msg) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Mensagem");
        alerta.setHeaderText(msg);
        alerta.setContentText("");

        alerta.showAndWait(); //exibe a mensage
    }
    
    
    
}
