package data.module;

import data.global.Game;
import data.object.*;

public class Window {
	
	public static void showGreeting() {
		//String a = Vocab.DateInfo;
	}
	
	public static void nameInputForPlayer(int index) {
		System.out.printf(Vocab.NameInputPrompt, index);
	}
	
	public static void showMapRegeneratePrompt() {
		System.out.print(Vocab.MapRegeneratePrompt);
	}
	
	public static void showDateInfo() {
		System.out.print(Game.dateShowFormat.format(Game.date));
	}
	
	public static void showMenu() {
		System.out.printf(Vocab.CurrentPlayerInfo, Game.players[Game.currentPlayer].name,"");
		for (int i = 0; i < Vocab.Command.length; i++) {
			System.out.println(i + " - " + Vocab.Command[i]);
		}
		System.out.printf("ÇëÑ¡Ôñ£º");
	}
	
	public static void showBarrier(int step) {
		int location = Game.players[Game.currentPlayer].location;
		boolean flag = false;
		for (int i = 0; i < step; i++) {
			if (Game.mapWithInfo.route[Helper.ensure(location + i + 1)].isBarrier) {
				System.out.printf(Vocab.BarrierInfo, i + 1);
				flag = true;
			}
		}
		if (!flag) {
			System.out.printf(Vocab.NoBarrierInfo, step);
		}
	}
	
	public static void StepInputPrompt() {
		System.out.print(Vocab.StepInputPrompt);
	}
	
	public static void showCellInfo(int step) {      // step > 0 => anti clock direction
		int location = Helper.ensure(Game.players[Game.currentPlayer].location + step);
		System.out.printf("%-8s" + Vocab.CellTypeName[Game.mapWithInfo.route[location].type], Vocab.CellInfoListHead[0]);
		if (Game.mapWithInfo.route[location].type == 0) {
			System.out.printf("%-8s" + Vocab.StreetName[Game.mapWithInfo.route[location].street], Vocab.CellInfoListHead[1], Game.mapWithInfo.route[location].streetNo);
			System.out.printf("%-6s" + Game.mapWithInfo.route[location].price + "\n", Vocab.CellInfoListHead[2]);
			System.out.printf("%-6s" + Game.mapWithInfo.route[location].level + "\n", Vocab.CellInfoListHead[3]);
			System.out.printf("%-7s" + Game.mapWithInfo.route[location].owner.name + "\n", Vocab.CellInfoListHead[4]);
		}	
		System.out.println();
	}
	
	public static void showPlayersInfo() {
		System.out.print(Vocab.ShowPlayersInfoPrompt);
		System.out.printf("%-10s%-6s%-6s%-6s%-6s%-6s\n", Vocab.PlayersInfoListHead[0], Vocab.PlayersInfoListHead[1], Vocab.PlayersInfoListHead[2], Vocab.PlayersInfoListHead[3], Vocab.PlayersInfoListHead[4], Vocab.PlayersInfoListHead[5]);
		for (int i = 1; i < Game.players.length; i++) {
			System.out.printf(" %-12s%-8d%-8d%-8d%-8d%-8d\n", Game.players[i].name, Game.players[i].coupon, Game.players[i].cash, Game.players[i].deposit, Game.players[i].property, Game.players[i].totalAssets);
		}
	}
	
	public static void showDiceInfo(int diceStep) {
		System.out.printf(Vocab.DiceInfo, diceStep);
	}
	
	public static void showEndGameWithWinOf(Player player) {
		System.out.printf(Vocab.ShowEndGame, player.name);
	}

}
