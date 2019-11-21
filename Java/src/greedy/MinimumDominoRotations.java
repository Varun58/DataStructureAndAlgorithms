package greedy;

public class MinimumDominoRotations {

  //https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/

  // O(n)
  public static void main(String[] args) {
    int[] arrA = {2, 1, 2, 4, 2, 2};
    int[] arrB = {5, 2, 6, 2, 3, 2};
    System.out.println(minDominoRotations(arrA, arrB));
  }

  // https://www.youtube.com/watch?v=EIwaaYt9UDk
  private static int minDominoRotations(int[] A, int[] B) {
    int n = A.length;
    int aSwap = 0, bSwap = 0;

    int i = 0;
      for (; i < n && ((A[i] == A[0]) || (B[i] == A[0])); i++) {

      if (A[i] != A[0]) {
        aSwap++;
      }

      if (B[i] != A[0]) {
        bSwap++;
      }
    }

    if (i == n) {
      return Math.min(aSwap, bSwap);
    }

    int j = 0;
    aSwap = 0;
    bSwap = 0;

    for (; j < n && ((A[j] == B[0]) || (B[i] == B[0])); j++) {

      if (A[j] != B[0]) {
        aSwap++;
      }

      if (B[j] != B[0]) {
        bSwap++;
      }
    }

    if (j == n) {
      return Math.min(aSwap, bSwap);
    }

    return -1;
  }

  public static int minDominoRotations2(int[] A, int[] B) {
    int n = A.length;
    int rotations = check(A[0], B, A, n);
    // If one could make all elements in A or B equal to A[0]
    if (rotations != -1 || A[0] == B[0]) {
      return rotations;
    }
    // If one could make all elements in A or B equal to B[0]
    else {
      return check(B[0], B, A, n);
    }
  }

  public static int check(int x, int[] A, int[] B, int n) {
    // how many rotations should be done
    // to have all elements in A equal to x
    // and to have all elements in B equal to x
    int rotations_a = 0, rotations_b = 0;
    for (int i = 0; i < n; i++) {
      // rotations coudn't be done
      if (A[i] != x && B[i] != x) {
        return -1;
      }
      // A[i] != x and B[i] == x
      else if (A[i] != x) {
        rotations_a++;
      }
      // A[i] == x and B[i] != x
      else if (B[i] != x) {
        rotations_b++;
      }
    }
    // min number of rotations to have all
    // elements equal to x in A or B
    return Math.min(rotations_a, rotations_b);
  }
}
