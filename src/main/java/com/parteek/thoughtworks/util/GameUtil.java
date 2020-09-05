package com.parteek.thoughtworks.util;

import org.springframework.stereotype.Component;

import com.parteek.thoughtworks.constant.GameConstants;

@Component
public class GameUtil {

	private final static int MAX = 12;
	private final static int MIN = 2;
	private static GameUtil gameUtil;
	private GameUtil() {
		
	}
	
	
	public static  GameUtil getInstance() {
		if(gameUtil == null) {
			synchronized (GameUtil.class) {
				if(gameUtil == null) {
					gameUtil = new GameUtil();
				}
			}
		}
		return gameUtil;

	}
	
	// Validate cell type entry 
	public boolean validateCellType(char type) {
		return GameConstants.ALLOWED_CELL_TYPE.indexOf(type) > -1;
	}

	/*
	 * Roll the dice
	 * */
	public int rollDice() {
		return (int) (Math.random() * (MAX - MIN + 1) + MIN);

	}
}
