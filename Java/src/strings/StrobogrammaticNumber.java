package strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class StrobogrammaticNumber {

  public boolean isStrobogrammatic(String num) {
    Map<Character, Character> map = new HashMap<>();
    map.put('1','1');
    map.put('6','9');
    map.put('8','8');
    map.put('9','6');
    map.put('0', '0');

    int l= 0;
    int r = num.length() -1;

    while(l<=r) {

      if (!map.containsKey(num.charAt(l)))
        return false;

      if (map.get(num.charAt(l)) != num.charAt(r))
        return false;

      l++;
      r--;
    }

    return true;
  }

  public boolean isStrobogrammatic2(String num) {
    int[] map = new int[10];
    Arrays.fill(map, -1);
    map[0] = 0;
    map[1] = 1;
    map[8] = 8;
    map[6] = 9;
    map[9] = 6;
    int i = 0, j = num.length() - 1;
    while(i <= j) {
      if(map[num.charAt(i) - '0'] != num.charAt(j) - '0') return false;
      i++;
      j--;
    }
    return true;
  }

}
