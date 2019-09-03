package ReverseAStringofWords;

public class ReversedAStringofWords {

	public static void main(String[] args) {
		String str = "This is a test question, please answer it.";

		System.out.println("Original String: " + str);

		     //recursive method to reverse String in Java

		String reversedString = reverseRecursively(str);

		System.out.println("Reversed by using Recursion: " +reversedString);

		}

	    // Reverse every word and also swap , & .
		public static String reverseRecursively(String str) {

			//base case to handle one char string and empty string

			if (str.length() < 2) {
				return str;
			}
			for (char c: str.toCharArray()) {
				if (c == '.' || c == ',') {
					String temp = swapEnd(str.substring(0, str.indexOf(c)+1), c);
					int index = str.indexOf(c);
                	return reverseRecursively((str.substring(index+1))) + " " + temp;
				}
				if (c == ' ') {
					int index = str.indexOf(c);
					return reverseRecursively((str.substring(index+1))) + " " + str.substring(0, index);
				}
				
			}
			return str;
		}
	
		public static String swapEnd(String s, char c) {
			
			if (s.charAt(s.length()-1) == c) {
				return s.charAt(s.length()-1) + s.substring(0,s.length()-1);
			}
			return s;
		}

		/* Reverse every character of the String 
		public static String reverseRecursively(String str) {

		//base case to handle one char string and empty string

			if (str.length() < 2) {

				return str;
			}
			
			return reverseRecursively(str.substring(1)) + str.charAt(0);
		}
		*/
}

