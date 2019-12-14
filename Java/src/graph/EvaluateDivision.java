package graph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvaluateDivision {

  class Node {
    String val;
    int state;
    Map<Node, Double> neighbors;

    public Node(String val) {
      this.val = val;
      this.state = 0;
      this.neighbors = new HashMap<>();
    }
  }

  public void resetGraph(Map<String, Node> nodeMap) {
    for (String node : nodeMap.keySet()) {
      nodeMap.get(node).state = 0;
    }
  }

  //https://www.youtube.com/watch?v=pfQoqxP-6DE
  public double[] calcEquation(
      List<List<String>> equations,
      double[] values,
      List<List<String>> queries
  ) {
    Map<String, Node> nodeMap = new HashMap<>();
    double[] answers = new double[queries.size()];
    buildGraph(equations, values, nodeMap);
    int i = 0;
    for (List<String> q : queries) {
      Node start = nodeMap.get(q.get(0));
      Node end = nodeMap.get(q.get(1));
      double ans = dfs(start, end, 1.0);
      answers[i] = ans;
      i++;
      resetGraph(nodeMap);
    }
    return answers;
  }

  public double dfs(Node start, Node end, double product) {
    if (start == null || end == null) {
      return -1;
    }

    if (start.val.equals(end.val)) {
      return product;
    }

    start.state = 1;

    for (Node n : start.neighbors.keySet()) {
      if (n.state == 0) {
        double candidate = dfs(n, end, product * start.neighbors.get(n));
        if (candidate != -1.0) {
          return candidate;
        }
      }
    }
    start.state = 2;
    return -1;
  }

  public void buildGraph(List<List<String>> equations, double[] values, Map<String, Node> nodeMap) {
    int i = 0;
    for (List<String> eq : equations) {
      String first = eq.get(0);
      String second = eq.get(1);

      if (nodeMap.get(first) == null) {
        nodeMap.put(first, new Node(first));
      }

      if (nodeMap.get(second) == null) {
        nodeMap.put(second, new Node(second));
      }

      nodeMap.get(first).neighbors.put(nodeMap.get(second), values[i]);
      nodeMap.get(second).neighbors.put(nodeMap.get(first), (double) 1 / values[i]);
      i++;
    }
  }
}
