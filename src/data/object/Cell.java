package data.object;

import data.global.Game;
import data.module.Vocab;


public class Cell {
	// attr accessor
	public int type = 0;
	public String icon = Vocab.CellIcon[type];
	public int street = 0, streetNo = 0;
	int x = 0, y = 0;
	public Player owner = Game.players[0];  // system
	public int level = 1, price = 0;
	public boolean isBarrier = false;
	
	// def initialize
	public Cell() {
	}
	
	// def method
	/** player raise the level of this cell */
	void levelUp() {
		
	}


}
