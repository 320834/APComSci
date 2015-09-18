package project2_9;

/**
 * @author Saikiran Nakka
 * This program replaces i with ! and s with $
 *
 */
public class Mississippi {
	public static void main(String[] args) {
		String m = "Mississippi";
		String newm = m.replace('i', '!').replace('s', '$');
		System.out.println("Before: " + m + "\nAfter: " + newm);
	}

}
