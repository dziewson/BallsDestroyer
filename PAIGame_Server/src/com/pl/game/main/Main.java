package com.pl.game.main;
import java.io.IOException;

import com.pl.game.model.board.Board;
import com.pl.game.model.server.Server;

public class Main {
	public static void main(String[] args) throws IOException {
		Board board = new Board();
		board.initBoard();
		Server server = new Server(board);
		server.listen();		
	}
}
