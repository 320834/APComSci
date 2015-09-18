package sorts.ints;

public class LinearSearch {
    public static int linearSearch(int[] x, int key)
    {
    	for(int i = 0; i < x.length; i++)
    		if(x[i] == key)
    			return i;
    	
    	return -1;
    }

}
