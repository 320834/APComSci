package validatedInputII;

import java.util.ArrayList;

public class Tester
{
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args)
	{
		ArrayList<String> keys = new ArrayList();
		keys.add("Hello");
		keys.add("Goodbye");
		keys.add("P@ssw0rd");
		keys.add("Sriram123");
		ValidatedInput vi = new ValidatedInput();
		SimplePasswordValidator pass = new SimplePasswordValidator(keys);
		if(vi.getMatch(pass, 5))
			System.out.println("Password is Correct");
		else
			System.out.println("Out of Attempts");
	}
}