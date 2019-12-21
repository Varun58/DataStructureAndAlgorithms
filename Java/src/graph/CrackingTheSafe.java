package graph;

import java.util.HashSet;
import java.util.Set;

public class CrackingTheSafe {

  public static void main(String[] args) {
    System.out.println(new CrackingTheSafe().crackSafe(2, 2));
  }

  // https://leetcode.com/explore/interview/card/google/61/trees-and-graphs/3075/discuss/381122/Can-someone-explain-the-damn-question-please
  // https://leetcode.com/explore/interview/card/google/61/trees-and-graphs/3075

  Set<String> seen  = null;
  StringBuilder ans = null;
  public String crackSafe(int n, int k) {
    if(n == 1 && k ==1 ) {
      return "0";
    }

    seen = new HashSet<>();
    ans = new StringBuilder();

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n-1; i++) {
      sb.append("0");
    }

    String start = sb.toString();
    dfs(start, k);
    ans.append(start);
    return new String(ans);
  }

  public void dfs(String node, int k) {
    for (int i = 0; i < k; i++) {
         String next = node + i;
         if(!seen.contains(next)) {
            seen.add(next);
            dfs(next.substring(1), k);
            ans.append(i);
         }
    }
  }
}
