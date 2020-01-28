package sorting;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRoomsOne {

  public boolean canAttendMeetings(int[][] intervals) {
    Comparator<int[]> comparator = Comparator.comparingInt((int[] a) -> a[0]);
    Arrays.sort(intervals, comparator);

    for (int i = 0; i < intervals.length -1; i++) {
      if (intervals[i][0] > intervals[i + 1][0]) {
        return false;
      }
    }

    return true;
  }
}
