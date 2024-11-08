//UIL State 2018 - Emma - Sample Solution
import static java.lang.System.out;
import java.util.*;
import java.io.*;
public class Emma {

	public static void main(String[] args) throws IOException{
		Scanner f=new Scanner(new File("emma.dat"));
		while(f.hasNext()){
			int n = f.nextInt();
			int n3 = n*3;
			char [][] g = new char[n3][n3];
			for(int r=0;r<n3;r++)
			  for(int c=0;c<n3;c++)
				g[r][c]=' ';
			for(int r=0;r<n;r++)
			  for(int c=0;c<n;c++)
			  {
			   	g[r][c]='*';
			   	g[r+n3*2/3][c+n3*2/3]='*';
			   	g[r+n3*2/3][c]='*';
			   	g[r][c+n3*2/3]='*';
			  }			
			for(int r=n3/2-n/2;r<=n3/2+n/2;r++)
			  for(int c=n3/2-n/2;c<=n3/2+n/2;c++)
				if(r==c){
				  g[r][c]='*';
				  g[r][n3-c-1]='*';
				}
			for(int r=0;r<n3;r++){
			  for(int c=0;c<n3;c++)
			  	out.print(g[r][c]);
			  out.println();
			}
			out.println("==========");
		}
	}
}
