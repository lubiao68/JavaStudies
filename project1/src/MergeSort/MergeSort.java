package MergeSort;

public class MergeSort {

	public static void main(String[] args) {
		int[] list = {9, 8,3,13,87,12,99};
		mergeSort(list);
		for (int e: list) {
			System.out.print (e + " ");
		}
	}
	
	public static void mergeSort (int[] list) {
			sort (list, 0, list.length-1);
	}
	
	public static void sort (int[] list, int l, int r) {
		if (l >= r) {
			return;
		}
		
		int m = (r + l) / 2;
		sort (list, l, m);
		sort (list, m+1, r);
		merge (list, l, m, r);	
	}
	
	public static void merge (int[] list, int l, int m, int r) {
		int[] in = new int[r-l+1];
		int left = l;
		int right = m+1;
		int index = 0;
		
		
		while (left <= m && right <= r) {
			if (list[left] <= list[right]) {
				in[index] = list[left];
				left ++;
			} else {
				in[index] = list[right];
				right ++;
			}
			index ++;		
		}	
		if (right <= r) {
			for (int i=right; i<=r; i++, index++) {
				in[index] = list[i];
			}
		}
		else if (left <= m ) {
			for (int i=left; i<=m; i++, index++) {
				in[index] = list[i];
			}
		}
		
		for (int i=0; i< in.length; i++) {
		    list[l+i] = in[i];
		}
	}
}




