/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package br.com.fatec.controller;

import br.com.fatec.DAO.AdministradorDAO;
import br.com.fatec.model.Administrador;
import br.com.fatec.model.Sessoes;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import javafx.fxml.FXML;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Fernanda
 */
public class LoginAdmController implements Initializable {
    private String senha;
    @FXML
    private TextField txtUsuario;

    @FXML
    private CheckBox ckSenha;

    @FXML
    private Button btnConfirmar;

    @FXML
    private Button btnVoltar;

    @FXML
    private ImageView imgLogo;

    @FXML
    private Label lblLogin;

    @FXML
    private Label lblAdm;

    @FXML
    private Label lblUsuario;

    @FXML
    private Label lblSenha;

    private String dadoPassado;
    @FXML
    private TextField txtSenha;
    @FXML
    private PasswordField pwSenha;

    public String getDadoPassado() {
        return dadoPassado;
    }

    public void setDadoPassado(String dadoPassado) {
        this.dadoPassado = dadoPassado;
    }

    //variaveis auxiliares
    //Importando DAO no controller
    private AdministradorDAO administradorDAO = new AdministradorDAO();
    //Importando o model no controller 
    private Administrador administrador;
    private boolean incluindo = true;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txtUsuario.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, 
                    Boolean oldValue, Boolean newValue) {
                if(!newValue) {
                    pwSenha.requestFocus();
                }
            }    
        });
        txtSenha.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, 
                    Boolean oldValue, Boolean newValue) {
                if(!newValue) {
                    ckSenha.requestFocus();
                }
            }    
        });
        btnVoltar.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, 
                    Boolean oldValue, Boolean newValue) {
                if(!newValue) {
                    txtUsuario.requestFocus();
                }
            }    
        });
    }
                

    @FXML
    private void btnConfirmar_Click(ActionEvent event) throws IOException {
        //pega o login no text e joga para um objeto
        //para ser pesquisado
        String login = txtUsuario.getText();
        String senha = pwSenha.getText();
                
        try {
            // Chama o método buscaPorLoginSenha da sua DAO para verificar as credenciais
            Administrador administradorAutenticado = administradorDAO.buscaPorLoginSenha(login, senha);
                                
            // Verifica se o administrador foi autenticado com sucesso
            if (administradorAutenticado != null) {
                // Autenticação bem-sucedida, faça o que desejar aqui
                // Por exemplo, redirecione para a próxima tela
                mensagem("Login bem-sucedido!");
                Administrador menu = new Administrador(1);
                menu.startMenu(new Stage());
                               
                // Código para redirecionar para a próxima tela...
            } else {
                // Autenticação falhou, exiba uma mensagem de erro
                mensagem("Credenciais inválidas. Verifique seu login e senha.");
            }
        } catch (SQLException ex) {
            mensagem("Erro na autenticação: " + ex.getMessage());
        }

    }

    private void mensagem(String msg) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Mensagem");
        alerta.setHeaderText(msg);
        alerta.setContentText("");

        alerta.showAndWait(); //exibe a mensage
    }

    @FXML
    //fecha a tela atual
    private void btnVoltar_Click(ActionEvent event) {
        Stage stage = (Stage) btnVoltar.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void ckSenha_Change(ActionEvent event) {
       
       
    
    }


   
}
