import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

			//change the class name
public class Cypher_MEA
{
	private String[][] thing;
	public void run() throws Exception
	{
		Scanner file = new Scanner(new File("cypher.dat"));
		
			//read in the number at the top of the data file
		
			//pick up the left over enter key
		//file.nextLine();
	    thing= new String[27][27];
		for(int x=0;x<27;x++){
			thing[x]=file.nextLine().split(" ");
		}
/*		for(int r=0;r<27;r++){
		for(int c=0;c<27;c++)
		System.out.print(thing[r][c]);
		System.out.println();
		}*/
		int times = file.nextInt(); 
			//read in each data set
		for(int asdf = 0; asdf<times; asdf++)
		{
			String c=file.next();
				String k=file.next();
				String f="";		
				int l=0;
				while(c.length()!=k.length()){
					if(c.length()>k.length()){
						k+=k.substring(l,l+1);
					}
					else{
						k=k.substring(0,k.length()-1);
					}
					l++;
				}
				for(int x=0;x<k.length();x++){
					f+=thing[0][lettf(c.substring(x,x+1),keyf(k.substring(x,x+1)))];
				}
				System.out.println(""+f);
			
		}
	}
	public int keyf(String in){
		for(int x=1;x<27;x++)
			if(thing[x][0].equals(in))
				return x;
		return 0;
	}
	public int lettf(String in,int i){
		for(int x=1;x<27;x++)
			if(thing[i][x].equals(in))
				return x;
		return 0;
	}

	public static void main(String[] args) throws Exception
	{
			//change this to whatever your class name is
		new Cypher_MEA().run();
	}	
	
}