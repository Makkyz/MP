package stuff;

import java.util.ArrayList;

public class DFS {

	public static void main(String[] args) throws InterruptedException {
		
		Field field = new Field();
		
		int startX = 1;
		int startY = 1;
		int endX = 9;
		int endY = 9;
		
		field.startX(startX);
		field.startY(startX);
		field.endX(endX);
		field.endY(endY);
		ArrayList<Integer> saveX = new ArrayList<Integer>();
		ArrayList<Integer> saveY = new ArrayList<Integer>();
		saveX.add(startX);
		saveY.add(startY);
		
		boolean endFound = false;
		int x = startX;
		int y = startY;
		int round = 1;
		
		while(!endFound) {
			
			if (field.coor[x - 1][y] == 1 && !isStart(field, x - 1, y)) {
				save(saveX, saveY, x - 1, y, field, round);
				round++;
			} else if (field.coor[x + 1][y] == 1 && !isStart(field, x + 1, y)) {
				save(saveX, saveY, x + 1, y, field, round);
				round++;
			} else if (field.coor[x][y - 1] == 1 && !isStart(field, x, y - 1)) {
				save(saveX, saveY, x, y - 1, field, round);
				round++;
			} else if (field.coor[x][y + 1] == 1 && !isStart(field, x, y + 1)) {
				save(saveX, saveY, x, y + 1, field, round);
				round++;
			} else {
				delete(saveX, saveY, round);
				round--;
			}
			
			x = saveX.get(round - 1);
			y = saveY.get(round - 1);
			
			if (x == endX && y == endY) {
				endFound = true;
			}
			
		}
		
		for (int i = 0; i < field.coor.length; i++) {
			for (int ii = 0; ii < field.coor[i].length; ii++) {
				System.out.print(field.coor[i][ii] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
		for (int i = 0; i < saveX.size(); i++) {
			System.out.println(saveY.get(i) + ";" + saveX.get(i));
		}
		
	}
	
	public static void save(ArrayList<Integer> listX, ArrayList<Integer> listY, int x, int y, Field f, int r) {
		f.coor[x][y] = r + 1;
		listX.add(x);
		listY.add(y);
	}
	
	public static void delete(ArrayList<Integer> listX, ArrayList<Integer> listY, int r) {
		listX.remove(r - 1);
		listY.remove(r - 1);
	}
	
	public static boolean isStart(Field f, int x, int y) {
		if (x == f.startX && y == f.startY) {
			return true;
		}
		return false;
	}

}