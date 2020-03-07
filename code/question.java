import java.util.Scanner;
import java.io.FileInputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.*;
import java.util.*;

public class TwoDBlockMatrix{

	public float [][] matrix;

	public static void main(String args[]){

		InputStream in = new FileInputStream("testcase.txt");
		TwoDBlockMatrix mat = buildTwoDBlockMatrix(in);
        
		System.out.println(mat.toString());
	}


	public TwoDBlockMatrix(float[][] array){
		this.matrix = array;
	}



	public static TwoDBlockMatrix buildTwoDBlockMatrix(java.io.InputStream in){
		
		int content;
        String t = "";

        while ((content = in.read()) != -1) {
            t = t + (char)content;
        }

		Scanner s1 = new Scanner(t);
		int []dim = new int[2];
		dim = dimsMatrix(s1);
		Scanner s = new Scanner(t);
		int row = dim[0];
		int col = dim[1];
		System.out.println("rows: " + row);
		System.out.println("columns: " + col);				
		float [][]matrix = new float[row][col];

		
		for(int i = 0; i < row;i++){
			for(int j = 0; j < col; j++){
				matrix[i][j] = 0;
			}
		}

		int key = 0;
		int i = 0;
		int j = 0;
		int temp1 = 0;
		int temp2 = 0;
		String d = "";
		while(s.hasNextLine()){
			
			if(s.hasNextFloat()){
				if(key==0){
					
					i = (int)s.nextFloat();
					System.out.println("i" + i);
					j = (int)s.nextFloat();	
					System.out.println("j" + j);
					temp1 = i;
					temp2 = j;

				}
				else{
					System.out.println("Storing done");							
					matrix[temp1-1][temp2-1] = s.nextFloat();
					temp2++;
				}
			}

			else{

				d = s.next();
				if(d.equals("#")){
					System.out.println("# done");
					if(s.hasNextLine()){
						i = (int)s.nextFloat();
						j = (int)s.nextFloat();
						temp1 = i;
						temp2 = j;
						System.out.println("i" + i);
						System.out.println("j" + j);
					}	
					
				}
				else{
					float f = Float.valueOf(d.replaceAll("[^\\d.]+|\\.(?!\\d)", ""));		
					System.out.println("conversion to float");
					matrix[temp1-1][temp2-1] = f;
					temp1++;
					temp2 = j;
				}
			}
			key =1;
		}

		for(i = 0; i < row; i++){
			for(j = 0; j < col; j++){
				System.out.print(matrix[i][j] + " ");

			}
			System.out.println("\n");	
		}
			
		TwoDBlockMatrix blockMat = new TwoDBlockMatrix(matrix);

		return blockMat; 	

	}



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



	public TwoDBlockMatrix multiply (TwoDBlockMatrix other) throws IncompatibleDimensionException{

		if (this.matrix[0].length!=other.matrix.length) {
            throw new IncompatibleDimensionException ("Incompatible Dimension");
        }
		else{

			float [][]finals = new float[this.matrix.length][other.matrix[0].length];

			for(int i = 0; i < this.matrix.length; i++){
				for(int j = 0; j < other.matrix[0].length; j++){
					finals[i][j] = 0;
					for(int t = 0; t < other.matrix.length; t++){
						finals[i][j] = finals[i][j] + matrix[i][t]*other[t][j];
					}	
				}
			}
		}	

		TwoDBlockMatrix multiMatrix = new TwoDBlockMatrix(finals);
		return multiMatrix;
	}



	public TwoDBlockMatrix getSubBlock (int row_start, int col_start, int row_end, int col_end) throws SubBlockNotFoundException{

		m = this.matrix.length;
		n = this.matrix[0].length;
		if (row_end-row_start==0 || col_end-col_start==0 || row_start<1 || row_start>m || row_end<1 || row_end>m+1 || col_start<1 || col_start>n || col_end<1 || col_end>n+1) {
            throw new SubBlockNotFoundException ("Sub Block Not Found");
        }
        
        else{
			float [][]subMat = new float[row_end - row_start+1][col_end - col_start+1];

			for(int i = 0; i < row_end - row_start; i++){
				for( int j = 0; j < col_end - col_start; j++){
					subMat[i][j] = matrix[row_start+i-1][col_start+j-1];	
				}
			}
		}	

		TwoDBlockMatrix slicedMatrix = new TwoDBlockMatrix(subMat);
		return slicedMatrix;
	}



	public TwoDBlockMatrix inverse() throws InverseDoesNotExistException{
		
		int size = this.matrix.length;
		int size1 = this.matrix[0].length;
		float value = determinant(this.matrix);	

		if (size!=size1 || value==0) {
            throw new InverseDoesNotExistException("Inverse dont exist");
        }

        else{
			float [][]inv = new float[size][size];

			for(int i = 0; i < size; i++){
				for(int j = 0; j < size; j++){
					inv[i][j] = (float)(Math.pow(-1,i+j)*determinant(coFactor(i,j,this.matrix)));
					if(inv[i][j]==-0.0){
						inv[i][j] = 0;
					}	
				}
			}
		}	

		TwoDBlockMatrix invMat = new TwoDBlockMatrix(inv);
		return invMat;
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
	}


