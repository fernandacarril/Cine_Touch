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
    @FXML
    private Button btnPesquisar;
    
    public String getDadoPassado() {
        return dadoPassado;
    }

    public void setDadoPassado(String dadoPassado) {
        this.dadoPassado = dadoPassado;
    }

    private FilmeDAO filmeDAO = new FilmeDAO();
    private Filme filme; //model para a tela
    private ObservableList<Filme> listaFilme =  
            FXCollections.observableArrayList();
    private boolean incluindo = true;
    private ObservableList<String> listaClass =  
            FXCollections.observableArrayList("L", "10","12","14","16","18");
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        carregar_Combo_ID();
    }   
    
    private void mensagem(String msg) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Mensagem");
        alerta.setHeaderText(msg);
        alerta.setContentText("");

        alerta.showAndWait(); //exibe a mensage
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
    
    private void carregar_Combo_ID() {
        FilmeDAO filmeDao = new FilmeDAO();
        try {
            //busca todos os registros no banco para uma Coleção
            Collection<Filme> listFilm = filmeDao.lista("");
            //colocar a lista gerada pela DAO dentro da COMBO
            listaFilme.addAll(listFilm);
            //informa que a combo possui uma lista
            cbId.setItems(listaFilme);
            cbClass.setItems(listaClass);
        } catch (SQLException ex) {
            mensagem(ex.getMessage());
        }
    }

    @FXML
    private void cbId_Change(ActionEvent event) {
        if(cbId.getValue() != null) {
            txtFilme.setText(String.valueOf(
                    cbId.getValue().getNomeFilme()));
            cbClass.setValue(String.valueOf(
                    cbId.getValue().getClassificacao()));
            txtTempo.setText(String.valueOf(
                    cbId.getValue().getDuracao()));
            txtGenero.setText(String.valueOf(
                    cbId.getValue().getGenero()));
            txtSinopse.setText(String.valueOf(
                    cbId.getValue().getSinopse()));
        }
        else {
            txtFilme.setText("");
        }
    }
    private boolean validarDados() {
        if(txtFilme.getText().length() == 0 ||
                cbClass.getSelectionModel().isEmpty() ||
                txtTempo.getText().length() == 0 ||
                txtGenero.getText().length() == 0 || 
                txtSinopse.getText().length() == 0){
            return false;
        }
        else
            return true;
    }
    private void limparCampos() {
        cbId.getSelectionModel().clearSelection();
        txtFilme.setText("");
        cbClass.getSelectionModel().clearSelection();
        txtTempo.setText("");
        txtGenero.setText("");
        txtSinopse.setText("");
        
        cbId.requestFocus();
    }
    private void habilitarInclusao(boolean inc) {
        btnExcluir.setDisable(inc);
    }

    @FXML
    private void btnGravar_Click(ActionEvent event) {
        //verificar se dados estão OK
        if(!validarDados()) {
            mensagem("Por favor preencha todos os campos");
            return; //sai fora do método
        }
        
        //move dados da tela para model
        filme = carregar_Model();
        
        try {
            if(incluindo) { //se a operação geral é de inclusão
                if(filmeDAO.insere(filme)) {
                    mensagem("Filme incluido com sucesso!!");
                    cbId.requestFocus();
                }
                else {
                    mensagem("Erro na Inclusão");
                }
            }
            else { //alterando
                if(filmeDAO.altera(filme)) {
                    mensagem("Filme alterado com sucesso!!!");
                    cbId.requestFocus();
                }
                else {
                    mensagem("Erro na Alteração");
                }
            }
        }
        catch (SQLException ex) {
            mensagem("Erro na Inclusão\n" + ex.getMessage());
        }
        
        //tudo certo, vamos incluir um veiculo novo
        limparCampos();
        habilitarInclusao(true);
    }

    @FXML
    private void btnExcluir_Click(ActionEvent event) {
        filme = new Filme();
        //filme.setIdFilme(Integer.parseInt(cbId.getValue()));
        filme.setIdFilme(cbId.getValue().getIdFilme());
        
        try {
            if(filmeDAO.remove(filme)) {
                mensagem("Filme excluído com Sucesso !!!");
                cbId.requestFocus();
            } 
            else {
                mensagem("Filme algum erro para exclusão");
            }
        } catch (SQLException ex) {
            mensagem("Erro de Exclusão\n" + ex.getMessage());
        }
        
        //tudo certo, vamos incluir um veiculo novo
        limparCampos();
        habilitarInclusao(true);
    }

    @FXML
    private void btnVoltar_Click(ActionEvent event) {
    }

    @FXML
    private void btnPesquisar_Click(ActionEvent event) {
        filme = new Filme();
        filme.setNomeFilme(txtFilme.getText());
        try {
            //faz a procura
            filme = filmeDAO.buscaID(filme);
            
            //verifica se achou
            if(filme != null) { //achou
                carregar_View(filme);
                incluindo = false;
                habilitarInclusao(false);
            }
            else {
                mensagem("Filme não encontrado");
                //envia o foco para o text da placa
                txtFilme.requestFocus();
                incluindo = true;
            }
        } catch (SQLException ex) {
            mensagem("Erro na procura do Filme: " + 
                    ex.getMessage());
        }
    }
    

}
