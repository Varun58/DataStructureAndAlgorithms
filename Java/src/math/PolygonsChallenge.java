package math;

import java.util.HashMap;
import java.util.Map;

public class PolygonsChallenge {

	enum Shape{
		Square,Rectangle,Other;
	}
	
	private static Shape checkShapeType(int a, int b , int c , int d) {
		if(a<0 || b<0 || c<0 || d<0) {
			return Shape.Other;
		}
		
		if(a==b && b==c || c==d) {
			return Shape.Square;
		}
		
		if(a==c || b==d) {
			return Shape.Rectangle;
		}
		return Shape.Other;
	}
	
	public static Map<Shape,Integer> checkPoints(Point[] points) {
		Map<Shape,Integer> shapeCount = new HashMap<Shape,Integer>();
		
		shapeCount.put(Shape.Square, 0);
		shapeCount.put(Shape.Rectangle, 0);
		shapeCount.put(Shape.Other, 0);
		
		for( Point p : points) {
			Shape s =checkShapeType(p.a,p.b,p.c,p.d);
			shapeCount.put(s, shapeCount.get(s)+1);
		}
		return shapeCount;
	}
	
	class Point{
		public Point(int i, int j, int k, int l) {
			this.a=i;
			this.b=j;
			this.c=k;
			this.d=l;
		}
		
		public Point() {}

		int a,b,c,d;
	}
	
	public  static int countNumberOfSquares(int m, int n) {
		
		if(n<m) {
			int temp = n;
			 n = m;
			 m=temp;
		}
		
		return ((n-m)*m*(m+1)/2) + m*(m+1)*(2*m+1)/6;
	}
	
	/*
	 * tgons=[[1,1,1,1],[1,2,1,2],[1,2,3,4],[-1,-2,-1,-2],[1,0,1,0]]
		squares=0
		rects = 0
		neithers = 0
		for gon in tgons:
		    if any(n <= 0 for n in gon): #if any integers <= 0, it's invalid
		        neithers+=1
		    elif len(set(gon)) == 1: #if all integers are equal, it's a square
		        squares+=1
		    elif gon[0] == gon[2] and gon[1] == gon[3]: #if both pairs of opposing sides have equal length, it's a rectangle
		        rects+=1
		    else:
		        neithers+=1
		print squares,rects,neithers
	 * */
}
