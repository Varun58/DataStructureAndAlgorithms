package arrays;

public class MaximumSumSubArray {

  public static void main(String[] args) {
    int input[] = {-2,1,-3,4,-1,2,1,-5,4};
    System.out.println(maxSubArray(input));
    System.out.println(maxSubArray2(input));
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
