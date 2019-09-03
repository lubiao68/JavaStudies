package Facebook;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Runways {

	public static void main (String[] args) {
		String[] bannedWords= {"bad", "strange"};
		String paragraph = "The strange string # is a way to strange  strange express someone's bad feeling and is a must.";
		Set<String> bannedSet = new HashSet<>(); 
		Map<String, Integer> unbannedSet = new LinkedHashMap<>();
		
		System.out.println("Original sentence is:");
		System.out.println(paragraph);
		for (String word: bannedWords) {
			bannedSet.add(word);
		}
		for (String word: paragraph.replaceAll("[^a-zA-Z'.]", " ").toLowerCase().split(" ")) {
			if (!bannedSet.contains(word)){
				unbannedSet.put(word, unbannedSet.getOrDefault(word,0)+1);
			}
		}
		System.out.println();
		System.out.println ("Original sentence without banned word is: ");
		String result = "";
		for (String word:unbannedSet.keySet()) {
			System.out.print(word + " ");
			if (result.equals("") || unbannedSet.get(word) > unbannedSet.get(result)) {
				result = word;
			}
		}
		System.out.println();		
		System.out.println();
		System.out.println("Most popular word is: " + result);
	    // System.out.println(run_ways("3828382"));
	}

	public static int run_ways (String data) {
	
		// Base case
		// Take tbe first two digits and see if there are two path
		//Break up data

		int len = data.length();
	
		int value = Integer.parseInt(data);
	
	
		if (len > 2 || value > 26)
			return 1;
		else {
			return 2;
		}
	}
}


