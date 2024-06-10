/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package br.com.fatec.controller;

import br.com.fatec.model.Aperitivos;
import br.com.fatec.model.Filme;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Fernanda
 */
public class GerenciarAperitivosController implements Initializable {

    @FXML
    private Label lblTitulo;
    @FXML
    private Label lblId;
    @FXML
    private Label lblDescricao;
    @FXML
    private Label lblNome;
    @FXML
    private Label lblValor;
    @FXML
    private Label lblPeso;
    @FXML
    private Button btnGravar;
    @FXML
    private Button btnExcluir;
    @FXML
    private Button btnVoltar;
    @FXML
    private Button btnPesquisar;
    @FXML
    private TextField txtID;
    @FXML
    private TextField txtNome;
    @FXML
    private TextField txtDescricao;
    @FXML
    private TextField txtValor;
    @FXML
    private TextField txtPeso;
    
    private Aperitivos aperitivo; //model para a tela
    private ObservableList<Aperitivos> listaAperitivos =  
            FXCollections.observableArrayList();
    private boolean incluindo = true;
    
    private String dadoPassado;
    public String getDadoPassado() {
        return dadoPassado;
    }

    public void setDadoPassado(String dadoPassado) {
        this.dadoPassado = dadoPassado;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    private void mensagem(String msg) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Mensagem");
        alerta.setHeaderText(msg);
        alerta.setContentText("");

        alerta.showAndWait(); //exibe a mensage
    }
    
    private Aperitivos carregar_Model(){
        Aperitivos model = new Aperitivos();
        model.setId(Integer.parseInt(txtID.getText()));
        model.setNome(txtNome.getText());
        model.setDescricao(txtDescricao.getText());
        model.setValor(Double.parseDouble(txtValor.getText()));
        model.setPeso(Double.parseDouble(txtPeso.getText()));

        
        return model;
        
    }
    private void carregar_View(Filme model){
       txtID.setText(model.getNomeFilme());
       txtNome.setText(model.getClassificacao());
       txtDescricao.setText(model.getDuracao());
       txtValor.setText(model.getGenero());
       txtPeso.setText(model.getSinopse());
    }
    
    private boolean validarDados() {
        if(txtID.getText().length() == 0 ||
                txtNome.getText().length() == 0 ||
                txtDescricao.getText().length() == 0 ||
                txtValor.getText().length() == 0 || 
                txtPeso.getText().length() == 0){
            return false;
        }
        else
            return true;
    }
    private void limparCampos() {
        txtID.setText("");
        txtNome.setText("");
        txtDescricao.setText("");
        txtValor.setText("");
        txtPeso.setText("");
        
        txtID.requestFocus();
    }
    private void habilitarInclusao(boolean inc) {
        btnExcluir.setDisable(inc);
    }

    @FXML
    private void btnGravar_Click(ActionEvent event) {
        try {
            int id = Integer.parseInt(txtID.getText());
            String nome = txtNome.getText();
            String descricao = txtDescricao.getText();
            double valor = Double.parseDouble(txtValor.getText());
            double peso = Double.parseDouble(txtPeso.getText());

            Aperitivos aperitivo = new Aperitivos(id, nome, descricao, valor, peso);

            if (incluindo) {
                Aperitivos.inserirAperitivo(aperitivo);
                mensagem("Aperitivo incluído com sucesso!");
            } else {
                Aperitivos.atualizarAperitivo(aperitivo);
                mensagem("Aperitivo atualizado com sucesso!");
            }
        } catch (NumberFormatException e) {
            mensagem("Por favor, preencha todos os campos corretamente.");
        }

        limparCampos();
        habilitarInclusao(true);
    }

    @FXML
    private void btnExcluir_Click(ActionEvent event) {
        try {
            int id = Integer.parseInt(txtID.getText());
            Aperitivos.excluirAperitivo(id);
            mensagem("Aperitivo excluído com sucesso!");
            limparCampos();
        } catch (NumberFormatException e) {
            mensagem("Por favor, insira um ID válido para excluir o aperitivo.");
        }
    }

    @FXML
    private void btnVoltar_Click(ActionEvent event) {
        Stage stage = (Stage) btnVoltar.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void btnPesquisar_Click(ActionEvent event) {
        try {
            int id = Integer.parseInt(txtID.getText());
            Aperitivos aperitivo = Aperitivos.pesquisarAperitivo(id);
            if (aperitivo != null) {
                txtNome.setText(aperitivo.getNome());
                txtDescricao.setText(aperitivo.getDescricao());
                txtValor.setText(String.valueOf(aperitivo.getValor()));
                txtPeso.setText(String.valueOf(aperitivo.getPeso()));
                habilitarInclusao(false);
                
            } else {
                mensagem("Aperitivo não encontrado.");
            }
        } catch (NumberFormatException e) {
            mensagem("Por favor, insira um ID válido para pesquisar o aperitivo.");
        }
    }
    
}
