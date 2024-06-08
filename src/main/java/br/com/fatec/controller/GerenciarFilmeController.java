/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package br.com.fatec.controller;

import br.com.fatec.DAO.FilmeDAO;
import br.com.fatec.model.Filme;
import java.net.URL;
import java.sql.SQLException;
import java.util.Collection;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
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
    private Label lblTempo;
    @FXML
    private TextField txtTempo;
    @FXML
    private ComboBox<String> cbClass;
    @FXML
    private Label lblSinopse;
    @FXML
    private TextField txtSinopse;
    @FXML
    private Label lblClassificacao1;
    @FXML
    private TextField txtGenero;
    @FXML
    private TextField txtFilme;
    @FXML
    private ComboBox<Filme> cbId;
    
    private String dadoPassado;
    
    public String getDadoPassado() {
        return dadoPassado;
    }

<<<<<<< Updated upstream
    private String dadoPassado;
    
    public String getDadoPassado() {
        return dadoPassado;
    }

=======
>>>>>>> Stashed changes
    public void setDadoPassado(String dadoPassado) {
        this.dadoPassado = dadoPassado;
    }
    
<<<<<<< Updated upstream
    
=======
    private FilmeDAO filmeDAO = new FilmeDAO();
    private Filme filme; //model para a tela
    private ObservableList<Filme> listaFilme =  
            FXCollections.observableArrayList();
    private boolean incluindo = true;
>>>>>>> Stashed changes
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        carregar_Combo();
    }   
    
    private void mensagem(String msg) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Mensagem");
        alerta.setHeaderText(msg);
        alerta.setContentText("");

        alerta.showAndWait(); //exibe a mensage
    }

    private void cbId_Change(ActionEvent event) {
        if(cbId.getValue() != null) {
            txtFilme.setText(
                    cbId.getValue().getNomeFilme());
        }
        else {
            txtFilme.setText("");
        }

    }
    /*
    * Carrega os dados que estão na tela para o Model
    */
    private Filme carregar_Model(){
        Filme model = new Filme();
        model.setNomeFilme(txtFilme.getText());
        model.setClassificacao(cbClass.getValue());
        model.setDuracao(txtTempo.getText());
        model.setGenero(txtGenero.getText());
        model.setSinopse(txtSinopse.getText());
        
        return model;
        
    }
    
    /**
     * Carrega os dados do Model para a Tela
    
*/  
    private void carregar_View(Filme model){
       txtFilme.setText(model.getNomeFilme());
       cbClass.setValue(model.getClassificacao());
       txtTempo.setText(model.getDuracao());
       txtGenero.setText(model.getGenero());
       txtSinopse.setText(model.getSinopse());
    }
    
    private void carregar_Combo() {
        FilmeDAO filmeDao = new FilmeDAO();
        try {
            //busca todos os registros no banco para uma Coleção
            Collection<Filme> listFilm = filmeDao.lista("");
            //colocar a lista gerada pela DAO dentro da COMBO
            listaFilme.addAll(listFilm);
            //informa que a combo possui uma lista
            cbId.setItems(listaFilme);
        } catch (SQLException ex) {
            mensagem(ex.getMessage());
        }
    }

}
