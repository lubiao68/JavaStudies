package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class BST {
    public TreeNode root; 
	public int max_diameter = 0;
	
	public boolean isValidBST (TreeNode root) {
		return validateSubTree (root, null, null);
	}
	
	public boolean validateSubTree (TreeNode node, Integer min, Integer max) {
		if (node == null)
			return true;
		if (min != null && node.val <= min || max != null && node.val >= max) {
			return false;
		}
		return validateSubTree (node.left, min, node.val) && validateSubTree (node.right, node.val, max); 
	}
	/*
	public boolean validateSubTree (TreeNode node, Integer min, Integer max) {
		if ( node == null) {
			return true;
		}
		if (min != null && node.val <= min || max != null && node.val >= max) {
			return false;
		}
		
		return validateSubTree (node.left, min, node.val) && validateSubTree (node.right, node.val, max);
	}
	*/
	
	public int findHeight (TreeNode root) {
		if (root == null) {
			return -1;
		}
		int left = findHeight(root.left) + 1;
		int right = findHeight(root.right) + 1;			
		// Sum up both sub nodes and store in the global variable. 
		max_diameter = Math.max(max_diameter, left + right);
		return Math.max(left, right); 
	}
	
	public int findDiameter (TreeNode root) {
		return findHeight(root);
	}	
	
	public void printBST (TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		TreeNode node = null;
		TreeNode space = new TreeNode(0);
		if (root == null) {
			return;
		}
		queue.add(root);
		while (!queue.isEmpty()) {
			node = queue.poll();
			if (node.val == 0) {
				System.out.print("null" + " ");
			} else {
				System.out.print(node.val + " ");
			}	
			if (node.left != null) {
				queue.add(node.left);
				if (node.right == null) {
					queue.add(space);
				}
			}
			if (node.right != null) {
				queue.add(node.right);
				if (node.left == null) {
					queue.add(space);
				}
			}
		}
		return;
	}
	
	
    public void insertNode (int val) {
    	TreeNode parent = null;
    	TreeNode current = null;
    	
    	if (root == null) {
    		root = new TreeNode(val);
    		return;
    	} 
    	current = root;
    	parent = current;
    	
        while (true) {
        	if (val < current.val) {
        		if (current.left == null) {
            		current.left = new TreeNode(val);
            		return;
        		}
        		current = current.left;       		
        	} else {
            	if (val > current.val) {
            		if (current.right == null) {
                		current.right = new TreeNode(val);
                		return;
            		}
            		current = current.right;
            	}
        	}
    	}
        /*
         while (true) {
        	parent = current;
        	if (val < current.val) {
        		current = current.left;
        		if (current == null) {
        			parent.left = new TreeNode(val);
        			return;
        		}
        		
        	} else {
       			current = current.right;
       			if (current == null) {
       				parent.right = new TreeNode(val);
       				return;
       			}
        	}
    	}
         */
    }

    public TreeNode searchNode (int value) {
    	TreeNode current;
		if (root == null) {
			System.out.println("no Tree!");
			return null;
		}
		current = root;
		while (true) {
			if (value == current.val) {
				System.out.println("Found the node! " + value);
				return current;
			}
			if (value < current.val) {
				if (current.left == null) {
					System.out.println(value + " Not Found");
					return null;
				}
				else {
					current = current.left;
				}
			} else {
				if (current.right == null) {
					System.out.println(value + " Not Found");
					return null;
				}
				else {
					current = current.right; 
				}						
			}
		}
    }
    
    
    public int searchMin() {
    	TreeNode current;
    	
		if (root == null)
			return -1;
		
		current = root;
		
    	while(true) {
    		if (current.left == null)
    			return current.val;
    		else
    			current = current.left;
    	}
    }
    
    public int searchMax() {
    	TreeNode current;
    	
		if (root == null)
			return -1;
		
		current = root;
		
    	while(true) {
    		if (current.right == null)
    			return current.val;
    		else
    			current = current.right;
    	}
    }
    
    
}

