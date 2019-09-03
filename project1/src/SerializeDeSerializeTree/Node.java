package SerializeDeSerializeTree;

public class Node {
	public int val;
	public Node left;
	public Node right;
	public Node (int val) {
		this.val = val;
		this.left = null;
		this.right = null;
	}
	
	public void addLeftNode (Node node) {
		if (this.left == null) {
			this.left = node;
		}
		else {
			System.out.println("Left node exists and failed to add " + node.val);
		}
		return;
	}
	
	public void addRightNode (Node node) {
		if (this.right == null) {
			this.right = node;
		}
		else {
			System.out.println("Left node exists and failed to add " + node.val);
		}
		return;
	}
}
