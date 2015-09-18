package p3_13;
/**
 * Exercise P3.13. Implement a class Rabbi tPopul ati on that simulates the growth of a
rabbit population. The rules are as follows: Start with one pair of rabbits. Rabbits
are able to mate at the age of one month. A month later, each female produces
another pair of rabbits. Assume that rabbits never die and that the female always
produces one new pair (one male, one female) every month from the second month
on. Implement a method waitAMonth that waits for one month, and a method ,.
getPai rs that prints the current number of rabbit pairs. Write a test program that
shows the growth of the rabbit population for ten months. Hint: Keep one instance
field for the newborn rabbit pairs and another one for the rabbit pairs that are at
least one month old.
 * @author 320951
 *
 */
public class RabbitPopulation {
	private int kidPairs;
	private int adultPairs;
	
	public RabbitPopulation(){
		kidPairs = 1;
		adultPairs = 0;
	}
	public void waitAMonth(){
		int newJuvenillePairs = adultPairs;
		adultPairs += kidPairs;
		kidPairs = newJuvenillePairs;
	}
	public void getPairs(){
		System.out.println("Kid Pairs: "  + kidPairs + "\nAdult Pairs: " + adultPairs);
	}
}
