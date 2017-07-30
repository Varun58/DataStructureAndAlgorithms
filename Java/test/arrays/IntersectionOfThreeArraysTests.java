package arrays;

import java.util.List;
import java.util.Set;

import org.junit.Test;

import junit.framework.Assert;

public class IntersectionOfThreeArraysTests {

	
	/*@Before
	public void setUp() {
		
	}*/
	
	@Test
	public void testIntersectionOf3SortedArraysUsingSingleLoop() {
		
		int arr1[] = {1,3,4,5,6};
		int arr2[] = {2,4,7,9,20};
		int arr3[] = {0,1,2,3,4};
	
		List<Integer> intersection = IntersectionOfThreeArrays
				.getIntersectionOf3SortedArraysUsingSingleLoop(arr1, arr2, arr3);
		
		Assert.assertEquals("4 should be the common of the 3 arrays.",  new Integer(4), intersection.get(0));
		Assert.assertEquals("size should be 1", 1, intersection.size());
		
	}
	
	@Test
	public void testIntersectionOf3UnSortedArraysUsingHashSet() {
		
		int arr1[] = {1,3,4,5,6};
		int arr2[] = {2,4,7,9,20};
		int arr3[] = {0,1,2,3,4};
	
		Set<Integer> intersection = IntersectionOfThreeArrays
				.getIntersectionOf3UnSortedArraysUsingHashSet(arr1, arr2, arr3);
		
		Assert.assertTrue(intersection.size()==1);
		Assert.assertTrue(intersection.contains(4));
	}
	
	@Test
	public void testExactlyCommonElementsIn2ArrayFrom3SortedArraysUsingSingleLoop() {
		
		int arr1[] = {1,3,4,5,6};
		int arr2[] = {2,4,7,9,20};
		int arr3[] = {0,1,2,3,4};
	
		List<Integer> intersection = IntersectionOfThreeArrays
				.getExactlyCommonElementsIn2ArrayFrom3SortedArraysUsingSingleLoop(arr1, arr2, arr3);
		
		Assert.assertEquals("1 should be the common of the 2 arrays.",  new Integer(1), intersection.get(0));
		Assert.assertEquals("3 should be the common of the 2 arrays.",  new Integer(3), intersection.get(1));
		Assert.assertEquals("size should be 2", 2, intersection.size());
		
	}
}
