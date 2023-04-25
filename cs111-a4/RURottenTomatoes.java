/*************************************************************************
 *  Compilation:  javac RURottenTomatoes.java
 *  Execution:    java RURottenTomatoes
 *
 *  @author: Haider Ali ha484@scarletmail.rutgers.edu Ha484
 *
 * RURottenTomatoes creates a 2 dimensional array of movie ratings 
 * from the command line arguments and displays the index of the movie 
 * that has the highest sum of ratings.
 *
 *  java RURottenTomatoes 3 2 5 2 3 3 4 1
 *  0
 *************************************************************************/

public class RURottenTomatoes {

    public static void main(String[] args) 
	{
		int r,c,i,j,k=2,m=0,s=0,ind=0;
	
		r = Integer.parseInt(args[0]);
		c = Integer.parseInt(args[1]);
		int arr[][]=new int[r][c];
		
		for(i = 0; i < r; i++)
		{
			for(j = 0;j < c; j++)
			{
				arr[i][j]=Integer.parseInt(args[k]);
				k++;
			}
		}
		
		for( i = 0; i < c; i++)
		{
			
			for(j = 0; j < r;j++)
			{
			  s=s+arr[j][i];  
			}
			
			if( s > m)
			{
				m=s;
			
				ind=i;
			}
			s=0;

		}
	
		System.out.println(ind);
	 
	}
}
