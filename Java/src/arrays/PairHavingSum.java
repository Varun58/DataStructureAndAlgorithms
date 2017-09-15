package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PairHavingSum {

	public static void main(String[] args) {
		int arr[] = { 3, 2, 1, 4, 6, 7, 12, 8, 5, 9 };
		System.out.println(pairHavingSum(arr, 11));
		
		System.out.println("Using Sorting Approach : ");
		pairHavingSumUsingSorting(arr, 11);
		
		System.out.println("Using Two Loops Approach : ");
		pairHavingSumUsingTwoLoops(arr, 11);
	}

	public static void pairHavingSumUsingTwoLoops(int[] arr, int sum) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] + arr[j] == sum) {
					System.out.println(arr[i] + " , " + arr[j]);
				}
			}
		}
	}

	public static void pairHavingSumUsingSorting(int[] arr, int sum) {
		Arrays.sort(arr);

		int i = 0;
		int j = arr.length - 1;
		while (i < j) {
			if (arr[i] + arr[j] == sum) {
				System.out.println(arr[i] + " , " + arr[j]);
				i++;
				j++;
			} else if (arr[i] + arr[j] > sum) {
				j--;
			} else {
				i++;
			}
		}
	}

	public static Map<Integer, Integer> pairHavingSum(int[] arr, int sum) {

		if (arr == null || arr.length == 0 || sum == 0)
			return null;

		Set<Integer> set = new HashSet<Integer>();

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int value : arr) {
			set.add(value);
		}

		for (int value : arr) {
			if (set.contains(sum - value)) {
				if (!(map.containsKey(value) || map.containsKey(sum - value)))
					map.put(value, sum - value);
			}
		}

		return map;
	}

}
