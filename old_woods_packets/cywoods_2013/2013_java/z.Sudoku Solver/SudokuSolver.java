//Joshua Haddix

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


class template
{
	private Integer[][] mat;

	public void run()throws Exception
	{
		Scanner file=new Scanner(new File("JudgeSudokuGrids.dat"));
		Scanner chop = new Scanner("");
		int datSize=file.nextInt();
		for(int z=0; z<datSize; z++)
		{
			int toSolve=file.nextInt();
			file.nextLine();
			mat= new Integer[9][9];
			for(int q=0; q<9; q++)
			{
				String str= file.nextLine();
				String[] st= str.split("");
				/*for(String item:st)
					System.out.print(item);
				System.out.println();*/
				for(int pos=1; pos<=9; pos++)
				{
					Integer ger= new Integer(Integer.parseInt(st[pos]));
					mat[q][pos-1]=ger;
				}
			}
			
			for(int z2=0; z2<toSolve; z2++){
				int row= file.nextInt();
				//System.out.print(row);
				int col= file.nextInt();
				//System.out.println(" "+col);
				int ans= solve(mat,row-1,col-1);
				System.out.println(ans);
				mat[row-1][col-1]=ans;
			}
		}

	}
	
	public int solve(Integer[][] grd, int ro, int co)
	{
		ArrayList<Integer> legal= new ArrayList<Integer>();
		for(int nums= 1; nums<10; nums++)
			legal.add(nums);
		if(grd[ro][co]!=0)
			return grd[ro][co];
		else
		{
			for(int v=0; v<9 && legal.size()!=1; v++)
			{
				if(legal.contains(grd[ro][v]))
					legal.remove(grd[ro][v]);
				if(legal.contains(grd[v][co]))
					legal.remove(grd[v][co]);
			}
			if(legal.size()>1)
			{
				int blx=3*(co/3);
				int bly=3*(ro/3);
				for(int q=bly; q<bly+3; q++)
				{
					for(int r=blx; r<blx+3; r++)
					{
						if(legal.contains(grd[q][r]))
							legal.remove(grd[q][r]);
					}
				}
			}
		}
		return legal.get(0);
	}

	public static void main(String[] args)throws Exception
	{
		template a=new template();
		a.run();
	}
}

