package arrays;

public class JumpGame {

  public static void main(String[] args) {
    int[] nums = {2, 3, 1, 1, 4};
    System.out.println(canJump(nums));
  }

  public static boolean canJump(int[] nums) {
    if (nums == null || nums.length == 0) {
      return true;
    }

    boolean[][] possibleJumps = new boolean[nums.length][nums.length];
    for (int i = 0; i < nums.length; i++) {
      for (int j = 0; j < nums.length; j++) {
        if (i == j) {
          possibleJumps[i][j] = true;
        } else if (i < j) {
          possibleJumps[i][j] = false;
        } else {
          int temp = nums[i];
          while (temp > 0 && j < nums.length - 1) {
            possibleJumps[i][j++] = true;
            temp--;
          }
        }
      }
    }

    int k = nums.length - 1;
    int l = nums.length - 1;
    while (possibleJumps[k][l]) {
      if (possibleJumps[k][l - 1]) {
        l--;
        continue;
      }

      if (possibleJumps[k - 1][l]) {
        k--;
      }
    }

    return k == 0 && l == 0;
  }
}
