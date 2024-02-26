import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.HashMap;

public class Megan
{
	public static boolean isSorted(String order,String[] words)
	{
		HashMap<Character, Integer> hmap = new HashMap<Character, Integer>();
		for(int a=0;a<order.length();a++)
		{
			hmap.put(order.charAt(a),a);
		}

		for(int a=0;a<words.length-1;a++)
		{
			String word1=words[a];
			String word2=words[a+1];
			boolean didBreak=false;

			for(int b=0;b<Math.min(word1.length(),word2.length());b++)
			{
				if(word1.charAt(b)!=word2.charAt(b))
				{
					if(hmap.get(word1.charAt(b))>hmap.get(word2.charAt(b)))
						return false;
					didBreak=true;
					break;
				}
			}
			if(!didBreak)
			{
				if(word1.length()>word2.length())
					return false;
			}
		}
		return true;
	}

	public static void main(String args[]) throws FileNotFoundException
	{
		Scanner s;
		if(args.length==0)
           s = new Scanner(new File("megan.dat"));
        else
            s = new Scanner(new File(args[0]));

        int alphabets=s.nextInt();
        s.nextLine();
        for(int a=0;a<alphabets;a++)
        {
			String order=s.nextLine();
			String line=s.nextLine();
			if(s.hasNextLine())
				s.nextLine();
			String words[]=line.split(",");

			System.out.println("Word List " + (a+1) + " is " + ((isSorted(order,words)) ? "sorted." : "not sorted."));
		}
	}
}
