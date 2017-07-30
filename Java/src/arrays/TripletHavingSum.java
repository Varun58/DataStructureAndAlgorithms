package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TripletHavingSum {

	// Solution works but no way to find the duplicate triplets , Check the solution
	// using sorting and 2 pointer
	public static void getTripletHavingGivenSum(int arr[], int sum) {
		if (arr == null || arr.length == 0 || arr.length < 3) {
			return;
		}

		Set<Integer> set = new HashSet<Integer>();

		for (int value : arr) {
			set.add(value);
		}

		Map<Integer, HashSet<Integer>> resultMap = new HashMap<Integer, HashSet<Integer>>();

		for (int i = 0; i < arr.length; i++) {
			int tempSum = sum - arr[i];
			for (int j = i + 1; j < arr.length; j++) {
				if (set.contains(tempSum - arr[j]) && j != i) {

					/*
					 * if(!(resultMap.containsKey(arr[j]) || resultMap.containsKey(tempSum-arr[j]) )
					 * && (tempSum-arr[j] != arr[j])) { HashSet<Integer> resultSet =new
					 * HashSet<Integer>();
					 * 
					 * resultSet.add(arr[i]); resultSet.add(arr[j]); resultSet.add(tempSum -
					 * arr[j]);
					 * 
					 * resultMap.put(arr[i],resultSet);
					 */

					System.out.println(arr[i] + "," + arr[j] + "," + (tempSum - arr[j]));
				}

			}
		}
	}

	// Solution works but no way to find the duplicate triplets , Check the solution
	// using sorting and 2 pointer
	public static List<HashSet<Integer>> getTripletHavingGivenSumUsingSortingAndTwoPointer(int arr[], int sum) {
		
		if (arr == null || arr.length == 0 || arr.length < 3) {
			return null;
		}

		Arrays.sort(arr);
		
		List<HashSet<Integer>> resultSet = new ArrayList<HashSet<Integer>>();

		for (int i = 0; i < arr.length; i++) {
			int tempSum = sum - arr[i];
			int j = i + 1;
			int k = arr.length - 1;
			while (j < k) {
				if (arr[j] + arr[k] == tempSum) {
					System.out.println(arr[i] + "," + arr[j] + "," + arr[k]);
					HashSet<Integer> set = new HashSet<Integer>(Arrays.asList(arr[i],arr[j],arr[k]));
					/*Set<Integer> set = new HashSet<Integer>() {{
						add(arr[i]);
						add(arr[j]);
						add(arr[k]);
					}};*/
					resultSet.add(set);
					k--;
					j++;
				} else if (arr[j] + arr[k] > tempSum) {
					k--;
				} else if (arr[j] + arr[k] < tempSum) {
					j++;
				}
			}
		}
		return resultSet;
	}

	//http://www.geeksforgeeks.org/find-a-triplet-that-sum-to-a-given-value/
	
	/*public static void main(String[] args) {
		int[] arr = { 3, 5, 8, 10, 2, 1, 7 };
		TripletHavingSum.getTripletHavingGivenSum(arr, 15);
	}*/
}
