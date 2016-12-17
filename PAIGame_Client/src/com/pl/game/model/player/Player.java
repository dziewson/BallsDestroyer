package com.pl.game.model.player;

import java.util.ArrayList;
import java.util.List;

import com.pl.game.model.utils.Direction;
import com.pl.game.view.player.PlayerShot;
import com.pl.game.view.player.PlayerView;

import javafx.scene.layout.Pane;

public class Player {
	private String nickName = "";
	private List<String> styles = new ArrayList<>();
	private final static double playerStartSize = 40;
	private PlayerView playerView;
	private int styleId;

	public Player() {

	}

	public Player(double startXPosition, double startYPosition, String nickName, int styleId) {
		styles.add("");
		this.nickName = nickName;
		this.styleId = styleId;
		initializePlayer(startXPosition, startYPosition);
	}

	private void initializePlayer(double startXPosition, double startYPosition) {
		addPlayersStyles();
		playerView = new PlayerView(startXPosition, startYPosition, playerStartSize, this.nickName);
		setStyle();

	}

	public void movePlayer(Direction direction, double distance) {
		playerView.movePlayerView(direction, distance);

	}
	public void initStyle() {
		setStyle();
		this.playerView.setPlayerName(nickName);
	}

	public PlayerView getPlayerView() {
		return playerView;
	}

	private void setStyle() {
		this.playerView.setPlayerLook(styles.get(styleId));
	}

	private void addPlayersStyles() {
		styles.add("first-player-style");
		styles.add("second-player-style");
		styles.add("third-player-style");
		styles.add("fourth-player-style");
	}	

	public void setPlayerSize(double playerSize) {
		this.playerView.getCircle().setRadius(playerSize);
	}

	public double getPlayerXPosition() {
		return this.playerView.getPlayerXPosition();
	}

	public double getPlayerYPosition() {
		return this.playerView.getPlayerYPosition();
	}

	public double getPlayerSize() {
		return this.playerView.getPlayerSize();
	}

	public void shoot(Direction direction, Pane pane) throws InterruptedException {
		PlayerShot shot = new PlayerShot(this.getPlayerXPosition(), this.getPlayerYPosition(), this.getPlayerSize(),
				200);
		shot.init();
		pane.getChildren().add(0, shot.getShootView());
		shot.shoot(direction);
	}

	public String getNickName() {
		return this.nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public void setPlayerXPosition(double x) {
		this.playerView.setPlayerXPosition(x);
	}

	public void setPlayerYPosition(double y) {
		this.playerView.setPlayerYPosition(y);
	}
	public void setVisible(boolean visible) {
		this.playerView.getCircle().setVisible(visible);
		this.playerView.getNickName().setVisible(visible);
	}

	public int getStyleId() {
		return styleId;
	}

	public void setStyleId(int styleId) {
		this.styleId = styleId;
	}	
	public void setNamePosition() {
		this.playerView.setTextPosition();
	}
	public boolean isVisible() {
		return this.playerView.getCircle().isVisible();
	}
}
