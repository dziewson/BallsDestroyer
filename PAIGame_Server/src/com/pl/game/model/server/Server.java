package com.pl.game.model.server;

import java.io.IOException;
import java.net.ServerSocket;

import com.pl.game.model.board.Board;
import com.pl.game.model.data.PlayersPositions;

public class Server {
	private ServerSocket server;
	private Board board;
	private int maxClientsPerRoom = 4;
	private int port = 8080;
	volatile int x = 0;

	private ClientsNumber clients = new ClientsNumber();
	PlayersPositions players = new PlayersPositions();

	public Server(Board board) throws IOException {
		this.board = board;
		server = new ServerSocket(port);
	}

	public void listen() throws IOException {
		System.out.println("Waiting for clients...");
		while (true) {
			x++;
			if (clients.getClients() % maxClientsPerRoom == 0) {
				x = 0;
				System.out.println("Starting new room");
				Room room = new Room(server, board, clients);
				room.start();
				while (!clients.isConnected()) {
					x++;
				}
				x = 0;
			}

		}
	}
	private  void loadServerConfig() {
		
	}

}
