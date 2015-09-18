package p11_3;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DataSet ds = new DataSet();
		
		ds.add(new Person("bob", 64));
		ds.add(new Person("sam", 61));
		ds.add(new Person("randy", 70));
		ds.add(new Person("nick", 50));
		
		System.out.println("The tallest person is " + ((Person) ds.getMaximum()).getName() + " who is " + ds.getMaximum().getMeasure() + " inches tall!");
	}

}
