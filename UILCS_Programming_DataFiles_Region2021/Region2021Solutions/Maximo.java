/*
 *UIL Computer Science 2020
 *Region Packet Solution
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.List;
import java.util.Collections;
public class Maximo
{
	public static boolean inSet(int i,int[] array)
	{
		for(int a=0;a<array.length;a++)
		{
			if(i==array[a])
				return true;
		}
		return false;
	}

	public static ArrayList<Integer> intersection(int[] set1, int[] set2)
	{
		ArrayList<Integer> intersection=new ArrayList<Integer>();
		for(int a=0;a<set1.length;a++)
		{
			if(inSet(set1[a],set2))
				intersection.add(set1[a]);
		}
		Collections.sort(intersection);
		return intersection;
	}

	public static void printResult(int[] set1, int[] set2)
	{
		ArrayList<Integer> intersection=intersection(set1,set2);

		List<Integer> list1=new ArrayList<Integer>(set1.length);
		List<Integer> list2=new ArrayList<Integer>(set2.length);
		for (int i : set1)
		{
		    list1.add(i);
		}

		for (int i : set2)
		{
		    list2.add(i);
		}

		if(intersection.equals(list1)&&intersection.equals(list2))
			System.out.println("Set A is equal to Set B");
		else if(intersection.equals(list1))
			System.out.println("Set A is a subset of Set B");
		else if(intersection.equals(list2))
			System.out.println("Set B is a subset of Set A");
		else
		{
			System.out.print("Neither set is a subset of the other. Their intersection is: ");
			if(intersection.size()==0)
				System.out.println("{}");
			else if(intersection.size()==1)
				System.out.println("{"+intersection.get(0)+"}");
			else
			{
				System.out.print("{"+intersection.get(0));
				for(int a=1;a<intersection.size();a++)
				{
					System.out.print(","+intersection.get(a));
				}
				System.out.println("}");
			}
		}
	}
	public static void main(String args[]) throws FileNotFoundException
	{
		Scanner s = new Scanner(new File("maximo.dat"));
        
        int N = s.nextInt();
        s.nextLine();
        for ( int n = 0; n < N; n++ )
        {
			String lineA=s.nextLine();
			lineA=lineA.substring(3,lineA.length()-1);
			String lineB=s.nextLine();
			lineB=lineB.substring(3,lineB.length()-1);
			
			int setA[]=Arrays.stream(lineA.split(",")).mapToInt(Integer::parseInt).toArray();
			java.util.Arrays.sort(setA);

			int setB[]=Arrays.stream(lineB.split(",")).mapToInt(Integer::parseInt).toArray();
			java.util.Arrays.sort(setB);
			printResult(setA,setB);
			
		}

	}
}