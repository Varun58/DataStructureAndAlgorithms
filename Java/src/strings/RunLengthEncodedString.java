package strings;

public class RunLengthEncodedString {

	public static void main(String[] args) {
		String s = "wwwwwaaadexxxxxx";
		System.out.println(runLengthEncode2(s));

	}

	static String runLengthEncode(String s) {
		if (s == null || s.length() == 0) {
			return s;
		}

		StringBuilder compressed = new StringBuilder("");

		char prevCh = s.charAt(0);
		int count = 1;
		for (int i = 1; i < s.length(); i++) {

			char c = s.charAt(i);

			if (c == prevCh) {
				count++;
			} else {
				compressed.append(prevCh + "" + count);
				prevCh = c;
				count = 1;
			}
		}
		compressed.append(prevCh + "" + count);
		return compressed.toString();
	}

	static String runLengthEncode2(String s) {
		if (s == null || s.length() == 0) {
			return s;
		}

		StringBuilder compressed = new StringBuilder("");

		char prev = s.charAt(0);
		int count = 1;
		for (int i = 1; i < s.length(); i++) {
			while (i < s.length() && s.charAt(i) == prev) {
				count++;
				i++;
			}
			if (i == s.length())
				break;
			compressed.append(prev + "" + count);
			prev = s.charAt(i);
			count = 1;
		}
		compressed.append(prev + "" + count);
		return compressed.toString();
	}
}
