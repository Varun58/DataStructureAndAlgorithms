package strings;

public class AnagramSubstring {

/*	We have two words. We need to determine if the second word contains a substring with an anagram of the first word.
	ping & jingp -> yes
	ping & ijngp -> no 
*/
	
	public static boolean isAnagramSubstringUsingCountArray(String large, String anagramStr) {

		if (large == null && anagramStr == null)
			return true;

		if (large == null || anagramStr == null)
			return false;

		int[] countArr1 = new int[128];

		for (char ch : anagramStr.toCharArray()) {
			countArr1[ch]++;
		}

		boolean patternMatching = false;

		int count = 0;

		for (char ch : large.toCharArray()) {

			if (countArr1[ch] > 0) {
				patternMatching = true;

				if (count < 0) {
					count = 0;
				}
				count++;
			} else {
				count = -1;
				patternMatching = false;
			}
			if (count > 0 && count != anagramStr.length() && !patternMatching) {
				return false;
			}
			if (count == anagramStr.length()) {
				return true;
			}
		}
		return false;
	}

}
