package arrays;

public class RotateArrays {

	public static void main(String[] args) {

		int[][] arr = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

		rotateArrayBy90Degree(arr);
	}

	public static int[][] rotateArrayBy90Degree(int arr[][]) {
		int n = arr.length - 1;

		for (int i = 0; i < n / 2; i++) {

			for (int j = 0; j < n; j++) {

				int temp = arr[i][j];
				arr[i][j] = arr[n - j][i];
				arr[n - j][i] = arr[n - i][n - j];
				arr[n - i][n - j] = arr[j][n - i];
				arr[j][n - i] = temp;
			}

		}

		return arr;
	}

	int[][] rotate(int[][] input) {

		int n = input.length;
		int m = input[0].length;
		int[][] output = new int[m][n];

		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				output[j][n - 1 - i] = input[i][j];
		return output;
	}
}
