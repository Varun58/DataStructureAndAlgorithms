package strings;

import java.util.HashMap;
import java.util.Scanner;

public class MagazineContainsRansomWords {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int m = Integer.parseInt(in.next());
		int n = Integer.parseInt(in.next());
		String magazine[] = new String[m];
		for (int magazine_i = 0; magazine_i < m; magazine_i++) {
			magazine[magazine_i] = in.next();
		}
		String ransom[] = new String[n];
		for (int ransom_i = 0; ransom_i < n; ransom_i++) {
			ransom[ransom_i] = in.next();
		}

		HashMap<String, Integer> magazineMap = new HashMap<String, Integer>();

		for (String word : magazine) {
			magazineMap.put(word, magazineMap.getOrDefault(word, 0) + 1);
		}

		for (String word : ransom) {
			if (magazineMap.containsKey(word)) {
				int count = magazineMap.get(word);
				if (--count < 0) {
					System.out.println("No");
					return;
				}
				magazineMap.put(word, count);
			} else {
				System.out.println("No");
				return;
			}
		}

		System.out.println("Yes");
	}

	// Sample case
	/*
	 * 15 17 o l x imjaw bee khmla v o v o imjaw l khmla imjaw x imjaw l khmla x
	 * imjaw o l l o khmla v bee o o imjaw imjaw o output : No
	 */

	/*
	 * 6 5 two times three is not four two times two is four Output : No
	 */
}
