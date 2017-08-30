package graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class TopologicalSort {

	public static void main(String[] args) {
		Graph g = new Graph(7);

		g.edge(5, 2);
		g.edge(5, 4);
		g.edge(0, 6);
		g.edge(4, 3);
		g.edge(2, 3);
		g.edge(3, 1);

		g.topologicalSort();
	}
}

class Graph {
	private int V;
	private LinkedList<Integer> adj[];

	Graph(int v) {
		this.V = v;
		this.adj = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}

	void edge(int u, int v) {
		this.adj[u].add(v);
	}

	void topologicalSort() {
		Stack stack = new Stack();

		boolean visited[] = new boolean[V];

		for (int i = 0; i < visited.length; i++) {
			visited[i] = false;
		}

		for (int i = 0; i < V; i++) {
			if (!visited[i]) {
				topologicalSortUtil(visited, i, stack);
			}
		}

		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	}

	void topologicalSortUtil(boolean[] visited, int vertexIndx, Stack<Integer> stack) {

		visited[vertexIndx] = true;

		/*if (adj[vertexIndx].size() == 0) {
			return;
		}*/

		Iterator<Integer> itr = adj[vertexIndx].iterator();

		while (itr.hasNext()) {
			int idx = itr.next();
			if (!visited[idx])
				topologicalSortUtil(visited, idx, stack);
		}

		stack.push(new Integer(vertexIndx));
	}
}
