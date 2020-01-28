package arrays;

public class MissingNumberInArray {

	public static void main(String[] args) {

		int arr[] = { 1, 2, 4, 6, 3, 7, 8 };
		
		System.out.println("Using Sum Property :");
		System.out.println(missingNumberUsingSum(arr));
		
		System.out.println("Using XOR :");
		System.out.println(missingNumberUsingXOR(arr));
	}

	static int missingNumberUsingSum(int arr[]) {
		int n = arr.length + 1;
		int actSum = (n * (n + 1)) / 2;
		
		int arrSum = 0;
		for (int i = 0; i < arr.length; i++) {
			arrSum += arr[i];
		}
		return actSum - arrSum;
	}

	// better solution for XOR
	public int missingNumber(int[] nums) {
		int expectedNum  = nums.length;
		for(int i=0;i < nums.length;i++) {
			expectedNum ^= i ^ nums[i];
		}
		return expectedNum;
	}

	static int missingNumberUsingXOR(int arr[]) {
		int xor1 = arr[0];
		for (int i = 1; i < arr.length; i++) {
			xor1 ^= arr[i];
		}

		int xor2 = 1;
		for (int i = 2; i <=arr.length + 1; i++) {
			xor2 ^= i;
		}

		return xor1 ^ xor2;
	}
}
