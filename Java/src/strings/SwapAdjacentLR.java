package strings;

import java.util.HashMap;
import java.util.Map;

public class SwapAdjacentLR {
  public static void main(String[] args) {
    System.out.println(new SwapAdjacentLR().canTransform("RXXLRXRXL", "XRLXXRRLX"));
    System.out.println(new SwapAdjacentLR().canTransform("XLLR", "LXLX"));
    System.out.println(new SwapAdjacentLR().canTransform("XLXRRXXRXX", "LXXXXXXRRR"));
  }

  //https://leetcode.com/problems/swap-adjacent-in-lr-string/discuss/321932/One-pass-O(n)-Python-beat-99-easy-to-understand
  public boolean canTransform1(String start, String end) {
    Map<Character, Integer> map = new HashMap<>();
    map.put('R', 1);
    map.put('X', 0);
    map.put('L', -1);
    int count = 0;
    for (int i = 0; i < start.length(); i++) {
      int diff = map.get(start.charAt(i)) - map.get(end.charAt(i));
      count += diff;

      if (count < 0 || Math.abs(diff) == 2) {
        return false;
      }
    }

    return count == 0;
  }

  public boolean canTransform(String start, String end) {
    int l = 0, r = 0;
    for (int i = 0; i < start.length(); i++) {
      if (start.charAt(i) == 'L') l++;
      if (start.charAt(i) == 'R') r++;
      if (end.charAt(i) == 'L') l--;
      if (end.charAt(i) == 'R') r --;

      System.out.print("L "+ l);
      System.out.print(" R "+ r);
      if (l > 0 || r < 0 || ( l < 0 && r != 0) || (r > 0 && l != 0)) return false;
      System.out.println();
    }


    return l == 0 && r == 0;
  }


}
