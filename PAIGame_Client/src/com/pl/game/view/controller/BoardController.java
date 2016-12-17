package com.pl.game.view.controller;

import com.pl.game.model.board.Board;
import com.pl.game.model.board.Point;
import com.pl.game.model.data.DataToSendToServer;
import com.pl.game.model.data.PlayersPositions;
import com.pl.game.model.player.Player;
import com.pl.game.model.utils.Direction;
import com.pl.game.view.controller.utils.BoardControllerData;
import com.pl.game.view.controller.utils.BoardControllerUtils;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;

public class BoardController {
	BoardControllerData data;

	public BoardController(Pane boardView, Board board) {
		this.data = new BoardControllerData(boardView, board);
	}

	public void initializeBoard() {
		generatePoints(data.getBoard());
		initializePointsStyleAndAddPointsToBoard();
		data.getBoardView().setStyle("-fx-background-color: white");
		createPlayers();
		addPlayerAbilityToMove();

	}

	private void createPlayers() {
		data.setPlayer(
				new Player(data.getStartX() + 150, data.getStartY() + 170, data.getPlayerName(), data.getPlayerID()));
		data.getBoardView().getChildren().add(data.getPlayer().getPlayerView().getCircle());
		data.getBoardView().getChildren().add(data.getPlayer().getPlayerView().getNickName());
		addOponent(data.getFirstOponent());
		addOponent(data.getSecondOponent());
		addOponent(data.getThirdOponent());
	}

	private void addOponent(Player oponent) {
		oponent.setVisible(false);
		data.getBoardView().getChildren().add(oponent.getPlayerView().getCircle());
		data.getBoardView().getChildren().add(oponent.getPlayerView().getNickName());
	}

	private void generatePoints(Board board) {
		for (Point point : board.getSmallPoints()) {
			data.getSmallPoints().add(new Circle(point.getXPosition(), point.getYPosition(), point.getPointValue()));
		}
		for (Point point : board.getMediumPoints()) {
			data.getMediumPoints().add(new Circle(point.getXPosition(), point.getYPosition(), point.getPointValue()));
		}
		for (Point point : board.getBigPoints()) {
			data.getBigPoints().add(new Circle(point.getXPosition(), point.getYPosition(), point.getPointValue()));
		}
	}

	private void initializePointsStyleAndAddPointsToBoard() {
		data.getBoardView().getChildren().addAll(data.getSmallPoints());
		data.getBoardView().getChildren().addAll(data.getMediumPoints());
		data.getBoardView().getChildren().addAll(data.getBigPoints());
		initPointsWithStyle();
	}

	private void initPointsWithStyle() {
		for (Circle circle : data.getSmallPoints()) {
			circle.getStyleClass().add("small-point-style");
		}
		for (Circle circle : data.getMediumPoints()) {
			circle.getStyleClass().add("medium-point-style");
		}
		for (Circle circle : data.getBigPoints()) {
			circle.getStyleClass().add("big-point-style");
		}
	}

