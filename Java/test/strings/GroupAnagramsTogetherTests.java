package strings;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class GroupAnagramsTogetherTests {

	@Test
	public void testGroupingOfAnagramsTogether() {
		String words[] = {
				"cat",
				"god",
				"toe",
				"hat",
				"dog",
				"eot",
				"tah",
				"tac",
				"most",
				"smot",
				
		};
		List<List<String>> result = GroupAnagramsTogether.groupAnagramTogetherUsingSortingAndHashmap(words);
		
		Assert.assertTrue(result.size() == 5);
		
		Assert.assertTrue(result.get(0).size() == 2);
		Assert.assertTrue(result.get(1).size() == 2);
		Assert.assertTrue(result.get(2).size() == 2);
		Assert.assertTrue(result.get(3).size() == 2);
		Assert.assertTrue(result.get(4).size() == 2);
		Assert.assertTrue(result.get(4).size() == 2);
		
		Assert.assertTrue(result.get(0).get(0).equals("toe"));
		Assert.assertTrue(result.get(0).get(1).equals("eot"));
		Assert.assertTrue(result.get(1).get(0).equals("hat"));
		Assert.assertTrue(result.get(1).get(1).equals("tah"));
		Assert.assertTrue(result.get(2).get(0).equals("most"));
		Assert.assertTrue(result.get(2).get(1).equals("smot"));
		Assert.assertTrue(result.get(3).get(0).equals("god"));
		Assert.assertTrue(result.get(3).get(1).equals("dog"));
		Assert.assertTrue(result.get(4).get(0).equals("cat"));
		Assert.assertTrue(result.get(4).get(1).equals("tac"));
		
		result.stream().forEach(System.out::println);
		
	}
}

