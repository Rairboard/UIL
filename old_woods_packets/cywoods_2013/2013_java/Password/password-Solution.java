import java.util.*;
import java.io.*;

public class password 
{

    public password() throws Exception
    {
    	Scanner k = new Scanner(new File("password-judge.dat"));
    	int toCheck = k.nextInt();
    	for(int i = 0; i < toCheck; i++)
    	{
    		String start = k.next();
    		String toSplit = start.substring(0,start.length()/2);
    		String secHalf = start.substring(start.length()/2);
    		String[] first = toSplit.split("");
    		String[] second = secHalf.split("");
    		String toPrint = "";
    		for(int j = 0; j < second.length; j++)
    		{
    			if ( j < first.length)
    				toPrint = toPrint + second[j] + first[j];
    			else
    				toPrint = toPrint + second[j];
    		}
    		System.out.println(toPrint);
    	}
    }
    
        public static void main(String[] args) throws Exception {
        password test = new password();
    }
}