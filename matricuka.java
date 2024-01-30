import java.util.Arrays;

import acm.program.ConsoleProgram;
//დაწერეთ მეთოდი რომელსაც არგუმენტად გადმოეცემა int-ების 
//მატრიცა და ამ მატრიცას ატრიალებს სიმეტრიულად y ღერძის მიმართ (Final10)
//1, 2 -> 2,1
//3, 4     4,3
//Tags: Matrix, Rearrange elements

public class matricuka extends ConsoleProgram{
	public void run() {
		int [][] matrixiko = new int [][] {{ 1, 2 },
											{3, 4}};
		for(int i = 0; i < matrixiko.length; i++) {
			for(int j = 0; j < matrixiko[0].length/2; j++) {
				reverse(matrixiko[i], j, matrixiko[0].length - 1 - j);
				
			}
		}
		printMatrix(matrixiko);
	}

	private void printMatrix(int[][] matrixiko) {
		// TODO Auto-generated method stub
		for(int[] mat: matrixiko) {
			println(Arrays.toString(mat));
		}
	}

	private void reverse(int[] array, int i, int j) {
		// to pointer reversing
		int  tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
		
	}
}
