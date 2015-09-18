/**
 * 
 */
package p4_14;

import java.util.Scanner;

/**
 * @author 320951
 *
 */
public class MilitaryTimeTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner k = new Scanner(System.in);
		System.out.print("Enter First Time: ");
		int t1 = k.nextInt();
		k.nextLine();
		System.out.print("\nEnter Second Time: ");
		int t2 = k.nextInt();
		k.nextLine();
		MilitaryTime yes = new MilitaryTime(t1, t2);
		System.out.println("\nHours: " + yes.getHours() + "\nMinutes: " + yes.getMinutes());
		k.close();
	}

}
