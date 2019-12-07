package arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Calendar1 {

    List<int[]> calendar;
    TreeMap<Integer, Integer> calendar2;

    public Calendar1() {
      calendar = new ArrayList<>();
      calendar2 = new TreeMap<>();
    }

    //[s1,e1] [s2, e2]

    //  two events [s1, e1) and [s2, e2) do not conflict
    // if and only if one of them starts after the other one ends:
    // either e1 <= s2 OR e2 <= s1.

    // By De Morgan's laws, this means the events conflict
    // when s1 < e2 AND s2 < e1.
    public boolean book1(int start, int end) {
      for(int[] iv: calendar) {
        if(iv[0] < end && start < iv[1]) {
          return false;
        }
      }

      calendar.add(new int[]{start, end});
      return true;
    }



    public boolean book2(int start, int end) {
      Integer prev = calendar2.floorKey(start);
      Integer next = calendar2.ceilingKey(start);

      if( (prev == null || calendar2.get(prev) <= start) &&
          (next == null || next >= end)
      ) {
        calendar2.put(start, end);
        return true;
      }

      return false;
    }

    public boolean book(int start, int end) {
      Integer prev = calendar2.floorKey(end -1);

      if( (prev != null && calendar2.get(prev) > start)) {
        return false;
      }

      calendar2.put(start, end);
      return true;
    }
}
