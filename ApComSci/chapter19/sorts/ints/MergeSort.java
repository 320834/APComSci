package sorts.ints;

public class MergeSort
{
	public static void main(String[] args){
		int[] x = {71, 86, 79, 36, 78, 35, 75, 86, 24, 11, 89, 57};
		sort(x);
		System.out.print("[" + x[0]);
		for(int i = 1; i < x.length; i++)
			System.out.print(", " + x[i]);
		System.out.print("]");
	}

	public static void sort(int[] a)
	{
		sort(a, 0, a.length - 1);
	}
	
	private static void sort(int[] a, int low, int high)
	{
		if(low >= high)
			return;
		
		int mid = (high + low)/2;
		sort(a, low, mid);
		sort(a, mid + 1, high);
		merge(a, low, mid, high);
	}

	private static void merge(int[] a, int low, int mid, int high)
	{  
	    int[] b = new int[mid + 1 - low];
	    for(int i = 0; i < b.length; i++)
	      b[i] = a[i + low];

	    int aLowerIndex = low, bIndex = 0, aHigherIndex = mid + 1;
	    while (aLowerIndex < aHigherIndex && aHigherIndex <= high)
	    {
	      if (a[aHigherIndex] < b[bIndex])
	        a[aLowerIndex++] = a[aHigherIndex++];
	      else
	        a[aLowerIndex++] = b[bIndex++];
	    }

	    while (aLowerIndex < aHigherIndex)
	      a[aLowerIndex++] = b[bIndex++];
	}
}
