package strings;

import java.util.HashMap;

public class BullsAndCows {

  public static void main(String[] args) {
    System.out.println(getHint("1123", "0111"));
  }

  public static String getHint(String secret, String guess) {
    int cows = 0;
    int bulls = 0;
    int numbers[]= new int[10];
    for (int i = 0; i<secret.length(); i++) {
      if (secret.charAt(i) == guess.charAt(i)) bulls++;
      else {
        if (numbers[secret.charAt(i)-'0']++ < 0) cows++;
        if (numbers[guess.charAt(i)-'0']-- > 0) cows++;
      }
    }

    return bulls + "A" + cows + "B";
  }

  public static String getHint2(String secret, String guess) {
    int bulls = 0;
    int cows = 0;
    HashMap<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < guess.length(); i++) {
      Character ch = guess.charAt(i);
      if (map.containsKey(ch)) {
        map.put(ch, map.get(ch) + 1);
      } else {
        map.put(ch, 1);
      }
    }

    for (int i = 0; i < secret.length(); i++) {
      if (secret.charAt(i) == guess.charAt(i)) {
        bulls++;
      }

      Character ch = secret.charAt(i);
      if (map.containsKey(ch)) {
        cows++;

        if (map.get(ch) > 1) {
          map.put(ch, map.get(ch) - 1);
        } else {
          map.remove(ch);
        }
      }
    }

    cows = cows - bulls;
    return bulls + "A" + cows + "B";
  }

}
