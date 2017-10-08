package dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordBreak {

	static boolean wordBreak(String str, Set<String> dict) {

		int size = str.length();

		if (size == 0)
			return true;

		boolean wb[] = new boolean[size + 1];

		for (int i = 1; i <= size; i++) {
			if (wb[i] == false && dict.contains(str.substring(0, i))) {
				wb[i] = true;
			}

			if (wb[i]) {
				if (size == i)
					return true;

				for (int j = i + 1; j <= size; j++) {

					if (wb[j] == false && dict.contains(str.substring(i, j))) {
						wb[j] = true;
					}

					if (j == size && wb[j]) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public static boolean wordBreakRec(String str, HashSet<String> dict) {
		return wordBreakUtil(str, dict);
	}

	public static boolean wordBreakUtil(String str, HashSet<String> dict) {

		if (str.length() == 0)
			return true;

		for (int i = 1; i <= str.length(); i++) {
			if ((dict.contains(str.substring(0, i))) &&
					
					wordBreakUtil(str.substring(i), dict))
				return true;
		}

		return false;
	}
	
	/*public static boolean wordBreakUtil(String str, HashSet<String> dict) {

		if (str.length() == 0)
			return true;

		for (int i = 0; i <= str.length(); i++) {
			if ((dict.contains(str.substring(0, i))) &&
					
					wordBreakUtil(str.substring(i, str.length() + 1 - i), dict))
				return true;
		}

		return false;
	}*/

	public static boolean wordbreakDP(String str, HashSet<String> dict) {
		boolean bd[] = new boolean[str.length() + 1];
		bd[0]=true;
		for (int i = 1; i <= str.length(); i++) {
			for (int j = 0; j < i; j++) {
				if (bd[j] &&j<i&&dict.contains(str.substring(j, i))) {
					bd[i] = true;
				}
			}
		}
		return bd[str.length()];
	}
	

	public static void main(String[] args) {
		HashSet<String> set = new HashSet<String>(Arrays.asList("i", "love", "ice", "cream", "do", "but"));
		//System.out.println(wordbreakDP("iloveicecream", set));
		 System.out.println(wordBreakRec("iloveicecream", set));
		// System.out.println(wordBreak("iloveicecream", set));

	}
}
