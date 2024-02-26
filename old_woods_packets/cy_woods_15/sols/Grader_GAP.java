import java.util.*;
import java.io.*;

public class Grader_GAP {

    public static void main(String[] args) throws Exception
    {
        Scanner file = new Scanner(new File("grader.dat"));
        int t = file.nextInt();
        file.nextLine();
        for(int i = 0; i < t; i++)
        {
        	Map<String,Integer> m;
        	m = new TreeMap<String,Integer>();
        	String n = file.next();
        	int x = file.nextInt();
        	m.put(n,x);
        	String name = "";
        	String grade = "";
        	for(Map.Entry<String,Integer> entry : m.entrySet())
        	{
        		name = entry.getKey();
        		if(entry.getValue() >= 89.5)
        		{
        			grade  = "A";
        		}
        		if(entry.getValue() < 89.5 && entry.getValue() >= 79.45)
        		{
        			grade = "B";
        		}
        		if(entry.getValue() < 79.45 && entry.getValue() >= 69.45)
        		{
        			grade = "C";
        		}
        		if(entry.getValue() < 69.44)
        		{
        			grade = "F";
        		}
        	}
        	System.out.println( grade + " " + name);
        }
           
    }
}
