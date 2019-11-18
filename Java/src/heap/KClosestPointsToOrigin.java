package heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

  // https://leetcode.com/problems/k-closest-points-to-origin/discuss/220235/Java-Three-solutions-to-this-classical-K-th-problem.
  public static void main(String[] args) {
    int[][] points = {
        {3, 3}, {5, -1}, {-2, 4}
    };
    int resp[][] = kClosest(points, 2);

    for (int i = 0; i < resp[i].length; i++) {
      for (int j = 0; j < resp[i].length; j++) {
        System.out.println(resp[i][j]);
      }
    }
  }

  public static int[][] kClosest(int[][] points, int K) {
    int[][] res = new int[K][2];
    PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparing(a -> (a[0] * a[0] + a[1] * a[1])));
    minHeap.addAll(Arrays.asList(points));

    for (int i = 0; i < K; i++) {
      res[i] = minHeap.poll();
    }
    return res;
  }
}
