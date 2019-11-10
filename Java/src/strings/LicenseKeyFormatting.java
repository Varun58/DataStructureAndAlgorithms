package strings;

public class LicenseKeyFormatting {

  public static void main(String[] args) {
    System.out.println(licenseKeyFormatting("5F3Z-2e-9-w", 4));
    System.out.println(licenseKeyFormatting("--a-a-a-a--", 2));
  }

  public static String licenseKeyFormatting(String S, int K) {
    StringBuilder sb = new StringBuilder();
    int count = 0;
    for (int i = S.length() - 1; i >= 0; i--) {
      if (S.charAt(i) == '-') {
        continue;
      }

      if (count >= K) {
        sb.append('-');
        sb.append(S.charAt(i));
        count = 1;
      } else {
        sb.append(S.charAt(i));
        count++;
      }
    }

    return sb.reverse().toString().toUpperCase();
  }
}
