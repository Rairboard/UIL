/*
 *UIL Computer Science 2020
 *Invitational B Packet Solution
 */
public class Aran
{
	public static void main(String args[])
	{
		for(int x=1;x<=26;x++)
		{
			char cap='A';
			char low='a';
			System.out.print("Day "+x+": ");
			for(int y=0;y<x;y++)
			{
				System.out.print(cap);
				System.out.print(low);
				cap++;
				low++;
			}
			System.out.println();
		}
	}
}