import java.util.*;
import java.io.*;
import java . util . Scanner ;
import java.util.*;
import java.io.*;
import java . util . Scanner ;
import java.lang.*;
public class newRead{
	public static void main(String args []){
		try {
				FileInputStream fstream = new FileInputStream("testcase.txt");
				Scanner s1 = new Scanner ( fstream );
				ArrayList<String> arli = new ArrayList<String> ();
				int i = 0;
				int p = 0;
				int q = 0;
				int k = 0;
				int j= 0;
				int n = 0;
				int rowtemp = 0;
				int columntemp = 0;
				int row = 0;
				int column = 0;
				int temp = 0;
				String xy = "";

				while (s1 . hasNextLine ())
				{
					arli.add(s1. nextLine ()) ;
					i++;
					//System . out . println (i);
				}
				//System . out . println ("rr" + i);
				i--;
				//n= i;
				//i = i-1;
				System . out . println (arli);
				//System . out . println (arli.get(i));
				//System . out . println (i);
				//i = i-1;
				//System . out . println ("k" + n);
				fstream = new FileInputStream ("testcase.txt");
				Scanner s2 = new Scanner ( fstream );

				while (s2 . hasNextLine ()){

					j = n;
					while( !arli.get(n).equals("#"))
				{
					//System . out . println ("jatin Ahuja");
						n++;
						//System . out . println ("jatin");
						xy = s2. nextLine ();
						//System . out . println ("n: "+n);
						//System . out . println (arli.get(n));

					}
					String [] laksh = arli.get(n-1).split(" ");
						k = laksh.length -1 ;
						//System . out . println ("bc k " +k);
				//String [] l = new String [];
						String [] l =arli.get(j).split(" ");
						int a = Integer.parseInt(l[0]);
						int b = Integer.parseInt(l[1]);
						//System . out . println (" " +a);
						//System . out . println (" " +b);
						rowtemp = a+n-j-2;
						columntemp =  b+k;
						//System . out . println ("bc" +columntemp);
						//System . out . println ("bc row " +rowtemp);
						//System . out . println ("bc col " +columntemp);

						//System . out . println ("bc" +columntemp);
						//System . out . println ("jatin A");
						//System . out . println ("n: "+n);
						//System . out . println ("i: "+i);
						if(rowtemp > row)
							{row = rowtemp;}
													//System . out . println ("row: "+row);}
						if(columntemp > column)
							{column = columntemp;}
						//System . out . println ("col: "+column);
						

							n++;
							

						if(n==i+1){
							break;
						}
				

				}
				System . out . println ("row"+row);
				System . out . println ("column"+column);



				//storing the values in the matrix

		float [][] A = new float[row][column];
						for ( p=0 ; p < row; p++)
				{
					for ( q = 0; q < column; q++)
					{
						A[p][q] = 0;
					}
				}
		
		for ( p=0 ; p < row; p++)
				{
					System.out.println("");
					for ( q = 0; q < column; q++)
					{
						System.out.print(A[p][q] + " ");
					}
				}
				System . out . println ("yaha ");

				int rowp = 0;
				int columnp=0;

				fstream = new FileInputStream ("testcase.txt");
				Scanner s3 = new Scanner ( fstream );
					n=0;
				while (s2 . hasNextLine ()){
					System . out . println ("bc k0 ");

					j = n;
					while( !arli.get(n).equals("#"))
					{
						//System . out . println ("jatin Ahuja");
						n++;
						//System . out . println ("jatin");
						xy = s3. nextLine ();
						//System . out . println ("n: "+n);
						//System . out . println (arli.get(n));

					}
					String [] lakshya = arli.get(n-1).split(" ");
						k = lakshya.length -1 ;
						//System . out . println ("bc k " +k);
						//String [] l = new String [];
						String [] l =arli.get(j).split(" ");
						int a = Integer.parseInt(l[0]);
						int b = Integer.parseInt(l[1]);
						//System . out . println (" " +a);
						//System . out . println (" " +b);
						rowtemp = a+n-j-2;
						columntemp =  b+k;
						temp =j; 
						System . out . println ("bc k ");

						for (p=a-1; p<rowtemp; p++){
							for(q=b-1; q<columntemp; q++){
								String [] elements =arli.get(temp+1).split(" ");
								if(q == columntemp -1){
								 // take substring last of elements and then convert to integer and store
								 System.out.println ("elements: " + );	
								 A[p][q] = Float.parseFloat(elements[q-b+1].substring(0,elements[elements.length-1].length()-1));
								}
								else{
									A[p][q] = Float.parseFloat(elements[q-b+1]);
								System . out . println ("bc k1 ");
								}
								System . out . println ("bc k2 ");	
								}
								temp++;
								if(temp==n){
						
							break;
						}
								
							}


						//System . out . println ("bc" +columntemp);
						//System . out . println ("bc row " +rowtemp);
						//System . out . println ("bc col " +columntemp);

						//System . out . println ("bc" +columntemp);
						//System . out . println ("jatin A");
						//System . out . println ("n: "+n);
						//System . out . println ("i: "+i);
						//if(rowtemp > row)
							//{row = rowtemp;}
													//System . out . println ("row: "+row);}
						//if(columntemp > column)
							//{column = columntemp;}
						//System . out . println ("col: "+column);
						

							n++;
							

						if(n==i+1){
							break;
						}
				
				}
				System . out . println ("bc k3 ");
		for ( p=0 ; p < row; p++)
				{
					System.out.println("");
					for ( q = 0; q < column; q++)
					{
						System.out.print(A[p][q] + " ");
					}
				}


		} catch ( FileNotFoundException e) {
			System . out . println (" File not found ");
		}
	}
}