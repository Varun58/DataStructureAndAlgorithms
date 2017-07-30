package strings;

import org.junit.Test;

import junit.framework.Assert;

public class RemoveSpacesInAStringTests {

	@Test
	public void testRemoveSpacesInString() {
		Assert.assertEquals("this%20is%20a%20string%20with%20spaces.", RemoveSpacesInAString
				.removeSpacesInString("this is a string with spaces."));
		
		Assert.assertEquals("With%20Great%20Power%20comes%20great%20Responsibility.", RemoveSpacesInAString
				.removeSpacesInString("With Great Power comes great Responsibility."));
		
		Assert.assertEquals("", RemoveSpacesInAString.removeSpacesInString(""));
		
		Assert.assertEquals(null, RemoveSpacesInAString.removeSpacesInString(null));
	}
}
