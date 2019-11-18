package strings;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

  public static void main(String[] args) {
    System.out.println(isIsomorphic("paper", "title"));
    System.out.println(isIsomorphic("foo", "bar"));
    System.out.println(isIsomorphic("egg", "add"));
    System.out.println(isIsomorphic("ab", "aa"));

    Map<Character, Character> map = new HashMap<>();
    Character r1 = map.put('a', 'n') ;


    Character r2 = map.put('a', 't');
    System.out.println(r1);
    System.out.println(r2);
  }
  public static boolean isIsomorphic(String s, String t) {
   if(s.length() != t.length()) {
     return false;
   }

   int[] m1 = new int[256];
   int[] m2 = new int[256];

   int n1 = s.length();

    for (int i = 0; i < n1; i++) {
       if(m1[s.charAt(i)] != m2[t.charAt(i)]){
         return false;
       }

       m1[s.charAt(i)] = i+1;
       m2[t.charAt(i)] = i+1;
    }

    return true;
  }

  public static boolean isIsomorphic2(String s, String t) {
    Map<Character, Character> map = new HashMap<>();

    for(int i = 0 ; i< s.length(); i++){
      char a = s.charAt(i);
      char b = t.charAt(i);
      if(map.containsKey(a)){
        if(map.get(a).equals(b)) {
          continue;
        }
        else
          return false;
      }else{
        if(!map.containsValue(b))
          map.put(a,b);
        else return false;
      }
    }

    return true;
  }
}
