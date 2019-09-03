package LRU;

import java.util.Set;
import LRU.LRUCache.Node;

public class LRU {

	public static void main(String[] args) {
	
		// The maximum allowed size is 100. 
		LRUCache cache = new LRUCache(5);
        
		cache.getCache(4);
		cache.printCache();
		
		// Initially add 5 elements. 
		cache.addCache(1, "Apple");
		cache.addCache(2, "Banana");
		cache.addCache(3, "Pear");
		cache.addCache(4, "Peach");
		cache.addCache(5, "Watermellon");
		cache.printCache();

		// Add three more and the 3 least access elements will be popped.
		cache.addCache(6, "Strawberry");
		cache.addCache(7, "Blueberry");
		cache.addCache(8, "Sugarcane");
		cache.printCache();
		
		// 4 was at the top of the queue (least access element) and it will be moved to the head.
		cache.getCache(4);
		cache.printCache();
		
		// 6 was at the middle of the queue (least access element) and it will be moved to the head.
		cache.updateCache(6, "Dragon fruit");
		cache.printCache();
	}	
	
}

