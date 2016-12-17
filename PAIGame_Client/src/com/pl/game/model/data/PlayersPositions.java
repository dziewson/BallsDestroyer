package com.pl.game.model.data;

import java.io.Serializable;

public class PlayersPositions implements Serializable {

	private static final long serialVersionUID = 4801355808479719569L;
	private DataToSendToServer player1;
	private DataToSendToServer player2;
	private DataToSendToServer player3;
	private DataToSendToServer player4;

	public PlayersPositions() {
	}

	public PlayersPositions(DataToSendToServer player1, DataToSendToServer player2) {

		this.player1 = player1;
		this.player2 = player2;
	}

	public DataToSendToServer getPlayer1() {
		return player1;
	}

	public void setPlayer1(DataToSendToServer player1) {
		this.player1 = player1;
	}

	public DataToSendToServer getPlayer2() {
		return player2;
	}

	public void setPlayer2(DataToSendToServer player2) {
		this.player2 = player2;
	}

	public DataToSendToServer getPlayer3() {
		return player3;
	}

	public void setPlayer3(DataToSendToServer player3) {
		this.player3 = player3;
	}

	public DataToSendToServer getPlayer4() {
		return player4;
	}

	public void setPlayer4(DataToSendToServer player4) {
		this.player4 = player4;
	}

	@Override
	public String toString() {
		return "PlayersPositions [player1=" + player1 + ", player2=" + player2 + "]";
	}

}