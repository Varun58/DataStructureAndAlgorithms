package math;

public class ReverseInteger {

  // Given a 32-bit signed integer, reverse digits of an integer.
  // Input: 123
  // Output: 321

  // Input: -123
  // Output: -321

  public static void main(String[] args) {
    System.out.println(reverse2(2147483647));
    System.out.println(reverse2(2147483630));
    System.out.println(reverse2(-2147483631));
    System.out.println(reverse2(123));
    System.out.println(reverse2(-123));
  }

  private static int reverse(int x) {
    int reversedValue = 0;

    while (x != 0) {
      int pop = x % 10;
      x /= 10;

      if (reversedValue > Integer.MAX_VALUE / 10 || (reversedValue == Integer.MAX_VALUE / 10 && pop > 7)
          || (reversedValue < Integer.MIN_VALUE / 10 || (reversedValue == Integer.MIN_VALUE / 10 && pop < -8))) {
        return 0;
      }
      reversedValue = reversedValue * 10 + pop;
    }
    return 0;
  }

  private static int reverse2(int x) {
    if (x == 0 || x == Integer.MAX_VALUE || x == Integer.MIN_VALUE) {
      return 0;
    }

    int tempInt = Integer.signum(x) * x;
    int remainder = 0;
    int newNum = 0;

    while (tempInt > 0) {
      if ((long) newNum * 10 > Integer.MAX_VALUE) {
        return 0;
      }

      remainder = tempInt % 10;
      newNum = newNum * 10 + remainder;
      tempInt /= 10;
    }

    return Integer.signum(x) * newNum;
  }

  private static int reverse3(int x) {
    if (x == 0 || x == Integer.MAX_VALUE || x == Integer.MIN_VALUE) {
      return 0;
    }

    int signValue = Integer.signum(x);

    String reversedInteger = new StringBuilder(String.valueOf(Math.abs(x))).reverse().toString();

    if (Long.parseLong(reversedInteger) > Integer.MAX_VALUE) {
      return 0;
    }

    return signValue * Integer.parseInt(reversedInteger);
  }
}
