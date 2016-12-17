package com.pl.game.model.client;

import java.io.IOException;
import java.io.ObjectInputStream;

import com.pl.game.model.data.DataToSendToClients;
import com.pl.game.view.controller.BoardController;

import javafx.application.Platform;
import javafx.scene.layout.Pane;

public class Recive implements Runnable {
	private ObjectInputStream objectInputStream;
	private BoardController boardController;
	private String playerName;
	private Pane boardPane;
	private boolean initalizeBoard = true;

	public Recive(ObjectInputStream objectInputStream, BoardController boardController, String playerName,
			Pane boardPane) {
		this.objectInputStream = objectInputStream;
		this.boardController = boardController;
		this.playerName = playerName;
		this.boardPane = boardPane;

	}

	@Override
	public void run() {
		while (true) {

			try {
				Object recivedData = objectInputStream.readObject();
				DataToSendToClients data = (DataToSendToClients) recivedData;
				//Thread.sleep(300);
				if (data != null) {
					Platform.runLater(new Runnable() {
						@Override
						public void run() {
							boardController.setBoard(data.getBoard());
							boardController.setBoardView(boardPane);
							boardController.setPlayers(data.getPlayers());
							boardController.drawOponents();
							if (initalizeBoard) {
								boardController.setPlayerID(data.getId());
								boardController.setPlayerName(playerName);
								boardController.initializeBoard();
								initalizeBoard = false;
							}
						}
					});
				}
			} catch (ClassNotFoundException | IOException e) {
				Platform.runLater(new Runnable() {

					@Override
					public void run() {
						boardController.showAlert("Error", "Internet connection", "Probably there is internet connection issue, try again later!", true);						
					}
					
				});				
				break;
			} 
		}

	}

}
