package arrays;

import java.util.HashMap;

public class FruitIntoBaskets {

  public static void main(String[] args) {
    System.out.println(totalFruit(new int[] {3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4}));
  }

  // Sol1: O(n) with O(1) space
  // https://www.youtube.com/watch?v=s_zu2dOkq80  
  public static int totalFruit(int[] tree) {
    if (tree == null || tree.length == 0) {
      return 0;
    }

    int lastFruit = -1;
    int secondLastFruit = -1;
    int lastFruitCount = 0;
    int max = 0;
    int currentMax = 0;

    for (int fruit : tree) {

      if (fruit == lastFruit || fruit == secondLastFruit) {
        currentMax++;
      } else {
        currentMax = lastFruitCount + 1;
      }

      if (fruit == lastFruit) {
        lastFruitCount++;
      } else {
        lastFruitCount = 1;
      }

      if (fruit != lastFruit) {
        secondLastFruit = lastFruit;
        lastFruit = fruit;
      }

      max = Math.max(max, currentMax);
    }

    return max;
  }

  // Sol: 1   O(n) with space comp O(n)
  // https://www.youtube.com/watch?v=za2YuucS0tw
  // https://leetcode.com/problems/fruit-into-baskets/solution/
  public static int totalFruit2(int[] tree) {
    if (tree == null || tree.length == 0) {
      return 0;
    }

    int max = 1;
    HashMap<Integer, Integer> map = new HashMap<>();
    int i = 0;
    int j = 0;

    while (j < tree.length) {

      if (map.size() <= 2) {
        map.put(tree[j], j++);
      }

      if (map.size() > 2) {
        int min = tree.length - 1;
        for (int value : map.values()) {
          min = Math.min(min, value);
        }

        i = min + 1;
        map.remove(tree[min]);
      }

      max = Math.max(max, j - i);
    }

    return max;
  }
}
