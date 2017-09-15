package bits;

import java.math.BigInteger;

public class BinaryRepresentationOfNumber {

	public static void main(String[] args) {
		System.out.println("Using Divide");
		System.out.println(binaryRepUsingDivide(4));
		System.out.println(binaryRepUsingDivide(7));
		System.out.println(binaryRepUsingDivide(23));

		System.out.println("Using Shifting");

		System.out.println(binaryNumberUsingShiftingBits(4));
		System.out.println(binaryNumberUsingShiftingBits(7));
		System.out.println(binaryNumberUsingShiftingBits(23));

		System.out.println("Using Recursive Divide");

		binaryNumberUsingRecursion(4);
		System.out.println();
		binaryNumberUsingRecursion(7);
		System.out.println();
		binaryNumberUsingRecursion(23);
		System.out.println();

		System.out.println("Checking all 31 bits");
		
		checkAll32Bits(4);
		checkAll32Bits(7);
		checkAll32Bits(23);
		checkAll32Bits(1024);
	}

	public static int binaryRepUsingDivide(int n) {

		if (n <= 1) {
			return n;
		}

		StringBuilder sb = new StringBuilder("");

		while (n != 0) {
			sb.append((n % 2));
			n = n / 2;
		}

		if (sb.toString().isEmpty() || sb.toString().length() == 0) {
			return -1;
		}

		return Integer.parseInt(sb.reverse().toString());
	}

	public static int binaryNumberUsingShiftingBits(int n) {
		if (n <= 1) {
			return n;
		}

		StringBuilder sb = new StringBuilder("");

		while (n != 0) {

			if ((n & 1) == 1) {
				sb.append(1);
			} else {
				sb.append(0);
			}

			n = n >> 1;
		}

		if (sb.toString().isEmpty() || sb.toString().length() == 0) {
			return -1;
		}

		return Integer.parseInt(sb.reverse().toString());
	}

	public static void binaryNumberUsingRecursion(int n) {
		if (n > 1) {
			binaryNumberUsingRecursion(n / 2);
		}
		System.out.print(n % 2);
	}

	
	//Check this later
	//not working
	public static void checkAll32Bits(int n) {

		if (n <= 1) {
			System.out.println(n);
		}

		StringBuilder sb = new StringBuilder("");
		
		BigInteger number = new BigInteger(String.valueOf(n));
		BigInteger one = new BigInteger("1");
		one = one.shiftLeft(31);
		
		for (; one.compareTo(new BigInteger("0"))>0; one = one.divide(new BigInteger("2"))) {
			if ((one.and(number)).equals(new BigInteger("1"))) {
				sb.append(1);
			} else {
				sb.append(0);
			}
		}

		if (sb.toString().isEmpty() || sb.toString().length() == 0) {
			System.out.println("-1");
		}

		System.out.println(sb.toString());
		
	}
}
