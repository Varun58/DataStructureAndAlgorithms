package math;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PrisionCellsAfterNDays {

  // https://www.youtube.com/watch?v=KcEtcBDX76w

  public int[] prisonAfterNDays(int[] cells, int N) {
    Set<String> set = new HashSet<String>();

    int size = 0;
    boolean flag = false;

    for (int i=0 ; i < N; i++) {
      int[] nextDayValue = nextDay(cells);
      String str = Arrays.toString(nextDayValue);
      if(!set.contains(str)) {
        set.add(str);
        size++;
      }else {
        flag = true;
        break;
      }

      cells = nextDayValue;
    }

    if(flag) {
      N = N % size;
      for(int i=1; i<= N;i++) {
        cells = nextDay(cells);
      }
    }

    return cells;
  }

  private int[] nextDay(int[] cells) {
    int[] res = new int[cells.length];
    for(int i = 1 ; i < cells.length -1 ; i++) {
      if(cells[i-1] == cells[i+1]) {
        res[i] = 1;
      }
    }
    return res;
  }
}
