package r8_3;
/**
 * Exercise RS.3. Write Java code for a loop that simultaneously computes the maximum
and minimum values of an array list. Use an array list of accounts as an
example
 * @author 320951
 *
 */
public class MinMax {
	private double min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
	public MinMax(double[] array){
		for(int i = 0; i < array.length; i++){
			if(min > array[i])
				min = array[i];
			if(max < array[i])
				max = array[i];
		}
	}
	
	public double getMin(){
		return min;
	}
	
	public double getMax(){
		return max;
	}
}
