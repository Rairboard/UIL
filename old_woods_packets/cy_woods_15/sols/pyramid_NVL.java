import java.io.*;
import java.util.*;

public class pyramid_NVL {
        
    /**
     * Creates a new instance of <code>pyramid_nl</code>.
     */
    public pyramid_NVL() {
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        Scanner file = new Scanner(new File("pyramid.dat"));
        int times = file.nextInt();
        file.nextLine();
        for(int i = 0; i < times; i++)
        {
        	int x = file.nextInt();
        	int num = x;
        	for(int y = 0; y < x; y++)
        	{
        		for(int z = 0; z < num; z++)
        		{
        			System.out.print(num);
        		}
        		num = num - 1;
        		System.out.println();
        	}
        	
        	
        }
    }
}
