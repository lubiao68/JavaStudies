package KSortedList;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KSortedList {
	
    public static ListNode mergeKLists(List<ListNode> lists) {

    	if (lists==null||lists.size()==0) return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> a.val - b.val);

        ListNode dummy = new ListNode(0);
        ListNode tail=dummy;

        for (ListNode node:lists)
            if (node!=null)
                queue.add(node);
                
        while (!queue.isEmpty()){
        	// Priority queue will be sorted for any poll, offer operations etc.  Default max heap and need to add a comparator for min heap.
        	// Poll the smallest item from min heap and it is from first list in the queue.  
        	// Shift to child so it can be added later to the queue so it can be continuously processed until nothing left.
            tail.next=queue.poll();
            tail=tail.next;
            // Add the next node on the list to queue until nothing left to be added. 
            if (tail.next!=null)
                queue.add(tail.next);
        }
        // This is the key for shifting and the initially node is dummy node.
        return dummy.next;
    }
	
	public static void main(String[] args) {
		List<ListNode> lists = new ArrayList<ListNode>();
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(1);
		ListNode c = new ListNode(2);
		a.addNode(new ListNode(3));
		b.addNode(new ListNode(5));
		c.addNode(new ListNode(2));
		lists.add(a);
		lists.add(b);
		lists.add(c);
		/*
		ListNode sortedList = mergeKList(lists);
		ListNode tail = sortedList;
		while (tail != null) {
			System.out.print(tail.val + " ");
			tail = tail.next;
		}
		System.out.println();
		*/
		ListNode tail = null;
        // tail = twoSortList(a, b);
        tail = recursiveTwoSortedList(a, b);
		while (tail != null) {
			System.out.print(tail.val + " ");
			tail = tail.next;
		}
	}
	
	public static ListNode twoSortList(ListNode a, ListNode b) {
		ListNode result = new ListNode(0);
		ListNode prev = result;

		while (a != null && b != null) {
			if (a.val <= b.val) {
				prev.next = a;
				a = a.next;
			} else {
				prev.next = b;
				b = b.next;
			}
			prev = prev.next;
		}
		if (a != null) { 
			prev.next = a;
		} 
		if (b !=  null){
			prev.next = b;
		}
		return result.next; 
	}
	
	public static ListNode recursiveTwoSortedList(ListNode a, ListNode b) {
		if (a == null) {
			return b;
		}
		if (b == null) {
			return a;
		}
		if (a.val < b.val) {
			a.next = recursiveTwoSortedList (a.next, b);
			return a;
		} else {
			b.next = recursiveTwoSortedList (a, b.next);
			return b;
		}
	}
	
    public static ListNode mergeKList(List<ListNode> lists) {
    	PriorityQueue<ListNode> queue = new PriorityQueue<>((a,b)->a.val - b.val);
    	if (lists == null || lists.size()==0) {
    		return null;
    	}
    	// Add each head of list to the min queue. 
    	for (ListNode node:lists) {
    		if (node != null) {
    			queue.add(node);
    		}
    	}
    	// Initialize a list for output. 
    	ListNode resultList = new ListNode(0);
    	ListNode tail = resultList;
    	
    	while (!queue.isEmpty()) {
    		// Pop the smallest from the min queue and assign to the tail.next (head is dummy). 
    		tail.next = queue.poll();
    		// Shift its next for next loop & also its next will be added to the queue until null. 
    		tail  = tail.next;
    		if (tail.next != null) {
        		queue.add(tail.next);    			
    		}
    	}
    	return resultList.next;
    }
}

