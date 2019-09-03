package FindParentVertex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class FindParentVertex {
    private int numVertex;
    private LinkedList<Integer> adjacencyList[];
    
	public FindParentVertex (int numVertex) {
		this.numVertex = numVertex;
		this.adjacencyList = new LinkedList[numVertex];
		for (int i=0;i<numVertex;i++) {
			this.adjacencyList[i] = new LinkedList<>();
		}
	}
	public void addEdge (int u, int v) {
		adjacencyList[u].add(v);
	}
	public void dfs (int start, int end, boolean visited[][]) {
		// Mark as true for the first time. i x i & other combination. 
		visited[start][end] = true;
		// Since we are using adjacency list and dfs here, we need to use end adjacency list. 
		for (int adj:adjacencyList[end]) {
			if (visited[start][adj] == false) {
				dfs(start, adj, visited);
			}
		}
		return;
	}
	public void searchMotherVertex() {
		boolean visited[][] = new boolean[numVertex][numVertex];
		int count = 0;
		// Initialize the visit array and since it's directional here uses two dimension array.
		for (int i=0;i<numVertex;i++) {
			for (int j=0;j<numVertex;j++) {
				visited[i][j]= false;
			}				
		}
		for (int i=0;i<numVertex;i++) {
			dfs (i, i, visited);		
		}
		// If all true for a given list then it is a mother vertex. 
		for (int i=0;i<numVertex;i++) {
			int num = 0;
			for (int j=0;j<numVertex;j++) {
				if (visited[i][j] == true) {
					num ++;
				}
			}
			if (num == numVertex) {
				System.out.println(i);
				count ++;
			}
		}
		if (count == 0) {
			System.out.println("Didn't find mother vertex!");
		}
		return;
	}
	/*
	public boolean dfs (int start, boolean visited[][], HashSet<Integer> path) {
		if (path.size() == numVertex) {
			return true;
		}
		for (int i=0;i<adjacencyList[start].size();i++) {
			if (visited[start][i] == false) {
				visited[start][i] = true;
				System.out.printf(" %d ",adjacencyList[start].get(i));
				path.add(adjacencyList[start].get(i));
				if (dfs(adjacencyList[start].get(i), visited, path)) {
					return true;
				}
			} 
		}
		return false;
	}
	public ArrayList<Integer> searchMotherVertex() {
		boolean visited[][] = new boolean[numVertex][numVertex];
		ArrayList<Integer> motherVertices = new ArrayList<>();
		HashSet<Integer> path = new HashSet<>();
		for (int i=0;i<adjacencyList.length;i++) {
			for (int j=0;j<numVertex;j++) {
				for (int k=0;k<numVertex;k++) {
					visited[j][k] = false;
				}				
			}
			path.clear();
			System.out.printf(" %d ",i);
			path.add(i);
			if (dfs (i, visited, path)) {
				motherVertices.add(i);
		    }
			System.out.println();
		}
		return motherVertices;
	}
	*/
	public static void main(String[] args) {
		FindParentVertex vertices = new FindParentVertex(7);
		ArrayList<Integer> motherVertices;
		vertices.addEdge(0,1);
		vertices.addEdge(0,2);
		vertices.addEdge(1,3);
		vertices.addEdge(4,1);
		vertices.addEdge(5,2);
		vertices.addEdge(5,6);
		vertices.addEdge(6,0);
		vertices.addEdge(6,4);
		vertices.searchMotherVertex();
		/*
		motherVertices = vertices.searchMotherVertex();
		if (motherVertices.size() == 0) {
			System.out.println("There is no mother vertex.");
		} else {
	    	for (int i=0;i<motherVertices.size();i++) {
		    	System.out.printf("The mother vertex is %d .", motherVertices.get(i));
			    System.out.println();
		    }
		}
		*/
	}

}

