package strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagramsTogether {

	
	public static List<List<String>> groupAnagramTogetherUsingSortingAndHashmap(String[]  words){
		
		if(words ==  null || words.length == 0 ) return null;
		
		Map<String,List<String>> anagramMap = new HashMap<String,List<String>>();
		
		for(String word: words) {
			char[] charArr = word.toCharArray();
			/*Arrays.sort(charArr);*/
			char[]  countArr = new char[26];
			
			for(int i = 0;i<charArr.length;i++) {
				countArr[charArr[i]-'a']++;
			}
			
			/*String sortedWord = new String(charArr);*/
			
			String countWord = new String(countArr);
			
			if(anagramMap.containsKey(countWord)) {
				List<String> groups = anagramMap.get(countWord);
				groups.add(word);
				anagramMap.put(countWord, groups);
			}else {
				List<String> group = new ArrayList<String>();
				group.add(word);
				anagramMap.put(countWord, group);
			}
			
			
		}
		
		return new ArrayList<List<String>>(anagramMap.values());
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
