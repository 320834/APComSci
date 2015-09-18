package p4_6;

public class DataSet {
	private double smallest, largest;

	public DataSet(){
	largest = 0;
	smallest = 0;
	}
	public DataSet(int v1, int v2, int v3, int v4){
	if(v1 < v2 && v1 < v3 && v1 < v4)
	  smallest = v1;
	else if(v2 < v3 && v2 < v4)
	  smallest = v2;
	else if(v3 < v4)
	  smallest = v3;
	else
	smallest = v4;
	if(v1 > v2 && v1 > v3 && v1 > v4)
	  largest = v1;
	else if(v2 > v3 && v2 > v4)
	  largest = v2;
	else if(v3 > v4)
	  largest = v3;
	else
	 largest = v4;

	}

	public void addValue(int x){
	if( x > largest)
	  largest = x;
	if( x < smallest)
	  smallest = x;
	}

	public int getSmallest(){
	return (int) Math.round(smallest);
	}

	public int getLargest(){
	return (int) Math.round(largest);
	}

}
