package strings;

import java.util.Arrays;

public class SmallerByFrequency {

  public static void main(String[] args) {
    String queries[] = {"bbb", "cc"};
    String words[] = {"a", "aa", "aaa", "aaaa"};

    for (Integer result : numSmallerByFrequency(queries, words)) {
      System.out.println(result);
    }
  }

  // n + nO(logn) + O(logn) solution using sort and binary search
  public static int[] numSmallerByFrequency(String[] queries, String[] words) {
    int[] q = new int[queries.length];
    int[] w = new int[words.length];

    for (int i = 0; i < q.length; i++) {
      q[i] = smallestCharFreq(queries[i]);
    }

    for (int i = 0; i < w.length; i++) {
      w[i] = smallestCharFreq(words[i]);
    }

    Arrays.sort(w);
    int answer[] = new int[q.length];

    for (int i = 0; i < q.length; i++) {
      int l = 0;
      int r = w.length - 1;
      while (l <= r) {
        int mid = l + ((r - l) / 2);

        if (w[mid] <= q[i]) {
          l = mid + 1;
        } else {
          r = mid - 1;
        }
      }

      answer[i] = w.length - l;
    }

    return answer;
  }

  // m * n solution
  public static int[] numSmallerByFrequency2(String[] queries, String[] words) {
    int answer[] = new int[queries.length];
    for (int i = 0; i < queries.length; i++) {
      for (int j = 0; j < words.length; j++) {
        if (smallestCharFreq(queries[i]) < smallestCharFreq(words[j])) {
          answer[i]++;
        }
      }
    }
    return answer;
  }

  public static int smallestCharFreq(String word) {
    int freq = 0;
    int smallestCh = word.charAt(0);

    for (int i = 0; i < word.length(); i++) {
      if (word.charAt(i) == smallestCh) {
        freq++;
      } else if (word.charAt(i) < smallestCh) {
        smallestCh = word.charAt(i);
        freq = 1;
      }
    }

    return freq;
  }
}
