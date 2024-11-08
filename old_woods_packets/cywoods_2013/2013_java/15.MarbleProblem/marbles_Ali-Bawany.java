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

public class marbles {

    public void run()throws Exception{
    	Scanner file = new Scanner(new File("bag.dat"));
    	int total=0;
    	String[] colors=new String[4];
    	int[] nums=new int[4];
    	for(int i=0;i<4;i++)
    	{
    		colors[i]=file.next();
    		int n=file.nextInt();
    		nums[i]=n;
    		total+=n;
    	}
    	int times = file.nextInt();
    	file.nextLine();
    	for(int donotuse = 0;donotuse<times;donotuse++){
    	
    	    String x=file.next();
    	    for(int i=0;i<colors.length;i++)
    	    {
    	    	if(colors[i].equals(x))
    	    	{
    	    		System.out.println(nums[i]+"/"+total);
    	    		nums[i]=(nums[i]-1);
    	    		total--;
    	    	}
    	    }
    		

    	}


    }

    public static void main(String[] args)throws Exception {
    	new marbles().run();
    }
}
