/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.fatec.model;

import br.com.fatec.App;
import br.com.fatec.controller.GerenciarSessaoController;
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
public class Sessoes {

    private int idSessao;
    private Filme filme;
    private Sala sala;
    private String dataI;
    private String dataF;
    private String horario;

    public Sessoes() {
    }
 
    public void start(Stage tela) throws IOException {
        setStage(tela);
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("view/GerenciarSessao.fxml"));   
        Parent root = fxmlLoader.load();
        GerenciarSessaoController controller = fxmlLoader.getController();
        controller.setDadoPassado("Funcionou");
        Scene scene = new Scene(root);
        tela.setScene(scene);
        tela.show();
    }

    @Override
    public String toString() {
        return "Sessoes{" + "idSessao=" + idSessao + ", filme=" + filme + ", sala=" + sala + ", dataI=" + dataI + ", dataF=" + dataF + ", horario=" + horario + '}';
    }

    public String getDataI() {
        return dataI;
    }

    public void setDataI(String dataI) {
        this.dataI = dataI;
    }

    public String getDataF() {
        return dataF;
    }

    public void setDataF(String dataF) {
        this.dataF = dataF;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Sessoes(int idSessao, Filme filme, Sala sala, String dataI, String dataF, String horario) {
        this.idSessao = idSessao;
        this.filme = filme;
        this.sala = sala;
        this.dataI = dataI;
        this.dataF = dataF;
        this.horario = horario;
    }




    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.idSessao;
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
        final Sessoes other = (Sessoes) obj;
        return this.idSessao == other.idSessao;
    }

    public Sessoes(Filme filme) {
        this.filme = filme;
    }

    public int getIdSessao() {
        return idSessao;
    }

    public void setIdSessao(int idSessao) {
        this.idSessao = idSessao;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }




   

}
