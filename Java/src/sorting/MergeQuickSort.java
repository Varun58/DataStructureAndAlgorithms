package sorting;

import java.util.Arrays;

public class MergeQuickSort {

	public static void main(String[] args) {
		int arr1[] = { 10, 80, 30, 90, 40, 50, 70 };

		int res[] = quickSort(arr1,0,arr1.length-1);
		System.out.println("Quick Sort:");
		Arrays.stream(res).forEach(x -> System.out.print(x + " "));
		System.out.println();

	}

	private static int[] quickSort(int[] arr1, int l, int r) {
		if (l < r) {
			int pi = partition(arr1, l, r);

			quickSort(arr1, l, pi - 1);
			quickSort(arr1, pi + 1, r);
		}
		return arr1;
	}

	private static int partition(int[] arr1, int low, int r) {
		int high = r;

		int i = low - 1;
		
		for (int j= low; j < high; j++) {
			if (arr1[j] <= arr1[high]) {
				i++;
				int temp = arr1[i];
				arr1[i] = arr1[j];
				arr1[j] = temp;
			}
		}

		int swap = arr1[i+1];
		arr1[i+1] = arr1[high];
		arr1[high] = swap;
		
		return i+1;
	}

}
