package strings;

import org.junit.Assert;
import org.junit.Test;

public class OneEditAwayTests {

	@Test
	public void testStringIsOneEditAwayUsingBruteForce() {
		Assert.assertTrue(OneEditAway.checkStringIsOneEditAwayFromOtherBruteUsingNextCharacterApproach("pale", "ple"));
		Assert.assertTrue(OneEditAway.checkStringIsOneEditAwayFromOtherBruteUsingNextCharacterApproach("pales", "pale"));
		Assert.assertTrue(OneEditAway.checkStringIsOneEditAwayFromOtherBruteUsingNextCharacterApproach("pale", "bale"));
		Assert.assertFalse(OneEditAway.checkStringIsOneEditAwayFromOtherBruteUsingNextCharacterApproach("pale", "bake"));
		
	}
	
	@Test
	public void testStringIsOneEditAwayUsingCleanMethod() {
		Assert.assertTrue(OneEditAway.checkStringIsOneEditAwayFromOtherUsingCleanApproachOnLength("pale", "ple"));
		Assert.assertTrue(OneEditAway.checkStringIsOneEditAwayFromOtherUsingCleanApproachOnLength("pales", "pale"));
		Assert.assertTrue(OneEditAway.checkStringIsOneEditAwayFromOtherUsingCleanApproachOnLength("pale", "bale"));
		Assert.assertFalse(OneEditAway.checkStringIsOneEditAwayFromOtherUsingCleanApproachOnLength("pale", "bake"));
	}
}

