/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.fatec.model;

import br.com.fatec.App;
import br.com.fatec.controller.GerenciarSessoesController;
import br.com.fatec.controller.LoginAdmController;
import static br.com.fatec.model.Administrador.setStage;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
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
    private Date dataI;
    private Date dataF;
    private String horario;

    public Sessoes() {
    }

   
    public void start(Stage tela) throws IOException {
        setStage(tela);

        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("view/GerenciarSessões.fxml"));
        Parent root = fxmlLoader.load();
        GerenciarSessoesController controller = fxmlLoader.getController();
        controller.setDadoPassado("Funcionou");


        Scene scene = new Scene(root, 640, 480);
 

        tela.setScene(scene);
        tela.show();
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

    public Sessoes(int idSessao, Filme filme, Sala sala, Date dataI, Date dataF, String horario) {
        this.idSessao = idSessao;
        this.filme = filme;
        this.sala = sala;
        this.dataI = dataI;
        this.dataF = dataF;
        this.horario = horario;
    }

    public Date getDataI() {
        return dataI;
    }

    public void setDataI(Date dataI) {
        this.dataI = dataI;
    }

    public Date getDataF() {
        return dataF;
    }

    public void setDataF(Date dataF) {
        this.dataF = dataF;
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

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    @Override
    public String toString() {
        return horario;
    }

}
