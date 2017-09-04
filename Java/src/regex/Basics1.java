package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Basics1 {

	public static void main(String[] args) {
		System.out.println(Pattern.matches("geeksforge*ks", "geeksforgeeks"));
		System.out.println(Pattern.matches("g*ks", "geeks"));
		System.out.println(Pattern.quote("name23"));
		
		Pattern p = Pattern.compile("geeks");
		
		Matcher m = p.matcher("geeksforgeeks.orgs");
		
		while(m.find()) {
			System.out.println("Pattern found from indexes "+m.start()+" to "+ m.end());
		}
		
		//Case Insensitive
		
		Pattern p2 = Pattern.compile("ge*",Pattern.CASE_INSENSITIVE);
		
		Matcher m2 = p2.matcher("GeeksforGeeks.org");
		
		while(m2.find()) {
			System.out.println("Pattern found from indexes "+m2.start()+" to "+ m2.end());
		}
		
		//Split
		
		String text = "geeks1for2geeks3" ;
		
		String delimiter = "\\d";
		
		Pattern p3 = Pattern.compile(delimiter,Pattern.CASE_INSENSITIVE);
		
		String[] result = p3.split(text);
		
		for(String s : result) {
			System.out.println(s);
		}
		
	}
}
