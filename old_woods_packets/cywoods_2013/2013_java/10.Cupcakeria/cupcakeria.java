/**
 * @(#)cupcakeria.java
 *
 *
 * @Daniela Liguori
 * @version 1.00 2013/8/26
 */
 
import java.util.*;
import java.io.*;
import java.text.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Character.*;
import static java.lang.Math.*;
import static java.util.Collections.*;
import static java.util.Arrays.*;

public class cupcakeria 
{
	private TreeMap<String,Double> menu;
	
	public void run()throws Exception
	{
		Scanner file = new Scanner(new File("cupcakeria_s.dat"));		
		int customers = file.nextInt();
		file.nextLine();
		
		for(int o = 0; o<customers; o++)
		{
			file.next();
			file.next();
			int cups = file.nextInt(); 
			file.nextLine();
			double cost = 1.50 * cups;	
			System.out.println("$" + cost + "0");
		}		
	}
 
    public static void main(String[] args) throws Exception
    {
 		cupcakeria a = new cupcakeria();
 		a.run();
    }
}
