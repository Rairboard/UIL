/*
 *UIL Computer Science 2020
 *Region Packet Solution
 */
import static java.lang.System.out;
public class Adela {

	public static void main(String[] args) {
		for(int x = 1; x <= 9; x++)
			{
			for(int y = 1; y <= x; y++)
				out.print("*");
			out.println();
			}
		for(int x = 8; x >= 1; x--)
		{
		for(int y = 1; y <= x; y++)
			out.print("*");
		out.println();
		}
		

	}

}
