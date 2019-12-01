package minimax;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


// https://leetcode.com/submissions/detail/282903506/
public class GuessTheWord {
  Random rand = new Random();

  int match(String a, String b) {
    int ans = 0;
    for (int i = 0; i < a.length(); i++) {
      if (a.charAt(i) == b.charAt(i)) {
        ans++;
      }

    }
    return ans;
  }

  String[] shrink(String[] wordlist, String guess, int matchSize) {
    List<String> words = new ArrayList<>();

    for (String word : wordlist) {
      int m = match(word, guess);
      if (m == matchSize) {
        words.add(word);
      }
    }

    return words.toArray(new String[words.size()]);
  }

  public void findSecretWord(String[] wordlist, Master master) {
    String target = wordlist[rand.nextInt(wordlist.length)];
    int count = 10;
    while (count-- > 0) {
      int matches = master.guess(target);
      wordlist = shrink(wordlist, target, matches);
      target = wordlist[rand.nextInt(wordlist.length)];
    }
  }

  class Master {
    public int guess(String word) {
      return new Random(6).ints(-1, 6).findFirst().getAsInt();
    }
  }
}

