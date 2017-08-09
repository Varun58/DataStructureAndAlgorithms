package sorting;

import java.util.Arrays;

public class LinearSorting {

	public static void main(String[] args) {
		int arr1[] = { 1, 4, 1, 2, 7, 5, 2 };

		int res[] = countingSort(arr1);
		System.out.println("Counting Sort:");
		Arrays.stream(res).forEach(x -> System.out.print(x + " "));
		System.out.println();

		int arr2[] = { 170,45,75,90,802,24,2,66 };

		res = radixSort(arr2);
		System.out.println("Radix Sort:");
		Arrays.stream(res).forEach(x -> System.out.print(x + " "));
		System.out.println();

	}

	private static int[] radixSort(int[] arr2) {
		int n = arr2.length;

		int mx = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			if (arr2[i] > mx)
				mx = arr2[i];
		}

		for (int m = 1; (mx / m) > 0; m *= 10)
			countingSortRadix(arr2, m);

		return arr2;
	}

	private static void countingSortRadix(int[] arr2, int m) {

		int count[] = new int[10];

		for (int i = 0; i < arr2.length; i++) {
			count[(arr2[i] / m) % 10]++;
		}

		for (int i = 1; i < count.length; i++) {
			count[i] += count[i - 1];
		}

		int output[] = new int[arr2.length];

		for (int i = arr2.length-1; i >=0 ; i--) {
			output[count[(arr2[i] / m) % 10] - 1] = arr2[i];
			count[(arr2[i] / m) % 10]--;
		}
		
		for (int i = 0; i < arr2.length; i++) {
			arr2[i]=output[i];
		}
	}

	private static int[] countingSort(int[] arr1) {
		int n = 10;

		int count[] = new int[n];

		for (int i = 0; i < arr1.length; i++) {
			count[arr1[i]]++;
		}

		for (int i = 1; i < n; i++) {
			count[i] += count[i - 1];
		}

		int[] output = new int[arr1.length];

		for (int i = 0; i < arr1.length; i++) {
			output[count[arr1[i]] - 1] = arr1[i];
			count[arr1[i]]--;
		}
		
		for (int i = 0; i < arr1.length; i++) {
			arr1[i]=output[i];
		}

		return arr1;
	}

}
