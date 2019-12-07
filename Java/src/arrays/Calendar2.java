package arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Calendar2 {

  TreeMap<Integer, Integer> booked;

  List<int[]> calendar;
  List<int[]> overlaps;
  public Calendar2() {
    booked = new TreeMap<>();

    calendar = new ArrayList<>();
    overlaps = new ArrayList<>();
  }

  public boolean book(int start, int end) {
    booked.put(start, booked.getOrDefault(start, 0) + 1);
    booked.put(end, booked.getOrDefault(end, 0) - 1);

    int activeEvents = 0;
    for(int freq: booked.values()) {
      activeEvents+= freq;
      if(activeEvents >= 3) {
        booked.put(start, booked.getOrDefault(start, 0) - 1);
        booked.put(end, booked.getOrDefault(end, 0) + 1);

        return false;
      }

    }
    return true;
  }

  public boolean book2(int start, int end) {

    for(int[] iv: overlaps) {
       if(iv[0] < end && start < iv[1]) {
         return false;
       }
    }

    for(int[] iv: calendar) {
      if(iv[0] < end && start < iv[1]) {
        overlaps.add(new int[]{ Math.max(iv[0], start), Math.min(iv[1], end)});
      }
    }

    calendar.add(new int[]{start, end});
    return true;
  }
}
