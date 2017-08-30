package graph.djkstra2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {


	static List<Vertex> vertices;
	static List<Edge> edges;
	
	public static void main(String[] args) {


		vertices = new ArrayList<Vertex>();
		edges = new ArrayList<Edge>();
		for (int i = 0; i < 11; i++) {
			Vertex location = new Vertex("Node_" + i, "Node_" + i);
			vertices.add(location);
		}

		addEdge("Edge_0", 0, 1, 85);
		addEdge("Edge_1", 0, 2, 217);
		addEdge("Edge_2", 0, 4, 173);
		addEdge("Edge_3", 2, 6, 186);
		addEdge("Edge_4", 2, 7, 103);
		addEdge("Edge_5", 3, 7, 183);
		addEdge("Edge_6", 5, 8, 250);
		addEdge("Edge_7", 8, 9, 84);
		addEdge("Edge_8", 7, 9, 167);
		addEdge("Edge_9", 4, 9, 502);
		addEdge("Edge_10", 9, 10, 40);
		addEdge("Edge_11", 1, 10, 600);

		// Lets check from location Loc_1 to Loc_10
		Graph graph = new Graph(vertices, edges);
		DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);
		dijkstra.execute(vertices.get(0));
		LinkedList<Vertex> path = dijkstra.getPath(vertices.get(10));

		for (Vertex vertex : path) {
			System.out.println(vertex);
		}

	}

	private static void addEdge(String edgeId, int sourceVertexId, int destVertexId, int distance) {
		Edge lane = new Edge(edgeId, vertices.get(sourceVertexId), vertices.get(destVertexId), distance);
		edges.add(lane);
	}

}
