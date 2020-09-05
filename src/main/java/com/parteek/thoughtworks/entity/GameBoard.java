package com.parteek.thoughtworks.entity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.springframework.util.StringUtils;

import com.parteek.thoughtworks.util.GameUtil;

public class GameBoard {

	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	private  ArrayList<Player> players;
	private  ArrayList<Cell> cells;

	/*
	 * Initialize the game
	 * */
	public void initGame() {
		try {

			players = initalisePlayer();
			cells = prepareGameBoard();

		} catch (NumberFormatException e) {
			System.out.println("Invalid Format type");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * Initialize the game players
	 * */
	
	private ArrayList<Player> initalisePlayer() throws NumberFormatException, IOException {
		ArrayList<Player> players = new ArrayList<>();

		System.out.println("Please Enter Total Number Of Player");
		int noOfPlayers = Integer.parseInt(reader.readLine());
		while (noOfPlayers < 2) {
			System.out.println("You must have 2 or more player to play this game");
			System.out.println("Please Enter Total Number Of Player");
			noOfPlayers = Integer.parseInt(reader.readLine());
		}

		for (int i = 1; i <= noOfPlayers; i++) {
			players.add(new Player(i));
		}

		return players;
	}

	/*
	 * Initialize the game board
	 * */
	
	private ArrayList<Cell> prepareGameBoard() throws NumberFormatException, IOException {

		ArrayList<Cell> cells = new ArrayList<>();
		GameUtil gameUtil = GameUtil.getInstance();
		System.out.println("Please Enter Total Number Of Cell In Board");
		int cellCount = Integer.parseInt(reader.readLine());

		System.out.println("Please enter Type for each cell");
		for (int i = 0; i < cellCount; i++) {
			String type = reader.readLine();
			while (StringUtils.isEmpty(type)) {
				System.out.println("Type cannot be empty");
				type = reader.readLine();
			}

			type = type.toUpperCase();

			while (!gameUtil.validateCellType(type.charAt(0))) {
				System.out.println("Please enter validate data ('E', 'J', 'T', 'H')");
				type = reader.readLine();
			}

			Cell cell = new Cell();
			cell.setType(type.charAt(0));
			cells.add(cell);
		}
		return cells;

	}

	public  ArrayList<Player> getPlayers() {
		return players;
	}

	public  ArrayList<Cell> getCells() {
		return cells;
	}
	
	
}
