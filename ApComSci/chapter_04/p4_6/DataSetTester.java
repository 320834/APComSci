package p4_6;

public class DataSetTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DataSet ds = new DataSet(1,2,3,4);
		System.out.println(ds.getLargest());
		for(int x = 0; x < 4; x++){
		ds.addValue(1);
		}
	}
}
