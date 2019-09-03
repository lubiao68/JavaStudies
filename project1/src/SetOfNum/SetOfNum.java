package SetOfNum;

import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class SetOfNum {

	public static void main(String[] args) {
		int[] array = {2,4,6,10};
		int target = 0;
		int result = 0;
		Scanner in = new Scanner(System.in); 
		System.out.println("Please enter the Sum you would like to match: ");
        target = in.nextInt();
        result =  find(array, target);
        System.out.println("------------------------------------------");
		System.out.printf("The number of set to match the sum is: %2d.",result);
		System.out.println();
        System.out.println("------------------------------------------");
	}
	
	public static int find (int[] array, int target) {
		Map<String, Integer> memo = new Hashtable<>();
		return find_all(array, 0, target, memo);
	}
	
	// This looks like to find the permutation of the elements.
	// Walk through examples on the paper or white board.  
	// This is a recursive problem. 
	// What happens at each node ?
	// Assumption and clarification: 
	// - Target - 0 = 1 count; no negative; integer
	// - Array - Sort, no negative; No repeat; integer;
	// Input parameters of recursive function: array, index, target.  index can be used to break down to small recursive logic.
	// What's the base cases? Look at a current node or element or level.
	// What's the edge cases? Look for any inputs. 
	// DP - How to find what can use DP?  
	// - The input condition and it should be the key. 
	// - The output (return) at the each level (recursive call to child node usually). Here is the DP logic for what to retrieve and save. 
	// - Base case is another place will have DP logic for retrieve and save. 
	
	public static int find_all (int[] array, int index, int target, Map<String, Integer> memo) {
		String key = null;
		key = Integer.toString(index) + ":" + Integer.toString(target);
		System.out.printf("Key: %s = ",  key);
		if (memo.containsKey(key)) {
			System.out.println();
			System.out.println("--------------------------");
			System.out.println("Read key from cache: " + key);
			System.out.println("--------------------------");
			return memo.get(key);
		}

		// The base case here is important since the count will be added when target(remaining sum) is 0. 	
		if (target == 0) {
			System.out.println();
			System.out.println("---------------------");
			System.out.println("Match found index: " + (index-1));
			System.out.println("---------------------");
			return 1;
		} else if (target < 0 | array.length == 0 || index >= array.length) {
			System.out.println("No match at index:" + index);
			return 0;
		}
        //  Since the array is sorted, so stop and return here. 
		if (array[index] > target) {
			System.out.println("No match index: " + index);
			return 0;
		} 
		else  {
			if (!memo.containsKey(key)) {
			    // Here breaks down to two conditions. 1st is to move to the next index in the array and 2nd is to also deduct the sum until zero.
				System.out.printf("Store key: %s, index: %d in cache!", key, index);
				System.out.println();
				//return find_all(array, index + 1, target, memo) + find_all (array, index + 1, target - array[index], memo);
				memo.put(key, find_all(array, index + 1, target, memo) + find_all (array, index + 1, target - array[index], memo));
			}
			return memo.get(key);
		}
	}
}

