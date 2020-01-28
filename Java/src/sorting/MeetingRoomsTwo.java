package sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomsTwo {

  public int minMeetingRooms(int[][] intervals) {
    if (intervals == null || intervals.length == 0) {
      return 0;
    }

    PriorityQueue<Integer> allocator = new PriorityQueue<>(
        intervals.length,
        Comparator.comparingInt(a -> a)
    );
    
    Arrays.sort(intervals, Comparator.comparing((int[] a) -> a[0]));

    allocator.add(intervals[0][1]);
    for (int i = 1; i < intervals.length; i++) {
      if (intervals[i][0] >= allocator.peek()) {
        allocator.poll();
      }

      allocator.add(intervals[i][1]);
    }

    return allocator.size();
  }
}
