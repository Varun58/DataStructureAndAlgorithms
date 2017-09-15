package math;

public class IsMultipleOf3 {
	
	public static void main(String[] args) {
		System.out.println(isMultipleOfThree(3));
		System.out.println(isMultipleOfThree(13));
		System.out.println(isMultipleOfThree(23));
		System.out.println(isMultipleOfThree(33));
		System.out.println(isMultipleOfThree(36));
		System.out.println(isMultipleOfThree(987));
		System.out.println(isMultipleOfThree(123456));
		System.out.println(isMultipleOfThree(97));
		System.out.println(isMultipleOfThree(9));
	}
	
	static boolean isMultipleOfThree(int number) {
		
		if(number<0) {
			number = -number;
		}
		
		if(number == 1) return false;
		
		if(number == 0 ) return true;
		
		int oddCount =0,evenCount=0;
		
		while(number!=0) {
			
			if((number & 1)== 1) {
				oddCount++;
			}
			number = number >> 1;
		
			if((number & 1) == 1) {
				evenCount++;
			}
			
			number = number >> 1;
		}
		
		return Math.abs(evenCount-oddCount)==0;
	}

}
