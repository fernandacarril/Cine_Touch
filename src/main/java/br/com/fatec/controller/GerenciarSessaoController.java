/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package br.com.fatec.controller;

import br.com.fatec.DAO.FilmeDAO;
import br.com.fatec.DAO.SessaoDAO;
import br.com.fatec.model.Filme;
import br.com.fatec.model.Sala;
import br.com.fatec.model.Sessoes;
import java.net.URL;
import java.sql.SQLException;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author AMD
 */
public class GerenciarSessaoController implements Initializable {

    @FXML
    private TextField txt_SessaoId;
    @FXML
    private TextField txt_DataInicio;
    @FXML
    private TextField txt_FilmeId;
    @FXML
    private TextField txt_DataFim;
    @FXML
    private TextField txt_Horas;
    @FXML
    private TextField txt_Sala;
    @FXML
    private ComboBox<Filme> cb_Filme;
    @FXML
    private Button btn_gravar;
    @FXML
    private Button btn_excluir;
    @FXML
    private Button btn_visualizarSessoes;
    @FXML
    private Button btn_voltar;
    @FXML
    private Button btn_Pesquisa;

    private String dadoPassado;

    public String getDadoPassado() {
        return dadoPassado;
    }

    public void setDadoPassado(String dadoPassado) {
        this.dadoPassado = dadoPassado;
    }

