package BubbleSort;

public class BubbleSort {

	public static void main(String[] args) {
		int[] array = {5,8,1,6,9,3};
		int temp = 0;
		for (int i=0; i< array.length-1;i++) {
			for (int j=0; j< array.length - 1 - i; j++) {
				if (array[j] > array[j+1]) {
					temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
		for (int e:array) {
			System.out.print(e + " ");
		}

	}
}

