package sorting;

import java.util.Arrays;

public class ComparisonSorting {

	public static void main(String[] args) {

		int arr1[] = { 234, 3, 5, 64, 8, 6, 23, 79, 7, 0, 5, 15 };

		int res[] = bubbleSort(arr1);
		System.out.println("Bubble Sort:");
		Arrays.stream(res).forEach(x -> System.out.print(x + " "));
		System.out.println();
		
		int arr2[] = { 234, 3, 5, 64, 8, 6, 23, 79, 7, 0, 5, 15 };

		res = selectionSort(arr2);
		System.out.println("Selection Sort");
		Arrays.stream(res).forEach(x -> System.out.print(x + " "));
		System.out.println();
		
		int arr3[] = { 234, 3, 5, 64, 8, 6, 23, 79, 7, 0, 5, 15 };

		res = insertionSort(arr3);
		System.out.println("Insertion Sort");
		Arrays.stream(res).forEach(x -> System.out.print(x + " "));
		System.out.println();
		
		int arr4[] = { 234, 3, 5, 64, 8, 6, 23, 79, 7, 0, 5, 15 };

		res = shellSort(arr4);
		System.out.println("Shell Sort");
		Arrays.stream(res).forEach(x -> System.out.print(x + " "));
		System.out.println();

	}

	private static int[] shellSort(int[] arr) {
		int n = arr.length;
		int gap = n;

		for (gap = n / 2; gap > 0; gap /= 2) {
			for (int i = gap; i < n; i++) {
				int key = arr[i];
				int j = i;
				while (j - gap >= 0 && arr[j - gap] > key) {
					arr[j] = arr[j-gap];
					j = j - gap;
				}
				arr[j]=key;
			}
		}

		return arr;
	}

	private static int[] insertionSort(int[] arr) {
		int n = arr.length;

		for (int i = 1; i < n; i++) {
			int key = arr[i];
			int j = i - 1;
			while (  j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j--;
			}

			arr[j + 1] = key;
		}

		return arr;
	}

	public static int[] selectionSort(int arr[]) {
		int n = arr.length;

		for (int i = 0; i < n; i++) {
			int pos = i;
			for (int j = i + 1; j < n; j++) {
				if (arr[j] < arr[pos]) {
					pos = j;
				}
			}

			int temp = arr[i];
			arr[i] = arr[pos];
			arr[pos] = temp;
		}

		return arr;
	}

	public static int[] bubbleSort(int arr[]) {
		int n = arr.length;

		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - 1 - i; j++) {

				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}

		return arr;

	}
}
