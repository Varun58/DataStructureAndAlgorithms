package greedy;

public class KSwap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i, k = 4, max, n = 5, temp, j;
		int a[] = new int[n];
		for (i = 0; i < n; i++) {
			for (i = 0; i < n - 1 && k > 0; i++) {
				max = i;
				
				for (j = i + 1; j < n; j++) { 
					if (a[j] > a[max])
						max = j;
				}
				
					if (max != i) {
						temp = a[i];
						a[i] = a[max];
						a[max] = temp;
						k--;
					}
				
			}
		}
	}

}
