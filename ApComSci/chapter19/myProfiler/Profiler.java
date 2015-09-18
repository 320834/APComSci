package myProfiler;

public class Profiler {

	public static void main(String[] args) {
		int[] random1000 = getRandom(1000), random10000 = getRandom(10000), random100000 = getRandom(100000), random1000000 = getRandom(1000000);
		System.out.println("                1000 terms      10000 terms     100000 terms     1000000 terms");
		System.out.println("Selection Sort:    " + runtimeSS(random1000.clone()) + "\t\t" + runtimeSS(random10000.clone()) + "\t\t" + runtimeSS(random100000.clone()) + "\t\t ridiculous amount of time");
		System.out.println("Insertion Sort:    " + runtimeIS(random1000.clone()) + "\t\t" + runtimeIS(random10000.clone()) + "\t\t" + runtimeIS(random100000.clone()) + "\t\t also rdiculous amount of time");
		System.out.println("Merge Sort:        " + runtimeMS(random1000.clone()) + "\t\t" + runtimeMS(random10000.clone()) + "\t\t" + runtimeMS(random100000.clone()) + "\t\t " + runtimeMS(random1000000.clone()));
	}

	public static long runtimeSS(int[] input){
		long start = System.currentTimeMillis();
		sorts.ints.SelectionSort.sort(input);
		long end = System.currentTimeMillis();
		return end - start;
	}
	
	public static long runtimeIS(int[] input){
		long start = System.currentTimeMillis();
		sorts.ints.InsertionSort.sort(input);
		long end = System.currentTimeMillis();
		return end - start;
	}

	public static long runtimeMS(int[] input){
		long start = System.currentTimeMillis();
		sorts.ints.MergeSort.sort(input);
		long end = System.currentTimeMillis();
		return end - start;
	}

	public static int[] getRandom(int terms){
		int[] returnArray = new int[terms];
		
		for(int i = 0; i < returnArray.length; i++){
			returnArray[i] = (int)(Math.random() * 100);
		}
		return returnArray;
	}
}
