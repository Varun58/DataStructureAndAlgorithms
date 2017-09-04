package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexForPassword {

	// http://www.mkyong.com/regular-expressions/how-to-validate-password-with-regular-expression/
	
	//http://www.java2novice.com/java-collections-and-util/regex/

	public static boolean validate(final String password) {
		Pattern pattern;
		Matcher matcher;

		final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
		pattern = Pattern.compile(PASSWORD_PATTERN);
		matcher = pattern.matcher(password);
		return matcher.matches();

	}
	

	public static boolean validateUser(final String password) {
		Pattern pattern;
		Matcher matcher;

		final String PASSWORD_PATTERN = "^[a-z0-9_-]{3,15}$";
		pattern = Pattern.compile(PASSWORD_PATTERN);
		matcher = pattern.matcher(password);
		return matcher.matches();

	}

	public static void main(String[] args) {
		boolean valid = validate("mkyong1A@");
		System.out.println("Password is valid : " + "mkyong1A@" + " , " + valid);
		
		boolean valid2 = validateUser("mk3-4_yong");
		System.out.println("User is valid : " + "mk3-4_yong@" + " , " + valid2);
	}
}
