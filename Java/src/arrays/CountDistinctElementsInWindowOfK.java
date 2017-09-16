package arrays;

import java.util.HashMap;
import java.util.Map;

public class CountDistinctElementsInWindowOfK {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 1, 3, 4, 2, 3 };
		countDistinct(arr, 4);
	}

	public static void countDistinct(int arr[], int k) {

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		int n = arr.length;
		
		for (int i = 0; i < k && i<n; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}
		
		System.out.print(map.size()+" ");

		for (int i = k; i < n; i++) {
			int prev = arr[i-k];
			
			//remove pre element
			if(map.containsKey(prev)) {
				if(map.get(prev)-1==0) {
					map.remove(prev);
				}else {
					map.put(prev,map.get(prev)-1);
				}
			}else {
				
			}
			
			//Add new element
			map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
			
			System.out.print(map.size()+" ");
		}

	}
}