    private SessaoDAO sessaoDAO = new SessaoDAO();
    private Sessoes sessao;
    private FilmeDAO filmeDAO = new FilmeDAO(); 
    private Filme filme;
    private ObservableList<Filme> listaFilme
            = FXCollections.observableArrayList();
    private boolean incluindo = true;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        carregar_Combo();
    }


    private Sessoes carregar_Model_Sessao() {
        Sessoes modelS = new Sessoes();
        try {
            modelS.setIdSessao(Integer.parseInt(txt_SessaoId.getText()));
            modelS.setDataI(txt_DataInicio.getText());
            modelS.setDataF(txt_DataFim.getText());
            modelS.setHorario(txt_Horas.getText());
        } catch (NumberFormatException e) {
            // Exiba uma mensagem de erro apropriada
            System.out.println("Erro: Um dos campos numéricos contém um valor inválido.");
            e.printStackTrace();
        }
       return null;
    }

    private Sessoes carregar_Model() {
        // Cria uma nova instância de Sessoes
        Sessoes model = new Sessoes();


        return model;
    }

    //private Sessoes carregar_model() {
        //Sessoes model = new Sessoes();
        //int idSessao = Integer.parseInt(txt_SessaoId.getText());
        //int numeroSala = Integer.parseInt(txt_Sala.getText());
        
    //}

    private Sessoes carregar_Model_insere() {
         // Cria uma nova instância de Sessoes
        Sessoes model = new Sessoes();

        // Define o idSessao
        model.setIdSessao(Integer.parseInt(txt_SessaoId.getText()));

        // Cria uma instância de Sala e configura os valores
        Sala sala = new Sala();
        sala.setNumeroSala(Integer.parseInt(txt_Sala.getText())); // Presumo que txt_Sala contenha o número da sala

        // Cria uma instância de Filme e configura os valores
        Filme filmes = new Filme();
        filmes.setIdFilme(Integer.parseInt(txt_FilmeId.getText())); // Presumo que txt_FilmeId contenha o id do filme

        // Define sala e filme no modelo
        model.setSala(sala);
        model.setFilme(filmes);

        // Define as outras propriedades
        model.setDataI(txt_DataInicio.getText());
        model.setDataF(txt_DataFim.getText());
        model.setHorario(txt_Horas.getText());
        return null;
    }

    private Filme carregar_Model_Filme() {
        Filme filmeS = new Filme();
        try {
            filmeS.setIdFilme(Integer.parseInt(txt_FilmeId.getText()));
            filmeS.setNomeFilme(txt_FilmeId.getText());
        } catch (NumberFormatException e) {
            // Exiba uma mensagem de erro apropriada
            System.out.println("Erro: Um dos campos numéricos contém um valor inválido.");
            e.printStackTrace();
        }
        return filmeS;
    }

    private Sessoes carregar_Model__Sessao_insere() {
        Sessoes modelS = new Sessoes();
        try {
            modelS.setIdSessao(Integer.parseInt(txt_SessaoId.getText()));
            modelS.setDataI(txt_DataInicio.getText());
            modelS.setDataF(txt_DataFim.getText());
            modelS.setHorario(txt_Horas.getText());
        } catch (NumberFormatException e) {
            // Exiba uma mensagem de erro apropriada
            System.out.println("Erro: Um dos campos numéricos contém um valor inválido.");
            e.printStackTrace();
        }

        return modelS;
    }

    private Filme carregar_model_filme_insere() {
        Filme filmeS = new Filme();
        try {
            filmeS.setIdFilme(Integer.parseInt(txt_FilmeId.getText()));
            filmeS.setNomeFilme(txt_FilmeId.getText());
        } catch (NumberFormatException e) {
            // Exiba uma mensagem de erro apropriada
            System.out.println("Erro: Um dos campos numéricos contém um valor inválido.");
            e.printStackTrace();
        }
        return filmeS;
    }

    private void carregar_View(Sessoes model) {
        // Define o ID da Sessão no campo de texto
        txt_SessaoId.setText(String.valueOf(model.getIdSessao()));

        // Define a sala no campo de texto
        if (model.getSala() != null) {
            txt_Sala.setText(String.valueOf(model.getSala().getNumeroSala()));
        }

        // Define os outros campos de texto
        txt_DataInicio.setText(model.getDataI());
        txt_DataFim.setText(model.getDataF());
        txt_Horas.setText(model.getHorario());

        // Define o filme selecionado na ComboBox
        Filme filmeSelecionado = model.getFilme();
        if (filmeSelecionado != null) {
            for (Filme filme : cb_Filme.getItems()) {
                if (filme.getIdFilme() == filmeSelecionado.getIdFilme()) {
                    cb_Filme.setValue(filme);
                    break; // Interrompe o loop após encontrar o Filme correspondente
                }
            }
        }
        // Define o ID do filme no campo de texto
        txt_FilmeId.setText(String.valueOf(filmeSelecionado != null ? filmeSelecionado.getIdFilme() : ""));
    }

    @FXML
    private void cb_Filme_Change(ActionEvent event) {
        if (cb_Filme.getValue() != null) {
            txt_FilmeId.setText(String.valueOf(cb_Filme.getValue().getNomeFilme()));

        } else {
            txt_FilmeId.setText("");
        }

    }

    @FXML
    private void btn_gravar_Click(ActionEvent event) {

        if (!validarDados()) {
            mensagem("Por favor preencha todos os campos");
            return; //sai fora do método
        }
        sessao = carregar_Model_Sessao();
        filme = carregar_Model_Filme();
        try {
            if (incluindo) { //se a operação geral é de inclusão
                sessao = carregar_Model_Sessao();
                if (sessaoDAO.insere(sessao)&& filmeDAO.insere(filme)) {
                    mensagem("Filme incluido com sucesso!!");
                    cb_Filme.requestFocus();
                } else {
                    mensagem("Erro na Inclusão");
                }
            } else { //alterando
                sessao = carregar_Model_Sessao();
                if (sessaoDAO.altera(sessao)) {
                    mensagem("Filme alterado com sucesso!!!");
                    cb_Filme.requestFocus();
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
    private void btn_excluir_Click(ActionEvent event) {
    }

    @FXML
    private void btn_visualizarSessoes_Click(ActionEvent event) {
    }

    @FXML
    private void btn_voltar_Click(ActionEvent event) {
    }

    @FXML
    private void btn_Pesquisa_Click(ActionEvent event) {
    }

    private void carregar_Combo() {
        FilmeDAO Filmedao = new FilmeDAO();
        try {            //busca todos os registros no banco para uma Coleção
            Collection<Filme> listFilm = Filmedao.lista("");
            //colocar a lista gerada pela DAO dentro da COMBO
            listaFilme.addAll(listFilm);
            //informa que a combo possui uma lista
            cb_Filme.setItems(listaFilme);
        } catch (SQLException ex) {
            mensagem(ex.getMessage());
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

    private boolean validarDados() {
        if (txt_SessaoId.getText().length() == 0
                || txt_FilmeId.getText().length() == 0
                || cb_Filme.getSelectionModel().isEmpty()
                || txt_Sala.getText().length() == 0
                || txt_DataInicio.getText().length() == 0
                || txt_DataFim.getText().length() == 0
                || txt_Horas.getText().length() == 0) {
            return false;
        } else {
            return true;
        }
    }
    //private boolean validarDados() {


    //}

    private void habilitarInclusao(boolean inc) {
        btn_excluir.setDisable(inc);
    }

    private void limparCampos() {
        txt_FilmeId.setText("");
        txt_Sala.setText("");
        cb_Filme.getSelectionModel().clearSelection();
        txt_DataInicio.setText("");
        txt_DataFim.setText("");
        txt_Horas.setText("");
        //manda o foco para a placa do veículoi
        txt_FilmeId.requestFocus();
    }

}
