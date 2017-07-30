package strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoStringAnagrams {

	public static boolean checkTwoStringsAnagramUsingBooleanArray(String str1, String str2) {

		if (str1 == null && str2 == null) {
			return true;
		}

		if (str1 == null && str2 != null) {
			return false;
		}

		if (str1 != null && str2 == null) {
			return false;
		}

		if (str1.equals(str2))
			return true;

		int charTable[] = new int[128];

		for (char character : str1.toCharArray()) {
			charTable[character]++;
		}

		for (char character : str2.toCharArray()) {
			charTable[character]--;

			if (charTable[character] < 0)
				return false;
		}

		return true;
	}

	public static boolean checkTwoStringsAnagramUsingCharMap(String str1, String str2) {

		if (str1 == null && str2 == null) {
			return true;
		}

		if (str1 == null && str2 != null) {
			return false;
		}

		if (str1 != null && str2 == null) {
			return false;
		}

		if (str1.equals(str2))
			return true;

		Map<Character, Integer> charMap = new HashMap<Character, Integer>();

		for (char character : str1.toCharArray()) {
			if (charMap.containsKey(character)) {
				charMap.put(character, charMap.get(character) + 1);
			} else {
				charMap.put(character, 1);
			}
		}

		for (char character : str2.toCharArray()) {
			if (charMap.containsKey(character)) {
				charMap.put(character, charMap.get(character) - 1);
				if (charMap.get(character) < 0) {
					return false;
				}
			} else {
				return false;
			}
		}

		return true;
	}

	//Without using extra space
	public static boolean checkTwoStringsAnagramUsingSorting(String str1, String str2) {

		if (str1 == null && str2 == null) {
			return true;
		}

		if (str1 == null && str2 != null) {
			return false;
		}

		if (str1 != null && str2 == null) {
			return false;
		}

		if (str1.equals(str2))
			return true;

		char strArr1[] = str1.toCharArray();
		char strArr2[] = str2.toCharArray();

		Arrays.sort(strArr1);
		Arrays.sort(strArr2);
		
		if ((new String(strArr1)).equals(new String(strArr2)))
			return true;

		return false;
	}
}
