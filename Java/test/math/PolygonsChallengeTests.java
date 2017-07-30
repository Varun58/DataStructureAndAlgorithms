package math;

import java.util.Map;

import org.junit.Test;

import junit.framework.Assert;
import math.PolygonsChallenge.Point;
import math.PolygonsChallenge.Shape;
import strings.RemoveDuplicateCharFromString;

public class PolygonsChallengeTests {

	@Test
	public void testPolygonsOfVariousSizesChecked() {
		Point[] points = new Point[10];
		PolygonsChallenge pc = new PolygonsChallenge();
		points[0] = pc.new Point(1,1,1,1);
		points[1] = pc.new Point(1,2,1,2);
		points[2] = pc.new Point(1,-1,1,1);
		points[3] = pc.new Point(-1,-1,-1,-1);
		points[4] = pc.new Point(0,1,0,1);
		points[5] = pc.new Point(1,2,4,5);
		points[6] = pc.new Point(11,1,1,1);
		points[7] = pc.new Point(-1,1,1,-1);
		points[8] = pc.new Point(0,0,0,0);
		points[9] = pc.new Point(4,5,4,5);
		
		Map<Shape,Integer> shapeCountMap = pc.checkPoints(points);
		
		Assert.assertTrue(3==shapeCountMap.get(Shape.Rectangle));
		Assert.assertTrue(3==shapeCountMap.get(Shape.Square));
		Assert.assertTrue(4==shapeCountMap.get(Shape.Other));
	}
	
	@Test
	public void testCountNumberOfSquaresWhenBothLinesDifferent() {
		int squares =PolygonsChallenge.countNumberOfSquares(4, 3);
		Assert.assertEquals("failed for different lines", 20,squares);
	}
	
	@Test
	public void testCountNumberOfSquaresWhenBothLinesEqual() {
		int squares =PolygonsChallenge.countNumberOfSquares(3, 3);
		Assert.assertEquals("failed for equal lines should be 14 (9+4+1)", 14,squares);
		
		 squares =PolygonsChallenge.countNumberOfSquares(4, 4);
		Assert.assertEquals("failed for equal lines should be 30 (16+9+4+1)", 30,squares);
	}
}

