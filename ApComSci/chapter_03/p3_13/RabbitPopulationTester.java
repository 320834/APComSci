package p3_13;

public class RabbitPopulationTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RabbitPopulation r = new RabbitPopulation();
		for(int i = 1; i<=5; i++){
			System.out.println("Month: " + i);
			r.getPairs();
			r.waitAMonth();
	}

}
}
