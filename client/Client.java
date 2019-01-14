package client;

import java.util.LinkedList;
import org.omg.CORBA.IntHolder;

import bst.StudentBinarySearchTree;
import graph.AdjacencyMatrix;
import graph.DFS;
import towns.ShortestPath;

public class Client {
/**
 * This class contains a main method that tests other functions in the Graph project.
 */
	public static void main(String[] args) {
		//A sample adjacency matrix.
		AdjacencyMatrix matrix = new AdjacencyMatrix(12);
		matrix.addEdge(0, 1);
		matrix.addEdge(1, 2);
		matrix.addEdge(1, 3);
		matrix.addEdge(2, 4);
		matrix.addEdge(3, 5);
		matrix.addEdge(3, 6);
		matrix.addEdge(3, 7);
		matrix.addEdge(4, 5);
		matrix.addEdge(5, 8);
		matrix.addEdge(6, 9);
		matrix.addEdge(7, 7);
		matrix.addEdge(8, 9);
		matrix.addEdge(9, 10);
		matrix.addEdge(9, 11);
		
//		matrix.print(); //TEST CODE

		//We undertake and output a DFS traversal of the matrix.
		int[] traversal = DFS.traverse(0, matrix);

		System.out.print("The DFS traversal of the graph is: ");
		for (int index = 0; index < traversal.length; index++) {
			System.out.print(traversal[index] + " ");
		}
		System.out.println();
		
		//A sample binary search tree of student ages.
		StudentBinarySearchTree studentTree = new StudentBinarySearchTree(29, "Andrew");
		studentTree.insert(31, "Gabriel");
		studentTree.insert(28, "Alexis");
		studentTree.insert(30, "Tim");
		studentTree.insert(27, "Samuel");
		studentTree.insert(60, "Hun");
		studentTree.insert(35, "Johnny");
		studentTree.insert(26, "Kaitlin");
		studentTree.insert(36, "Christian");
		studentTree.insert(32, "Tim");
		studentTree.insert(37, "Tyler");
		studentTree.insert(33, "Min-Jung");
		studentTree.insert(34, "Jack");
		studentTree.insert(99, "Vahid");
		studentTree.insert(38, "Joseph");
		
		//We invoke the method to find the oldest student.
		studentTree.getMaximumAge(studentTree.getRoot());
		
		//A sample matrix of towns.
		AdjacencyMatrix townMap = new AdjacencyMatrix(24);
		townMap.addEdge(0, 1);
		townMap.addEdge(1, 2);
		townMap.addEdge(2, 4);
		townMap.addEdge(2, 5);
		townMap.addEdge(3, 5);
		townMap.addEdge(4, 7);
		townMap.addEdge(4, 8);
		townMap.addEdge(5, 6);
		townMap.addEdge(5, 9);
		townMap.addEdge(6, 14);
		townMap.addEdge(7, 10);
		townMap.addEdge(8, 9);
		townMap.addEdge(8, 11);
		townMap.addEdge(9, 12);
		townMap.addEdge(9, 13);
		townMap.addEdge(10, 11);
		townMap.addEdge(11, 12);
		townMap.addEdge(11, 17);
		townMap.addEdge(12, 13);
		townMap.addEdge(12, 18);
		townMap.addEdge(13, 14);
		townMap.addEdge(13, 19);
		townMap.addEdge(14, 15);
		townMap.addEdge(14, 16);
		townMap.addEdge(16, 20);
		townMap.addEdge(17, 18);
		townMap.addEdge(17, 21);
		townMap.addEdge(18, 19);
		townMap.addEdge(18, 22);
		townMap.addEdge(19, 20);
		townMap.addEdge(19, 23);
		townMap.addEdge(22, 23);
		
		//We find the shortest path between two towns and output this path.
		IntHolder distancePtr = new IntHolder();
		LinkedList<Integer> townsOnRoute = ShortestPath.find(townMap, 0, 23, distancePtr);

		System.out.print("The shortest path is: ");
		for (int index = 0; index < townsOnRoute.size(); index++) {
			System.out.print(townsOnRoute.get(index) + " ");
		}
		System.out.println();
		System.out.println("The distance is: " + distancePtr.value);
	}

}
