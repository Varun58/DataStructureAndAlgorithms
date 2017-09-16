package math;

public class NumberIsPowerOf2 {

	public static void main(String[] args) {
		System.out.println(powerOfTwo(8));
		System.out.println(powerOfTwoByDividing(4));
		System.out.println(powerOfTwo(75));
		System.out.println(powerOfTwoByDividing(223));
		System.out.println(powerOfTwoByDividing(256));
	}

	static boolean powerOfTwo(int n) {
		return n != 0 && (n & n - 1) == 0;
	}

	static boolean powerOfTwoByDividing(int n) {
		if (n == 0 ) {
			return false;
		}

		while (n != 1) {
			if (n % 2 != 0) {
				return false;
			}
			n = n / 2;
		}
		return true;
	}

}
