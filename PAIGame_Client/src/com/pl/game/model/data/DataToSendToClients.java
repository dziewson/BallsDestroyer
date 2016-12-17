package com.pl.game.model.data;

import java.io.Serializable;

import com.pl.game.model.board.Board;


public class DataToSendToClients implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4167754977171788652L;
	private Board board;
	private int id;
	PlayersPositions players = new PlayersPositions();
	public DataToSendToClients(Board board, int id, PlayersPositions players ) {
		this.board = board;
		this.id = id;
		this.players = players;
	}
	public Board getBoard() {
		return board;
	}
	public void setBoard(Board board) {
		this.board = board;
	}
	@Override
	public String toString() {
		return "DataToSendToClients [board=" + board + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public PlayersPositions getPlayers() {
		return players;
	}
	public void setPlayers(PlayersPositions players) {
		this.players = players;
	}

	
	
}
