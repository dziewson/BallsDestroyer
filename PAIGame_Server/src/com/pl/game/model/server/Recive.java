package com.pl.game.model.server;

import java.io.IOException;
import java.io.ObjectInputStream;

import com.pl.game.model.data.DataToSendToServer;
import com.pl.game.model.data.PlayersPositions;

public class Recive implements Runnable {
	private PlayersPositions players;
	private ObjectInputStream objectInputStream;
	private int clientid;

	public Recive(PlayersPositions players, ObjectInputStream objectInputStream, int id) {
		this.players = players;
		this.objectInputStream = objectInputStream;
		this.clientid = id;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Object object = objectInputStream.readObject();
				DataToSendToServer data = (DataToSendToServer) object;
				if (data.getPlayerID() == 1) {
					players.setPlayer1(data);
				} else if (data.getPlayerID() == 2) {
					players.setPlayer2(data);
				} else if (data.getPlayerID() == 3) {
					players.setPlayer3(data);
				} else if (data.getPlayerID() == 4) {
					players.setPlayer4(data);
				}
			} catch (ClassNotFoundException | IOException e) {		
				System.out.println("Client " + clientid + "disconnected");
				break;
			}

		}
	}

}
