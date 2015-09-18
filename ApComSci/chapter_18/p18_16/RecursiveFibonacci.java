package p18_16;

public class RecursiveFibonacci {
	public static int recursiveRun(int n) {
		if (n <= 1)
			return n;

		return recursiveRun(n - 1) + recursiveRun(n - 2);
	}
}
