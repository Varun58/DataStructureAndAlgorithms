package arrays;

import java.util.ArrayList;
import java.util.Collections;

public class LargestNumberFromArrayElements {

	static long largestNumberFromArrayEle(int arr[]) {

		ArrayList<Integer> sortArr = new ArrayList<>();

		for (int e : arr) {
			sortArr.add(e);
		}

		Collections.sort(sortArr, (x, y) -> {

			String s1 = String.valueOf(x).concat(String.valueOf(y));

			String s2 = String.valueOf(y).concat(String.valueOf(x));

			return s2.compareTo(s1);
		});

		StringBuilder sb = new StringBuilder("");

		for (int value : sortArr) {
			sb.append(String.valueOf(value));
		}

		return Long.parseLong(sb.toString());
	}

	public static void main(String[] args) {
		int arr[] = { 54, 546, 548, 60 };

		System.out.println(largestNumberFromArrayEle(arr));
	}
}
