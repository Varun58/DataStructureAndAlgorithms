package math;

public class PositionOfOnlySetBit {

	public static void main(String[] args) {
		System.out.print(positionOfSetBit(8)+" ");
		System.out.print(positionOfSetBit(16)+" ");
		System.out.print(positionOfSetBit(128)+" ");
		System.out.print(positionOfSetBit(1024)+" ");

		System.out.print(positionOfSetBit(102)+" ");
		System.out.print(positionOfSetBit(14)+" ");

		System.out.println();
		System.out.print(positionOfSetBitByShiftingNumber(8)+" ");
		System.out.print(positionOfSetBitByShiftingNumber(16)+" ");
		System.out.print(f(128)+1+" "); //Using log fn
		System.out.print(positionOfSetBitByShiftingNumber(1024)+" ");

		System.out.print(positionOfSetBitByShiftingNumber(102)+" ");
		System.out.print(positionOfSetBitByShiftingNumber(14)+" ");

	}

	// Only Set bit is when number is multiple of 2

	static int positionOfSetBit(int n) {
		if ((n & n - 1) != 0) {
			return -1;
		}

		int i = 1;
		int pos = 1;
		while ((n & i) == 0) {
			i = i << 1;
			pos++;
		}
		return pos;
	}

	static int positionOfSetBitByShiftingNumber(int n) {
		if ((n & n - 1) != 0) {
			return -1;
		}

		int pos = 0;
		
		while (n != 0) {
			n = n >> 1;
			pos++;
		}
		return pos;
	}
	
	static int f(int n) {
			return (n > 1)? 1 + f(n/2): 0;
	}
}
