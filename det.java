import java.lang.*;
public class det{
	
	public static void main(String args[]){		
		float [][] mat = {{2,0,0,1},
						  {0,2,0,2},
						  {0,0,2,4},
						  {0,0,0,2}};  
		float [][] mat1 = inverse(mat);		 	
		
		for(int i = 0; i < mat1.length; i++){		 	
			for(int j = 0; j < mat1.length; j++){
				System.out.print(mat1[i][j] + " ");
			}
			System.out.println("");
		}		
	}

	public static float[][] inverse(float [][] array){
		
		int size = array.length;
		float [][]inv = new float[size][size];
		float value = determinant(array);		

		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				inv[i][j] = (float)(Math.pow(-1,i+j)*determinant(coFactor(i,j,array)));
				if(inv[i][j]==-0.0){
					inv[i][j] = 0;
				}	
			}
		}

		float [][]invTrans = new float[size][size];
		
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				invTrans[i][j] = inv[j][i]/value;
			}	
		}

		return invTrans;											

	}


	public static float[][] coFactor(int a, int b, float [][]array){

		float [][] coFac = new float[array.length- 1][array[0].length-1];	
		int p = 0;
		int q = 0;
		int row = array.length;
		int col = array[0].length;

		for(int i = 0; i < row; i++){
			if(i!=a){
				q = 0;
				for(int j = 0; j < col; j++){					
					if(j!=b){
						coFac[p][q] = array[i][j];
						q++;
					}	
				}
				p++;
			}	
		}

		return coFac;
	} 

	public static float determinant(float [][]array){	
		int i = 0;
		float deterFinal = 0;
		int size = array.length;
		if(size==1){
			return array[0][0];
		}
		for(int j = 0; j < size; j++){
			deterFinal = deterFinal + (float)(array[i][j]*determinant(coFactor(i,j,array))*Math.pow(-1,i+j));				
		}
		return deterFinal;
	}
}