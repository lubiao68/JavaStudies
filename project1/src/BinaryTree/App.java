package BinaryTree;

import java.util.ArrayList;

public class App {

	public static void main(String[] args) {
		BST tree = new BST();		
          tree.insertNode(10);
          tree.insertNode(15);
          tree.insertNode(25);
          tree.insertNode(5);
          tree.insertNode(17);
          tree.insertNode(6);         
          System.out.println(tree.searchMin());
          System.out.println(tree.searchMax());
          tree.searchNode(25);
          System.out.println(tree.isValidBST(tree.root));
          System.out.println(tree.findDiameter(tree.root));
          tree.printBST(tree.root);
          return;
          
          
	}

}
