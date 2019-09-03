package SetOfNumElements;

	import java.util.ArrayList;
	import java.util.HashMap;
	import java.util.List;
	import java.util.Map;
	import java.util.Scanner;

	public class SetOfNumElements {

		public static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		
		public static void main(String[] args) {
			int[] array = {2,4,6,10,16,32};
			int target = 0;
			int result = 0;
			Scanner in = new Scanner(System.in); 
			System.out.println("Please enter the Sum you would like to match: ");
	        target = in.nextInt();
			// System.out.printf("The number of set to match the sum is: %s .", find(array, target));
	        if ((result = find(array, target)) == 0) {
		        System.out.println("-----------------------------------------------------------------");
	        	System.out.printf("No match found for %d !", target);
		        System.out.println("----------------------------------------------------------------");
	        }
	        System.out.println("----------------------------------------------------------------");
	        System.out.printf("There are %d matching indexes for target %d are: ", result, target);
	        System.out.println();
	        System.out.println("----------------------------------------------------------------");
	        for (int i=0;i<list.size();i++) {
	        	System.out.print("[ ");
	        	for (int j=0; j < list.get(i).size(); j++) {
	        		System.out.print(list.get(i).get(j) + " ");
	        	}
	        	System.out.print("]");
	        	System.out.println();
	        }
		}

		public static int find (int[] array, int target) {
			Map<String, Integer> memo = new HashMap<>();
			ArrayList<Integer> indexList = new ArrayList<>();
			if (array.length == 0) {
				return 0;
			}	
			return find_set(array, 0, target, memo, indexList);
		}
		
		//  The function here is not only tracking the total number of patterns (indexes) for the target sum, it also
		//  tracks the number of elements for output.  Dynamic programming is used to minimize the redundant lookups.
		//  "memo" is a hashmap for dynamic programming.  
		//  "indexList" is used to backtrack the number of elements and the Array List for each pattern is added to
		//  the global "list" when the last element is detected.
		
		public static int find_set (int[] array, int index, int target, Map<String, Integer>memo, ArrayList<Integer> indexList) {
			String key = Integer.toString(target)+":"+Integer.toString(index);
			int result = 0;
			
			// Dynamic programming logic here to retrieve  what has already been calculated. 
			if (memo.containsKey(key)) {
				//* Retrieve the count for Dynamic programming.  
		        System.out.println("----------------------------------------------------------------");
				System.out.printf("Dynamic programming retriving key %s ", key);
				System.out.println();
		        System.out.println("----------------------------------------------------------------");
				return memo.get(key);
			}
			System.out.printf("Key: %s = ", key);
			// This means the match was found and the previous index was the last value. 
			// The recursion will return from here.  Add the previous index to the list for output.
			if (target == 0) {
				System.out.println();
				System.out.println("-------------------------------");
				System.out.printf("Match found and last index is %d.", index-1);
				System.out.println();
				System.out.println("-------------------------------");
				// Add the pattern (ArrayList) to the global "list".
				list.add(indexList);
				return 1;
			}
			// Didn't find the set to match the target value and return from here.
			if (target < 0 || index < 0 || index >= array.length) {
				System.out.printf("Not found at index %d.", index);
				System.out.println();
				// Clear the ArrayList when there is no match found. 
				indexList.clear();
				return 0;
			}
			// If the array is sorted, since the index is already greater than the target no match here.
			/*
			if (array[index] > target) {
				return 0;
			}
			*/
	        // Otherwise skip and continue to search for next index. 
			if (target < array[index]) {
				result = find_set (array, index+1, target, memo, indexList);
				System.out.printf ("The index %d value %d is greater than the remaining sum %d to target.", index, array[index], target);
				System.out.println();
			} else {
				// For a given index, it either is included or not included as a part of set. So the recursion 
				// will break down to two function calls. 
				System.out.printf("Searching next index for both conditions %d", index+1);
				System.out.println();
				ArrayList<Integer> indexList1 = (ArrayList<Integer>) indexList.clone();
				// Add the pattern (ArrayList) to the global "list". Only the call including the index will be possible to match.
				indexList1.add(index);
				result = find_set (array, index+1, target, memo, indexList) + find_set (array,index+1, target-array[index], memo, indexList1);
			}
			//* Save the count for Dynamic programming.  
			System.out.printf("Dynamic programming saving key %s ", key);
			System.out.println();
			memo.put(key, result);
			return result;

		}
	}


