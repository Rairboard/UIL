import java.io.*;
import java.util.*;

public class Three_RC {
        
  
    public void run() throws Exception
    {
    	Scanner file = new Scanner(new File("three.dat"));
    	int times = file.nextInt();
    	
    	for(int i = 0; i < 0; i++)
    	{
    		int max = 0;
    		int ans = 0;
    		String ss = file.nextLine();
    		Scanner s = new Scanner(ss);
    		while(s.hasNextInt())
    		{
    			if(s.nextInt() > max)
    			{
    				max = s.nextInt();
    			}
    		}
    		if(max % 2 == 0)
    		{
    			ans = max / 2;
    		}else{
    			ans = (max * 3) + 1;
    		}
    		System.out.println(ans);
    	}
    	
    }
   

    public static void main(String[] args) throws Exception
    {
    	Three_RC chad = new Three_RC();
    	chad.run();
    }
}
