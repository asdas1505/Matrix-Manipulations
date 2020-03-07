
public TwoDBlockMatrix transpose(){

	int [][]matrixT = new int[this.matrix[0].length][this.matrix.length];

	for(int i = 0; i < this.matrix.length; i++){
		for(int j = 0; j < this.matrix[0].length; j++){
			matrixT[j][i] = matrix[i][j];	
		}
	}
	TwoDBlockMatrix transMatrix = new TwoDBlockMatrix(matrixT);		
	
	return transMatrix;
}

/*public class Transpose{
	
	public static void main(String args[]){

		int [][]matrix = new int[3][3];

		matrix[0][0] = 1;
		matrix[0][1] = 2;
		matrix[0][2] = 3;
		matrix[1][0] = 4;
		matrix[1][1] = 5;
		matrix[1][2] = 6;
		matrix[2][0] = 7;
		matrix[2][1] = 8;
		matrix[2][2] = 9;

		int [][]matrixT = new int[3][3];

		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				matrixT[j][i] = matrix[i][j];	
			}
		}

		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				System.out.print(matrixT[i][j] + " ");			 	
			}
			System.out.println("\n");
		}
	}
}
*/
