import java.util.Scanner;
import data.object.*;
import data.module.*;
import data.global.*;

public class Monopoly {
	
	public static void main(String[] args) {
		Window.showGreeting();
		initialize();
		start();
//		Window.showCellInfo(5);
	}
	
	private static void start() {
		while (true) {                  // break if game finish
			Window.showDateInfo();
			while (true) {              // break if one player finish
				Window.showMenu();
				switch (Helper.getInt(0, Vocab.Command.length)) {
				case 0: Game.map.show(); break;
				//case 1: Game.mapWithInfo.show(); break;
				}
				break;
			}
			break;
		}
		
	}

	
	// chushihua she dangqian wanjia = player1 deng
	public static void initialize() {
		// Set game object
		setPlayers();
		// Set map
		setMap();
		//System.out.print(players[0].icon);
	}
	
	// private def method
	/** Enable user to set player's name and give an icon */
	public static void setPlayers() {
	//	Scanner input = new Scanner(System.in);
		for (int i = 0; i < Game.players.length; i++) {
			Window.nameInputForPlayer(i + 1);
			Game.players[i].name = Helper.getStr();
			if (i < Vocab.PlayerIcon.length) {
				Game.players[i].icon = Vocab.PlayerIcon[i];
			} 
		}
		//System.out.print(currentMap.route[1].icon);
	}
	
	/** Enable user to set map by random or himself */
	public static void setMap() {
		Game.map.generateByRandom();
		System.arraycopy(Game.map.image, 0, Game.mapWithInfo.image, 0, Game.map.image.length);
		System.arraycopy(Game.map.route, 0, Game.mapWithInfo.route, 0, Game.map.route.length);
	}
	
	public static void switchPlayer() {
		Game.currentPlayer = 1 - Game.currentPlayer;
	}
}
