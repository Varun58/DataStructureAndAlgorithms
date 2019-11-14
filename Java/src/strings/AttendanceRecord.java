package strings;

public final class AttendanceRecord {

  // Solution 1
  public static boolean checkRecord(String s) {
    int countA = 0;
    for (int i = 0; i < s.length() && countA < 2; i++) {
      if (s.charAt(i) == 'A') {
        countA++;
      }

      if (i < s.length() - 2 && s.charAt(i) == 'L' && s.charAt(i + 1) == 'L' && s.charAt(i + 2) == 'L') {
        return false;
      }
    }

    return countA < 2;
  }

  // Solution 2
  public static boolean checkRecord2(String s) {
    if (s == null) {
      return false;
    }

    int countL = 0;
    int countA = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == 'L') {
        int start = i + 1;
        while (start < s.length() && s.charAt(start) == 'L' && s.charAt(start - 1) == 'L') {
          start++;
        }
        countL = Math.max(countL, start - i);
      }


      if (s.charAt(i) == 'A') {
        countA++;
      }
    }

    System.out.println("countL: " + countL);
    System.out.println("countA: " + countA);

    return countA <= 1 && countL <= 2;
  }

  // miscellanious can be regex too
  public static boolean checkRecord3(String s) {
    return !s.matches(".*(A.*A|LLL).*");
  }

  public static void main(String[] args) {
    System.out.println(checkRecord("PPALLP"));
    System.out.println(checkRecord("PPALLL"));
    System.out.println(checkRecord("LALL"));
    System.out.println(checkRecord("ALLAPPL"));
    System.out.println(checkRecord("LPLPLPLPLPL"));
  }
}
