package strings;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class SortWordsOnTheBasisOfLastCharacter {

	public static String[] sortWordsOnLastCharacter(String[]  words) {
		
		Collections.sort(Arrays.asList(words),new LastCharComparator());
		
		return words;
	}
	
	public static void main(String[] args) {
		String result[] = sortWordsOnLastCharacter(new String[] {"Luis","Hector","Selena","Emmanuel","Amish"});
		Arrays.stream(result).forEach(System.out::println);
	}
	
}



class LastCharComparator implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		if(o1.charAt(o1.length()-1)==o2.charAt(0)) {
			return 0;
		}
		else if(o1.charAt(o1.length()-1)<o2.charAt(0)) {
			return -1;
		}else {
			return -1;
		}
	}
	
	//http://www.geeksforgeeks.org/given-array-strings-find-strings-can-chained-form-circle/
	//http://www.geeksforgeeks.org/find-array-strings-can-chained-form-circle-set-2/
	//https://www.careercup.com/question?id=5932349506191360
		
}
