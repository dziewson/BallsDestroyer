package com.pl.game.view.controller.utils;

import java.util.ArrayList;
import java.util.List;

import com.pl.game.model.board.Board;
import com.pl.game.model.data.PlayersPositions;
import com.pl.game.model.player.Player;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

public class BoardControllerData {
	private Pane boardView;
	private Player player;
	private Player firstOponent = new Player(0, 0, "", 0);
	private Player secondOponent = new Player(0, 0, "", 0);
	private Player thirdOponent = new Player(0, 0, "", 0);
	private Board board;
	private double startX;
	private String playerName;
	private double startY;
	private double smallPointGrowth = 0.15;
	private double mediumPointGrowth = 0.25;
	private double bigPointGrowth = 0.5;
	private double distance = 7;
	private List<Circle> smallPoints = new ArrayList<>();
	private List<Circle> mediumPoints = new ArrayList<>();
	private List<Circle> bigPoints = new ArrayList<>();
	private PlayersPositions players;
	private int playerID;
	private String killedPlayer;
	private int numberOfSameNames = 0;
	//private boolean breakGame = false;

	public BoardControllerData(Pane boardView, Board board) {
		this.boardView = boardView;
		this.board = board;
	}

	public Pane getBoardView() {
		return boardView;
	}

	public void setBoardView(Pane boardView) {
		this.boardView = boardView;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Player getFirstOponent() {
		return firstOponent;
	}

	public void setFirstOponent(Player oponent) {
		this.firstOponent = oponent;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public double getStartX() {
		return startX;
	}

	public void setStartX(double startX) {
		this.startX = startX;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public double getStartY() {
		return startY;
	}

	public void setStartY(double startY) {
		this.startY = startY;
	}

	public double getSmallPointGrowth() {
		return smallPointGrowth;
	}

	public void setSmallPointGrowth(double smallPointGrowth) {
		this.smallPointGrowth = smallPointGrowth;
	}

	public double getMediumPointGrowth() {
		return mediumPointGrowth;
	}

	public void setMediumPointGrowth(double mediumPointGrowth) {
		this.mediumPointGrowth = mediumPointGrowth;
	}

	public double getBigPointGrowth() {
		return bigPointGrowth;
	}

	public void setBigPointGrowth(double bigPointGrowth) {
		this.bigPointGrowth = bigPointGrowth;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public List<Circle> getSmallPoints() {
		return smallPoints;
	}

	public void setSmallPoints(List<Circle> smallPoints) {
		this.smallPoints = smallPoints;
	}

	public List<Circle> getMediumPoints() {
		return mediumPoints;
	}

	public void setMediumPoints(List<Circle> mediumPoints) {
		this.mediumPoints = mediumPoints;
	}

	public List<Circle> getBigPoints() {
		return bigPoints;
	}

	public void setBigPoints(List<Circle> bigPoints) {
		this.bigPoints = bigPoints;
	}

	public PlayersPositions getPlayers() {
		return players;
	}

	public void setPlayers(PlayersPositions players) {
		this.players = players;
	}

	public int getPlayerID() {
		return playerID;
	}

	public void setPlayerID(int playerID) {
		this.playerID = playerID;
		setStartPostions();
	}

	public Player getSecondOponent() {
		return secondOponent;
	}

	public void setSecondOponent(Player secondOponent) {
		this.secondOponent = secondOponent;
	}

	public Player getThirdOponent() {
		return thirdOponent;
	}

	public void setThirdOponent(Player thirdOponent) {
		this.thirdOponent = thirdOponent;
	}

	private void setStartPostions() {
		switch (playerID) {
		case (1):
			startX = 250;
			startY = 250;
			break;
		case (2):
			startX = 325;
			startY = 325;
			break;
		case (3):
			startX = 450;
			startY = 450;
			break;
		case (4):
			startX = 575;
			startY = 575;
			break;
		}
	}
	
	public String getKilledPlayer() {
		return killedPlayer;
	}

	public void setKilledPlayer(String killedPlayer) {
		this.killedPlayer = killedPlayer;
	}

	public int getNumberOfSameNames() {
		return numberOfSameNames;
	}

	public void setNumberOfSameNames(int numberOfSameNames) {
		this.numberOfSameNames = numberOfSameNames;
	}
	
}
