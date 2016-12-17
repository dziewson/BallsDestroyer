package com.pl.game.model.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.pl.game.model.board.Board;
import com.pl.game.model.data.PlayersPositions;

public class ClientThread extends Thread {
	private Socket socket;
	private ObjectOutputStream objectOutputStream = null;
	private ObjectInputStream objectInputStream = null;
	private Board board;
	private int id;
	private PlayersPositions players;

	public ClientThread(Socket clientSocket, Board board, int id, PlayersPositions players) {
		this.socket = clientSocket;
		this.board = board;
		this.id = id;
		this.players = players;
	}

	public void run() {
		try {
			objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
			objectInputStream = new ObjectInputStream(socket.getInputStream());
			new Thread(new Send(objectOutputStream, board, id, players)).start();
			new Thread(new Recive(players, objectInputStream, id)).start();
		} catch (IOException e) {
			try {
				socket.close();
				this.interrupt();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

	}
}
