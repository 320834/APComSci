package p4_5;

public class DataSet {
	private double v1, v2, v3, v4;
	private int sum;

	public DataSet(){
	v1 = 0;
	v2 = 0;
	v3 = 0;
	v4 = 0;
	sum = (int) Math.round(v1 + v2 + v3 + v4);
	}
	public DataSet(int v1, int v2, int v3, int v4){
	this.v1 = v1;
	this.v2 = v2;
	this.v3 = v3;
	this.v4 = v4;
	sum = Math.round(v1 + v2 + v3 + v4);
	}

	public void addValue(int x){
	sum += x;
	}

	public int getSum(){
	return sum;
	}

	public double getAverage(){
	double avg;
	avg = sum / 4;
	return avg;
	}

}
