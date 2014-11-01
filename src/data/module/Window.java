package data.module;

import data.global.Game;
//import data.object.*;

public class Window {
	
/*	public static void main(String[] args) {
		showDateInfo();
		showMenu();
		showCellInfo(5);
	}*/
	
	public static void showGreeting() {
		//String a = Vocab.DateInfo;
	}
	
	public static void nameInputForPlayer(int index) {
		System.out.printf(Vocab.NameInputPrompt, index);
	}
	
	public static void showDateInfo() {
		System.out.printf(Vocab.DateInfo,1,1);
	}
	
	public static void showMenu() {
		System.out.printf(Vocab.CurrentPlayerInfo, Game.players[Game.currentPlayer].name,"");
		for (int i = 0; i < Vocab.Command.length; i++) {
			System.out.println(i + " - " + Vocab.Command[i]);
		}
	}
	
	public static void showCellInfo(int index) {      // index has been ensured
		System.out.println(Vocab.CellTypeName[Game.mapWithInfo.route[index].type]);
	}

}
