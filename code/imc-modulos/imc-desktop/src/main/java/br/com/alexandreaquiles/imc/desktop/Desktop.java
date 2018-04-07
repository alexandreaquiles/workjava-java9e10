package br.com.alexandreaquiles.imc.desktop;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Desktop extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Pane pane = FXMLLoader.load(Desktop.class.getResource("/fx/tela_principal.fxml"));
		
		Scene scene = new Scene(pane);
		scene.getStylesheets().add("/fx/principal.css");
		stage.setTitle("IMC");
        stage.setScene(scene);
        stage.show();
	}

}
