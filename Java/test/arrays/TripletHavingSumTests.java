package arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.junit.Test;

import junit.framework.Assert;

public class TripletHavingSumTests {

	@Test
	public void testTripletHavingSumUsingSorting() {
		int[] arr = { 3, 5, 8, 10, 2, 1, 7 };
		List<HashSet<Integer>> result = TripletHavingSum.getTripletHavingGivenSumUsingSortingAndTwoPointer(arr, 15);
		
		Assert.assertTrue(result.size()==3);
		
		Assert.assertTrue(result.get(0).containsAll(Arrays.asList(3,2,10)));
		Assert.assertTrue(result.get(1).containsAll(Arrays.asList(8,5,2)));
		Assert.assertTrue(result.get(2).containsAll(Arrays.asList(3,5,7)));
	}
}
