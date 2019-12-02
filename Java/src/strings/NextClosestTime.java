package strings;

import java.util.HashSet;
import java.util.Set;

public class NextClosestTime {
  public static void main(String[] args) {
    System.out.print(nextClosestTime("18:59"));
  }

  public static String nextClosestTime(String time) {
    int minutes = Integer.parseInt(time.substring(0, 2)) * 60;
    minutes += Integer.parseInt(time.substring(3));

    Set<Integer> set = new HashSet<>();
    for (char c : time.toCharArray()) {
      if (c != ':') {
        set.add(c - '0');
      }
    }

    while (true) {
      minutes = (minutes + 1) % (24 * 60);
      int[] digits = {
          minutes / 60 / 10, minutes / 60 % 10, minutes % 60 / 10, minutes % 60 % 10
      };

      boolean isValid = true;
      for (int val : digits) {
        if (!set.contains(val)) {
          isValid = false;
          break;
        }
      }

      if (isValid) {
        return String.format("%02d:%02d", minutes / 60, minutes % 60);
      }
    }

  }
}
