package data.global;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
	
	// Create date info
	public static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	public static DateFormat dateShowFormat = new SimpleDateFormat(Vocab.DateShowFormat);
    public static Date date ;//= dateFormat.parse("2014-01-01");
  	public static Calendar dateCalendar = Calendar.getInstance();

}
