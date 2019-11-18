package dp;

import java.util.Map;
import java.util.TreeMap;

public class OddEvenJumps {

  // watch this video to understand the solution https://www.youtube.com/watch?v=r2I7KIqHTPU
  // solution is based on treemap methods which internally uses RedBlack Tree
  // must read the treemap ceiling entry and floor entry implementation

  public static void main(String[] args) {
    int[] arr1 = {10,13,12,14,15};
    System.out.println(oddEvenJumps(arr1));

    int[] arr2 = {2,3,1,1,4};
    System.out.println(oddEvenJumps(arr2));
  }

  public static int oddEvenJumps(int[] A) {
    int n = A.length;
    int res = 1;

    boolean[] higher = new boolean[n];
    boolean[] lower = new boolean[n];

    higher[n - 1] = true;
    lower[n - 1] = true;

    TreeMap<Integer, Integer> map = new TreeMap<>();
    map.put(A[n - 1], n - 1);

    for (int i = n - 2; i >= 0; --i) {
      Map.Entry<Integer, Integer> hi = map.ceilingEntry(A[i]);
      Map.Entry<Integer, Integer> lo = map.floorEntry(A[i]);

      if (hi != null) {
        higher[i] = lower[hi.getValue()];
      }

      if (lo != null) {
        lower[i] = higher[lo.getValue()];
      }

      if(higher[i]) {res++;}
      map.put(A[i], i);
    }
    return res;
  }
}
