package arrays;

public class TrappingRainWater {

  public static void main(String[] args) {
    int arr[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
		System.out.println(maxTrappedRainWater(arr));
    System.out.println(maxTrappedRainWaterUsingLeftRightHigh(arr));
    System.out.println(maxTrappedRainWaterUsingLeftRightPointers(arr));
  }

  // Method 1 : Find Max Height on left and Max height on right , get diff of min
  // height - curr element
  // Method 2 : Use Two pointers low and high and keep adding res

  public static int maxTrappedRainWaterUsingLeftRightHigh(int arr[]) {
    int n = arr.length;
    int[] leftMax = new int[n];
    int[] rightMax = new int[n];

    leftMax[0] = arr[0];
    for (int i = 1; i < n; i++) {
      leftMax[i] = Math.max(leftMax[i - 1], arr[i]);
    }

    rightMax[n - 1] = arr[n - 1];
    for (int i = n - 2; i > 0; i--) {
      rightMax[i] = Math.max(rightMax[i + 1], arr[i]);
    }

    int res = 0;
    for (int i = 0; i < n; i++) {
      res += Math.max(Math.min(leftMax[i], rightMax[i]) - arr[i], 0);
    }

    return res;
  }

  public static int maxTrappedRainWaterUsingLeftRightPointers(int arr[]) {
    int low = 0, high = arr.length - 1;
    int lmax = 0, rmax = 0;

    int res = 0;

    while (low <= high) {
      if (arr[low] < arr[high]) {
        if (arr[low] > lmax) {
          lmax = arr[low];
        } else {
          res += lmax - arr[low];
        }
        low++;
      } else {
        if (arr[high] > rmax) {
          rmax = arr[high];
        } else {
          res += rmax - arr[high];
        }
        high--;
      }
    }
    return res;
  }

  public static int maxTrappedRainWater(int arr[]) {
    int result = 0;

    for (int i = 0; i < arr.length - 1; i++) {
      int left = arr[i];
      for (int j = 0; j < i; j++) {
        left = Math.max(left, arr[j]);
      }

      int right = arr[i];
      for (int j = i + 1; j < arr.length - 1; j++) {
        right = Math.max(right, arr[j]);
      }

      result = result + (Math.min(left, right) - arr[i]);
    }
    return result;
  }

}
