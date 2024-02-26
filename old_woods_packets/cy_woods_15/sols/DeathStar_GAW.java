import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

public class DeathStar
{
	private String tmp;
	public void run() throws Exception
	{
		Scanner file = new Scanner(new File("DeathStar.dat"));
		
		int times = file.nextInt();
		file.nextLine();
		
		for(int i = 0; i<times; i++)
		{
			tmp = file.next();
			if(tmp.equals("Rebellion")){
				System.out.println("True");
			}
			else{
				System.out.println("False");
			}
		}
	}

	public static void main(String[] args) throws Exception
	{
		new DeathStar().run();
	}	
	
}