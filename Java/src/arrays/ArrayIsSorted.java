package arrays;

import java.util.Arrays;

public class ArrayIsSorted {

	public static boolean checkArrayIsSortedByComparingNextElement(int[] input) {

		if (input == null || input.length <= 1)
			return true;

		for (int i = 0; i < input.length - 1; i++) {
			if (input[i] > input[i + 1])
				return false;
		}

		return true;
	}
	
	public static boolean checkArrayIsSortedByComparingNextElementUsingCompareTo(Integer[] input) {

		if (input == null || input.length <= 1)
			return true;

		for (int i = 0; i < input.length - 1; i++) {
			if (input[i].compareTo( input[i + 1])>0)
				return false;
		}

		return true;
	}

	public static boolean checkArrayIsSortedUsingSorting(int[] input) {

		if (input == null || input.length <= 1)
			return true;

		int[]  copyArr = Arrays.copyOf(input, input.length);
		Arrays.sort(copyArr);
		
		return Arrays.equals(copyArr,input);
	}
	
	
}
