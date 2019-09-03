package SelectionSort;

public class SelectionSort {

	public static void main(String[] args) {
		int[] list = selectionSort(new int[] {9, 8,3,13,87,12,99});
		for (int e: list) {
			System.out.print (e + " ");
		}
	}
	public static int[] selectionSort(int[] list) {
		int min_index = 0;
		int temp = 0;
		for (int i=0; i< list.length; i++) {
			min_index = i;
			for (int j= i+1; j< list.length; j++) {
				if (list[j] < list[min_index]) {
					min_index = j;
				}
			}
			// swap
			temp = list[min_index];
			list[min_index] = list[i];
			list[i] = temp;
		}
		return list;
	}
	/*
	public static int[] selectionSort(int[] list) {
		int min_value = 0;
		int min_index = 0;
		for (int i=0; i< list.length; i++) {
			min_value = list[i];
			for (int j= i+1; j< list.length; j++) {
				if (min_value > list[j]) {
					min_value = list[j];
					min_index = j;
				}
			}
			// swap
			list[min_index] = list[i];
			list[i] = min_value;
		}
		return list;
	}
	*/

}

