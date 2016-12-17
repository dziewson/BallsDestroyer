package com.pl.game.model.board;

import java.io.Serializable;

public class PointImpl implements Point, Serializable {

	private static final long serialVersionUID = -6709056520646719794L;
	private double pointValue;
	private double xPosition;
	private double yPosition;

	public PointImpl(double xPosition, double yPosition, double pointValue) {
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		this.pointValue = pointValue;
	}

	@Override
	public double getPointValue() {
		return pointValue;
	}

	@Override
	public void setPointValue(double value) {
		this.pointValue = value;
	}

	@Override
	public void setXPosition(double x) {
		this.xPosition = x;
	}

	@Override
	public void setYPosition(double y) {
		this.yPosition = y;
	}

	@Override
	public double getXPosition() {
		return xPosition;
	}

	@Override
	public double getYPosition() {
		return yPosition;
	}

	@Override
	public String toString() {
		return "PointImpl [pointValue=" + pointValue + ", xPosition=" + xPosition + ", yPosition=" + yPosition + "]";
	}

}
