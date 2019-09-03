package LCAList;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class LCAList {
	public static List<Node> list = new ArrayList<Node>();
	
	public static void main(String[] args) {
		
		Node root = new Node(10);
		Node a = null;
		Node b = null;
		Node c = null;
		Node d = null;
		a = root.addLeftNode(6);
		b = a.addLeftNode(3);
		c = b.addRightNode(15);
		d = a.addRightNode(30);
		// System.out.println((isLCA(root, a, b)).val);
		
		list.add(b);
		list.add(c);
		list.add(d);
			
		System.out.println((isLCAforList (root,list)).val);
	}
	
	public static Node isLCAforList (Node node, List<Node> list) {
		if (node == null) {
			return null;
		}

		for (Node e: list) {
			if (node.val == e.val) {
				return node; 
			}
		}
		Node leftNode =isLCAforList (node.left, list);
		Node rightNode =isLCAforList (node.right, list);
		
		if (leftNode == null) {
			return rightNode;
		}
		if (rightNode == null) {
			return leftNode;
		}	
		return node;
	}
	
	// Assumption is that there is no repeat nodes on the binary tree.
	public static Node isLCA (Node node, Node x, Node y) {
		Node leftNode = null;
		Node rightNode = null;
		
		// The node does not exist.  
		if (node == null) {
			return null;
		}

		// If the current node is one of two nodes return to parent level.  
		if (node.val == x.val || 
			node.val == y.val) {
			return node;
		}
		
		leftNode = isLCA (node.left, x, y);
		rightNode = isLCA (node.right, x, y);
		
		if (leftNode == null) {
			return rightNode;
		}
		if (rightNode == null) {
			return leftNode;
		}	
		return node;
	}
}
