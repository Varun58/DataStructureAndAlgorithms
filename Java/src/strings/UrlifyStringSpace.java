package strings;

public class UrlifyStringSpace {

	public static void main(String[] args) {

		System.out.println(removeSpacesInString("this is a string with spaces.".toCharArray()));

	}

	static String removeSpacesInString(char[] str) {
		if (str == null || str.length == 0)
			return null;

		int spaces = 0;
		int i = 0;
		for (i = 0; i < str.length; i++) {
			if (str[i] == ' ') {
				spaces++;
			}
		}
		while (str[i - 1] == ' ') {
			i--;
			spaces--;
		}

		int index = i + spaces * 2 + 1;

		char[] newStringArr = new char[index];

		for (int j = i - 1; j >= 0; j--) {

			if (str[j] == ' ') {
				newStringArr[index - 1] = '0';
				newStringArr[index - 2] = '2';
				newStringArr[index - 3] = '%';
				index = index - 3;
			} else {
				newStringArr[index - 1] = str[j];
				index--;
			}
		}

		return new String(newStringArr);
	}
}
