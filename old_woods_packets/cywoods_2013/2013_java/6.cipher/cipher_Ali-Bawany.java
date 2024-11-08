import java.io.*;
import java.util.*;
import java.text.*;
import java.awt.*;
import java.math.*;
import java.util.regex.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Character.*;
import static java.util.Collections.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;

public class cipher {

    public void run()throws Exception{
    	Scanner file = new Scanner(new File("cipher.dat"));
    	char [] alphabet ="bcdefghijklmnopqstuvxyz".toCharArray();
    	int times = file.nextInt();
    	file.nextLine();
    	for(int donotuse = 0;donotuse<times;donotuse++){
    		String temps=file.nextLine();
    		String news="";
    	 	for(int i=0;i<temps.length();i++)
    		{
    			if(temps.charAt(i)=='w'||temps.charAt(i)=='r'||temps.charAt(i)=='a')
    			{
    				news+=(""+temps.charAt(i));
    			}
    			else{
    			
    			if(temps.charAt(i)!=' ')
    			{
    				if(temps.charAt(i)=='b')
    				{
    					news+="z";
    				}
    				else
    				{
    					int spot=0;
    					for(int j=0;j<alphabet.length;j++)
    					{
    						if(alphabet[j]==temps.charAt(i))
    						{
    							spot=j;
    						}
    					}
    					
    					news+=(""+alphabet[spot-1]);
    				}
    				
    					
    			}
    			else
    			{
    				news+=" ";
    			}
    			}
    		}
    			System.out.println(news);

    	}
    


    }

    public static void main(String[] args)throws Exception {
    	new cipher().run();
    }
}
