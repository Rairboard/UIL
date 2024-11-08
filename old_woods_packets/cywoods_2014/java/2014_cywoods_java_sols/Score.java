
import java.util.*;
import java.text.*;
import java.io.*;
import java.math.*;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Character.*;
import static java.util.Collections.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author s690574
 */
public class Score {
	int f;
	int s;
	int t;
	int L;
	ArrayList arr;

    public static void main(String[] args) throws Exception {
        new Score().run();
    }

    public void run() throws Exception {
        try {
            Scanner kb = new Scanner(new File("score.dat"));
            int sets = kb.nextInt();
            kb.nextLine();
            int f = Integer.MIN_VALUE;
			int s = Integer.MIN_VALUE;
			int t = Integer.MIN_VALUE;
			int L = Integer.MAX_VALUE;
			ArrayList<Integer> arr = new ArrayList<Integer>();
            for (int set = 0; set < sets; set++)
            {
            	arr.add(kb.nextInt()); 
            }
            for(int a: arr)
            {
            	if(a < L)
            	{
            		L = a;
            	}
            	if(a > f)
            	{
            		f = a;
            	}
            }
            for(int a: arr)
            {
            	if(a > s && a < f)
            	{
            		s = a;
            	}
            }
            for(int a: arr)
            {
            	if(a > t && a < s)
            	{
            		t = a;
            	}
            }
			
            System.out.println("FIRST PLACE: " + f);
            System.out.println("SECOND PLACE: " + s);
            System.out.println("THIRD PLACE: " + t);
            System.out.println("LAST PLACE: " + L);
        } 
        	catch (Exception e) {
            System.out.println("???");
            e.printStackTrace();
            throw e;
        }
    }
}

