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


class Alphabet
{

	public void run()throws Exception
	{
		Scanner kb =new Scanner(new File("alpha.dat"));
		int runs = kb.nextInt();
		kb.nextLine();
		for(int n=0; n<runs; n++)
    	{
    		char a= kb.next().charAt(0);
    		char b= kb.next().charAt(0);
    		
    		int x=a-64;
    		int y=b-64;
    		
    		for(int r=26; r>0; r--)
    		{
    			for(int c=0; c<26-r; c++){
    				System.out.print(" ");
    			}
    			if(r>=x && r<=y){
    				System.out.println(b);
    				b--;
    			}
    			else
    				System.out.println("#");
    		}
    	}
	}

	public static void main(String[] args)throws Exception
	{
		Alphabet a=new Alphabet();
		a.run();
	}
}