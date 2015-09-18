package p11_9;

public class DataSet {
	@SuppressWarnings("rawtypes")
	private Comparable maximum, minimum;
	private int count;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void add(Comparable c){
		if(count == 0){
			maximum = c;
			minimum = c;
			count++;
		}
		else
			if(c.compareTo(maximum) > 0)
				maximum = c;
			else
				minimum = c;
		count++;
	}
	
	@SuppressWarnings("rawtypes")
	public Comparable getMinimum(){
		return minimum;
	}
	
	@SuppressWarnings("rawtypes")
	public Comparable getMaximum(){
		return maximum;
	}
}
