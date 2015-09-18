package p8_19;

public class MagicSquareMaker {
	private int[][] square;
	private int dim;
	
	public MagicSquareMaker(int n){
		dim = n;
		square = new int[n][n];
		if(n % 2 != 0){
			square[n - 1][n/2] = 1;
			int i = 0;
			int j = 3;
			square[i][j] = 2;
			for(int k = 3; k <= n * n; k++){
				if(!isLowCorner(i, j) && notFilled(i, j)){
					if(j + 1 == dim)
						j = 0;
					else
						j +=1;
					if(i + 1 == dim)
						i = 0;
					else
						i +=1;
					square[i][j] = k;
				}
				else{
					if(i - 1 < 0){
						i = n - 1;
					}
					else
						i -=1;
					square[i][j] = k;
				}
			}
		}
	}
	
	private boolean notFilled(int i, int j){
		if(j + 1 == dim)
			j = 0;
		else
			j +=1;
		if(i + 1 == dim)
			i = 0;
		else
			i +=1;
		return square[i][j] == 0;
	}
	
	private boolean isLowCorner(int i, int j){
		return i == dim -1 && j == dim - 1;
	}
	public String toString(){
		String returnSquare = "";
		for(int row = 0; row < dim; row++){
			returnSquare += "[";
			for(int col = 0; col < dim; col++){
				returnSquare += " " + square[row][col];
			}
			returnSquare += "]\n";
		}
		return returnSquare;
	}
}
