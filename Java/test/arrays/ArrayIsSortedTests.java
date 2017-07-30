package arrays;

import org.junit.Assert;
import org.junit.Test;

public class ArrayIsSortedTests {

	@Test
	public void testArrayIsSortedUsingMatchingNextElement() {
		Assert.assertTrue(ArrayIsSorted.checkArrayIsSortedByComparingNextElement(new int[] {1,3,4,5,6,9,20}));
		Assert.assertTrue(ArrayIsSorted.checkArrayIsSortedByComparingNextElement(new int[] {1,3,4,5,5,6,6,9,20}));
		Assert.assertTrue(ArrayIsSorted.checkArrayIsSortedByComparingNextElement(new int[] {}));
		Assert.assertTrue(ArrayIsSorted.checkArrayIsSortedByComparingNextElement(new int[] {9}));
	
		Assert.assertFalse(ArrayIsSorted.checkArrayIsSortedByComparingNextElement(new int[] {9,20,1,3,4,5}));
		Assert.assertFalse(ArrayIsSorted.checkArrayIsSortedByComparingNextElement(new int[] {11,3}));
	}

	@Test
	public void testArrayIsSortedUsingCopyArrayAndSorting() {
		Assert.assertTrue(ArrayIsSorted.checkArrayIsSortedUsingSorting(new int[] {1,3,4,5,6,9,20}));
		Assert.assertTrue(ArrayIsSorted.checkArrayIsSortedUsingSorting(new int[] {1,3,4,5,5,6,6,9,20}));
		Assert.assertTrue(ArrayIsSorted.checkArrayIsSortedUsingSorting(new int[] {}));
		Assert.assertTrue(ArrayIsSorted.checkArrayIsSortedUsingSorting(new int[] {9}));
	
		Assert.assertFalse(ArrayIsSorted.checkArrayIsSortedUsingSorting(new int[] {9,20,1,3,4,5}));
		Assert.assertFalse(ArrayIsSorted.checkArrayIsSortedUsingSorting(new int[] {11,3}));
	}
	
	@Test
	public void testcheckArrayIsSortedByComparingNextElementUsingCompareTo() {
		Assert.assertTrue(ArrayIsSorted.checkArrayIsSortedByComparingNextElementUsingCompareTo(new Integer[] {1,3,4,5,6,9,20}));
		Assert.assertTrue(ArrayIsSorted.checkArrayIsSortedByComparingNextElementUsingCompareTo(new Integer[] {1,3,4,5,5,6,6,9,20}));
		Assert.assertTrue(ArrayIsSorted.checkArrayIsSortedByComparingNextElementUsingCompareTo(new Integer[] {}));
		Assert.assertTrue(ArrayIsSorted.checkArrayIsSortedByComparingNextElementUsingCompareTo(new Integer[] {9}));
	
		Assert.assertFalse(ArrayIsSorted.checkArrayIsSortedByComparingNextElementUsingCompareTo(new Integer[] {9,20,1,3,4,5}));
		Assert.assertFalse(ArrayIsSorted.checkArrayIsSortedByComparingNextElementUsingCompareTo(new Integer[] {11,3}));
	}

}
