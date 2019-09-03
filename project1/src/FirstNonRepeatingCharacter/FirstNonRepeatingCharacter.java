 package FirstNonRepeatingCharacter;

public class FirstNonRepeatingCharacter {

	public static void main(String[] args) {
		String s = "aDKSEIEIFJaGSAGKDakfjadslkfsdaklfjsakldfjdakfjasldfjaskdfjl;adkfjakdfjadfjaskdfja;dfkjsad;fkasfjdakDWIAbBKCD";
		// String s = a.toLowerCase();
		long start_time = System.currentTimeMillis();
		System.out.println(start_time);
		System.out.println();
		int index = findFirstUniqueCharacter(s);
		long end_time = System.currentTimeMillis();
		if (index == -1) {
			System.out.println("Not found!");
		} else {
			System.out.printf("They first non repeating character is %c .", s.charAt(index));			
		}
		System.out.println();
		System.out.println();
		System.out.println(end_time);
		System.out.println();
		System.out.println(end_time-start_time);
		return;
	}
	public static int findFirstUniqueCharacter(String s) {
		int[] count = new int[128]; 
		
		if (s == null || s.length() == 0) {
			return -1; 
		}
		
		for (int i=0;i<128;i++) {
			count[i] = -1;
		}
		for (int i=0;i<s.length();i++) {
			// int index = s.charAt(i) - 'a';
			int index = s.charAt(i);
			if (count[index] == -1) {
				count[index]  = i;
			} else {
				count[index] = -2;
			}
		}
		int index = -1;
		for (int i=0;i<128;i++) {
			if (count[i] >= 0) {
				if (index == -1) {
					index = count[i];
				}
				else if (count[i] < index) {
					index = count[i];
				}
			}
		}
		return index;
	}

}


