package dp;

public class MinimumStepsToReachDestination {

	public static void main(String[] args) {

			System.out.println("Minimum Steps required from source : "+ minStepsReq(0, 0, 11));
	}

	static int minStepsReq(int source, int steps, int dest) {
		if (Math.abs(source) > dest) {
			return Integer.MAX_VALUE;
		}

		if (source == dest) {
			return steps;
		}

		int pos = minStepsReq(source + steps + 1, steps + 1, dest);

		int neg = minStepsReq(source - steps - 1, steps + 1, dest);
		
		return Math.min(pos, neg);
	}

}
