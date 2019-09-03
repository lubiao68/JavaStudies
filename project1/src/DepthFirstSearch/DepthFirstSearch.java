package DepthFirstSearch;

import java.util.*;
import java.util.concurrent.PriorityBlockingQueue;

public class DepthFirstSearch {
	
	public static void main(String[] args) {
		Node b, c, d, e, f, g, h, i, j;	
		HashSet<Character> set = new HashSet<>();
		HashMap<Character, Node> map = new HashMap<>();
		
		Node a = new Node('a');
		a.getMapList(map);
		a.getSetList(set);
		
		
		b = a.addChild('b');
		d = b.addChild('d');
		f = b.addChild('f');
		c = b.addChild('c');
		e = d.addChild('e');
		g = f.addChild('g');
		j = f.addChild('j');
		h = j.addChild('h');
		i = j.addChild('i');
		System.out.println();

		/*
		b = a.addChild('b');
		c = b.addChild('c');
		d = c.addChild('d');
		*/
		printBFS(a);
		search(a, 'a', 'd');
		
		Character [] list = {'b', 'c', 'd'};
		
		for (Character element:list) {
			reachable(map.get(element));
		}

	}
	
	public static void printDFS(Node node) {
		Stack<Node> stack = new Stack<>();
		Set<Node> set = new HashSet<>();

		stack.push(node);
		set.add(node);
		// Add and remove each node from stack while processing until nothing left in the stack.
		// If a node has been popped, mark hashset and add its child nodes then continue. Each loop will pop the last node.
		while (!stack.isEmpty()) {
			// Pop the last item from the stack.
			Node currNode = stack.pop();
			// If it's already been processed before, that means there is a circle so skip it.
			System.out.print(currNode.vertex + " "); 
			// Otherwise backtrack	
			// Find child nodes haven't been processed yet, add to stack and continue.
			if (currNode.next == null) {
				continue;
			}

			for (Node e:currNode.next) {
				if (!set.contains(e)) {
					stack.push(e);
					set.add(e);
				}
			}
		}
		System.out.println();
		return;
	}
	
	public static void printBFS(Node node) {
		Queue<Node> queue = new LinkedList<>();
		Set<Node> set = new HashSet<>();

		queue.offer(node);
		set.add(node);
		// Add and remove each node from stack while processing until nothing left in the stack.
		// If a node has been popped, mark hashset and add its child nodes then continue. Each loop will pop the last node.
		while (!queue.isEmpty()) {
			// Pop the last item from the stack.
			Node currNode = queue.poll();
			// If it's already been processed before, that means there is a circle so skip it.
			System.out.print(currNode.vertex + " "); 
			// Otherwise backtrack	
			// Find child nodes haven't been processed yet, add to stack and continue.
			if (currNode.next == null) {
				continue;
			}

			for (Node e:currNode.next) {
				if (!set.contains(e)) {
					queue.offer(e);
					set.add(e);
				}
			}
		}
		System.out.println();
		return;
	}
	
	
	/*
	public static void printDFS(Node node) {
		Stack<Node> stack = new Stack<>();
		Set<Node> set = new HashSet<>();

		stack.push(node);
		// Add and remove each node from stack while processing until nothing left in the stack.
		// If a node has been popped, mark hashset and add its child nodes then continue. Each loop will pop the last node.
		while (!stack.isEmpty()) {
			// Pop the last item from the stack.
			Node currNode = stack.pop();
			// If it's already been processed before, that means there is a circle so skip it.
			if (!set.contains(currNode)) {
				set.add(currNode);
				System.out.print(currNode.vertex + " ");
			} 
			// Otherwise backtrack	
			// Find child nodes haven't been processed yet, add to stack and continue.
			if (currNode.next == null) {
				continue;
			}

			for (Node e:currNode.next) {
				if (!set.contains(e)) {
					stack.push(e);
				}
			}
		}
		System.out.println();
		return;
	}
	*/
	
	public static void reachable (Node node) {
		Stack<Node> stack = new Stack<>();
		Set<Node> set = new HashSet<>();
		
		stack.push(node);
		// Add and remove each node from stack while processing until nothing left in the stack.
		// If a node has been popped, mark hashset and add its child nodes then continue. Each loop will pop the last node.
		System.out.print("Reachable nodes from ' " + node.vertex + "' are ");
		while (!stack.isEmpty()) {
			// Pop the last item from the stack.
			Node currNode = stack.pop();
			// If it's already been processed before, that means there is a circle so skip it.
			if (!set.contains(currNode)) {
				set.add(currNode);
				System.out.print("'" + currNode.vertex + "' ");
			} 
			// Otherwise backtrack	
			// Find child nodes haven't been processed yet, add to stack and continue.
			if (currNode.next == null) {
				continue;
			}

			for (Node e:currNode.next) {
				if (!set.contains(e)) {
					stack.push(e);
				}
			}
		}
		System.out.println();
		return;
	}

	public static void search(Node root, Character start, Character dest) {	
		Stack<Node> stack = new Stack<>();
		Set<Node> set = new HashSet<>();
		int count = 0;
		boolean start_ptr = false;
		boolean dest_ptr = false;
		
		stack.push(root);
		// Add and remove each node from stack while processing until nothing left in the stack.
		// If a node has been popped, mark hashset and add its child nodes then continue. Each loop will pop the last node.
		while (!stack.isEmpty()) {
			// Pop the last item from the stack.
			Node currNode = stack.pop();
			
			// If it's already been processed before, that means there is a circle so skip it.
			if (!set.contains(currNode)) {
				set.add(currNode);
				if (!start_ptr && currNode.vertex == start) {
					start_ptr = true;
					System.out.print("Starting ");
					count = 0;
				}		
				if (start_ptr) {
					if (currNode.vertex == dest) {
						dest_ptr = true;
						System.out.print (currNode.vertex + " and ");
						System.out.println("the number of edges is " + count + "!");
						return;
					}
					else  if (start_ptr) {
						count ++;
						System.out.print(currNode.vertex + " -> ");
					}
				}
			}
			// Otherwise backtrack
			if (currNode.next == null) {
				continue;
			}
			// Find child nodes haven't been processed yet, add to stack and continue.
			for (Node e:currNode.next) {
				if (!set.contains(e)) {
					stack.push(e);
				}
			}
		}
		if (!dest_ptr) {
			System.out.println(".... to " + dest + " not found!");
		}

		return;
	}
}

