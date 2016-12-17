package com.pl.game.model.utils;

public enum Direction {
	UP("UP"), DOWN("DOWN"), RIGHT("RIGHT"), LEFT("LEFT");

	private final String direction;

	private Direction(final String direction) {
		this.direction = direction;
	}
	@Override
	public String toString() {
		return direction;
	}

}
