package p7_2;

public class RandomWalkTester {
	/**
	 * Makes a drunkard move 100 times and prints the distance traveled
	 * @author 320951 - Saikiran Nakka
	 * @param args
	 */
	public static void main(String[] args) {
		RandomWalk drunkard = new RandomWalk(8, 3);
		for(int i = 0; i <= 100; i++){
			System.out.println("Move: " + i + " Point: " + drunkard.move());
		}
		System.out.println("Linear Distance: " + drunkard.getDistance() + " units");
	}

}
