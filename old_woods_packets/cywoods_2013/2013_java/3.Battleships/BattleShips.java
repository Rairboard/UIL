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


class BattleShips
{
       
    char[][]matrix;
    
        
	public void run()throws Exception
	{
		Scanner file=new Scanner(new File("BlackPearl.dat"));
		int game = file.nextInt();
		file.nextLine();
		for(int x = 0; x<game; x++)
		{
			char[][] mat = new char[11][11];
			matrix = new char[10][10];
			for(int r = 0; r<11; r++)
			{
				String s = file.nextLine();
				//System.out.println (s);
				s=s.replaceAll("\\|", "");
				char[] p = s.toCharArray();
				mat[r] = p;
				
			}

			for(int q =0; q<10; q++)
			{
				for(int e = 0; e<10; e++)
				{
					matrix[q][e] = mat[q+1][e+1];
				}
			}
			for(int o = 0; o<10; o++)
			{
			//	System.out.println (matrix[o]);
			}
			int pairs = file.nextInt();
			//System.out.println ("PAIR" + pairs);
			for(int p =0; p<pairs; p++)
			{
				file.nextLine();
				int c = 0;
				String k = file.next();
				//System.out.println (k);
				char q = k.charAt(0);
				//System.out.println ((int)q);
				c+= (q-'A');	
				//System.out.println (c);	
				int r = Integer.parseInt(k.substring(1));
				//System.out.println (r);		
				if(matrix[r][c]=='O')
				{
					System.out.println ("HIT!");
				}
				if(matrix[r][c]!='O')
				{
					//MARKER
					//matrix[r][c] = 'P';
					/*for(int o = 0; o<10; o++)
					{
						System.out.println (matrix[o]);
					}
					System.out.println ("NO?" + matrix[r][c]);*/
					System.out.println ("MISS");
				}			
			}
			file.nextLine();
		}
	}
	
	public static void main(String[] args)throws Exception
	{
		BattleShips a=new BattleShips();
		a.run();
	}
}