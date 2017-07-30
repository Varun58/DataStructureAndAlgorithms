package strings;

import org.junit.Test;

import junit.framework.Assert;
import strings.TwoStringAnagrams;

public class TwoStringAnagramTests {

	@Test
	public void checkTwoStringAreAnagramsUsingBooleanArray() {
		Assert.assertTrue(TwoStringAnagrams.checkTwoStringsAnagramUsingBooleanArray("smart", "tmasr"));
		Assert.assertTrue(TwoStringAnagrams.checkTwoStringsAnagramUsingBooleanArray("goods", "doogs"));
		Assert.assertFalse(TwoStringAnagrams.checkTwoStringsAnagramUsingBooleanArray("smart", "eastm"));
		Assert.assertFalse(TwoStringAnagrams.checkTwoStringsAnagramUsingBooleanArray("assert", "asserts"));
		Assert.assertFalse(TwoStringAnagrams.checkTwoStringsAnagramUsingBooleanArray("", "eastm"));
		Assert.assertFalse(TwoStringAnagrams.checkTwoStringsAnagramUsingBooleanArray("", null));
		Assert.assertFalse(TwoStringAnagrams.checkTwoStringsAnagramUsingBooleanArray(null, ""));
		Assert.assertFalse(TwoStringAnagrams.checkTwoStringsAnagramUsingBooleanArray(null, "eastm"));
		Assert.assertFalse(TwoStringAnagrams.checkTwoStringsAnagramUsingBooleanArray("eastm",null));
	}
	
	@Test
	public void checkTwoStringAreAnagramsUsingHashMap() {
		Assert.assertTrue(TwoStringAnagrams.checkTwoStringsAnagramUsingCharMap("smart", "tmasr"));
		Assert.assertTrue(TwoStringAnagrams.checkTwoStringsAnagramUsingCharMap("goods", "doogs"));
		Assert.assertFalse(TwoStringAnagrams.checkTwoStringsAnagramUsingCharMap("smart", "eastm"));
		Assert.assertFalse(TwoStringAnagrams.checkTwoStringsAnagramUsingCharMap("assert", "asserts"));
		Assert.assertFalse(TwoStringAnagrams.checkTwoStringsAnagramUsingCharMap("", "eastm"));
		Assert.assertFalse(TwoStringAnagrams.checkTwoStringsAnagramUsingCharMap("", null));
		Assert.assertFalse(TwoStringAnagrams.checkTwoStringsAnagramUsingCharMap(null, ""));
		Assert.assertFalse(TwoStringAnagrams.checkTwoStringsAnagramUsingCharMap(null, "eastm"));
		Assert.assertFalse(TwoStringAnagrams.checkTwoStringsAnagramUsingCharMap("eastm",null));
	}

	//Without using extra space
	
	@Test
	public void checkTwoStringAreAnagramsUsingSorting() {
		Assert.assertTrue(TwoStringAnagrams.checkTwoStringsAnagramUsingSorting("smart", "tmasr"));
		Assert.assertTrue(TwoStringAnagrams.checkTwoStringsAnagramUsingSorting("goods", "doogs"));
		Assert.assertFalse(TwoStringAnagrams.checkTwoStringsAnagramUsingSorting("smart", "eastm"));
		Assert.assertFalse(TwoStringAnagrams.checkTwoStringsAnagramUsingSorting("assert", "asserts"));
		Assert.assertFalse(TwoStringAnagrams.checkTwoStringsAnagramUsingSorting("", "eastm"));
		Assert.assertFalse(TwoStringAnagrams.checkTwoStringsAnagramUsingSorting("", null));
		Assert.assertFalse(TwoStringAnagrams.checkTwoStringsAnagramUsingSorting(null, ""));
		Assert.assertFalse(TwoStringAnagrams.checkTwoStringsAnagramUsingSorting(null, "eastm"));
		Assert.assertFalse(TwoStringAnagrams.checkTwoStringsAnagramUsingSorting("eastm",null));
	}
}
