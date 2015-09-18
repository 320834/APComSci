package p8_11;

public class PermutationGenerator {
	private int choices[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
			
	public int[] nextPermutation(){
		int[] returnPermutation = new int[10];
		int count = 10;
		
		for(int i = 0; i < 10; i++){
			int term = (int) (Math.random() * count);
			returnPermutation[i] = choices[term];
			int temp = choices[term];
			choices[term] = choices[count - 1];
			choices[count - 1] = temp;
			count--;
		}
		return returnPermutation;
	}
}