package arrays;

public class ContainerWithMostWater {

  public int maxArea(int[] height) {
    if (height == null || height.length == 0 || height.length == 1) {
      return 0;
    }

    int size = height.length;
    int l = 0;
    int r = size - 1;

    int maxArea = Integer.MIN_VALUE;

    while (l < r) {
      maxArea = Math.max(maxArea, (Math.min(height[l], height[r]) * (r - l)));
      if (height[l] > height[r]) {
        r--;
      } else {
        l++;
      }
    }

    return maxArea;
  }
}
