package towns;

import java.util.LinkedList;
import org.omg.CORBA.IntHolder;

import graph.AdjacencyMatrix;

public class ShortestPath {
/**
 * This class finds the shortest path between two points on an AdjacencyMatrix.
 * The worst case complexity of this algorithm, ignoring all constants, is O(n(n-1)!)
 * An explanation about how this complexity was calculated can be found at the bottom of the READ ME.txt file in 
 * the Algorithms project directory.
 */
	public static LinkedList<Integer> find(AdjacencyMatrix matrix, int origin, int destination, IntHolder distancePtr) {
	/**
	 * @param matrix - The AdjacancyMatrix to be searched.
	 * @param origin - The unique id of the starting point.
	 * @param destination - The unique id of the destination.
	 * @param distancePtr - A pointer to the variable that will be used as a return value recording the shortest distance.
	 */
		boolean[][] graph = matrix.getGraph(); //We get the adjacency list.
		LinkedList<Integer> townsOnRoute = new LinkedList<Integer>(); //This will be used to record the nodes on route to the destination.
		LinkedList<Integer> shortestPath = find (graph, origin, destination, townsOnRoute);
		//This method is not called by the user as I need to ensure that the linked list passed to it is blank.
		distancePtr.value = shortestPath.size() - 1; //The number of edges traversed is equal to the number of nodes - 1.
		return shortestPath;
	}
	
	public static LinkedList<Integer> find(boolean[][] graph, int location, int destination, LinkedList<Integer> townsOnRoute) {
	/**
	 * This is a recursive method using a Depth search. The method continually calls itself as it moves from node to node.
	 * Upon finding the destination node, it passes the path to that node back to the previous method.  That method compares all
	 * returned paths and determines which is shortest before passing this back again.  When all valid paths have been assessed
	 * in this way, the shortest path will have been determined. 
	 * 
	 * @param graph - The adjacency list.
	 * @param location - Our current node in the graph.
	 * @param destination - The node we are going to.
	 * @param townsOnRoute - A list of every node we have passed to arrive at the current one.
	 */
		LinkedList<Integer> placesToGo = new LinkedList<Integer>(); //Used to record every node we can go to from the current point.
		
		townsOnRoute.add(location); //Add the current location to the list of nodes visited.
		if (location == destination) return townsOnRoute; //If we are at our destination, there's no need to continue searching for it!
		
		for (int index = 0; index < graph[location].length; index++) { //For every node in the graph:
			if (graph[location][index] && !townsOnRoute.contains(index)) //If there is a connection from our current node AND if we have NOT been there before,
				placesToGo.add(index); //Add the node to the places we can go.
		}
		
		if (placesToGo.isEmpty()) return new LinkedList<Integer>(); //An empty array denotes an invalid path.
		
		LinkedList<Integer> shortestPath = new LinkedList<Integer>(); //Used to record the shortest path.
		LinkedList<Integer> temp; //Used to store several LinkedLists.
		for (int index = 0; index < placesToGo.size(); index++) { //For every place we can go:
			//We get the shortest path from that place.
			temp = find(graph, placesToGo.get(index), destination, (LinkedList<Integer>)townsOnRoute.clone());
			if (!temp.isEmpty()) //We ignore invalid paths.
				if (temp.size() < shortestPath.size() || shortestPath.isEmpty()) //If the new path is the shortest so far (or if its our first time through the loop).
					shortestPath = temp; //Note the shortest path.
		}
		
		return shortestPath; //Return the shortest path.
	}

}
