package strings;

import org.junit.Assert;
import org.junit.Test;

import strings.BalancedParanthesis;

public class BalancedParenthesisTests {

	@Test
	public void testBalancedParenthesis() {
		Assert.assertTrue(BalancedParanthesis.balancedParenthesis(""));
		Assert.assertTrue(BalancedParanthesis.balancedParenthesis(null));
	}
	
	@Test
	public void testBalancedParenthesisForNegativeCases() {
		Assert.assertFalse(BalancedParanthesis.balancedParenthesis("["));
		Assert.assertFalse(BalancedParanthesis.balancedParenthesis("]"));
		Assert.assertFalse(BalancedParanthesis.balancedParenthesis(")"));
		Assert.assertFalse(BalancedParanthesis.balancedParenthesis("{"));
		Assert.assertFalse(BalancedParanthesis.balancedParenthesis("}"));
		Assert.assertFalse(BalancedParanthesis.balancedParenthesis("[{(}]"));
		Assert.assertFalse(BalancedParanthesis.balancedParenthesis("{[}]"));
	}
	
	@Test
	public void testBalancedParenthesisWithAlphabetsInBetween() {
		Assert.assertTrue(BalancedParanthesis.balancedParenthesis("a(bcd)d"));
		Assert.assertFalse(BalancedParanthesis.balancedParenthesis("(kjds(hfkj)sdhf"));
		Assert.assertFalse(BalancedParanthesis.balancedParenthesis("(sfdsf)(fsfsf"));
		Assert.assertFalse(BalancedParanthesis.balancedParenthesis("(kjds(hfkj)sdhf"));
	}
	
	@Test
	public void testBalancedParenthesisWithValidCases() {
		Assert.assertTrue(BalancedParanthesis.balancedParenthesis("()"));
		Assert.assertTrue(BalancedParanthesis.balancedParenthesis("({})"));
		Assert.assertTrue(BalancedParanthesis.balancedParenthesis("[{()}]"));
		Assert.assertTrue(BalancedParanthesis.balancedParenthesis("{[]}()"));
	}
}
