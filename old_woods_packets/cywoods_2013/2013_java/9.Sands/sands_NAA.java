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

class sands
{
	char[][][] mat;

	public void run()throws Exception
	{
		Scanner file=new Scanner(new File("sandsJ.dat"));
		int times = parseInt(file.nextLine());
		for(int n=0;n<times;n++)
		{
			int height = file.nextInt();
			int rows = file.nextInt();
			int cols = file.nextInt();
			file.nextLine();
			String startX="";
			String startY="";
			char[][][] mat = new char[height][rows][cols];
			double[][][] sand = new double[height][rows][cols];
			for(int x=0;x<height;x++)
			{
				for(int y=0;y<rows;y++)
				{
					String line = file.nextLine();
					String linec=line;
					while(linec.indexOf("o")>=0)
					{
						startX+=y+" ";
						startY+=linec.indexOf("o")+" ";
						linec = linec.substring(0,linec.indexOf("o"))+""+linec.substring(linec.indexOf("o")+1);
					}
					mat[x][y]=line.toCharArray();
				}
			}
			double lost = 0;
			double floor = 0;
			for(int x=0;x<height;x++)
			{
				for(int y=0;y<rows;y++)
				{
					for(int z=0;z<cols;z++)
					{
						if(mat[x][y][z]=='o')
						{
							sand[x][y][z]+=1.0/startY.split(" ").length;
						}
						if(mat[x][y][z]=='^')
						{
							int[] fY={-1, -1, -1,  0, 0,  1, 1, 1};
							int[] fZ={-1,  0,  1, -1, 1, -1, 0, 1};
							boolean[] go = {true,true,true,true,true,true,true,true};
							int fs = 0;
							for(int i=0;i<fY.length;i++)
							{
								if(x+1<0||x+1>=mat.length||y+fY[i]<0||y+fY[i]>=mat[x+1].length||z+fZ[i]<0||z+fZ[i]>=mat[x+1][y+fY[i]].length)
								{
									fs++;
									go[i]=false;
								}
							}
							for(int i=0;fs!=8&&i<fY.length;i++)
							{
								if(go[i])
									sand[x+1][y+fY[i]][z+fZ[i]]+=sand[x][y][z]/(8-fs);
							}
						}
						if(mat[x][y][z]=='.'||mat[x][y][z]=='o')
						{
							if(x+1<mat.length)
							{
								sand[x+1][y][z]+=sand[x][y][z];
							}
							else
							{
								floor+=sand[x][y][z];
							}
						}
						if(mat[x][y][z]=='#')
						{
							lost+=sand[x][y][z];
						}
					}
				}
			}
			lost*=100;
			floor*=100;
			System.out.printf("%.2f %.2f\n",floor, 100f-floor);
		}
	}
	public static void main(String[] args)throws Exception
	{
		new sands().run();
	}
}