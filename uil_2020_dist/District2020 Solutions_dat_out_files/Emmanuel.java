/*
 *UIL Computer Science 2020
 *District Packet Solution
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;
public class Emmanuel
{
	public static void main(String args[]) throws FileNotFoundException
	{
		
		Scanner s = new Scanner(new File("emmanuel.dat"));
        
        int N = s.nextInt();
       	s.nextLine();
        for ( int n = 0; n < N; n++ )
        {
            String line=s.nextLine();
            line=line.substring(1,line.length()-1);
            String[] setString = line.split(",");
            int[] setInt=new int[setString.length];
            int[] count=new int[101];
            for(int a=0;a<setString.length;a++)
            {
                setInt[a]=Integer.parseInt(setString[a]);
                //count how many times each number has occured
                count[setInt[a]]=count[setInt[a]]+1;
            }
            
            //find the index of the highest count, this is the mode
            int maxCount=-1;
            int maxCountIndex=-1;
            for(int a=0;a<count.length;a++)
            {
                if(count[a]>maxCount)
                {
                    maxCountIndex=a;
                    maxCount=count[a];
                }
            }
            
            System.out.println(maxCountIndex+ " appeared "+maxCount +" time(s)");

        }
        s.close();
        
	}
}