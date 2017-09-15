package strings;

import java.util.HashSet;
import java.util.Set;

public class DifficultyOfSentence {

	public static void main(String[] args) {
		String sentence = "difficulty of sentence";

		System.out.println(calculateDifficulty(sentence));

		System.out.println(calculateDifficulty("I am a geek"));

		System.out.println(calculateDifficulty("We are geeks"));

	}

	// Method 1 : Iterate over whole sentence O(n)
	// Method 1 : Split the sentence by space and iterate on words O(nk) , k is
	// maximum length of word
	public static int calculateDifficulty(String str) {

		int hardC = 0, easyC = 0;
		int vowels = 0, consonants = 0;
		int consecutiveCons = 0;

		Set<Character> vowelSet = new HashSet<Character>();
		vowelSet.add('a');
		vowelSet.add('e');
		vowelSet.add('i');
		vowelSet.add('o');
		vowelSet.add('u');

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ') {
				vowels = 0;
				consonants = 0;
				consecutiveCons = 0;
			} else {
				if (!vowelSet.contains(Character.toLowerCase(str.charAt(i)))) {
					consonants++;
					consecutiveCons++;
				} else {
					vowels++;
					consecutiveCons = 0;
				}

				if (i + 1 < str.length() && str.charAt(i + 1) == ' ') {
					if (consecutiveCons == 4 || consonants > vowels) {
						hardC++;
					} else
						easyC++;
				}
			}

		}

		if (consecutiveCons == 4 || consonants > vowels) {
			hardC++;
		} else
			easyC++;

		int difficulty = 5 * hardC + 3 * easyC;

		return difficulty;
	}
}
