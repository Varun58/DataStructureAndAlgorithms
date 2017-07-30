package strings;

public class RemoveSpacesInAString {

	public static String removeSpacesInString(String str) {
		if ( str == null || str.length() == 0 )
			return str;

		int spaces = 0;

		for (char ch : str.toCharArray()) {
			if (ch == ' ') {
				spaces++;
			}
		}

		int index = str.length() + spaces * 2;

		char[] newStringArr = new char[index];

		for (int i = str.length() - 1; i >= 0; i--) {

			if (str.charAt(i) == ' ') {
				newStringArr[index - 1] = '0';
				newStringArr[index - 2] = '2';
				newStringArr[index - 3] = '%';
				index=index-3;
			} else {
				newStringArr[index - 1] = str.charAt(i);
				index--;
			}
		}

		return new String(newStringArr);
	}
}
