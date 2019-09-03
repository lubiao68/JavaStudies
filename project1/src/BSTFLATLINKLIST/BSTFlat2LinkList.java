package BSTFLATLINKLIST;

import java.util.Stack;

public class BSTFlat2LinkList {
    public static Stack<Node> stack = new Stack<>();
	public static void main (String[] args) {
		Node a = new Node(1);
		Node b = new Node(2);
		Node c = new Node(3);
		Node d = new Node(4);
		Node e = new Node(5);
		Node f = new Node(6);
		Node g = new Node(7);
		Node h = new Node(8);
		
		a.addLeftNode(b);
		b.addLeftNode(c);
		b.addRightNode(d);
		c.addLeftNode(e);
		e.addLeftNode(f);
		c.addRightNode(g);
		g.addRightNode(h);
		flatten(a);
		if(validateFlattenTree(a)) {
			System.out.println("The tree has been flatten!");
		}
	}
	/*
	public static void flatten(Node node) {
		Stack<Node> stack = new Stack<>();
		
		if (node == null) {
			return;
		}
		
		while (node != null || !stack.isEmpty()) {
			if (node.right != null) {
				stack.push(node.right);
			}
			if (node.left != null) {
				flatten(node.left);
				node.right = node.left;
				node.left = null;
			} else if (!stack.isEmpty()) {
				node.right = stack.pop();
			}
			node = node.right;
		}
		return;
	} */
	
	
	public static void flatten(Node node) {
		if (node == null) {
			return;
		}
		
		if (node.right != null) {
			stack.push(node.right);
		}
		if (node.left != null) {
			flatten(node.left);
			node.right = node.left;
			node.left = null;
		} else if (!stack.isEmpty()) {
			node.right = stack.pop();
			flatten(node.right);
		}
		return;
	} 
	
	
	public static boolean validateFlattenTree(Node node) {
		
		if (node == null) {
			return true;
		}
		if (node.left != null) {
			System.out.println("The tree hasn't been flatten!");
			return false;
		}
		return validateFlattenTree(node.right);
	}
}

