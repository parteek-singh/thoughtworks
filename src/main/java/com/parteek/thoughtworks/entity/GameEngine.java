package com.parteek.thoughtworks.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.parteek.thoughtworks.constant.GameConstants;
import com.parteek.thoughtworks.util.GameUtil;

public class GameEngine {

	GameBoard gameBoard = null;

	public GameEngine() {

	}

	public GameEngine(GameBoard gameBoard) {
		this.gameBoard = gameBoard;

	}

	public void startGame() {
		GameUtil gameUtil = getGameUtil();
		CellReward cellReward = getCellReward();

		List<Player> players = getGamePlayer();
		List<Cell> cells = getBoardCells();

		for (int i = 0; i < GameConstants.MAX_CHANCES; i++) {

			for (Player player : players) {
				int diceNumber = gameUtil.rollDice();

				

				int nextPosition = player.getPostion() + diceNumber;
				if (nextPosition > cells.size() - 1) {
					player.setPostion(0);
					nextPosition = nextPosition - (cells.size());
				}
				player.setPostion(nextPosition);

				Cell selectedCell = cells.get(player.getPostion());
				System.out.println("Roll Dice output : " + diceNumber + "  "+ selectedCell.getType()); 
				double amount = cellReward.getReward(player, selectedCell);
				player.setMoney(player.getMoney() + amount);

			}
		}

		Map<Player, Double> allPlayers = new HashMap<>();
		for (Player player : players) {
			double amount = (player.getMoney() + (player.getHotelOwned().size() * GameConstants.HOTEL_WORTH));
			allPlayers.put(player, amount);

		}
		players = (ArrayList<Player>) players.stream().sorted((p1, p2) -> p1.getWorth().compareTo(p1.getWorth()))
				.collect(Collectors.toList());
		for (Player player : players) {
			System.out.println("Player " + player.getIndex() + " has total worth " + player.getWorth());
		}
		System.out.println();
	}

	
	public List<Player> getGamePlayer() {
		return this.gameBoard.getPlayers();

	}
	
	public List<Cell> getBoardCells() {
		return this.gameBoard.getCells();

	}
	
	public GameUtil getGameUtil() {
		return GameUtil.getInstance();

	}

	public CellReward getCellReward() {
		return CellReward.getInstance();

	}
}
