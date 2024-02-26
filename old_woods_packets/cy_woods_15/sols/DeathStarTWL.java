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


class DeathStar
{
	//instance variables go here
	
	public void run()throws Exception
	{
		Scanner file = new Scanner(new File("DeathStar.dat"));
		
		int times = file.nextInt();
		
		file.nextLine();
		
		for(int asdf = 0; asdf < times; asdf++)
		{
			System.out.println(file.nextLine().equals("Rebellion"));
		}
		

	}
	


	public static void main(String[] args)throws Exception
	{
		DeathStar a=new DeathStar();
		a.run();
	}
}