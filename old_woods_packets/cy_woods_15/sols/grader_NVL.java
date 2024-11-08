import java.io.*;
import java.util.*;

public class grader_NVL {
        
    /**
     * Creates a new instance of <code>grader_nl</code>.
     */
    public grader_NVL() {
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        Scanner file = new Scanner(new File("grader.dat"));
        int times = file.nextInt();
        file.nextLine();
        Map<String,Integer> m;
        m = new TreeMap<String,Integer>();
        
        for(int i = 0; i < times; i++)
        {
        	
        	m = new TreeMap<String,Integer>();
        	String s = file.next();
        	int x = file.nextInt();
        	m.put(s,x);
        
        	
        
	        for(String word : m.keySet())
	        {
	        	String grade = "";
	        	int g = m.get(word);
	        	if(g >= 89.5)
	        	{
	        		grade = "A";
	        	}
	        	if(g < 89.5 && g >= 79.5)
	        	{
	        		grade = "B";
	        	}
				if(g < 79.5 && g >= 69.5)
	        	{
	        		grade = "C";
	        	}
	        	if(g < 69.5)
	        	{
	        		grade = "F";
	        	}
	        	System.out.println(grade + " " + word);
	        }
    	}
    }
}
