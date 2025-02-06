import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.HashMap;

public class Melanie
{
    public static long factorial(long l)
    {
        long fact = 1;
        for (int i = 2; i <= l; i++)
        {
            fact *= i;
        }
        return fact;
    }
	public static void main(String args[]) throws FileNotFoundException
	{
        Scanner s;
		if(args.length==0)
            s = new Scanner(new File("melanie.dat"));
        else
            s = new Scanner(new File(args[0]));

        int numCases=s.nextInt();
        s.nextLine();
        for(int caseNum=0;caseNum<numCases;caseNum++)
        {
            String line=s.nextLine();

            HashMap<Character, Integer> hmap = new HashMap<Character, Integer>();
            for(int a=0;a<line.length();a++)
            {
                char key=line.charAt(a);
                if(hmap.containsKey(key))
                    hmap.put(key, hmap.get(key) + 1);
                else
                    hmap.put(key,1);
            }

            long fact = factorial(line.length());

            long product=1;
            for (HashMap.Entry<Character,Integer> entry : hmap.entrySet()) 
            { 
                product*=factorial(entry.getValue());
            }
            
            System.out.println(fact/product);
        }
            
        s.close();
    }
}