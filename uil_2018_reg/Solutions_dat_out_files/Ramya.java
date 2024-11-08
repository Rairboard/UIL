//UIL 2018 - Region - Ramya
import java.io.*;
import java.util.*;

/*
 * Java program to print all permutations of a given string.
 * This code adapted from a program contributed by Mihir Joshi
 * https://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/
*/

public class Ramya
{
	int num = 1;
	Set<String> list = new HashSet<String>();
    public static void main(String[] args) throws IOException
    {
        Scanner f = new Scanner(new File("ramya.dat"));
        int N = 0;
        while(f.hasNext())
        {
        	String str = f.next();
	        int n = str.length();
	        Ramya permutation = new Ramya();
	        permutation.permute(str, 0, n-1);
	        System.out.println("=====");
	        N++;
        }
    }
 
    /**
     * permutation function
     * @param str string to calculate permutation for
     * @param l starting index
     * @param r end index
     */
    private void permute(String str, int l, int r)
    {
        if (l == r)
        {
           if(!list.contains(str))
           {
                list.add(str);
                if(num<=30)
                {
                	num++;
                	System.out.println(str);
                }
           }
        }
        else
        {
            for (int i = l; i <= r; i++)
            {
                str = swap(str,l,i);
                permute(str, l+1, r);
                str = swap(str,l,i);
            }
        }
    }
    /**
     * Swap Characters at position
     * @param a string value
     * @param i position 1
     * @param j position 2
     * @return swapped string
     */
    public String swap(String a, int i, int j)
    {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
}