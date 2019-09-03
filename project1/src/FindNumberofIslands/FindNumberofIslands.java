package FindNumberofIslands;

public class FindNumberofIslands {

	public static void main(String[] args) {
		int[][] matrix = {{1,1,0,0,0}, {0,1,0,0,1}, {1,0,0,1,1},{0,0,0,0,0}, {1,0,1,0,1}};
		System.out.print("The number of islands is " + countIslands(matrix));
	}
	public static boolean isSafe (int[][] matrix, int row, int col, boolean [][] visited) {
		return (row >= 0 && row < matrix.length && col >=0 && col < matrix[0].length && !visited[row][col] && matrix[row][col] == 1);
	}
	public static void dfs (int[][] matrix, int row, int col, boolean [][] visited) {
		int[] ROW = {-1, -1, -1, 0, 0, 1, 1, 1};
		int[] COL = {-1, 0, 1, -1, 1, -1, 0, 1};
		visited[row][col] = true;
		for (int i=0; i<8; i++) {
			if (isSafe(matrix, row + ROW[i], col + COL[i], visited)) {
				dfs (matrix, row + ROW[i], col + COL[i], visited);				
			}			
		}
		return;
	}
	public static int countIslands (int[][] matrix) {
		boolean [][] visited = new boolean[matrix.length][matrix[0].length];
		for (int i=0; i<matrix.length; i++) {
			for (int j=0; j<matrix[0].length; j++) {
				visited[i][j] = false;
			}
		}
		int count = 0;
		for (int i=0; i<matrix.length; i++) {
			for (int j=0; j<matrix[0].length; j++) {
				if (matrix[i][j] == 1 && visited[i][j] == false) {
					dfs (matrix, i, j, visited);
					++ count;
				}
			}
		}
		return count;
	}
}

