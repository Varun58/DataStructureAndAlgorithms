package math;

public class TwoRectanglesOverlap {

	
	//One method : check if one point is above other of the rectangle
	//Second method : need to explore
	
	public static void main(String[] args) {
		Point l1 = new Point(0, 10);
		Point r1 = new Point(10, 0);
		Point l2 = new Point(5, 5);
		Point r2 = new Point(15, 0);

		System.out.println(doRectanglesOverlap(l1, r1, l2, r2));
	}

	private static boolean doRectanglesOverlap(Point l1, Point r1, Point l2, Point r2) {

		if (l1.x > r2.x || l2.x > r1.x) {
			return false;
		}

		if (r2.y > l1.y || r1.y > l2.y) {
			return false;
		}

		return true;
	}
}

class Point {

	int x;
	int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
