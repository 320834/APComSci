package p18_16;

import java.util.ArrayList;

public class OptimizedFibonacci {
	public static ArrayList<Integer> runs = new ArrayList<Integer>();
	public static int optimizedRun(int n) {
		System.out.println(runs.size());
		if (n <= 1){
			runs.add(new Integer(n));
			System.out.println(runs.size());
			return n;
		}
		
		if(runs.size() >= n - 1)
			return runs.get(n - 1 - 1) + runs.get(n - 2 - 1);
		else if(runs.size() >= n - 2)
			return optimizedRun(n - 1) + runs.get(n - 2 - 1);
		return optimizedRun(n-1) + optimizedRun(n - 2);
	}

}
