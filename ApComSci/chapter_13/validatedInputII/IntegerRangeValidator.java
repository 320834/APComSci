package validatedInputII;

public class IntegerRangeValidator implements Validator<Integer>
{
	private int min = 0, max = 0;

	public void setMin(int min){
		this.min = min;
	}
	
	public void setMax(int max){
		this.max = max;
	}
	
	public String error()
	{
		return "Input is not an integer/Incorrect Range.";
	}

	public String prompt()
	{
		return "Enter an integer.";
	}

	public boolean isValid(String value)
	{
		try
		{
			Integer.parseInt(value);
		}
		catch(NumberFormatException e)
		{
			return false;
		}
		return(Integer.parseInt(value) >= min && Integer.parseInt(value) <= max);
	}
}
