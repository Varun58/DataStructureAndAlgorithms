package sorting;

import java.util.Arrays;

public class MergeQuickSort {

	public static void main(String[] args) {
		int arr[] = { 10, 80, 30, 90, 40, 50, 70 };
		
		System.out.println("Merge Sort:");
		mergeSort(arr, 0, arr.length-1);
		Arrays.stream(arr).forEach(x -> System.out.print(x + " "));

		System.out.println();
		
		int arr1[] = { 10, 80, 30, 90, 40, 50, 70 };
		int res[] = quickSort(arr1, 0, arr1.length - 1);
		System.out.println("Quick Sort:");
		Arrays.stream(res).forEach(x -> System.out.print(x + " "));
		System.out.println();

	}

	private static int[] quickSort(int[] arr, int l, int r) {
		if (l < r) {
			int pi = partition(arr, l, r);

			quickSort(arr, l, pi - 1);
			quickSort(arr, pi + 1, r);
		}
		return arr;
	}

	private static int partition(int[] arr, int low, int r) {
		int high = r;

		int i = low - 1;

		for (int k = low; k < high; k++) {
			if (arr[k] <= arr[high]) {
				i++;
				int temp = arr[i];
				arr[i] = arr[k];
				arr[k] = temp;
			}
		}

		int swap = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = swap;

		return i + 1;
	}

	public static void mergeSort(int arr[], int l, int h) {
		if (l < h) {
			int mid = (l + h) / 2;
			mergeSort(arr, l, mid);
			mergeSort(arr, mid + 1, h);
			merge(arr, l, mid, h);
		}
	}

	public static  void merge(int arr[], int l, int m, int h) {
		int n1 = m - l + 1;
		int n2 = h - m;

		int la[] = new int[n1];
		for (int i = 0; i < n1; i++) {
			la[i] = arr[l + i];
		}

		int ra[] = new int[n2];
		for (int j = 0; j < n2; j++) {
			ra[j] = arr[m + j + 1];
		}

		int i = 0;
		int j = 0;
		int k = l;
		while (i < n1 && j < n2) {
			if (la[i] < ra[j]) {
				arr[k] = la[i];
				i++;
				k++;
			} else {
				arr[k] = ra[j];
				j++;
				k++;
			}
		}

		while (i < n1) {
			arr[k] = la[i];
			i++;
			k++;
		}

		while (j < n2) {
			arr[k] = ra[j];
			j++;
			k++;
		}
	}
}
