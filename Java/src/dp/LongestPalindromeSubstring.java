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
}
