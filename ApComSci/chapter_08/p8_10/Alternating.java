package p8_10;

public class Alternating {
	int[]array;
	public Alternating(int[] array){
		this.array = array;
	}
	public int getAlternatingSum(){
		int sum = 0;
		for(int i = 0; i < array.length; i+= 2){
			sum += array[i];
		}
		for(int i = 1; i < array.length; i+= 2){
			sum -= array[i];
		}
		
		return sum;
	}
}
