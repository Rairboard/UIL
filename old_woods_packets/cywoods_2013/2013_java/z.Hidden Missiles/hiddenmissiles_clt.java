import java.io.*;
import java.util.*;

public class hiddenmissiles_clt
{
	//instance variables go here
	private char[][] mat;
	
	public void run()throws Exception
	{
		Scanner file=new Scanner(new File("hiddenmissilesj.dat"));
		int run=file.nextInt();
		file.nextLine();
		for(int q=0; q<run; q++)
		{
			int nr=file.nextInt();
			int nc=file.nextInt();
			file.nextLine();
			mat=new char[nr][nc];
			for(int i=0; i<nr; i++)
			{
				mat[i]=file.nextLine().toCharArray();
			}
			int tot=0;
			ArrayList<String> locs=new ArrayList<String>();
			for(int r=0; r<mat.length; r++)
			{
				for(int c=0; c<mat[r].length; c++)
				{
					if(mat[r][c]=='o')
					{
						tot++;
						locs.add("(" + r + ", " + c + ")");
					}
				}
			}
			for(String s : locs)
			{
				System.out.println(s);
			}
			System.out.println(tot + "\n");
		}
	}
	
	public static void main(String[] args)throws Exception
	{
		hiddenmissiles_clt a=new hiddenmissiles_clt();
		a.run();
	}	
}