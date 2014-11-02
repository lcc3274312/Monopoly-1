package data.object;

import data.module.Vocab;


public class Cell {
	// attr accessor
	public int type = 0;
	String icon = Vocab.CellIcon[type];
	int street = 0, streetNo = 0;
	int x = 0, y = 0;
	Player owner = null;
	int level = 0, price = 0;
	boolean isBarrier = false;
	
	// def initialize
	public Cell() {
	}
	
	// def method
	/** player raise the level of this cell */
	void levelUp() {
		
	}


}
