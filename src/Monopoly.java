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
	
	static boolean endRound = false;
	
	private static void start() {
		while (!endRound) {                  // break if game finish
			Window.showDateInfo();
			while (true) {              // break if one player finish
				Window.showMenu();
				menuSelection();
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
		System.arraycopy(Game.map.image, 0, Game.mapWithInfo.image, 0, Game.map.image.length);
		System.arraycopy(Game.map.route, 0, Game.mapWithInfo.route, 0, Game.map.route.length);
	}
	
	public static void menuSelection() {
		switch (Helper.getInt(0, Vocab.Command.length - 1)) {
		case 0: // show map with info
			Game.mapWithInfo.update();
			Game.mapWithInfo.addPlayersInfo();
			Game.mapWithInfo.show(); 
			break;
		case 1: // show original map
			Game.map.show(); 
			break;
		case 2:
			break;
		case 3: // show barrier in 10 steps
			Window.showBarrier(10);
			break;
		case 4: // show info of certain cell
			Window.StepInputPrompt();
			String str_step = Helper.getStr(); 
			int step = 0;
			try {
				while (true) {
					step = Integer.parseInt(str_step);
					Window.showCellInfo(step);
					Window.StepInputPrompt();
					str_step = Helper.getStr(); 
				}
			} catch (NumberFormatException e) {
			}
			break;
		case 5: // show info of players
			Window.showPlayersInfo();
			break;
		case 7: // admit fail
			endGame();
		}

	}
	
	public static void switchPlayer() {
		Game.currentPlayer = 3 - Game.currentPlayer;
	}
	
	public static void endGame() {
		switchPlayer();
		Window.showEndGameWithWinOf(Game.players[Game.currentPlayer]);
		//Helper.getStr();
		System.exit(0);
	}
}
