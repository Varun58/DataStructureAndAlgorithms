package sorting;

public class SelectionSort {


  public static void main(String[] args) {
    int arr[] = {10, 80, 30, 90, 40, 50, 70};
    sort(arr);

    for (int value : arr) {
      System.out.print(value + " ");
    }
  }

  public static void sort(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      int pos = i;
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[j] < arr[pos]) {
          pos = j;
        }
      }
      swap(arr, i, pos);
    }
  }

  private static void swap(int[] arr, int idxA, int idxB) {
    int temp = arr[idxA];
    arr[idxA] = arr[idxB];
    arr[idxB] = temp;
  }
}
