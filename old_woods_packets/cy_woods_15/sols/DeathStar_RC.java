import java.io.*;
import java.util.*;

public class DeathStar_RC {
        
 
    public void run() throws Exception
    {
    	Scanner file = new Scanner(new File("planetData.dat"));
    	int times = file.nextInt();
    	
    	for(int i = 0; i < times; i++)
    	{
    		if(file.next().equals("Empire"))
    		{
    			System.out.println("False");
    		}else{
    			System.out.println("True");
    		}
    	}
    }
    
    
    public static void main(String[] args) throws Exception
    { 
    	DeathStar_RC chad = new DeathStar_RC();
    	chad.run();
    }
}
