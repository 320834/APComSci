package sorts.ints;

public class InsertionSort
{
//	public static void main(String[] args){
//		int[] x = {71, 86, 79, 36, 78, 35, 75, 86, 24, 11};
//		sort(x);
//		System.out.print("[" + x[0]);
//		for(int i = 1; i < x.length; i++)
//			System.out.print(", " + x[i]);
//		System.out.print("]");
//		System.out.println();
//		System.out.println("35: " + binarySearch(x, 35));
//		System.out.println("1: " + binarySearch(x, 1));
//		System.out.println("38: " + binarySearch(x, 38));
//	}

    public static void sort(int[] x)
    {
        for(int i = 0; i < x.length; i++)
        {
        	int stored = x[i];
        	int a= i;
        	while(a > 0 && x[a - 1] > stored)
        	{
        		x[a] = x[a - 1];
        		a--;
        	}
        	x[a] = stored;
        }
    }
    
    public static void recursiveSort(int[] x)
    {
        
    }

    public static void sortWithBinarySearch(int[] x)
    {
        
    }

    public static int binarySearch(int[] x, int key)
    {
        return binarySearch(x, key, 0, x.length - 1);
    }

    private static int binarySearch(int[] x, int key, int start, int end)
    {
    	if(start >= end)
    		if(x[end] > key)
    			return -end - 1;
    		else
    			return -end;
    	
    	int mid = (start + end)/2;
    	if(x[mid] > key)
    		end = mid - 1;
    	if(x[mid] < key)
    		start = mid + 1;
    	else if(x[mid] == key)
    		return mid;
        return binarySearch(x, key, start, end);
    }

    // recursive variant sorts x[start] ... x[x.length - 1]
    @SuppressWarnings("unused")
	private static void sort(int[] x, int start)
    {
        
    }

    // inserts value into correct position in x[0]...x[start]
    @SuppressWarnings("unused")
	private static void insert(int[] x, int value, int start)
    {
        
    }
}
