package p7_6;
/**
 * Find's mean and standard deviation of a list of user inputted number's using the formula in the book
 * @author 320951 - Saikiran Nakka
 *
 */
public class DataSet {
	private int count;
	private double sum, sumSquare;
	
	/**
	 * Default Constructor
	 */
	public DataSet(){
	}
	
	/**
	 * adds a new number to the sum, count, and sumSquare
	 * @param num new number
	 */
	public void add(double num){
		count++;
		sum += num;
		sumSquare += Math.pow(num, 2);
	}
	
	/**
	 * Returns mean of data set
	 * @return mean
	 */
	public double getMean(){
		return sum/count;
	}
	
	/**
	 * Returns Standard Deviation of data set
	 * @return standard deviation
	 */
	public double getStandardDeviation(){
		return Math.sqrt((sumSquare - 1.0/count * Math.pow(sum, 2))/(count - 1));
	}
}
