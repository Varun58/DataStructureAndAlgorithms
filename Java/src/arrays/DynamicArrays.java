package arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DynamicArrays {

	/*public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int queries = sc.nextInt();
		List<Integer>[] seq = new List[N];

		
		Integer lastAnswer = 0;

		for (int i = 0; i < queries; i++) {
			int q = sc.nextInt();

			if (q == 1) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				int seqIndex = (int) ((x ^ lastAnswer) % N);

				if (null == seq[seqIndex]) {
					List<Integer> newList = new ArrayList<Integer>(N);
					newList.add(y);
					seq[seqIndex] = newList;
				} else {
					seq[seqIndex].add(y);
				}
			} else if (q == 2) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				int seqIndex = (int) ((x ^ lastAnswer) % N);
				List<Integer> sequence = seq[seqIndex];
				lastAnswer = sequence.get(y % sequence.size());
				System.out.println(lastAnswer);
			}
		}
	}
*/	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int queries = sc.nextInt();
		//List<Integer>[] seq = new List[N];
		int seq[][] = new int[N][N];
		int size[] = new int[N];
		Integer lastAnswer = 0;

		for (int i = 0; i < queries; i++) {
			int q = sc.nextInt();

			if (q == 1) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				int seqIndex = (int) ((x ^ lastAnswer) % N);

				if (size[seqIndex] != 0) {
					seq[seqIndex][size[seqIndex]] = y;
					size[seqIndex]++;
				} else {
					seq[seqIndex][0] = y;
					size[seqIndex]=1;
				}
			} else
				if (q == 2) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				int seqIndex = (int) ((x ^ lastAnswer) % N);
				lastAnswer = seq[seqIndex][y % size[seqIndex]];
				System.out.println(lastAnswer);
			}
		}
	
	}
}
