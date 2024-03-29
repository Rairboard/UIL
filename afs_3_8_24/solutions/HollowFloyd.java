import java.io.*;
import java.util.*;
import static java.lang.System.*;
import static java.lang.Math.*;

//Given an integer, output Floyd's triangle of that size
public class HollowFloyd
{
	public static void main(String [] args) throws FileNotFoundException 
	{
		Scanner f = new Scanner(new File("hollowfloyd.dat"));
		while(f.hasNext())
		{
			int n = f.nextInt();
			for(int r=0;r<n;r++)
			{
				for(int c=0;c<=r;c++)
				{
					if(r==0||r==n-1||c==0||c==r)
						out.print("*");
					else
						out.print(" ");
				}
				out.println();
			}
		}
	}
}
/*
Student Input
4
6
10

Student Output
*
**
* *
****
*
**
* *
*  *
*   *
******
*
**
* *
*  *
*   *
*    *
*     *
*      *
*       *
**********

Test Input
4
6
10
3
2
1
5

Test Output
*
**
* *
****
*
**
* *
*  *
*   *
******
*
**
* *
*  *
*   *
*    *
*     *
*      *
*       *
**********
*
**
***
*
**
*
*
**
* *
*  *
*****
*/