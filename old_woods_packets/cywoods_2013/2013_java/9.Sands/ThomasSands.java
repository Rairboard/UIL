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


class Sands
{
	//instance variables go here

	public void run()throws Exception
	{
		Scanner file=new Scanner(new File("sandsJ.dat"));
		int cases = file.nextInt();file.nextLine();
		for(int xx = 0; xx<cases; xx++){
			int d = file.nextInt(), r = file.nextInt(), c = file.nextInt();
			file.nextLine();
			char[][][] mat = new char[d][r][c];
			ArrayList<int[]> start = new ArrayList<int[]>();
			for(int dd = 0; dd < d; dd++){
				for(int rr = 0; rr < r; rr++){
					String line = file.nextLine();
					int off = 0;
					while(line.indexOf("o",off)!=-1){
						int cc = line.indexOf("o",off);
						start.add(new int[]{1,rr,cc});
						off = cc+1;
					}
					mat[dd][rr] = line.toCharArray();
				}
			}
			Queue<double[]> que = new LinkedList<double[]>();
			double holes = start.size();
			while(!start.isEmpty()){
				int[] temp = start.remove(0);
				que.add(new double[]{1,temp[1],temp[2],10000/holes});
			}
			int[][] dir = {{-1,-1,-1,0,0,1,1,1},{-1,0,1,-1,1,-1,0,1}};
			double totalSand = 0;
			while(!que.isEmpty()){
				double[] temp = que.remove();
				int dd = (int)temp[0], rr = (int)temp[1], cc = (int)temp[2]; double sand = temp[3];
				if(!inBounds(rr,cc,r,c))continue;
				if(dd>=d-1){
					if(dd==d-1){
						if(mat[dd][rr][cc]!='#')totalSand+=sand;
						continue;
					}
					totalSand+=sand;
					continue;
				}
				if(mat[dd][rr][cc]=='#')continue;
				if(mat[dd][rr][cc]=='^'){
					for(int x = 0; x<dir[0].length; x++){
						int rrr = rr+dir[0][x], ccc = cc+dir[1][x];
						que.add(new double[]{dd+1,rrr,ccc,sand/8.0});
					}
					continue;
				}
				que.add(new double[]{dd+1, rr, cc, sand});
			}
			System.out.printf("%.2f%s made it to the floor and %.2f%s was trapped\n",totalSand/100.0,"%",100.0-totalSand/100.0,"%");
		}
	}
	public boolean inBounds(int x, int y, int r, int c){
		return x>-1&&y>-1&&x<r&&y<c;
	}
	public static void main(String[] args)throws Exception
	{
		Sands a=new Sands();
		a.run();
	}
}