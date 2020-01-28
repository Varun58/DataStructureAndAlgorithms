package matrix;

public class RotateMatrixBy90Degrees {

	public static void main(String[] args) {
		int image[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		System.out.println("Before Transformation : ");
		printMatrix(image);

		System.out.println("After Transformation : ");
		printMatrix(rotateMatrixBy90DegreeClockWise(image));

		System.out.println("After Anti Transformation : ");
		printMatrix(rotateMatrixBy90DegreeAntiClockWise(image));

		// Rotate N*N matrix INPlace
		int image2[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };

		System.out.println("Before INPLACE Transformation : ");
		printMatrix(image2);

		System.out.println("After Anti Transformation INPLACE: ");
		printMatrix(rotateMatrixBy90DegreeAntiClockWiseInplace(image2));

	}

	static int[][] rotateMatrixBy90DegreeClockWise(int arr[][]) {

		int m = arr.length;
		int n = arr[0].length;

		int c[][] = new int[n][m];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				c[j][m - 1 - i] = arr[i][j];
			}
		}
		return c;
	}

	static int[][] rotateMatrixBy90DegreeAntiClockWise(int arr[][]) {

		int m = arr.length;
		int n = arr[0].length;

		int c[][] = new int[n][m];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				c[n - 1 - j][i] = arr[i][j];
			}
		}
		return c;
	}

	static void printMatrix(int arr[][]) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + "    ");
			}
			System.out.println();
		}
	}

	static int[][] rotateMatrixBy90DegreeAntiClockWiseInplace(int arr[][]) {

		int n = arr.length;

		for (int i = 0; i < n / 2; i++) {
			for (int j = i; j < n - 1 - i; j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[j][n - 1 - i];
				arr[j][n - 1 - i] = arr[n - 1 - i][n - 1 - j];
				arr[n - 1 - i][n - 1 - j] = arr[n - 1 - j][i];
				arr[n - 1 - j][i] = temp;
			}
		}
		return arr;
	}
}
