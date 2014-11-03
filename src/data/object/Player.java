package data.object;

import data.module.Helper;

public class Player {
	// attr_accessor
	public String name = "noname", icon = "\u3000\u3000";
	public int location = 0, direction = 1;
	public int cash = 5000, deposit = 0, coupon = 0, property = 0;
	public int totalAssets = 0; // totalAssets is counted every time when show
	// define states
	int unmovableRound = 0;
	// define cells[] items[]
//	Integer[] cells = new Integer[Map.MAX_STEP];
	
	// def initialize
	public Player() {
	}
	
	// def method
	/** Control player to move */
	void move(int step) {
		// whether player can move?
		for (int i = 0; i < step; i++) {
			step();
			// whether player is blocked by barrier
//			if (Map.route[location].isBarrier) {
//				break;
//			}
		}
	}
	
	/** Use items */
	void useItem(int index) {
		
	}
	
	// def private method
	/** One step and deal with sth */
	void step() {
		location += direction;
		location = Helper.ensure(location);
	}

}