	public static int[] dimsMatrix(java.util.Scanner s){

			int key=0;
			int i = 0;
			int rowMax=0;
			int colMax = 0;
			int count=0;	
			float []dim = new float[2];
			dim[0] = 0;
			dim[1] = 0;	
			String d = "";
			int flag = 0;
			while(s.hasNextLine()){
				
				if(key!=0){
					if(s.hasNextInt()){
						d = s.nextLine();	
					}
					else{				
						d = s.next();		
					}
				}

				if(flag==1){

					count = 0;
					for(int c = 0; c < d.length(); c++){
						if(d.charAt(c) == ' '){
							count++;
						}
					}
					if(colMax < count + (int)dim[1]){
						colMax = count + (int)dim[1];
					}
				
					flag = 0; 	
				
				}


				if(key == 0 || d.equals("#")){
				

					if(rowMax<(int)dim[0]+i-2 && key > 0){ 				
						rowMax = (int)dim[0]+i-2;								
					}

					if(s.hasNextLine()){
						dim[0] = s.nextFloat();	
						dim[1] = s.nextFloat();
					
						flag = 1;
						
						d = s.nextLine();
				
					}															
					i=0;	
				}
			
				i++;
			
				key=1;
			
			}

			int []dims = new int[2];
			dims[0] = rowMax;
			dims[1] = colMax;
		return dims;				

	}





	public static String toString(){

		float [][]array = this.matrix;
		int i = 0;
		String main = "";	
		while(i<array.length){
			int j=0;						
			int flag = 0;							
			int colStart = 0;					
			int rowStart = i;
			int colEnd = 0;
			int rowEnd= 0;

			while(j < array[0].length){
				if(array[i][j]!=0){
					if(flag==0){
						colStart = j;
						rowStart = i;
						colEnd = colStart-1;
						flag = 1;		
					}				
					colEnd++;
				}

				else if(flag!=0){
					int temp = i+1;
					int k_copy = 0;
					while(temp<array.length){
						int k = colStart;
						while(k <= colEnd){
							k_copy = k;
							if(array[temp][k]==0){
								break;
							}
							k++;
						}
						if(array[temp][k_copy]==0){
							rowEnd = temp-1;
							flag = 0;
							j = j-1;
							main = main + "\n" + String.valueOf((int)rowStart+1) + " " + String.valueOf((int)colStart+1) + "\n"; 
							for(int m = rowStart; m <= rowEnd; m++){
								for(int n = colStart; n <= colEnd; n++){		
									if(n == colEnd){
										main =  main + String.valueOf((int)array[m][n]) + ";" + "\n" ; 
									}
									else{
										main = main + String.valueOf((int)array[m][n]) + " ";	
									}
									array[m][n] = 0;
								}
								if(m==rowEnd){
									main = main + "#" ;
								}
							}
							break;
						}
						temp++;
						if(temp == array.length){
							rowEnd = temp-1;
							flag = 0;
							j = j-1;
							main = main + "\n" +String.valueOf((int)rowStart+1) + " " + String.valueOf((int)colStart+1) + "\n";
							for(int m = rowStart; m <= rowEnd; m++){
								for(int n = colStart; n <= colEnd; n++){
									if(n == colEnd){
										main = main + String.valueOf((int)array[m][n]) + ";" + "\n"; 
									}
									else{
										main = main + String.valueOf((int)array[m][n]) + " ";	
									}
									array[m][n] = 0;
								}
								if(m==rowEnd){
									main = main  + "#"  ;
								}
							}
							break;						
						}
					} 	
				}
				j++;

				if(j==array[0].length && flag==1){
					int temp = i+1;
					int k_copy = 0;
					if(temp == array.length){
						temp = temp-1;
					}
					while(temp<array.length){
						int k = colStart;
						while(k <= colEnd){
							k_copy = k;
							if(array[temp][k]==0){
								break;
							}
							k++;
						}
						if(array[temp][k_copy]==0){
							rowEnd = temp-1;
							flag = 0;
							main = main + "\n" +String.valueOf((int)rowStart+1) + " " + String.valueOf((int)colStart+1) + "\n";
							for(int m = rowStart; m <= rowEnd; m++){
								for(int n = colStart; n <= colEnd; n++){
									if(n == colEnd){
										main =  main + String.valueOf((int)array[m][n] ) + ";" + "\n" ; 
									}
									else{
										main = main + String.valueOf((int)array[m][n] ) + " ";	
									}
									array[m][n] = 0;
								}
								if(m==rowEnd){
									main = main + "#" ;
								}
							}
							break;
						}
						temp++;
						if(temp == array.length){
							rowEnd = temp-1;
							flag = 0;
							main = main + "\n" + String.valueOf((int)rowStart+1) + " " + String.valueOf((int)colStart+1) + "\n";
							for(int m = rowStart; m <= rowEnd; m++){
								for(int n = colStart; n <= colEnd; n++){
									if(n == colEnd){
										main = main + String.valueOf((int)array[m][n]) + ";" + "\n"; 
									}
									else{
										main = main + String.valueOf((int)array[m][n]) + " ";	
									}
									array[m][n] = 0;
								}
								if(m==rowEnd){
									main =  main + "#"  ;
								}
							}
							break;						
						}

					}		
				}

			}
			i++;	
		}
		return main;
	}



	class IncompatibleDimensionException extends Exception{

	    public IncompatibleDimensionException(String s)
	    {	
	    // Call constructor of parent Exception
	        super(s);
	        }
	}

	class SubBlockNotFoundException extends Exception{

	    public SubBlockNotFoundException(String s)
	    {
	    // Call constructor of parent Exception
	        super(s);
	        }
	}

	class InverseDoesNotExistException extends Exception{

	    public InverseDoesNotExistException(String s)
	    {
	    // Call constructor of parent Exception
	        super(s);
	        }
	}

}

	/*
	public TwoDBlockMatrix(float[][] array){
		this.matrix = array;
	}

	public String toString(){

	}

	public TwoDBlockMatrix transpose(){

	}

	public TwoDBlockMatrix multiply(TwoDBlockMatrix other){

	}

	public TwoDBlockMatrix getSubBlock(int row_start, int col_start, int row_end, int col_end){

	}

	public TwoDBlockMatrix inverse(){

	}

	public static void main(String[] args) {
		
	}
*/

