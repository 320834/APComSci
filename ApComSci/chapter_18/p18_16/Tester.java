package p18_16;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long m = System.currentTimeMillis();
		System.out.println(IterativeFibonacci.iterativeRun(46));
		System.out.println(System.currentTimeMillis() - m + " milliseconds");
		m = System.currentTimeMillis();
		System.out.println(RecursiveFibonacci.recursiveRun(46));
		System.out.println(System.currentTimeMillis() - m + " milliseconds");
//		m = System.currentTimeMillis();
//		System.out.println(OptimizedFibonacci.optimizedRun(46));
//		System.out.println(System.currentTimeMillis() - m + " milliseconds");
	}
}
