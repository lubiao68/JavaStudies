package DetectCycle;

import java.util.Iterator;
import java.util.LinkedList;

public class DetectCycle {
	private int numVertices;
	private LinkedList<Integer> adjacentList[];  // Define a LinkedList array to represent a graph.
	
	public DetectCycle(int numVertices) {
		this.numVertices = numVertices;
		adjacentList = new LinkedList[numVertices]; // Instantiate a LinkedList array. 
		for (int i=0; i<numVertices; i++) {
			adjacentList[i] = new LinkedList();  // Instantiate each LinkedList to represent a vertex. 
		}	
	}
	public void addEdge (int v1, int v2) {
		adjacentList[v1].add(v2); 
		adjacentList[v2].add(v1);
		return;
	}
	public boolean isCycle() {
		boolean[] visited = new boolean[numVertices];
		for (int i=0;i<numVertices;i++) {
			visited[i] = false; 
		}
		for (int i=0; i<numVertices;i++) {
			if (!visited[i]) {
				if (dfs (i, visited, -1)) {
					return true;
				}
			}
		}
		return false;
	}
	public boolean dfs (int vertar, boolean[] visited, int parent) {
		visited[vertar] = true;
		Integer i;
		Iterator<Integer> it = adjacentList[vertar].iterator();
		while (it.hasNext()) {
			i = it.next();
			if (!visited[i]) {
				if (dfs(i, visited, vertar)) {
					return true;
				}
			}
			else {
				if (i != parent) {
					return true;
				}
			}
		}
		return false;
	}
}

