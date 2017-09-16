package math;

public class DecimalToRomanUpto3999 {

	public static void main(String[] args) {
		int number = 3456;
		//System.out.println(decimalToRoman(number));
		System.out.println(decimalToRoman(3549));
		decimalToRomanUsingPredef(3549);
	}

	
	//Method1
	public static void decimalToRomanUsingPredef(int n) {
		String thousand[] = {"","M","MM","MMM"};
		String hundred[] = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","DM"};
		String tens[] = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
		String ones[] = {"","I","II","III","IV","V","VI","VII","VIII","IX"};
		
		String number = thousand[n/1000]+hundred[(n%1000)/100]+tens[(n%100)/10]+ones[n%10];
		System.out.println(number);
	}
	
	//Method 2
	public static int digit(char val, int times, int i, char arr[]) {
		for (int j = 0; j < times; j++) {
			arr[i++] = val;
		}
		return i;
	}

	public static int subDigit(char val, char subval, int i, char arr[]) {
		arr[i++] = val;
		arr[i++] = subval;
		return i;
	}

	public static String decimalToRoman(int n) {

		char result[] = new char[15];
		int i = 0;
		while (n != 0) {

			if (n >= 1000) {
				i = digit('M', n / 1000, i, result);
				n = n % 1000;
			}

			else if (n >= 500) {
				if (n <900) {
					i = digit('D', n / 500, i, result);
					n = n % 500;
				} else {
					i = subDigit('C', 'M', i, result);
					n = n % 100;
				}
			}
			else if(n>=100) {
				if (n <400) {
					i = digit('C', n / 100, i, result);
					n = n % 100;
				} else {
					i = subDigit('C', 'D', i, result);
					n = n % 100;
				}
			}
			else if(n>=50) {
				if (n <90) {
					i = digit('L', n / 50, i, result);
					n = n % 50;
				} else {
					i = subDigit('L', 'C', i, result);
					n = n % 10;
				}
			}
			else if(n>=10) {
				if (n <40) {
					i = digit('X', n / 10, i, result);
					n = n % 10;
				} else {
					i = subDigit('X', 'L', i, result);
					n = n % 10;
				}
			}
			else if(n>=5) {
				if (n <9) {
					i = digit('V', n/5 , i, result);
					n = n % 5;
				} else {
					i = subDigit('I', 'X', i, result);
					n = 0;
				}
			}
			else if(n>=1) {
				if (n <4) {
					i = digit('I', n , i, result);
					n = 0;
				} else {
					i = subDigit('I', 'V', i, result);
					n = 0;
				}
			}
		}

		return new String(result);
	}
}
