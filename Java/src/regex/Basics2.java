package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Basics2 {

	/*
	 Construct	Description
	.	Any character (may or may not match line terminators)
	\d	A digit: [0-9]
	\D	A non-digit: [^0-9]
	\s	A whitespace character: [ \t\n\x0B\f\r]
	\S	A non-whitespace character: [^\s]
	\w	A word character: [a-zA-Z_0-9]
	\W	A non-word character: [^\w]
	*/
	
	/*
	 Boundary Construct	Description
	^	The beginning of a line
	$	The end of a line
	\b	A word boundary
	\B	A non-word boundary
	\A	The beginning of the input
	\G	The end of the previous match
	\Z	The end of the input but for the final terminator, if any
	\z	The end of the input
	*/
	
	/*
	Construct	Description
	[abc]	a, b, or c (simple class)
	[^abc]	Any character except a, b, or c (negation)
	[a-zA-Z]	a through z, or A through Z, inclusive (range)
	[a-d[m-p]]	a through d, or m through p: [a-dm-p] (union)
	[a-z&&[def]]	d, e, or f (intersection)
	[a-z&&[^bc]]	a through z, except for b and c: [ad-z] (subtraction)
	[a-z&&[^m-p]]	a through z, and not m through p: [a-lq-z] (subtraction)
	*/
	
	//https://docs.oracle.com/javase/tutorial/essential/regex/index.html
	//http://www.geeksforgeeks.org/regular-expressions-in-java/
	
	public static void main(String[] args) {
		
		
		//extract numbers from a string
		Pattern p = Pattern.compile("\\d+");
		Matcher m = p.matcher("This232String553Includes093NumbersAtV2ariousPositions44"); 
		while (m.find()) {
		 System.out.println(Integer.parseInt(m.group()));
		}	
		
		//3 different ways to enter a new line character
		/*
		\r represents CR (Carriage Return), which is used in Unix
		\n means LF (Line Feed), used in Mac OS
		\r\n means CR + LF, used in Windows
		
		String.split("[\\r\\n]+")
		*/
		
		//Escape constructs Pattern, like "$5". Instead of writing \\$5 or [$]5
		
		//Removing Spaces
		String line = "                aa bbbbb   ccc     d  ";
		// " aa bbbbb ccc d "
		System.out.println(line.replaceAll("[\\s]+", " "));

		
	}
}
