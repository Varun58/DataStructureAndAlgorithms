package dp;

import java.math.BigInteger;

public class FibonacciSeries {

	public static void main(String[] args) {
		System.out.println(fibonacciN(0));
	}

	public static BigInteger fibonacciN(int n) {

		if (n == 0 || n == 1) {
			return BigInteger.valueOf(n);
		}

		BigInteger a = BigInteger.valueOf(0);
		BigInteger b = BigInteger.valueOf(1);
		
		BigInteger c = BigInteger.valueOf(1);
		
		for (int j = 2; j <= n; j++) {
			c = a.add(b);
			a = b;
			b = c;
		}
		
		return c;
	}
}
