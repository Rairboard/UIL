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


class SudokuSolver
{
	//instance variables go here
	//has the what can go here check
	//should add the where can this go check

	public void run()throws Exception
	{
		Scanner file=new Scanner(new File("SudokuGrids.dat"));
		int times = file.nextInt();
		file.nextLine();
		int[][] mat = new int[9][9];
		for(int n=0;n<times;n++)
		{
			int cases = file.nextInt();
			file.nextLine();

			//read grid
			String totGrid="";
			for(int i=0;i<9;i++)
			{
				String line = file.nextLine();
				for(int j=0;j<9;j++)
				{
					mat[i][j]=parseInt(""+line.charAt(j));
					//out.print(line.charAt(j));
				}
				//out.println();
				totGrid+=line;
			}

			//solve it all
			m:while(totGrid.indexOf('0')>=0)
			{
				ArrayList<Integer> zeroX = new ArrayList<Integer>();
				ArrayList<Integer> zeroY = new ArrayList<Integer>();
				if(totGrid.charAt(0)=='0')
				{
					zeroX.add(0);
					zeroY.add(0);
				}
				int lastFound=0;
				while(totGrid.indexOf('0',lastFound+1)>=lastFound+1)
				{
					int loc = totGrid.indexOf('0',lastFound+1);
					lastFound = loc;
					//x = loc/9
					//y = loc%9
					zeroX.add(loc/9);
					zeroY.add(loc%9);
				}
				int s = zeroX.size();
				int cnt = 0;
				l:while(!zeroX.isEmpty()&&s!=cnt)
				{
					int tx=zeroX.remove(0);
					int ty=zeroY.remove(0);

					//three shads 
					//                   1      2      3      4      5      6      7      8      9
					boolean[] shadR = {false, false, false, false, false, false, false, false, false};
					boolean[] shadC = {false, false, false, false, false, false, false, false, false};
					boolean[] shadS = {false, false, false, false, false, false, false, false, false};
					//grab the row
					for(int i=0;i<9;i++)
					{
						if(mat[tx][i]>0)
						{
							shadC[mat[tx][i]-1]=true;
						}
					}
					//grab the col
					for(int i=0;i<9;i++)
					{
						if(mat[i][ty]>0)
						{
							shadR[mat[i][ty]-1]=true;
						}
					}
					//the square
					//top left corner is 3(cx/3) 3(cy/3)
					for(int x=3*(tx/3), j=0;j<3;j++, x=3*(tx/3))
					{
						x=x+j;
						for(int y=3*(ty/3), k=0;k<3;k++, y=3*(ty/3))
						{
							y=y+k;
							if(mat[x][y]>0)
							{
								shadS[mat[x][y]-1]=true;
							}
						}
					}
					//out.println(Arrays.toString(shadR));
					//out.println(Arrays.toString(shadC));
					//out.println(Arrays.toString(shadS));
					int fs = 0;
					b:for(int a=0;a<9;a++)
					{
						if(shadR[a]||shadC[a]||shadS[a])
						{
							continue b;
						}
						else
						{
							fs+=1;
							mat[tx][ty]=a+1;
							totGrid=totGrid.substring(0,tx*9+ty)+(a+1)+totGrid.substring(tx*9+ty+1);
						}
					}
					if(fs>1)
					{
						mat[tx][ty]=0;
						totGrid=totGrid.substring(0,tx*9+ty)+(0)+totGrid.substring(tx*9+ty+1);
						/*if(zeroX.size()==0)
						{
							//out.println("break");
							break m;
						}*/
						zeroX.add(tx);
						zeroY.add(ty);
					}

					//out.println(totGrid.substring(0,9));
					//out.println(totGrid.substring(9,18));
					//out.println(totGrid.substring(18,27));
					//out.println(totGrid.substring(27,36));
					//out.println(totGrid.substring(36,45));
					//out.println(totGrid.substring(45,54));
					//out.println(totGrid.substring(54,63));
					//out.println(totGrid.substring(63,72));
					//out.println(totGrid.substring(72));

					//out.println(zeroX);
					//out.println(zeroY);
					//new Scanner(System.in).nextLine();
					cnt++;
					if(s!=zeroX.size())
					{
						cnt=0;
						s=zeroX.size();
					}
				}
			}

			for(int x=0;x<mat.length;x++)
			{
				for(int y=0;y<mat[x].length;y++)
				{
					if(y%3==0)
						out.print(" ");
					out.print(mat[x][y]);
				}
				if(x%3==2)
					out.println();
				out.println();
			}
			out.println();

			//print whats here
			for(int c=0;c<cases;c++)
			{
				String[] ls = file.nextLine().split(" ");
				int tx = parseInt(ls[0])-1;
				int ty = parseInt(ls[1])-1;
				out.println(mat[tx][ty]+" at: ("+tx+","+ty+")");
			}
		}
	}

	public static void main(String[] args)throws Exception
	{
		SudokuSolver a=new SudokuSolver();
		a.run();
	}
}
