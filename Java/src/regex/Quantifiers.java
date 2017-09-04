package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Quantifiers {

	/*
	 Quantifiers:
	 
	X*        Zero or more occurrences of X
	X?        Zero or One occurrences of X
	X+        One or More occurrences of X
	X{n}      Exactly n occurrences of X 
	X{n, }    At-least n occurrences of X
	X{n, m}   Count of occurrences of X is from n to m
	*/

	public static void main(String[] args) {

		//Greedy Pattern
		System.out.println("Greedy : " );
		Pattern p = Pattern.compile("g+");
		Matcher m = p.matcher("ggg");
		while (m.find()) {
			System.out.println(m.start() + " to " + m.end());
		}
		
		//Reluctant
		System.out.println("Reluctant : " );
		Pattern p2 = Pattern.compile("g+?");
		Matcher m2 = p2.matcher("ggg");
		while (m2.find()) {
			System.out.println(m2.start() + " to " + m2.end());
		}
		
		//Posessive Quantifier
		System.out.println("Posessive : " );
		Pattern p3 = Pattern.compile("g++");
		Matcher m3 = p3.matcher("ggg");
		while (m3.find()) {
			System.out.println(m3.start() + " to " + m3.end());
		}
		
		// Create a pattern with Greedy quantifier
        Pattern pg = Pattern.compile("g+g");
 
        // Create same pattern with possessive quantifier
        Pattern pp = Pattern.compile("g++g");         
 
        System.out.println("Using Greedy Quantifier");
        Matcher mg = pg.matcher("ggg"); 
        while (mg.find())
            System.out.println("Pattern found from " + mg.start() +
                               " to " + (mg.end()-1)); 
 
        System.out.println("\nUsing Possessive Quantifier");
        Matcher mp = pp.matcher("ggg"); 
        while (mp.find())
            System.out.println("Pattern found from " + mp.start() +
                               " to " + (mp.end()-1)); 
	}
}
