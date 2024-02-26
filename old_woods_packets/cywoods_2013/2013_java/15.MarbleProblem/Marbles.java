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


class marbles
{
	Map<String,Integer> m;

	public void run()throws Exception
	{
		Scanner file=new Scanner(new File("bagJudge.dat"));
		Scanner chop = new Scanner("");

    	int temp = 0;
    	int red = 0;
    	int blue = 0;
    	int green = 0;
    	int yellow = 0;
    	int total  = 0;
    	int numTimes =0;
    	int cnt = 0;
    	String line = ""; 
    	m = new TreeMap<String,Integer>();
    	
    	
		red = file.nextInt();
		m.put("Red", red);
		blue = file.nextInt();
		m.put("Blue", blue);
		green = file.nextInt();
		m.put("Green", green);
		yellow = file.nextInt();
		m.put("Yellow", yellow);
		total = red + blue + green + yellow;
		
		numTimes = file.nextInt();
    	
 		for(int x = 0; x < numTimes; x++)
    	{
			line = file.next();	
			cnt = m.get(line);
			System.out.println(cnt + "/" +total);
			cnt--;
			m.put(line, cnt);
			total--;	
    	}
	}	

	public static void main(String[] args)throws Exception
	{
		marbles a = new marbles();
		a.run();
	}
}