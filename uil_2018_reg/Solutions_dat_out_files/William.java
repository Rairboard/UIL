//2018 UIL Region - William - Longest Common Subsequence
import java.io.*;
import java.util.*;
import static java.lang.System.*;
import static java.lang.Math.*;
class William
{
	public static void main(String [] args) throws IOException
	{
		Scanner f = new Scanner(new File("william.dat"));
		while(f.hasNext()){
			String s = f.nextLine();
			int len = s.length();
			String A = s.substring(0,len/2);
			String B = new String(new StringBuilder(s.substring(len/2)).reverse());
			int m = A.length();
			int n = B.length();
			int[][]g = new int[m+1][n+1];

			for(int r=0;r<=m;r++){
				for(int c=0;c<=n;c++)
				{
					if(r==0||c==0)
						g[r][c]=0;
					else
					if(A.charAt(r-1)==B.charAt(c-1))
						g[r][c]=g[r-1][c-1]+1;
					else
						g[r][c]=max(g[r][c-1],g[r-1][c]);
				}
			}
			//build longest common subsequence string
			s = "";
			int r=m,c=n;
			while(r>0&&c>0){
				if(A.charAt(r-1)==B.charAt(c-1))//letters match
				{
					s=""+A.charAt(r-1)+s;
					r--;c--;//move up and left, diagonally
				}
				else
				if(g[r-1][c]>g[r][c-1])//upper cell value greater
					r--;//move up a row
				else
					c--;//move left a column
			}
			out.println(s+":"+new StringBuilder(s).reverse());
		}
	}
}
