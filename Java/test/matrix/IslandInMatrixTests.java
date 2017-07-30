package matrix;

import org.junit.Assert;
import org.junit.Test;

public class IslandInMatrixTests {

	@Test
	public void testIslandIsFound() {
		
		int M[][]= new int[][] {{1, 1, 0, 0, 0},
			{0, 1, 0, 0, 1},
			{1, 0, 0, 1, 1},
			{0, 0, 0, 0, 0},
			{1, 0, 1, 0, 1}
			};
		Assert.assertTrue(IslandInMatrix.countNumberOfIslands(M)==5);
		Assert.assertTrue(IslandInMatrix.countNumberOfIslands(null)==0);
	}
}
