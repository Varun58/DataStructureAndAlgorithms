package sorting;

public final class BubbleSort {

  public static void main(String[] args) {
    int arr[] = {10, 80, 30, 90, 40, 50, 70};
    sort(arr);

    for (int value : arr) {
      System.out.print(value + " ");
    }
  }

  public static void sort(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = i; j < arr.length - 1; j++) {
        if (arr[j] > arr[j + 1]) {
          swap(arr, j, j + 1);
        }
      }
    }
  }

  private static int[] swap(int[] arr, int idxA, int idxB) {
    int temp = arr[idxA];
    arr[idxA] = arr[idxB];
    arr[idxB] = temp;
    return arr;
  }
}
