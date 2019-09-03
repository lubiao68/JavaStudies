package LongestCommonSequence;

import java.util.Hashtable;
import java.util.Map;

public class LongestCommonSequence {

	public static void main(String[] args) {
		//String a ="atJuly@4thOk";
		//String b = "partyJaualay4atahaOaK";
		String a = "bceadsdsdd";
		String b = "abcfbecaada";
				
		findSeq(a,b);
	}

	public static void findSeq(String a, String b) {
		String result = null;
		Map<String, String> memo = new Hashtable<>();
		result = findSeqAll (a, 0, b, 0, memo);
		if (result == null) {
			System.out.printf("The longest common sequence was not found!");
		}
		else {
			System.out.printf("The longest common sequence is : %s.", result);		
		}

	}
	
	
	// This looks like to find the permutation of the elements and compare two Strings.
	// Walk through examples on the paper or white board.  
	// This is a recursive problem. 
	// What happens at each node ?
	// Assumption and clarification: N/A 
	// Input parameters of recursive function: array, index, target.  indexs can be used to break down to small recursive logic and also are used as key for memorization.
	// What's the base cases? Look at a current node or element or level.
	// - Greater than either of the length
	// - Equal between two string and then return. 
	// Each Node (Child)
	// - If two are not equal, need to increment index on either each string and get the longest one to return. 
	// What's the edge cases? Look for any inputs. 
	// DP - How to find what can use DP?  
	// - The input condition and it should be the key. 
	// - The output (return) at the each level (recursive call to child node usually). Here is the DP logic for what to retrieve and save. 
	// - Base case is another place will have DP logic for retrieve and save. 
	public static String findSeqAll (String a, int indexA, String b, int indexB, Map<String, String> memo) {
		String result = null;
		String temp = null;
		String key = null;
		
		if (indexA >= a.length() || indexB >= b.length()) {
			return null;
		}
        // Memorization and return if it's in the hashtable for indexes. 
		key = Integer.toString(indexA) + ":" + Integer.toString(indexB);
		if (memo.containsKey(key)) {
			return memo.get(key);
		}
		
		// If a part of string between two strings are equal then continue on to next character on both strings.
		// If there is no subsequent match then store the local one otherwise store the longer. 
		if (a.substring(indexA, indexA+1).equals(b.substring(indexB, indexB+1))) {
			//  add to the hashtable.
			key = Integer.toString(indexA+1) + ":" + Integer.toString(indexB+1);		
			if (memo.containsKey(key)) {
				return memo.get(key);
			}		
			temp = findSeqAll(a, indexA+1, b, indexB+1, memo);
			if (temp == null) {
				result = a.substring(indexA, indexA+1);		
			}
			else {
				key = Integer.toString(indexA+1) + ":" + Integer.toString(indexB+1);
				result = a.substring(indexA, indexA+1) + temp;		
			}
			memo.put(key, result);
			return result;
		}
		
		// Retrieve both if they are in the hashtable. 
		String A = null;
		String B = null;
		key = Integer.toString(indexA) + ":" + Integer.toString(indexB+1);		
		if (memo.containsKey(key)) {
			A = memo.get(key);
		} else {
			A = findSeqAll(a, indexA, b,indexB+1, memo);	
		}
		key = Integer.toString(indexA+1) + ":" + Integer.toString(indexB);		
		if (memo.containsKey(key)) {
			B = memo.get(key);
		} else {
			B = findSeqAll(a, indexA+1, b,indexB, memo);	
		}
		
		if (A == null && B == null) {
			return null;
		}
		else if (A == null) {
			key = Integer.toString(indexA+1) + ":" + Integer.toString(indexB);
			memo.put(key, B);
			return B;
		}
		else if (B == null) {
			key = Integer.toString(indexA) + ":" + Integer.toString(indexB+1);
			memo.put(key, A);	
			return A;
		}
		else {
			key = Integer.toString(indexA+1) + ":" + Integer.toString(indexB);
			memo.put(key, A);
			key = Integer.toString(indexA) + ":" + Integer.toString(indexB+1);
			memo.put(key, B);
			if (A.length() > B.length() ) {
				return A;
			}
			else {
				return B;
			}		
		}
	}
}

