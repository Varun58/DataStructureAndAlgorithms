package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class MinAreaRectangle {

  public static void main(String[] args) {
    int[][] points = {{1, 1}, {1, 3}, {3, 1}, {3, 3}, {2, 2}};
    System.out.println(minAreaRectangle(points));
  }

  //https://www.programcreek.com/2016/11/leetcode-minimum-area-rectangle-java/
  public static int minAreaRectangle(int[][] points) {
    if (points == null || points.length == 0) {
      return 0;
    }

    Arrays.sort(points, (a, b) -> {
      if (a[0] != b[0]) {
        return Integer.compare(a[0], b[0]);
      }
      return Integer.compare(a[1], b[1]);
    });

    Map<Integer, HashSet<Integer>> mapX = new HashMap<>();
    Map<Integer, HashSet<Integer>> mapY = new HashMap<>();

    for (int[] point : points) {
      int x = point[0];
      int y = point[1];

      mapX.computeIfAbsent(x, k -> new HashSet<>()).add(y);
      mapY.computeIfAbsent(y, k -> new HashSet<>()).add(x);
    }

    int result = Integer.MAX_VALUE;

    for (int i = 0; i < points.length - 1; i++) {
      for (int j = i + 1; j < points.length; j++) {
        int x1 = points[i][0];
        int y1 = points[i][1];
        int x2 = points[j][0];
        int y2 = points[j][1];

        if (mapX.get(x1).contains(y2) && mapY.get(y1).contains(x2)) {
          int area = Math.abs((x1 - x2) * (y1 - y2));
          if (area > 0) {
            result = Math.min(result, area);
          }
        }
      }
    }

    if (result == Integer.MAX_VALUE) {
      return 0;
    }

    return result;
  }
}
