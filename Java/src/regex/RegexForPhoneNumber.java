package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexForPhoneNumber {

	public static void main(String[] args) {
		System.out.println("Phone number 1234567890 validation result: " + validatePhoneNumber("1234567890"));
		System.out.println("Phone number 123-456-7890 validation result: " + validatePhoneNumber("123-456-7890"));
		System.out.println(
				"Phone number 123-456-7890 x1234 validation result: " + validatePhoneNumber("123-456-7890 x1234"));
		System.out.println(
				"Phone number 123-456-7890 ext1234 validation result: " + validatePhoneNumber("123-456-7890 ext1234"));
		System.out.println("Phone number (123)-456-7890 validation result: " + validatePhoneNumber("(123)-456-7890"));
		System.out.println("Phone number 123.456.7890 validation result: " + validatePhoneNumber("123.456.7890"));
		System.out.println("Phone number 123 456 7890 validation result: " + validatePhoneNumber("123 456 7890"));
		
		System.out.println();
		
		System.out.println("Using Another Pattern : ^(\\\\(\\\\d{3}\\\\)|^\\\\d{3}[.-]?)?\\\\d{3}[.-]?\\\\d{4}$");
		
		System.out.println(checkValidNumber());
	}

	private static boolean validatePhoneNumber(String phoneNo) {
		// validate phone numbers of format "1234567890"
		if (phoneNo.matches("\\d{10}"))
			return true;
		// validating phone number with -, . or spaces
		else if (phoneNo.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}"))
			return true;
		// validating phone number with extension length from 3 to 5
		else if (phoneNo.matches("\\d{3}-\\d{3}-\\d{4}\\s(x|(ext))\\d{3,5}"))
			return true;
		// validating phone number where area code is in braces ()
		else if (phoneNo.matches("\\(\\d{3}\\)-\\d{3}-\\d{4}"))
			return true;
		// return false if nothing matches the input
		else
			return false;

	}
	
	private static boolean checkValidNumber() {
		//For US Phone Number
		//String regexP = " ^(\\(\\d{3}\\)|^\\d{3}[.-]?)?\\d{3}[.-]?\\d{4}$";
		
		//For SG Number
		String regexP = "^[+]?(\\(\\d{2}\\)|\\d{2}[.-]?)\\d{8}$";
		Pattern p = Pattern.compile(regexP);
		Matcher m = p.matcher("+65-12345678");
		
		return m.matches();
	}
}
