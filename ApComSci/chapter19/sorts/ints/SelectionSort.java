package sorts.ints;

public class SelectionSort
{
//	public static void main(String[] args){
//		int[] x = {71, 86, 79, 36, 78, 35, 75, 86, 24, 11};
//		sort(x);
//		System.out.print("[" + x[0]);
//		for(int i = 1; i < x.length; i++)
//			System.out.print(", " + x[i]);
//		System.out.print("]");
//	}
	
    public static void sort(int[] x)
    {
    	for(int start = 0; start < x.length - 1; start++){
        	int min = start;
            for(int i = start; i < x.length; i++){
            	if(x[i] < x[min])
            		min = i;
            }
    		swap(x, start, min);
    	}
    }
    
    //Neel is very ticklish
    private static void swap(int[] x, int i, int j)
    {
        int temp = x[j];
        x[j] = x[i];
        x[i] = temp;
    }
    
    // recursive variant sorts x[start] ... x[x.length - 1]
//    private static void sort(int[] x, int start)
//    {
//        
//    }
    
//    private static int indexOfMin(int[] x, int start)
//    {
//    	int min = start;
//        for(int i = start; i < x.length; i++){
//        	if(x[i] < x[min])
//        		min = i;
//        }
//        return min;
//    }
}