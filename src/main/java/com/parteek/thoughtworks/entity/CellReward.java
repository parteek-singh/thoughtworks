package com.parteek.thoughtworks.entity;

import com.parteek.thoughtworks.constant.GameConstants;

public class CellReward {

	private static CellReward cellReward;

	private CellReward() {
	}

	public static CellReward getInstance() {
		if (cellReward == null) {
			synchronized (CellReward.class) {
				if (cellReward == null) {
					cellReward = new CellReward();
				}
			}
		}
		return cellReward;

	}

	/*
	 * This method will return amount need to be updated
	 * */
	public double getReward(Player currentPlayer, Cell cell) {
		double reward = 0;
		switch (cell.getType()) {
		case GameConstants.EMPTY:
			reward = 0;
			break;
		case GameConstants.JAIL:
			reward = -150;
			break;
		case GameConstants.TREASURE:
			reward = 200;
			break;
		case GameConstants.HOTEL:
			if (cell.getOwner() != null) {
				// Check if the current player is not the owner
				if (!currentPlayer.getHotelOwned().contains(cell)) {
					reward = -50;
					cell.getOwner().addMoney(50);
				}

			} else {
				cell.setOwner(currentPlayer);
				currentPlayer.addHotel(cell);
				reward = -200;
			}
			break;

		default:
			break;
		}
		return reward;

	}
}
