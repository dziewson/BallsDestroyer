package com.pl.game.model.board;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Board implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Point> smallPoints = new ArrayList<>();
	private List<Point> mediumPoints = new ArrayList<>();
	private List<Point> bigPoints = new ArrayList<>();

	public Board() {

	}

	public void initBoard() {
		generatePoints();		
	}

	private void generatePoints() {

		for (int index = 0; index < 150; index++) {
			double x = 30 + (970 - 30) * new Random().nextDouble();
			double y = 30 + (770 - 30) * new Random().nextDouble();
			if (!isListHasPointsAtThisPosition(x, y)) {
				if (index < 80) {
					smallPoints.add(new PointImpl(x, y, 3));
				} else if (index >= 81 && index < 120) {
					mediumPoints.add(new PointImpl(x, y, 5));
				} else {
					bigPoints.add(new PointImpl(x, y, 7));
				}
			}
		}
	}

	private boolean isListHasPointsAtThisPosition(double x, double y) {
		for (Point point : smallPoints) {
			if ((point.getXPosition() - 5 < x && x < point.getXPosition() + 5)
					&& (point.getYPosition() - 5 < y && y < point.getYPosition() + 5)) {
				return true;
			}
		}
		for (Point point : mediumPoints) {
			if ((point.getXPosition() - 7 < x && x < point.getXPosition() + 7)
					&& (point.getYPosition() - 7 < y && y < point.getYPosition() + 7)) {
				return true;
			}
		}
		for (Point point : bigPoints) {
			if ((point.getXPosition() - 9 < x && x < point.getXPosition() + 9)
					&& (point.getYPosition() - 9 < y && y < point.getYPosition() + 9)) {
				return true;
			}
		}
		return false;
	}

	public List<Point> getSmallPoints() {
		return smallPoints;
	}

	public List<Point> getMediumPoints() {
		return mediumPoints;
	}

	public List<Point> getBigPoints() {
		return bigPoints;
	}

	@Override
	public String toString() {
		return "Board [smallPoints=" + smallPoints + ", mediumPoints=" + mediumPoints + ", bigPoints=" + bigPoints
				+ "]";
	}
	
	

}
