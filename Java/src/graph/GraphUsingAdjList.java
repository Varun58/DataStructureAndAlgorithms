package graph;

import java.util.ArrayList;
import java.util.LinkedList;

public class GraphUsingAdjList {

	private ArrayList<Integer> vertices;
	private LinkedList<Integer>[] edges;
	private int verticesCount = 0;

	public GraphUsingAdjList(int count) {
		this.vertices = new ArrayList<>(count);
		this.verticesCount = count;
		this.edges = new LinkedList[count];
		for (int i = 0; i < verticesCount; i++) {
			vertices.add(i);
			edges[i] = new LinkedList<Integer>();
		}
	}

	public void addEdge(int src, int dest) {
		int i = vertices.indexOf(src);
		int j = vertices.indexOf(dest);
		
		if(i!=-1 && j!=-1) {
			edges[i].addFirst(dest);
			edges[j].addFirst(src);
		}
	}

}
