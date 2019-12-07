package arrays;

public class JumpGame {

  public static void main(String[] args) {
    int[] nums = {2, 3, 1, 1, 4};
    System.out.println(new JumpGame().canJump(nums));
  }

  public boolean canJump(int[] nums) {
    int lastPos = nums.length - 1;
    for (int i = nums.length - 1; i >= 0; i--) {
      if (i + nums[i] >= lastPos) {
        lastPos = i;
      }
    }
    return lastPos == 0;
  }

  public boolean canJump2(int[] nums) {
    int maxPos = 0;
    for (int i = 0; i <= nums.length - 1; i++) {
      if (i > maxPos) {
        return false;
      }
      maxPos = Math.max(maxPos, nums[i] + i);
    }
    return true;
  }

  enum Index {
    UNKNOWN, GOOD, BAD;
  }

  Index[] memo;

  public boolean canJump3(int[] nums) {
    memo = new Index[nums.length];
    for (int i = 0; i < nums.length; i++) {
      memo[i] = Index.UNKNOWN;
    }

    memo[memo.length - 1] = Index.GOOD;
    return canJumpFromPosition(0, nums);
  }

  public boolean canJumpFromPosition(int position, int nums[]) {
    if (memo[position] != Index.UNKNOWN) {
      return memo[position] == Index.GOOD;
    }

    int furthestJump = Math.min(position + nums[position], nums.length - 1);
    for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
      if (canJumpFromPosition(nextPosition, nums)) {
        memo[position] = Index.GOOD;
        return true;
      }
    }

    memo[position] = Index.BAD;
    return false;
  }
}
