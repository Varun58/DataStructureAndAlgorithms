package bits;

public class EvaluateBooleanExpressionRepAsString {

	public static void main(String[] args) {
		String s = "1C1B1B0A0";
		System.out.println(evaluate(new StringBuffer(s)));
	}

	//Skip 2 characters
	// or Use a HashMap
	public static char evaluate(StringBuffer sb) {
		int n = sb.length();

		for (int i = 0; i < n; i += 2) {

			if (i + 1 < n && i + 2 < n) {
				if (sb.charAt(i + 1) == 'A') {
					if (sb.charAt(i) == '0' || sb.charAt(i + 2) == '0') {
						sb.setCharAt(i + 2, '0');
					} else {
						sb.setCharAt(i + 2, '0');
					}
				} else if (sb.charAt(i + 1) == 'B') {
					if (sb.charAt(i) == '1' || sb.charAt(i + 2) == '1') {
						sb.setCharAt(i + 2, '1');
					} else {
						sb.setCharAt(i + 2, '0');
					}
				} else {
					if (sb.charAt(i) == sb.charAt(i + 2)) {
						sb.setCharAt(i + 2, '0');
					} else {
						sb.setCharAt(i + 2, '1');
					}
				}
			}
		}

		return sb.charAt(n - 1);
	}
}
