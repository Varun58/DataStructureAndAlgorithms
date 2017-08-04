package stacks;

import java.util.Stack;

public class PalindromeStringUsingStack {

	public static boolean isPalindrome(String input) {
		if(input == null || input.length()==1 || input.isEmpty())
			return true;
		
		int i=0;
		int j=input.length()-1;
		
		while(i<j) {
			if(input.charAt(i)!=input.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}
	
	public static boolean isPalindromeUsingStack(String input) {
		if(input == null || input.length()==1 || input.isEmpty())
			return true;
		Stack<Character> stack = new Stack<Character>();
		int i=0;
		while(input.charAt(i)!='X') {
			stack.push(input.charAt(i));
			i++;
		}
		i++;
		while(i<input.length()) {
			if(input.charAt(i)!=stack.pop()) {
				return false;
			}
			i++;
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(isPalindrome("ababXbaba"));
		System.out.println(isPalindrome("ababXXbaba"));
		System.out.println(isPalindrome("ababXXXbaba"));
		System.out.println(isPalindrome("ababcXcbaba"));
		System.out.println(isPalindrome("ababcXdbaba"));
		
		System.out.println(isPalindromeUsingStack("ababXbaba"));
		System.out.println(isPalindromeUsingStack("ababXXbaba"));
		System.out.println(isPalindromeUsingStack("ababXXXbaba"));
		System.out.println(isPalindromeUsingStack("ababcXcbaba"));
		System.out.println(isPalindromeUsingStack("ababcXdbaba"));
	}
}
