package com.pl.game.model.data;

import java.io.Serializable;

public class DataToSendToServer implements Serializable {
	private static final long serialVersionUID = 2247032265737148361L;
	private double playerXPosition;
	private double playerYPosition;
	private double playerSize;
	private int playerID;
	private boolean visible;
	private String playerName;
	private String killedPlayerName;

	public DataToSendToServer() {

	}

	public DataToSendToServer(double playerXPosition, double playerYPosition, double playerSize, int playerID,
			String playerName) {
		super();
		this.playerXPosition = playerXPosition;
		this.playerYPosition = playerYPosition;
		this.playerSize = playerSize;
		this.playerName = playerName;
		this.playerID = playerID;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public double getPlayerXPosition() {
		return playerXPosition;
	}

	public void setPlayerXPosition(double playerXPosition) {
		this.playerXPosition = playerXPosition;
	}

	public double getPlayerYPosition() {
		return playerYPosition;
	}

	public void setPlayerYPosition(double playerYPosition) {
		this.playerYPosition = playerYPosition;
	}

	public double getPlayerSize() {
		return playerSize;
	}

	public void setPlayerSize(double playerSize) {
		this.playerSize = playerSize;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public int getPlayerID() {
		return playerID;
	}

	public void setPlayerID(int playerID) {
		this.playerID = playerID;
	}

	public String getKilledPlayerName() {
		return killedPlayerName;
	}

	public void setKilledPlayerName(String killedPlayerName) {
		this.killedPlayerName = killedPlayerName;
	}

	@Override
	public String toString() {
		return "DataToSendToServer [playerXPosition=" + playerXPosition + ", playerYPosition=" + playerYPosition
				+ ", playerSize=" + playerSize + ", playerID=" + playerID + ", playerName=" + playerName + "]";
	}

}
