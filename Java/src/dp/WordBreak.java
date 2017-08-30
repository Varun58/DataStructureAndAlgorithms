package dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordBreak {

	//does not work yet
	static boolean wordBreak(String str,Set<String> dict) {
		int size = str.length();
		
		if(size == 0) return true;
		
		boolean wb[] = new boolean[size+1];
		
		for(int i=1;i<=size;i++) {
			if(wb[i]== false && dict.contains(str.substring(0, i))) {
				wb[i]=true;
			}
			
			if(wb[i]) {
				if(size == i) return true;
				
				for(int j=i+1;j<=size;j++) {
					
					if(wb[j]== false && i>j-i && dict.contains(str.substring(i, j-i))) {
						wb[j]=true;
					}
					
					if(j==size && wb[j]) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		HashSet<String>  set = new HashSet<String>(Arrays.asList("i","love","ice","cream","do","but"));
		System.out.println(wordBreak("iloveicecream", set));
	}
}
