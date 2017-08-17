package hashing;

import java.util.HashMap;
import java.util.Scanner;

public class BirthdayCakeCandles {


    static int birthdayCakeCandles(int n, int[] ar) {
    	
		HashMap<Integer, Integer> countMap = new HashMap<>();
        int count=0;
        for(int i = 0;i<ar.length;i++){
        	countMap.put(ar[i], countMap.getOrDefault(ar[i], 0) + 1);
        }
        
        for(int i = 0;i<ar.length;i++){
        	if(countMap.get(ar[i])>count){
                count=countMap.get(ar[i]);
            }        	
        }
        
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = birthdayCakeCandles(n, ar);
        System.out.println(result);
    }

}
