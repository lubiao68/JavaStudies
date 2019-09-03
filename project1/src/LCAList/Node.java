package LCAList;

public class Node {
	public int val;
	public Node left;
	public Node right;
	
	public Node (int x) {
		this.val = x;
		this.left  = null;
		this.right = null;
	}
	
	public Node addLeftNode (int val) {
		Node node = new Node(val);
		this.left = node;
		return node;
	}
	
	public Node addRightNode (int val) {
		Node node = new Node(val);
		this.right = node;
		return node;
	}
}

