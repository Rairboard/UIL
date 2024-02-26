import java.util.*;
import java.io.*;

public class Pyramid_GAP {
        
  
    public static void main(String[] args) throws Exception
    {
        Scanner file = new Scanner(new File("pyramid.dat"));
        int t = file.nextInt();
        file.nextLine();
        for(int i = 0; i < t; i++)
        {
        	int n = file.nextInt();
        	int num = n;
        	for(int y  = 0; y < n; y++)
        	{
        		for(int x = 0; x < num; x++)
        		{
        			System.out.print(num);
        		}
        		num -= 1;
        		System.out.println();
        	}
        
        }
    }
}
