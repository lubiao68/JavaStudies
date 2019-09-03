package RemoveString;

import java.util.*;
import java.lang.*;
import java.io.*;

public class RemoveString {

	public static void main(String[] args) {
		String s1, s2;
		StringBuffer temp = new StringBuffer();
		String p = null;
		
		Set set = new HashSet();
				
		Scanner in = new Scanner(System.in);
		
		System.out.println("Please enter the first string: ");
		s1 = in.nextLine();
		
		System.out.println("Please enter the second string: ");
		s2=in.nextLine();
		
		if (s2.length() >= s1.length()) {
			System.out.println("The second string should be less than the first string!");
		}
		for (int i=0;i<s2.length();i++) {
			set.add(s2.charAt(i));
		}

		for (int i=0; i<s1.length(); i++) {
			if (set.contains(s1.charAt(i))) {
				continue;
			}
			temp.append(s1.charAt(i));
		}
		System.out.println(temp);
	}
}

