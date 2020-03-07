
public TwoDBlockMatrix getSubBlock (int row_start, int col_start, int row_end, int col_end){

	float [][]subMat = new float[row_end - row_start+1][col_end - col_start+1];

	for(int i = 0; i < row_end - row_start+1; i++){
		for( int j = 0; j < col_end - col_start+1; j++){
			subMat[i][j] = matrix[row_start+i-1][col_start+j-1];	
		}
	}

	TwoDBlockMatrix slicedMatrix = new TwoDBlockMatrix(subMat);

	return slicedMatrix;
}


/*public class subMatrix{
	
	public static void main(String args[]){

		int [][]matrix = new int[3][3];
											// TwoDBlockMatrix getSubBlock (int row_start, int col_start, int row_end, int col_end)
		matrix[0][0] = 1;
		matrix[0][1] = 2;
		matrix[0][2] = 3;
		matrix[1][0] = 4;
		matrix[1][1] = 5;
		matrix[1][2] = 6;
		matrix[2][0] = 7;
		matrix[2][1] = 8;
		matrix[2][2] = 9;

		int row_start, col_start, row_end, col_end;
		row_start = 2;
		col_start = 1;
		row_end = 3;
		col_end = 2;

		


		for(int i = 0; i < row_end - row_start+1; i++){
			for( int j = 0; j < col_end - col_start+1; j++){
				subMat[i][j] = matrix[row_start+i-1][col_start+j-1];	
			}
		}	

		

		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				System.out.print(matrix[i][j] + " ");	
			}
			System.out.print("\n");	
		}	

		System.out.print("\n");	

		for(int i = 0; i < subMat.length; i++){
			for(int j = 0; j < subMat[0].length; j++){
				System.out.print(subMat[i][j] + " ");	
			}
			System.out.print("\n");
		}

	}
}
*/	
	


