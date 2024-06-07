/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package br.com.fatec.controller;

import br.com.fatec.DAO.FilmeDAO;
import br.com.fatec.DAO.GerenciarSesõesDAO;
import br.com.fatec.model.Filme;
import br.com.fatec.model.Sala;
import br.com.fatec.model.Sessoes;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Collection;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Fernanda
 */
public class GerenciarSessõesController implements Initializable {

    @FXML
    private Label lblTitulo;
    @FXML
    private Label lblSessao;
    @FXML
    private TextField txtId;
    @FXML
    private Label lblFilme;
    @FXML
    private TextField txtIdFilme;
    @FXML
    private ComboBox<Filme> cbFilme;
    @FXML
    private Label lblSala;
    @FXML
    private TextField txtSala;
    @FXML
    private Label lblDataI;
    @FXML
    private DatePicker dtDataI;
    @FXML
    private Label lblHorario;
    @FXML
    private Label lblDataF;
    @FXML
    private DatePicker dtDataF;
    @FXML
    private ComboBox<Sessoes> cbHorario;
    @FXML
    private Button btnGravar;
    @FXML
    private Button btnExcluir;
    @FXML
    private Button btnVoltar;

    private String dadoPassado;
    @FXML
    private Button btnVisualizarSessoes;

    public String getDadoPassado() {
        return dadoPassado;
    }

    public void setDadoPassado(String dadoPassado) {
        this.dadoPassado = dadoPassado;
    }

    //variaveis auxiliares 
    private GerenciarSesõesDAO GerenciarSessõesDAO = new GerenciarSesõesDAO();
    private Sessoes sessoes; ///model para 
    private ObservableList<Filme> listafilme
            = FXCollections.observableArrayList();
    private ObservableList<Sessoes> listahorario
            = FXCollections.observableArrayList();

    //para saber se a operação é de inclusão ou não
    private boolean incluindo = true;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        carregar_Combo_filme();
        carregar_Combo_horario();
    }

    private void carregar_Combo_filme() {
        FilmeDAO filmeDao = new FilmeDAO();
        try {
            //busca todos os registros no banco para uma Coleção
            Collection<Filme> listFilm = filmeDao.lista("");
            //colocar a lista gerada pela DAO dentro da COMBO
            listafilme.addAll(listFilm);
            //informa que a combo possui uma lista
            cbFilme.setItems(listafilme);

        } catch (SQLException ex) {
            mensagem(ex.getMessage());
        }
    }

    private void carregar_Combo_horario() {
        GerenciarSesõesDAO gerDao = new GerenciarSesõesDAO();
        try {
            //busca todos os registros no banco para uma Coleção
            Collection<Sessoes> listhoras = gerDao.listaHoras("");
            // Limpa a lista existente
            listahorario.clear();
            //colocar a lista gerada pela DAO dentro da COMBO
            listahorario.addAll(listhoras);
            //informa que a combo possui uma lista
            cbHorario.setItems(listahorario);

        } catch (SQLException ex) {
            mensagem(ex.getMessage());
        }
    }

    @FXML
    private void cbFilme_Change(ActionEvent event) {
        if (cbFilme.getValue() != null) {
            txtIdFilme.setText(String.valueOf(cbFilme.getValue().getIdFilme()));

        } else {
            txtIdFilme.setText("");
        }
    }

    @FXML
    private void mensagem(String msg) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Mensagem");
        alerta.setHeaderText(msg);
        alerta.setContentText("");

        alerta.showAndWait(); //exibe a mensage
    }

    @FXML
    private void btnGravar_Click(ActionEvent event) {
        //verificar se dados estão OK
        if (!validarDados()) {
            mensagem("Por favor preencha todos os campos");
            return; //sai fora do método
        }

        //move dados da tela para model
        sessoes = carregar_Model();

        try {
            if (incluindo) { //se a operação geral é de inclusão
                if (GerenciarSessõesDAO.insere(sessoes)) {
                    mensagem("Veículo incluído com sucesso!!!");
                    txtId.requestFocus();
                } else {
                    mensagem("Erro na Inclusão");
                }
            } else { //alterando
                if (GerenciarSessõesDAO.altera(sessoes)) {
                    mensagem("Veículo alterado com sucesso!!!");
                    txtId.requestFocus();
                } else {
                    mensagem("Erro na Alteração");
                }
            }
        } catch (SQLException ex) {
            mensagem("Erro na Inclusão\n" + ex.getMessage());
        }

        //tudo certo, vamos incluir um veiculo novo
        limparCampos();
        habilitarInclusao(true);
    }

    @FXML
    private void btnExcluir_Click(ActionEvent event) {
    }

    @FXML
    private void btnVisualizarSessoes_Click(ActionEvent event) {
    }

    private Sessoes carregar_Model() {
        Sessoes model = new Sessoes(cbFilme.getValue());

        try {
            model.setIdSessao(Integer.parseInt(txtId.getText()));
        } catch (NumberFormatException e) {
            System.err.println("ID inválido: " + txtId.getText());
            return null;
        }

        try {
            int filmeId = Integer.parseInt(txtIdFilme.getText());
            Filme filme = getFilmeById(filmeId);
            if (filme != null) {
                model.setFilme(filme);
            } else {
                System.err.println("Filme não encontrado para o ID: " + txtIdFilme.getText());
                return null;
            }
        } catch (NumberFormatException e) {
            System.err.println("ID do filme inválido: " + txtIdFilme.getText());
            return null;
        }

        try {
            String numeroSala = txtSala.getText();
            Sala sala = new Sala();
            model.setSala(sala);
        } catch (NumberFormatException e) {
            System.err.println("Valor da sala inválido: " + txtSala.getText());
            return null;
        }

        return model;
    }

    private void carregar_View(Sessoes model) {
        txtId.setText(String.valueOf(model.getIdSessao()));
        txtIdFilme.setText(String.valueOf(model.getFilme().getIdFilme()));
        txtSala.setText(String.valueOf(model.getSala().getNumeroSala()));
        // Adicione aqui o código para atualizar os outros campos conforme necessário

    }

    private Filme getFilmeById(int id) {
        for (Filme filme : listafilme) {
            if (filme.getIdFilme() == id) {
                return filme;
            }
        }
        return null; // Retorna null se não encontrar
    }

    private boolean validarDados() {
        if (txtId.getText().length() == 0
                || txtIdFilme.getText().length() == 0
                || cbFilme.getSelectionModel().isEmpty()
                || txtSala.getText().length() == 0
                || dtDataI.getValue() != null
                || dtDataF.getValue() != null
                || cbHorario.getSelectionModel().isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    private void limparCampos() {
        txtIdFilme.setText("");
        txtSala.setText("");
        cbFilme.getSelectionModel().clearSelection();
        dtDataI.setValue(null);
        dtDataF.setValue(null);
        cbHorario.getSelectionModel().clearSelection();
        //manda o foco para a placa do veículoi
        txtIdFilme.requestFocus();
    }

    private void habilitarInclusao(boolean inc) {
        btnExcluir.setDisable(inc);
    }

    @FXML
    private void btnVoltar_Click(ActionEvent event) {
    }
}
