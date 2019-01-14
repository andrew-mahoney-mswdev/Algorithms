package graph;

import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JOptionPane;

public class DFS {
/** 
 * This class performs a depth first traversal of an adjacency matrix. 
 */
	public static int[] traverse(int sourceNode, AdjacencyMatrix matrix) {
		ArrayList<Integer> traversal = new ArrayList<Integer>(); //Records the order in which nodes were visited.  This must be an ArrayList as we don't know how many nodes will be visited.
		boolean[][] graph = matrix.getGraph(); //Stores the adjacency matrix of the graph.
		boolean[] alreadyStacked = new boolean[graph.length];
		//The array records whether a node HAS ALREADY BEEN on the stack, regardless of whether the node is currently on the stack.
		Stack<Integer> stack = new Stack<Integer>(); //The stack object used from traversing.

		if (sourceNode < 0 || sourceNode > graph.length) { //If the index is invalid.
			int[] traversalArray = new int[0];
			return traversalArray; //Return a blank array.
		};

		stack.add(sourceNode); //The source node is added to the stack.
		alreadyStacked[sourceNode] = true; //We note that the source node has been on the stack. 
		
		while (!stack.isEmpty()) { //Continue traversing until the stack is empty.
			int currentNode = stack.pop(); //Remove the oldest item from the stack.
			traversal.add(currentNode); //We note that we have visited this node.
//			System.out.println(currentNode); //TEST CODE
			
			for (int index = 0; index < graph[currentNode].length; index++) {
				//For every potential edge on the node.
				if (graph[currentNode][index] && !alreadyStacked[index]) {
					//If there is a link to that node AND if that node has not already been on the stack:
					stack.add(index); //Add the unstacked index to the stack.
					alreadyStacked[index] = true; //Note that this item has been on the stack.
				}
			}
//			System.out.println(stack); //TEST CODE
//			JOptionPane.showMessageDialog(null, "STOP"); //TEST CODE
		}
				
		//We convert from ArrayList<Integer> to int[] so that the return type is compatible with assertArrayEquals().
		//I do not use toArray() as this returns an array of type Object, and the assert method requires primitive types.
		int[] traversalArray = new int[traversal.size()];
		for (int index = 0; index < traversal.size(); index++) {
			traversalArray[index] = traversal.get(index);
		}
		return traversalArray;
	}
}
