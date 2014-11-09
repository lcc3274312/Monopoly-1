import java.io.IOException;
import java.text.ParseException;

import data.object.*;
import data.module.*;
import data.global.*;

public class Monopoly {
	
	public static void main(String[] args) {
		Window.showGreeting();
		switch (Helper.getStr()) {
		case "x": System.exit(0); break;
		case "s": load(); break;
		default: initialize();
		}
		setTime();
		start();  
	}
	

	static boolean afterLoad = false;
	static boolean endRound = false;
	
	private static void start() {
		// after load, run remaining round
		while (true) {   
			for (int i = (afterLoad ? Game.currentPlayer : 1); i < Game.players.length; i++) {   // one round
				endRound = false; 
				afterLoad = false;
				while (!endRound) {          // break if one player finish
					Window.showDateInfo();
					Window.showMenu();
					menuSelection();
				}
				if (Time.endOfMonth()) {
					Game.bank.interest(Game.currentPlayer);
				}
			}	
			Time.nextDay();
		}
	}

	
	/** initialize the players, map, time 
	 * // to give them values != create them */
	public static void initialize() {
		setPlayers();
		setMap();
	}
	
	/** Enable user to set player's name and give an icon */
	public static void setPlayers() {
		for (int i = 1; i < Game.players.length; i++) {
			Window.nameInputForPlayer(i);
			Game.players[i].name = Helper.getStr();
			if (i < Vocab.PlayerIcon.length) {
				Game.players[i].icon = Vocab.PlayerIcon[i];
			} // else player.icon will be a default value "\u3000\u3000"
		}
	}
	
	/** Enable user to set map by random //or himself */
	public static void setMap() {
		do {
			Game.map.clear();
			Game.map.generateByRandom();
			Game.map.update();
			Game.map.show();
			Window.showMapRegeneratePrompt();
		} while (Helper.getStr().equals("r"));
		// copy map
		for (int i = 0; i < Map.HEIGHT; i++) {
			for (int j = 0; j < Map.WIDTH; j++) {
				Game.mapWithInfo.image[j][i] = Game.map.image[j][i];
			}
		}
		for (int i = 0; i < Map.length; i++) {
			Game.mapWithInfo.route[i] = Game.map.route[i];
		}
	}
	
	public static void setTime() {
  		try {
  			Game.date = Game.dateFormat.parse(Time.nowStr);
  		    Game.dateCalendar.setTime(Game.date);
  		} catch (ParseException e) {
  		}
	}
	
	public static void menuSelection() {
		switch (Helper.getInt(0, Vocab.Command.length - 1)) {
		case 0: showMapWithInfo();       break;
		case 1: showMap();               break;
		case 2: showItemList();          break;
		case 3: showBarrierIn10Steps();  break;
		case 4: showInfoOfCertainCell(); break;
		case 5: showPlayersInfo();       break;
		case 6: diceAndGo();             break;
		case 7: save();					 break;
		case 8: endGame();
		}

	}

	// Selection methods
	private static void showMapWithInfo() {
		Game.mapWithInfo.update();
		Game.mapWithInfo.addPlayersInfo();
		Game.mapWithInfo.show(); 
		Helper.getEnter();
	}
	
	private static void showMap() {
		Game.map.show(); 
		Helper.getEnter();
	}
	
	private static void showItemList() {
		Window.showItemSelectList(Game.players[Game.currentPlayer].items);
		int n = Helper.getInt(0, Game.players[Game.currentPlayer].items.length - 1);
		if (n != 0) {
			Game.players[Game.currentPlayer].useItem(n);
		}	
	}
	
	
	private static void showBarrierIn10Steps() {
		Window.showBarrier(10);
		Helper.getEnter();
	}
	
	private static void showInfoOfCertainCell() {
		String str_deltaStep = ""; 
		int deltaStep = 0;
		try {
			while (true) {
				Window.stepInputPrompt();
				str_deltaStep = Helper.getStr(); 
				deltaStep = Integer.parseInt(str_deltaStep);
				Window.showCellInfo(deltaStep);
			}
		} catch (NumberFormatException e) {
			System.out.println();
		}
	}
	
	private static void showPlayersInfo() {
		Window.showPlayersInfo();
		Helper.getEnter();
	}
	
	private static void diceAndGo() {
		int step = dice();
		if (Game.players[Game.currentPlayer].slowRound > 0) {
			step = 1;
			Game.players[Game.currentPlayer].slowRound--;
		}
		Window.showDiceInfo(step);
		Game.players[Game.currentPlayer].move(step);
		Helper.getEnter();
		showMapWithInfo();
		caseLocation();
		switchPlayer();
		endRound = true;
	}
	
	private static void save() {
		try {
			Game.save();
		} catch (IOException e) {
			Window.showErrorInfo(Vocab.UnknownSaveError);
		}	
	}

	private static void load() {
		try {
			Game.load();
			afterLoad = true;
		} catch (IOException e) {
			Window.showErrorInfo(Vocab.UnknownLoadError);
			Helper.getEnter();
			System.exit(0);
		}	
	}
	//==============================
	
	private static void caseLocation() {
		switch (Game.mapWithInfo.route[Game.players[Game.currentPlayer].location].type) {
		case 0: fieldDeal(); break;
		case 1: shopDeal();  break;
		case 2: /* dealed in move() */ break;
		case 3: new Item(11); break; // news
		case 4: new Item(12); break;
		case 5: getItem(); break;
		case 6: getCoupon(); break;
		}
		
	}

	private static void fieldDeal() {
		Window.showCellInfo(0);
		if (Game.mapWithInfo.route[Game.players[Game.currentPlayer].location].owner == 0) {
			Window.buyPrompt();
			switch (Helper.getInt(0, 1)) {
			case 1: Game.players[Game.currentPlayer].buy();
			case 0:
			}
		} else if (Game.mapWithInfo.route[Game.players[Game.currentPlayer].location].level < Cell.MAX_LEVEL && Game.mapWithInfo.route[Game.players[Game.currentPlayer].location].owner == Game.currentPlayer) {
			Window.levelUpPrompt();
			switch (Helper.getInt(0, 1)) {
			case 1: Game.players[Game.currentPlayer].levelUp();
			case 0:
			}
		} else {
			if (Game.players[Game.currentPlayer].fineFreeRound > 0) {
				Game.players[Game.currentPlayer].fineFreeRound--;
			} else {
				Game.players[Game.currentPlayer].fined();
			}
		}
		
	}


	private static void shopDeal() {
		Window.showCellGreeting(1);
		Window.showShopMenu();
		int n = Helper.getInt(0, Item.ItemNum);
		if (n != 0) {
			
		}
	}


	private static void getItem() {
		int randItem = Helper.rand(10) + 1;
		Game.players[Game.currentPlayer].getItem(randItem);
	}
	
	private static void getCoupon() {
		int randCoupon = Helper.rand(5) * 10 + 10;
		Game.players[Game.currentPlayer].getCoupon(randCoupon);
	}


	private static int dice() {
		return Helper.rand(6) + 1; 
	}
	
	/** Switch player
	 *  rewrite it if you change the player number */
	private static void switchPlayer() {
		Game.currentPlayer = 3 - Game.currentPlayer;
	}
	
	public static void endGame() {
		switchPlayer();
		Window.showEndGameWithWinOf(Game.players[Game.currentPlayer]);
		Helper.getEnter();
		System.exit(0);
	}
}
