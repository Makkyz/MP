package stuff;
import java.util.ArrayList;

public class BFS {
	
	static boolean foundEnd = false;
	
	public static void main(String[] args) {
		
		Field field = new Field();
		
		int startX = 5;
		int startY = 4;
		int endX = 4;
		int endY = 6;
		
		field.endX(endX);
		field.endY(endY);
		field.startX(startX);
		field.startY(startY);
		
		System.out.println(startY + ";" + startX + " " + field.round);
		System.out.println();
		
		ArrayList<Integer> stuffX1 = new ArrayList<Integer>();
		ArrayList<Integer> stuffY1 = new ArrayList<Integer>();
		ArrayList<Integer> stuffX2 = new ArrayList<Integer>();
		ArrayList<Integer> stuffY2 = new ArrayList<Integer>();
		
		
		use(field, startX, startY, stuffX1, stuffY1);
		
		
		int x = 0;
		while (x < 500 && !foundEnd) { // x < 500 to prevent program running forever, just in case
			x++;
			
			field.roundUp();
			for (int i = 0; i < stuffX1.size(); i++) {
				search(field, stuffX1.get(i), stuffY1.get(i), stuffX2, stuffY2);
			}
			//stuff1 empty
			stuffX1.clear();
			stuffY1.clear();
			
			//test print 1
			for (int i = 0; i < stuffX2.size(); i++) {
				System.out.println(stuffX2.get(i) + ";" + stuffY2.get(i) + " " + field.coor[stuffX2.get(i)][ stuffY2.get(i)]);
			}
			
			System.out.println();
			
			if (!foundEnd) {
				field.roundUp();
				for (int i = 0; i < stuffX2.size(); i++) {
					search(field, stuffX2.get(i), stuffY2.get(i), stuffX1, stuffY1);
				}
				
				stuffX2.clear();
				stuffY2.clear();
				
				//test print 2
				for (int i = 0; i < stuffX1.size(); i++) {
					System.out.println(stuffX1.get(i) + ";" + stuffY1.get(i)+ " " + field.coor[stuffX1.get(i)][ stuffY1.get(i)]);
				}
				
				System.out.println();
			}
		}
		
		//after finding the end
		
		ArrayList<Integer> path1x = new ArrayList<Integer>();
		ArrayList<Integer> path1y = new ArrayList<Integer>();
		
		path1x.add(field.endX);
		path1y.add(field.endY);
		
		for (int i = field.round; i >= 1 ; i--) {
			search(field, path1x.get(path1x.size() - 1), path1y.get(path1y.size() - 1), field.round, path1x, path1y);
			field.roundDown();
		}
		
		//"Path (switched x and y to be like the 'maze' in Field class):");
		
		for (int i = path1x.size(); i > 0; i--) {
			System.out.println(path1y.get(i - 1) + ";" + path1x.get(i - 1));
		}
	    
	}
	
	public static void search(Field f, int x, int y, ArrayList<Integer> aX,  ArrayList<Integer> aY) {
		if (f.passable(x - 1, y)) {
			use(f, x - 1, y, aX, aY);
		}
		if (f.passable(x + 1, y)) {
			use(f, x + 1, y, aX, aY);
		}
		if (f.passable(x, y - 1)) {
			use(f, x, y - 1, aX, aY);
		}
		if (f.passable(x, y + 1)) {
			use(f, x, y + 1, aX, aY);
		}
		
	}
	
	public static void use(Field f, int x, int y, ArrayList<Integer> aX,  ArrayList<Integer> aY) {
		if (f.endX == x && f.endY == y) {
			foundEnd = true;
		}
		f.setUsed(x, y);
		aX.add(x);
		aY.add(y);
	}
	
	public static void search(Field f, int x, int y, int r, ArrayList<Integer> xa,  ArrayList<Integer> ya) {
		if (f.coor[x - 1][y] == r) {
			xa.add(x - 1);
			ya.add(y);
		} else if (f.coor[x + 1][y] == r) {
			xa.add(x + 1);
			ya.add(y);
		} else if (f.coor[x][y - 1] == r) {
			xa.add(x);
			ya.add(y - 1);
		} else if (f.coor[x][y + 1] == r) {
			xa.add(x);
			ya.add(y + 1);
		}
	}

}
