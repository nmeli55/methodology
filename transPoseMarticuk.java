//დაწერეთ მეთოდი რომელსაც არგუმენტად გადმოეცემა int-ების 
//მატრიცა და ამ მატრიცას უკეთებს ტრანსპონირებას (Final12)
//Transpose of a matrix is a matrix which is formed by 
//turning all the rows of the source matrix into columns and vice-versa.
//[[1, 2, 3, 4],		          [[1, 5, 9, 3],
//[5, 6, 7, 8],			[2, 6, 0, 4],
//[9, 0, 1, 2], —------> 		[3, 7, 1, 5],
//[3, 4, 5, 0]]			[4, 8, 2, 0]]
//Tags: Matrix, Rearrange elements

import java.util.Arrays;

import acm.program.ConsoleProgram;

public class transPoseMarticuk extends ConsoleProgram{
	public void run() {
		int[][] matrix = new int[][] { 
									{ 12, 11, 10 }, 
									{ 4, 2, 3 }, 
									{ 7, 8, 9 }, 
									{ 1, 5, 6 } };
		
		int rows = matrix.length;
		int columns = matrix[0].length;
		
		int [][] transpose = new int[columns][rows];
		
		for(int i = 0; i < transpose.length; i++) {
			for(int j = 0; j < transpose[0].length; j++) {
				transpose[i][j] = matrix[j][i];
			}
		}
		printMatrix(transpose);
		
	}

	private void printMatrix(int [][] matr) {
		// TODO Auto-generated method stub
		for(int [] arr : matr) {
			println(Arrays.toString(matr));
		}
	}
}
