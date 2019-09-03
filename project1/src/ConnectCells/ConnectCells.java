package ConnectCells;

public class ConnectCells {

	public static void main(String[] args) {
		

	}
	public static int getBiggestRegion (int[][] matrix) {
		int maxRegion = 0;
		for (int row=0;row < matrix.length;row++) {
			for (int column=0; column < matrix[row].length; column++) {
				if (matrix[row][column] == 1) {
					int size = getRegionSize(matrix, row, column);
					maxRegion = Math.max(size, maxRegion);
				}
			}
		}
		return maxRegion;
	}
	
	// DFS with iterator.. 
	
	public static int getRegionSize(int[][] matrix, int row, int column) {
		// Base case for recursion
		if (row <=0 || column <=0 || row >= matrix.length || column >= matrix[row].length) {
			return 0;
		}
		// Base case for recursion
		if (matrix[row][column] == 0) {
			return 0;
		}
		int size = 1;  // Itself!
		// Clear up what's been counted and so does not repeat. It's equivalent to "visited" in DFS.  
		matrix[row][column] = 0;
		// Up, down, left and right and see if it is set to 1. 
		for (int r=row -1; r<row +1; r++) {
			for (int c=column-1; c< column +1; c++) {
				// Skip the existing row and column!
				if (r != row || c != column) {
					size+= getRegionSize(matrix, r, c);
				}
			}
		}
		return size;
	}

}
