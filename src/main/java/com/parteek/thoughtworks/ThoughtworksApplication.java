package com.parteek.thoughtworks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.parteek.thoughtworks.entity.GameBoard;
import com.parteek.thoughtworks.entity.GameEngine;

@SpringBootApplication
public class ThoughtworksApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThoughtworksApplication.class, args);

		GameBoard gameBoard = new GameBoard();
		gameBoard.initGame();

		GameEngine engine = new GameEngine(gameBoard);
		engine.startGame();

	}

}
