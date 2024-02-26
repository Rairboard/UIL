/**
 * @(#)Diamond.java
 *
 *
 * @author 
 * @version 1.00 2015/10/21
 */	
 import java.util.*;
 import java.io.*;

public class Diamond {
        
    /**
     * Creates a new instance of <code>Diamond</code>.
     */
     String[][] diamond;
     
    public Diamond() {
    }
    
    public void run() throws Exception
    {
    	Scanner file = new Scanner(new File("diamond.in"));
    	int times = file.nextInt();
    	for(int asdf = 0; asdf < times; asdf++)
    	{
    		int x = file.nextInt();
	    	diamond = new String[x*2-1][x*2-1];
	    	for(int i = 0; i < diamond.length; i++)
	    		Arrays.fill(diamond[i], " ");
	    	int max = (int)Math.pow(x,x-1);
	    	int maxLength = Integer.toString(max).length();
	    	recur(x, max, x-1, x-1);
	    	for(int r = 0; r < diamond.length; r++)
	    	{
	    		for(int c = 0; c < diamond[r].length; c++)
	    		{
	    			System.out.printf("%-"+maxLength+"s"+" " , diamond[r][c]);
	    		}
	    		System.out.println();
	    	}
    	}
    	
    }
    
    public void recur(int n, int value, int r, int c)
    {
    	if(value == 0)
    		return;
    	if(r < 0 || r >= diamond.length || c < 0 || c >= diamond[r].length || !diamond[r][c].equals(" ") && Integer.parseInt(diamond[r][c]) > value)
    		return;
    	diamond[r][c] = "" + value;
    	recur(n, value/n, r + 1, c);
    	recur(n, value/n, r - 1, c);
    	recur(n, value/n, r, c + 1);
    	recur(n, value/n, r, c - 1);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        Diamond a = new Diamond();
        a.run();
    }
}
