package com.pl.game.view.controller;

import java.io.File;
import java.io.IOException;

import com.pl.game.model.client.Client;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;

public class MainWindowController {
	@FXML
	private Button playButton;
	@FXML
	private AnchorPane mainPane;
	@FXML
	TextField name;
	private final static String SEPARATOR = File.separator;

	@FXML
	public void initialize() {
		setBackgroundImage();
	}

	public void playButtonClicked() {
		Scene scene = mainPane.getScene();
		try {
			Pane pane = (Pane) FXMLLoader.load(
					getClass().getClassLoader().getResource("com" + SEPARATOR + "pl" + SEPARATOR + "game" + SEPARATOR
							+ "main" + SEPARATOR + "resources" + SEPARATOR + "FXML" + SEPARATOR + "Board.fxml"));

			scene.setRoot(pane);
			String playerName = name.getText();
			Client client = new Client(/* "localhost" */ "10.3.164.87", 8080, pane, playerName);
			client.initStream();
			client.startReciving();
			client.startSending();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void setBackgroundImage() {
		Image img = new Image("com" + SEPARATOR + "pl" + SEPARATOR + "game" + SEPARATOR + "main" + SEPARATOR
				+ "resources" + SEPARATOR + "Images" + SEPARATOR + "background.jpg");
		BackgroundImage myBI = new BackgroundImage(img, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		mainPane.setBackground(new Background(myBI));
	}
}
