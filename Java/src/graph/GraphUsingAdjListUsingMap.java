package graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GraphUsingAdjListUsingMap {

	private Map<Integer, List<Integer>> adjacencyList;

	public GraphUsingAdjListUsingMap(int verticesCount) {
		adjacencyList = new HashMap<Integer, List<Integer>>();
		for (int i = 1; i <= verticesCount; i++) {
			adjacencyList.put(i, new LinkedList<Integer>());
		}
	}

	public void setEdge(int src, int dest) {
		if (src > adjacencyList.size() || dest > adjacencyList.size()) {
			return;
		}

		adjacencyList.get(src).add(dest);
		adjacencyList.get(dest).add(src);
	}
	
	public List<Integer> getEdge(int src){
		if(src>adjacencyList.size()) {
			return null;
		}
		return adjacencyList.get(src);
	}
	
	public void printList() {
		/* Prints the adjacency List representing the graph.*/
        System.out.println ("the given Adjacency List for the graph \n");
        for (int i = 1 ; i <= adjacencyList.size() ; i++)
        {
            System.out.print(i+"->");
            List<Integer> edgeList = getEdge(i);
            for (int j = 1 ; ; j++ )
            {
                if (j != edgeList.size())
                {
                    System.out.print(edgeList.get(j - 1 )+"->");
                }else
                {
                    System.out.print(edgeList.get(j - 1 ));
                    break;
                }						 
            }
            System.out.println();					
         }
	}
}
