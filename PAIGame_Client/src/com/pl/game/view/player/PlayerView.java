package com.pl.game.view.player;

import com.pl.game.model.utils.Direction;

import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public class PlayerView{

	private Circle circle = new Circle();
	private Text nickName = new Text();

	public PlayerView(double startXPosition, double startYPosition, double playerSize, String name) {
		this.setPlayerXPosition(startXPosition);
		this.setPlayerYPosition(startYPosition);
		this.setPlayerName(name);
		this.setPlayerSize(playerSize);
		this.setTextPosition();
	}

	public void setPlayerXPosition(double xPosition) {
		this.circle.setCenterX(xPosition);
	}

	public void setPlayerYPosition(double yPosition) {
		this.circle.setCenterY(yPosition);
		
	}

	public void setPlayerName(String playerName) {
		this.nickName.setText(playerName);
	}

	public double getPlayerXPosition() {		
		return this.circle.getCenterX();
	}

	public double getPlayerYPosition() {
		return this.circle.getCenterY();
	}

	public void setPlayerSize(Double size) {
		this.circle.setRadius(size);
	}

	public double getPlayerSize() {
		return this.circle.getRadius();
	}

	public void setTextPosition() {
		this.nickName.setX(this.getPlayerXPosition() - this.countNameWidth() / 2);
		this.nickName.setY(this.getPlayerYPosition() + this.countNameHeigth() / 3);
	}

	public void setPlayerLook(String style) {
		this.circle.getStyleClass().add(style);
	}

	public void movePlayerView(Direction direction, double distance) {
		switch (direction.toString()) {
		case ("UP"):
			this.setPlayerYPosition(this.getPlayerYPosition() - distance);
			this.setTextPosition();
			break;
		case ("DOWN"):
			this.setPlayerYPosition(this.getPlayerYPosition() + distance);
			this.setTextPosition();
			break;
		case ("LEFT"):
			this.setPlayerXPosition(this.getPlayerXPosition() - distance);
			this.setTextPosition();
			break;
		case ("RIGHT"):
			this.setPlayerXPosition(this.getPlayerXPosition() + distance);
			this.setTextPosition();
			break;
		}
	}

	public Circle getCircle() {
		return circle;
	}

	public Text getNickName() {
		return nickName;
	}
	private double countNameWidth() {		
		return nickName.getLayoutBounds().getWidth();
	}
	private double countNameHeigth() {		
		return nickName.getLayoutBounds().getHeight();
	}


}
