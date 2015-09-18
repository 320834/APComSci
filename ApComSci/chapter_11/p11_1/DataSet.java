package p11_1;

public class DataSet {
	private double sum, maximum;
	private int count;
	
	public void add(Measurable m){
		sum = sum + m.getMeasure();
		if(count == 0 || maximum < m.getMeasure())
			maximum = m.getMeasure();
		count++;
	}
	
	public double getAverage(){
		if(count == 0)
			return 0;
		else
			return sum/count;
	}
	
	public double getMaximum(){
		return maximum;
	}
}
