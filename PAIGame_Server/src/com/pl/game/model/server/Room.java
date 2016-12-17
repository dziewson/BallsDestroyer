package com.pl.game.model.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.pl.game.model.board.Board;
import com.pl.game.model.data.PlayersPositions;

public class Room extends Thread {
	private ServerSocket socket;
	private Board board;
	private Socket connection;
	private int clients = 0;
	private ClientsNumber clientsNumber;
	private PlayersPositions players = new PlayersPositions();

	public Room(ServerSocket clientSocket, Board board, ClientsNumber clientsNumber) {
		this.socket = clientSocket;
		this.board = board;
		this.clientsNumber = clientsNumber;
	}

	public void run() {
		while (true) {
			try {
				connection = socket.accept();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (connection.isConnected()) {
				System.out.println("client " + ++clients + " connected");
				new ClientThread(connection, board, clients, players).start();
				clientsNumber.increment();
				clientsNumber.setConnected(true);
			}
			if (clients == 4) {
				System.out.println("Closing room");
				clientsNumber.setConnected(false);
				break;
			}

		}
	}
}
