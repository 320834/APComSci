package generator;

public class RandomNumberGenerator {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		int r = 5, a = -10, b = 5;
		for(int i = 0; i <= 50; i++) //For the sake of seeing if the statement works or not w/o spamming the run button
		System.out.println(r = (a - 1) + (int) (Math.random() * (b - (a - 1)) + 1));
	}
}
