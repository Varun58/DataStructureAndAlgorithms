package math;

public class SquareRootOfNumber {

	public static void main(String[] args) {
		System.out.println(findSquareRoot(256));
		System.out.println(findSquareRoot(4));
		System.out.println(findSquareRoot(11));
		
		System.out.println((int)findSquareRootUsingBabylonianMethod(256));
		System.out.println((int)findSquareRootUsingBabylonianMethod(4));
		System.out.println(findSquareRootUsingBabylonianMethod(11));
	}

	private static int findSquareRoot(int x) {
		
		if(x == 0 || x ==1 ) {
			return x;
		}
		
		int floor = 0;
		int i=1,res=0;
		while(res <=x) {
			if(res ==  x) {
				return i;
			}
			floor=i;
			i++;
			res = i*i;
		}
		return floor;
	}
	
	
	private static float findSquareRootUsingBabylonianMethod(int n) {
		float x = n;
		float y = 1;
		float e = (float) 0.000001;
		while(x-y >e) {
			x= (x+y)/2;
			y = n/x;
		}
		return x;
	}
	
}
