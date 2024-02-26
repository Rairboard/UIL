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


public class cipher {        
    public void run()throws Exception {
    	Scanner file = new Scanner(new File("cipher.dat"));
    	int len = file.nextInt();
    	file.nextLine();
    	for(int i = 0; i <len;i++)
    	{
    		String l = "bcdefghijklmnopqstuvxyz";
    		String w = file.nextLine();
    		String s ="";
    		for(int a = 0; a<w.length();a++)
    		{
    		//	out.println(s);
    			if(!(w.charAt(a) == 'w' || w.charAt(a) == 'a' || w.charAt(a) == 'r' || w.charAt(a)== ' '))
    			{
    				if(l.indexOf(w.charAt(a)) == 0)
    					s+=l.charAt(l.length()-1);
    				else s+=l.charAt(l.indexOf("" + w.charAt(a))-1);
    			}
    			else s+=w.charAt(a);
    				
    		}
    		out.println(s);
    	}
    }
    
    public static void main(String[] args)throws Exception {
        cipher a = new cipher();
        a.run();
    }
}
