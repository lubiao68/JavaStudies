package SerializeDeSerializeTree;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class SerializeDeSerializeTree {

	public static void main(String[] args) {
			
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
			
			String s = serializeTree(a);
		    System.out.println(s);
		    Node node =deserializeTree(s);
		    s = serializeTree(node);
		    System.out.println(s);
		}
		
		
		public static String serializeTree(Node node) {
			if (node == null) {
				return "X";
			}
			return Integer.toString(node.val) + ',' + serializeTree(node.left) + ',' + serializeTree(node.right);
		}


		public static Node deserializeTree(String s) {
			Queue<String> q = new LinkedList<>();			
			q.addAll(Arrays.asList(s.split(",")));
			return deserializeTreeHelp(q);
		}

		
		public static Node deserializeTreeHelp(Queue<String> q) {
			String s = "";
			if (!q.isEmpty()) {
				s = q.poll();
				if (s.contentEquals("X")) {
					return null;
				}
				Node node = new Node(Integer.valueOf(s));
				node.left = deserializeTreeHelp(q);
				node.right = deserializeTreeHelp(q);
				return node;  
			}
			return null;
		}

}


