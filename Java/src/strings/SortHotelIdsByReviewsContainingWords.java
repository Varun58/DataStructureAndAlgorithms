package strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SortHotelIdsByReviewsContainingWords {

	public static int[] getHotelIdsSortedByReviewsHavingCountOfMatchingWords(int[] ids,String[] reviews , String[] words) {
		
		Map<Integer,String> hotelReviewMap = new HashMap<Integer,String>();
		
		Set<String> wordsList = new HashSet<String>(Arrays.asList(words));
 		
		int count=0;
		
		for(int hId:ids) {
			hotelReviewMap.put(hId, reviews[count++]);
		}
		
		Map<Integer,Long> hotelCountMap = new HashMap<Integer,Long>();
		
		hotelReviewMap.forEach((k,v)->{
			
			// Arrays.asList(v.split(" ")).forEach(System.out::println);
			
			long occurs = 	 Arrays.asList(v.split(" ")).stream()
												.filter(x-> wordsList.contains(x))
												//.distinct()
												.count();
			System.out.println(" id " + k+ " has occurence "+occurs);
			hotelCountMap.put(k,occurs);
		});
		
		
		ArrayList<Map.Entry<Integer,Long>> myList = new ArrayList<Map.Entry<Integer,Long>>(hotelCountMap.entrySet());
		
		Collections.sort(myList,new Comparator<Map.Entry<Integer,Long>>(){

			@Override
			public int compare(Entry<Integer, Long> arg0, Entry<Integer, Long> arg1) {
				return arg1.getValue().compareTo(arg0.getValue());
			}
			
		});
		
		int result[]= new int[myList.size()];
		int j=0;
		for(Map.Entry<Integer,Long> e : myList ) {
			result[j++]=e.getKey();
		}
		
		return result;
	}
}

class Hotel{
	
}
