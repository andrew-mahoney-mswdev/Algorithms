package test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import graph.AdjacencyMatrix;
import graph.DFS;

@RunWith(value = Parameterized.class)
public class ParameterisedTest {
//This class tests the DFS traversal a graphs.
	
	@Parameter(value = 0)
	public int source; //The source value at which the traversal will start. 

	@Parameter(value = 1)
	public AdjacencyMatrix matrix; //The matrix that will be traversed.
	
	@Parameter(value = 2)
	public int[] expected; //The expected sequence in which nodes should be traversed.
	
	@Parameters
	public static Collection<Object[]> data() {
	//This method defines three different adjacency matrices for testing.

		//The connections of the first graph are:
		AdjacencyMatrix matrixA = new AdjacencyMatrix(13);
		matrixA.addEdge(0, 1);
		matrixA.addEdge(1, 2);
		matrixA.addEdge(1, 3);
		matrixA.addEdge(2, 4);
		matrixA.addEdge(3, 5);
		matrixA.addEdge(3, 6);
		matrixA.addEdge(3, 7);
		matrixA.addEdge(4, 5);
		matrixA.addEdge(5, 8);
		matrixA.addEdge(6, 9);
		matrixA.addEdge(7, 7);
		matrixA.addEdge(8, 9);
		matrixA.addEdge(9, 10);
		matrixA.addEdge(9, 11);
		
		//The connections of the second graph are:
		AdjacencyMatrix matrixB = new AdjacencyMatrix(11);
		matrixB.addEdge(0, 1);
		matrixB.addEdge(1, 2);
		matrixB.addEdge(2, 3);
		matrixB.addEdge(2, 4);
		matrixB.addEdge(3, 5);
		matrixB.addEdge(3, 6);
		matrixB.addEdge(4, 6);
		matrixB.addEdge(6, 7);
		matrixB.addEdge(6, 8);
		matrixB.addEdge(7, 9);
		matrixB.addEdge(8, 9);
		matrixB.addEdge(8, 10);
		
		//An empty matrix is defined:
		AdjacencyMatrix emptyMatrix = new AdjacencyMatrix(10);
		
		//Three test cases are defined for the first two graphs, followed by four special test cases.
		Object[][] data = new Object [][] { { 0, matrixA, new int[]{0, 1, 3, 7, 6, 9, 11, 10, 8, 5, 4, 2} }, //Test traversing from the beginning of the graph.
											{ 10, matrixA, new int[]{10, 9, 11, 8, 5, 4, 2, 1, 0, 3, 7, 6} }, //Test from the other end of the graph
											{ 3, matrixA, new int[]{3, 7, 6, 9, 11, 10, 8, 5, 4, 2, 1, 0} }, //Test from the middle
											
											//These test cases are applied to the second graph.
											{ 0, matrixB, new int[]{0, 1, 2, 4, 6, 8, 10, 9, 7, 3, 5} }, //Test traversing from the beginning
											{ 9, matrixB, new int[]{9, 8, 10, 6, 4, 2, 1, 0, 3, 5, 7} }, //Test from the other end
											{ 6, matrixB, new int[]{6, 8, 10, 9, 7, 4, 2, 1, 0, 3, 5} }, //Test form the middle
											
											//These test cases assess the effect of erroneous input.
											{ 12, matrixA, new int[]{12} }, //Tests the effect of a source node with no connections.
											{ -1, matrixA, new int[]{} }, //Tests the effect of an invalid source node.
											{ 100, matrixB, new int[]{} }, //Tests the effect of a source node that's out of bounds.
											{ 0, emptyMatrix, new int[]{0} } }; //Tests the effect of an empty matrix. 
		
		return Arrays.asList(data);
	}

	@Test
	public void parameterisedTestOfArrayCombine() { //Test function
		assertArrayEquals(DFS.traverse(source, matrix), expected);
	}
	
}
