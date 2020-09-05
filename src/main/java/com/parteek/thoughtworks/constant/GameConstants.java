package com.parteek.thoughtworks.constant;

import java.util.ArrayList;
import java.util.Arrays;

public class GameConstants {

	public static final char EMPTY = 'E';
	public static final char JAIL = 'J';
	public static final char TREASURE = 'T';
	public static final char HOTEL = 'H';

	public static final ArrayList<Character> ALLOWED_CELL_TYPE = new ArrayList<>(
			Arrays.asList(EMPTY, JAIL, TREASURE, HOTEL));
	public static final int MAX_CHANCES = 10;
	public static final double INITIAL_MONEY = 1000;
	public static final double HOTEL_WORTH = 200;
	public static final double HOTEL_RENT = 50;
	public static final double JAIL_FINE = 150;
	public static final double TREASURE_VALUE = 200;
}
