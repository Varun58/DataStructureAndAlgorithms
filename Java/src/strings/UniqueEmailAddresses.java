package strings;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {

  public static void main(String[] args) {
    String emails[] = {"a@leetcode.com", "b@leetcode.com", "c@leetcode.com"};
    System.out.println(numUniqueEmails2(emails));
  }

  // Sol 1 Does not work bcs of the replaceAll for .
  public static int numUniqueEmails(String[] emails) {
    Set<String> seen = new HashSet();
    for (String email: emails) {
      int i = email.indexOf('@');
      String local = email.substring(0, i);
      String rest = email.substring(i);
      if (local.contains("+")) {
        local = local.substring(0, local.indexOf('+'));
      }
      local = local.replaceAll(".", "");
      seen.add(local + rest);
    }

    return seen.size();
  }

  // Sol 2
  public static int numUniqueEmails2(String[] emails) {
    Set<String> hset = new HashSet<>();
    for (int i = 0; i < emails.length; i++) {
      String sanitizedEmail = sanitize(emails[i]);
      System.out.println(sanitizedEmail);
      hset.add(sanitizedEmail);
    }

    return hset.size();
  }

  private static String sanitize(String s) {
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '.') {
        continue;
      }

      if (s.charAt(i) == '+') {
        break;
      }

      if (s.charAt(i) == '@') {
        break;
      }

      sb.append(s.charAt(i));
    }
    return sb.append(s.substring(s.indexOf('@'))).toString().toLowerCase();
  }
}
