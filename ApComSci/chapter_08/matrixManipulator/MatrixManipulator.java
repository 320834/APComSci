package matrixManipulator;

/**
 * Offers the specified operations on integer matrices.
 */
public class MatrixManipulator
{
	/**
	 * Determines if (first + second) is defined where + indicates matrix addition.
	 * 
	 * @return true if matrix addition is defined, false otherwise.
	 */
	public static boolean addable(int[][] first, int[][] second)
	{
		if(atLeastOneByOne(first) && atLeastOneByOne(second))
			return (first.length == second.length && first[0].length == second[0].length);
		return false;
	}

	/**
	 * Performs (first + second) where + indicates matrix addition. (Precondition: addable(first, second) returns true.)
	 * 
	 * @return the result of first + second.
	 * @throws IllegalArgumentException
	 *             if the precondition is not met.
	 */
	public static int[][] add(int[][] first, int[][] second)
	{
		if(atLeastOneByOne(first) && atLeastOneByOne(second)){
			int[][]returnArray = new int[first.length][first[1].length];
			if(addable(first, second)){
				for(int r = 0; r < first.length; r++)
					for(int c = 0; c < first[0].length; c++)
						returnArray[r][c] = first[r][c] + second[r][c];
				return returnArray;
			}
		}
		throw new IllegalArgumentException();
	}

	/**
	 * Performs (scalar * matrix) where * indicates scalar multiplication of a matrix. (Precondition: matrix.length > 0 && matrix[0].length > 0)
	 * 
	 * @return the result of scalar * matrix.
	 * @throws IllegalArgumentException
	 *             if the precondition is not met.
	 */
	public static int[][] multiplyByScalar(int scalar, int[][] matrix)
	{
		if(atLeastOneByOne(matrix)){
			if(matrix.length > 0 && matrix[0].length > 0){
				int[][] returnArray = new int[matrix.length][matrix[0].length];
				for(int r = 0; r < matrix.length; r++)
				for(int c = 0; c < matrix[0].length; c++)
					returnArray[r][c] = matrix[r][c]*scalar;
				return returnArray;
			}
		}
		throw new IllegalArgumentException();
	}

	/**
	 * Multiplies the specified row of first and the specified column of second. (Precondition: first[row].length > 0 && first[row].length == second.length)
	 * 
	 * @return the result of multipliying the specified row and column.
	 * @throws IllegalArgumentException
	 *             if the precondition is not met.
	 */
	public static int multiply(int[][] first, int row, int[][] second, int col)
	{
		if(atLeastOneByOne(first) && atLeastOneByOne(second)){
			int result = 0;
			if(first[row].length > 0 && first[row].length == second.length){
				for(int i = 0; i < first[row].length; i++){
					result += first[row][i] * second[i][col];
				}
				return result;
			}
		}
		throw new IllegalArgumentException();
	}

	/**
	 * Determines if (first * second) is defined where * indicates matrix multiplication.
	 * 
	 * @return true if matrix multiplication is defined, false otherwise.
	 */
	public static boolean multipliable(int[][] first, int[][] second)
	{
		if(atLeastOneByOne(first) && atLeastOneByOne(second))
			return first[0].length == second.length;
		return false;
	}

	/**
	 * Performs (first * second) where * indicates matrix multiplication. (Precondition: multipliable(first, second) returns true.)
	 * 
	 * @return the result of first * second.
	 * @throws IllegalArgumentException
	 *             if the precondition is not met.
	 */
	public static int[][] multiply(int[][] first, int[][] second)
	{
		if(multipliable(first, second)){
			int[][] returnArray = new int[first.length][second[0].length];
			for(int r = 0; r < first.length; r++)
				for(int c = 0; c < second[0].length; c++)
					returnArray[r][c] = multiply(first, r, second, c);
			return returnArray;
		}
		else
			throw new IllegalArgumentException();
	}

	private static boolean atLeastOneByOne(int[][] matrix)
	{
		return matrix != null && matrix.length > 0 && matrix[0].length > 0;
	}
}
