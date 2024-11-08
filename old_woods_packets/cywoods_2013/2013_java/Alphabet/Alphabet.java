import java.util.*;
import java.io.*;

public class Alphabet {
        
    
    public Alphabet() {
    }
    
    public void run()throws Exception{
    	Scanner file= new Scanner(new File("alpha.dat"));
    	int times=file.nextInt();
    	file.nextLine();
    	
    	for(int n=0; n<times; n++)
    	{
    		char first= file.next().charAt(0);
    		char last= file.next().charAt(0);
    		
    		int x=first-64;
    		int y=last-64;
    		
    		for(int r=26; r>0; r--)
    		{
    			for(int c=0; c<26-r; c++){
    				System.out.print(" ");
    			}
    			if(r>=x && r<=y){
    				System.out.println(last);
    				last--;
    			}
    			else
    				System.out.println("#");
    		}
    	}
    }
    
    
    
    public static void main(String[] args)throws Exception {
        Alphabet a=new Alphabet();
        a.run();
    }
}
