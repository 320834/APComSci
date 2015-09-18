package validatedInputII;

import java.util.ArrayList;

public class SimplePasswordValidator<T> implements Validator<T>
{
	private ArrayList<String> password;
	
	public SimplePasswordValidator(){
		password.add("password");
	}
	
	public SimplePasswordValidator(ArrayList<String> passwords){
		password = passwords;
	}
	
	public String prompt() {
		return "Enter Password: ";
	}

	public String error() {
		return "Value does not match Password";
	}

	public boolean isValid(String value) {
		if(value == null)
			return false;
		for(int i = 0; i < password.size(); i++)
			if(password.get(i).equals(value))
				return true;
		return false;
	}

}
