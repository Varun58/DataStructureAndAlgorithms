package strings;

import org.junit.Assert;
import org.junit.Test;

public class AnagramSubstringTests {

	@Test
	public void testOneStringIsAnagramSubstringOfOther() {
		
		Assert.assertTrue(AnagramSubstring.isAnagramSubstringUsingCountArray("jingp", "ping"));
		
		Assert.assertTrue(AnagramSubstring.isAnagramSubstringUsingCountArray("ihhatjngpeihappe", "pinge"));
		
		Assert.assertTrue(AnagramSubstring.isAnagramSubstringUsingCountArray("aaabaaabaaabacaababcccc", "abc"));
		
		Assert.assertTrue(AnagramSubstring.isAnagramSubstringUsingCountArray("aaabaaabaaabacababbbacccc", "abc"));
		
		Assert.assertFalse(AnagramSubstring.isAnagramSubstringUsingCountArray("aaaaaaaaabbaaaaa", "c"));
		
		Assert.assertFalse(AnagramSubstring.isAnagramSubstringUsingCountArray("ijngp", "ping"));
		Assert.assertFalse(AnagramSubstring.isAnagramSubstringUsingCountArray("ihhatjngpheappe", "pinge"));
		
	}
}
