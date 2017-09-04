package arrays;

public class AllPossibleWordsFromPhoneDigits {

	static char hashTable[][] = { {}, {}, { 'a', 'b', 'c' }, { 'd', 'e', 'f' }, { 'g', 'h', 'i' }, { 'j','k', 'l' },
			{ 'm','n', 'o' }, { 'p', 'q', 'r', 's' }, { 't', 'u', 'v' }, { 'w', 'x', 'y', 'z' }, };

	static void printWords(int number[], int currDigit, char output[], int n) {
		if (currDigit == n) {

			for (char c : output) {
				System.out.print(c + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 0; i <hashTable[number[currDigit]].length; i++) {
			if (number[i] == 0 || number[i] == 1)
				return;
			output[currDigit] = hashTable[number[currDigit]][i];
			printWords(number, currDigit + 1, output, n);

		}
	}

	public static void main(String[] args) {

		// int number[] = { 2, 3, 4 };

		int number[] = { 9, 6, 5, 6, 7, 8, 3, 2, 2, 4, 6 };

		char temp[] = new char[number.length + 1];
		printWords(number, 0, temp, number.length);
	}
}
