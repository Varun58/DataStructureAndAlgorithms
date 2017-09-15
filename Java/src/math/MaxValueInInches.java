package math;

public class MaxValueInInches {

	public static void main(String[] args) {
		Height[] h = new Height[5];
		h[0] = new Height(1, 3);
		h[1] = new Height(10, 5);
		h[2] = new Height(6, 8);
		h[3] = new Height(3, 7);
		h[4] = new Height(5, 9);

		getMaxHeight(h);
	}

	public static int getMaxHeight(Height[] h) {

		Integer maxV = Integer.MIN_VALUE;
		Integer maxI = Integer.MIN_VALUE;

		for (int i = 0; i < h.length; i++) {
			int value = (h[i].feet * 12) + h[i].inches;
			if (maxV < value) {
				maxV = value;
				maxI = i;
			}
		}
		System.out.println(maxV);
		return maxI;
	}
}

class Height {
	public Height(int i, int j) {
		this.feet = i;
		this.inches = j;
	}

	int feet;
	int inches;
}
