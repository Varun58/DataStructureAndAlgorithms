package strings;

public class OneEditAway {

	// Brute force method not clear enough
	public static boolean checkStringIsOneEditAwayFromOtherBruteUsingNextCharacterApproach(String s1, String s2) {

		if (s1 == null && s2 != null)
			return false;

		if (s1 != null && s2 == null)
			return false;

		if (Math.abs(s1.length() - s2.length()) > 2)
			return false;

		int count = 1;
		int i = 0, j = 0;
		while (count >= 0 && i < s1.length() & j < s2.length()) {
			if (s1.charAt(i) != s2.charAt(j)) {

				count--;

				if (s1.charAt(i + 1) == s2.charAt(j) && i + 1 < s1.length()) {
					i++;
				} else if (s1.charAt(i) == s2.charAt(j + 1) && j + 1 < s2.length()) {
					j++;
				} else {
					i++;
					j++;
				}
			} else {
				i++;
				j++;
			}
		}

		if (count < 0) {
			return false;
		}

		return true;
	}

	public static boolean checkStringIsOneEditAwayFromOtherUsingCleanApproachOnLength(String s1, String s2) {

		if (s1 == null && s2 != null)
			return false;

		if (s1 != null && s2 == null)
			return false;

		if (Math.abs(s1.length() - s2.length()) > 2)
			return false;

		String shorter = s1.length() < s2.length() ? s1 : s2;
		String longer = s1.length() < s2.length() ? s2 : s1;

		boolean foundDifference = false;
		int longerIndex = 0, shorterIndex = 0;
		while (longerIndex < longer.length() & shorterIndex < shorter.length()) {

			if (longer.charAt(longerIndex) != shorter.charAt(shorterIndex)) {

				if (foundDifference)
					return false;

				foundDifference = true;

				if (longer.length() == shorter.length()) {
					shorterIndex++;
				}

			} else {
				shorterIndex++;
			}
			longerIndex++;
		}
		return true;
	}

}
