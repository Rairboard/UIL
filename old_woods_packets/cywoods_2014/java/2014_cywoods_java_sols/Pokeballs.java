import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

			//change the class name
public class Pokeballs
{
	public int u;
	public int s;
	public int r;
	public String[] p;
	
	public void run() throws Exception
	{
		Scanner file = new Scanner(new File("pokeballs.dat"));
		
			//read in the number at the top of the data file
		int times = file.nextInt(); 
			//pick up the left over enter key
		file.nextLine();
		
			//read in each data set
		for(int asdf = 0; asdf<times; asdf++)
		{
			u = file.nextInt();
			s = file.nextInt();
			r = file.nextInt();
			file.nextLine();
			p = file.nextLine().split(" ");
			String out="";
			for( String t : p)
			{
				if( t.equals("Cool"))
				{
					if(u>0)
					{
						out+="Ultra ";
						u--;
					}
					else{
						out+="It Got Away! ";
					}
				}
				if( t.equals("Meh"))
				{
					if(s>0)
					{
						out+="Super ";
						s--;
					}
					else if(u>0){
						out+="Ultra ";
						u--;
					}
					else{
						out+="It Got Away! ";
					}
				}
				if( t.equals("Bleh"))
				{
					if(r>0)
					{
						out+="Regular ";
						r--;
					}
					else if(s>0)
					{
						out+="Super ";
						s--;
					}
					else if(u>0){
						out+="Ultra ";
						u--;
					}
					else{
						out+="It Got Away! ";
					}
				}
			}
			System.out.println(out.trim());
		}
	}

	public static void main(String[] args) throws Exception
	{
			//change this to whatever your class name is
		new Pokeballs().run();
	}	
	
}