package strings;

import org.junit.Assert;
import org.junit.Test;

public class SortHotelIdsByReviewsContainingWordsTests {

	@Test
	public void testSortHotelIdsByReviewsContainingWords() {
		
		int[] hotelIds = {
				691,
				489,
				751,
				213,
				356,
				850
		};
		
		String[] reviews = {
				"was bad",
				"good is good is good pleasant",
				"awesome is fun",
				"ok is normal but fine",
				"happy is good today but awesome tomorrow",
				"fine be ok good to be happy"
		};
		
		String[] words = {
				"good",
				"pleasant",
				"awesome",
				"ok",
				"fine",
				"happy"
		};
		
		int sortedIds[] = SortHotelIdsByReviewsContainingWords.getHotelIdsSortedByReviewsHavingCountOfMatchingWords(hotelIds, reviews, words);
		
		//850=4, 356=3, 213=2, 489=4, 751=1, 691=0
		int expectedIds[] = {850,489, 356, 213 , 751, 691};
		
		
		
		Assert.assertArrayEquals(expectedIds, sortedIds);
		
	}
}
