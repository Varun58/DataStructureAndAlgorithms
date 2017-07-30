package strings;

import org.junit.Assert;
import org.junit.Test;

import strings.UniqueCharInStrings;

public class UniqueCharInStringsTests {

	@Test
	public void testUniqueCharUsingBruteForce() {
		Assert.assertTrue(UniqueCharInStrings.uniqCharUsingBruteForce("smart"));
		Assert.assertFalse(UniqueCharInStrings.uniqCharUsingBruteForce("arrangement"));
		Assert.assertFalse(UniqueCharInStrings.uniqCharUsingBruteForce("happiness"));
		Assert.assertTrue(UniqueCharInStrings.uniqCharUsingBruteForce(""));
		Assert.assertTrue(UniqueCharInStrings.uniqCharUsingBruteForce(null));
	}

	@Test
	public void testUniqueCharUsingHashSet() {
		Assert.assertTrue(UniqueCharInStrings.uniqCharUsingHashSet("smart"));
		Assert.assertFalse(UniqueCharInStrings.uniqCharUsingHashSet("arrangement"));
		Assert.assertFalse(UniqueCharInStrings.uniqCharUsingHashSet("happiness"));
		Assert.assertTrue(UniqueCharInStrings.uniqCharUsingHashSet(""));
		Assert.assertTrue(UniqueCharInStrings.uniqCharUsingHashSet(null));
	}


	@Test
	public void testUniqueCharUsingHashMap() {
		Assert.assertTrue(UniqueCharInStrings.uniqCharUsingHashMap("smart"));
		Assert.assertFalse(UniqueCharInStrings.uniqCharUsingHashMap("arrangement"));
		Assert.assertFalse(UniqueCharInStrings.uniqCharUsingHashMap("happiness"));
		Assert.assertTrue(UniqueCharInStrings.uniqCharUsingHashMap(""));
		Assert.assertTrue(UniqueCharInStrings.uniqCharUsingHashMap(null));
	}
	
	//Without using Extra Space
	
	
	
	@Test
	public void testUniqueCharUsingSorting() {
		Assert.assertTrue(UniqueCharInStrings.uniqCharUsingSorting("smart"));
		Assert.assertFalse(UniqueCharInStrings.uniqCharUsingSorting("arrangement"));
		Assert.assertFalse(UniqueCharInStrings.uniqCharUsingSorting("happiness"));
		Assert.assertTrue(UniqueCharInStrings.uniqCharUsingSorting(""));
		Assert.assertTrue(UniqueCharInStrings.uniqCharUsingSorting(null));
	}
	
}
