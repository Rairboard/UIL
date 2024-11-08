/*
 *UIL Computer Science 2020
 *Invitational B Packet - Alternate Solution
 */
import java.util.*;
import java.io.*;
import static java.lang.System.*;
class NitinAlt
{
	public static void main(String [] args) throws IOException
	{
		Scanner f = new Scanner(new File("nitin.dat"));
		int N = f.nextInt();
		f.nextLine();
		ArrayList<String> pets = new ArrayList<String>();
		while(N-->0)
		{
			String s = f.nextLine();
			int end = s.length();
			s = s.substring(end-1)+s.substring(0,end-2);
			pets.add(s);
		}
		N = f.nextInt();
		f.nextLine();
		while(N-->0)
		{
			String s = f.nextLine();
			int end = s.length();
			s = s.substring(end-1)+s.substring(0,end-2);
			char p = s.charAt(0);
			int x = 0;
			while(x<pets.size() && pets.get(x).charAt(0)!=p)
				x++;
			if(x<pets.size())
			{
				String pet = pets.get(x);
				pets.remove(x);
				out.println(s.substring(1)+" "+petType(s.charAt(0))+" "+pet.substring(1));
			}
			else
				out.println(s.substring(1)+" WAIT LIST "+petType(s.charAt(0)));
		}
		f.close();
	}
	static String petType(char a)
	{
		return a=='C'?"CAT":"DOG";
	}
}