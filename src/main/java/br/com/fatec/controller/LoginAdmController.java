/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package br.com.fatec.controller;

import br.com.fatec.DAO.AdministradorDAO;
import br.com.fatec.model.Administrador;
import java.net.URL;
import java.sql.SQLException;
import javafx.fxml.FXML;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Fernanda
 */
public class LoginAdmController implements Initializable {

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
    private PasswordField txtSenha;

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
        //     

    }

    @FXML
    private void btnConfirmar_Click(ActionEvent event) {
        //pega o login no text e joga para um objeto
        //para ser pesquisado

        administrador = new Administrador(0,"","");
        administrador.setLogin(txtUsuario.getText());
        try {
            //faz uma procura 
            administrador = administradorDAO.buscaID(administrador);

            //Verifica se achou
            if (administrador == null) {
                System.out.println("DEU BOM CARAI");
            } else {
                mensagem("Login nao encontrado");
                txtUsuario.requestFocus();
            }
        } catch (SQLException ex) {
            mensagem("Erro na procura da Placa: "
                    + ex.getMessage());
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
    private void btnVoltar_Click(ActionEvent event) {
    }

}
