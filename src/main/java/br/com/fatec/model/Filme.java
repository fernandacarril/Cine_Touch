/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.fatec.model;

import br.com.fatec.App;
import br.com.fatec.controller.GerenciarFilmeController;
import static br.com.fatec.model.Administrador.setStage;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Fernanda
 */
public class Filme {
    private int idFilme;
    private String nomeFilme, duracao, sinopse;
    private String genero;
    private String classificacao;

    
    
    public void start(Stage tela) throws IOException {
        setStage(tela);
        
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("view/GerenciarFilme.fxml"));
        Parent root = fxmlLoader.load();
        GerenciarFilmeController controller = fxmlLoader.getController();
        controller.setDadoPassado("Funcionou");

        Scene scene = new Scene(root);
        
        tela.setScene(scene);
        tela.show();
    }

    @Override
    public String toString() {
        return "" + this.idFilme;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.idFilme;
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
        final Filme other = (Filme) obj;
        return this.idFilme == other.idFilme;
    }
    
    public Filme() {
    }
    
    public Filme(int idFilme, String nomeFilme, String duracao, String genero, String classificacao, String sinopse) {
        this.idFilme = idFilme;
        this.nomeFilme = nomeFilme;
        this.duracao = duracao;
        this.genero = genero;
        this.classificacao = classificacao;
        this.sinopse = sinopse;
    }
    
    
    public int getIdFilme() {
        return idFilme;
    }

    public void setIdFilme(int idFilme) {
        this.idFilme = idFilme;
    }

    public String getNomeFilme() {
        return nomeFilme;
    }

    public void setNomeFilme(String nomeFilme) {
        this.nomeFilme = nomeFilme;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }
    
    
    
}
