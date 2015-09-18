package p2_1;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * 
 * @author Saikiran Nakka
 * @since September 6th, 2014
 * This program is Project 2.1 on page 61.
 * List the date and weekday that is 100 days from today.
 * The Weekday of your birthday.
 * The date that is 10,000 days from your birthday
 */
public class P2_1_GregorianCalendar {
	public static void main(String [] args){
		Scanner keyboard = new Scanner(System.in);
		System.out.println("What day of the month were you born?");
		int day = Integer.parseInt(keyboard.nextLine());
		System.out.println("What month were you born?(ex.10)");
		int month = Integer.parseInt((keyboard.nextLine()));
		System.out.println("What year were you born?");
		int year = Integer.parseInt(keyboard.nextLine());
		birthday(day, month, year);
		today100();
		keyboard.close();
	}
	/**
	 * 
	 * @param day 
	 * 			this is used to create the GregorianCalendar object of the birthday
	 * @param month
	 * 			   this is used to create the GregorianCalendar object of the birthday
	 * @param year
	 * 			  this is used to create the GregorianCalendar object of the birthday
	 * This method prints the weekday of the user's birthday and the date 10,000 days away from the user's birthday
	 */
	public static void birthday(int day, int month, int year){
		GregorianCalendar birthday = new GregorianCalendar(year, month, day);
		String weekday = null;
		int day1 = birthday.get(Calendar.DAY_OF_WEEK);
		if(day1 == 1)
			weekday = "Sunday";
		else if (day1 == 2)
			weekday = "Monday";
		else if (day1 == 3)
			weekday = "Tuesday";
		else if (day1 == 4)
			weekday = "Wednesday";
		else if (day1 == 5)
			weekday = "Thursday";
		else if (day1 == 6)
			weekday = "Friday";
		else if (day1 == 7)
			weekday = "Saturday";	
		System.out.println("Your birthday was on a " + weekday + ".");
		birthday.add(Calendar.DAY_OF_MONTH, 10000);
		day1 = Calendar.DAY_OF_WEEK;
		if(day1 == 1)
			weekday = "Sunday";
		else if (day1 == 2)
			weekday = "Monday";
		else if (day1 == 3)
			weekday = "Tuesday";
		else if (day1 == 4)
			weekday = "Wednesday";
		else if (day1 == 5)
			weekday = "Thursday";
		else if (day1 == 6)
			weekday = "Friday";
		else if (day1 == 7)
			weekday = "Saturday";	
		System.out.println("The day 10,000 days from today is "+(birthday.get(Calendar.MONTH))+"/"+birthday.get(Calendar.DAY_OF_MONTH)+"/"+birthday.get(Calendar.YEAR)+" which is a "+weekday + ".");
	}
	public static void today100(){
		GregorianCalendar today = new GregorianCalendar();
		today.add(Calendar.DAY_OF_MONTH, 100);
		String weekday = null;
		int day = today.get(Calendar.DAY_OF_WEEK);
		if(day == 1)
			weekday = "Sunday";
		else if (day == 2)
			weekday = "Monday";
		else if (day == 3)
			weekday = "Tuesday";
		else if (day == 4)
			weekday = "Wednesday";
		else if (day == 5)
			weekday = "Thursday";
		else if (day == 6)
			weekday = "Friday";
		else if (day == 7)
			weekday = "Saturday";	
		//had to do +1 for month because for some reason it was one month off
		System.out.println("The day 100 days from today is "+(today.get(Calendar.MONTH)+1)+"/"+today.get(Calendar.DAY_OF_MONTH)+"/"+today.get(Calendar.YEAR)+" which is a "+weekday + ".");
	}
}
