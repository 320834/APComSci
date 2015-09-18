package p11_1;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DataSet ds = new DataSet();
		Die die = new Die(6);
		die.cast();
		for(int i = 1; i < 10; i++){
			ds.add(die);
			die.cast();
		}
		System.out.println("Average: " + ds.getAverage());
	}

}
