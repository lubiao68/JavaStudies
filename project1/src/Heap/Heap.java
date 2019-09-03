package HEAP;

public class Heap {
	// static int[] array = new int[] {15,14,13,12,11,10,9,8,7,6,5,4,3,2,1};
	static int[] array = new int[] {15,5,12,7, 6,3,8,2,11,14,4,10,13,9,1};
	// static int[] array2 = new int[] {1,2,3,4,5,6,7,7,8,9,10,11,12,13,14,15};
	
	public static void main(String[] args) {
		// To build a min heap. 
		/*
		build_heap (array, true);
		for (int e: array) {
			System.out.print(e + " ");
		}
		System.out.println();
		*/
		// To build a max heap.
		/*
		build_heap (array, true);
		for (int e: array) {
			System.out.print(e + " ");
		}
		System.out.println();
		*/
		sort_heap (array, true);
		for (int e: array) {
			System.out.print(e + " ");
		}
		System.out.println();
	}
	
	// 1. For an unsorted array, build max or min heap (still doesn't mean it's sorted)
	// 2. swap the last element for each loop until before the last item.  
	// 3. heapify from the top each time to the last element of that cycle so the previous sorted elements will not be overwritten.
	public static void sort_heap (int[] array, boolean max) {
		build_heap (array, max);
		for (int i=array.length-1; i>0; i--) {
			swap (i, 0);
			heapify (array, 0, max, i);
		}
		return;
	}
	
	public static void build_heap (int[] array, boolean max) {
		for (int i= (array.length-1)/2; i>=0; i-- ) {
			heapify(array, i, max, array.length);
		}
		return;
	}
	
	// Since we are dealing with array, we need to rely on the input for the total number of "elements" to determine
	// if the node has any child nodes or not. If not, -1 should be return;   
	public static int getLeftIndex (int parent, int array_size) {
		int index = parent * 2 + 1;
		if (index >= array_size) {
			return -1;
		}
		return index;
	}
	
	// Since we are dealing with array, we need to rely on the input for the total number of "elemements" to determine
	// if the node has any child nodes or not. If not, -1 should be return;   
	public static int getRightIndex (int parent, int array_size) {
		int index = parent * 2 + 2;
		if (index >= array_size) {
			return - 1;
		}
		return index;
	}
	
	public static int getParentIndex (int child) {
		if (child == 0) {
			return 0;
		}
		return (child -1) / 2;
	}
	
	public static void swap (int index1, int index2) {
		int temp = 0;
		temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
		return;
	}
	
	// Heapify is from a node down to swap and continue until the leaf of that branch based on the min or max.  
	// It's very important to be aware of the availability of the child nodes since the heap is not a full binary tree. 
	// The param size is for sorting purpose.  
	public static void heapify (int[] array, int index, boolean max, int array_size) {
		// This is a recursive function the base case here is to get to the leaf node. So it's extremely important to check the child nodes.
		int heapifyIndex = 0;
		if (getLeftIndex(index, array_size) == -1 && getRightIndex(index, array_size) == -1) {
			return;
		}
		if (getLeftIndex(index, array_size) != -1 && getRightIndex(index, array_size) == -1) {
			heapifyIndex = getLeftIndex(index, array_size);
		}
		else if (getLeftIndex(index, array_size) == -1 && getRightIndex(index, array_size) != -1) {
			heapifyIndex = getRightIndex(index, array_size);
		}
		else if (array[getLeftIndex(index, array_size)] > array[getRightIndex(index, array_size)] && !max ||
				 array[getLeftIndex(index, array_size)] < array[getRightIndex(index, array_size)] && max) {
			heapifyIndex = getRightIndex(index, array_size);
		}
		else if (array[getLeftIndex(index, array_size)] < array[getRightIndex(index, array_size)] && !max ||
				 array[getLeftIndex(index, array_size)] > array[getRightIndex(index, array_size)] && max) {
				heapifyIndex = getLeftIndex(index, array_size);
		}
		// Swap and then continue heapifing the child nodes. 
		if (array[index] > array[heapifyIndex] && !max ||
			array[index] < array[heapifyIndex] && max) {
			swap (index, heapifyIndex);
		}
		heapify(array, heapifyIndex, max, array_size);
		return;
	}
}

