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
import javafx.scene.control.ListCell;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.StringConverter;

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
    private Sala sala;

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

    @FXML

    private void carregar_Combo() {
        FilmeDAO filmeDao = new FilmeDAO();
        try {
            Collection<Filme> listFilm = filmeDao.lista("");

            // Limpa a ObservableList antes de adicionar novos itens
            listaFilme.clear();
            listaFilme.addAll(listFilm);

            // Configura os itens da ComboBox
            cb_Filme.setItems(listaFilme);

            // Configura o StringConverter para exibir o ID
            cb_Filme.setConverter(new StringConverter<Filme>() {
                @Override
                public String toString(Filme filme) {
                    return filme == null ? "" : String.valueOf(filme.getIdFilme());
                }

                @Override
                public Filme fromString(String string) {
                    // Implementação necessária apenas se você quiser converter o texto de volta para um objeto Filme
                    return null;
                }
            });

            // Configura o CellFactory para exibir o ID
            cb_Filme.setCellFactory(comboBox -> new ListCell<Filme>() {
                @Override
                protected void updateItem(Filme filme, boolean empty) {
                    super.updateItem(filme, empty);
                    if (empty || filme == null) {
                        setText("");
                    } else {
                        setText(String.valueOf(filme.getIdFilme()));
                    }
                }
            });
        } catch (SQLException ex) {
            mensagem(ex.getMessage());
        }
    }

    @FXML
    private void cb_Filme_Change(ActionEvent event) {
        if (cb_Filme.getValue() != null) {
            txt_FilmeId.setText(String.valueOf(cb_Filme.getValue().getNomeFilme()));

        } else {
            txt_FilmeId.setText("");
        }

    }

    private Sessoes carregar_Model_Sessao() {
        Sessoes modelS = new Sessoes();

        modelS.setIdSessao(Integer.parseInt(txt_SessaoId.getText()));
        modelS.setDataI(txt_DataInicio.getText());
        modelS.setDataF(txt_DataFim.getText());
        modelS.setHorario(txt_Horas.getText());

        // Carregar sala
        modelS.setSala(carregarModelSala());

        // Carregar filme
        modelS.setFilme(carregar_Model_Filme());

        return modelS;
    }

    private Sala carregarModelSala() {
        Sala modelSala = new Sala();
        modelSala.setNumeroSala(Integer.parseInt(txt_Sala.getText()));
        // Outras configurações da sala, se necessário
        return modelSala;
    }

    private Filme carregar_Model_Filme() {
        Filme filmeS = new Filme();
        filmeS.setIdFilme(cb_Filme.getValue().getIdFilme());
        filmeS.setNomeFilme(txt_FilmeId.getText());

        return filmeS;
    }

    //private Sessoes carregar_model() {
    //Sessoes model = new Sessoes();
    //int idSessao = Integer.parseInt(txt_SessaoId.getText());
    //int numeroSala = Integer.parseInt(txt_Sala.getText());
    //}
    private Sessoes carregar_Model_Sessao_insere() {
        Sessoes modelS = new Sessoes();

        modelS.setIdSessao(Integer.parseInt(txt_SessaoId.getText()));
        modelS.setDataI(txt_DataInicio.getText());
        modelS.setDataF(txt_DataFim.getText());
        modelS.setHorario(txt_Horas.getText());
        // Carregar sala
        modelS.setSala(carregarModelSala());

        // Carregar filme
        modelS.setFilme(carregar_Model_Filme());

        return modelS;
    }

    private Sala carregarModelSala_Insere() {
        Sala modelSala = new Sala();
        modelSala.setNumeroSala(Integer.parseInt(txt_Sala.getText()));
        // Outras configurações da sala, se necessário
        return modelSala;
    }

    private Filme carregar_Model_Filme_insere() {
        Filme filmeS = new Filme();
        filmeS.setIdFilme(cb_Filme.getValue().getIdFilme());
        filmeS.setNomeFilme(txt_FilmeId.getText());

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
    private void btn_gravar_Click(ActionEvent event) {

        if (!validarDados()) {
            mensagem("Por favor, preencha todos os campos.");
            return; // Sai do método
        }

        sessao = carregar_Model_Sessao(); // Carrega o modelo de sessão
        if (sessao == null) {
            mensagem("Erro ao carregar dados da sessão.");
            return;
        }

        try {
            if (incluindo) { // Se a operação geral é de inclusão
                if (sessaoDAO.insere(sessao)) {
                    mensagem("Sessao incluído com sucesso!");
                    cb_Filme.requestFocus();
                } else {
                    mensagem("Erro na inclusão.");
                }
            } else { // Alterando
                if (sessaoDAO.altera(sessao)) {
                    mensagem("Filme alterado com sucesso!");
                    cb_Filme.requestFocus();
                } else {
                    mensagem("Erro na alteração.");
                }
            }
        } catch (SQLException ex) {
            mensagem("Erro na operação: " + ex.getMessage());
        }

        // Tudo certo, vamos incluir um novo filme
        limparCampos();
        habilitarInclusao(true);
    }

    @FXML
    private void btn_excluir_Click(ActionEvent event) {
        if (!validarDados()) {
            mensagem("Por favor, preencha todos os campos.");
            return; // Sai do método
        }

        filme = new Filme();
        //filme.setIdFilme(Integer.parseInt(cbId.getValue()));
        filme.setIdFilme(cb_Filme.getValue().getIdFilme());

        sessao = carregar_Model_Sessao(); // Carrega o modelo de sessão

        System.out.println("teste   ");

        try {
            // Se a operação geral é de exc
            if (sessaoDAO.remove(sessao)) {
                mensagem("Sessao excluido com sucesso!");
                cb_Filme.requestFocus();
            } else {
                mensagem("Filme algum erro para exclusão");
            }

        } catch (SQLException ex) {
            mensagem("Erro na operação: " + ex.getMessage());
        }

        // Tudo certo, vamos incluir um novo filme
        limparCampos();
        habilitarInclusao(true);

    }

    @FXML
    private void btn_visualizarSessoes_Click(ActionEvent event) {
    }

    @FXML
    private void btn_voltar_Click(ActionEvent event) {
        Stage stage = (Stage) btn_voltar.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void btn_Pesquisa_Click(ActionEvent event) throws SQLException {
        sessao = new Sessoes();
        //filme.setIdFilme(Integer.parseInt(cbId.getValue()));
        sessao.setIdSessao(Integer.parseInt(txt_SessaoId.getText()));

        try {
            //faz a procura
            sessao = sessaoDAO.buscaID(sessao);
            if (sessao != null) { //achou
                carregar_View(sessao);
                incluindo = false;
                habilitarInclusao(false);
            } else {
                mensagem("Filme não encontrado");
                //envia o foco para o text da placa
                txt_SessaoId.requestFocus();
                incluindo = true;
            }
        } catch (SQLException ex) {
            mensagem("Erro na procura do Filme: "
                    + ex.getMessage());
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
        return !txt_SessaoId.getText().isEmpty()
                && !txt_FilmeId.getText().isEmpty()
                && !txt_Sala.getText().isEmpty()
                && !txt_DataInicio.getText().isEmpty()
                && !txt_DataFim.getText().isEmpty()
                && !txt_Horas.getText().isEmpty()
                && cb_Filme.getValue() != null;
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
