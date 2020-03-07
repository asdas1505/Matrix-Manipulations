import java.util.Scanner;
import java.io.FileInputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.*;
import java.util.*;
import java.lang.Cloneable; 

public static TwoDBlockMatrix buildTwoDBlockMatrix(java.io.InputStream in){
	
	try{
				InputStream in = new FileInputStream("testcase.txt");				
				InputStream inp = in;
				Scanner s1 = new Scanner(in);
				int []dim = new int[2];
				dim = dimsMatrix(s1);
				inp = new FileInputStream("testcase.txt"); 				// Reading file second time 
				Scanner s = new Scanner(inp);
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
		

		}

		catch(FileNotFoundException e){
				System.out.println("File not found");
		}

	TwoDBlockMatrix blockMat = new TwoDBlockMatrix(matrix);

	return blockMat; 	

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



