package math;

public class CountNumberOfSetBits {

	public static void main(String[] args) {
		System.out.print(count(9) + " ");
		System.out.print(count(256) + " ");
		System.out.print(count(4096) + " ");
		System.out.print(count(23) + " ");
		System.out.print(count(7) + " ");

		System.out.println();

		System.out.print(countUsingBrianKernMethod(9) + " ");
		System.out.print(countUsingBrianKernMethod(256) + " ");
		System.out.print(countUsingBrianKernMethod(4096) + " ");
		System.out.print(countUsingBrianKernMethod(23) + " ");
		System.out.print(countUsingBrianKernMethod(7) + " ");
	}

	static int count(int n) {
		int count = 0;
		while (n != 0) {
			count += n & 1;
			n = n >> 1;
		}
		return count;
	}

	// Brian Kerningham Method n&n-1
	static int countUsingBrianKernMethod(int n) {
		int count = 0;
		while (n != 0) {
			n &= n - 1;
			count++;
		}
		return count;
	}
}
