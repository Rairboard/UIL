/**
 * @(#)Elevator.java
 *
 *
 * @author 
 * @version 1.00 2013/10/21
 */

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


public class Elevator {

	private int CurLevel;
	private LinkedList<Integer> list = new LinkedList<Integer>();
	private LinkedList<Integer> callList = new LinkedList<Integer>();
    public Elevator() 
    {
    	 int CurLevel = 1;
    	 
    }
    private void goTo(int level, int called)
    {
    	System.out.println("The elevator was at " + CurLevel + " and was called to " + called + ", but now it moved to " + level);
    	CurLevel = level;
    }
    private boolean add(int lvl)
    {
    	return list.add(lvl);
    }
    private int getNextLevel()
    {
    	int temp = list.peek();
    	list.poll();
    	return temp;
    }
    private int getNextCallLevel()
    {
    	int temp = callList.peek();
    	callList.poll();
    	return temp;
    }
    public String getList()
    {
    	return Arrays.toString(list.toArray());
    }
    public String getCallList()
    {
    	return Arrays.toString(callList.toArray());
    }
    public int getLevel()
    {
    	return CurLevel;
    }
    
    public static void main(String[] args) throws Exception
    {
        Elevator Awesome = new Elevator();
        Scanner file=new Scanner(new File("Elevator.dat"));
        int temp = file.nextInt();
        for(int i = 0; i < temp ; i++)
        {
        	Awesome.list.add(file.nextInt());
        	
        	Awesome.callList.add(file.nextInt());
        	
        }
        while(Awesome.list.size() != 0)
        {
        	Awesome.goTo(Awesome.getNextLevel(), Awesome.getNextCallLevel());
   
        	
        }
    }
}