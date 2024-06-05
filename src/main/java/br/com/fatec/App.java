package br.com.fatec;

import br.com.fatec.DAO.FilmeDAO;
import br.com.fatec.persistencia.Banco;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

/**
 * JavaFX App
 */
public class App extends Application {
    
    private static Scene scene;
    private static Stage stage; 

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("view/TelaInicial"));
        this.stage = stage;
        stage.setScene(scene);
        stage.show();
        testebanco();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    
    public static void fechar() {
        stage.close();
    }

//Criando chamada no banco de dados
  
    public void testebanco(){
        try {
            Banco.conectar();
            System.out.println("Conectado com Sucesso!!!");
            
            System.out.println("Testando Banco!!!");         
            
            System.out.println("Fechando...");
            Banco.desconectar();
            System.out.println("Fechado...");
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
    
    }

   
}