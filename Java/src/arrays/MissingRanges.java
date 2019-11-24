package arrays;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {

  public static void main(String[] args) {
    System.out.println(findMissingRanges(new int[] {2147483647}, 0, 2147483647));
    System.out.println(findMissingRanges(new int[] {0, 1, 3, 50, 75}, 0, 99));
    System.out.println(findMissingRanges(new int[] {}, 1, 1));
    System.out.println(findMissingRanges(new int[] {1, 3}, 0, 9));
  }

  // Sol: 1 https://leetcode.com/problems/missing-ranges/discuss/281962/Java-1ms-clear-code
  public static List<String> findMissingRanges(int[] nums, int lower, int upper) {
    List<String> results = new ArrayList<>();
    int n = nums.length;

    if (n == 0) {
      results.add(intervalToString(lower, upper));
      return results;
    }

    if (lower < nums[0]) {
      results.add(intervalToString(lower, nums[0] - 1));
    }

    for (int i = 0; i < n - 1; i++) {
      if ((nums[i] + 1 == nums[i + 1]) || (nums[i + 1] == nums[i])) {
        continue;
      }

      results.add(intervalToString(nums[i] + 1, nums[i + 1] - 1));
    }

    if (upper > nums[n - 1]) {
      results.add(intervalToString(nums[n - 1] + 1, upper));
    }

    return results;
  }

  private static String intervalToString(int i, int j) {
    return i == j ? ("" + j) : (i + "->" + j);
  }
}
