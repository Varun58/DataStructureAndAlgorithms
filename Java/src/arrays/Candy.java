package arrays;

import java.util.Arrays;

public class Candy {

  public static void main(String[] args) {
    System.out.println(new Candy().candy3(new int[] {1, 2, 3, 4, 5, 3, 2, 1}));
    System.out.println(new Candy().candy3(new int[] {1, 0, 2}));
  }

  // Time : O(n)
  // Space: O(1) constant space
  public int candy3(int[] ratings) {
    if (ratings.length <= 1) {
      return ratings.length;
    }
    int candies = 0;
    int up = 0;
    int down = 0;
    int old_slope = 0;
    for (int i = 1; i < ratings.length; i++) {
      int new_slope = (ratings[i] > ratings[i - 1]) ? 1 : (ratings[i] < ratings[i - 1] ? -1 : 0);
      if ((old_slope > 0 && new_slope == 0) || (old_slope < 0 && new_slope >= 0)) {
        candies += count(up) + count(down) + Math.max(up, down);
        up = 0;
        down = 0;
      }
      if (new_slope > 0)
        up++;
      if (new_slope < 0)
        down++;
      if (new_slope == 0)
        candies++;

      old_slope = new_slope;
    }
    candies += count(up) + count(down) + Math.max(up, down) + 1;
    return candies;
  }

  public int count(int n) {
    return n * (n + 1) / 2;
  }

  // Time : O(n)
  // Space: O(n)
  public int candy(int[] ratings) {
    int n = ratings.length;
    int[] candies = new int[ratings.length];
    Arrays.fill(candies, 1);

    for (int i = 1; i < n; i++) {
      if (ratings[i] > ratings[i - 1]) {
        candies[i] = candies[i - 1] + 1;
      }
    }

    int sum = candies[n - 1];
    for (int i = n - 2; i >= 0; i--) {
      if (ratings[i] > ratings[i + 1]) {
        candies[i] = Math.max(candies[i], candies[i + 1] + 1);
      }
      sum += candies[i];
    }
    return sum;
  }

  // Time : O(n)
  // Space: O(n)
  public int candy2(int[] ratings) {
    int n = ratings.length;
    int[] l2r = new int[n];
    int[] r2l = new int[n];
    Arrays.fill(l2r, 1);
    Arrays.fill(r2l, 1);

    for (int i = 1; i < n; i++) {
      if (ratings[i] > ratings[i - 1]) {
        l2r[i] = l2r[i - 1] + 1;
      }
    }

    for (int i = n - 2; i >= 0; i--) {
      if (ratings[i] > ratings[i + 1]) {
        r2l[i] = r2l[i + 1] + 1;
      }
    }

    int candies = 0;
    for (int i = 0; i < n; i++) {
      candies += Math.max(l2r[i], r2l[i]);
    }
    return candies;
  }
}
