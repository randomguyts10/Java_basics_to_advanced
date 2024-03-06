package Graphs;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Graph {
	
	

// DFT for disconnected graphs
	
	public static void dfTraversalDisconnected(int[][] adjMatrix)
	{
		boolean[] visited = new boolean[adjMatrix.length];
		for (int i = 0; i < adjMatrix.length; i++) {
			if (!visited[i]) {
				dfTraversalDisconnected(adjMatrix, i, visited);
				System.out.println();
			}
			
		}
		
	}
	
	public static void dfTraversalDisconnected(int[][] adjMatrix, int currentVertex, boolean[] visited)
	{
		visited[currentVertex] = true;
		System.out.print(currentVertex + " ");
		for (int i = 0; i < visited.length; i++) {
			if (adjMatrix[currentVertex][i] == 1 && visited[i] == false) {
				dfTraversalDisconnected(adjMatrix, i, visited);
			}
		}

	}

	
	// BFT for disconnected graphs
	
		public static void bfTraversalDisconnected(int[][] adjMatrix, boolean visited[], int currentVertex)
		{
			Queue<Integer> pendingVertices = new LinkedList<Integer>();

			visited[currentVertex] = true;
			pendingVertices.add(currentVertex);
			
			while (!pendingVertices.isEmpty()) {
				currentVertex = pendingVertices.poll();
				System.out.print(currentVertex + " ");
				for (int i = 0; i < adjMatrix.length; i++) {
					if (adjMatrix[currentVertex][i] == 1 && visited[i] == false) {
						// i is unvisited vertex of current Vertex
						pendingVertices.add(i);
						visited[i] = true;
					}
				}
			}
			
		}
		
		public static void bfTraversalDisconnected(int[][] adjMatrix)
		{
			boolean visited[] = new boolean[adjMatrix.length];
			
			for (int i = 0; i < adjMatrix.length; i++) {
					if (!visited[i]) {
						
						bfTraversalDisconnected(adjMatrix, visited, i);
						System.out.println();
					}
				}
		}
			
//		}		
	
		
		public static boolean bfsHasPath(int[][] adjMatrix, int v1, int v2)
		{
			if (adjMatrix[v1][v2] == 1) {
				return true;
			}
			Queue<Integer> q = new LinkedList<Integer>();

			boolean visited[] = new boolean[adjMatrix.length];
			visited[v1] = true;
			q.add(v1);
			
			while (!q.isEmpty()) {
				int x = q.poll();
				for (int i = 0; i < adjMatrix.length; i++) {
					if (adjMatrix[x][i] == 1 && visited[i] == false) {
						// i is unvisited vertex of current Vertex
						q.add(i);
						visited[i] = true;
					}
				}
			}
			
			if (visited[v2] == true) {
				return true;
			} else {
				return false;
			}
			
		}
		
		public static boolean dfsHasPath(int[][] adjMatrix, int v1, int v2)
		{
			if (adjMatrix[v1][v2] == 1) {
				return true;
			}
			boolean[] visited = new boolean[adjMatrix.length];
			
			return dfsHasPath(adjMatrix, v1, v2, visited);

			
		}
		
		public static boolean dfsHasPath(int[][] adjMatrix, int v1, int v2, boolean[] visited)
		{
			if (adjMatrix[v1][v2] == 1) {
				return true;
			}
			visited[v1] = true;

			for (int i = 0; i < visited.length; i++) {
				if (adjMatrix[v1][i] == 1 && visited[i] == false) {
					boolean out =  dfsHasPath(adjMatrix, i, v2, visited);
					if (!out) {
						continue; 
					} else {
						return out;
					}
				}
			}
			return false;

		}		

		
		public static ArrayList<Integer> dfsGetPath(int[][] adjMatrix, int v1, int v2)
		{

			boolean[] visited = new boolean[adjMatrix.length];
			
			return dfsGetPath(adjMatrix, v1, v2, visited);

			
		}
		
		public static ArrayList<Integer> dfsGetPath(int[][] adjMatrix, int v1, int v2, boolean[] visited)
		{
			if (v1 == v2) {
				ArrayList<Integer> ans = new ArrayList<Integer>();
				visited[v1] = true;
				ans.add(v1);
				return ans;
			}
			visited[v1] = true;

			for (int i = 0; i < visited.length; i++) {
				if (adjMatrix[v1][i] == 1 && visited[i] == false) {
					ArrayList<Integer> out =  dfsGetPath(adjMatrix, i, v2, visited);
					if (out != null) {
						out.add(v1);
						return out;
					}
				}
			}
			return null;

		}		
		
		
		public static ArrayList<Integer> bfsGetPath(int[][] adjMatrix, int v1, int v2)
		{
			
			boolean[] visited = new boolean[adjMatrix.length];
			Queue<Integer> pendingVertices = new LinkedList<Integer>();
			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
			pendingVertices.add(v1);
			visited[v1] = true;
			map.put(v1, -1);
			boolean pathFound = false;
			while (!pendingVertices.isEmpty()) {
				int currentVertex = pendingVertices.poll();
				for (int i = 0; i < adjMatrix.length; i++) {
					
					if (adjMatrix[currentVertex][i] == 1 && visited[i] == false) {
						pendingVertices.add(i);
						visited[i] = true;
						map.put(i, currentVertex);
						if (i == v2) {
							// Path Found
							pathFound = true;
							break;
						}
						
					}
				}
			}
			
			if (pathFound) {
				ArrayList<Integer> path = new ArrayList<Integer>();
				int currentVertex = v2;
				while (currentVertex != -1) {
					path.add(currentVertex);
					int parent = map.get(currentVertex);
					currentVertex = parent;
				}
				
				return path;
			} else {
				return null;
			}

		}				

		
		
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int e = sc.nextInt();
		int adjMatrix[][] = new int[n][n];
		
		for (int i = 0; i < e; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			adjMatrix[v1][v2] = 1;
			adjMatrix[v2][v1] = 1;
		}
		
//		for (int i = 0; i < adjMatrix.length; i++) {
//			for (int j = 0; j < adjMatrix[i].length; j++) {
//				System.out.print(adjMatrix[i][j] + " ");
//			}
//			System.out.println();
//		}
		
//		System.out.println("DFT Path:");
//		dfTraversalDisconnected(adjMatrix);
//
//		System.out.println("BFT Path:");
//		bfTraversalDisconnected(adjMatrix);
		
		int v1 = 1;
		int v2 = 5;
				
		
//		System.out.println(bfsHasPath(adjMatrix, v1, v2));
//		System.out.println(dfsHasPath(adjMatrix, v1, v2));		

		ArrayList<Integer> out = dfsGetPath(adjMatrix, v1, v2);
		for (Integer i : out) {
			System.out.print(i + " ");
		}

		ArrayList<Integer> out2 = bfsGetPath(adjMatrix, v1, v2);
		for (Integer i : out2) {
			System.out.print(i + " ");
		}
	
	}
}
