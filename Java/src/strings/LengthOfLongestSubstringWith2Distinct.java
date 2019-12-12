package strings;

import java.util.Collections;
import java.util.HashMap;

public class LengthOfLongestSubstringWith2Distinct {

  public static void main(String[] args) {
    System.out.println(new LengthOfLongestSubstringWith2Distinct().lengthOfLongestSubstringTwoDistinct("ccaabbb"));
  }

  public int lengthOfLongestSubstringTwoDistinct(String s) {
    int n = s.length();
    if (n < 3) {
      return n;
    }

    int left = 0;
    int right = 0;
    int max = 0;
    HashMap<Character, Integer> hashMap = new HashMap<>();
    while (right < n) {
      if (hashMap.size() < 3) {
        hashMap.put(s.charAt(right), right++);
      }

      if (hashMap.size() == 3) {
        int delIndx = Collections.min(hashMap.values());
        hashMap.remove(s.charAt(delIndx));
        left = delIndx + 1;
      }

      max = Math.max(max, right - left);
    }

    return max;
  }
}
