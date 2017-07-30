package strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateCharFromString {

	public static String removeDuplicateCharUsingBruteForce(String str) {

		if (str == null || str.isEmpty())
			return str;

		char[] uniqueStr = new char[str.length()];
		int index = 0;
		uniqueStr[index]=str.charAt(0);
		boolean duplicate = false;
		for (int i = 1; i < str.length(); i++) {
			for (int j = 0; j <= index; j++) {
				if (str.charAt(i) == uniqueStr[j] && i != j) {
					duplicate=true;
				}
				
			}
			if(!duplicate) {
				index++;
				uniqueStr[index] = str.charAt(i);
			}
			duplicate = false;
		}
		return (new String(uniqueStr)).trim();
	}
	
	//Unique String returned is not in original order , it is sorted
	public static String removeDuplicateCharUsingBooleanArray(String str) {

		if (str == null || str.isEmpty())
			return str;

		boolean presence[] = new boolean[128];
		char[] uniqueStr = new char[str.length()];
		
		for(char c: str.toCharArray()) {
			presence[c]=true;
		}
		int count=0;

		for(int i=0;i< presence.length;i++) {
			if(presence[i]) {
				uniqueStr[count++]=(char) i;
			}
		}
		
		return (new String(uniqueStr)).trim();
	}
	
	
	public static String removeDuplicateCharUsingHashSet(String str) {

		if (str == null || str.isEmpty())
			return str;

		Set<Character> hashSet = new HashSet<Character>();
		
		char[] uniqueStr = new char[str.length()];
		int count =0;
		for(char c: str.toCharArray()) {
			if(hashSet.add(c)) {
				uniqueStr[count++]=c;				
			}
		}
		return (new String(uniqueStr)).trim();
	}
	
	public static String removeDuplicateCharUsingSorting(String str) {

		if (str == null || str.isEmpty())
			return str;

		char[] sortedArr = str.toCharArray();
		
		char[] uniqueArr = new char[str.length()];		
		
		Arrays.sort(sortedArr);
		
		int count =0;
		
		for(int i=0;i<sortedArr.length-1;i++) {
			if(sortedArr[i]!=sortedArr[i+1]) {
				uniqueArr[count++]=sortedArr[i];				
			}
		}
		uniqueArr[count++]=sortedArr[sortedArr.length-1];
		return (new String(uniqueArr)).trim();
	}
}
