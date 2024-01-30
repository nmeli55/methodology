//დაწერეთ მეთოდი რომელსაც არგუმენტად გადმოეცემა int-ების 
//მატრიცა და ამ მატრიცას ატრიალებს სიმეტრიულად x ღერძის მიმართ (Final11)
//1, 2 -> 3,4
//3, 4     1,2
//Tags: Matrix, Rearrange elements

import java.util.Arrays;

import acm.program.ConsoleProgram;

public class matriccccc extends ConsoleProgram{
	public void run() {
		int matrix [][] = new int [][] {{1, 2}, {3, 4}};
		for(int i = 0; i < matrix.length/2; i++){
			swapMatrix(matrix, i, matrix.length- 1 - i);
		}
			printMartix(matrix);
		
	}

	private void printMartix(int [][] matrix) {
		// TODO Auto-generated method stub
		
		for( int [] array : matrix ) {
			println(Arrays.toString(array));
		}
	}

	private void swapMatrix(int[][] arr, int i, int j) {
		// TODO Auto-generated method stub
		int [] tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
		
	}
}
