package interview;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ValidateEarliestDate {

	private static LocalDateTime minTime;

	private static String minTimeString;

	public String solution(int A, int B, int C, int D, int E, int F) {
		String minString = "2017-08-24 23:59:59";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		minTime = LocalDateTime.parse(minString, formatter);
		minTimeString = null;

		int[] arr = new int[6];
		arr[0] = A;
		arr[1] = B;
		arr[2] = C;
		arr[3] = D;
		arr[4] = E;
		arr[5] = F;
		permute(arr, 0);

		if (minTimeString != null) {
			return minTimeString;
		}

		return "NOT POSSIBLE";

	}

	/*public static void main(String[] args) {

		ValidateEarliestDate permutations = new ValidateEarliestDate();
		System.out.println(permutations.solution(1, 2, 3, 4, 5, 6));
		System.out.println(permutations.solution(0, 0, 0, 0, 0, 0));
		System.out.println(permutations.solution(0, 0, 0, 7, 8, 9));
		System.out.println(permutations.solution(2, 4, 5, 9, 5, 9));

	}*/

	public void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	public void permute(int[] arr, int i) {
		if (i == arr.length) {
			validateTime(arr);
			return;
		}
		for (int j = i; j < arr.length; j++) {
			swap(arr, i, j);
			permute(arr, i + 1); // recurse call
			swap(arr, i, j); // backtracking
		}
	}

	private boolean validateTime(int[] arr) {
		try {
			String hour = String.valueOf(arr[0]) + String.valueOf(arr[1]);
			String min = String.valueOf(arr[2]) + String.valueOf(arr[3]);
			String sec = String.valueOf(arr[4]) + String.valueOf(arr[5]);
			String str = "2017-08-23 " + hour + ":" + min + ":" + sec;
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			LocalDateTime dateTime = LocalDateTime.parse(str, formatter);

			if (dateTime.compareTo(minTime) == -1) {
				minTime = dateTime;
				minTimeString = hour + ":" + min + ":" + sec;
			}

		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
