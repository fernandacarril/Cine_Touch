/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.fatec.model;

import br.com.fatec.App;
import br.com.fatec.controller.GerenciarFilmeController;
import br.com.fatec.controller.LoginAdmController;
import br.com.fatec.controller.TelaAdmController;
import java.io.IOException;
import java.util.Objects;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Fernanda
 */
public class Administrador extends Usuario  {
    private String login, senha;
    public static Stage tela;

    public Administrador(int idUsuario) {
        super(idUsuario);
    }

    public Administrador(String login, int idUsuario) {
        super(idUsuario);
        this.login = login;
    }



   
    public void startMenu(Stage tela) throws IOException {
        setStage(tela);
        
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("view/TelaAdm.fxml"));
        Parent root = fxmlLoader.load();
        TelaAdmController controller = fxmlLoader.getController();
        controller.setDadoPassado("Funcionou");

        Scene scene = new Scene(root);
        
        tela.setScene(scene);
        tela.show();
    }
    public void start(Stage tela) throws IOException {
        setStage(tela);
        
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("view/LoginAdm.fxml"));
        Parent root = fxmlLoader.load();
        LoginAdmController controller = fxmlLoader.getController();
        controller.setDadoPassado("Funcionou");

        Scene scene = new Scene(root);
        
        tela.setScene(scene);
        tela.show();        
    }
    
    public void start2 (Stage tela) throws IOException {
        setStage(tela);
        
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("view/GerenciarFilme.fxml"));
        Parent root = fxmlLoader.load();
        GerenciarFilmeController controller = fxmlLoader.getController();
        controller.setDadoPassado("Funcionou");

        Scene scene = new Scene(root, 640, 480);
        
        tela.setScene(scene);
        tela.show();        
    }
    
    
    
    public static void setStage(Stage t) {
        tela = t;
    }
    
    @Override
    public String toString() {
        return getLogin();
    }
    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.login);
        hash = 11 * hash + Objects.hashCode(this.senha);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Administrador other = (Administrador) obj;
        if (!Objects.equals(this.login, other.login)) {
            return false;
        }
        return Objects.equals(this.senha, other.senha);
    }
    
    public Administrador(int idUsuario, String login, String senha) {
        super(idUsuario);
        this.login = login;
        this.senha = senha;
    }
        
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
 
}   
