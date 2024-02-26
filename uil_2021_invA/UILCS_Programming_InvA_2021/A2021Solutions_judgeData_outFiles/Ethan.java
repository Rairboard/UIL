import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Ethan
{
	public static int[] getCoordinates(int[][] keypad, int num)
	{
		int[] coordinates={-1,-1};
		for(int x=0;x<keypad.length;x++)
		{
			for(int y=0;y<keypad[x].length;y++)
			{
				if(keypad[x][y]==num)
				{
					coordinates[0]=x;
					coordinates[1]=y;
				}
			}
		}
		return coordinates;
	}

	public static void main(String args[]) throws FileNotFoundException
	{
		Scanner s;
		if(args.length>0)
			s = new Scanner(new File(args[0]));
		else
			s = new Scanner(new File("ethan.dat"));

		int numCases=s.nextInt();
		for(int caseCount=0;caseCount<numCases;caseCount++)
		{
			int dimension=s.nextInt();

			int[][] keypad=new int[dimension][dimension];
			for(int x=0;x<dimension;x++)
			{
				for(int y=0;y<dimension;y++)
				{
					keypad[x][y]=s.nextInt();
				}
			}
			double distance=0.0;
			for(int a=1;a<(keypad.length*keypad.length);a++)
			{
				int[] current = getCoordinates(keypad,a);
				int[] next = getCoordinates(keypad,a+1);
				distance+=Math.sqrt(Math.pow(current[0]-next[0],2)+Math.pow(current[1]-next[1],2));
			}
			System.out.print("Case "+(caseCount+1)+" distance: ");
			System.out.printf("%.4f",distance);
			System.out.println();
		}
	}
}