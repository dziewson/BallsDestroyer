package com.pl.game.model.server;

import java.io.IOException;
import java.io.ObjectOutputStream;

import com.pl.game.model.board.Board;
import com.pl.game.model.data.DataToSendToClients;
import com.pl.game.model.data.PlayersPositions;

public class Send implements Runnable {
	private ObjectOutputStream objectOutputStream;
	private Board board;
	private int id;
	private PlayersPositions players;

	public Send(ObjectOutputStream objectOutputStream, Board board, int id, PlayersPositions players) {
		this.objectOutputStream = objectOutputStream;
		this.board = board;
		this.id = id;
		this.players = players;
	}

	@Override
	public void run() {
		while (true) {
			DataToSendToClients data = new DataToSendToClients(board, id, players);
			try {
				objectOutputStream.reset();
				objectOutputStream.writeObject(data);
			} catch (IOException e) {			
				break;
			}
		}

	}

}
