package random;

public class Random {
	public static void main(String[] args) {
		int[] numbers, even, odd;
		int evenNum = 0, oddNum = 0;
		numbers = initArray();
		for(int i = 0; i < numbers.length; i++)
			if(numbers[i] % 2 == 0)
				evenNum++;
			else oddNum++;
		even = even(evenNum, numbers);
		odd = odd(oddNum, numbers);
		System.out.println("The numbers are " + printArray(numbers));
		System.out.println("Odd numbers are " + printArray(odd));
		System.out.println("Even numbers are " + printArray(even));
	}

	public static String printArray(int[] array){
		String arr = "[" + array[0];
		for(int i = 1; i < array.length; i++)
			arr += ", " + array[i];
		return arr += "]";
	}
	
	public static int[] initArray() {
		int[] numbers = new int[100];
		for(int i = 0; i < 100; i++)
			numbers[i] = (int) (Math.random() * 26);
		return numbers;
	}

	public static int[] even(int num, int[] array){
		int[] even = new int[num];
		int evenIndex = 0;
		for(int i = 0; i < array.length; i++){
			if(array[i] % 2 == 0){
				even[evenIndex] = array[i];
				evenIndex++;
			}
		}
		return even;
	}

	public static int[] odd(int num, int[] array){
		int[] odd = new int[num];
		int oddIndex = 0;
		for(int i = 0; i < array.length; i++){
			if(array[i] % 2 != 0){
				odd[oddIndex] = array[i];
				oddIndex++;
			}
		}
		return odd;
	}
}