package arrays;

import java.util.Arrays;

public class PlusOne {

  public static void main(String[] args) {
    System.out.println(Arrays.toString(plusOne(new int[]{9})));
  }

  public static int[] plusOne(int[] digits) {
    if(digits == null || digits.length == 0) {
      return digits;
    }


    int carry = 0;
    boolean shift = false;
    for(int i = digits.length -1 ; i >=0 ; i --) {
      if(i == digits.length -1 ) {
        int sum= digits[i] + 1;
        carry = sum/10;
        digits[i] = sum % 10;

        if(i ==0 && carry != 0) {
          shift = true;
        }
      } else {
        int sum= digits[i] + carry;
        carry = sum/10;
        digits[i] = sum % 10;

        if(i ==0 && carry != 0) {
          shift = true;
        }
      }
    }

    if(shift) {
      int[] newDigits = new int[digits.length+1];
      System.arraycopy(digits, 0, newDigits, 1, digits.length);
      newDigits[0] = carry;
      return newDigits;
    }

    return digits;
  }
}
