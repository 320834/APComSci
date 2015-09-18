package matrixManipulator;

public class MatrixManipulatorTester
{
    public static void main(String[] args)
    {
        testSum();
        testScalarMultiplication();
        testRowColMultiplication();
        testMultiplication();
    }
    
	public static void testSum()
	{
		int[][] first = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}};
		int[][] second = {{11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}};
		
		// initialize first and second to the size shown in the sample output
		// initialize first and second with the values shown in the sample output

		int[][] sum = MatrixManipulator.add(first, second);

		printMatrix(first);
		System.out.println("+");
		printMatrix(second);
		System.out.println("=");
		printMatrix(sum);
	}

	public static void testScalarMultiplication()
	{
		int[][] matrix = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}};
		int scalar = 2;

		// initialize matrix to the size shown in the sample output
		// initialize matrix with the values shown in the sample output

		int[][] scalarProduct = MatrixManipulator.multiplyByScalar(scalar, matrix);

		printMatrix(matrix);
		System.out.println("*");
		System.out.println(scalar);
		System.out.println("=");
		printMatrix(scalarProduct);
	}

	public static void testRowColMultiplication()
	{
		int[][] first = {{20, 21, 22, 23}, {24, 25, 26, 27}, {28, 29, 30, 31}};
		int[][] second = {{32, 33}, {34, 35}, {36, 37}, {38, 39}};

		// initialize first and second to the sizes shown in the sample output
		// initialize first and second with the values shown in the sample output

		int product = MatrixManipulator.multiply(first, 0, second, 0);
		System.out.println("first:");
		printMatrix(first);
		System.out.println("\nsecond:");
		printMatrix(second);
		System.out.println();
		System.out.println("MatrixManipulator.multiply(first, 0, second, 0): ");
		System.out.println(product);

		product = MatrixManipulator.multiply(first, 0, second, 1);
		System.out.println("\nMatrixManipulator.multiply(first, 0, second, 1): ");
		System.out.println(product);

		product = MatrixManipulator.multiply(first, 1, second, 0);
		System.out.println("\nMatrixManipulator.multiply(first, 1, second, 0): ");
		System.out.println(product);

		product = MatrixManipulator.multiply(first, 1, second, 1);
		System.out.println("\nMatrixManipulator.multiply(first, 1, second, 1): ");
		System.out.println(product);
	}

	public static void testMultiplication()
	{
		int[][] first = {{20, 21, 22, 23}, {24, 25, 26, 27}, {28, 29, 30, 31}};
		int[][] second = {{32, 33}, {34, 35}, {36, 37}, {38, 39}};

		// initialize first and second to the sizes shown in the sample output
		// initialize first and second with the values shown in the sample output

		int[][] product = MatrixManipulator.multiply(first, second);

		printMatrix(first);
		System.out.println("*");
		printMatrix(second);
		System.out.println("=");
		printMatrix(product);
	}

	private static void printMatrix(int[][] matrix)
	{
		if (matrix != null)
			for (int row = 0; row < matrix.length; row++)
				System.out.println(java.util.Arrays.toString(matrix[row]));
		else
			System.out.println("null");
	}
}
