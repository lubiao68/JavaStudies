package BTLevelOrderTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import SymmetricTree.TreeNode;

public class BTLevelOrderTraversal {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.addLeftNode(new TreeNode(2));
		root.addRightNode(new TreeNode(2));
		root.left.addLeftNode(new TreeNode(3));
		root.left.addRightNode(new TreeNode(4));
		root.right.addLeftNode(new TreeNode(4));
		root.right.addRightNode(new TreeNode(3));
		/*
		for (List<Integer> list:levelOrder(root)) {
			System.out.print("Level: ");
			for (Integer e:list) {
				System.out.print(e + " ");
			}
			System.out.println();
		}
		*/
		root.printBSTbyLevel(root);
		return;	

	}
	
	public static List<List<Integer>> levelOrder (TreeNode root) {
		List<List<Integer>> list = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		
		if (root == null) {
			return list;
		}
		
		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> levelList = new ArrayList<>();
			for (int i= 0;i < size; i++) {
				TreeNode node = queue.poll();
				levelList.add(node.val);
				if (node.left != null) {
					queue.add(node.left);					
				}
				if (node.right != null) {
					queue.add(node.right);					
				}
			}
			list.add(levelList);
		}
		return list;
	}
}

