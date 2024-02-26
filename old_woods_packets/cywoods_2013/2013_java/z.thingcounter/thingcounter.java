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


class thingcounter
{
	//instance variables go here
	int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
	public void run()throws Exception
	{
		Scanner file=new Scanner(new File("thingcounter.dat"));
		int cases = file.nextInt();file.nextLine();
		for(int xx = 0; xx<cases; xx++){
			int r = file.nextInt(), c = file.nextInt();file.nextLine();
			char[][] mat= new char[r][];
			for(int y = 0; y<r; y++){
				mat[y] = file.nextLine().toCharArray();
			}
			int points = file.nextInt();file.nextLine();
			for(int x = 0; x<points; x++){
				int rr = file.nextInt(), cc = file.nextInt();
				System.out.println(recur(rr,cc,mat[rr][cc],mat,new boolean[r][c])+" "+mat[rr][cc]);
				if(file.hasNext())file.nextLine();
			}
			System.out.println();
		}
	}
	public int recur(int r, int c,char start, char[][] mat, boolean[][] vis){
		if(r<0||c<0||r>=mat.length||c>=mat[0].length||mat[r][c]!=start||vis[r][c])return 0;
		vis[r][c] = true;
		int cnt = 1;
		for(int x = 0;x<4; x++){
			cnt+=recur(r+dir[x][0],c+dir[x][1],start,mat,vis);
		}
		return cnt;
	}
	public static void main(String[] args)throws Exception
	{
		thingcounter a=new thingcounter();
		a.run();
	}
}