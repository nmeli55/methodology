import java.util.Arrays;

import acm.program.ConsoleProgram;
//for squares!!!
public class transposing extends ConsoleProgram {
	public void run() {
		int[][] matrix = new int[][] { 
									{ 12, 11, 10 }, 
									{ 4, 2, 3 }, 
									{ 7, 8, 9 }, 
									};
		for(int i = 0; i < matrix.length; i++) {
			for(int j = i; j < matrix[0].length; j++) {
				swapMatrix(matrix, i,j,j,i);
				//anu, sad aris row da col(i,j), da sad unda iyvnen row da col(j,i)
				
			}
		}
		//for ro morcha, unda movaxdinot daprintva!
		printM(matrix);
		
	}

	private void printM(int[][] matric) {
		// prints thy matrix with the help of Gods of Matrices!~
		for(int[] arrrr : matric) {
			println(Arrays.toString(arrrr));
		}
		
	}

	private void swapMatrix(int [][] matrix, int i, int j, int j2, int i2) {
		// let thy matrices be swapped~!
		//tu ormagi cikli gvaq for ebis, mashin tmp aris chveulebrivi int, tu ara da arrayia int[[
		int tmp = matrix[i][j];
		matrix[i][j] = matrix[j2][i2];
		matrix[j2][i2] = tmp;
		//chveulebrivi two pointer solution midis rogorc chans yvela swapping motion ze
		
	}
}
