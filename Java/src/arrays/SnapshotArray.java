package arrays;

import java.util.TreeMap;

public class SnapshotArray {

  TreeMap<Integer, Integer>[] A;
  int snapId = 0;

  public SnapshotArray(int length) {
    A = new TreeMap[length];
    for (int i = 0; i < A.length; i++) {
      A[i] = new TreeMap<>();
      A[i].put(0, 0);
    }
  }

  public void set(int index, int value) {
    A[index].put(snapId, value);
  }

  public void snap() {
    snapId++;
  }

  public int get(int index, int snapId) {
    return A[index].floorEntry(snapId).getValue();
  }
}
