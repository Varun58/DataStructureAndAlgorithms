package arrays;

import org.junit.Test;

public class MaximumNumberOfGuestsOnOneDayTests {

	@Test
	public void testMaximumNumberOfGuestsOn1Day() {
		int[] checkIn = {
				1,2,10,5,5
		};
		
		int[] checkOut = {
				4,5,12,9,12
		};
		
		int dayHavingMaxGuests = MaximumNumberOfGuestsOnOneDay.getDayHavingMaximumGuests(checkIn, checkOut);
		
		System.out.println("Maximum number of guests there were  on the day " +dayHavingMaxGuests);
		
		//System.out.println(maxDays);
	}
}
