package recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class WordSquare {

  int N = 0;
  HashMap<String, List<String>> prefixHashTable = null;
  String[] words = null;

  public List<List<String>> wordSquares(String[] words) {
    this.words = words;
    this.N = words[0].length();

    List<List<String>> results = new ArrayList<List<String>>();
    this.buildPrefixHashTable(words);

    for (String word : words) {
      LinkedList<String> wordSquares = new LinkedList<>();
      wordSquares.addLast(word);
      this.backtracking(1, wordSquares, results);
    }
    return results;
  }


  public void backtracking(int step, LinkedList<String> wordSquares, List<List<String>> results) {
    if (step == N) {
      results.add((List<String>) wordSquares.clone());
      return;
    }

    StringBuilder prefix = new StringBuilder();
    for (String word : wordSquares) {
      prefix.append(word.charAt(step));
    }

    for (String candidate : this.getWordsFromPrefix(prefix.toString())) {
      wordSquares.addLast(candidate);
      backtracking(step + 1, wordSquares, results);
      wordSquares.removeLast();
    }
  }

  public List<String> getWordsFromPrefix(String prefix) {
    List<String> wordList = this.prefixHashTable.get(prefix);
    if (wordList == null) {
      return new ArrayList<>();
    } else {
      return wordList;
    }
  }

  public void buildPrefixHashTable(String[] words) {
    this.prefixHashTable = new HashMap<>();
    for (String word : words) {
      for (int i = 1; i < N; i++) {
        String prefix = word.substring(0, i);
        List<String> wordList = prefixHashTable.get(prefix);

        if (wordList == null) {
          wordList = new ArrayList<>();
          wordList.add(word);
          prefixHashTable.put(prefix, wordList);
        } else {
          wordList.add(word);
        }
      }
    }
  }
}
