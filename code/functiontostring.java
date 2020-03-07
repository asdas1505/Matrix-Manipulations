public class functiontostring{
	

	public static void main(String args[]){

		float [][]matrix = {{1,2,3,0,1}, {1,2,3,0,1}, {1,2,3,1,1},{0,1,1,1,1}};		
		int j = 0;											
		int i = 0;												
													
		System.out.println(dimSubBlock(matrix));
	}

	public static String dimSubBlock(float [][]array){

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
}