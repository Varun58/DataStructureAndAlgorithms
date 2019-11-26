package strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagrams {

  public boolean isAnagram(String s, String t) {
    if(s.length() != t.length())  {
      return false;
    }

    Map<Character, Integer> map = new HashMap<>();

    for(int i=0;i<s.length();i++ ) {
      map.put(s.charAt(i), map.getOrDefault(s.charAt(i) , 0) + 1);
      map.put(t.charAt(i), map.getOrDefault(t.charAt(i) , 0) - 1);
    }

    for(int count: map.values()) {
      if(count!= 0) {
        return false;
      }
    }
    return true;
  }

  public boolean isAnagram2(String s, String t) {
    if(s.length() != t.length())  {
      return false;
    }

    int[] counter = new int[26];

    for(int i=0;i<s.length();i++ ) {
      counter[s.charAt(i) - 'a'] ++;
      counter[t.charAt(i) - 'a'] --;
    }

    for(int count: counter) {
      if(count!= 0) {
        return false;
      }
    }
    return true;
  }

  public boolean isAnagram3(String s, String t) {
    if(s.length() != t.length())  {
      return false;
    }

    char[] str1 = s.toCharArray();
    char[] str2 = t.toCharArray();

    Arrays.sort(str1);
    Arrays.sort(str2);
    return Arrays.equals(str1, str2);
  }
}
