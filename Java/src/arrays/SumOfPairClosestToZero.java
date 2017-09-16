package arrays;

public class SumOfPairClosestToZero {

	public static void main(String[] args) {
		int arr[] = { 1, 60, -10, 70, -80, 85 };
		minAbsSumPair(arr);
		minAbsSumPairUsingSorting(arr);
	}

	private static void minAbsSumPair(int[] arr) {
		int minSum = Integer.MAX_VALUE;
		int minI = 0, minJ = 0;

		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (Math.abs(arr[i] + arr[j]) < minSum) {
					minSum = Math.abs(arr[i] + arr[j]);
					minI = i;
					minJ = j;
				}
			}
		}

		System.out.println(" Elements having sum closest to zero are " + arr[minI] + " " + arr[minJ]);
	}

	private static void minAbsSumPairUsingSorting(int[] arr) {
		int minSum = Integer.MAX_VALUE;
		int minI = 0, minJ = 0;

		quickSort(arr, 0, arr.length-1);
		
		int i = 0;
		int j = arr.length-1;
		
		while(i<j) {
				if (Math.abs(arr[i] + arr[j]) < minSum) {
					minSum = Math.abs(arr[i] + arr[j]);
					minI = i;
					minJ = j;
					i++;
					j--;
				}
				else if (Math.abs(arr[i] + arr[j]) > minSum){
					j--;
				}else {
					i++;
				}
			}
		System.out.println(" Elements having sum closest to zero are " + arr[minI] + " " + arr[minJ]);
	}

	public static void quickSort(int arr[], int l, int h) {
		if (l < h) {
			int piv = partition(arr, l, h);
			quickSort(arr, l, piv - 1);
			quickSort(arr, piv + 1, h);
		}
	}

	private static int partition(int[] arr, int l, int h) {

		int pi = arr[h];
		int i = l - 1;
		for (int j = l; j < h; j++) {

			if (arr[j] <= pi) {
				i++;

				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}

		int temp = arr[i + 1];
		arr[i + 1] = arr[h];
		arr[h] = temp;
		return i + 1;
	}
}
