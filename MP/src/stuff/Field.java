package stuff;

public class Field {
	
	int round = 1;
	int startX = 0;
	int startY = 0;
	int endX = 0;
	int endY = 0;
	
	/*int[][]coor = {
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},	//b3
			{0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0},		
			{0, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0},			
			{0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 0},			
			{0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 0},			
			{0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 1, 0},			
			{0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 0},
			{0, 1, 1, 1, 0, 0, 0, 1, 1, 0, 1, 0},
			{0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0},
			{0, 1, 0, 0, 1, 0, 0, 1, 0, 1, 1, 0},
			{0, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};*/
	
	
	int[][]coor = {
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},	//b2	
			{0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0},		
			{0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0},			
			{0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0},			
			{0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0},
			{0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0},		
			{0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0},
			{0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0},
			{0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0},
			{0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0},
			{0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};	
	
	
	/*int[][]coor = {
			{0, 0, 0, 0, 0, 0, 0},	//b1
			{0, 1, 1, 1, 1, 1, 0},
			{0, 1, 1, 1, 1, 1, 0},
			{0, 1, 1, 1, 1, 1, 0},
			{0, 1, 1, 1, 1, 1, 0},
			{0, 1, 1, 1, 1, 1, 0},
			{0, 0, 0, 0, 0, 0, 0}}; */
	
	public boolean passable(int x, int y) {
		if (coor[x][y] == 1 && !(startX == x && startY == y)) {
			return true;
		}
		return false;
	}
	
	public void setUsed(int x, int y) {
		coor[x][y] = round;
	}
	
	public void roundUp() {
		this.round = round + 1;
	}
	
	public void roundDown() {
		this.round = round - 1;
	}
	
	public void startX(int x) {
		this.startX = x;
	}
	
	public void startY(int y) {
		this.startY = y;
	}
	
	public void endX(int x) {
		this.endX = x;
	}
	
	public void endY(int y) {
		this.endY = y;
	}

}
