package com.pl.game.view.player;

import com.pl.game.model.utils.Direction;

import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class PlayerShot {
	private Circle circle = new Circle(0, 0, 0);
	private final static String TEXTURE_PATH = "file:resources/images/net.png";
	private double playerXPosition;
	private double playerYPostion;
	private double playerSize;
	private double range;

	public PlayerShot(double playerXPosition, double playerYPostion, double playerSize, double range) {
		this.playerXPosition = playerXPosition;
		this.playerYPostion = playerYPostion;
		this.playerSize = playerSize;
		this.range = range;
	}

	public void init() {
		this.circle.setCenterX(playerXPosition);
		this.circle.setCenterY(playerYPostion);
		this.circle.setRadius(playerSize);
		this.setTexture();
	}

	private void setTexture() {
		ImagePattern texture = new ImagePattern(new Image(TEXTURE_PATH));
		circle.setFill(texture);
	}

	public void shoot(Direction direction) throws InterruptedException {
		
		SequentialTransition sequence = new SequentialTransition(createFader(), moveTransition(direction));
		sequence.play();
	}

	private Timeline moveTransition(Direction direction) {		
		Timeline move = new Timeline();
		move.setCycleCount(1);
		KeyValue keyValue = null;
		switch(direction.toString()){
		case("RIGHT"):
			keyValue = new KeyValue(this.circle.centerXProperty(), this.circle.getCenterX() + range);
			break;
		case("LEFT"):
			keyValue = new KeyValue(this.circle.centerXProperty(), this.circle.getCenterX() - range);
			break;
		case("UP"):
			keyValue = new KeyValue(this.circle.centerYProperty(), this.circle.getCenterY() - range);
			break;
		case("DOWN"):
			keyValue = new KeyValue(this.circle.centerYProperty(), this.circle.getCenterY() +range);
			break;
		}
		
		KeyFrame keyFrame = new KeyFrame(Duration.millis(250), keyValue);
		move.getKeyFrames().add(keyFrame);
		move.play();
		return move;
	}

	public Circle getShootView() {
		return this.circle;
	}

	private FadeTransition createFader() {
		FadeTransition fade = new FadeTransition(Duration.seconds(2), circle);
		fade.setFromValue(1);
		fade.setToValue(0);
		return fade;
	}

}
