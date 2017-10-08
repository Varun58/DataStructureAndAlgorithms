package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortOddNumbersInDescAndEvenInAsc {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 5, 4, 7, 10 };

		int res[] = twoWaySortSwappingEvenOddAndSorting(arr);
		Arrays.stream(res).forEach(x -> System.out.print(x + " "));
		
		System.out.println();
		int arr2[] = { 1, 2, 3, 5, 4, 7, 10 };
		int res2[] = twoWaySortMakingOddNegativeAndSorting(arr2);

		Arrays.stream(res2).forEach(x -> System.out.print(x + " "));
	}

	static int[] twoWaySortSwappingEvenOddAndSorting(int arr[]) {
		int l = arr.length;
		int i = 0;
		int j = l - 1;
		int k = 0;
		while (i < j) {
			while (arr[i] % 2 != 0) {
				i++;
				k++;
			}

			while (arr[j] % 2 == 0) {
				j--;
			}

			if (i < j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}

		List<Integer> list = new ArrayList<Integer>();

		for (int v = 0; v <k; v++) {
			list.add(arr[v]);
		}
		Collections.sort(list, Collections.reverseOrder());

		for (int v = 0; v < list.size(); v++) {
			arr[v] = list.get(v);
		}

		Arrays.sort(arr, k, l);

		return arr;
	}

	static int[] twoWaySortMakingOddNegativeAndSorting(int arr[]) {

		for (int i = 0; i < arr.length; i++) {
			if ((arr[i] & 1) != 0) {
				arr[i] *= -1;
			}
		}

		Arrays.sort(arr);
		
		for (int i = 0; i < arr.length; i++) {
			if ((arr[i] & 1) != 0) {
				arr[i] *= -1;
			}
		}
		
		return arr;
	}
}
