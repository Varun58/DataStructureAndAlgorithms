package strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SentenceSimilarity {

  public static void main(String[] args) {
    List<List<String>>  pairs = new ArrayList<>();
    pairs.add(Arrays.asList("great", "fine"));
    pairs.add(Arrays.asList("acting", "drama"));
    pairs.add(Arrays.asList("skills", "talent"));

    System.out.println(areSentencesSimilar(
        new String[]{"great", "acting", "skills"},
        new String[]{"fine", "drama", "talent"},
        pairs
    ));

  }

  public static boolean areSentencesSimilar(
      String[] words1,
      String[] words2,
      List<List<String>> pairs
  ) {
    if (words1.length != words2.length) {
      return false;
    }

    Set<String> set = new HashSet<>();
    for (int i = 0; i < pairs.size(); i++) {
      set.add(pairs.get(i).get(0) + "#" +pairs.get(i).get(1));
    }

    for (int i = 0; i < words1.length; i++) {
      if(!words1[i].equals(words2[i]) && !set.contains(words1[i] +"#"+words2[i]) &&
          !set.contains(words2[i] +"#"+words1[i])) {
        return false;
      }
    }

    return true;
  }

  // This is an extension of the above problem
  // where the pairs are transitive and has to be solved using dfs
  // https://leetcode.com/problems/sentence-similarity/discuss/109633/Java-Super-Clean-Code-(Similarity-I-and-II)
  public static boolean areSentencesSimilarTwo(
      String[] words1,
      String[] words2,
      List<List<String>> pairs
  ){
    if (words1.length != words2.length) {
      return false;
    }

    Map<String, Set<String>> map = new HashMap<>();
    for(List<String> p : pairs) {
       map.putIfAbsent(p.get(0), new HashSet<>());
      map.putIfAbsent(p.get(1), new HashSet<>());
      map.get(p.get(0)).add(p.get(1));
      map.get(p.get(1)).add(p.get(0));
    }

    for (int i = 0; i < words1.length; i++) {
      if(words1[i].equals(words2[i])) {
        continue;
      }

      if(!map.containsKey(words1[i])){
        return false;
      }

      if(!dfs(map, words1[i], words2[i], new HashSet<>())){
        return false;
      }
    }
    

    return true;
  }

  public static boolean dfs(Map<String, Set<String>> map, String source, String target,Set<String> visited) {
    if(map.get(source).contains(target)) {
      return true;
    }

    if(visited.add(source)) {
      for(String next: map.get(source)) {
        if(!visited.contains(next) && dfs(map, next, target, visited)) {
          return true;
        }
      }
    }

    return false;
  }
}
