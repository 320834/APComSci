package p18_16;

public class IterativeFibonacci {
	public static int iterativeRun(int num){
		int sum = 1, prevNum =1, secondPrev = 0;
		if(num == 1)
			return 0;
		if(num == 2)
			return 1;
		for(int i = 2; i < num; i++){
			secondPrev = prevNum;
			prevNum = sum;
			sum = prevNum + secondPrev;
		}
		return sum;
	}
}
