package arrays;

import java.util.TreeMap;

class Calendar3 {

  TreeMap<Integer, Integer> booked;

  public Calendar3() {
    booked = new TreeMap<>();
  }

  public int book(int start, int end) {
    booked.put(start, booked.getOrDefault(start, 0) + 1);
    booked.put(end, booked.getOrDefault(end, 0) - 1);

    int activeEvents = 0, maxActive = 0;
    for (int f : booked.values()) {
      maxActive = Math.max(maxActive, activeEvents += f);
    }
    return maxActive;
  }
}

