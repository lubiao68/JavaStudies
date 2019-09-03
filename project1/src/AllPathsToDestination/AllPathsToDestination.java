package AllPathsToDestination;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AllPathsToDestination {
	private int numVertex;
	private ArrayList<Integer> graph[];
	private boolean visited[];
	public static ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();
	
	public AllPathsToDestination (int numVertex) {
		this.numVertex = numVertex;
		this.graph = new ArrayList[this.numVertex];
		this.visited = new boolean[this.numVertex];
		for (int i=0;i<this.numVertex;i++) {
			graph[i] = new ArrayList<>();
			this.visited[i] = false;
		}
	}
	public void addEdge (int u, int v) {
		graph[u].add(v);
		return;
	}
	public int getNumVertex() {
		return this.numVertex;
	}

	public void dfs (int start, int end, ArrayList<Integer> list) {
		visited[start] = true;
		if (graph[start].equals(graph[end])) {
			ArrayList<Integer> addList = (ArrayList<Integer>)list.clone();
			resultList.add(addList);
			visited[start] = false;
			return;
		}
		
		for (Integer i:graph[start]) {
			if (!visited[i]) {
				list.add(i);
				dfs (i, end, list);
				list.remove(i);
			}
		}		
		visited[start] = false;
	}
	public void findAllPaths (int start, int end) {
		ArrayList<Integer> list = new ArrayList<>();
		if (start < 0 || start >= numVertex || end < 0 || end >=numVertex) {
			return;
		}
		list.add(start);
		dfs (start, end, list);
		return;
	}
	
	public static void main(String[] args) {
		AllPathsToDestination graph = new AllPathsToDestination(4);
		graph.addEdge(0,1); 
		graph.addEdge(0,2);
		graph.addEdge(0,3); 
		graph.addEdge(2,0); 
		graph.addEdge(2,1); 
		graph.addEdge(1,3);
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter the start of the graph:");
		int start = input.nextInt();
		System.out.println();
		System.out.print("Please enter the end of the graph:");
		int end = input.nextInt();
		System.out.println();
		
		graph.findAllPaths (start, end);
		if (resultList.size() == 0) {
			System.out.printf("No paths have been found between %d and %d !", start, end);
		} else {
			for (int i=0;i<resultList.size();i++) {
				System.out.printf("Path %d is: ", i);
				for (int j=0;j<resultList.get(i).size();j++) {
					System.out.print(resultList.get(i).get(j) + " ");
				}
				System.out.println();
			}			
		}	
	}

}
