package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Valor;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Valor valor = new Valor();
		valor.atualizarValores();
		
		Parent root = FXMLLoader.load(getClass().getResource("/view/fxmls/Home.fxml"));
		primaryStage.setResizable(false);
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
		primaryStage.setResizable(false);
		primaryStage.show();

	}

}
