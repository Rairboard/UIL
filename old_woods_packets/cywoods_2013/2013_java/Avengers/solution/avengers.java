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

public class avengers {

    public void run()throws Exception{
    	
    	String []letters="ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");
    	String []m=".-  -...  -.-.  -..  .  ..-.  --.  ....  ..  .---  -.-  .-..  --  -.  ---  .--.  --.-  .-.  ...  -  ..-  ...-  .--  -..-  -.--  --..".split("  ");
    	ArrayList<String> morse=new ArrayList<String>();
    	
    	for(int i=0;i<m.length;i++)
    	{
    		morse.add(m[i]);
    	}
    	Scanner file = new Scanner(new File("avengers.dat"));
    	int times = file.nextInt();
    	file.nextLine();
    	for(int donotuse = 0;donotuse<times;donotuse++){
    		String output="";
    		String input=file.nextLine();
    		String[]words =input.split(",");
    		for(int i=0;i<words.length;i++)
    		{
    			String[]letter =words[i].split(" ");
    			for(int j=0;j<letter.length;j++)
    			{
                     
    				 int x=morse.indexOf(letter[j])+1;

    				 if(x>=0)
    				 {

                     output+=letters[x];
    				 }
    				 output+="";
    			}
    			output+=" ";
    		}
    		System.out.println(output);
    	    System.out.println();



    	}


    }

    public static void main(String[] args)throws Exception {
    	new avengers().run();
    }
}
