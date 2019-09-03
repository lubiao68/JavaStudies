package MatchingParenthesis;

import java.util.Stack;

public class MatchingParenthesis {

	public static void main(String[] args) {
		String s = "{[aidfiasfdio]((d)s)add{()}}";
		Stack<Character> stack = new Stack<>();
		
		for (char e:s.toCharArray()) {
			if (e == '{' || e == '(' || e == '[') {
				stack.push(e);
			}
			else {
				if (stack.isEmpty()) {
					System.out.println("Not matching at " + s.indexOf(s));
					return;
				}
				if (e != '}' && e != ']' &&  e != ')') {
					continue;
				} else	if (e=='}' && stack.peek() != '{' ||
							e==')' && stack.peek() != '(' ||
							e==']' && stack.peek() != '[') {
					System.out.println("Not matching at " + s.indexOf(e));
				}
				else {
					stack.pop();
				}	
				/*		
				switch (e) {
					case '}':  if (stack.peek() != '{') {
									System.out.println("Not matching at " + s.indexOf(e));
								}
								else {
									stack.pop();
								}
							    break;
					case ']':  if (stack.peek() != '[') {
							        System.out.println("Not matching at " + s.indexOf(e)); 
								}
								else {
										stack.pop();
								}
								break;   
					   
					case ')':  if (stack.peek() != '(') {
							        System.out.println("Not matching at " + s.indexOf(e)); 
								}
								else {
							        stack.pop();
								}
						 	    break;
					default:
						continue;
				}
				*/
			}
		}
		System.out.println("Matching parenthesis!");
		return;
	}
}

