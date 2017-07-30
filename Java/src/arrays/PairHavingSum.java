package arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PairHavingSum {
	
	public static Map<Integer,Integer> pairHavingSum(int[] arr,int sum){
		
		if(arr == null || arr.length==0 || sum==0) return null;
		
		Set<Integer> set = new HashSet<Integer>();
		
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		
		for(int value : arr) {
			set.add(value);
		}
		
		for(int value : arr) {
			if(set.contains(sum-value)) {
				if(!(map.containsKey(value) || map.containsKey(sum-value)))
				map.put(value, sum-value);
			}
		}
		
		return map;
	}

}
