package com.pl.game.main;

import java.io.File;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {
	private final static String SEPARATOR = File.separator;

	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = (AnchorPane) FXMLLoader.load(
					getClass().getClassLoader().getResource("com" + SEPARATOR + "pl" + SEPARATOR + "game" + SEPARATOR
							+ "main" + SEPARATOR + "resources" + SEPARATOR + "FXML" + SEPARATOR + "MainWindow.fxml"));
			Scene scene = new Scene(root, 1000, 800);
			primaryStage.setResizable(false);
			scene.getStylesheets()
					.add(getClass().getClassLoader()
							.getResource("com" + SEPARATOR + "pl" + SEPARATOR + "game" + SEPARATOR + "main" + SEPARATOR
									+ "resources" + SEPARATOR + "CSS" + SEPARATOR + "application.css")
							.toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setTitle("Balls Destroyer");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
