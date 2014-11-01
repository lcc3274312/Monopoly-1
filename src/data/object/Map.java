package data.object;

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
		
	}
	
	public void generateByUser() {
		
	}
	
	/** To print the map */
	public void show() {
		for (int i=0;i<10 ;i++) {
			for (int j=0;j<20 ;j++ ) {
				System.out.print(image[j][i]);
			}
			System.out.println();
		}
	}
}
