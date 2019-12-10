package strings;

import java.util.Stack;

public class DecodeStrings {

  public static void main(String[] args) {
    System.out.println(new DecodeStrings().decodeString("3[a]2[bc]"));
  }

  // https://www.youtube.com/watch?v=0iQqj5egK9k
  // https://leetcode.com/problems/decode-string/discuss/87534/Simple-Java-Solution-using-Stack
  public String decodeString(String s) {
    Stack<Integer> numStack = new Stack<>();
    Stack<String> resStack = new Stack<>();
    String res = "";

    int count = 0;
    for(int i = 0; i< s.length(); i++) {
      if(Character.isDigit(s.charAt(i))) {
        count = count*10 + (s.charAt(i) - '0');
      } else if (s.charAt(i) == '[') {
        resStack.push(res);
        numStack.push(count);
        res = "";
        count = 0;
      } else if (s.charAt(i) == ']') {
        int n = numStack.pop();
        StringBuilder temp = new StringBuilder(resStack.pop());
        for(int j = 0; j < n; j++) {
          temp.append(res);
        }
        res = temp.toString();
      } else {
        res += s.charAt(i);
      }
    }

    return res;
  }

  // https://leetcode.com/problems/decode-string/discuss/190485/Very-Easy-DFS-solution-with-no-stack
  private int i = 0;
  public String decodeString2(String s) {
    StringBuilder sb = new StringBuilder();
    int num = 0;

    while (i < s.length()) {
      char c = s.charAt(i);

      if (c >= '0' && c <= '9') {
        num = num * 10 + c - '0';
      } else if (c == '[') {
        i++;
        String str = decodeString(s);
        for (int k = 0; k < num; k++)
          sb.append(str);
        num = 0;
      } else if (c == ']') {
        return sb.toString();
      } else {
        sb.append(c);
      }
      i++;
    }

    return sb.toString();
  }
}
