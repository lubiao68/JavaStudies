package InsertionSort;

public class InsertionSort {

	public static void main(String[] args) {
		int[] list = insertionSort(new int[] {9, 8,3,13,87,12,99});
		for (int e: list) {
			System.out.print (e + " ");
		}
	}
	
	public static int[] insertionSort (int[] list) {
		int temp = 0;
		for (int i=1; i<list.length; i++) {
			for (int j=i-1; j>=0; j--) {
				if (list[j] > list[j+1]) {
					temp = list[j];
					list[j] = list[j+1];
					list[j+1] = temp;
				}
				else {
					break;
				}
			}
		}
		return list;
	}
	

}


/*

public class InsertionSort {

	public static void main(String[] args) {
		int[] array = {5,8,1,6,9,3};
		int temp = 0;
		
		for (int i=1; i<array.length; i++) {
			for (int j=i-1; j>=0; j--) {
				if (array[j+1] < array[j]) {
					temp = array[j+1];
					array[j+1] = array[j];
					array[j] = temp;
				}
				else
				{
					break;
				}
			}
		}
		for (int e:array) {
			System.out.print(e + " ");
		}

	}
}
*/

/*
public static int[] insertionsort(int[] list) {
	int element = 0;
	int index = 0;
	// Outer loop is for unsorted zone
	for (int i=1; i<list.length; i++) {
		// Leave list[x] position for swapping and setting at sorted zone.
		element = list[i];
		// Set initial index position
		index = i - 1;
		// Compare elements with sorted zone items
		while (index>=0 && list[index] > element) {
			// Swapping with element at list[index + 1] initially and then any sorted elements need to be shift. 
		    list[index+1] = list[index];
			index --;
		}
		// Settle element where it supposed to be.
		list[index+1] = element;
	}
	return list;
}
*/
