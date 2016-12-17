package com.pl.game.view.controller.utils;

import com.pl.game.model.player.Player;

import javafx.scene.shape.Circle;

public class BoardControllerUtils {

	public static void checkIfPlayerIsOnPoint(BoardControllerData data, Player player) {
		for (Circle circle : data.getSmallPoints()) {
			if (circle.getBoundsInParent()
					.intersects(player.getPlayerView().getCircle().getBoundsInParent())) {
				if(circle.isVisible()) {
					if(player.getNickName().equals(data.getPlayer().getNickName())) {
						data.getPlayer().setPlayerSize(data.getPlayer().getPlayerSize() + data.getSmallPointGrowth());	
					}									
					circle.setVisible(false);
					decreaseDistanceAndSizeIncreasing(data);
				}
			}
		}
		for (Circle circle : data.getMediumPoints()) {
			if (circle.getBoundsInParent()
					.intersects(player.getPlayerView().getCircle().getBoundsInParent())) {
				if(circle.isVisible()) {
					if(player.getNickName().equals(data.getPlayer().getNickName())) {
						data.getPlayer().setPlayerSize(data.getPlayer().getPlayerSize() + data.getMediumPointGrowth());
					}					
								
					circle.setVisible(false);
					decreaseDistanceAndSizeIncreasing(data);
				}

			}
		}
		for (Circle circle : data.getBigPoints()) {
			if (circle.getBoundsInParent()
					.intersects(player.getPlayerView().getCircle().getBoundsInParent())) {
				if(circle.isVisible()) {
					if(player.getNickName().equals(data.getPlayer().getNickName())) {
						data.getPlayer().setPlayerSize(data.getPlayer().getPlayerSize() + data.getBigPointGrowth());
					}									
					circle.setVisible(false);
					decreaseDistanceAndSizeIncreasing(data);
				}				
			}
		}
	}

	private static void decreaseDistanceAndSizeIncreasing(BoardControllerData data) {
		data.setDistance(data.getDistance() - 0.002);
		if (data.getDistance() <= 1) {
			data.setDistance(1);
		}
		if (data.getSmallPointGrowth() > 0) {
			data.setSmallPointGrowth(data.getSmallPointGrowth() - 0.000001);
		}
		if (data.getMediumPointGrowth() > 0) {
			data.setMediumPointGrowth(data.getMediumPointGrowth() - 0.000001);
		}
		if (data.getBigPointGrowth() > 0) {
			data.setBigPointGrowth(data.getBigPointGrowth() - 0.000001);
		}
	}

	public static void checkIfPlayerTouchBoardBorder(BoardControllerData data) {
		if (data.getPlayer().getPlayerXPosition() - data.getPlayer().getPlayerSize() <= 9
				|| data.getPlayer().getPlayerXPosition() - data.getPlayer().getPlayerSize() >= 991
				|| data.getPlayer().getPlayerYPosition() - data.getPlayer().getPlayerSize() <= 9
				|| data.getPlayer().getPlayerYPosition() - data.getPlayer().getPlayerSize() >= 791) {
			data.getPlayer().setVisible(false);
		}
	}

	public static void checkIfPlayersAreKillingEachOther(BoardControllerData data) {
		if (arePlayersIntersects(data.getPlayer(), data.getFirstOponent())) {
			if (data.getPlayer().getPlayerSize() > data.getFirstOponent().getPlayerSize()) {
				if(data.getFirstOponent().isVisible()) {
					data.getFirstOponent().setVisible(false);
				}								
			} else if (data.getFirstOponent().getPlayerSize() > data.getPlayer().getPlayerSize()) {
				if(data.getPlayer().isVisible()) {
					data.getPlayer().setVisible(false);
				}				
			}
		} else if (arePlayersIntersects(data.getPlayer(), data.getSecondOponent())) {
			if (data.getPlayer().getPlayerSize() > data.getSecondOponent().getPlayerSize()) {
				if(data.getSecondOponent().isVisible()) {
					data.getSecondOponent().setVisible(false);
				}		
			} else if (data.getSecondOponent().getPlayerSize() > data.getPlayer().getPlayerSize()) {
				if(data.getPlayer().isVisible()) {
					data.getPlayer().setVisible(false);
				}
				
			}
		} else if (arePlayersIntersects(data.getPlayer(), data.getThirdOponent())) {
			if (data.getPlayer().getPlayerSize() > data.getThirdOponent().getPlayerSize()) {
				if(data.getThirdOponent().isVisible()) {
					data.getThirdOponent().setVisible(false);
				}	
				data.getThirdOponent().setVisible(false);
			} else if (data.getThirdOponent().getPlayerSize() > data.getPlayer().getPlayerSize()) {
				if(data.getPlayer().isVisible()) {
					data.getPlayer().setVisible(false);
				}	
				
			}
		}
	}

	private static boolean arePlayersIntersects(Player player1, Player player2) {
		if (player1.getPlayerView().getCircle().getBoundsInParent()
				.intersects(player2.getPlayerView().getCircle().getBoundsInParent())) {
			return true;
		}
		return false;
	}

}
