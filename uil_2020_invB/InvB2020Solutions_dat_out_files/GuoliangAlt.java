/*
 *UIL Computer Science 2020
 *Invitational B Packet - Alternate Solution
 */
import java.util.*;
import java.io.*;
import static java.lang.System.*;
class GuoliangAlt
{
	public static void main(String [] args) throws IOException
	{
		Scanner f = new Scanner(new File("guoliang.dat"));
		while (f.hasNext())
		{
			String s = f.next();
			if(isIso(s))
				out.println(s);
		}
		f.close();
	}
	static boolean isIso(String s)
	{
		int[]flag = new int[26];
		for(int i=0;i<s.length();i++)
		{
			int p = s.charAt(i)-97;
			if(flag[p]==1)
				return false;
			flag[p]=1;
		}
		return true;
	}
}