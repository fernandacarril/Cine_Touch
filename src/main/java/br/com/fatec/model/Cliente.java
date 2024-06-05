/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.fatec.model;

import br.com.fatec.App;
import br.com.fatec.controller.VisualizarSessoesController;
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
public class Cliente extends Usuario {
    private String cpf;
    public static Stage tela;

    public Cliente(String cpf, int idUsuario) {
        super(idUsuario);
        this.cpf = cpf;
    }

 


    
    
      public void start(Stage tela) throws IOException {
        setStage(tela);
        
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("view/VisualizarSessoes.fxml"));
        Parent root = fxmlLoader.load();
        VisualizarSessoesController controler = fxmlLoader.getController();
        controler.setDadoPassado("Funcionou");

        Scene scene = new Scene(root, 640, 480);
        
        tela.setScene(scene);
        tela.show();        

    }
   
    
    public static void setStage(Stage t) {
        tela = t;
    }
    
    

    @Override
    public String toString() {
        return "Cliente{" + "cpf=" + cpf + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.cpf);
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
        final Cliente other = (Cliente) obj;
        return Objects.equals(this.cpf, other.cpf);
    }
    
    

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
}
