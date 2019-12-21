package arrays;

import java.util.Arrays;

public class MaximumSumSubArray {

  public static void main(String[] args) {
    int input[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    System.out.println(maxSubArray(input));

    int input2[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    System.out.println(maxSubArray2(input2));


    int input3[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    System.out.println(Arrays.toString(new MaximumSumSubArray().maximumSumSubarray(input3)));
  }

  public int[] maximumSumSubarray(int[] nums) {
    int start = 0;
    int end = 0;
    int s = 0;

    int currSum = nums[0];
    int maxSum = nums[1];
    for (int i = 0; i < nums.length; i++) {
      currSum = currSum + nums[i];
      
      if (currSum > maxSum) {
        maxSum = currSum;
        start = s;
        end = i;
      }

      if (currSum < 0) {
        currSum = 0;
        s = i + 1;
      }
    }

    return new int[] {start, end};
  }


  // Sol1: Greedy
  public static int maxSubArray(int[] nums) {
    int n = nums.length;
    int currSum = nums[0];
    int maxSum = nums[0];

    for (int i = 0; i < n; i++) {
      currSum = Math.max(nums[i], currSum + nums[i]);
      maxSum = Math.max(currSum, maxSum);
    }

    return maxSum;
  }

  // Sol2: Dynamic Programming ( Kadanes Algorithm)
  public static int maxSubArray2(int[] nums) {
    int n = nums.length;
    int maxSum = nums[0];

    for (int i = 1; i < n; i++) {
      if (nums[i - 1] > 0) {
        nums[i] += nums[i - 1];
      }
      maxSum = Math.max(nums[i], maxSum);
    }

    return maxSum;
  }

  // Sol3: https://www.geeksforgeeks.org/maximum-subarray-sum-using-divide-and-conquer-algorithm/
}
