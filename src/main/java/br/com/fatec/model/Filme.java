/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.fatec.model;

import br.com.fatec.App;
import br.com.fatec.controller.GerenciarFilmeController;
import br.com.fatec.controller.VisualizarFilmesController;
import static br.com.fatec.model.Administrador.setStage;
import java.io.IOException;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Fernanda
 */
public class Filme {

    private final SimpleBooleanProperty selecionado;
    private final SimpleIntegerProperty idFilme;
    private final SimpleStringProperty nomeFilme, duracao, sinopse, genero, classificacao;

    public Filme() {
        this.selecionado = new SimpleBooleanProperty(false);
        this.idFilme = new SimpleIntegerProperty(0);
        this.nomeFilme = new SimpleStringProperty("");
        this.duracao = new SimpleStringProperty("");
        this.sinopse = new SimpleStringProperty("");
        this.genero = new SimpleStringProperty("");
        this.classificacao = new SimpleStringProperty("");
    }

    public Filme(int idFilme, String nomeFilme, String duracao, String sinopse, String genero, String classificacao) {
        this.selecionado = new SimpleBooleanProperty(false);
        this.idFilme = new SimpleIntegerProperty(idFilme);
        this.nomeFilme = new SimpleStringProperty(nomeFilme);
        this.duracao = new SimpleStringProperty(duracao);
        this.sinopse = new SimpleStringProperty(sinopse);
        this.genero = new SimpleStringProperty(genero);
        this.classificacao = new SimpleStringProperty(classificacao);
    }
    public SimpleBooleanProperty selecionadoProperty() {
        return selecionado;
    }

    public SimpleIntegerProperty idFilmeProperty() {
        return idFilme;
    }
    public SimpleStringProperty nomeFilmeProperty() {
        return nomeFilme;
    }
    public SimpleStringProperty duracaoProperty() {
        return duracao;
    }
    public SimpleStringProperty sinopseProperty() {
        return sinopse;
    }
    public SimpleStringProperty generoProperty() {
        return genero;
    }
    public SimpleStringProperty classificacaoProperty() {
        return genero;
    }

    public int getIdFilme() {
        return idFilme.get();
    }
    public void setIdFilme(int idFilme) {
        this.idFilme.set(idFilme);
    }

    public String getNomeFilme() {
        return nomeFilme.get();
    }
    public void setNomeFilme(String nomeFilme) {
        this.nomeFilme.set(nomeFilme);
    }

    public String getDuracao() {
        return duracao.get();
    }
    public void setDuracao(String duracao) {
        this.duracao.set(duracao);
    }

    public String getSinopse() {
        return sinopse.get();
    }
    public void setSinopse(String sinopse) {
        this.sinopse.set(sinopse);
    }

    public String getGenero() {
        return genero.get();
    }
    public void setGenero(String genero) {
        this.genero.set(genero);
    }

    public String getClassificacao() {
        return classificacao.get();
    }
    public void setClassificacao(String classificacao) {
        this.classificacao.set(classificacao);
    }
    public boolean isSelecionado() {
        return selecionado.get();
    }

    public void setSelecionado(boolean selecionado) {
        this.selecionado.set(selecionado);
    }
    
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
    public void startVer(Stage tela) throws IOException {
        setStage(tela);
        
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("view/VisualizarFilmes.fxml"));
        Parent root = fxmlLoader.load();
        VisualizarFilmesController controller = fxmlLoader.getController();
        controller.setDadoPassado("Funcionou");

        Scene scene = new Scene(root);
        
        tela.setScene(scene);
        tela.show();
    }
    
}