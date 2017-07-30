package strings;

import org.junit.Assert;
import org.junit.Test;

import strings.RemoveDuplicateCharFromString;

public class RemoveDuplicateCharFromStringTests {
	
	@Test
	public void testDuplicateCharRemovedFromStringUsingBruteForce() {
		Assert.assertEquals("failed for arrangement", "arngemt",
				RemoveDuplicateCharFromString.removeDuplicateCharUsingBruteForce("arrangement"));
		Assert.assertEquals("failed for obsession", "obsein",
				RemoveDuplicateCharFromString.removeDuplicateCharUsingBruteForce("obsession"));
		Assert.assertEquals("failed for blank ", "",
				RemoveDuplicateCharFromString.removeDuplicateCharUsingBruteForce(""));
		Assert.assertEquals("failed for null", null,
				RemoveDuplicateCharFromString.removeDuplicateCharUsingBruteForce(null));
		Assert.assertEquals("failed for b", "b",
				RemoveDuplicateCharFromString.removeDuplicateCharUsingBruteForce("b"));
	}
	
	@Test
	public void testDuplicateCharRemovedFromStringUsingArrayMatching() {
		Assert.assertEquals("failed for arrangement", "aegmnrt",
				RemoveDuplicateCharFromString.removeDuplicateCharUsingBooleanArray("arrangement"));
		Assert.assertEquals("failed for obsession", "beinos",
				RemoveDuplicateCharFromString.removeDuplicateCharUsingBooleanArray("obsession"));
		Assert.assertEquals("failed for blank", "",
				RemoveDuplicateCharFromString.removeDuplicateCharUsingBooleanArray(""));
		Assert.assertEquals("failed for null", null,
				RemoveDuplicateCharFromString.removeDuplicateCharUsingBooleanArray(null));
		Assert.assertEquals("failed for  b", "b",
				RemoveDuplicateCharFromString.removeDuplicateCharUsingBooleanArray("b"));
	}

	@Test
	public void testDuplicateCharRemovedFromStringUsingHashSet() {
		Assert.assertEquals("failed for arrangement", "arngemt",
				RemoveDuplicateCharFromString.removeDuplicateCharUsingHashSet("arrangement"));
		Assert.assertEquals("failed for obsession", "obsein",
				RemoveDuplicateCharFromString.removeDuplicateCharUsingHashSet("obsession"));
		Assert.assertEquals("failed for blank", "",
				RemoveDuplicateCharFromString.removeDuplicateCharUsingHashSet(""));
		Assert.assertEquals("failed for null", null,
				RemoveDuplicateCharFromString.removeDuplicateCharUsingHashSet(null));
		Assert.assertEquals("failed for b", "b",
				RemoveDuplicateCharFromString.removeDuplicateCharUsingHashSet("b"));
	}
	
	@Test
	public void testDuplicateCharRemovedFromStringUsingSorting() {
		Assert.assertEquals("failed for arrangement", "aegmnrt",
				RemoveDuplicateCharFromString.removeDuplicateCharUsingSorting("arrangement"));
		Assert.assertEquals("failed for obsession", "beinos",
				RemoveDuplicateCharFromString.removeDuplicateCharUsingSorting("obsession"));
		Assert.assertEquals("failed for blank", "",
				RemoveDuplicateCharFromString.removeDuplicateCharUsingSorting(""));
		Assert.assertEquals("failed for null", null,
				RemoveDuplicateCharFromString.removeDuplicateCharUsingSorting(null));
		Assert.assertEquals("failed for b ", "b",
				RemoveDuplicateCharFromString.removeDuplicateCharUsingSorting("b"));
	}
}
