package graph;

public class AdjacencyMatrix {
/**
 * Records all connections between nodes in a graph.
 */
	private boolean[][] graph;
	
	public AdjacencyMatrix(int size) {
		//Connections are stored in a 2-dimensional array of booleans.
		//The array value [x][y] is set to true if x is connected to y.
		graph = new boolean[size][size];
	}
	
	public boolean[][] getGraph() {return graph;}
	
	public void addEdge(int node, int neighbour) {
		//Adds a non-directional edge between two nodes.
		graph[node][neighbour] = true;
		graph[neighbour][node] = true;
	}
	
	public void print() {
		for (int i = 0; i < graph.length; i++) {
			System.out.print(i + ": ");
			for (int j = 0; j < graph[0].length; j++) {
				if (graph[i][j]) System.out.print("1 ");
				else System.out.print("0 ");
			}
			System.out.println();
		}
	}
	
}
