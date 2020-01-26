package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
  public static void main(String[] args) {
    new CourseSchedule().canFinish2(2, new int[][] {{1, 0}});
  }

  // Topological sort using indegree

  // BFS
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    HashMap<Integer, List<Integer>> map = new HashMap<>();
    int[] indegree = new int[numCourses];

    int count = numCourses;

    Queue<Integer> q = new LinkedList<>();

    for (int i = 0; i < numCourses; i++) {
      map.put(i, new ArrayList<Integer>());
    }

    for (int i = 0; i < prerequisites.length; i++) {
      map.get(prerequisites[i][0]).add(prerequisites[i][1]);
      indegree[prerequisites[i][1]]++;
    }

    for (int i = 0; i < numCourses; i++) {
      if (indegree[i] == 0) {
        q.offer(i);
      }
    }

    while (!q.isEmpty()) {
      int curr = q.poll();
      for (int val : map.get(curr)) {
        if (--indegree[val] == 0) {
          q.offer(val);
        }
      }

      count--;
    }

    return count == 0;
  }

  // Topological sort and check if no cycle
  // DFS
  public boolean canFinish2(int numCourses, int[][] prerequisites) {
    ArrayList<Integer>[] graph = new ArrayList[numCourses];
    for (int i = 0; i < numCourses; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int i = 0; i < prerequisites.length; i++) {
      graph[prerequisites[i][1]].add(prerequisites[i][0]);
    }

    boolean[] visited = new boolean[numCourses];


    for (int i = 0; i < numCourses; i++) {
      if (!DFS(graph, visited, i)) {
        return false;
      }
    }
    return true;
  }

  public boolean DFS(ArrayList<Integer>[] graph, boolean[] visited, int course) {
    if (visited[course]) {
      return false;
    }

    visited[course] = true;

    for (int i = 0; i < graph[course].size(); i++) {
      if (!DFS(graph, visited, graph[course].get(i))) {
        return false;
      }
    }
    visited[course] = false;
    return true;
  }
}
