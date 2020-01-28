package arrays;

public class RotateArrays {

  // https://www.youtube.com/watch?v=SA867FvqHrM

  // sol 1 : transpose and reverse the elements in the rows
  // sol 2 : reverse 4 values in the outer matrix
  public static void main(String[] args) {

    int[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};

    rotateArrayBy90Degree(arr);
  }

  public static int[][] rotateArrayBy90Degree(int[][] arr) {
    int n = arr.length;

    // transpose
    for (int i = 0; i < n; i++) {
      for (int j = i; j < n; j++) {
        int temp = arr[i][j];
        arr[i][j] = arr[j][i];
        arr[j][i] = temp;
      }
    }

    // reverse elements in the rows
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n / 2; j++) {
        int temp = arr[i][j];
        arr[i][j] = arr[i][n - j - 1];
        arr[i][n - j - 1] = temp;
      }
    }
    return arr;
  }

  public static int[][] rotateArrayBy90Degree2(int[][] arr) {
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
}
