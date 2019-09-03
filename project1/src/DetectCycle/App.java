package DetectCycle;

public class App {

	public static void main(String[] args) {
		DetectCycle matrix = new DetectCycle(5);
		matrix.addEdge(0, 1);
		matrix.addEdge(0, 3);
		matrix.addEdge(1, 2);
		matrix.addEdge(3, 4);
		
		if (matrix.isCycle()) {
			System.out.println("Graph contains cycle!");
		} else {
			System.out.println("Graph does not contain cycle!");
		}
	}

}

