package math;

public class NumberClosestNDivisibleM {

	public static void main(String[] args) {
		System.out.println(closestNumber(13, 4));
		System.out.println(closestNumber(-15, 6));
		System.out.println(closestNumber(0, 8));
		System.out.println(closestNumber(18, -7));
	}

	static int closestNumber(int n, int m) {
		int q = n / m;

		int n1 = m * q;

		int n2 = 0;

		if (m * q > 0) {
			n2 = m * (q + 1);
		} else {
			n2 = m * (q - 1);
		}

		if (Math.abs(n - n1) < Math.abs(n - n2)) {
			return n1;
		}
		return n2;
	}
}
