package KnapsackProblem;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class KnapsackProblem {
	public static void main(String[] args) {
		List<Item> items = new ArrayList<>();
		items.add(new Item(1,5));
		items.add(new Item(2,3));
		items.add(new Item(4,5));
		items.add(new Item(2,3));
		items.add(new Item(5,10));

		System.out.println(fillup_knapsack(items, 0, 10));
		
	}
	public static int fillup_knapsack (List<Item> items, int index, int capacity) {
		Map<String, Integer> memo = new Hashtable<>();
		String key = null;
		
		if (items.size() == 0 || index >= items.size()) {
			return 0;
		}
		key = Integer.toString(capacity) + ":" + Integer.toString(index);
		if (capacity == 0) {		
			if (!memo.containsKey(key)) {
				memo.put(key, 0);
				System.out.println(key);
			}
			return memo.get(key);
		}

		if (items.get(index).weight > capacity) {
			return fillup_knapsack (items, index+1, capacity);
		}
		int temp1 = fillup_knapsack (items, index+1, capacity);
		int temp2 = items.get(index).value + fillup_knapsack (items, index+1, capacity - items.get(index).weight);
		if (!memo.containsKey(key)) {
			memo.put(key, Math.max(temp1,  temp2));
		}
		System.out.printf("key: %3s, index %2d,  value %2d", key, index, memo.get(key));
		System.out.println();
		return memo.get(key);

	}
	
	
}

