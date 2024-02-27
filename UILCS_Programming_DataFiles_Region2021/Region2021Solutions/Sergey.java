/*
 *UIL Computer Science 2020
 *Region Packet Solution
 */
import java.util.*;
import java.io.*;
import static java.lang.System.out;
public class Sergey {
	public static int s;
	public static int d;

	public static void main(String[] args) throws IOException{
		Scanner f = new Scanner(new File("sergey.dat"));
		int n = f.nextInt();
		for(int x = 1; x <= n; x++)
		{
			
			s = f.nextInt();
			d = (f.nextInt() % 360) / 90;
			char[][] pic = new char[s][s];
			f.nextLine();
			for(int y = 0; y < s; y++)
				pic[y] = f.nextLine().toCharArray();
			for(int num_rotations = 1; num_rotations <= d; num_rotations++)
				rotate(pic);			
			for(char[] ch:pic)
			{
				String temp = "";
				for(char c:ch)
					temp+=c;
				out.println(temp);
			}
			out.println("DONE");
		}
		f.close();

	}
	
	public static void rotate(char[][] pic)
	{
		
		for(int level = 0; level < s /2; level++)
		{
			int first = level;
			int last = s - 1 - level;
			for(int i = first; i < last; i++)
			{
				int shift = i - first;
				char c = pic[first][i];
				pic[first][i] = pic[last - shift][first];
				pic[last - shift][first] = pic[last][last - shift];
				pic[last][last - shift] = pic[i][last];
				pic[i][last] = c;
			}
		}
	}

}
