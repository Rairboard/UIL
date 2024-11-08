import java.io.*;
import java.util.*;
import java.text.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Character.*;
import static java.util.Collections.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import java.math.*;

class thingcounter
{
	//instance variables go here

	public void run()throws Exception
	{
		Scanner file=new Scanner(new File("thingcounter.dat"));
		//
		int times = Integer.parseInt(file.nextLine());
		for(int n = 0; n<times; n++)
		{
			int row=file.nextInt();
			int col=file.nextInt();
			file.nextLine();
			char[][] mat = new char[row][col];
			for(int x=0;x<row;x++)
			{
				mat[x]=file.nextLine().toCharArray();
			}
			int cases = parseInt(file.nextLine());
			for(int t=0;t<cases;t++)
			{
				char[][] temp = new char[row][col];
				for(int x=0;x<row;x++)
				{
					for(int y=0;y<col;y++)
					{
						//out.print(mat[x][y]);
						temp[x][y]=mat[x][y];
					}
					//out.println("");
				}
				int xL=file.nextInt();
				int yL=file.nextInt();
				int count=0;
				char toFind = temp[xL][yL];
				//out.println(toFind+" at "+xL+" "+yL);
				ArrayDeque<Integer> ad = new ArrayDeque<Integer>();
				ad.addLast(xL);
				ad.addLast(yL);
				while(!ad.isEmpty())
				{
					int xH=ad.removeFirst();
					int yH=ad.removeFirst();
					if(xH>=0&&yH>=0&&xH<temp.length&&yH<temp[xH].length&&temp[xH][yH]==toFind)
					{
						count++;
						temp[xH][yH]=(char)(7);
						//up
						ad.addLast(xH-1);
						ad.addLast(yH);
						//upR
						//ad.addLast(xH-1);
						//ad.addLast(yH+1);
						//R
						ad.addLast(xH);
						ad.addLast(yH+1);
						//dR
						//ad.addLast(xH+1);
						//ad.addLast(yH+1);
						//d
						ad.addLast(xH+1);
						ad.addLast(yH);
						//dl
						//ad.addLast(xH+1);
						//ad.addLast(yH-1);
						//l
						ad.addLast(xH);
						ad.addLast(yH-1);
						//ul
						//ad.addLast(xH-1);
						//ad.addLast(yH-1);
					}
					else
					{
						//nothing
					}
				}
				out.println(count+" "+toFind);
				//
			}
			if(n!=times-1)
				out.println();
		}
	}
	public static void main(String[] args)throws Exception
	{
		new thingcounter().run();
	}
}
