package BinarySearch;

public class BinarySearch {
/*
	public static void main(String[] args) {
		int[] list = {28, 32, 38, 2, 3, 18, 5};
		System.out.println(recursive_search(list, 0, 3));
	}

	public static int recursive_search(int[] list, int index, int value) {
		if (index > list.length - 1)
			return -1;
		if (list[index] == value)
			return index;
		System.out.println("Index: index");
		return (recursive_search(list, index + 1, value));
	}
*/	
	public static void main(String[] args) {
		int[] list = {2, 3, 5, 18, 28, 32, 38};
		System.out.println(recursive_search(list, 0, list.length - 1, 3));
	}

	public static int recursive_search(int[] list, int head, int tail, int value) {
		int binary_index = 0;
		if (head >= tail)
			return -1;
		binary_index = (head + tail) / 2;
		if (list[binary_index] == value)
			return binary_index;
		else if (list[binary_index] > value)
			tail = binary_index - 1;
		else
			head = binary_index + 1;
		System.out.println("Index: " + binary_index);
		return (recursive_search(list, head, tail, value));
	}
}

