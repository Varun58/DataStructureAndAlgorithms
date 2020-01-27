package graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {

  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    Set<String> wordSet = new HashSet<>(wordList);
    Queue<String> queue = new LinkedList<>();
    if (!wordSet.contains(endWord)) {
      return 0;
    }

    int len = 1;
    queue.offer(beginWord);
    while (!queue.isEmpty()) {
      int count = queue.size();

      for (int k = 0; k < count; k++) {
        String originalWord = queue.poll();
        char[] strChars = originalWord.toCharArray();

        for (int j = 0; j < strChars.length; j++) {
          for (char ch = 'a'; ch <= 'z'; ch++) {
            char chOld = strChars[j];
            if (chOld == ch) {
              continue;
            }

            strChars[j] = ch;
            String newWord = String.valueOf(strChars);
            if (endWord.equals(newWord)) {
              return len + 1;
            }

            if (!originalWord.equals(newWord) && wordSet.contains(newWord)) {
              queue.offer(newWord);
              wordSet.remove(newWord);
            }

            strChars[j] = chOld;
          }
        }
      }

      len++;
    }
    return 0;
  }
}
