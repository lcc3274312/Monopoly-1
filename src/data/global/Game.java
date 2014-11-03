package data.global;

import data.module.*;
import data.object.*;

public class Game {
	/* WARNING:After changing PLAYER_NUM,you should add 
	 * PlayerIcon and CellIcon in Vocab.java,or other 
	 * players will be invisible */
	public static final int PLAYER_NUM = 2;
	
	// Create global object players[],player
	public static Player[] players = new Player[PLAYER_NUM + 1];
	static {
		for (int i = 0; i < players.length; i++) {
			Game.players[i] = new Player();
		}
	}
	
	public static int currentPlayer = 1;

    // Create global object maps and cells
	public static Map map = new Map();
	public static Map mapWithInfo = new Map();
	static {
		for (int i = 0; i < Map.length; i++) {
			map.route[i] = new Cell();
			mapWithInfo.route[i] = new Cell();
		}
	}
}
