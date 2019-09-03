package DFSTraversal;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Vector;

public class DFSTraversal {
	private int numVertices;
	private LinkedList<Integer> adjacencyList[];
	private boolean visited[];
	public DFSTraversal (int numVertices) {
		this.numVertices = numVertices;
		this.adjacencyList = new LinkedList[this.numVertices];
		for (int i=0;i<numVertices;i++) {
			this.adjacencyList[i] = new LinkedList<>();
		}
		this.visited = new boolean[this.numVertices];
		for (int i=0;i<numVertices;i++) {
			this.visited[i] = false;
		}
	}
	public void addEdge (int u, int v) {
		adjacencyList[u].add(v);
	}
	public void dfsTraversal (int s) {
		Stack<Integer> stack = new Stack<>();
		stack.push(s);
		while (!stack.isEmpty()) {
			s = stack.pop();
			if (visited[s]==false) {
				System.out.print(s + " ");
				visited[s] = true;
			}
			for (int v: adjacencyList[s]) {
				if (!visited[v]) {
					stack.push(v);
				}
			}
		}
	}
	
	public static void main(String[] args) {
        // Total 5 vertices in graph 
		DFSTraversal g = new DFSTraversal(5); 
          
        g.addEdge(1, 0); 
        g.addEdge(0, 2); 
        g.addEdge(2, 1); 
        g.addEdge(0, 3); 
        g.addEdge(1, 4); 
              
        System.out.println("Following is the Depth First Traversal"); 
        g.dfsTraversal(0); 

	}

}

/* 
public class DFSTraversal {
	private int numVertices;
	private LinkedList<Integer> adjacencyList[];
	private Vector<Boolean> visited;
	public DFSTraversal (int numVertices) {
		this.numVertices = numVertices;
		this.adjacencyList = new LinkedList[this.numVertices];
		for (int i=0;i<numVertices;i++) {
			this.adjacencyList[i] = new LinkedList<>();
		}
		this.visited = new Vector<>();
		for (int i=0;i<numVertices;i++) {
			this.visited.add(false);
		}
	}
	public void addEdge (int u, int v) {
		adjacencyList[u].add(v);
	}
	public void dfsTraversal (int s) {
		Stack<Integer> stack = new Stack<>();
		stack.push(s);
		while (!stack.isEmpty()) {
			s = stack.pop();
			if (visited.get(s)==false) {
				System.out.print(s + " ");
				visited.set(s,  true);
			}
			Iterator<Integer> itr = adjacencyList[s].iterator();
			while (itr.hasNext()) {
				int v = itr.next();
				if (!visited.get(v)) {
					stack.push(v);
				}
			}
		}
	}
	*/

