package p8_18;

import java.util.ArrayList;
import java.util.Collections;

public class MagicSquares {
	private int[][] square;
	private ArrayList<Integer> inputs;
	private int dim, row = 0, col = 0, magicNumber;
	
	public MagicSquares(int n){
		dim = n;
		square = new int[n][n];
		inputs = new ArrayList<Integer>();
	}
	
	public void add(int i){
		inputs.add(i);
		
		if(col + 1 == dim){
			col = 0;
			row++;
		}
		else
			col++;
		square[row][col] = i;
		Collections.sort(inputs);
	}

	public boolean isMagic(){
		if(inputs.size() == dim * dim){			//Entered n^2 inputs(checks if square)
			if(occursOnce()){
				magicNumber = row(0);
				return testMagicNumber();
			}
		}
		return false;
	}
	
	private boolean testMagicNumber(){
		for(int i = 0; i < dim; i++){
			if(row(i) != magicNumber || col(i) != magicNumber)
				return false;
		}
		return checkDiags();
	}
	
	private boolean checkDiags(){
		int sum = 0;
		for(int i = 0; i < dim; i++){
			sum += square[i][i];
		}
		if(sum != magicNumber)
			return false;
		sum = 0;
		int i = 0;
		for(int j = dim - 1; j >= 0; j--){
			sum += square[i][j];
			i++;
		}
		if(sum != magicNumber)
			return false;
		
		return true;
	}
	
	private int col(int col){
		int sum = 0;
		
		for(int i = 0; i < dim; i++){
			sum += square[i][col];
		}
		return sum;
	}
	
	private int row(int row){
		int sum = 0;
		
		for(int i = 0; i < dim; i++){
			sum += square[row][i];
		}
		return sum;
	}
	
	private boolean occursOnce(){
		for(int i = 0;  i < inputs.size(); i++){
			if(inputs.get(i) != i + 1)
				return false;
		}
		return true;
	}
}
