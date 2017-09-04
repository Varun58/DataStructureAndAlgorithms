package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexForIPValidation {

	//http://www.mkyong.com/regular-expressions/how-to-validate-ip-address-with-regular-expression/?utm_source=mkyong&utm_medium=author&utm_campaign=related-post&utm_content=4
	
	public static boolean isValidIP(String ipAddr) {

		 /*String IPADDRESS_PATTERN =
					"^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
					"([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
					"([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
					"([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";*/
		 String IPADDRESS_PATTERN2 =
					"^([01]?[0-9][0-9]?|2[0-4][0-9]|25[0-5])\\." +
					"([01]?[0-9][0-9]?|2[0-4][0-9]|25[0-5])\\." +
					"([01]?[0-9][0-9]?|2[0-4][0-9]|25[0-5])\\." +
					"([01]?[0-9][0-9]?|2[0-4][0-9]|25[0-5])$";
		// Wrong -->String pattern = "^(\\\\d[0-255]{1,3})\\\\.(\\\\d{1,3})\\\\.(\\\\d{1,3})\\\\.(\\\\d{1,3})$";
		Pattern ptn = Pattern.compile(IPADDRESS_PATTERN2);
		Matcher mtch = ptn.matcher(ipAddr);
		return mtch.find();
	}

	public static void main(String a[]) {
		System.out.println("255.23.45.12 is valid? " + isValidIP("255.222.45.12"));
		System.out.println("15.23.45.12 is valid? " + isValidIP("15.23.45.12"));
		System.out.println("10.2a.56.32 is valid? " + isValidIP("10.2a.56.32"));
		System.out.println("10.23.45 is valid? " + isValidIP("10.23.45"));
	}
}
