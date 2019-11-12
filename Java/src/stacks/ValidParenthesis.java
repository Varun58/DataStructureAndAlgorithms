package stacks;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParenthesis {

  public static void main(String[] args) {
    String input = "]";
    System.out.println(isValid(input));
  }

  // Solution 1
  public static boolean isValid(String s) {
    Map<Character, Character> map = new HashMap<>();
    map.put(')', '(');
    map.put(']', '[');
    map.put('}', '{');

    Stack<Character> stack = new Stack<>();

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (map.containsKey(s.charAt(i))) {
        char topElement = stack.isEmpty() ? '#' : stack.pop();

        if (topElement != map.get(c)) {
          return false;
        }
      } else {
        stack.push(s.charAt(i));
      }
    }

    return stack.isEmpty();
  }
}
