package data.object;

import data.module.Helper;
import data.module.Vocab;

public class Map {
	// attr_accessor
	public static final int WIDTH = 20, HEIGHT = 10;
	public static int length = 56;
	
	public String[][] image = new String[WIDTH][HEIGHT];
	public Cell[] route = new Cell[length];
	
	// def initialize
	/** Fill image with blank */
	public Map() {
		for (int i = 0; i < WIDTH; i++ ) {
			for (int j = 0; j < HEIGHT; j++ ) {
				image[i][j] = "\u3000\u3000";
			}
		}
	}
	
	//def method
	/** Generate the map by random */
	public void generateByRandom() {
		generateShape();
		generateSite();
	}
	
	private void generateShape() {
		// Get three random turning points
		int[] x = new int[3];
		int[] y = new int[3];
		for (int i=0; i<3; i++) {
			x[i] = 6 * i + Helper.rand(6);
			if ((i != 0) && (x[i] == x[i-1] + 1)) {
				x[i]+=1;
			}
			y[i] = 3 * i + Helper.rand(3);  
			if ((i != 0) && (y[i] == y[i-1] + 1)) {
				y[i]+=1;
			}
		}
		// Walk the map and set the x,y for cell on route 
		int step = 0;
		for (int i = 0; i < y[2]; i++) {
			route[step].x = 0;
			route[step].y = i;
			step++;
		}		
		for (int i = 0; i < x[0]; i++) {
			route[step].x = i;
			route[step].y = y[2];
			step++;
		}
		for (int i = y[2]; i < HEIGHT - 1; i++) {
			route[step].x = x[0];
			route[step].y = i;
			step++;
		}
		for (int i = x[0]; i < x[1]; i++) {
			route[step].x = i;
			route[step].y = HEIGHT - 1;
			step++;
		}
		for (int i = HEIGHT - 1; i > y[1]; i--) {
			route[step].x = x[1];
			route[step].y = i;
			step++;
		}
		for (int i = x[1]; i < WIDTH - 1; i++)	{
			route[step].x = i;
			route[step].y = y[1];
			step++;
		}
		for (int i = y[1]; i > y[0]; i--) {
			route[step].x = WIDTH - 1;
			route[step].y = i;
			step++;
		}
		for (int i = WIDTH - 1; i > x[2]; i--) {
			route[step].x = i;
			route[step].y = y[0];
			step++;
		}
		for (int i = y[0]; i > 0; i--) {
			route[step].x = x[2];
			route[step].y = i;
			step++;
		}
		for (int i = x[2]; i > 0; i--) {
			route[step].x = i;
			route[step].y = 0;
			step++;
		}
	}

	private void generateSite() {
		int street = 1, step = 0;
		int[] siteNum = new int[] {0,4,2,2,3,2,3};  // Refer to Vocab.CellTypeName
		// create 8 streets, 4*((4+6)||(5+5)||(6+4))
		int randStMaxNo = 0, randSiteType = 0;
		for (int i = 0; i < 4; i++) {
			randStMaxNo = Helper.rand(3) + 4;
			for (int j = 0; j < randStMaxNo; j++) {
				route[step].street = street;
				route[step].streetNo = j + 1;
				step++;
			}
			street++;
			for (int j = 0; j < Helper.rand(2) + 1; j++) {
				do {
					randSiteType = Helper.rand(6) + 1;
				} while (siteNum[randSiteType] == 0); 
				route[step].type = randSiteType;
				route[step].icon = Vocab.CellIcon[randSiteType];
				step++;
			}
			for (int j = 0; j < (10 - randStMaxNo); j++) {
				route[step].street = street;
				route[step].streetNo = j + 1;
				step++;
			}
			street++;
			for (int j = 0; j < Helper.rand(2) + 1; j++) {
				do {
					randSiteType = Helper.rand(6) + 1;
				} while (siteNum[randSiteType] == 0); 
				route[step].type = randSiteType;
				route[step].icon = Vocab.CellIcon[randSiteType];
				step++;
			}
		}
		for (int j = step; j < route.length; j++) {
			do {
				randSiteType = Helper.rand(6) + 1;
			} while (siteNum[randSiteType] == 0); 
			route[step].type = randSiteType;
			route[step].icon = Vocab.CellIcon[randSiteType];
			step++;
		}
	}

	/** To print the map */
	public void show() {
		// Update image by route
		for (int i = 0; i < route.length; i++) {
			image[route[i].x][route[i].y] = route[i].icon;
		}
		// Print image
		for (int i = 0; i < HEIGHT; i++) {
			for (int j = 0; j < WIDTH; j++) {
				System.out.print(image[j][i]);
			}
			System.out.println();
		}
	}
	
	/** To clear the map */
	public void clear() {
		// clear image
		for (int i = 0; i < WIDTH; i++ ) {
			for (int j = 0; j < HEIGHT; j++ ) {
				image[i][j] = "\u3000\u3000";
			}
		}
		// clear route
		for (int i = 0; i < route.length; i++) {
			route[i] = new Cell();
		}
	}
}
