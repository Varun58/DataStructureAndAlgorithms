package arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IntersectionOfThreeArrays {

	public static List<Integer> getIntersectionOf3SortedArraysUsingSingleLoop(int[] arr1, int[] arr2, int[] arr3) {

		if ((arr1 == null || arr1.length == 0) || (arr2 == null || arr2.length == 0)
				|| (arr3 == null || arr3.length == 0))
			return null;

		List<Integer> common = new ArrayList<Integer>();

		int i = 0, j = 0, k = 0, count = 0;

		while (i < arr1.length && j < arr2.length && k < arr3.length) {

			if (arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
				common.add(arr1[i]);
				i++;
				j++;
				k++;
			}

			else if (arr1[i] < arr2[j] && arr1[i] < arr3[k]) {
				i++;
			}

			else if (arr1[i] > arr2[j] && arr2[j] < arr3[k]) {
				j++;
			} else {
				k++;
			}
		}
		return common;
	}

	public static Set<Integer> getIntersectionOf3UnSortedArraysUsingHashSet(int[] arr1, int[] arr2, int[] arr3) {

		if ((arr1 == null || arr1.length == 0) || (arr2 == null || arr2.length == 0)
				|| (arr3 == null || arr3.length == 0))
			return null;

		HashSet<Integer> commonInTwo = new HashSet<Integer>();

		List<Integer> common = new ArrayList<Integer>();

		for (int x : arr2) {
			commonInTwo.add(x);
		}

		for (int y : arr1) {
			if (commonInTwo.contains(y)) {
				common.add(y);
			}
		}

		commonInTwo.clear();

		for (int x : arr3) {
			commonInTwo.add(x);
		}

		HashSet<Integer> commonInAll = new HashSet<Integer>();

		for (int y : common) {
			if (commonInTwo.contains(y)) {
				commonInAll.add(y);
			}
		}

		return commonInAll;
	}

	public static List<Integer> getExactlyCommonElementsIn2ArrayFrom3SortedArraysUsingSingleLoop(int[] arr1, int[] arr2, int[] arr3) {

		if ((arr1 == null || arr1.length == 0) || (arr2 == null || arr2.length == 0)
				|| (arr3 == null || arr3.length == 0))
			return null;

		List<Integer> common = new ArrayList<Integer>();

		int i = 0, j = 0, k = 0;

		while (i < arr1.length && j < arr2.length && k < arr3.length) {

			if (!(arr1[i] == arr2[j] && arr2[j] == arr3[k])){
				
				if(arr1[i] == arr2[j])
				{
				
					i++;
					j++;
					common.add(arr1[i]);
				}
				if(arr2[j] == arr3[k])
				{
					common.add(arr2[j]);
					j++;
					k++;
				}
					
				if(arr3[k] == arr1[i])
				{
					common.add(arr3[k]);
					i++;
					k++;
				}
			}
			if ((arr1[i] == arr2[j] && arr2[j] == arr3[k])){
				i++;
				j++;
				k++;
			}
			else if (arr1[i] < arr2[j] && arr1[i] < arr3[k]) {
				i++;
			}

			else if (arr1[i] > arr2[j] && arr2[j] < arr3[k]) {
				j++;
			} else {
				k++;
			}
		}
		return common;
	}

}
