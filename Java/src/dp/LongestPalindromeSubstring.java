package dp;

public class LongestPalindromeSubstring {

  public String longestPalindrome(String input) {
    if (input == null || input.length() < 1) {
      return input;
    }

    int start = 0, end = 0;

    for (int i = 0; i < input.length(); i++) {
      int longest1 = expand(input, i, i);
      int longest2 = expand(input, i, i + 1);

      int maxLength = Math.max(longest1, longest2);

      if (maxLength > end - start) {
        start = i - (maxLength - 1) / 2;
        end = i + maxLength / 2;
      }
    }

    return input.substring(start, end + 1);
  }

  private int expand(String input, int start, int end) {
    int L = start, R = end;
    while (L >= 0 && R < input.length() && input.charAt(L) == input.charAt(R)) {
      L--;
      R++;
    }
    return R - L - 1;
  }

  public  String longestPalindromeBrute(String input) {
    String longestP = "";

    for (int i = 0; i < input.length(); i++) {
      for (int j = i +1; j <= input.length(); j++) {
        //System.out.println(input.substring(i, j));

        String inputSubstring = input.substring(i, j);

        if(isPalindrome(inputSubstring)
            && longestP.length() <= inputSubstring.length()) {
          longestP = inputSubstring;
        }
      }
    }
    return longestP;
  }

  public  boolean isPalindrome(String s) {

    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
        return false;
      }
    }

    return true;
  }
}
