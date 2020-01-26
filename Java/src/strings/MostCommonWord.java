package strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostCommonWord {

  // O(P+B)
  public String mostCommonWord(String paragraph, String[] banned) {
    paragraph += ".";

    Set<String> bannedWords = new HashSet<>(Arrays.asList(banned));

    Map<String, Integer> count = new HashMap<>();
    StringBuilder wordBuilder = new StringBuilder();

    String ansWord = "";
    int ansWordCount = 0;

    for (Character c : paragraph.toCharArray()) {
      if (Character.isLetter(c)) {
        wordBuilder.append(Character.toLowerCase(c));
      } else if (wordBuilder.length() > 0) {
        String word = wordBuilder.toString();
        if (!bannedWords.contains(word)) {
          count.put(word, count.getOrDefault(word, 0) + 1);

          if (count.get(word) > ansWordCount) {
            ansWordCount = count.get(word);
            ansWord = word;
          }
        }
        wordBuilder = new StringBuilder();
      }
    }

    return ansWord;
  }
}
