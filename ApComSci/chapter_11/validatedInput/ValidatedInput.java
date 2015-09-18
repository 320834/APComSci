package validatedInput;

import java.util.Scanner;

public class ValidatedInput
{
	private Scanner scan = new Scanner(System.in);;
	
	// prompt is validator.prompt(), error on invalid input is validator.error()
	// validity check is validator.isValid(...)
	// continues prompting and displaying error until valid input is obtained
	// returns valid input 
	public int getInt(Validator<Integer> validator)
	{
		System.out.println(validator.prompt());
		String value = scan.nextLine();
		while(!validator.isValid(value)){
			System.out.println(validator.error());
			System.out.println(validator.prompt());
			value = scan.nextLine();
		}
		return Integer.parseInt(value);
	}
	
	// same as above
	// accepts any integer as valid input
	// hint: use AnyIntegerValidator with the above method
	public int getInt()
	{
		return getInt(new AnyIntegerValidator()); // TODO: implement method
	}

	// same as above
	// accepts any integer x such that: min <= x <= max
	// precondition: min <= max
	// hint: define a class IntegerRangeValidator to use with the first method
	public int getInt(int min, int max)
	{
		Validator<Integer> validator = new IntegerRangeValidator();
		((IntegerRangeValidator) validator).setMin(min);
		((IntegerRangeValidator) validator).setMax(max);
		return getInt(validator); // TODO: implement method
	}
}
