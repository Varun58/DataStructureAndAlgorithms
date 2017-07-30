package strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class UniqueCharInStrings {

	//This also covers write a program to find first non repeated character in a string.
	
	public static boolean uniqCharUsingBruteForce(String input) {
		
		if(input == null) return true;
		
		for(int i=0;i<input.length();i++) {
			for(int j=0;j<input.length();j++) {
				if(i!=j && input.charAt(i)==input.charAt(j)) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static boolean uniqCharUsingHashSet(String input) {
		
		if(input == null) return true;
		
		Set<Character> hashSet = new HashSet<Character>();
		
		for(char eachChar: input.toCharArray()) {
			/*if(!hashSet.add(eachChar)) {
				return false;
			}*/
			
			if(!hashSet.contains(eachChar)) {
				hashSet.add(eachChar);
			}else {
				return false;
			}
			
		}
		return true;
	}
	
	public static boolean uniqCharUsingHashMap(String input) {
		
		if(input == null) return true;
		
		Map<Character,Integer> hashMap = new HashMap<Character,Integer>();
		
		for(char eachChar: input.toCharArray()) {
			/*if(!hashSet.add(eachChar)) {
				return false;
			}*/
			
			if(!hashMap.containsKey(eachChar)) {
				hashMap.put(eachChar,1);
			}else {
				hashMap.put(eachChar,hashMap.get(eachChar)+1);
				/*return false;*/
			}
			
		}
		
		for(Entry<Character,Integer> entry : hashMap.entrySet()) {
			if(entry.getValue()>1) {
				return false;
			}
		}
		
		return true;
	}
	
	//Without using Extra Space / Data Structure
	
	public static boolean uniqCharUsingSorting(String input) {
		
		if(input == null) return true;
		
		char[] inputArray = input.toCharArray();
		
 		Arrays.sort(inputArray);
 		
 		for(int i=0;i<inputArray.length-1;i++) {
 			if(inputArray[i]==inputArray[i+1])return false;
 		}
 		
		return true;
	}
	
	
}
