package arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class BinarySearchIceCreamParlour {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();

		for (int a0 = 0; a0 < t; a0++) {

			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
			int m = in.nextInt();
			int n = in.nextInt();
			int a[] = new int[n];
			Flavours flavours[] = new Flavours[n];
			for (int a_i = 0; a_i < n; a_i++) {
				a[a_i] = in.nextInt();
				flavours[a_i] = new Flavours(a_i,a[a_i]);
			}

			System.out.println();

			Arrays.sort(flavours,new SortFla());

			int i = 0, j = a.length - 1;
			while (i <j) {
				if ((flavours[i].value + flavours[j].value) == m) {
					
					int count1 = flavours[i].id +1;
					int count2 = flavours[j].id +1;
					
					System.out.print(count1 + " " + count2);
					i++;
					j--;
				} else if ((flavours[i].value + flavours[j].value) < m) {
					i++;
				} else {
					j--;
				}

			}

			System.out.println();
		}
	}
}

		class SortFla implements Comparator<Flavours> {
			@Override
			public int compare(Flavours f1, Flavours f2) {
				if (f1.value > f2.value)
					return 1;
				if (f1.value < f2.value)
					return -1;
				return 0;
			}
		}
		
		class Flavours {
			int id;
			int value;
		
			public Flavours(int id, int value) {
				this.id = id;
				this.value = value;
			}

			@Override
			public String toString() {
				return "Flavours [id=" + id + ", value=" + value + "]";
			}
			
		}