package LRU;

import java.util.Hashtable;

public class LRUCache {
	public static final int MAX_CACHE_SIZE = 100;
	
	Hashtable<Integer, Node> hashtable;  
	private int numItemsInCache;
	private int sizeOfCache;
	public Node head = null;
	public Node tail = null;
	
	public LRUCache (int size) {
		if (size > MAX_CACHE_SIZE) {
			System.out.println("The maximum allowed size is 5 currently!");
		}
		hashtable = new Hashtable<>(size);
		sizeOfCache = size;
		numItemsInCache = 0;
	}
	
	public class Node {
		int key;
		String value;
		Node prev = null;
		Node next = null;
	}
	
	// These are methods related to cache access operations. 
	public void addCache(int key, String value) {
		Node node = null;
		if (numItemsInCache > sizeOfCache) {
			return;
		}
		// Need to check and see if the key exists !!!
		// Update the cache and move to the tail !!!
		node = hashtable.get(key);
		if (node != null && key == node.key) {
			updateCache(node.key, value);
			return;
		}
		if (numItemsInCache == sizeOfCache) {
			node = pollHeadNode();
			if (node == null) {
				return;
			}
			node = hashtable.get(node.key);
			if (node != null) {
				hashtable.remove(node.key);
				numItemsInCache --;				
			}
			System.out.println(node.key + " was removed from queue & cache!");
		}
		node = appendNode (key, value);
		hashtable.put(key, node);
		System.out.println(key + " was added to queue & cache!");
		numItemsInCache ++;
		return;
	}
	
	public void getCache(int key) {
		Node node = hashtable.get(key);
		if (node == null) {
			System.out.println(key + " was not found in the cache!");
			return;
		}
		moveNodeToTail(node);
		System.out.println(key + " has been retrieved and the cache has been reflected!");
	}
	
	public void deleteCache (int key) {
		Node node = hashtable.get(key);
		if (node == null) {
			System.out.println(key + " was not in the cache and failed to delete !");
			return;
		}
		removeNode(node);
		hashtable.remove(key);
		System.out.println(key + " was removed from queue & cache!");
		numItemsInCache --;
		return;
	}
	
	public void updateCache (int key, String value) {
		Node node = hashtable.get(key);
		if (node == null) {
			System.out.println(key + " was not in the cache and failed to update !");
			return;
		}
		node.value = value;
		moveNodeToTail(node);
		System.out.println(key + " has been updated and the cache has ben reflected!");
		return;
	}
	
	public void printQueue() {
		Node node = tail;
		if (isEmpty()) {
			System.out.println("Cache is empty");
			return;
		}
		System.out.println(" ---------------------------------");
		System.out.println("         Linked List (Cache)      ");
		System.out.println(" V--------------------------------");
		while (node != null) {
			System.out.println(" | " + node.key + " : " + node.value);
			node = node.prev;
		}
		if (node == null) {
			System.out.println(" V-------------------------------");
		}
		else {
			System.out.println("---------------------------------");
		}
		return;
	}
	
	public void printCache() {
		System.out.println();
		printQueue();
		System.out.println();
		System.out.println(" ---------------------------------");
		System.out.println("   HashTable (Map to Linked List) ");
		System.out.println(" V--------------------------------");
		for (Integer e: hashtable.keySet() ) {
			System.out.println(" | " + e + " : " + hashtable.get(e).value);
		}
		System.out.println(" V-------------------------------");
		System.out.println();
		return;
	}
	
	// These are methods related to access to doubly linked list nodes used by cache.
	public boolean isEmpty() {
		if (head == null | tail == null) {
			return true;
		}
		else {
			return false;
		}
	}
	public Node appendNode (int key, String value) {
		Node node = new Node();
		node.key = key;
		node.value = value;
		
		if (isEmpty()) {
			head = node;
			tail = node;			
		}
		else {
			node.prev = tail;
			node.next = null;
			tail.next = node;
			tail = node;
		}
		return node;
	}
	
	public void removeNode (Node node) {
		if (node == null) {
			return;
		}
		// Only one node condition below.
		if (head == tail) {
			head = null;
			tail = null;
			return;
		}
		if (node == head) {
			node.next.prev = null;
			head = node.next;
		} if (node == tail) {
			tail.prev.next = null;
			tail = tail.prev;
		} else {
			node.next.prev = node.prev;
			node.prev.next = node.next;
		}
		return;
	}
	
	public Node pollHeadNode () {
		Node node = null;	
		if (head == null) {
            return null;
        }
		// both point to a single node.
		if (head == tail) {
			node = head;
			head = null;
			tail = null;
			return node;
		}
		node = head;
		int key = head.key;
		head.next.prev = null;
		head = head.next;
		return node;
	}

	
	public void moveNodeToTail (Node node) {
		// No move is needed if it is only one node or it is empty.
		if (node == null || head == tail) {
			return;
		}
		if (node == head) {
			node.next.prev = null;
			head = node.next;
		} else if (node == tail) {
			tail.prev.next = null;
			tail = tail.prev;
		} else {
			node.next.prev = node.prev;
			node.prev.next = node.next;
		}
		node.prev = tail;
		node.next = null;
		tail.next = node;
		tail = node;
		return;
	}   
}

