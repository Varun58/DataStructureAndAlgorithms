package test;

import java.util.Scanner;

public class PointsOnSquare {

	/*
	 * 5 5 3 5 3 0 0 0 4 3 0 1 5
	 */

	// 6

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int k = in.nextInt();
		Point[] pr = new Point[m];
		int[] visited = new int[m];
		int visitCount = 0;
		for (int a0 = 0; a0 <m; a0++) {
			int x = in.nextInt();
			int y = in.nextInt();
			Point p = new Point(x, y);
			pr[a0] = p;
		}

		int x = 0, d = 0, i = 0;
		int min = Integer.MIN_VALUE;
		while (visitCount != k) {
			while (x < k && i < pr.length - 1) {
				if (i + 1 == pr.length - 1) {
					i=0;
				}
				d = distance(pr[i], pr[i + 1]);
				visited[i]++;
				visited[i+1]++;
				visitCount= Math.max(visitCount, visited[i+1]);
				i = i++;

			}

			if (x == k && d < min) {
				min = d;
			}

			x = 0;
			d = 0;

		}
		
		System.out.println(min);
		in.close();
	}

	static int distance(Point p1, Point p2) {
		return (int) Math.pow((Math.pow((p1.x - p2.x), 2) + Math.pow((p1.y - p2.y), 2)), 1 / 2);
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
