package strings;

import java.util.ArrayList;
import java.util.List;

public class ExpressiveWords {

  public int expressiveWords(String S, String[] words) {
    REL R = new REL(S);

    int ans = 0;
    search:
    for (String word : words) {
      REL R2 = new REL(word);

      if (!R.key.equals(R2.key)) {
        continue;
      }

      for (int i = 0; i < R.counts.size(); i++) {
        int c1 = R.counts.get(i);
        int c2 = R2.counts.get(i);

        if ((c1 < 3 && c1 != c2) || c1 < c2) {
          continue search;
        }
      }

      ans++;
    }
    return ans;
  }

  class REL {
    String key;
    List<Integer> counts;

    public REL(String word) {
      int N = word.length();
      counts = new ArrayList<>();
      int prev = -1;
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < N; i++) {
        if (i == N - 1 || word.charAt(i) != word.charAt(i + 1)) {
          sb.append(word.charAt(i));
          counts.add(i - prev);
          prev = i;
        }
      }

      key = sb.toString();
    }
  }
}
