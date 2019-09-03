package DepthFirstSearch;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Node implements SetMap {
	public Character vertex;
	public ArrayList<Node> next;
	public boolean visited;
	public static HashSet<Character> set = null;
	public static HashMap<Character, Node> map = null;
	
	public Node (Character vertex) {
		this.vertex = vertex;
		this.next = null;
		this.visited = false;
	}
	
	public Node addChild(Character vertex) {

		if (set.contains(vertex)) {
			System.out.println("Failed to add an existing node " + vertex + "!");
			return null;
		}
		else {
			set.add(vertex);
			Node node = new Node(vertex);
			map.put(vertex, node);
			if (this.next == null) {
				this.next = new ArrayList<Node>();
			}
			this.next.add(node);
			return node;			
		}
	}

	@Override
	public void getMapList(HashMap<Character, Node> map) {
		this.map = map;
		map.put(vertex, this);
		
	}

	@Override
	public void getSetList(HashSet<Character> set) {
		// TODO Auto-generated method stub
		this.set = set;
		set.add(vertex);
	}
}
