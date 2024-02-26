import java.util.*;
import java.io.*;

public class Ready {
        

    public Ready() throws Exception
    {
    	Scanner file = new Scanner(new File("judgesReady.dat"));
    	
    	int times = file.nextInt();
    	
    	file.nextLine();
    	
    	for(int asdf = 0; asdf < times; asdf++)
    	{
    		int a = file.nextInt();
    		Map<String,Integer> m = new TreeMap<>();
    		for(int q = 0; q < a; q++)
    		{
    			String s = file.next();
    			int f = (int)(file.nextDouble() * 60);
    			m.put(s,f);
    		}
    		int c = (int)(file.nextDouble() * 60);
    		file.nextLine();
    		int minutes = 0;
    		boolean alive = true;
    		while(minutes <= 360 && alive)
    		{
    			for (Map.Entry<String, Integer> entry : m.entrySet())
    			{
    				if(minutes % entry.getValue() == 0 && minutes % c != 0)
    				{
    					alive = false;
    					String min = "";
    					if(minutes % 60 < 10)
    					{
    						min += "0";
    					}
   						System.out.println(entry.getKey() + " " + ((minutes / 60 == 0)? "12" + ":" + min + minutes % 60 + " A.M.": minutes / 60 + ":" + min + minutes % 60 + " A.M."));
    					break;
    				}
    			}
    			minutes ++;
    		}
    		if(alive)
    		{
    			System.out.println("6:00 A.M. Yay!");
    		}	
    	}
    }
    

    public static void main(String[] args) throws Exception
    {
        Ready run = new Ready();
    }
}
