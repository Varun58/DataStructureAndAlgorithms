package arrays;

import java.util.Map;

import org.junit.Test;

import junit.framework.Assert;

public class PairHavingSumTests {

	@Test
	public void testPairHavingGivenSumWhenAllPositiveElements() {
		int arr[]= {3,2,1,4,6,7,12,8,5,9};
		
		Map<Integer,Integer> sumMap = PairHavingSum.pairHavingSum(arr, 11);

		Assert.assertNotNull(sumMap);
		Assert.assertTrue(sumMap.size()>1);
		Assert.assertTrue(sumMap.containsKey(3));
		Assert.assertTrue(sumMap.containsKey(2));
		Assert.assertTrue(sumMap.containsKey(4));
		Assert.assertTrue(sumMap.containsKey(6));
	}
	
	@Test
	public void testPairHavingGivenSumWhenNegativeElementsPresent() {
		
		int arr[]= {-1,2,4,-3,-5,9,8};
		
		Map<Integer,Integer> sumMap = PairHavingSum.pairHavingSum(arr, 7);

		Assert.assertNotNull(sumMap);
		Assert.assertTrue(sumMap.size()==1);
		Assert.assertTrue(sumMap.containsKey(-1));
	}

	@Test
	public void testPairHavingGivenSumWhenNoElementsOrSumZero() {
		
		int arr[]= {-1,2,4,-3,-5,9,8};
		
		Map<Integer,Integer> sumMap = PairHavingSum.pairHavingSum(arr, 0);
		Assert.assertNull(sumMap);
		
		Map<Integer,Integer> sumMap2 = PairHavingSum.pairHavingSum(null, 7);
		Assert.assertNull(sumMap2);
		
	}
	
}
