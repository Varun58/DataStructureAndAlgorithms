package graph;

public class GraphUsingAdjMatrix {

	private boolean[][] adjMatrix;
	private int verticesCount;

	public GraphUsingAdjMatrix(int verticesCount) {
		this.verticesCount = verticesCount;
		this.adjMatrix = new boolean[verticesCount][verticesCount];
	}

	public void addEdge(int i, int j) {
		if (i < verticesCount && i > 0 && j < verticesCount && j > 0) {
			this.adjMatrix[i][j] = true;
			this.adjMatrix[j][i] = true;
		}
	}

	public void removeEdge(int i, int j) {
		if (i < verticesCount && i > 0 && j < verticesCount && j > 0) {
			this.adjMatrix[i][j] = false;
			this.adjMatrix[j][i] = false;
		}
	}

	public boolean isEdge(int i, int j) {
		if (i < verticesCount && i > 0 && j < verticesCount && j > 0) {
			return adjMatrix[i][j];
		} else {
			return false;
		}
	}

}
