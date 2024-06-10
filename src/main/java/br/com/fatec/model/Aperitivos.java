/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.fatec.model;

import br.com.fatec.App;
import br.com.fatec.controller.GerenciarAperitivosController;
import static br.com.fatec.model.Administrador.setStage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Fernanda
 */
public class Aperitivos {
    private static List<Aperitivos> listaAperitivos = new ArrayList<>();
    private int id;
    private String nome, descricao;
    private double valor, peso;
    public void start(Stage tela) throws IOException {
        setStage(tela);
        
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("view/GerenciarAperitivos.fxml"));
        Parent root = fxmlLoader.load();
        GerenciarAperitivosController controller = fxmlLoader.getController();
        controller.setDadoPassado("Funcionou");

        Scene scene = new Scene(root);
        
        tela.setScene(scene);
        tela.show();
    }

    @Override
    public String toString() {
        return getNome();
    }

    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + this.id;
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
        final Aperitivos other = (Aperitivos) obj;
        return this.id == other.id;
    }

    
    public Aperitivos() {
    }
    
    
    public Aperitivos(int id, String nome, String descricao, double valor, double peso) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.peso = peso;
    }
    public static List<Aperitivos> getListaAperitivos() {
        return listaAperitivos;
    }

    public static void inserirAperitivo(Aperitivos aperitivo) {
        listaAperitivos.add(aperitivo);
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
    
    public static void atualizarAperitivo(Aperitivos aperitivo) {
        for (Aperitivos a : listaAperitivos) {
            if (a.getId() == aperitivo.getId()) {
                a.setNome(aperitivo.getNome());
                a.setDescricao(aperitivo.getDescricao());
                a.setValor(aperitivo.getValor());
                a.setPeso(aperitivo.getPeso());
                break;
            }
        }
    }
    public static Aperitivos pesquisarAperitivo(int id) {
        for (Aperitivos aperitivo : listaAperitivos) {
            if (aperitivo.getId() == id) {
                return aperitivo;
            }
        }
        return null;
    }
    public static void excluirAperitivo(int id) {
        Aperitivos aperitivo = pesquisarAperitivo(id);
        if (aperitivo != null) {
            listaAperitivos.remove(aperitivo);
        }
    }

}
