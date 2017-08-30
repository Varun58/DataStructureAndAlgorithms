package test;

import java.util.HashMap;
import java.util.Map;

public class CountPrimeOccurences {

	static boolean sieveOfEratosthenes(int n, int x) {
		boolean prime[] = new boolean[n + 1];
		for (int i = 0; i <= n; i++)
			prime[i] = true;

		for (int p = 2; p * p <= n; p++) {
			if (prime[p] == true) {
				for (int i = p * 2; i <= n; i += p)
					prime[i] = false;
			}
		}
		for (int i = 2; i <= n; i++) {
			if (prime[i] == true && i == x)
				return true;
		}
		return false;
	}

	static int getLargestNumberWithPrimeOccurences(int[] inputArray, int minOccurence) {

		if (inputArray == null ||  minOccurence == 0) {
			return -1;
		}

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int maxE = -1;
		int maxC = -1;
		for (int i = 0; i < inputArray.length; i++) {
			if (map.containsKey(inputArray[i])) {
				int count = map.get(inputArray[i]) + 1;
				map.put(inputArray[i], count);
			} else {
				map.put(inputArray[i], 1);
			}
		}

		for (Map.Entry<Integer, Integer> e : map.entrySet()) {
			if (e.getValue() >= minOccurence && sieveOfEratosthenes(e.getValue(), e.getValue())) {
				if (e.getValue() >=maxC && e.getKey()>maxE) {
					maxC = e.getValue();
					maxE = e.getKey();
				}
			}
		}

		if (maxE != -1) {
			return maxE;
		}

		return -1;
	}

	public static void main(String[] args) {
		/*int arr[] = new int[] { 1, 11, 11, 11, 23, 11, 27, 51, 37, 37 };
		System.out.println(getLargestNumberWithPrimeOccurences(arr, 2));*/
		
		int arr2[] = new int[] { 11,11,11,11 ,11 , 31,31,31,31 ,31};
		System.out.println(getLargestNumberWithPrimeOccurences(arr2, 1));
		//|| inputArray.length==0 || inputArray.length==1 || 
		// System.out.println(sieveOfEratosthenes(28, 28));

	}
}
