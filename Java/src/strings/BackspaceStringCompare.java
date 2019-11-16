package strings;

import java.util.Stack;

public final class BackspaceStringCompare {

  public static void main(String[] args) {
    System.out.println(backspaceCompare("a##c", "#a#c"));
    System.out.println(backspaceCompare("ab##", "c#d#"));
    System.out.println(backspaceCompare("a#c", "b"));
  }

  // Solution 1: using two pointer
  public static boolean backspaceCompare(String S, String T) {
    int i = S.length() -1;
    int j = T.length() - 1;

    int skipS = 0;
    int skipT = 0;

    while (i >=0 || j>=0 ) {

      while (i>=0){
        if(S.charAt(i)=='#'){
          skipS++;
          i--;
        } else if(skipS > 0) {
          skipS--;
          i--;
        } else {
          break;
        }
      }

     while(j>=0) {
       if(T.charAt(j)=='#'){
         skipT++;
         j--;
       } else if(skipT > 0) {
         skipT--;
         j--;
       } else {
         break;
       }
     }

     if(i>=0  && j>= 0 && S.charAt(i) != T.charAt(j)) {
       return false;
     }

     i--;j--;
    }

    return true;
  }

  // Solution 2: using stack O(n) time and space complexity
  public static boolean backspaceCompare2(String S, String T) {
    return build(S).equals(build(T));
  }

  public static String build(String S) {
    Stack<Character> stack = new Stack<>();

    for (Character ch:S.toCharArray()) {
        if(ch != '#') {
          stack.push(ch);
        } else if(!stack.isEmpty()){
          stack.pop();
        }
    }
    return String.valueOf(stack);
  }
  

  public static boolean backspaceCompare3(String S, String T) {
    return sanitize3(S).equals(sanitize3(T));
  }

  private static String sanitize3(String input) {
    int count = 0;
    StringBuilder sb = new StringBuilder();
    for (int i = input.length()-1; i >= 0; i--) {
      Character ch = input.charAt(i);
      if(ch == '#') {
          count--;
          continue;
      }

      if( count < 0) {
        count++;
      } else {
        sb.append(ch);
      }
    }
    return sb.toString();
  }
}
