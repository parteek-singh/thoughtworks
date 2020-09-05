package com.parteek.thoughtworks.entity;

import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import com.parteek.thoughtworks.util.GameUtil;

public class GameEngineTest {

	@Spy
	@InjectMocks
	private GameEngine gameEngine;

	@Mock
	GameUtil gameUtil;

	@Mock
	GameBoard gameBoard;

	ArrayList<Player> players;
	ArrayList<Cell> cells;
	int[] diceOutput;

	@Test
	public void testStartEngine() {
		MockitoAnnotations.initMocks(this);

		players = new ArrayList<>();

		Player player = new Player(0);
		Player player1 = new Player(1);
		Player player2 = new Player(2);
		players.add(player);
		players.add(player1);
		players.add(player2);

		char[] celltype = new char[] { 'E', 'E', 'J', 'H', 'E', 'T', 'J', 'T', 'E', 'E', 'H', 'J', 'T', 'H', 'E', 'E',
				'J', 'H', 'E', 'T', 'J', 'T', 'E', 'E', 'H', 'J', 'T', 'H', 'J', 'E', 'E', 'J', 'H', 'E', 'T', 'J', 'T',
				'E', 'E', 'H', 'J', 'T', 'E', 'H', 'E' };
		cells = new ArrayList<>();

		for (int i = 0; i < celltype.length; i++) {
			Cell cell = new Cell();
			cell.setIndex(i);
			cell.setType(celltype[i]);
			cells.add(cell);
		}

		diceOutput = new int[] { 4, 4, 4, 6, 7, 8, 5, 11, 10, 12, 2, 3, 5, 6, 7, 8, 5, 11, 10, 12, 2, 3, 5, 6, 7, 8, 5,
				11, 10, 12 };

		CellReward cellReward = CellReward.getInstance();
		when(gameEngine.getGameUtil()).thenReturn(gameUtil);
		when(gameEngine.getCellReward()).thenReturn(cellReward);
		when(gameEngine.getGamePlayer()).thenReturn(players);
		when(gameEngine.getBoardCells()).thenReturn(cells);
		when(gameBoard.getPlayers()).thenReturn(players);
		when(gameBoard.getCells()).thenReturn(cells);
		when(gameUtil.rollDice()).thenReturn(diceOutput[0], diceOutput[1], diceOutput[2], diceOutput[3], diceOutput[4],
				diceOutput[5], diceOutput[6], diceOutput[7], diceOutput[8], diceOutput[9], diceOutput[10], diceOutput[11], diceOutput[12], diceOutput[13], diceOutput[14],
				diceOutput[15], diceOutput[16], diceOutput[17], diceOutput[18], diceOutput[19],diceOutput[20], diceOutput[21], diceOutput[22], diceOutput[23], diceOutput[24],
				diceOutput[25], diceOutput[26], diceOutput[27], diceOutput[28], diceOutput[29]);

		gameEngine.startGame();
	}
}
