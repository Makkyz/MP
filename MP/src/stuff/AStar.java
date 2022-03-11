package stuff;

import java.util.ArrayList;

public class AStar {
	
	public static void main(String[] args) {
		
		int startX = 1;
		int startY = 1;
		int endX = 10;
		int endY = 10;
		
		Field field = new Field();
		char parent[][] = new char[field.coor.length][field.coor[0].length]; //r-right, l-left, u-up, d-down
		int distStart[][] = new int[field.coor.length][field.coor[0].length];
		
		field.endX(endX);
		field.endY(endY);
		field.startX(startX);
		field.startY(startY);
		
		ArrayList<Integer> usedX = new ArrayList<Integer>();
		ArrayList<Integer> usedY = new ArrayList<Integer>();
		ArrayList<Integer> usableX = new ArrayList<Integer>();
		ArrayList<Integer> usableY = new ArrayList<Integer>();
		
		usableX.add(startX);
		usableY.add(startY);
		setValue(startX, startY, field.coor, field, startX, startY, distStart);
		
		//main search loop
		boolean endFound = false;
		while(!endFound) {
			int inList = findSmol(usableX, usableY, field.coor);
			int x = usableX.get(inList);
			int y = usableY.get(inList);
			used(x, y, inList, usableX, usableY, usedX, usedY);
			
			if(x == endX && y == endY) {
				endFound = true;
			}
			
			if(!endFound) {
				if ((!isInList(x - 1, y, usedX, usedY)) && field.coor[x - 1][y] != 0) {
					checkAndUse(x - 1, y, field, usableX, usableY, parent, x, y, distStart);
					parent[x - 1][y] = 'r'; //parent is on the right from new node
				}
				if ((!isInList(x + 1, y, usedX, usedY)) && field.coor[x + 1][y] != 0) {
					checkAndUse(x + 1, y, field, usableX, usableY, parent, x, y, distStart);
					parent[x + 1][y] = 'l';
				}
				if ((!isInList(x, y - 1, usedX, usedY)) && field.coor[x][y - 1] != 0) {
					checkAndUse(x, y - 1, field, usableX, usableY, parent, x, y, distStart);
					parent[x][y - 1] = 'd';
				}
				if ((!isInList(x, y + 1, usedX, usedY)) && field.coor[x][y + 1] != 0) {
					checkAndUse(x, y + 1, field, usableX, usableY, parent, x, y, distStart);
					parent[x][y + 1] = 'u';
				}
			}
			
		}
		
		System.out.println();
		printList(field.coor);
		System.out.println();
		
		ArrayList<Integer> pathX = new ArrayList<Integer>();
		ArrayList<Integer> pathY = new ArrayList<Integer>();
		pathX.add(field.endX);
		pathY.add(field.endY);
		int x = field.endX;
		int y = field.endY;
		
		while (!(x == field.startX && y == field.startY)) {
			char direction = parent[x][y];
			switch (direction) {
			case 'r':
				x = x + 1;
				break;
			case 'l':
				x = x - 1;
				break;
			case 'u':
				y = y - 1;
				break;
			case 'd':
				y = y + 1;
				break;}
			
			pathX.add(x);
			pathY.add(y);
		}
		
		for (int i = pathY.size(); i > 0; i--) {
			System.out.println(pathY.get(i - 1) + ";" + pathX.get(i - 1));	//switched to match maze again
		}
		
	}
	
	public static void checkAndUse(int x, int y, Field field, ArrayList<Integer> usableX,
			ArrayList<Integer> usableY, char parent[][], int lastX, int lastY, int dist[][]) {
		
		if (!isInList(x, y, usableX, usableY)) {
			usableX.add(x);
			usableY.add(y);
			
			if (getValue(x, y, field.coor, field, lastX, lastY, dist) < field.coor[x][y] || field.coor[x][y] == 1) {
				setValue(x, y, field.coor, field, lastX, lastY, dist);
				
			}
		}
	}
	
	public static void setValue(int x, int y, int val[][], Field f, int lastX, int lastY, int dist[][]) {
		int lastVal = dist[lastX][lastY];
		
		int distStart = lastVal + abs(x - lastX) + abs(y - lastY);
		int distEnd = abs(x - f.endX) + abs(y - f.endY);
		val[x][y] = distStart + distEnd;
		dist[x][y] = distStart;
	}
	
	public static int getValue(int x, int y, int val[][], Field f, int lastX, int lastY, int dist[][]) {
		int distStart = dist[lastX][lastY] + abs(x - lastX) + abs(y - lastY);
		int distEnd = abs(x - f.endX) + abs(y - f.endY);
		return distStart + distEnd;
	}
	
	public static boolean isInList(int x, int y, ArrayList<Integer> usedX, ArrayList<Integer> usedY) {
		for (int i = 0; i < usedX.size(); i++) {
			if (usedX.get(i) == x && usedY.get(i) == y) {
				return true;
			}
		}
		return false;
	}
	
	public static int findSmol(ArrayList<Integer> aX, ArrayList<Integer> aY, int val[][]) {
		int a = val[aX.get(0)][aY.get(0)];
		int x = 0;
		for (int i = 1; i < aX.size(); i++) {
			if (val[aX.get(i)][aY.get(i)] < a) {
				a = val[aX.get(i)][aY.get(i)];
				x = i;
			}
		}
		return x;
	}
	
	public static void used(int x, int y, int pos, ArrayList<Integer> unusedX, 
			ArrayList<Integer> unusedY, ArrayList<Integer> usedX, ArrayList<Integer> usedY) {
		unusedX.remove(pos);
		unusedY.remove(pos);
		usedX.add(x);
		usedY.add(y);
	}
	
	public static void printList(int a[][]) {
		for (int i = 0; i < a.length; i++) {
			for (int ii = 0; ii < a[i].length; ii++) {
				System.out.print(a[i][ii] + " ");
			}
			System.out.println();
		}
	}
	
	public static int abs(int x) {
		if (x < 0) {
			x = x * (-1);
		}
		return x;
	}

}
