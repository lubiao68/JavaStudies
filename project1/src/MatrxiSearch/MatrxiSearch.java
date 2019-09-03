package MatrxiSearch;

import java.util.Scanner;

public class MatrixSearch {

	public static void main(String[] args) {
		int[][] matrix1 = {{1,4,7,11}, {8,9,10,20}, {11,12,17,30}};
		int[][] matrix2 = {{0,1,2,3}, {4,5,6,7}, {8,9,10,11}};
		
       	Scanner in = new Scanner(System.in);
  		System.out.println("Please enter the number you would like to search!");
       	int target = in.nextInt();
       	// OmnSortedSearch (matrix1, target);
       	binarySearchArrays(matrix2, target);
        	
	}
	
	public static void binarySearchArrays(int[][] array, int target) {
		int start = 0;
		int end = array.length * array[0].length - 1;
	
		binarySearchArraysHelper(array, start, end, target);
		
	}
		
	public static void binarySearchArraysHelper(int[][] array, int start, int end, int target) {
		
		while (start <= end) { // Need to have = here!
			int mid = start + (end-start) / 2;	// Prevent overflow !
			if (getArrayValue(array, mid) == target) {
				printArrayIndex(array, mid);
			}
			else if (getArrayValue(array, mid) > target) {
				binarySearchArraysHelper (array, start, mid - 1, target);
			}
			else {
				binarySearchArraysHelper (array, mid + 1, end, target);
			}
			return;
		}
		System.out.println("Didn't find " + target + " !");
		return;
	}
	
	// Covert index to array to retrieve the value for comparison. 
	public static int getArrayValue(int[][] array, int index) {
		int i=0, j=0;
		int rows = array.length; // Full length here!
		int columns = array[0].length; // Full length here!
		i = (index + 1) / columns; // Plus one before using division.
		j = (index + 1) % rows; // Plus one before using modulation. 
		int value = array[i][j];
		System.out.println("Comparing with " + value + " at Array [" + i + ", " + j + "] !");
		return value;
	}
	
	public static void printArrayIndex(int[][] array, int index) {
		int i=0, j=0;
		int columns = array.length;
		int rows = array[0].length;
		i = (index + 1) / (rows);
		j = (index + 1) % (columns);
		System.out.println(array[i][j] + " has been found at Array [" + i + ", " + j + "] !");
		return;
	}
	
	// Each i and j is sorted ! There may be duplicated elements.  
	// Key: Find a corner which can go up or down for comparing element which has greater 
	// or lesser value. While loop condition needs to be set to the diagonal corner.
	// O(m+n-1) is the time complexity and O(1) is space complexity. 
	
	public static void OmnSortedSearch (int[][] matrix, int target) {
		int i=0;
        int j=matrix[0].length-1;
        boolean flag = false;
        
        while (i<=matrix.length-1 && j >= 0) {
        	if (matrix[i][j] == target) {
        		System.out.println("The number " + target + " has been found at index [" + i + ", " + j + "]!");
        		flag = true;
        		i++;
        	} else if (matrix[i][j] > target) {
        		j--;
        	}
        	else {
        		i++;
        	}
        }
        if (!flag) {
        	System.out.println("The number " + target + " has not been found!");
        	System.out.println();
        }
		 
	}

}

