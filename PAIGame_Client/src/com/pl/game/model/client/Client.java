package com.pl.game.model.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import com.pl.game.view.controller.BoardController;

import javafx.application.Platform;
import javafx.scene.layout.Pane;

public class Client {
	private Socket socket;
	private ObjectInputStream objectInputStream;
	private ObjectOutputStream objectOutputStream;
	private Pane boardPane;
	private String playerName;
	private BoardController boardController;

	public Client(String ip, int port, Pane boardPane, String playerName) throws UnknownHostException, IOException {
		this.socket = new Socket();
		this.boardController = new BoardController(null, null);
		try {
			socket.connect(new InetSocketAddress(ip, port), 4000);
		} catch (Exception e) {
			Platform.runLater(new Runnable() {
				@Override
				public void run() {
					boardController.showAlert("Error", "Internet connection",
							"Probably there is internet connection issue, try again later!", false);
				}
			});
		}
	
		this.boardPane = boardPane;
		this.playerName = playerName;

	}

	public void initStream() throws IOException {		
		if(socket.isConnected()) {
			objectInputStream = new ObjectInputStream(socket.getInputStream());
			objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
		}
		
		
	}

	public void startReciving() {
		if(socket.isConnected()) 
		new Thread(new Recive(objectInputStream, boardController, playerName, boardPane)).start();
	}

	public void startSending() {
		if(socket.isConnected()) 
		new Thread(new Send(objectOutputStream, boardController)).start();
	}

}