	private void addPlayerAbilityToMove() {
		data.getBoardView().getScene().addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				if (event.getCode() == KeyCode.D) {
					movePlayer(Direction.RIGHT);
				}
				if (event.getCode() == KeyCode.A) {
					movePlayer(Direction.LEFT);
				}
				if (event.getCode() == KeyCode.W) {
					movePlayer(Direction.UP);
				}
				if (event.getCode() == KeyCode.S) {
					movePlayer(Direction.DOWN);
				}
			}
		});
	}

	private void movePlayer(Direction direcrtion) {
		data.getPlayer().movePlayer(direcrtion, data.getDistance());
		BoardControllerUtils.checkIfPlayerIsOnPoint(data, data.getPlayer());
		BoardControllerUtils.checkIfPlayerTouchBoardBorder(data);
		BoardControllerUtils.checkIfPlayersAreKillingEachOther(data);
		breakGame("LOSSSSSSSER");
	}

	public void setBoard(Board board) {
		this.data.setBoard(board);
	}

	public void setBoardView(Pane boardView) {
		this.data.setBoardView(boardView);
	}

	public void setPlayerID(int playerID) {
		this.data.setPlayerID(playerID);
	}

	public DataToSendToServer getData() {
		DataToSendToServer dataFromClient = new DataToSendToServer();
		dataFromClient.setPlayerID(data.getPlayerID());
		dataFromClient.setPlayerName(data.getPlayerName());
		dataFromClient.setPlayerSize(data.getPlayer().getPlayerSize());
		dataFromClient.setPlayerXPosition(data.getPlayer().getPlayerXPosition());
		dataFromClient.setPlayerYPosition(data.getPlayer().getPlayerYPosition());
		dataFromClient.setVisible(data.getPlayer().isVisible());
		dataFromClient.setKilledPlayerName(null);
		return dataFromClient;
	}

	public void setPlayers(PlayersPositions players) {
		this.data.setPlayers(players);
	}

	public void drawOponents() {
		if (data.getPlayerID() == 1) {
			DataToSendToServer player2 = data.getPlayers().getPlayer2();
			DataToSendToServer player3 = data.getPlayers().getPlayer3();
			DataToSendToServer player4 = data.getPlayers().getPlayer4();
			drawOponent(player2, data.getFirstOponent());
			drawOponent(player3, data.getSecondOponent());
			drawOponent(player4, data.getThirdOponent());

		}
		if (data.getPlayerID() == 2) {
			DataToSendToServer player1 = data.getPlayers().getPlayer1();
			DataToSendToServer player3 = data.getPlayers().getPlayer3();
			DataToSendToServer player4 = data.getPlayers().getPlayer4();
			drawOponent(player1, data.getFirstOponent());
			drawOponent(player3, data.getSecondOponent());
			drawOponent(player4, data.getThirdOponent());
		}
		if (data.getPlayerID() == 3) {
			DataToSendToServer player1 = data.getPlayers().getPlayer1();
			DataToSendToServer player2 = data.getPlayers().getPlayer2();
			DataToSendToServer player4 = data.getPlayers().getPlayer4();
			drawOponent(player1, data.getFirstOponent());
			drawOponent(player2, data.getSecondOponent());
			drawOponent(player4, data.getThirdOponent());
		}
		if (data.getPlayerID() == 4) {
			DataToSendToServer player1 = data.getPlayers().getPlayer1();
			DataToSendToServer player2 = data.getPlayers().getPlayer2();
			DataToSendToServer player3 = data.getPlayers().getPlayer3();
			drawOponent(player1, data.getFirstOponent());
			drawOponent(player2, data.getSecondOponent());
			drawOponent(player3, data.getThirdOponent());
		}
	}

	public void drawOponent(DataToSendToServer player, Player oponent) {
		if (player != null) {
			
			setOponent(player, oponent);
		}
	}
	private void checkIfPlayersNamesAreDifferent(Player player) {
		if(data.getPlayer().getNickName().trim().equals(player.getNickName().trim())) {
			int x = data.getNumberOfSameNames();
			data.setNumberOfSameNames(x++);
			player.setNickName(player.getNickName() + "(" + data.getNumberOfSameNames() + ")" );			
		}
	}

	private void setOponent(DataToSendToServer player, Player oponent) {
		oponent.setPlayerSize(player.getPlayerSize());
		oponent.setPlayerXPosition(player.getPlayerXPosition());
		oponent.setPlayerYPosition(player.getPlayerYPosition());
		BoardControllerUtils.checkIfPlayerIsOnPoint(data, oponent);
		if (oponent.getNickName().equals("")) {
			oponent.setNickName(player.getPlayerName());
			checkIfPlayersNamesAreDifferent(oponent);
			oponent.setStyleId(player.getPlayerID());
			oponent.initStyle();
			oponent.setVisible(true);
		}
		oponent.setNamePosition();
		if (!player.isVisible()) {
			oponent.setVisible(false);
		}
		BoardControllerUtils.checkIfPlayersAreKillingEachOther(data);
		breakGame("LOSSSSSSSER!");
	}

	public void setPlayerName(String playerName) {
		this.data.setPlayerName(playerName);
	}

	public void breakGame(String txt) {
		if (!data.getPlayer().isVisible()) {
			data.getBoardView().getChildren().clear();
			StackPane pane = createExitStackPane();
			HBox box = new HBox();
			box.setMaxSize(150, 50);
			box.getChildren().add(createLoserText(txt));
			box.getChildren().add(createExitButton());
			pane.getChildren().add(box);
			data.getBoardView().getChildren().add(pane);
		}/*else if(!data.getFirstOponent().isVisible() && !data.getSecondOponent().isVisible() && !data.getThirdOponent().isVisible()) {
			breakGame("WINNNER!!");
		}*/
	}

	private Button createExitButton() {
		Button button = new Button("Exit");
		button.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				System.exit(0);
			}
		});
		return button;
	}

	private StackPane createExitStackPane() {
		StackPane pane = new StackPane();
		pane.setMinHeight(800);
		pane.setMinWidth(1000);
		return pane;
	}

	private Label createLoserText(String txt) {
		Label text = new Label(txt);
		text.setMinWidth(100);
		text.setMinHeight(30);
		text.setAlignment(Pos.CENTER);
		return text;
	}

/*	public void checkIfDead() {
		if (data.getPlayers().getPlayer1().getKilledPlayerName().equals(data.getPlayerName())) {
			breakGame("LOSSSSSSSER!");
		} else if (data.getPlayers().getPlayer2().getKilledPlayerName().equals(data.getPlayerName())) {
			breakGame("LOSSSSSSSER!");
		} else if (data.getPlayers().getPlayer3().getKilledPlayerName().equals(data.getPlayerName())) {
			breakGame("LOSSSSSSSER!");
		} else if (data.getPlayers().getPlayer4().getKilledPlayerName().equals(data.getPlayerName())) {
			breakGame("LOSSSSSSSER!");
		}
	}*/

	public void showAlert(String title, String header, String communicate, boolean breakGame) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.setContentText(communicate);
		alert.showAndWait();
		if(breakGame) 
			breakGame("Internet connection error");
		
	}

}
