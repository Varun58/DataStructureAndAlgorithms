package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

// ref counting sort : https://medium.com/basecs/counting-linearly-with-counting-sort-cd8516ae09b3
public class CampusBikes {

  public static void main(String[] args) {

    int[][] workers = {{0, 0}, {1, 1}, {2, 0}};
    int[][] bikes = {{1, 0}, {2, 2}, {2, 1}};
    System.out.println(Arrays.toString(new CampusBikes().assignBikes(workers, bikes)));
  }


  public int[] assignBikes(int[][] workers, int[][] bikes) {
    int[] results = new int[workers.length];

    Set<Point> workersLeft = new HashSet<>();
    Set<Point> bikesLeft = new HashSet<>();

    for (int i = 0; i < workers.length; i++) {
      workersLeft.add(new Point(workers[i], i));
    }

    for (int i = 0; i < bikes.length; i++) {
      bikesLeft.add(new Point(bikes[i], i));
    }

    while (!workersLeft.isEmpty()) {
      Point currentWorker = workersLeft.iterator().next();
      Point worker = null;
      Point bike = null;

      while (true) {
        bike = closest(currentWorker, bikesLeft);
        worker = closest(bike, workersLeft);

        if (currentWorker == worker) {
          break;
        } else {
          currentWorker = worker;
        }
      }

      results[worker.i] = bike.i;
      workersLeft.remove(worker);
      bikesLeft.remove(bike);
    }

    return results;
  }

  public Point closest(Point x, Set<Point> pool) {
    int minDis = Integer.MAX_VALUE;
    Point result = null;

    for (Point each : pool) {
      int newDist = manHattanDistance(x, each);
      if (newDist < minDis) {
        minDis = newDist;
        result = each;
      } else if (newDist == minDis && result != null && each.i < result.i) {
        result = each;
      }
    }

    return result;
  }

  public int manHattanDistance(Point a, Point b) {
    return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
  }

  class Point {
    int x;
    int y;
    int i;

    public Point(int[] c, int j) {
      x = c[0];
      y = c[1];
      i = j;
    }

    @Override
    public String toString() {
      return "Point{" +
          "x=" + x +
          ", y=" + y +
          ", i=" + i +
          '}';
    }
  }

  // Sol2: Counting Sort O(mn)
  // https://leetcode.com/problems/campus-bikes/discuss/309284/Java-counting-sort-solution-47ms-(100)
  public static int[] assignBikes2(int[][] workers, int[][] bikes) {
    int w = workers.length;
    int b = bikes.length;

    int[] wo = new int[w];
    int[] bi = new int[b];

    List<int[]>[] distances = new List[2001];

    Arrays.fill(wo, -1);
    Arrays.fill(bi, -1);

    for (int i = 0; i < w; i++) {
      for (int j = 0; j < b; j++) {
        int[] worker = workers[i];
        int[] bike = bikes[j];

        int dist = manHattanDistance(worker, bike);

        if (distances[dist] == null) {
          distances[dist] = new ArrayList<int[]>();
        }

        distances[dist].add(new int[] {i, j});
      }
    }

    int assigned = 0;
    for (int i = 0; i <= 2000 && assigned < w; i++) {
      if (distances[i] == null) {
        continue;
      }
      for (int[] pair : distances[i]) {
        if (wo[pair[0]] == -1 && bi[pair[1]] == -1) {
          wo[pair[0]] = pair[1];
          bi[pair[1]] = pair[0];
          assigned++;
        }
      }
    }

    return wo;
  }

  // Sol3: Use Priority queue O(mn) * log(mn)
  // https://leetcode.com/problems/campus-bikes/discuss/305603/Java-Fully-Explained
  public static int[] assignBikes3(int[][] workers, int[][] bikes) {
    int n = workers.length;

    // {distance, i ,j }
    PriorityQueue<int[]> queue = new PriorityQueue<>(
        (a, b) -> {
          int comp = Integer.compare(a[0], b[0]);

          if (comp == 0) {
            if (a[1] == b[1]) {
              return Integer.compare(a[2], b[2]);
            }

            return Integer.compare(a[1], b[1]);
          }

          return comp;
        });

    for (int i = 0; i < workers.length; i++) {
      int[] worker = workers[i];

      for (int j = 0; j < bikes.length; j++) {
        int[] bike = bikes[j];
        int dist = manHattanDistance(bike, worker);
        queue.add(new int[] {dist, i, j});
      }
    }

    int[] res = new int[n];
    Arrays.fill(res, -1);

    Set<Integer> bikeAssignedIndexes = new HashSet<>();
    while (bikeAssignedIndexes.size() < n) {
      int[] workerAndBikePair = queue.poll();
      if (workerAndBikePair != null && res[workerAndBikePair[1]] == -1
          && !bikeAssignedIndexes.contains(workerAndBikePair[2])
      ) {
        res[workerAndBikePair[1]] = workerAndBikePair[2];
        bikeAssignedIndexes.add(workerAndBikePair[2]);
      }
    }

    return res;
  }

  private static int manHattanDistance(int[] a, int b[]) {
    return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
  }
}
