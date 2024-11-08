/*
 *UIL Computer Science 2020
 *Invitational B Packet Alternate Solution
 */

import static java.lang.System.*;
public class AranAlt
{
	public static void main(String args[])
	{
		for(int a  = 1;a <= 26; a++)
		{
			out.printf("Day %d: ",a);
			for(int A = 1; A <= a; A++)
				out.print(""+((char)(A+64))+((char)(A+96)));
			out.println();
		}
	}
}