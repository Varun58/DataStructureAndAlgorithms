package strings;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

  public static void main(String[] args) {
    System.out.println(minWindow("ADOBECODEBANC", "ABC"));
  }

  public static String minWindow(String s, String t) {
    if (s.length() == 0 || t.length() == 0) {
      return "";
    }

    Map<Character, Integer> dict = new HashMap<>();
    for (char c : t.toCharArray()) {
      int count = dict.getOrDefault(c, 0);
      dict.put(c, count + 1);
    }

    int l = 0;
    int r = 0;
    int formed = 0;

    Map<Character, Integer> wc = new HashMap<>();

    int required = dict.size();
    int[] ans = {-1, 0, 0};

    while (r < s.length()) {
      char cr = s.charAt(r);
      int scount = wc.getOrDefault(cr, 0);
      wc.put(cr, scount + 1);

      if (dict.containsKey(cr) && dict.get(cr).intValue() == wc.get(cr).intValue()) {
        formed++;
      }

      while (l <= r && required == formed) {
        char cl = s.charAt(l);
        if (ans[0] == -1 || r - l + 1 < ans[0]) {
          ans[0] = r - l + 1;
          ans[1] = l;
          ans[2] = r;
        }

        wc.put(cl, wc.getOrDefault(cl, 0) - 1);
        if (dict.containsKey(cl) && wc.get(cl).intValue() < dict.get(cl).intValue()) {
          formed--;
        }

        l++;
      }

      r++;
    }

    return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
  }
}
