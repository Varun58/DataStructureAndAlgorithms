package arrays;

import java.util.Arrays;

public class PlusOne {

  public static void main(String[] args) {
    System.out.println(Arrays.toString(plusOne(new int[] {1, 8, 9})));
  }

  public static int[] plusOne(int[] digits) {
    int carry = 1;
    for (int i = digits.length - 1; i >= 0; i--) {
      digits[i] += carry;
      if (digits[i] <= 9) {
        return digits;
      }
      digits[i] = 0;
    }
    int[] ret = new int[digits.length + 1];
    ret[0] = 1;
    return ret;
  }

  public static int[] plusOne2(int[] digits) {
    if (digits == null || digits.length == 0) {
      return digits;
    }


    int carry = 0;
    boolean shift = false;
    for (int i = digits.length - 1; i >= 0; i--) {
      if (i == digits.length - 1) {
        int sum = digits[i] + 1;
        carry = sum / 10;
        digits[i] = sum % 10;

        if (i == 0 && carry != 0) {
          shift = true;
        }
      } else {
        int sum = digits[i] + carry;
        carry = sum / 10;
        digits[i] = sum % 10;

        if (i == 0 && carry != 0) {
          shift = true;
        }
      }
    }

    if (shift) {
      int[] newDigits = new int[digits.length + 1];
      System.arraycopy(digits, 0, newDigits, 1, digits.length);
      newDigits[0] = carry;
      return newDigits;
    }

    return digits;
  }
}
