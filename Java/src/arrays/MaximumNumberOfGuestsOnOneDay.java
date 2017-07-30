package arrays;

import java.util.Arrays;

public class MaximumNumberOfGuestsOnOneDay {

	public static int getDayHavingMaximumGuests(int[] checkIn, int[] checkOut) {
		
		if(checkIn ==  null || checkOut ==  null || checkIn.length==0 || checkOut.length == 0) {
			return -1;
		}

		Arrays.sort(checkIn);
		Arrays.sort(checkOut);

		int i = 0, j = 0,count=0,maxDayCount=0 , day=0;
		
		while (i < checkIn.length && j < checkOut.length) {
			if (checkIn[i] <= checkOut[j]) {
				count++;
				if(count>maxDayCount) {
					maxDayCount = count;
					day = checkIn[i];
				}
				i++;
			} else {
				count--;
				j++;
			}
		}
		
	//if(count>0) return count;
		
		return day;
	}
	
	//http://www.geeksforgeeks.org/find-the-point-where-maximum-intervals-overlap/
}
