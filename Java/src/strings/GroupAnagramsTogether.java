package strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagramsTogether {

	public List<List<String>> groupAnagrams(String[] strs) {
		if(strs == null | strs.length == 0) {
			return new ArrayList<>();
		}

		// TIME COMPLEXITY : O(NK)
		// SPACE COMPLEXITY: O(NK)
		Map<String, List<String>> ans = new HashMap<>();
		int[] count = new int[26];
		StringBuilder sb = new StringBuilder();
		for(String str: strs) {
			Arrays.fill(count, 0);

			for(int i = 0;i<str.length();i++) {
				count[str.charAt(i) - 'a']++;
			}

			for(int i = 0;i<26;i++) {
				sb.append('#');
				sb.append(count[i]);
			}

			String strValue = sb.toString();
			if(!ans.containsKey(strValue)) {
				ans.put(strValue, new ArrayList<String>());
			}
			ans.get(strValue).add(str);
			sb = new StringBuilder();
		}

		return new ArrayList<>(ans.values());
	}

	// TIME COMPLEXITY : O(NKLOGK)
	// SPACE COMPLEXITY: O(NK)
	public List<List<String>> groupAnagrams2(String[] strs) {
		if(strs == null | strs.length == 0) {
			return new ArrayList<>();
		}

		Map<String, List<String>> ans = new HashMap<>();
		for(String str: strs) {
			char[] ca = str.toCharArray();
			Arrays.sort(ca);
			String strValue = String.valueOf(ca);
			if(!ans.containsKey(strValue)) {
				ans.put(strValue, new ArrayList<String>());
			}
			ans.get(strValue).add(str);
		}

		return new ArrayList<>(ans.values());
	}
	
	//http://www.programcreek.com/2014/04/leetcode-anagrams-java/
	//http://www.geeksforgeeks.org/print-pairs-anagrams-given-array-strings/
	
	//Trie method to be written later
	
	//http://www.geeksforgeeks.org/given-a-sequence-of-words-print-all-anagrams-together-set-2/
	
	/*public static void main(String[] args) {
		char[] m = new char[26];
		m[2]=65;
		m[3]=66;
		m[4]=67;
		
		System.out.println(new String(m));
	}*/
}
