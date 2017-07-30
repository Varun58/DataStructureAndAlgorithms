package math;

public class SwapTwoDigitsToGetMaximumNumber {

	public static int swapTwoDigitsToGetMaximumNumber(int number) {

		if (number == 0)
			return 0;

		String StringNum = String.valueOf(number);

		int maxNum = 0, secondMax = 0;

		for (int i = 0; i < StringNum.length(); i++) {
			int curr = Integer.parseInt(String.valueOf(StringNum.charAt(i)));
			int temp = Integer.parseInt(String.valueOf(StringNum.charAt(maxNum)));
			if (curr > temp) {
				secondMax = maxNum;
				maxNum = i;
			}
		}

		// Swap both maximum
		char[] charArr = StringNum.toCharArray();
		char t1 = charArr[0];
		charArr[0] = charArr[maxNum];
		charArr[maxNum] = t1;

		/*
		 * char t2 = charArr[1]; charArr[1] = charArr[secondMax]; charArr[secondMax]=t2;
		 */

		return Integer.parseInt(new String(charArr));
	}

	public static int swapTwoDigitsToGetMaximumNumberUsingLoop(int number) {

		if (number == 0)
			return 0;

		char[] stringNum = String.valueOf(number).toCharArray();

		int maxNum = 0, k = 4;

		for (int i = 0; i < stringNum.length; i++) {
			for (int j = i+1; j < stringNum.length; j++) {

				if (k == 0)
					break;

				int curr = Integer.parseInt(String.valueOf(stringNum[j]));
				int temp = Integer.parseInt(String.valueOf(stringNum[maxNum]));
				if (curr >= temp ) {
					maxNum = j;
				}
			}

			if (maxNum != 0 && k > 0 ) {
				char t1 = stringNum[i];
				stringNum[i] = stringNum[maxNum];
				stringNum[maxNum] = t1;

				k--;
			}

		}
		return Integer.parseInt(new String(stringNum));
	}

	public static void main(String[] args) {
		System.out.println(swapTwoDigitsToGetMaximumNumberUsingLoop(129814999));
		//129814999
		//3580
	}

}
