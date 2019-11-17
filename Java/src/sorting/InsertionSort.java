package sorting;

public class InsertionSort {

  public static void main(String[] args) {
    int arr[] = {10, 80, 30, 90, 40, 50, 70};
    sort(arr);

    for (int value : arr) {
      System.out.print(value + " ");
    }
  }

  public static void sort(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
      int min = arr[i];
      int j = i;
      while (j >= 0 && arr[j - 1] > arr[j]) {
        arr[j] = arr[j - 1];
        j--;
      }
      arr[j] = min;
    }
  }
}
